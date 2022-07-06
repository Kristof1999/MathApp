package hu.kristof.nagy.mathapp.view.topics.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hu.kristof.nagy.mathapp.data.Database
import hu.kristof.nagy.mathapp.data.entity.Topic
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailTopicListViewModel(parentTopicName: String) : ViewModel() {
    @Inject lateinit var db: Database

    val topics = db.topicDao().loadTopicsFor(parentTopicName)

    fun createTopic(topicName: String, parentTopicName: String) {
        viewModelScope.launch {
            db.topicDao().create(Topic(topicName, parentTopicName))
        }
    }
}