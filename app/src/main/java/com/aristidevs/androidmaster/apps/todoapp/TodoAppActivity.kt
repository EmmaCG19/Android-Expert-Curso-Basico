package com.aristidevs.androidmaster.apps.todoapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import androidx.recyclerview.widget.LinearLayoutManager
import com.aristidevs.androidmaster.R
import com.aristidevs.androidmaster.apps.todoapp.categories.CategoriesAdapter
import com.aristidevs.androidmaster.apps.todoapp.categories.TaskCategory
import com.aristidevs.androidmaster.apps.todoapp.categories.TaskCategory.*
import com.aristidevs.androidmaster.apps.todoapp.tasks.Task
import com.aristidevs.androidmaster.apps.todoapp.tasks.TasksAdapter
import com.aristidevs.androidmaster.databinding.ActivityTodoappBinding
import com.aristidevs.androidmaster.databinding.DialogTaskBinding

class TodoAppActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTodoappBinding
    private lateinit var dialogBinding: DialogTaskBinding
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var tasksAdapter: TasksAdapter

    private val categories: List<TaskCategory> =
        listOf(
            Business,
            Other,
            Personal
        )

    private val tasks: MutableList<Task> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoappBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        initListeners()
    }

    private fun initUI() {
        initCategoriesRV()
        initTasksRV()
    }

    private fun initListeners() {
        binding.fabAddTask.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {

        //Open Dialog
        val dialog = Dialog(this)
        dialogBinding = DialogTaskBinding.inflate(layoutInflater)
        dialog.setContentView(dialogBinding.root)
        dialog.show()

        //Adding a new task
        dialogBinding.btnAddTask.setOnClickListener {

            val taskName = dialogBinding.etTask.text.toString()

            if (taskName.isNotEmpty()) {

                //Obtain the selected category
                val selectedId = dialogBinding.rgCategories.checkedRadioButtonId
                val selectedRadioButton =
                    dialogBinding.rgCategories.findViewById<RadioButton>(selectedId)
                val currentCategory: TaskCategory = when (selectedRadioButton.text) {
                    getString(R.string.todo_dialog_category_business) -> Business
                    getString(R.string.todo_dialog_category_personal) -> Personal
                    else -> Other
                }

                //Add new item to the list
                tasks.add(Task(taskName, currentCategory))

                //Notify TasksAdapter of the changes on the list
                updateTasks()

                //Hide dialog
                dialog.hide()
            }
        }
    }

    private fun onItemSelected(position: Int) {
        tasks[position].isSelected = !tasks[position].isSelected
        updateTasks()
    }

    private fun updateTasks() {
        val newTasks: List<Task> = tasks.filter { it.category.isSelected }
        tasksAdapter.tasks = newTasks
        tasksAdapter.notifyDataSetChanged()
    }

    private fun initTasksRV() {
        tasksAdapter = TasksAdapter(tasks) { taskPosition ->
            onItemSelected(taskPosition)
        }

        binding.rvTasks.layoutManager = LinearLayoutManager(this)
        binding.rvTasks.adapter = tasksAdapter
    }

    private fun initCategoriesRV() {
        categoriesAdapter = CategoriesAdapter(categories) {
            onCategorySelected(it)
        }

        binding.rvCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvCategories.adapter = categoriesAdapter
    }

    private fun onCategorySelected(position: Int) {
        categories[position].isSelected = !categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateTasks()
    }
}