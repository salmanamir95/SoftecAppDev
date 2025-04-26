package com.example.personalizedailifeassistant.PersonalizedDashboard.Summaries

import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.personalizedailifeassistant.R

class SummariesFragment : Fragment() {

    private lateinit var viewModel: SummaryViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SummaryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_summaries, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(SummaryViewModel::class.java)
        recyclerView = view.findViewById(R.id.recyclerViewSummaries)
        val btnAddSummary = view.findViewById<Button>(R.id.btnAddSummary)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.summaries.observe(viewLifecycleOwner) { summaries ->
            adapter = SummaryAdapter(summaries)
            recyclerView.adapter = adapter
        }

        btnAddSummary.setOnClickListener {
            val newSummary = "New summary at ${System.currentTimeMillis()}"
            viewModel.addSummary(newSummary)
        }
    }
}


