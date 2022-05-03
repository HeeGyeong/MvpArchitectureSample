package com.example.mvparchitecturesample.view.movie

import com.example.mvparchitecturesample.api.ApiInterface
import com.example.mvparchitecturesample.model.MovieEntity
import com.example.mvparchitecturesample.util.NetworkManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviePresenter(
    private val userApi: ApiInterface,
    private val networkManager: NetworkManager,
    private var activity: MovieContract.View?,
    private var model: MovieContract.Model,
) : MovieContract.Presenter, MovieContract.Model.OnFinishedListener {


    override fun searchButtonClick(inputText: String) {
        CoroutineScope(Dispatchers.Main).launch {
            activity!!.showProgress()
            if (!networkManager.checkNetworkState()) {
                networkError()
            } else {
                model.getMovies(userApi.getSearchMovieFlow(inputText),this@MoviePresenter)

            }
        }
    }

    override fun networkError() {
        activity!!.hideProgress()
        activity!!.showToast("NetworkError")
    }

    override fun itemClick(movie: MovieEntity) {
        activity!!.showToast(movie.title)
    }

    override fun onFinished(movies: List<MovieEntity>) {
        activity!!.hideProgress()
        activity!!.changeMovieList(movies)
    }
}