package com.example.mvparchitecturesample.view.movie

import com.example.mvparchitecturesample.api.ApiInterface
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
        /*CoroutineScope(Dispatchers.Main).launch {

        }*/
    }

    override fun itemClick() {
    }

    // Model to Present Call
    override fun onFinished(string: String?) {
    }
}