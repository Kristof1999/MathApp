package hu.kristof.nagy.mathapp.viewmodel.browse

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hu.kristof.nagy.mathapp.data.MathAppDatabase
import hu.kristof.nagy.mathapp.data.entity.Exercise
import kotlinx.coroutines.launch

class ExerciseListViewModel(
    parentTopicName: String,
    private val db: MathAppDatabase
) : ViewModel() {
    val exercises = db.exerciseDao().loadExercisesFor(parentTopicName)

    fun delete(exercise: Exercise) {
        viewModelScope.launch {
            db.exerciseDao().delete(exercise)
        }
    }
}