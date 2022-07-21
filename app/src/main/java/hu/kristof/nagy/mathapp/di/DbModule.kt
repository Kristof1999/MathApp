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
            .addMigrations(MIGRATION_2_3, MIGRATION_3_4, MIGRATION_4_5, MIGRATION_5_6, MIGRATION_6_7, MIGRATION_7_8)
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
    private val MIGRATION_6_7 = object : Migration(6, 7) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.beginTransaction()
            try {
                database.execSQL("CREATE TABLE topic2(" +
                        "id INTEGER PRIMARY KEY," +
                        "topicName TEXT NOT NULL," +
                        "parentTopicName TEXT NOT NULL," +
                        "summary TEXT NOT NULL DEFAULT '')"
                )
                database.execSQL("UPDATE topic " +
                        "SET parentTopicName = ''" +
                        "WHERE parentTopicName IS NULL")
                database.execSQL("INSERT INTO topic2 SELECT * FROM topic ")
                database.execSQL("DROP TABLE topic")
                database.execSQL("ALTER TABLE topic2 RENAME TO topic")
                database.setTransactionSuccessful()
            } finally {
                database.endTransaction()
            }
        }
    }
    private val MIGRATION_7_8 = object : Migration(7, 8) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.beginTransaction()
            try {
                database.execSQL("DROP TABLE topic")
                database.execSQL("CREATE TABLE topic(" +
                        "id INTEGER PRIMARY KEY," +
                        "topicName TEXT NOT NULL," +
                        "summary TEXT NOT NULL DEFAULT ''," +
                        "parentTopicId INTEGER NOT NULL)"
                )

                database.execSQL("DROP TABLE exercise")
                database.execSQL("CREATE TABLE exercise(" +
                        "id INTEGER PRIMARY KEY," +
                        "name TEXT NOT NULL," +
                        "question TEXT NOT NULL," +
                        "answer TEXT NOT NULL," +
                        "parentTopicId INTEGER NOT NULL)"
                )
                database.setTransactionSuccessful()
            } finally {
                database.endTransaction()
            }
        }
    }
}