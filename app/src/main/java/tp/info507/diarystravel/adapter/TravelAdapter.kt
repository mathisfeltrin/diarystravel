package tp.info507.diarystravel.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tp.info507.diarystravel.R
import tp.info507.diarystravel.activity.TravelActivity
import tp.info507.diarystravel.storage.TravelStorage

class TravelAdapter(private val context: Context): RecyclerView.Adapter<TravelAdapter.TravelHolder>(){
    class TravelHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val country: TextView = itemView.findViewById(R.id.travel_country)
        val date: TextView = itemView.findViewById(R.id.travel_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TravelHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_travel, parent, false)
        return TravelHolder(view)
    }

    override fun onBindViewHolder(holder: TravelHolder, position: Int) {
        val travel = TravelStorage.get(context).findAll()[position]

        holder.country.text = travel.localisation
        holder.date.text = travel.date

        holder.itemView.setOnClickListener {
            // Action à effectuer lorsque l'élément est cliqué
            val context = holder.itemView.context
            val intent = Intent(context, TravelActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return TravelStorage.get(context).size()
    }



}