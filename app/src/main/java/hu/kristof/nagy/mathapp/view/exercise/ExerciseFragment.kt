package hu.kristof.nagy.mathapp.view.exercise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import hu.kristof.nagy.mathapp.databinding.FragmentExerciseBinding

class ExerciseFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentExerciseBinding.inflate(
            inflater, container, false
        )

        val args: ExerciseFragmentArgs by navArgs()
        binding.exerciseName.text = args.exercise.name

        binding.exerciseQuestion.loadUrl("https://www.google.com/")

        return binding.root
    }
}