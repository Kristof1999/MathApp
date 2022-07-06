package hu.kristof.nagy.mathapp.view.topics.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import hu.kristof.nagy.mathapp.R
import hu.kristof.nagy.mathapp.databinding.FragmentDetailListBinding
import hu.kristof.nagy.mathapp.view.TextDialogFragment

@AndroidEntryPoint
class DetailListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDetailListBinding.inflate(
            inflater, container, false
        ).apply {
            lifecycleOwner = viewLifecycleOwner
        }

        // TODO: rename type
        val args: ExerciseListFragmentArgs by navArgs()
        val listViewModel: ExerciseListViewModel by viewModels()
        val listItemViewModel: ExerciseListItemViewModel by viewModels()
        val viewModelFactory = DetailTopicListViewModelFactory(args.parentTopicName)
        val detailTopicListViewModel = ViewModelProvider(this, viewModelFactory)
            .get(DetailTopicListViewModel::class.java)

        initList(listItemViewModel, listViewModel, binding)

        exerciseCreate(binding, listViewModel)
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
        listViewModel: ExerciseListViewModel
    ) {
        binding.exerciseCreateBtn.setOnClickListener {
            var name = ""
            var question = ""
            var answer = ""

            val nameDialog = TextDialogFragment.instanceOf(
                R.string.exerciseCreateNameText, R.string.exerciseCreateNameHint
            )
            nameDialog.show(parentFragmentManager, "exerciseCreateName")
            nameDialog.text.observe(viewLifecycleOwner) {
                name = it

                val questionDialog = TextDialogFragment.instanceOf(
                    R.string.exerciseCreateQuestionText, R.string.exerciseCreateQuestionHint
                )
                questionDialog.show(parentFragmentManager, "exerciseCreateQuestion")
                questionDialog.text.observe(viewLifecycleOwner) {
                    question = it

                    val answerDialog = TextDialogFragment.instanceOf(
                        R.string.exerciseCreateAnswerText, R.string.exerciseCreateAnswerHint
                    )
                    answerDialog.show(parentFragmentManager, "exerciseCreateAnswer")
                    answerDialog.text.observe(viewLifecycleOwner) {
                        answer = it

                        listViewModel.create(name, question, answer)
                    }
                }
            }
        }
    }

    private fun initList(
        listItemViewModel: ExerciseListItemViewModel,
        listViewModel: ExerciseListViewModel,
        binding: FragmentDetailListBinding
    ) {
        val adapter = ExerciseListRecyclerViewAdapter(ExerciseClickListener(
            editListener = { exercise -> listItemViewModel.edit(exercise) },
            deleteListener = { exercise -> listItemViewModel.delete(exercise) }
        ))
        listViewModel.exercises.observe(viewLifecycleOwner) { exercises ->
            adapter.submitList(exercises)
        }
        binding.detailList.adapter = adapter
    }
}