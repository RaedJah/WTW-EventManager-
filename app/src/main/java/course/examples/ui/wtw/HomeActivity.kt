package course.examples.ui.wtw



import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import course.examples.ui.wtw.fragments.*
import com.google.android.material.chip.Chip
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import course.examples.ui.wtw.adapter.EventAdapter
import course.examples.ui.wtw.fragments.*
import course.examples.ui.wtw.model.Event




@Suppress("DEPRECATION")
class HomeActivity : AppCompatActivity() {

        private lateinit var upcomingEventsRecyclerView: RecyclerView
        private lateinit var eventsAroundMeRecyclerView: RecyclerView
        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_home)







                val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
                bottomNavigationView.setOnNavigationItemSelectedListener { item ->
                        when (item.itemId) {
                                R.id.navigation_home -> {
                                        // Switch to the home fragment
                                        switchToFragment(HomeFragment())
                                        true
                                }
                                R.id.navigation_communities -> {
                                        // Switch to the communities fragment
                                        switchToFragment(CommunitiesFragment())
                                        true
                                }
                                R.id.navigation_create_event -> {
                                        // Switch to the create event fragment/activity
                                        switchToFragment(CreateEventFragment())
                                        true
                                }
                                R.id.navigation_calendar -> {
                                        // Switch to the calendar fragment
                                        switchToFragment(CalendarFragment())
                                        true
                                }
                                R.id.navigation_discover -> {
                                        // Switch to the discover fragment
                                        switchToFragment(DiscoverFragment())
                                        true
                                }
                                else -> false
                        }
                }

                // Set default selection
                bottomNavigationView.selectedItemId = R.id.navigation_home
        }

        private fun switchToFragment(fragment: Fragment) {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, fragment)
                transaction.commit()
        }
}
