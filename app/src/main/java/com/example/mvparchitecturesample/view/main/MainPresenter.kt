package com.example.mvparchitecturesample.view.main

class MainPresenter(
    private var activity: MainContract.View?,
) : MainContract.Presenter {

    override fun onMoveButtonClick() {
        activity!!.moveActivity()
    }
}