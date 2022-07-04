package hu.kristof.nagy.mathapp.view.topics

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import hu.kristof.nagy.mathapp.R
import hu.kristof.nagy.mathapp.data.entity.Topic
import hu.kristof.nagy.mathapp.databinding.FragmentTopicListItemBinding
import java.nio.file.Files.size

class TopicListRecyclerViewAdapter(
    private val clickListener: TopicClickListener
) : ListAdapter<Topic, TopicListRecyclerViewAdapter.ViewHolder>(TopicListDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.from(parent, clickListener)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val topic = getItem(position)
        holder.bind(topic)
    }

    class ViewHolder private constructor(
        private val binding: FragmentTopicListItemBinding,
        private val clickListener: TopicClickListener
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(topic: Topic) {
            binding.topic = topic
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup, clickListener: TopicClickListener): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = FragmentTopicListItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding, clickListener)
            }
        }
    }
}

class TopicListDiffCallback : DiffUtil.ItemCallback<Topic>() {
    override fun areItemsTheSame(oldItem: Topic, newItem: Topic): Boolean {
        return oldItem.topicName == newItem.topicName
    }

    override fun areContentsTheSame(oldItem: Topic, newItem: Topic): Boolean {
        return oldItem == newItem
    }
}

class TopicClickListener(
    private val editListener: (topic: Topic) -> Unit,
    private val deleteListener: (topic: Topic) -> Unit
) {
    fun onEdit(topic: Topic) = editListener(topic)
    fun onDelete(topic: Topic) = deleteListener(topic)
}