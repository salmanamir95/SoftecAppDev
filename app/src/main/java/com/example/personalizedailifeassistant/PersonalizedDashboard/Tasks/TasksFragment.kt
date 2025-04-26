package com.example.personalizedailifeassistant.PersonalizedDashboard.Tasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.personalizedailifeassistant.R

class TasksFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var taskAdapter: TaskAdapter
    private val tasksViewModel: TasksViewModel by viewModels() // ViewModel initialization

    private lateinit var btnAddTask: Button
    private lateinit var editTextTaskTitle: EditText
    private lateinit var spinnerCategory: Spinner // Spinner for selecting category

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout first
        val view = inflater.inflate(R.layout.fragment_task, container, false)

        // Initialize the Spinner after inflating the layout
        spinnerCategory = view.findViewById(R.id.spinnerCategory)
        val categories = listOf("Academic", "Social", "Health", "Personal", "Work")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCategory.adapter = adapter

        return view // Return the inflated layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize views after the layout has been inflated
        recyclerView = view.findViewById(R.id.recyclerViewTasks)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        taskAdapter = TaskAdapter(mutableListOf())
        recyclerView.adapter = taskAdapter

        btnAddTask = view.findViewById(R.id.btnAddTask)
        editTextTaskTitle = view.findViewById(R.id.editTextTaskTitle) // EditText for task title

        // Handle Add Task button click
        btnAddTask.setOnClickListener {
            val taskTitle = editTextTaskTitle.text.toString()
            val category = spinnerCategory.selectedItem.toString() // Get selected category

            if (taskTitle.isNotEmpty()) {
                val newTask = Task(taskTitle, category = category) // Create a new Task object
                tasksViewModel.addTask(newTask) // Add task to ViewModel
                editTextTaskTitle.text.clear() // Clear the input field
            }
        }

        // Observe task changes and update the RecyclerView
        tasksViewModel.tasks.observe(viewLifecycleOwner) { updatedTasks ->
            taskAdapter.updateTasks(updatedTasks)
        }
    }
}
