
package course.examples.ui.wtw
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import com.google.firebase.auth.FirebaseAuth

class CommunityMembers : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.community_members)

        val listView: ListView = findViewById(R.id.listView)
        val names = mutableListOf("Honorine K", "Sam Fox", "Jah Jah", "Raina Samuel")  // Mutable example names
        val adapter = MembersAdapter(this, names)
        listView.adapter = adapter

    }
}

