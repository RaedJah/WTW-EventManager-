package course.examples.ui.wtw.fragments

import android.widget.Button
import android.widget.DatePicker

import androidx.fragment.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.provider.CalendarContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import course.examples.ui.wtw.R
import java.util.*


class CalendarFragment : Fragment() {

    private lateinit var datePicker: DatePicker
    private lateinit var addButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.calendar_fragment_layout, container, false)

        datePicker = view.findViewById(R.id.datePicker)
        addButton = view.findViewById(R.id.addButton)

        addButton.setOnClickListener {
            addEventToCalendar()
        }

        return view
    }

    private fun addEventToCalendar() {
        val year = datePicker.year
        val month = datePicker.month
        val day = datePicker.dayOfMonth

        val beginTime = Calendar.getInstance().apply {
            set(year, month, day, 9, 0)
        }
        val endTime = Calendar.getInstance().apply {
            set(year, month, day, 10, 0)
        }

        val intent = Intent(Intent.ACTION_INSERT).apply {
            data = CalendarContract.Events.CONTENT_URI
            putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.timeInMillis)
            putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.timeInMillis)
            putExtra(CalendarContract.Events.TITLE, "New Event")
            putExtra(CalendarContract.Events.DESCRIPTION, "Event Description")
            putExtra(CalendarContract.Events.EVENT_LOCATION, "Event Location")
            putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY)
        }

        startActivity(intent)
    }
}