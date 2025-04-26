package com.example.personalizedailifeassistant.PersonalizedDashboard.DailyPlanner

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.personalizedailifeassistant.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.recyclerview.widget.RecyclerView

class DailyPlannerFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DailyPlannerAdapter
    private val viewModel: DailyPlannerViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_daily_planner, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerViewDailyPlanner)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = DailyPlannerAdapter()
        recyclerView.adapter = adapter

        viewModel.tasks.observe(viewLifecycleOwner) { tasks ->
            adapter.updateTasks(tasks)
        }

        val fabAddTask = view.findViewById<FloatingActionButton>(R.id.fabAddTask)
        fabAddTask.setOnClickListener {
            val bottomSheet = AddTaskBottomSheetFragment()
            bottomSheet.show(parentFragmentManager, "AddTaskBottomSheetFragment")
        }
    }
}
