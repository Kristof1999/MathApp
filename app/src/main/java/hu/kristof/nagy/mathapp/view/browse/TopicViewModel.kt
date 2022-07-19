package hu.kristof.nagy.mathapp.view.browse

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.kristof.nagy.mathapp.data.MathAppDatabase
import hu.kristof.nagy.mathapp.data.entity.Topic
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopicViewModel @Inject constructor(
    private val db: MathAppDatabase
) : ViewModel() {
    private val _topics = MutableLiveData<List<Topic>>(listOf())
    val topics: LiveData<List<Topic>>
        get() = _topics

    fun loadTopics(parentTopicName: String) {
        _topics.value = if (parentTopicName.isEmpty()) {
            db.topicDao().loadTopLevelTopics().value
        } else {
            db.topicDao().loadTopicsFor(parentTopicName).value
        }
    }

    fun createTopic(topicName: String, parentTopicName: String) {
        viewModelScope.launch {
            db.topicDao().create(Topic(null, topicName, parentTopicName, ""))
        }
    }
}