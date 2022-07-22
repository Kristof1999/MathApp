package hu.kristof.nagy.mathapp.data.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(foreignKeys = [ForeignKey(
    entity = Topic::class,
    parentColumns = ["id"],
    childColumns = ["parentTopicId"],
    onDelete = ForeignKey.CASCADE,
    onUpdate = ForeignKey.CASCADE
)])
data class Exercise(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    val name: String,
    val question: String,
    val answer: String,
    val parentTopicId: Long
) : Parcelable