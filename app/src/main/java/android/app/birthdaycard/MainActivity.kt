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
    private var name: String = "Sam"
    private val images = arrayOf(
        R.drawable.cake,
        R.drawable.cake_2
    )

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
                imageView.setImageResource(images[randomPic()]);
                btn.text = "Close"
                age = randomAge()
                name = randomName()
                text.text = "Happy Birthday, $name $age !";
                imageView.visibility = View.VISIBLE
            }
        }
    }

    private fun randomAge(): Int {
        return Random.nextInt(1, 100);
    }

    private fun randomName(): String {
        val listName: List<String> = listOf("John", "Jane", "Oggy", "Boby", "Mike");
        val upperNames = listName.map { it.uppercase() }
        return upperNames[Random.nextInt(0, 5)]
    }

    private fun randomPic(): Int{
        return Random.nextInt(images.size);
    }
}