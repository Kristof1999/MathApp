package hu.kristof.nagy.mathapp.data

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import hu.kristof.nagy.mathapp.data.dao.ExerciseDao
import hu.kristof.nagy.mathapp.data.dao.TopicDao
import hu.kristof.nagy.mathapp.data.entity.Exercise
import hu.kristof.nagy.mathapp.data.entity.Topic

@Database(
    entities = [Topic::class, Exercise::class],
    version = 3,
    autoMigrations = [AutoMigration(from = 1, to = 2)]
)
abstract class MathAppDatabase : RoomDatabase() {
    abstract fun topicDao(): TopicDao
    abstract fun exerciseDao(): ExerciseDao
}