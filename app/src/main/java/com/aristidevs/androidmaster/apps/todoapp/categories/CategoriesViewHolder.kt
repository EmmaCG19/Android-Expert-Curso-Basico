package com.aristidevs.androidmaster.apps.todoapp.categories

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.aristidevs.androidmaster.R
import com.aristidevs.androidmaster.databinding.ItemTaskCategoryBinding

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemTaskCategoryBinding.bind(view)

    fun render(taskCategory: TaskCategory, onCategorySelected: (Int) -> Unit) {

        //Change background when category is clicked
        val color = if (taskCategory.isSelected) {
            R.color.todo_background_card
        } else {
            R.color.todo_background_disabled
        }

        binding.cvCategory.setCardBackgroundColor(
            ContextCompat.getColor(
                itemView.context,
                color
            )
        )

        itemView.setOnClickListener { onCategorySelected(layoutPosition) }

        when (taskCategory) {
            TaskCategory.Business -> {
                setCategoryInfo(
                    itemView.context.getString(R.string.todo_dialog_category_business),
                    R.color.todo_business_category
                )
            }

            TaskCategory.Other -> {
                setCategoryInfo(
                    itemView.context.getString(R.string.todo_dialog_category_other),
                    R.color.todo_other_category
                )
            }

            TaskCategory.Personal -> {
                setCategoryInfo(
                    itemView.context.getString(R.string.todo_dialog_category_personal),
                    R.color.todo_personal_category
                )
            }
        }
    }

    private fun setCategoryInfo(categoryName: String, colorId: Int) {
        binding.tvCategoryName.text = categoryName
        binding.categoryDivider.setBackgroundColor(
            ContextCompat.getColor(
                binding.root.context,
                colorId
            )
        )
    }
}


//TODO: Replace hardcoded strings with references from strings.xml