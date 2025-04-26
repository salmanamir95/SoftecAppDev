package com.example.personalizedailifeassistant.PersonalizedDashboard.Schedule

import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.personalizedailifeassistant.R

class ScheduleFragment : Fragment() {

    private lateinit var viewModel: ScheduleViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ScheduleAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_schedule, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ScheduleViewModel::class.java)
        recyclerView = view.findViewById(R.id.recyclerViewSchedule)
        val btnAddSchedule = view.findViewById<Button>(R.id.btnAddSchedule)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.schedules.observe(viewLifecycleOwner) { schedules ->
            adapter = ScheduleAdapter(schedules)
            recyclerView.adapter = adapter
        }

        btnAddSchedule.setOnClickListener {
            val newSchedule = "New Schedule at ${System.currentTimeMillis()}"
            viewModel.addSchedule(newSchedule)
        }
    }
}