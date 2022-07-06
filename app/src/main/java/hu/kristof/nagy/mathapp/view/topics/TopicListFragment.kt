package hu.kristof.nagy.mathapp.view.topics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import hu.kristof.nagy.mathapp.R
import hu.kristof.nagy.mathapp.databinding.FragmentTopicListBinding
import hu.kristof.nagy.mathapp.view.TextDialogFragment

@AndroidEntryPoint
class TopicListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTopicListBinding.inflate(
            inflater, container, false
        ).apply {
            lifecycleOwner = viewLifecycleOwner
        }

        val listViewModel: TopicListViewModel by viewModels()
        val listItemViewModel: TopicListItemViewModel by viewModels()

        initList(listItemViewModel, listViewModel, binding)

        createTopic(binding, listViewModel)

        return binding.root
    }

    private fun createTopic(
        binding: FragmentTopicListBinding,
        listViewModel: TopicListViewModel
    ) {
        val dialog = TextDialogFragment.instanceOf(
            R.string.topicCreateText, R.string.topicCreateHint
        )
        binding.topicCreateBtn.setOnClickListener {
            dialog.show(parentFragmentManager, "topicCreation")
        }
        dialog.text.observe(viewLifecycleOwner) { topicName ->
            listViewModel.createHighLevelTopic(topicName)
        }
    }

    private fun initList(
        listItemViewModel: TopicListItemViewModel,
        listViewModel: TopicListViewModel,
        binding: FragmentTopicListBinding
    ) {
        val adapter = TopicListRecyclerViewAdapter(TopicClickListener(
            deleteListener = { topic -> listItemViewModel.delete(topic) },
            detailNavListener = { topic ->
                val directions = TopicListFragmentDirections
                    .actionTopicListFragmentToExerciseListFragment(topic.topicName)
                findNavController().navigate(directions)
            }
        ))

        listViewModel.highLevelTopics.observe(viewLifecycleOwner) { topics ->
            adapter.submitList(topics)
        }

        binding.topicList.adapter = adapter
    }
}