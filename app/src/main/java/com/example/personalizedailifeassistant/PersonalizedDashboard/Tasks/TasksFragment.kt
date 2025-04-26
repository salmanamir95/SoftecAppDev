package com.example.personalizedailifeassistant.PersonalizedDashboard.Tasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.personalizedailifeassistant.R

class TasksFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Example of dynamic data setting
        val tasksTextView: TextView = view.findViewById(R.id.tvTasks)
        tasksTextView.text = "Complete project report, attend meeting."
    }
}