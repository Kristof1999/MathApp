package hu.kristof.nagy.mathapp.view.browse

import androidx.lifecycle.ViewModel
import hu.kristof.nagy.mathapp.data.MathAppDatabase

class ExerciseListViewModel(
    parentTopicName: String?,
    private val db: MathAppDatabase
) : ViewModel() {
    val exercises = db.exerciseDao().loadExercisesFor(parentTopicName)
}