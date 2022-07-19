package hu.kristof.nagy.mathapp.view.browse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import hu.kristof.nagy.mathapp.R
import hu.kristof.nagy.mathapp.data.MathAppDatabase
import hu.kristof.nagy.mathapp.data.entity.Exercise
import hu.kristof.nagy.mathapp.data.entity.Topic
import hu.kristof.nagy.mathapp.view.TextDialogFragment
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
        val listViewModel = ViewModelProvider(this, exerciseListViewModelFactory)
            .get(ExerciseListViewModel::class.java)
        val listItemViewModel: ExerciseListItemViewModel by viewModels()
        val topicListItemViewModel: TopicListItemViewModel by viewModels()
        val topicViewModel: TopicViewModel by viewModels()

        initList(
            listItemViewModel, listViewModel,
            topicViewModel, topicListItemViewModel,
            browseList
        )

        exerciseCreate(exerciseCreateBtn, args.parentTopicName!!)
        topicCreate(topicCreateBtn, topicViewModel, args.parentTopicName)

        return view
    }

    private fun topicCreate(
        topicCreateBtn: Button,
        topicViewModel: TopicViewModel,
        parentTopicName: String?
    ) {
        val dialog = TextDialogFragment.instanceOf(
            R.string.topicCreateText, R.string.topicCreateHint
        )
        topicCreateBtn.setOnClickListener {
            dialog.show(parentFragmentManager, "topicCreation")
        }
        dialog.text.observe(viewLifecycleOwner) { topicName ->
            topicViewModel.createTopic(topicName, parentTopicName)
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
        listItemViewModel: ExerciseListItemViewModel,
        listViewModel: ExerciseListViewModel,
        topicViewModel: TopicViewModel,
        detailTopicListItemViewModel: TopicListItemViewModel,
        browseList: RecyclerView
    ) {
        val adapter = BrowseRecyclerViewAdapter(ExerciseClickListener(
            editListener = { exercise ->
                val directions = BrowseFragmentDirections
                    .actionBrowseFragmentToExerciseEditFragment(exercise)
                findNavController().navigate(directions);
            },
            deleteListener = { exercise -> listItemViewModel.delete(exercise) },
            detailNavListener = { exercise ->
                val directions = BrowseFragmentDirections
                    .actionBrowseFragmentToExerciseFragment(exercise, exercise.name)
                findNavController().navigate(directions)
            }
        ), TopicClickListener(
            deleteListener = { topic -> detailTopicListItemViewModel.delete(topic) },
            detailNavListener = { topic ->
                val directions = BrowseFragmentDirections
                    .actionBrowseFragmentSelf(topic.topicName)
                findNavController().navigate(directions)
            },
            editListener = { topic ->

            },
            summaryNavListener = { topic ->

            }
        ))

        // TODO: encapsulate in a class
        // Invariant: the below list contains the topics first, and then the exercises.
        val list = MutableLiveData(mutableListOf<Any>())
        topicViewModel.topics.observe(viewLifecycleOwner) { topics ->
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

        browseList.adapter = adapter
    }
}