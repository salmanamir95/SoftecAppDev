package com.example.personalizedailifeassistant.PersonalizedDashboard.DailyPlanner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.personalizedailifeassistant.R
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import java.util.*

class CalendarFragment : Fragment() {

    private lateinit var calendarView: MaterialCalendarView
    private val sharedViewModel: CalendarSharedViewModel by activityViewModels() // Shared ViewModel between fragments

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_calendar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        calendarView = view.findViewById(R.id.calendarView)

        // Correct way: Set today as selected
        calendarView.selectedDate = CalendarDay.today()

        // Date selected listener
        calendarView.setOnDateChangedListener { _, date, _ ->
            val selectedDate = "${date.day}/${date.month + 1}/${date.year}"
            // Update the selected date in the shared ViewModel
            sharedViewModel.setSelectedDate(selectedDate)
        }
    }
}
