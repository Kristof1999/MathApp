package hu.kristof.nagy.mathapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Topic(
    @PrimaryKey val topicName: String
)