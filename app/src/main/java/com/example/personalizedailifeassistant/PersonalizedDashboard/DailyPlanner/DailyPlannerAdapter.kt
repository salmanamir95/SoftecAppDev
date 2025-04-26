package com.example.personalizedailifeassistant.PersonalizedDashboard.DailyPlanner
import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.personalizedailifeassistant.R

class DailyPlannerAdapter(private val dailyPlans: List<DailyPlannerTask>) :
    RecyclerView.Adapter<DailyPlannerAdapter.DailyPlannerViewHolder>() {

    class DailyPlannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.tvTaskTitle)
        val timeTextView: TextView = itemView.findViewById(R.id.tvTaskTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyPlannerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_daily_plan, parent, false)
        return DailyPlannerViewHolder(view)
    }

    override fun onBindViewHolder(holder: DailyPlannerViewHolder, position: Int) {
        val task = dailyPlans[position]
        holder.titleTextView.text = task.title
        holder.timeTextView.text = task.time
    }

    override fun getItemCount(): Int = dailyPlans.size
}