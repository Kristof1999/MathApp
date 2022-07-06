package hu.kristof.nagy.mathapp.view.topics.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import hu.kristof.nagy.mathapp.data.MathAppDatabase

class DetailTopicListViewModelFactory(
    private val db: MathAppDatabase,
    private val parentTopicName: String
    ) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailTopicListViewModel::class.java)) {
            return DetailTopicListViewModel(db, parentTopicName) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}