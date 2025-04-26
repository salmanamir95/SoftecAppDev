package com.example.personalizedailifeassistant.PersonalizedDashboard

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.personalizedailifeassistant.PersonalizedDashboard.DailyPlanner.DailyPlannerAdapter
import com.example.personalizedailifeassistant.R

class DailyPlannerFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var dailyPlannerAdapter: DailyPlannerAdapter
    private val dailyPlanList = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_daily_planner, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerViewDailyPlans)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        dailyPlannerAdapter = DailyPlannerAdapter(dailyPlanList)
        recyclerView.adapter = dailyPlannerAdapter

        // Temporary Static Example
        dailyPlanList.add("Math Class at 10 AM")
        dailyPlanList.add("Group Study at 2 PM")
        dailyPlannerAdapter.notifyDataSetChanged()
    }
}