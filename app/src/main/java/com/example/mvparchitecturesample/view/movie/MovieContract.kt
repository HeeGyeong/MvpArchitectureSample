package com.example.mvparchitecturesample.view.movie

interface MovieContract {
    interface View {
        fun showProgress()
        fun hideProgress()

        fun changeMovieList()
    }

    interface Model {
        interface OnFinishedListener {
            fun onFinished(string: String?)
        }

        fun getNextCourse(onFinishedListener: OnFinishedListener?)
    }

    interface Presenter {
        fun searchButtonClick(inputText: String)
        fun itemClick()
    }
}