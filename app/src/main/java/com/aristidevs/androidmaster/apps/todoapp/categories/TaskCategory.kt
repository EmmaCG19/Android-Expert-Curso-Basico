package com.aristidevs.androidmaster.apps.todoapp.categories

sealed class TaskCategory(var isSelected: Boolean = true) {
    object Personal : TaskCategory()
    object Business : TaskCategory()
    object Other : TaskCategory()
}