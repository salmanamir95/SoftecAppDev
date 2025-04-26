package com.example.personalizedailifeassistant.PersonalizedDashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.personalizedailifeassistant.R

// Adapter for Dashboard Sections
class SectionAdapter(
    private val sections: List<DashboardSection>,
    private val navHost: Fragment
) : RecyclerView.Adapter<SectionAdapter.SectionViewHolder>() {

    inner class SectionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvSectionTitle: TextView = view.findViewById(R.id.tvSectionTitle)
        private val rvSectionContent: RecyclerView = view.findViewById(R.id.rvSectionContent)
        private val tvSeeAll: TextView = view.findViewById(R.id.tvSeeAll)

        fun bind(section: DashboardSection) {
            tvSectionTitle.text = section.title
            tvSeeAll.setOnClickListener { navHost.parentFragmentManager.navigate(section.navigationAction) }

            when (section.title) {
                "Daily Planner" -> setupDailyPlanner()
                "Mood Tracking" -> setupMoodTracking()
                "Recent Reminders" -> setupReminders()
                "Latest Summaries" -> setupSummaries()
            }
        }

        private fun setupDailyPlanner() {
            rvSectionContent.layoutManager = LinearLayoutManager(itemView.context,
                LinearLayoutManager.HORIZONTAL, false)
            // Add actual adapter for daily planner items
        }

        private fun setupMoodTracking() {
            rvSectionContent.layoutManager = LinearLayoutManager(itemView.context,
                LinearLayoutManager.HORIZONTAL, false)
            // Add actual adapter for mood entries
        }

        private fun setupReminders() {
            rvSectionContent.layoutManager = LinearLayoutManager(itemView.context,
                LinearLayoutManager.HORIZONTAL, false)
            // Add actual adapter for reminders
        }

        private fun setupSummaries() {
            rvSectionContent.layoutManager = LinearLayoutManager(itemView.context,
                LinearLayoutManager.HORIZONTAL, false)
            // Add actual adapter for summaries
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dashboard_section, parent, false)
        return SectionViewHolder(view)
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        holder.bind(sections[position])
    }

    override fun getItemCount() = sections.size
}
