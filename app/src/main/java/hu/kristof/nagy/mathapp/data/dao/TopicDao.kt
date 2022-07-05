package hu.kristof.nagy.mathapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import hu.kristof.nagy.mathapp.data.entity.Topic

@Dao
interface TopicDao {
    @Query("SELECT * FROM topic")
    fun loadTopics(): LiveData<List<Topic>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun create(topic: Topic)

    @Delete
    suspend fun delete(topic: Topic)
}