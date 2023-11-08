package tp.info507.diarystravel.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import tp.info507.diarystravel.R
import tp.info507.diarystravel.model.Travel
import tp.info507.diarystravel.storage.TravelDataBaseStorage
import tp.info507.diarystravel.storage.TravelStorage

class DialogActivity : AppCompatActivity() {

    private fun handleTravelInsertion(nom: String, date: String, localisation: String) {
        val travel = Travel(
            0, nom, date, localisation, description = "")

        val travelStorage = TravelDataBaseStorage(this)
        val test = travelStorage.insert(travel)

        if (test != -1){
            //Toast.makeText(applicationContext, "Insertion réussie ! ;)", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(applicationContext, "Erreur insertion ! :(", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        val annul = findViewById<TextView>(R.id.annuler)

        annul.setOnClickListener {
            //Toast.makeText(applicationContext, "Coucou !", Toast.LENGTH_SHORT).show()
            finish()
        }

        val valid = findViewById<TextView>(R.id.valider)

        valid.setOnClickListener {
            val name = findViewById<EditText>(R.id.dialog_name).text.toString();
            val date = findViewById<EditText>(R.id.dialog_date).text.toString();
            val localisation = findViewById<EditText>(R.id.dialog_localisation).text.toString();

            handleTravelInsertion(name,date,localisation)

            finish()
        }
    }
}