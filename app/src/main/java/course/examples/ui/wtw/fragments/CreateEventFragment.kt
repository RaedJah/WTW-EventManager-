package course.examples.ui.wtw.fragments



import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.fragment.app.Fragment
import course.examples.ui.wtw.R
import androidx.lifecycle.ViewModelProvider
import course.examples.ui.wtw.model.Event
import course.examples.ui.wtw.viewmodels.EventViewModel
import java.util.UUID

class CreateEventFragment : Fragment() {

    companion object {
        private const val IMAGE_PICK_REQUEST = 1001
    }

    private lateinit var viewModel: EventViewModel
    private lateinit var eventName: EditText
    private lateinit var eventDescription: EditText
    private lateinit var togglePrivatePublic: ToggleButton
    private lateinit var eventTime: EditText
    private lateinit var continueButton: Button
    private lateinit var uploadThumbnailButton: Button
    private lateinit var imageViewThumbnail: ImageView
    private var imageUri: Uri? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.create_event_layout, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(EventViewModel::class.java)

        eventName = view.findViewById(R.id.event_name)
        eventDescription = view.findViewById(R.id.event_description)
        togglePrivatePublic = view.findViewById(R.id.public_private_button)
        eventTime = view.findViewById(R.id.event_time)
        continueButton = view.findViewById(R.id.continue_button)
        uploadThumbnailButton = view.findViewById(R.id.button_upload_thumbnail)
        imageViewThumbnail = view.findViewById(R.id.image_thumbnail)

        setupListeners()
        return view
    }

    private fun setupListeners() {
        continueButton.setOnClickListener { createEvent() }
        uploadThumbnailButton.setOnClickListener { openImagePicker() }
    }

    private fun createEvent() {
        val name = eventName.text.toString()
        val description = eventDescription.text.toString()
        val isPublic = togglePrivatePublic.isChecked
        val time = eventTime.text.toString()

        if (validateInput(name, description, time)) {
            val event = Event(
                id = UUID.randomUUID().toString(),
                title = name,
                description = description,
                host = "Host Username or ID", // Adjust as needed
                imageUrl = imageUri.toString(), // Handle image URL properly if using Firebase Storage
                time = time,
                location = "Specify Location", // Add field for location if required
                category = "Specify Category", // Add field for category selection if required
                isPrivate = isPublic
            )
            viewModel.addEvent(event)
            Toast.makeText(context, "Event Created: $name", Toast.LENGTH_SHORT).show()
            clearForm()
        } else {
            Toast.makeText(context, "Please fill all fields correctly", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validateInput(name: String, description: String, time: String): Boolean {
        return name.isNotEmpty() && description.isNotEmpty() && time.isNotEmpty()
    }

    private fun openImagePicker() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI).apply {
            type = "image/*"
        }
        startActivityForResult(intent, IMAGE_PICK_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_PICK_REQUEST && resultCode == Activity.RESULT_OK) {
            imageUri = data?.data
            imageViewThumbnail.setImageURI(imageUri)
        }
    }

    private fun clearForm() {
        eventName.setText("")
        eventDescription.setText("")
        eventTime.setText("")
        togglePrivatePublic.isChecked = false
        imageViewThumbnail.setImageResource(0) // Reset or set to a default image
    }
}
