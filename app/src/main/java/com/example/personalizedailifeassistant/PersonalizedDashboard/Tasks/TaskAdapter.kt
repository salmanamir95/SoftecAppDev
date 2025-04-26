package com.example.personalizedailifeassistant.PersonalizedDashboard.Tasks

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.personalizedailifeassistant.R
import android.view.LayoutInflater

class TaskAdapter(private val tasks: List<String>) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    // ViewHolder to hold the UI elements
    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val taskTextView: TextView = itemView.findViewById(R.id.tvTask)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.taskTextView.text = task
    }

    override fun getItemCount(): Int {
        return tasks.size
    }
}