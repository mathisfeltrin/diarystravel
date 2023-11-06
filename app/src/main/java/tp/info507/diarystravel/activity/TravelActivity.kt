package tp.info507.diarystravel.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import tp.info507.diarystravel.R

class TravelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travel)

        // Il faut ajouter une variable travel = l'objet qui sert à choisir entre le json et le sql dans le cours du prof.

        val button: ImageView = findViewById<ImageButton>(R.id.backHome)

        button.setOnClickListener {
            //Toast.makeText(applicationContext, "Coucou !", Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            //finish()
        }

        val image: ImageView = findViewById(R.id.travel_image)

        val takePhoto =
            registerForActivityResult(ActivityResultContracts.TakePicturePreview()) {
                bitmap -> if (bitmap != null) image.setImageBitmap(bitmap)
            }

        image.setOnClickListener{takePhoto.launch(null)}
    }
}