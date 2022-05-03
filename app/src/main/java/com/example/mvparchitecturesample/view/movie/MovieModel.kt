package com.example.mvparchitecturesample.view.movie

import com.example.mvparchitecturesample.model.MovieResponse

class MovieModel : MovieContract.Model {

    override fun getMovies(movie: MovieResponse, onFinishedListener: MovieContract.Model.OnFinishedListener?) {
        val movies = movie.movies

        if (movies.isNotEmpty()) {
            onFinishedListener!!.onFinished(movies)
        } else {
            onFinishedListener!!.onFinished(listOf())
        }
    }
}