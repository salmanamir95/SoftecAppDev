package com.example.personalizedailifeassistant.PersonalizedDashboard.DailyPlanner

import androidx.recyclerview.widget.DiffUtil

class TaskDiffCallback(
    private val oldList: List<DailyPlannerTask>,
    private val newList: List<DailyPlannerTask>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size
    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].title == newList[newItemPosition].title
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}