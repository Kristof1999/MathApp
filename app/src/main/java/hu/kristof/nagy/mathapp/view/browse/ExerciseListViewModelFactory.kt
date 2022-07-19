package hu.kristof.nagy.mathapp.view.browse

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import hu.kristof.nagy.mathapp.data.MathAppDatabase

class ExerciseListViewModelFactory(
    private val db: MathAppDatabase,
    private val parentTopicName: String?
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ExerciseListViewModel::class.java)) {
            return ExerciseListViewModel(parentTopicName, db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}