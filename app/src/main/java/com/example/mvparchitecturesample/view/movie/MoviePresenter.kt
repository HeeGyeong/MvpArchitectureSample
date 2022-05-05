package com.example.mvparchitecturesample.view.movie

import com.example.mvparchitecturesample.api.ApiInterface
import com.example.mvparchitecturesample.model.MovieEntity
import com.example.mvparchitecturesample.util.NetworkManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MoviePresenter(
    private val userApi: ApiInterface,
    private val networkManager: NetworkManager,
    private var activity: MovieContract.View?,
    private var model: MovieContract.Model,
) : MovieContract.Presenter, MovieContract.Model.OnFinishedListener {


    override fun searchButtonClick(inputText: String) {
        CoroutineScope(Dispatchers.Main).launch {
            val input = inputText.ifEmpty {
                "null"
            }

            activity!!.showProgress()
            if (!networkManager.checkNetworkState()) {
                apiError()
            } else {
                try {
                    model.getMovies(userApi.getSearchMovieFlow(input), this@MoviePresenter)
                } catch (e: Exception) {
                    apiError()
                }
            }
        }
    }

    override fun apiError() {
        activity!!.hideProgress()
        activity!!.showToast("ApiError")
    }

    override fun itemClick(movie: MovieEntity) {
        activity!!.showToast(movie.title)
    }

    override fun onFinished(movies: List<MovieEntity>) {
        activity!!.hideProgress()
        if (movies.isEmpty()) {
            activity!!.showToast("Movie list is Empty")
        }

        activity!!.changeMovieList(movies)
    }
}