package hu.kristof.nagy.mathapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import hu.kristof.nagy.mathapp.data.entity.Exercise

@Dao
interface ExerciseDao {
    // TODO: load only the names, and have a method which loads a one with the given name with a given topic
    @Query("SELECT * FROM exercise")
    fun loadAll(): LiveData<List<Exercise>>

    @Insert
    suspend fun create(exercise: Exercise)

    @Delete
    suspend fun delete(exercise: Exercise)

    @Update
    suspend fun edit(exercise: Exercise)
}