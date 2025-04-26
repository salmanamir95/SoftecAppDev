package com.example.personalizedailifeassistant.PersonalizedDashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.personalizedailifeassistant.R

class DashboardFrag: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Add the individual section fragments dynamically to the dashboard
        loadFragment(TasksFragment(), R.id.containerTasks)
        loadFragment(ScheduleFragment(), R.id.containerSchedule)
        loadFragment(MoodFragment(), R.id.containerMood)
        loadFragment(RemindersFragment(), R.id.containerReminders)
        loadFragment(SummariesFragment(), R.id.containerSummaries)
    }

    private fun loadFragment(fragment: Fragment, containerId: Int) {
        val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
        transaction.replace(containerId, fragment)
        transaction.addToBackStack(null) // Allows back navigation
        transaction.commit()
    }
}