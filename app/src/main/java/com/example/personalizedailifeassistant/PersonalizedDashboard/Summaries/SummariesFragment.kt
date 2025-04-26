import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.personalizedailifeassistant.PersonalizedDashboard.Summaries.SummariesAdapter
import com.example.personalizedailifeassistant.PersonalizedDashboard.Summaries.SummariesViewModel
import com.example.personalizedailifeassistant.PersonalizedDashboard.Summaries.SummaryModel
import com.example.personalizedailifeassistant.R

class SummariesFragment : Fragment() {

    private lateinit var summariesAdapter: SummariesAdapter
    private val summariesViewModel: SummariesViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_summaries, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnAddSummary = view.findViewById<Button>(R.id.btnAddSummary)
        val recyclerViewSummaries = view.findViewById<RecyclerView>(R.id.recyclerViewSummaries)

        summariesAdapter = SummariesAdapter(emptyList())
        recyclerViewSummaries.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewSummaries.adapter = summariesAdapter

        summariesViewModel.summaries.observe(viewLifecycleOwner) { summaries ->
            summariesAdapter.updateList(summaries)
        }

        btnAddSummary.setOnClickListener {
            summariesViewModel.addSummary(
                SummaryModel("You completed 5 tasks and improved mood today!")
            )
        }
    }
}