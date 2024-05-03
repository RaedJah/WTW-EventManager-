package course.examples.ui.wtw.viewmodels;


import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import course.examples.ui.wtw.model.Event
import course.examples.ui.wtw.repository.EventRepository
import kotlinx.coroutines.launch

class EventViewModel : ViewModel() {
    private val repository = EventRepository()
    val eventsLiveData = MutableLiveData<List<Event>>()

    fun addEvent(event: Event) {
        viewModelScope.launch {
            repository.addEventToFirestore(event) { isSuccess ->
                if (isSuccess) {
                    fetchEvents()
                }
            }
        }
    }
    fun fetchEvents() {
        viewModelScope.launch {
            repository.getEventsFromFirestore { events ->
                eventsLiveData.value = events
            }
        }
    }
}
