package hu.kristof.nagy.mathapp.viewmodel.browse

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hu.kristof.nagy.mathapp.data.MathAppDatabase
import hu.kristof.nagy.mathapp.data.entity.Topic
import kotlinx.coroutines.launch

class TopicListViewModel(
    private val db: MathAppDatabase,
    parentTopicName: String
) : ViewModel() {
    val topics = db.topicDao().loadTopicsFor(parentTopicName)

    fun createTopic(topicName: String, parentTopicName: String) {
        viewModelScope.launch {
            db.topicDao().create(Topic(null, topicName, parentTopicName, ""))
        }
    }

    fun delete(topic: Topic) {
        viewModelScope.launch {
            db.topicDao().delete(topic)
        }
    }
}