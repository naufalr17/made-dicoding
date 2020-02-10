package com.nsfc.moviecatalogue

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.nsfc.moviecatalogue.model.MovieAdapter
import com.nsfc.moviecatalogue.model.MovieModel
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T




class MainActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var adapter : MovieAdapter
    private lateinit var movieTitle : Array<String>
    private lateinit var movieDate : Array<String>
    private lateinit var movieDesc : Array<String>
    private lateinit var movieScore : Array<String>
    private lateinit var movieStudio : Array<String>
    private lateinit var movieDirector : Array<String>
    private lateinit var moviePoster : TypedArray

    private var movies = arrayListOf<MovieModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = MovieAdapter(this)
        lv_movie.adapter = adapter

        res()

        addItem()

        lv_movie.onItemClickListener = AdapterView.OnItemClickListener{_, _, position, _->
            val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_MOVIE,movies)

            startActivity(intent)
        }
    }

    private fun addItem() {
        for (position in movieTitle.indices){
            val movie = MovieModel(
                moviePoster.getResourceId(position, -1),
                movieTitle[position],
                movieDate[position],
                movieDesc[position],
                movieScore[position],
                movieStudio[position],
                movieDirector[position]

            )
            movies.add(movie)
        }

        adapter.movie = movies
    }


    private fun res() {
        movieTitle = resources.getStringArray(R.array.movie_title)
        movieDate = resources.getStringArray(R.array.movie_date)
        movieDesc = resources.getStringArray(R.array.movie_desc)
        movieScore = resources.getStringArray(R.array.movie_desc)
        movieStudio = resources.getStringArray(R.array.movie_desc)
        movieDirector = resources.getStringArray(R.array.movie_desc)
        moviePoster = resources.obtainTypedArray(R.array.movie_poster)

    }
}
