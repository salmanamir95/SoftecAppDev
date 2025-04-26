package com.example.personalizedailifeassistant.PersonalizedDashboard.DailyPlanner

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import com.example.personalizedailifeassistant.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import androidx.fragment.app.activityViewModels
import java.util.Calendar

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
                // Show date picker dialog to allow the user to choose a date
                showDatePickerDialog { selectedDate ->
                    val task = DailyPlannerTask(title, time, selectedDate)
                    viewModel.addTask(task)
                    dismiss()
                }
            }
        }

    }
    private fun showDatePickerDialog(onDateSelected: (String) -> Unit) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, year, month, dayOfMonth ->
                val selectedDate = "$dayOfMonth/${month + 1}/$year"
                onDateSelected(selectedDate) // Pass selected date to the callback
            },
            year, month, dayOfMonth
        )
        datePickerDialog.show()
    }

}
