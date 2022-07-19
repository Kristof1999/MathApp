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
import hu.kristof.nagy.mathapp.view.topics.TopicListItemViewModel
import hu.kristof.nagy.mathapp.view.topics.detail.*
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
        val topicCreateBtn = view.findViewById<Button>(R.id.topic_create_btn)
        val exerciseCreateBtn = view.findViewById<Button>(R.id.exercise_create_btn)
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
            browseList
        )

        exerciseCreate(exerciseCreateBtn, args.parentTopicName)
        topicCreate(topicCreateBtn, detailTopicListViewModel, args.parentTopicName)

        return view
    }

    private fun topicCreate(
        topicCreateBtn: Button,
        detailTopicListViewModel: DetailTopicListViewModel,
        parentTopicName: String
    ) {
        val dialog = TextDialogFragment.instanceOf(
            R.string.topicCreateText, R.string.topicCreateHint
        )
        topicCreateBtn.setOnClickListener {
            dialog.show(parentFragmentManager, "topicCreation")
        }
        dialog.text.observe(viewLifecycleOwner) { topicName ->
            detailTopicListViewModel.createTopic(topicName, parentTopicName)
        }
    }

    private fun exerciseCreate(
        exerciseCreateBtn: Button,
        parentTopicName: String
    ) {
        exerciseCreateBtn.setOnClickListener {
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
        browseList: RecyclerView
    ) {
        val adapter = BrowseRecyclerViewAdapter(ExerciseClickListener(
            editListener = { exercise ->
                val directions = DetailListFragmentDirections
                    .actionDetailListFragmentToExerciseEditFragment(exercise)
                findNavController().navigate(directions);
            },
            deleteListener = { exercise -> listItemViewModel.delete(exercise) },
            detailNavListener = { exercise ->
                val directions = DetailListFragmentDirections
                    .actionDetailListFragmentToExerciseFragment(exercise, exercise.name)
                findNavController().navigate(directions)
            }
        ), TopicClickListener(
            deleteListener = { topic -> detailTopicListItemViewModel.delete(topic) },
            detailNavListener = { topic ->
                val directions = DetailListFragmentDirections
                    .actionExerciseListFragmentSelf(topic.topicName)
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

        browseList.adapter = adapter
    }
}