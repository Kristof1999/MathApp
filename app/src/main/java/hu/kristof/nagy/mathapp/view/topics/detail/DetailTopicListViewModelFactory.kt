package hu.kristof.nagy.mathapp.view.topics.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DetailTopicListViewModelFactory(private val parentTopicName: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailTopicListViewModel::class.java)) {
            return DetailTopicListViewModel(parentTopicName) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}