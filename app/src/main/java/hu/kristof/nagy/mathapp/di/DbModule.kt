package hu.kristof.nagy.mathapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import hu.kristof.nagy.mathapp.data.MathAppDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Singleton
    @Provides
    fun provideDb(@ApplicationContext context: Context): MathAppDatabase {
        return Room.databaseBuilder(context, MathAppDatabase::class.java, "MathApp")
            .addMigrations(MIGRATION_2_3, MIGRATION_3_4, MIGRATION_4_5)
            .build()
    }

    private val MIGRATION_2_3 = object : Migration(2, 3) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE topic ADD COLUMN parentTopicName TEXT")
        }
    }
    private val MIGRATION_3_4 = object : Migration(3, 4) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE exercise ADD COLUMN parentTopicName TEXT NOT NULL DEFAULT 'misc'")
        }
    }
    private val MIGRATION_4_5 = object : Migration(4, 5) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("DROP TABLE exercise")
            database.execSQL("DROP TABLE topic")

            database.execSQL("CREATE TABLE exercise (" +
                    "id INTEGER PRIMARY KEY," +
                    "name TEXT NOT NULL, question TEXT NOT NULL," +
                    "answer TEXT NOT NULL, parentTopicName TEXT NOT NULL)"
            )
            database.execSQL("CREATE TABLE topic (" +
                    "id INTEGER PRIMARY KEY, " +
                    "topicName TEXT NOT NULL, parentTopicName TEXT)"
            )
        }
    }
    private val MIGRATION_5_6 = object : Migration(5, 6) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE topic ADD COLUMN summary TEXT NOT NULL DEFAULT ''")
        }
    }
}