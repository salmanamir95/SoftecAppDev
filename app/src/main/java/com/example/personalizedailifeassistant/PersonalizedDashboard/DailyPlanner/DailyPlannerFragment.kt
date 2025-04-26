package com.example.personalizedailifeassistant.PersonalizedDashboard.DailyPlanner

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.personalizedailifeassistant.R

class DailyPlannerFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var dailyPlannerAdapter: DailyPlannerAdapter
    private lateinit var viewModel: DailyPlannerViewModel // ViewModel instance

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_daily_planner, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize ViewModel
        viewModel = ViewModelProvider(requireActivity()).get(DailyPlannerViewModel::class.java)

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerViewDailyPlans)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Initialize Adapter with empty list (will be updated by ViewModel)
        dailyPlannerAdapter = DailyPlannerAdapter(emptyList())
        recyclerView.adapter = dailyPlannerAdapter

        // Observe LiveData from ViewModel
        viewModel.tasks.observe(viewLifecycleOwner) { tasks ->
            // When the task list changes, update the adapter
            dailyPlannerAdapter = DailyPlannerAdapter(tasks)
            recyclerView.adapter = dailyPlannerAdapter
        }

        // Button to add new task
        val btnAddPlan = view.findViewById<Button>(R.id.btnAddPlan)
        btnAddPlan.setOnClickListener {
            showAddPlanDialog()
        }

        // Add initial dummy tasks via ViewModel (this can be done via ViewModel if necessary)
        // viewModel.addTask(DailyPlannerTask("Math Class", "10:00 AM"))
        // viewModel.addTask(DailyPlannerTask("Group Study", "2:00 PM"))
    }

    private fun showAddPlanDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Add New Plan")

        val layout = LinearLayout(requireContext())
        layout.orientation = LinearLayout.VERTICAL

        val titleInput = EditText(requireContext())
        titleInput.hint = "Enter task title"
        layout.addView(titleInput)

        val timeInput = EditText(requireContext())
        timeInput.hint = "Enter task time (eg: 10:00 AM)"
        layout.addView(timeInput)

        builder.setView(layout)

        builder.setPositiveButton("Add") { dialog, _ ->
            val title = titleInput.text.toString()
            val time = timeInput.text.toString()
            if (title.isNotEmpty() && time.isNotEmpty()) {
                // Add task via ViewModel
                viewModel.addTask(DailyPlannerTask(title, time))
            }
            dialog.dismiss()
        }

        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.cancel()
        }

        builder.show()
    }
}
