package hu.kristof.nagy.mathapp.data.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Exercise(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    val name: String,
    val question: String,
    val answer: String,
    val parentTopicName: String?
) : Parcelable