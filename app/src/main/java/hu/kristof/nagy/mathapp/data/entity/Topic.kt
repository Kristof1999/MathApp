package hu.kristof.nagy.mathapp.data.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

/**
 * A Topic is a mathematical topic, for example: algebra, calculus, etc.
 * Topics can contain zero or more topics and exercises. For example:
 * differential equations has topics: ordinary diff. eq. and partial diff. eq., and
 * might even have exercises where one should categorise a given diff. eq..
 * A summary of the related theory can also be included.
 */
@Parcelize
@Entity
data class Topic(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    val topicName: String,
    val parentTopicName: String,
    val summary: String
) : Parcelable