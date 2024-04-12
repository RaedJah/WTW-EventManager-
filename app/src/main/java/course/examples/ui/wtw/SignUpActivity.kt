package course.examples.ui.wtw

// SignUpActivity.kt
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        // Find views
        val createAccountButton = findViewById<Button>(R.id.createAccountButton)

        // Set OnClickListener for create account button
        createAccountButton.setOnClickListener {
            // Handle button click action here
            // You can implement the logic to create an account
            // For now, let's just go back to the previous activity
            onBackPressed()
        }
    }
}
