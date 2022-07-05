package hu.kristof.nagy.mathapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import hu.kristof.nagy.mathapp.data.dao.ExerciseDao
import hu.kristof.nagy.mathapp.data.dao.TopicDao
import hu.kristof.nagy.mathapp.data.entity.Topic

@Database(entities = [Topic::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun topicDao(): TopicDao
    abstract fun exerciseDao(): ExerciseDao
}