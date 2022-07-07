package hu.kristof.nagy.mathapp.view.topics.detail

import androidx.lifecycle.ViewModel
import hu.kristof.nagy.mathapp.data.MathAppDatabase

class ExerciseListViewModel(
    parentTopicName: String,
    private val db: MathAppDatabase
) : ViewModel() {
    val exercises = db.exerciseDao().loadAllForTopic(parentTopicName)
}