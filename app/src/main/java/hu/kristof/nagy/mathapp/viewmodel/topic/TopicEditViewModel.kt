package hu.kristof.nagy.mathapp.viewmodel.topic

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
class TopicEditViewModel @Inject constructor(
    private val db: MathAppDatabase
) : ViewModel() {
    private val _topic = MutableLiveData<Topic>()
    val topic: LiveData<Topic>
        get() = _topic

    fun save(oldTopic: Topic, name: String, summary: String, parentTopicId: Long) {
        viewModelScope.launch {
            db.topicDao().edit(Topic(oldTopic.id, name, summary, parentTopicId))
        }
    }

    fun loadTopic(topicId: Long) {
        viewModelScope.launch {
            _topic.value = db.topicDao().loadTopic(topicId)
        }
    }
}