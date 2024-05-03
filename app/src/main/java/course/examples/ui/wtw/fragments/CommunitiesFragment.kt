package course.examples.ui.wtw.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.fragment.app.Fragment
import course.examples.ui.wtw.CommunityMembers
import course.examples.ui.wtw.HomeActivity
import course.examples.ui.wtw.R

class CommunitiesFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonRave = view.findViewById<Button>(R.id.buttonRave)
        buttonRave.setOnClickListener {
            // Navigate to CommunityMembersFragment
            goToCommunityMembersFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.communities_fragment, container, false)
    }


    private fun goToCommunityMembersFragment() {
        val intent = Intent(activity, CommunityMembers::class.java)
        startActivity(intent)
    }


}

