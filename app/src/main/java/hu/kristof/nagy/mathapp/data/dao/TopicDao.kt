package hu.kristof.nagy.mathapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import hu.kristof.nagy.mathapp.data.entity.Topic
import kotlinx.coroutines.flow.Flow

@Dao
interface TopicDao {
    @Query("SELECT * FROM topic")
    fun loadTopics(): Flow<Topic>

    @Insert
    suspend fun create(topic: Topic)

    @Delete
    suspend fun delete(topic: Topic)
}