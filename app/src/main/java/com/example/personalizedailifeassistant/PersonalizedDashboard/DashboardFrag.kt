package com.example.personalizedailifeassistant.PersonalizedDashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.personalizedailifeassistant.PersonalizedDashboard.DailyPlanner.DailyPlannerFragment
import com.example.personalizedailifeassistant.PersonalizedDashboard.Mood.MoodFragment
import com.example.personalizedailifeassistant.PersonalizedDashboard.Reminders.RemindersFragment
import com.example.personalizedailifeassistant.PersonalizedDashboard.Summaries.SummariesFragment
import com.example.personalizedailifeassistant.PersonalizedDashboard.Tasks.TasksViewModel
import com.example.personalizedailifeassistant.R
import com.example.personalizedailifeassistant.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: DashboardViewModel
    private lateinit var tasksViewModel: TasksViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
        tasksViewModel = ViewModelProvider(requireActivity()).get(TasksViewModel::class.java)

        setupQuickStats()
        setupSections()
        observeData()
    }

    private fun setupQuickStats() {
        // Example quick stats cards
        val quickStats = listOf(
            binding.cardTasks to "Pending Tasks",
            binding.cardDeadlines to "Upcoming Deadlines",
            binding.cardMood to "Current Mood",
            binding.cardReminders to "Active Reminders"
        )

        quickStats.forEach { (card, title) ->
            card.findViewById<TextView>(R.id.tvCardTitle).text = title
            card.setOnClickListener { handleQuickStatClick(title) }
        }
    }

    private fun setupSections() {
        val sectionAdapter = SectionAdapter(
            listOf(
                DashboardSection("Daily Planner", R.id.action_dashboard_to_dailyPlannerFragment),
                DashboardSection("Mood Tracking", R.id.action_dashboard_to_moodFragment),
                DashboardSection("Recent Reminders", R.id.action_dashboard_to_remindersFragment),
                DashboardSection("Latest Summaries", R.id.action_dashboard_to_summariesFragment)
            ),
            requireParentFragment()
        )

        binding.rvSections.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = sectionAdapter
        }
    }

    private fun observeData() {
        tasksViewModel.tasks.observe(viewLifecycleOwner) { tasks ->
            binding.cardTasks.findViewById<TextView>(R.id.tvCardValue).text = tasks.size.toString()
        }

        viewModel.currentMood.observe(viewLifecycleOwner) { mood ->
            binding.cardMood.findViewById<TextView>(R.id.tvCardValue).text = mood ?: "😊"
        }

        viewModel.upcomingDeadlines.observe(viewLifecycleOwner) { deadlines ->
            binding.cardDeadlines.findViewById<TextView>(R.id.tvCardValue).text = deadlines.size.toString()
        }
    }

    private fun handleQuickStatClick(title: String) {
        when (title) {
            "Pending Tasks" -> navigateToFragment(TasksFragment())
            "Upcoming Deadlines" -> navigateToFragment(DailyPlannerFragment())
            "Current Mood" -> navigateToFragment(MoodFragment())
            "Active Reminders" -> navigateToFragment(RemindersFragment())
        }
    }

    private fun navigateToFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

