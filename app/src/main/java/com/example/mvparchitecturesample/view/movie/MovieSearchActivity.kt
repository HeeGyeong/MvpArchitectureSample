package com.example.mvparchitecturesample.view.movie

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mvparchitecturesample.R
import com.example.mvparchitecturesample.api.ApiInterface
import com.example.mvparchitecturesample.model.MovieEntity
import com.example.mvparchitecturesample.util.NetworkManager
import kotlinx.android.synthetic.main.activity_movie_search.*
import org.koin.android.ext.android.inject

class MovieSearchActivity : AppCompatActivity(), MovieContract.View {
    private val api: ApiInterface by inject()
    private val network: NetworkManager by inject()

    private var movieAdapter: MovieAdapter? = null
    private var presenter: MoviePresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_search)
        presenter = MoviePresenter(api, network, this, MovieModel())
        movieAdapter = MovieAdapter(presenter!!)
        rv_movies.adapter = movieAdapter
    }

    fun btnClick(view: View) {
        when (view.id) {
            R.id.btn_search -> {
                presenter!!.searchButtonClick(et_input.text.toString())
            }
        }
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
        Log.d("Sample", "showProgress()")
    }

    override fun hideProgress() {
        progressBar.visibility = View.INVISIBLE
        Log.d("Sample", "hideProgress()")
    }

    override fun changeMovieList(movies: List<MovieEntity>) {
        movieAdapter!!.submitList(movies)
    }

    override fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}