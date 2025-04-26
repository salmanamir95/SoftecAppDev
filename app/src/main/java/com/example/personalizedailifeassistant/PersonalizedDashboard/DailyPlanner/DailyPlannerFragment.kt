package com.example.personalizedailifeassistant.PersonalizedDashboard.DailyPlanner

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.personalizedailifeassistant.R

class DailyPlannerFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var dailyPlannerAdapter: DailyPlannerAdapter
    private val dailyPlanList = mutableListOf<DailyPlannerTask>() // <-- notice type change

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_daily_planner, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerViewDailyPlans)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        dailyPlannerAdapter = DailyPlannerAdapter(dailyPlanList)
        recyclerView.adapter = dailyPlannerAdapter

        val btnAddPlan = view.findViewById<Button>(R.id.btnAddPlan)
        btnAddPlan.setOnClickListener {
            showAddPlanDialog()
        }

        // Add dummy tasks
        dailyPlanList.add(DailyPlannerTask("Math Class", "10:00 AM"))
        dailyPlanList.add(DailyPlannerTask("Group Study", "2:00 PM"))
        dailyPlannerAdapter.notifyDataSetChanged()
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
                dailyPlanList.add(DailyPlannerTask(title, time))
                dailyPlannerAdapter.notifyItemInserted(dailyPlanList.size - 1)
            }
            dialog.dismiss()
        }

        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.cancel()
        }

        builder.show()
    }
}
