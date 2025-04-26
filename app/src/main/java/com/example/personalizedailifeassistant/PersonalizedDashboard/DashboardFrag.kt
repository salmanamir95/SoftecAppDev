package com.example.personalizedailifeassistant.PersonalizedDashboard
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.personalizedailifeassistant.R
import com.example.personalizedailifeassistant.PersonalizedDashboard.DailyPlanner.DailyPlannerFragment
import com.example.personalizedailifeassistant.PersonalizedDashboard.Mood.MoodFragment
import com.example.personalizedailifeassistant.PersonalizedDashboard.Reminders.RemindersFragment
import com.example.personalizedailifeassistant.PersonalizedDashboard.Schedule.ScheduleFragment
import com.example.personalizedailifeassistant.PersonalizedDashboard.Summaries.SummariesFragment
import com.example.personalizedailifeassistant.PersonalizedDashboard.Tasks.TasksFragment

class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Load all modules inside their container
        childFragmentManager.commit {
            replace(R.id.containerTasks, TasksFragment())
            replace(R.id.containerDailyPlanner, DailyPlannerFragment())
            replace(R.id.containerMood, MoodFragment())
            replace(R.id.containerReminders, RemindersFragment())
            replace(R.id.containerSchedule, ScheduleFragment())
            replace(R.id.containerSummaries, SummariesFragment())
        }
    }
}