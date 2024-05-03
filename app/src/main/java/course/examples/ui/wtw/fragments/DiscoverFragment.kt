package course.examples.ui.wtw.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import course.examples.ui.wtw.R

class DiscoverFragment : Fragment() {

    private lateinit var buttonYoga: Button
    private lateinit var buttonSnowboarding: Button
    private lateinit var buttonDance: Button
    private lateinit var continueButton: Button
    private val selectedButtons = mutableSetOf<Button>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.discover_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize your buttons
        buttonYoga = view.findViewById(R.id.buttonYoga)
        buttonSnowboarding = view.findViewById(R.id.buttonSnowboarding)
        buttonDance = view.findViewById(R.id.buttonDance)
        continueButton = view.findViewById(R.id.continueButton)

        // Set click listeners to toggle selection
        setupButtonToggle(buttonYoga)
        setupButtonToggle(buttonSnowboarding)
        setupButtonToggle(buttonDance)

        // Set up continue button to navigate to CommunitiesFragment
        continueButton.setOnClickListener {
            if (selectedButtons.size < 3) {
                // Not enough buttons selected, show a toast message
                Toast.makeText(context, "Please select at least 3 hashtags to continue.", Toast.LENGTH_SHORT).show()
            } else {
                // Enough buttons selected, navigate to CommunitiesFragment
                val communitiesFragment = CommunitiesFragment()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, communitiesFragment)
                transaction.addToBackStack(null)
                transaction.commit()
            }
        }

    }

    private fun setupButtonToggle(button: Button) {
        button.setOnClickListener {
            if (selectedButtons.contains(button)) {
                // Button is selected, deselect it
                button.setBackgroundResource(R.drawable.edit_text_backgroundhashtag)
                selectedButtons.remove(button)
            } else {
                // Button is not selected, select it
                button.setBackgroundColor(
                    Color.MAGENTA)
                selectedButtons.add(button)
            }
        }
    }
}
