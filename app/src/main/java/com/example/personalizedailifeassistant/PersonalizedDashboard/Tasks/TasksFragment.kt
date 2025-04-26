package com.example.personalizedailifeassistant.PersonalizedDashboard.Tasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.personalizedailifeassistant.R

class TasksFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var taskAdapter: TaskAdapter
    private val taskList = mutableListOf("Complete project report", "Attend meeting")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerViewTasks)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        taskAdapter = TaskAdapter(taskList)
        recyclerView.adapter = taskAdapter

        val btnAddTask = view.findViewById<Button>(R.id.btnAddTask)

        btnAddTask.setOnClickListener {
            val newTask = "New Task at ${System.currentTimeMillis() % 10000}"
            taskList.add(newTask)
            taskAdapter.notifyItemInserted(taskList.size - 1)
        }
    }
}
