package com.example.personalizedailifeassistant.PersonalizedDashboard.DailyPlanner
import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.personalizedailifeassistant.R

class DailyPlannerAdapter : RecyclerView.Adapter<DailyPlannerAdapter.TaskViewHolder>() {

    private var tasks: List<DailyPlannerTask> = listOf()

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tvTaskTitle)
        val time: TextView = itemView.findViewById(R.id.tvTaskTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_daily_planner_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int = tasks.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.title.text = task.title
        holder.time.text = task.time
    }

    fun updateTasks(newTasks: List<DailyPlannerTask>) {
        tasks = newTasks
        notifyDataSetChanged()
    }
}