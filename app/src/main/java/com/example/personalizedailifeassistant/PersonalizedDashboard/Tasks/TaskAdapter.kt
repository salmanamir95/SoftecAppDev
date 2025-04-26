package com.example.personalizedailifeassistant.PersonalizedDashboard.Tasks

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.personalizedailifeassistant.R
import android.view.LayoutInflater

class TaskAdapter(private val tasks: MutableList<Task>) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val taskTextView: TextView = itemView.findViewById(R.id.tvTask)
        val taskCategoryTextView: TextView = itemView.findViewById(R.id.tvTaskCategory) // Add a TextView for category
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.taskTextView.text = task.title
        holder.taskCategoryTextView.text = task.category // Set category text
    }

    override fun getItemCount(): Int = tasks.size

    // Update the list of tasks
    fun updateTasks(newTasks: List<Task>) {
        tasks.clear()
        tasks.addAll(newTasks)
        notifyDataSetChanged()
    }
}
