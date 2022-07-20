package hu.kristof.nagy.mathapp.view.browse

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hu.kristof.nagy.mathapp.data.MathAppDatabase
import hu.kristof.nagy.mathapp.data.entity.Topic
import kotlinx.coroutines.launch

class TopicViewModel(
    private val db: MathAppDatabase,
    parentTopicName: String
) : ViewModel() {
    val topics = if (parentTopicName.isEmpty()) {
        db.topicDao().loadTopLevelTopics()
    } else {
        db.topicDao().loadTopicsFor(parentTopicName)
    }

    fun createTopic(topicName: String, parentTopicName: String) {
        viewModelScope.launch {
            db.topicDao().create(Topic(null, topicName, parentTopicName, ""))
        }
    }
}