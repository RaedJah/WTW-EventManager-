package course.examples.ui.wtw.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import course.examples.ui.wtw.R
import course.examples.ui.wtw.adapter.EventAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import course.examples.ui.wtw.viewmodels.EventViewModel

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var eventAdapter: EventAdapter
    private lateinit var viewModel: EventViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.home_fragment_layout, container, false)

        // Initialize ViewModel
        viewModel = ViewModelProvider(requireActivity())[EventViewModel::class.java]

        // Setup RecyclerView
        recyclerView = view.findViewById(R.id.events_around_me_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)
        eventAdapter = EventAdapter(emptyList())  // Initialize with empty list
        recyclerView.adapter = eventAdapter

        observeEvents()

        return view
    }

    private fun observeEvents() {
        // Observing the LiveData from ViewModel which holds the list of events
        viewModel.eventsLiveData.observe(viewLifecycleOwner) { events ->
            // Update the adapter's data when the list of events changes
            eventAdapter.updateEvents(events)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchEvents()  // Fetch events when the fragment view is created
    }
}
