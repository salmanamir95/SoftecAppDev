package com.example.personalizedailifeassistant.PersonalizedDashboard.Reminders

import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.personalizedailifeassistant.R

class RemindersFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var reminderAdapter: ReminderAdapter
    private val reminderList = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_reminders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerViewReminders)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        reminderAdapter = ReminderAdapter(reminderList)
        recyclerView.adapter = reminderAdapter

        val btnAddReminder = view.findViewById<Button>(R.id.btnAddReminder)

        btnAddReminder.setOnClickListener {
            // Add new reminder (for now, just a static reminder)
            val newReminder = "New Reminder at ${System.currentTimeMillis()}"
            reminderList.add(newReminder)
            reminderAdapter.notifyItemInserted(reminderList.size - 1)
        }
    }
}