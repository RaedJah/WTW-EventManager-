package course.examples.ui.wtw



import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import course.examples.ui.wtw.fragments.*

@Suppress("DEPRECATION")
class HomeActivity : AppCompatActivity() {
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
