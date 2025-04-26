package com.example.personalizedailifeassistant.PersonalizedDashboard.Mood

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.personalizedailifeassistant.R

class MoodHistoryAdapter : RecyclerView.Adapter<MoodHistoryAdapter.MoodViewHolder>() {

    private var moodHistoryList: List<String> = listOf()

    fun submitList(list: List<String>) {
        moodHistoryList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mood, parent, false)
        return MoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoodViewHolder, position: Int) {
        val mood = moodHistoryList[position]
        holder.bind(mood)
    }

    override fun getItemCount(): Int = moodHistoryList.size

    class MoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val moodTextView: TextView = itemView.findViewById(R.id.tvMoodHistory)

        fun bind(mood: String) {
            moodTextView.text = mood
        }
    }
}
