package com.example.personalizedailifeassistant.PersonalizedDashboard.DailyPlanner

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import com.example.personalizedailifeassistant.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import androidx.fragment.app.activityViewModels

class AddTaskBottomSheetFragment : BottomSheetDialogFragment() {

    private val viewModel: DailyPlannerViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_add_task_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val edtTitle = view.findViewById<EditText>(R.id.edtTaskTitle)
        val edtTime = view.findViewById<EditText>(R.id.edtTaskTime)
        val btnSave = view.findViewById<Button>(R.id.btnSaveTask)

        btnSave.setOnClickListener {
            val title = edtTitle.text.toString()
            val time = edtTime.text.toString()
            if (title.isNotEmpty() && time.isNotEmpty()) {
                viewModel.addTask(DailyPlannerTask(title, time))
                dismiss()
            }
        }
    }
}