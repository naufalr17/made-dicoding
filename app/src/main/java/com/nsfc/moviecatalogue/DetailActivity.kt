package com.nsfc.moviecatalogue

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.nsfc.moviecatalogue.MainActivity.Companion.EXTRA_MOVIE
import com.nsfc.moviecatalogue.model.MovieAdapter
import com.nsfc.moviecatalogue.model.MovieModel
import kotlinx.android.synthetic.main.activity_detail.*
import android.content.Intent
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val movies = intent.getParcelableExtra(EXTRA_MOVIE) as MovieModel

        iv_poster.setImageResource(movies.movie_image).toString()
        tv_title.text = movies.movie_title.toString()
        tv_date.text = movies.movie_date.toString()
        tv_desc.text = movies.movie_desc.toString()
        tv_score.text = movies.user_score.toString()
        tv_studio.text = movies.movie_studio.toString()
        tv_director.text = movies.movie_director.toString()
    }


}

