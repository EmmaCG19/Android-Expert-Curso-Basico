package com.aristidevs.androidmaster.apps.todoapp.tasks

import com.aristidevs.androidmaster.apps.todoapp.categories.TaskCategory

data class Task(
    val name: String,
    val category: TaskCategory,
    var isSelected: Boolean = false
)
