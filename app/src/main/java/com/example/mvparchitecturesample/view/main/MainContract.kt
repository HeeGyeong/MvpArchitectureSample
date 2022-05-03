package com.example.mvparchitecturesample.view.main

interface MainContract {
    interface View {
        fun moveActivity()
    }

    interface Presenter {
        fun onMoveButtonClick()
    }
}