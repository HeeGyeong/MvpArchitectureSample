package com.example.mvparchitecturesample.view.movie

import com.example.mvparchitecturesample.model.MovieEntity
import com.example.mvparchitecturesample.model.MovieResponse

interface MovieContract {
    interface View {
        fun showProgress()
        fun hideProgress()

        fun changeMovieList(movies: List<MovieEntity>)
        fun showToast(text: String)
    }

    interface Model {
        interface OnFinishedListener {
            fun onFinished(movies: List<MovieEntity>)
        }

        fun getMovies(movie: MovieResponse, onFinishedListener: OnFinishedListener?)
    }

    interface Presenter {
        fun searchButtonClick(inputText: String)
        fun networkError()

        fun itemClick(movie: MovieEntity)
    }
}