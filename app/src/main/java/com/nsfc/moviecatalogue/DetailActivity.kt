package com.nsfc.moviecatalogue

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.nsfc.moviecatalogue.model.MovieModel
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val movies = intent.getParcelableExtra("movie") as MovieModel

        Glide.with(this).load(movies.movie_image).into(iv_poster)
        tv_title.text = movies.movie_title
        tv_date.text = movies.movie_date
        tv_desc.text = movies.movie_desc
        tv_score.text = movies.user_score
        tv_studio.text = movies.movie_studio
        tv_director.text = movies.movie_director

    }


}

