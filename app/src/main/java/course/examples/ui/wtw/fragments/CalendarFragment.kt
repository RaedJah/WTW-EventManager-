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
import androidx.lifecycle.ViewModelProvider
import course.examples.ui.wtw.model.Event
import course.examples.ui.wtw.viewmodels.EventViewModel

class CalendarFragment : Fragment() {

    private lateinit var datePicker: DatePicker
    private lateinit var addButton: Button
    private lateinit var viewModel: EventViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.calendar_fragment_layout, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(EventViewModel::class.java)

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

        // Create an Event object to be saved to Firestore
        val event = Event(
            id = UUID.randomUUID().toString(),
            title = "New Event",
            description = "Event Description",
            host = "System",  // Adjust based on user or system setting
            imageUrl = "",  // Adjust if you have an image
            time = "$year-${month + 1}-$day 09:00",
            location = "Event Location",
            category = "General",
            isPrivate = false
        )

        // Adding event to ViewModel which saves to Firebase
        viewModel.addEvent(event)

        // Insert event into the device's calendar
        val intent = Intent(Intent.ACTION_INSERT).apply {
            data = CalendarContract.Events.CONTENT_URI
            putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.timeInMillis)
            putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.timeInMillis)
            putExtra(CalendarContract.Events.TITLE, event.title)
            putExtra(CalendarContract.Events.DESCRIPTION, event.description)
            putExtra(CalendarContract.Events.EVENT_LOCATION, event.location)
            putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY)
        }

        startActivity(intent)
    }
}
