package com.example.personalizedailifeassistant.PersonalizedDashboard.Summaries

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.personalizedailifeassistant.R

class SummariesAdapter(private var summaryList: List<SummaryModel>) :
    RecyclerView.Adapter<SummariesAdapter.SummaryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SummaryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_summary, parent, false)
        return SummaryViewHolder(view)
    }

    override fun onBindViewHolder(holder: SummaryViewHolder, position: Int) {
        val summary = summaryList[position]
        holder.bind(summary)
    }

    override fun getItemCount() = summaryList.size

    fun updateList(newList: List<SummaryModel>) {
        summaryList = newList
        notifyDataSetChanged()
    }

    class SummaryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvSummary: TextView = itemView.findViewById(R.id.tvSummaryText)

        fun bind(summary: SummaryModel) {
            tvSummary.text = summary.summaryText
        }
    }
}