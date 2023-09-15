package com.aristidevs.androidmaster.apps.todoapp.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aristidevs.androidmaster.R

class TasksAdapter(
    var tasks: List<Task>,
    private val onTaskSelected: (Int) -> Unit
) :
    RecyclerView.Adapter<TasksViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_todo_task, parent, false)
        return TasksViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        holder.render(tasks[position])
        holder.itemView.setOnClickListener {
            onTaskSelected(position)
        }
    }

    override fun getItemCount() = tasks.size
}