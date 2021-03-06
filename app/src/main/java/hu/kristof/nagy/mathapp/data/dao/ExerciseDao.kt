package hu.kristof.nagy.mathapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import hu.kristof.nagy.mathapp.data.entity.Exercise

@Dao
interface ExerciseDao {
    @Query("SELECT * FROM exercise WHERE exercise.parentTopicId IS :topicId")
    fun loadExercisesOf(topicId: Long): LiveData<List<Exercise>>

    @Insert
    suspend fun create(exercise: Exercise)

    @Delete
    suspend fun delete(exercise: Exercise)

    @Update
    suspend fun edit(exercise: Exercise)
}