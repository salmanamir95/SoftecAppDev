package com.example.personalizedailifeassistant.PersonalizedDashboard.Mood

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.personalizedailifeassistant.R
import java.text.SimpleDateFormat
import java.util.*

class MoodHistoryAdapter(private val moodLogs: MutableList<MoodLog>) :
    RecyclerView.Adapter<MoodHistoryAdapter.MoodViewHolder>() {

    // ViewHolder for each mood history item
    class MoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvMood: TextView = itemView.findViewById(R.id.tvMood)
        val tvTimestamp: TextView = itemView.findViewById(R.id.tvMoodTimestamp)
    }

    // Called when a new ViewHolder is created
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mood, parent, false)
        return MoodViewHolder(view)
    }

    // Binds mood and timestamp to ViewHolder
    override fun onBindViewHolder(holder: MoodViewHolder, position: Int) {
        val moodLog = moodLogs[position]
        holder.tvMood.text = moodLog.mood
        holder.tvTimestamp.text = formatTimestamp(moodLog.timestamp)
    }

    // Returns total items
    override fun getItemCount(): Int = moodLogs.size

    // Called when mood list changes
    fun updateMoodHistory(newMoods: List<MoodLog>) {
        moodLogs.clear()
        moodLogs.addAll(newMoods)
        notifyDataSetChanged()
    }

    // Helper to format timestamp to readable string
    private fun formatTimestamp(timestamp: String): String {
        return try {
            val date = Date(timestamp.toLong())
            val format = SimpleDateFormat("MMM dd, yyyy - hh:mm a", Locale.getDefault())
            format.format(date)
        } catch (e: Exception) {
            "Invalid time"
        }
    }
}
