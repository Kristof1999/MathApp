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
            .addMigrations(MIGRATION_2_3, MIGRATION_3_4)
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
}