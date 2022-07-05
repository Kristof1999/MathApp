package hu.kristof.nagy.mathapp.data.dao

import androidx.room.*
import hu.kristof.nagy.mathapp.data.entity.Topic
import kotlinx.coroutines.flow.Flow

@Dao
interface TopicDao {
    @Query("SELECT * FROM topic")
    fun loadTopics(): Flow<Topic>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun create(topic: Topic)

    @Update
    suspend fun edit(topic: Topic)

    @Delete
    suspend fun delete(topic: Topic)
}