package com.example.mvparchitecturesample.view.movie

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.mvparchitecturesample.R
import kotlinx.android.synthetic.main.activity_movie_search.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieSearchActivity : AppCompatActivity(), MovieContract.View {
    private val movieAdapter = MovieAdapter()
    private val presenter: MoviePresenter by inject()

//    val presenter: MoviePresenter by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_search)
        rv_movies.adapter = movieAdapter

    }

    fun btnClick(view: View) {
        when (view.id) {
            R.id.btn_search -> {
                presenter.searchButtonClick(et_input.text.toString())
            }
        }
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.INVISIBLE
    }

    override fun changeMovieList() {
        movieAdapter.submitList(listOf())
    }
}