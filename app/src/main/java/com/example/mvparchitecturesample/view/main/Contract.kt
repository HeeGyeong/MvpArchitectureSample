package com.example.mvparchitecturesample.view.main

interface Contract {
    interface View {
        fun showProgress()
        fun hideProgress()

        fun setString(string: String?)

        fun moveActivity()
    }

    interface Model {
        interface OnFinishedListener {
            fun onFinished(string: String?)
        }

        fun getNextCourse(onFinishedListener: OnFinishedListener?)
    }

    interface Presenter {
        fun onButtonClick()
        fun onMoveButtonClick()

        fun onDestroy()
    }
}