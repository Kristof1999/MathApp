package hu.kristof.nagy.mathapp.view.browse

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import hu.kristof.nagy.mathapp.data.MathAppDatabase

class TopicListViewModelFactory (
    private val db: MathAppDatabase,
    private val parentTopicName: String
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TopicListViewModel::class.java)) {
            return TopicListViewModel(db, parentTopicName) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}