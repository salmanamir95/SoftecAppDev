package com.example.personalizedailifeassistant.PersonalizedDashboard.DailyPlanner

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.personalizedailifeassistant.R

class DailyPlannerFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dailyPlannerAdapter: DailyPlannerAdapter
    private lateinit var viewModel: DailyPlannerViewModel
    private val sharedViewModel: CalendarSharedViewModel by activityViewModels() // Shared ViewModel

    private var selectedDate: String? = null // Store selected date

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_daily_planner, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize ViewModel
        viewModel = ViewModelProvider(requireActivity()).get(DailyPlannerViewModel::class.java)

        recyclerView = view.findViewById(R.id.recyclerViewDailyPlans)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        dailyPlannerAdapter = DailyPlannerAdapter(emptyList())
        recyclerView.adapter = dailyPlannerAdapter

        // Observe selected date from the shared ViewModel
        sharedViewModel.selectedDate.observe(viewLifecycleOwner) { date ->
            selectedDate = date
            // Filter tasks based on the selected date
            viewModel.filterTasksByDate(date)
        }

        // Observe the task list
        viewModel.tasks.observe(viewLifecycleOwner) { tasks ->
            dailyPlannerAdapter.updateTasks(tasks)
        }

        // Add button listener to show the Add Task dialog
        val btnAddPlan = view.findViewById<Button>(R.id.btnAddPlan)
        btnAddPlan.setOnClickListener {
            showAddPlanDialog()
        }
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
        timeInput.hint = "Enter task time (e.g., 10:00 AM)"
        layout.addView(timeInput)

        builder.setView(layout)

        builder.setPositiveButton("Add") { dialog, _ ->
            val title = titleInput.text.toString()
            val time = timeInput.text.toString()
            if (title.isNotEmpty() && time.isNotEmpty() && selectedDate != null) {
                val task = DailyPlannerTask(title, time, selectedDate!!)
                viewModel.addTask(task)
            }
            dialog.dismiss()
        }

        builder.setNegativeButton("Cancel") { dialog, _ -> dialog.cancel() }
        builder.show()
    }
}
