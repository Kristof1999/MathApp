package hu.kristof.nagy.mathapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import hu.kristof.nagy.mathapp.data.entity.Topic

@Dao
interface TopicDao {
    @Query("SELECT * FROM topic WHERE topic.parentTopicName IS NULL")
    fun loadHighLevelTopics(): LiveData<List<Topic>>

    @Query("SELECT * FROM topic WHERE topic.parentTopicName IS :topicName")
    fun loadTopicsFor(topicName: String): LiveData<List<Topic>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun create(topic: Topic)

    // TODO: update related exercises too
    @Update
    suspend fun edit(topic: Topic)

    @Delete
    suspend fun delete(topic: Topic)
}