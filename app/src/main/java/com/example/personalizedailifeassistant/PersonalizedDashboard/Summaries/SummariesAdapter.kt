package com.example.personalizedailifeassistant.PersonalizedDashboard.Summaries


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.personalizedailifeassistant.R

class SummaryAdapter(private val summaries: List<Summary>) : RecyclerView.Adapter<SummaryAdapter.SummaryViewHolder>() {

    class SummaryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvSummaryItem: TextView = view.findViewById(R.id.tvSummaryItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SummaryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_summary, parent, false)
        return SummaryViewHolder(view)
    }

    override fun onBindViewHolder(holder: SummaryViewHolder, position: Int) {
        holder.tvSummaryItem.text = summaries[position].content
    }

    override fun getItemCount(): Int = summaries.size
}

