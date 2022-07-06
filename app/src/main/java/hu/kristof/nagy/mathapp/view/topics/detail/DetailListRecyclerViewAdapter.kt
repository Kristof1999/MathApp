package hu.kristof.nagy.mathapp.view.topics.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hu.kristof.nagy.mathapp.data.entity.Exercise
import hu.kristof.nagy.mathapp.data.entity.Topic
import hu.kristof.nagy.mathapp.databinding.FragmentExerciseListItemBinding
import hu.kristof.nagy.mathapp.databinding.FragmentTopicListItemBinding
import hu.kristof.nagy.mathapp.view.topics.TopicClickListener

private val EXERCISE_VIEW_TYPE = 0
private val TOPIC_VIEW_TYPE = 1

class DetailListRecyclerViewAdapter(
    private val exerciseClickListener: ExerciseClickListener,
    private val topicClickListener: TopicClickListener
) : ListAdapter<Any, DetailListRecyclerViewAdapter.ViewHolder>(DetailListDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.from(parent, exerciseClickListener, topicClickListener, viewType)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is Exercise -> EXERCISE_VIEW_TYPE
            is Topic -> TOPIC_VIEW_TYPE
            else -> throw IllegalArgumentException("illegal list item")
        }
    }

    sealed class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(listItem: Any)

        class ExerciseViewHolder(
            private val binding: FragmentExerciseListItemBinding,
            private val clickListener: ExerciseClickListener
        ) : ViewHolder(binding.root) {
            override fun bind(listItem: Any) {
                binding.exercise = (listItem as Exercise)
                binding.clickListener = clickListener
                binding.executePendingBindings()
            }
        }

        class TopicViewHolder(
            private val binding: FragmentTopicListItemBinding,
            private val clickListener: TopicClickListener
        ) : ViewHolder(binding.root) {
            override fun bind(listItem: Any) {
                binding.topic = (listItem as Topic)
                binding.clickListener = clickListener
                binding.executePendingBindings()
            }
        }

        companion object {
            fun from(
                parent: ViewGroup,
                exerciseClickListener: ExerciseClickListener,
                topicClickListener: TopicClickListener,
                viewType: Int
            ): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)

                return when (viewType) {
                    EXERCISE_VIEW_TYPE -> {
                        val binding = FragmentExerciseListItemBinding.inflate(
                            layoutInflater, parent, false
                        )
                        ExerciseViewHolder(binding, exerciseClickListener)
                    }
                    TOPIC_VIEW_TYPE -> {
                        val binding = FragmentTopicListItemBinding.inflate(
                            layoutInflater, parent, false
                        )
                        TopicViewHolder(binding, topicClickListener)
                    }
                    else -> throw IllegalArgumentException("illegal list item")
                }
            }
        }
    }
}

class DetailListDiffCallback : DiffUtil.ItemCallback<Any>() {
    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
        if (isDifferentByType(oldItem, newItem)) {
            return false
        }

        return when (oldItem) {
            is Exercise -> oldItem.name == (newItem as Exercise).name
            is Topic -> oldItem.topicName == (newItem as Topic).topicName
            else -> throw IllegalArgumentException("illegal list item in diff callback")
        }
    }

    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
        if (isDifferentByType(oldItem, newItem)) {
            return false
        }

        return when (oldItem) {
            is Exercise -> (oldItem as Exercise) == (newItem as Exercise)
            is Topic -> (oldItem as Topic) == (newItem as Topic)
            else -> throw IllegalArgumentException("illegal list item in diff callback")
        }
    }

    private fun isDifferentByType(oldItem: Any, newItem: Any): Boolean {
        if (oldItem is Exercise && newItem !is Exercise) {
            return true
        }
        if (oldItem is Topic && newItem !is Topic) {
            return true
        }
        return false
    }
}

class ExerciseClickListener(
    private val editListener: (exercise: Exercise) -> Unit,
    private val deleteListener: (exercise: Exercise) -> Unit
) {
    fun onEdit(exercise: Exercise) = editListener(exercise)
    fun onDelete(exercise: Exercise) = deleteListener(exercise)
}