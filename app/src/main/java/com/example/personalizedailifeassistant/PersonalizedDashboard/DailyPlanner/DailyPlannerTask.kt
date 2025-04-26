package com.example.personalizedailifeassistant.PersonalizedDashboard.DailyPlanner

data class DailyPlannerTask(
    val title: String,
    val time: String,
    val date: String // Add a date field to link tasks to specific dates
)
