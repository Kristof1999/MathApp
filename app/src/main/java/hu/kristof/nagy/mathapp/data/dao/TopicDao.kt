package hu.kristof.nagy.mathapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import hu.kristof.nagy.mathapp.data.entity.Topic

@Dao
interface TopicDao {
    @Query("SELECT * FROM topic WHERE topic.parentTopicId IS :topicId")
    fun loadTopicsOf(topicId: Long): LiveData<List<Topic>>

    @Query("SELECT * FROM topic WHERE id IS :topicId")
    suspend fun loadTopic(topicId: Long): Topic

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun create(topic: Topic)

    @Update
    suspend fun edit(topic: Topic)

    @Delete
    suspend fun delete(topic: Topic)
}