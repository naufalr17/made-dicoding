package com.nsfc.moviecatalogue


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsfc.moviecatalogue.model.MovieModel
import com.nsfc.moviecatalogue.model.MovieRvAdapter
import kotlinx.android.synthetic.main.fragment_movie_list.*

class MovieListFragment : Fragment() {

    private val listMovie = ArrayList<MovieModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_movie.setHasFixedSize(true)

        listMovie.addAll(getListMovie())
        showRecyclerList()

    }

    private fun showRecyclerList() {
        rv_movie.layoutManager = LinearLayoutManager(context)
        val movieAdapter = MovieRvAdapter(listMovie)
        rv_movie.adapter = movieAdapter
    }

    @SuppressLint("Recycle")
    fun getListMovie(): ArrayList<MovieModel> {
        val moviePoster = resources.obtainTypedArray(R.array.movie_poster)
        val movieTitle = resources.getStringArray(R.array.movie_title)
        val movieDate = resources.getStringArray(R.array.movie_date)
        val movieDesc = resources.getStringArray(R.array.movie_desc)
        val movieScore = resources.getStringArray(R.array.movie_user_score)
        val movieStudio = resources.getStringArray(R.array.movie_studio)
        val movieDirector = resources.getStringArray(R.array.movie_director)

        val movieList = ArrayList<MovieModel>()
        for (position in movieTitle.indices){
            val movie = MovieModel(
                moviePoster.getResourceId(position,-1),
                movieTitle[position],
                movieDate[position],
                movieDesc[position],
                movieScore[position],
                movieStudio[position],
                movieDirector[position]
            )
            movieList.add(movie)
        }

        return movieList
    }

}
