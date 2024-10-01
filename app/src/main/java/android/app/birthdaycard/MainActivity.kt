package android.app.birthdaycard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var age: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.img)
        val text = findViewById<TextView>(R.id.text);
        val btn = findViewById<Button>(R.id.btn)

        btn.setOnClickListener {
            if (imageView.visibility == View.VISIBLE) {
                imageView.visibility = View.GONE
                btn.text = "Open"
            } else {
                btn.text = "Close"
                age = randomAge()
                text.text = "Happy Birthday, Sam $age !";
                imageView.visibility = View.VISIBLE
            }
        }
    }

    fun randomAge(): Int {
        return Random.nextInt(1, 100);
    }


}