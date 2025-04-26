package com.example.personalizedailifeassistant.PersonalizedDashboard.Mood

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.personalizedailifeassistant.R

class MoodHistoryAdapter(private var moodHistory: MutableList<String>) :
    RecyclerView.Adapter<MoodHistoryAdapter.MoodViewHolder>() {

    class MoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvMoodHistory: TextView = itemView.findViewById(R.id.tvMoodHistory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mood, parent, false)
        return MoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoodViewHolder, position: Int) {
        holder.tvMoodHistory.text = moodHistory[position] // Bind data to the view
    }

    override fun getItemCount(): Int = moodHistory.size

    // Update the RecyclerView data
    fun updateMoodHistory(newMoodHistory: List<String>) {
        moodHistory.clear()
        moodHistory.addAll(newMoodHistory)
        notifyDataSetChanged()
    }
}