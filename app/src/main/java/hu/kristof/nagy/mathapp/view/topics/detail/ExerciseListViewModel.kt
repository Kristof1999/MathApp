package hu.kristof.nagy.mathapp.view.topics.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.kristof.nagy.mathapp.data.MathAppDatabase
import hu.kristof.nagy.mathapp.data.entity.Exercise
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExerciseListViewModel @Inject constructor(
    private val db: MathAppDatabase
) : ViewModel() {
    val exercises = db.exerciseDao().loadAll()

    fun create(name: String, question: String, answer: String) {
        val exercise = Exercise(name, question, answer)
        viewModelScope.launch {
            db.exerciseDao().create(exercise)
        }
    }
}