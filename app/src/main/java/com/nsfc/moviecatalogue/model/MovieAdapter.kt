package com.nsfc.moviecatalogue.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.widget.ImageViewCompat
import com.nsfc.moviecatalogue.R

class MovieAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var movie = arrayListOf<MovieModel>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemMovie = convertView
        if (itemMovie == null) {
            itemMovie = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        }

        val viewHolder = ViewHolder(itemMovie as View)

        val movie = getItem(position) as MovieModel
        viewHolder.bind(movie)
        return itemMovie
    }

    private inner class ViewHolder internal constructor(view: View) {


        private val txtName: TextView = view.findViewById(R.id.item_title)
        private val txtDate: TextView = view.findViewById(R.id.item_date)
        private val txtDesc: TextView = view.findViewById(R.id.item_desc)
        private val imgPoster: ImageView = view.findViewById(R.id.item_iv)


        internal fun bind(movie: MovieModel) {
            txtName.text = movie.movie_title.toString()
            txtDate.text = movie.movie_date.toString()
            txtDesc.text = movie.movie_desc.toString()
            imgPoster.setImageResource(movie.movie_image).toString()
        }
    }

    override fun getItem(position: Int): Any = movie[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = movie.size
}

