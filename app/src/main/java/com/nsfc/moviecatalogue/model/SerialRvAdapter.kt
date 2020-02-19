package com.nsfc.moviecatalogue.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.nsfc.moviecatalogue.DetailActivity
import com.nsfc.moviecatalogue.DetailSerialActivity
import com.nsfc.moviecatalogue.R
import kotlinx.android.synthetic.main.item_movie.view.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk27.coroutines.onClick

class SerialRvAdapter(private val listSerial: ArrayList<SerialModel>) :
    RecyclerView.Adapter<SerialRvAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listSerial[position])
    }

    override fun getItemCount(): Int = listSerial.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(serialModel: SerialModel) {
            Glide.with(itemView.context)
                .load(serialModel.serial_image)
                .apply(RequestOptions().override(100, 125))
                .into(itemView.item_iv)

            itemView.item_title.text = serialModel.serial_title
            itemView.item_date.text = serialModel.serial_date
            itemView.item_desc.text = serialModel.serial_desc

            itemView.onClick {
                val intentSerial =
                    itemView.context.intentFor<DetailSerialActivity>("serial" to serialModel)
                itemView.context.startActivity(intentSerial)
            }
        }
    }

}