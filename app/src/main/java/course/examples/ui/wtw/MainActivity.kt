package course.examples.ui.wtw
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.front_page)

        // Set custom font for WTW label
        val wtwLabel = findViewById<TextView>(R.id.wtwLabel)
        //val fancyFont = Typeface.createFromAsset(assets, "your_fancy_font.ttf")
        //wtwLabel.typeface = fancyFont

        // Set custom font for Welcome text
        val welcomeText = findViewById<TextView>(R.id.welcomeText)
        //welcomeText.typeface = fancyFont

        // Get references to email and password EditText fields
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val emailEditText: EditText = findViewById(R.id.emailEditText)
        emailEditText.setTextColor(Color.parseColor("#FFFF00")) // Set text color to yellow


        // Get reference to login button
        val loginButton = findViewById<Button>(R.id.loginButton)
        // In your FrontPageActivity
        val signUpButton = findViewById<Button>(R.id.signUpButton)
        signUpButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }


        // Set OnClickListener for login button
        loginButton.setOnClickListener {
            // Perform login authentication here
        }
    }
}


/*import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import course.examples.ui.wtw.ui.theme.WTWTheme
import android.content.Intent


class MainActivity : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var forgotPasswordText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.front_page)

        // Initialize views
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)
        forgotPasswordText = findViewById(R.id.forgotPasswordText)

        // Set onClickListener for login button
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            // Perform validation
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            } else {
                // TODO: Implement login functionality
                // Here, you can call a login function or navigate to another activity
                // based on the entered email and password
            }
        }

        // Set onClickListener for forgot password text
        forgotPasswordText.setOnClickListener {
            // TODO: Implement forgot password functionality
            // Here, you can navigate to a screen where users can reset their password
        }
    }
}*/



/*class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.front_page)

        // Set OnClickListener for the login button
        val loginButton = findViewById<Button>(R.id.login_button)
        loginButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}*/
/*import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import course.examples.ui.wtw.R.id.textView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the TextView by its ID
        val textView = findViewById<TextView>(textView)

        // Set the text of the TextView
        textView.text = "Hello, World!"
    }
}*/