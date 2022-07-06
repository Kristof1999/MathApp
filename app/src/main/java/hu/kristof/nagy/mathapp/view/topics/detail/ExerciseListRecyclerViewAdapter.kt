package hu.kristof.nagy.mathapp.view.topics.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hu.kristof.nagy.mathapp.data.entity.Exercise
import hu.kristof.nagy.mathapp.databinding.FragmentExerciseListItemBinding

class ExerciseListRecyclerViewAdapter(
    private val clickListener: ExerciseClickListener
) : ListAdapter<Exercise, ExerciseListRecyclerViewAdapter.ViewHolder>(ExerciseListDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.from(parent, clickListener)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val exercise = getItem(position)
        holder.bind(exercise)
    }

    class ViewHolder(
        private val binding: FragmentExerciseListItemBinding,
        private val clickListener: ExerciseClickListener
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(exercise: Exercise) {
            binding.exercise = exercise
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup, clickListener: ExerciseClickListener): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = FragmentExerciseListItemBinding.inflate(
                    layoutInflater, parent, false
                )
                return ViewHolder(binding, clickListener)
            }
        }
    }
}

class ExerciseListDiffCallback : DiffUtil.ItemCallback<Exercise>() {
    override fun areItemsTheSame(oldItem: Exercise, newItem: Exercise): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Exercise, newItem: Exercise): Boolean {
        return oldItem == newItem
    }
}

class ExerciseClickListener(
    private val editListener: (exercise: Exercise) -> Unit,
    private val deleteListener: (exercise: Exercise) -> Unit
) {
    fun onEdit(exercise: Exercise) = editListener(exercise)
    fun onDelete(exercise: Exercise) = deleteListener(exercise)
}