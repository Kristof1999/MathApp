package hu.kristof.nagy.mathapp.view.browse

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import hu.kristof.nagy.mathapp.data.MathAppDatabase

class TopicViewModelFactory (
    private val db: MathAppDatabase,
    private val parentTopicName: String
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TopicViewModel::class.java)) {
            return TopicViewModel(db, parentTopicName) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}