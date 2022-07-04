package hu.kristof.nagy.mathapp.view.topics

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import hu.kristof.nagy.mathapp.R
import hu.kristof.nagy.mathapp.data.entity.Topic
import hu.kristof.nagy.mathapp.databinding.FragmentTopicListBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TopicListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTopicListBinding.inflate(inflater, container, false)

        val listViewModel: TopicListViewModel by viewModels()
        val listItemViewModel: TopicListItemViewModel by viewModels()

        initList(listItemViewModel, listViewModel, binding)

        binding.topicCreateBtn.setOnClickListener {
            // TODO: show dialog and ask for name
        }

        return binding.root
    }

    private fun initList(
        listItemViewModel: TopicListItemViewModel,
        listViewModel: TopicListViewModel,
        binding: FragmentTopicListBinding
    ) {
        val adapter = TopicListRecyclerViewAdapter(TopicClickListener(
            editListener = { topic -> listItemViewModel.edit(topic) },
            deleteListener = { topic -> listItemViewModel.delete(topic) }
        ))
        lifecycleScope.launch {
            val list = mutableListOf<Topic>()
            listViewModel.topics.collectLatest { topic ->
                list.add(topic)
            }
            adapter.submitList(list)
        }
        binding.topicList.adapter = adapter
    }
}