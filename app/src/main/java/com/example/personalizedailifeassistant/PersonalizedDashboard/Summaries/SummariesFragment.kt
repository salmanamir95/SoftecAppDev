package com.example.personalizedailifeassistant.PersonalizedDashboard.Summaries

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.personalizedailifeassistant.R

class SummariesFragment : Fragment() {

    private lateinit var viewModel: SummaryViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SummaryAdapter
    private lateinit var editTextNote: EditText
    private lateinit var btnAddSummary: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_summaries, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ViewModel setup
        viewModel = ViewModelProvider(this).get(SummaryViewModel::class.java)

        // Initialize RecyclerView and Adapter
        recyclerView = view.findViewById(R.id.recyclerViewSummaries)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Initialize Button and EditText
        btnAddSummary = view.findViewById(R.id.btnAddSummary)
        editTextNote = view.findViewById(R.id.editTextNote)

        // Observe summaries from ViewModel
        viewModel.summaries.observe(viewLifecycleOwner) { summaries ->
            adapter = SummaryAdapter(summaries)
            recyclerView.adapter = adapter
        }

        // Button listener for generating summaries
        btnAddSummary.setOnClickListener {
            val noteText = editTextNote.text.toString()
            if (noteText.isNotEmpty()) {
                val bulletPoints = viewModel.generateSummaryFromText(noteText) // Generate summary as String
                viewModel.addSummary(bulletPoints) // Add summary to ViewModel
                editTextNote.text.clear() // Clear EditText after adding
            }
        }
    }
}
