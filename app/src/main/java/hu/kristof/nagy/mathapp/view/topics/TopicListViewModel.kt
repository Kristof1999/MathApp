package hu.kristof.nagy.mathapp.view.topics

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.kristof.nagy.mathapp.data.Database
import hu.kristof.nagy.mathapp.data.entity.Topic
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopicListViewModel @Inject constructor(
    private val db: Database
) : ViewModel() {
    val highLevelTopics: LiveData<List<Topic>> = db.topicDao().loadHighLevelTopics()

    fun createHighLevelTopic(topicName: String) {
        viewModelScope.launch {
            db.topicDao().create(Topic(topicName, null))
        }
    }
}