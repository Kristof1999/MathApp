package hu.kristof.nagy.mathapp.viewmodel.exercise

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.kristof.nagy.mathapp.data.MathAppDatabase
import hu.kristof.nagy.mathapp.data.entity.Exercise
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExerciseCreateViewModel @Inject constructor(
    private val db: MathAppDatabase
) : ViewModel() {
    fun create(name: String, question: String, answer: String, parentTopicName: String) {
        val exercise = Exercise(null, name, question, answer, parentTopicName)
        viewModelScope.launch {
            db.exerciseDao().create(exercise)
        }
    }
}