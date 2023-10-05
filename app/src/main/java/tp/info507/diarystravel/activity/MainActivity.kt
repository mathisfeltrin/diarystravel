package tp.info507.diarystravel.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import tp.info507.diarystravel.R
import tp.info507.diarystravel.adapter.TravelAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button:ImageButton = findViewById<ImageButton>(R.id.addButton)

        button.setOnClickListener {
            Toast.makeText(applicationContext, "Coucou !", Toast.LENGTH_SHORT).show()
        }

        val list : RecyclerView = findViewById(R.id.travel_list)
        list.adapter = TravelAdapter()
    }
}