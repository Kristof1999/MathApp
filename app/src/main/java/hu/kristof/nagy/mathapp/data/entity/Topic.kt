package hu.kristof.nagy.mathapp.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 * A Topic is a mathematical topic, for example: algebra, calculus, etc.
 * Topics can contain zero or more topics and exercises. For example:
 * differential equations has topics: ordinary diff. eq. and partial diff. eq., and
 * might even have exercises where one should categorise a given diff. eq..
 * A summary of the related theory can also be included.
 */
@Entity(foreignKeys = [ForeignKey(
    entity = Topic::class,
    parentColumns = ["id"],
    childColumns = ["parentTopicId"],
    onDelete = ForeignKey.CASCADE,
    onUpdate = ForeignKey.CASCADE
)])
data class Topic(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    val topicName: String,
    val summary: String,
    val parentTopicId: Long
)