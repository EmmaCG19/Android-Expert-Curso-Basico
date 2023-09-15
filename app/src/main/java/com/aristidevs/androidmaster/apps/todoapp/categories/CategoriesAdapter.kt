package com.aristidevs.androidmaster.apps.todoapp.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aristidevs.androidmaster.R

class CategoriesAdapter(
    private val categories: List<TaskCategory>,
    private val onCategorySelected: (Int) -> Unit
) :
    RecyclerView.Adapter<CategoriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_task_category, parent, false)
        return CategoriesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.render(categories[position], onCategorySelected)
    }

    override fun getItemCount() = categories.size
}
