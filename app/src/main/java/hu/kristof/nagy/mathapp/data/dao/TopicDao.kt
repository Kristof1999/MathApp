package hu.kristof.nagy.mathapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import hu.kristof.nagy.mathapp.data.entity.Topic

@Dao
interface TopicDao {
    @Query("SELECT * FROM topic")
    fun getAll(): List<Topic>

    @Insert
    fun create(topic: Topic)

    @Delete
    fun delete(topic: Topic)
}