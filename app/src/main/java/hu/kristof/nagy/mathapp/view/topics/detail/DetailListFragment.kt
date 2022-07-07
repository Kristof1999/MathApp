package hu.kristof.nagy.mathapp.view.topics.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import hu.kristof.nagy.mathapp.R
import hu.kristof.nagy.mathapp.data.MathAppDatabase
import hu.kristof.nagy.mathapp.data.entity.Exercise
import hu.kristof.nagy.mathapp.data.entity.Topic
import hu.kristof.nagy.mathapp.databinding.FragmentDetailListBinding
import hu.kristof.nagy.mathapp.view.TextDialogFragment
import hu.kristof.nagy.mathapp.view.topics.TopicClickListener
import hu.kristof.nagy.mathapp.view.topics.TopicListItemViewModel
import javax.inject.Inject

@AndroidEntryPoint
class DetailListFragment : Fragment() {
    @Inject
    lateinit var db: MathAppDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDetailListBinding.inflate(
            inflater, container, false
        ).apply {
            lifecycleOwner = viewLifecycleOwner
        }

        val args: DetailListFragmentArgs by navArgs()
        val exerciseListViewModelFactory = ExerciseListViewModelFactory(db, args.parentTopicName)
        val listViewModel = ViewModelProvider(this, exerciseListViewModelFactory)
            .get(ExerciseListViewModel::class.java)
        val listItemViewModel: ExerciseListItemViewModel by viewModels()
        val viewModelFactory = DetailTopicListViewModelFactory(db, args.parentTopicName)
        val detailTopicListViewModel = ViewModelProvider(this, viewModelFactory)
            .get(DetailTopicListViewModel::class.java)
        val detailTopicListItemViewModel: TopicListItemViewModel by viewModels()

        initList(
            listItemViewModel, listViewModel,
            detailTopicListViewModel, detailTopicListItemViewModel,
            binding
        )

        exerciseCreate(binding, args.parentTopicName)
        topicCreate(binding, detailTopicListViewModel, args.parentTopicName)

        return binding.root
    }

    private fun topicCreate(
        binding: FragmentDetailListBinding,
        detailTopicListViewModel: DetailTopicListViewModel,
        parentTopicName: String
    ) {
        val dialog = TextDialogFragment.instanceOf(
            R.string.topicCreateText, R.string.topicCreateHint
        )
        binding.detailTopicCreateBtn.setOnClickListener {
            dialog.show(parentFragmentManager, "topicCreation")
        }
        dialog.text.observe(viewLifecycleOwner) { topicName ->
            detailTopicListViewModel.createTopic(topicName, parentTopicName)
        }
    }

    private fun exerciseCreate(
        binding: FragmentDetailListBinding,
        parentTopicName: String
    ) {
        binding.exerciseCreateBtn.setOnClickListener {
            val directions = DetailListFragmentDirections
                .actionDetailListFragmentToExerciseCreateFragment(parentTopicName)
            findNavController().navigate(directions)
        }
    }

    private fun initList(
        listItemViewModel: ExerciseListItemViewModel,
        listViewModel: ExerciseListViewModel,
        detailTopicListViewModel: DetailTopicListViewModel,
        detailTopicListItemViewModel: TopicListItemViewModel,
        binding: FragmentDetailListBinding
    ) {
        val adapter = DetailListRecyclerViewAdapter(ExerciseClickListener(
            editListener = { exercise -> listItemViewModel.edit(exercise) },
            deleteListener = { exercise -> listItemViewModel.delete(exercise) },
            detailNavListener = { exercise ->
                val directions = DetailListFragmentDirections
                    .actionDetailListFragmentToExerciseFragment(exercise)
                findNavController().navigate(directions)
            }
        ), TopicClickListener(
            deleteListener = { topic -> detailTopicListItemViewModel.delete(topic) },
            detailNavListener = { topic ->
                val directions = DetailListFragmentDirections
                    .actionExerciseListFragmentSelf(topic.topicName)
                findNavController().navigate(directions)
            }
        ))

        // TODO: encapsulate in a class
        // Invariant: the below list contains the topics first, and then the exercises.
        val list = MutableLiveData(mutableListOf<Any>())
        detailTopicListViewModel.topics.observe(viewLifecycleOwner) { topics ->
            val exercises = list.value!!.takeLastWhile { item -> item is Exercise }
            list.value = mutableListOf<Any>().apply {
                addAll(topics)
                addAll(exercises)
            }
        }
        listViewModel.exercises.observe(viewLifecycleOwner) { exercises ->
            val topics = list.value!!.takeWhile { item -> item is Topic }
            list.value = mutableListOf<Any>().apply {
                addAll(topics)
                addAll(exercises)
            }
        }
        list.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        binding.detailList.adapter = adapter
    }
}