package hu.kristof.nagy.mathapp.view.topics.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.kristof.nagy.mathapp.data.MathAppDatabase
import hu.kristof.nagy.mathapp.data.entity.Exercise
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExerciseListItemViewModel @Inject constructor(
    private val db: MathAppDatabase
) : ViewModel() {
    fun edit(exercise: Exercise) {
        viewModelScope.launch {
            db.exerciseDao().edit(exercise)
        }
    }

    fun delete(exercise: Exercise) {
        viewModelScope.launch {
            db.exerciseDao().delete(exercise)
        }
    }
}