package tp.info507.diarystravel.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tp.info507.diarystravel.R
import tp.info507.diarystravel.activity.TravelActivity
import tp.info507.diarystravel.model.Travel
import tp.info507.diarystravel.storage.TravelStorage

class TravelAdapter(private val context: Context): RecyclerView.Adapter<TravelAdapter.TravelHolder>(){

    private lateinit var travel: List<Travel>
    class TravelHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val country: TextView = itemView.findViewById(R.id.travel_country)
        val date: TextView = itemView.findViewById(R.id.travel_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TravelHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_travel, parent, false)
        recupTravel()

        return TravelHolder(view)
    }

    private fun recupTravel(){
        this.travel = TravelStorage.get(context).findAll()
    }

    override fun onBindViewHolder(holder: TravelHolder, position: Int) {

        if(travel.isNotEmpty()) {
            var item = travel[position]
            Log.d("FINDALL",item.toString())
            holder.country.text = item?.localisation
            holder.date.text = item?.date

            holder.itemView.setOnClickListener {
                // Action à effectuer lorsque l'élément est cliqué
                val context = holder.itemView.context
                val intent = Intent(context, TravelActivity::class.java)
                intent.putExtra("identifiant",item.id)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return TravelStorage.get(context).size()
    }
}