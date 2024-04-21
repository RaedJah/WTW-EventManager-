package course.examples.ui.wtw.model;


data class Event(
    val id: String, // Unique identifier for the event
    val title: String, // The title of the event
    val description: String, // A description of the event
    val host: String, // The host or organizer of the event
    val imageUrl: String, // A URL or local resource for the event's image
    val time: String, // The time the event starts
    val location: String, // The location of the event
    val category: String, // Category to help with sorting or filtering events
    val isPrivate: Boolean // Whether the event is private or public
)