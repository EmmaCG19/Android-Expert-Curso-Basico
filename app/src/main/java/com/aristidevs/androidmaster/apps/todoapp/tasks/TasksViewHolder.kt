package com.aristidevs.androidmaster.apps.todoapp.tasks

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.aristidevs.androidmaster.R
import com.aristidevs.androidmaster.apps.todoapp.categories.TaskCategory
import com.aristidevs.androidmaster.databinding.ItemTodoTaskBinding

class TasksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = ItemTodoTaskBinding.bind(itemView)

    fun render(task: Task, onTaskSelected: (Int) -> Unit) {
        //TextView
        binding.tvTaskName.text = task.name

        if (task.isSelected) {
            binding.tvTaskName.paintFlags =
                binding.tvTaskName.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            binding.tvTaskName.paintFlags =
                binding.tvTaskName.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        //Checkbox
        binding.cbTask.isChecked = task.isSelected
        binding.cbTask.buttonTintList = ColorStateList.valueOf(getCategoryColor(task))

        //Define click actions
        binding.root.setOnClickListener {
            onTaskSelected(layoutPosition)
        }

        binding.cbTask.setOnClickListener {
            onTaskSelected(layoutPosition)
        }

    }

    private fun getCategoryColor(task: Task): Int {
        val colorId = when (task.category) {
            TaskCategory.Business -> {
                R.color.todo_business_category
            }

            TaskCategory.Other -> {
                R.color.todo_other_category
            }

            TaskCategory.Personal -> {
                R.color.todo_personal_category
            }
        }

        return ContextCompat.getColor(binding.root.context, colorId)
    }
}
