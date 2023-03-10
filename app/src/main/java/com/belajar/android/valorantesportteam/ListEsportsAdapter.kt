package com.belajar.android.valorantesportteam

import android.content.Intent
import android.icu.text.Transliterator.Position
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class ListEsportsAdapter (private val listEsports: ArrayList<EsportsTeam>) : RecyclerView.Adapter<ListEsportsAdapter.ListViewHolder>(    ) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view:View =  LayoutInflater.from(parent.context).inflate(R.layout.item_row_esports, parent, false)
        return ListEsportsAdapter.ListViewHolder(view)
    }

    override fun getItemCount(): Int = listEsports.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, location, region, description, photo, roster) = listEsports[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvLocation.text = location
        holder.tvRegion.text = region

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailEsportsActivity::class.java)
            intentDetail.putExtra(DetailEsportsActivity.EXTRA_PHOTO, photo)
            intentDetail.putExtra(DetailEsportsActivity.EXTRA_NAME, name)
            intentDetail.putExtra(DetailEsportsActivity.EXTRA_DESC, description)
            intentDetail.putExtra(DetailEsportsActivity.EXTRA_LOC, location)
            intentDetail.putExtra(DetailEsportsActivity.EXTRA_REG, region)
            intentDetail.putExtra(DetailEsportsActivity.EXTRA_ROSTER, roster)
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvLocation: TextView = itemView.findViewById(R.id.tv_item_location)
        val tvRegion: TextView = itemView.findViewById(R.id.tv_item_region)
    }
}