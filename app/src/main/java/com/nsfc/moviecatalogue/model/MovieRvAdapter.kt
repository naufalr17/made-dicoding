package com.nsfc.moviecatalogue.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.nsfc.moviecatalogue.DetailActivity
import com.nsfc.moviecatalogue.R
import kotlinx.android.synthetic.main.item_movie.view.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk27.coroutines.onClick

class MovieRvAdapter(private val listMovie: ArrayList<MovieModel>) :
    RecyclerView.Adapter<MovieRvAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }

    override fun getItemCount(): Int = listMovie.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movieModel: MovieModel) {
            Glide.with(itemView.context)
                .load(movieModel.movie_image)
                .apply(RequestOptions().override(100, 125))
                .into(itemView.item_iv)

            itemView.item_title.text = movieModel.movie_title
            itemView.item_date.text = movieModel.movie_date
            itemView.item_desc.text = movieModel.movie_desc

            itemView.onClick {
                val intentMovie =
                    itemView.context.intentFor<DetailActivity>("movie" to movieModel)
                itemView.context.startActivity(intentMovie)
            }
        }
    }

}