package tp.info507.diarystravel.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import tp.info507.diarystravel.R
import tp.info507.diarystravel.adapter.TravelAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var list:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button:ImageButton = findViewById<ImageButton>(R.id.addButton)

        button.setOnClickListener {
            //Toast.makeText(applicationContext, "Coucou !", Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext, DialogActivity::class.java)
            startActivity(intent)
        }


        list = findViewById(R.id.travel_list)
        list.adapter = TravelAdapter(applicationContext)
    }

    override fun onResume() {
        super.onResume()
        list.adapter?.notifyDataSetChanged()
    }
}