package hu.kristof.nagy.mathapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * A Topic is a mathematical topic, for example: algebra, calculus, etc.
 * Topics can contain zero or more topics and exercises. For example:
 * differential equations has topics: ordinary diff. eq. and partial diff. eq., and
 * might even have exercises where one should categorise a given diff. eq..
 */
@Entity
data class Topic(
    @PrimaryKey val topicName: String,
    val parentTopicName: String?
)
// TODO: consider switching string ids to long ids