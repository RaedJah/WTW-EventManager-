package course.examples.ui.wtw.repository;


import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import course.examples.ui.wtw.model.Event
import kotlinx.coroutines.tasks.await

class EventRepository {
    private val db = FirebaseFirestore.getInstance()

    suspend fun addEventToFirestore(event: Event, callback: (Boolean) -> Unit) {
        try {
            db.collection("events").add(event).await()
            callback(true)
        } catch (e: Exception) {
            callback(false)
        }
    }

    suspend fun getEventsFromFirestore(callback: (List<Event>) -> Unit) {
        try {
            val result = db.collection("events").get().await()
            val events = result.map { document ->
                document.toObject<Event>()
            }
            callback(events)
        } catch (e: Exception) {
            callback(emptyList())
        }
    }
}
