package hu.kristof.nagy.mathapp.view.browse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import hu.kristof.nagy.mathapp.R
import hu.kristof.nagy.mathapp.data.MathAppDatabase
import hu.kristof.nagy.mathapp.data.entity.Exercise
import hu.kristof.nagy.mathapp.data.entity.Topic
import hu.kristof.nagy.mathapp.view.TextDialogFragment
import hu.kristof.nagy.mathapp.viewmodel.browse.ExerciseListViewModel
import hu.kristof.nagy.mathapp.viewmodel.browse.ExerciseListViewModelFactory
import hu.kristof.nagy.mathapp.viewmodel.browse.TopicListViewModel
import hu.kristof.nagy.mathapp.viewmodel.browse.TopicListViewModelFactory
import javax.inject.Inject

@AndroidEntryPoint
class BrowseFragment : Fragment() {

    @Inject
    lateinit var db: MathAppDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_browse, container, false)

        val browseList = view.findViewById<RecyclerView>(R.id.browse_list)
        val topicCreateBtn = view.findViewById<Button>(R.id.browse_topic_create_btn)
        val exerciseCreateBtn = view.findViewById<Button>(R.id.browse_exercise_create_btn)
        val args: BrowseFragmentArgs by navArgs()
        val exerciseListViewModelFactory = ExerciseListViewModelFactory(db, args.parentTopicName)
        val exerciseListViewModel = ViewModelProvider(this, exerciseListViewModelFactory)
            .get(ExerciseListViewModel::class.java)
        val topicListViewModelFactory = TopicListViewModelFactory(db, args. parentTopicName)
        val topicListViewModel = ViewModelProvider(this, topicListViewModelFactory)
            .get(TopicListViewModel::class.java)

        initList(
            exerciseListViewModel, topicListViewModel, browseList, args.parentTopicId
        )

        exerciseCreate(exerciseCreateBtn, args.parentTopicName)
        topicCreate(topicCreateBtn, topicListViewModel, args.parentTopicName)

        return view
    }

    private fun topicCreate(
        topicCreateBtn: Button,
        topicListViewModel: TopicListViewModel,
        parentTopicName: String
    ) {
        val dialog = TextDialogFragment.instanceOf(
            R.string.topicCreateText, R.string.topicCreateHint
        )
        topicCreateBtn.setOnClickListener {
            dialog.show(parentFragmentManager, "topicCreation")
        }
        dialog.text.observe(viewLifecycleOwner) { topicName ->
            topicListViewModel.createTopic(topicName, parentTopicName)
        }
    }

    private fun exerciseCreate(
        exerciseCreateBtn: Button,
        parentTopicName: String
    ) {
        exerciseCreateBtn.setOnClickListener {
            val directions = BrowseFragmentDirections
                .actionBrowseFragmentToExerciseCreateFragment(parentTopicName)
            findNavController().navigate(directions)
        }
    }

    private fun initList(
        exerciseListViewModel: ExerciseListViewModel,
        topicListViewModel: TopicListViewModel,
        browseList: RecyclerView,
        parentTopicId: Long
    ) {
        val adapter = BrowseRecyclerViewAdapter(ExerciseClickListener(
            editListener = { exercise ->
                val directions = BrowseFragmentDirections
                    .actionBrowseFragmentToExerciseEditFragment(exercise)
                findNavController().navigate(directions)
            },
            deleteListener = { exercise -> exerciseListViewModel.delete(exercise) },
            detailNavListener = { exercise ->
                val directions = BrowseFragmentDirections
                    .actionBrowseFragmentToExerciseFragment(exercise, exercise.name, parentTopicId)
                findNavController().navigate(directions)
            }
        ), TopicClickListener(
            deleteListener = { topic -> topicListViewModel.delete(topic) },
            detailNavListener = { topic ->
                val directions = BrowseFragmentDirections
                    .actionBrowseFragmentSelf(topic.topicName)
                findNavController().navigate(directions)
            },
            editListener = { topic ->
                val directions = BrowseFragmentDirections
                    .actionBrowseFragmentToTopicEditFragment(topic.id!!, parentTopicId)
                findNavController().navigate(directions)
            },
            summaryNavListener = { topic ->
                val directions = BrowseFragmentDirections
                    .actionBrowseFragmentToTopicSummaryFragment(topic.id!!)
                findNavController().navigate(directions)
            }
        ))

        // TODO: encapsulate in a class
        // Invariant: the below list contains the topics first, and then the exercises.
        val list = MutableLiveData(mutableListOf<Any>())
        topicListViewModel.topics.observe(viewLifecycleOwner) { topics ->
            val exercises = list.value!!.takeLastWhile { item -> item is Exercise }
            list.value = mutableListOf<Any>().apply {
                addAll(topics)
                addAll(exercises)
            }
        }
        exerciseListViewModel.exercises.observe(viewLifecycleOwner) { exercises ->
            val topics = list.value!!.takeWhile { item -> item is Topic }
            list.value = mutableListOf<Any>().apply {
                addAll(topics)
                addAll(exercises)
            }
        }
        list.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        browseList.adapter = adapter
    }
}