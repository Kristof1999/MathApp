package hu.kristof.nagy.mathapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Exercise(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    val name: String,
    val question: String,
    val answer: String,
    val parentTopicName: String
)