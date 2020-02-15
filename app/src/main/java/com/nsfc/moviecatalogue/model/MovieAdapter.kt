package com.nsfc.moviecatalogue.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.nsfc.moviecatalogue.R
import kotlinx.android.synthetic.main.item_movie.view.*

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

    inner class ViewHolder internal constructor(private val view: View) {
        fun bind(movie: MovieModel) {
            with(view) {
                item_title.text = movie.movie_title
                item_date.text = movie.movie_date
                item_desc.text = movie.movie_desc
                item_iv.setImageResource(movie.movie_image)
            }
        }

    }

    override fun getItem(position: Int): Any = movie[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = movie.size
}

