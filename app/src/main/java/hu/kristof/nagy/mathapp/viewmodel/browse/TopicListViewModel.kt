package hu.kristof.nagy.mathapp.viewmodel.browse

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hu.kristof.nagy.mathapp.data.MathAppDatabase
import hu.kristof.nagy.mathapp.data.entity.Topic
import kotlinx.coroutines.launch

class TopicListViewModel(
    private val db: MathAppDatabase,
    parentTopicId: Long
) : ViewModel() {
    val topics = db.topicDao().loadTopicsOf(parentTopicId)

    fun createTopic(topicName: String, parentTopicId: Long) {
        viewModelScope.launch {
            db.topicDao().create(Topic(null, topicName, "", parentTopicId))
        }
    }

    fun delete(topic: Topic) {
        viewModelScope.launch {
            db.topicDao().delete(topic)
        }
    }
}