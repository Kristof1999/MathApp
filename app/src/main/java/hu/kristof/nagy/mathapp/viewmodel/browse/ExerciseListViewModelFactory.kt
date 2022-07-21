package hu.kristof.nagy.mathapp.viewmodel.browse

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import hu.kristof.nagy.mathapp.data.MathAppDatabase

class ExerciseListViewModelFactory(
    private val db: MathAppDatabase,
    private val parentTopicId: Long
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ExerciseListViewModel::class.java)) {
            return ExerciseListViewModel(parentTopicId, db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}