package com.example.personalizedailifeassistant.PersonalizedDashboard.DailyPlanner

import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.personalizedailifeassistant.R

class DailyPlannerAdapter(private var dailyPlans: List<DailyPlannerTask>) :
    RecyclerView.Adapter<DailyPlannerAdapter.DailyPlannerViewHolder>() {

    class DailyPlannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val taskTitle: TextView = itemView.findViewById(R.id.tvTaskTitle)
        val taskTime: TextView = itemView.findViewById(R.id.tvTaskTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyPlannerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_daily_plan, parent, false)
        return DailyPlannerViewHolder(view)
    }

    override fun onBindViewHolder(holder: DailyPlannerViewHolder, position: Int) {
        val task = dailyPlans[position]
        holder.taskTitle.text = task.title
        holder.taskTime.text = task.time
    }

    override fun getItemCount(): Int = dailyPlans.size

    // Method to update the tasks in the adapter
    fun updateTasks(newTasks: List<DailyPlannerTask>) {
        val diffCallback = TaskDiffCallback(dailyPlans, newTasks)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        dailyPlans = newTasks
        diffResult.dispatchUpdatesTo(this) // Apply the changes
    }
}
