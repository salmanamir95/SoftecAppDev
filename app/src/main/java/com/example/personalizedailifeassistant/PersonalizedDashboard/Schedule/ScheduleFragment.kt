package com.example.personalizedailifeassistant.PersonalizedDashboard.Schedule

import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.personalizedailifeassistant.R

class ScheduleFragment : Fragment() {

    private lateinit var scheduleAdapter: ScheduleAdapter
    private val scheduleViewModel: ScheduleViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_schedule, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnAddSchedule = view.findViewById<Button>(R.id.btnAddSchedule)
        val recyclerViewSchedule = view.findViewById<RecyclerView>(R.id.recyclerViewSchedule)

        // Setup RecyclerView
        scheduleAdapter = ScheduleAdapter(emptyList())
        recyclerViewSchedule.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewSchedule.adapter = scheduleAdapter

        // Observe LiveData
        scheduleViewModel.schedules.observe(viewLifecycleOwner) { schedules ->
            scheduleAdapter.updateList(schedules)
        }

        // Add dummy schedule on button click
        btnAddSchedule.setOnClickListener {
            scheduleViewModel.addSchedule(
                ScheduleModel(
                    title = "New Meeting",
                    time = "5:00 PM"
                )
            )
        }
    }
}