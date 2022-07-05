package hu.kristof.nagy.mathapp.view.exercises

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import hu.kristof.nagy.mathapp.R
import hu.kristof.nagy.mathapp.databinding.FragmentExerciseListBinding
import hu.kristof.nagy.mathapp.view.TextDialogFragment

@AndroidEntryPoint
class ExerciseListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentExerciseListBinding.inflate(
            inflater, container, false
        ).apply {
            lifecycleOwner = viewLifecycleOwner
        }

        val listViewModel: ExerciseListViewModel by viewModels()
        val listItemViewModel: ExerciseListItemViewModel by viewModels()

        initList(listItemViewModel, listViewModel, binding)

        exerciseCreate(binding, listViewModel)

        return binding.root
    }

    private fun exerciseCreate(
        binding: FragmentExerciseListBinding,
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
        binding: FragmentExerciseListBinding
    ) {
        val adapter = ExerciseListRecyclerViewAdapter(ExerciseClickListener(
            editListener = { exercise -> listItemViewModel.edit(exercise) },
            deleteListener = { exercise -> listItemViewModel.delete(exercise) }
        ))
        listViewModel.exercises.observe(viewLifecycleOwner) { exercises ->
            adapter.submitList(exercises)
        }
        binding.exerciseList.adapter = adapter
    }
}