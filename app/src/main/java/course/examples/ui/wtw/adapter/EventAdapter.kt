package course.examples.ui.wtw.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import course.examples.ui.wtw.R
import course.examples.ui.wtw.model.Event
import com.bumptech.glide.Glide



class EventAdapter(private var events: List<Event>) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.event_title)
        private val hostTextView: TextView = itemView.findViewById(R.id.event_host)
        private val imageView: ImageView = itemView.findViewById(R.id.event_image)
        private val timeTextView: TextView = itemView.findViewById(R.id.event_time)

        fun bind(event: Event) {
            titleTextView.text = event.title
            hostTextView.text = event.host
            timeTextView.text = event.time
            // Use Glide to load the image
            Glide.with(itemView.context)
                .load(event.imageUrl)
                .into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(events[position])
    }

    override fun getItemCount() = events.size

    fun updateEvents(newEvents: List<Event>) {
        this.events = newEvents
        notifyDataSetChanged()
    }
}
