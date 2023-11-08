package tp.info507.diarystravel.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import tp.info507.diarystravel.R
import tp.info507.diarystravel.model.Travel
import tp.info507.diarystravel.storage.TravelStorage


class TravelActivity : AppCompatActivity() {
    private lateinit var desc : EditText
    private lateinit var item : Travel

    /*
    private fun askForPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (!Environment.isExternalStorageManager()) {
                val intent = Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION)
                startActivity(intent)
            }
        }
    }

    private fun checkPermission(permissions: Array<String>): Boolean {
        var res = true
        for (permission in permissions) {
            if ((ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED)) {
                if (!ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
                    ActivityCompat.requestPermissions(this, permissions, 0)
                }
                res = false
            }
        }
        return res
    }*/
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travel)

        val id = intent.getIntExtra("identifiant",0)
        item = TravelStorage.get(this).find(id)!!

        var title : TextView = findViewById(R.id.travel_name)

        desc = findViewById(R.id.travel_description)

        title.text = item.name
        desc.setText(item.description)

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

        val buttonMap: ImageView = findViewById<ImageButton>(R.id.buttonMap)

        buttonMap.setOnClickListener {
            val address = item.localisation
            val url = "https://www.google.fr/maps/place/$address/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }


    }

    override fun onStop() {
        super.onStop()

        item.description = desc.text.toString()
        Log.d("UPDATE",item.toString())
        TravelStorage.get(this).update(item.id,item)
    }
}