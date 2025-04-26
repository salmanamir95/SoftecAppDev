package com.example.personalizedailifeassistant.PersonalizedDashboard.Mood

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.personalizedailifeassistant.R


class MoodHistoryAdapter(private val moodList: List<String>) : RecyclerView.Adapter<MoodHistoryAdapter.MoodViewHolder>() {

    // ViewHolder for mood items
    class MoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val moodTextView: TextView = itemView.findViewById(R.id.tvMoodHistory)
    }

    // Create a new ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mood_history, parent, false)
        return MoodViewHolder(view)
    }

    // Bind the data to the view
    override fun onBindViewHolder(holder: MoodViewHolder, position: Int) {
        val mood = moodList[position]
        holder.moodTextView.text = mood
    }

    // Return the number of items in the list
    override fun getItemCount(): Int = moodList.size
}