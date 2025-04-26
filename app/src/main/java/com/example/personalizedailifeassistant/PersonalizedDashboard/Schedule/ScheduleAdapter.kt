package com.example.personalizedailifeassistant.PersonalizedDashboard.Schedule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.personalizedailifeassistant.R

class ScheduleAdapter(private var scheduleList: List<ScheduleModel>) :
    RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>() {

    inner class ScheduleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvScheduleTitle: TextView = itemView.findViewById(R.id.tvScheduleTitle)
        val tvScheduleTime: TextView = itemView.findViewById(R.id.tvScheduleTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_schedule, parent, false)
        return ScheduleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        val schedule = scheduleList[position]
        holder.tvScheduleTitle.text = schedule.title
        holder.tvScheduleTime.text = schedule.time
    }

    override fun getItemCount(): Int {
        return scheduleList.size
    }

    fun updateList(newList: List<ScheduleModel>) {
        scheduleList = newList
        notifyDataSetChanged()
    }
}