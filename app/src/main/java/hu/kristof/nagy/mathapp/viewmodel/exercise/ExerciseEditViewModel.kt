package hu.kristof.nagy.mathapp.viewmodel.exercise

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.kristof.nagy.mathapp.data.MathAppDatabase
import hu.kristof.nagy.mathapp.data.entity.Exercise
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExerciseEditViewModel @Inject constructor(
    private val db: MathAppDatabase
) : ViewModel() {
    fun edit(exercise: Exercise, name: String, question: String, answer: String) {
        val newExercise = Exercise(exercise.id, name, question, answer, exercise.parentTopicId)
        viewModelScope.launch {
            db.exerciseDao().edit(newExercise)
        }
    }
}