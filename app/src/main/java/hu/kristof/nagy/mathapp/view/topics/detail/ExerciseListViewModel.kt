package hu.kristof.nagy.mathapp.view.topics.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hu.kristof.nagy.mathapp.data.MathAppDatabase
import hu.kristof.nagy.mathapp.data.entity.Exercise
import kotlinx.coroutines.launch

class ExerciseListViewModel(
    parentTopicName: String,
    private val db: MathAppDatabase
) : ViewModel() {
    val exercises = db.exerciseDao().loadAllForTopic(parentTopicName)

    fun create(name: String, question: String, answer: String, parentTopicName: String) {
        val exercise = Exercise(name, question, answer, parentTopicName)
        viewModelScope.launch {
            db.exerciseDao().create(exercise)
        }
    }
}