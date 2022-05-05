package com.example.mvparchitecturesample.view.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.mvparchitecturesample.R
import com.example.mvparchitecturesample.view.movie.MovieSearchActivity

class MainActivity : AppCompatActivity(), MainContract.View {
    var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)
    }

    fun btnClick(view: View) {
        when (view.id) {
            R.id.moveBtn -> {
                presenter!!.onMoveButtonClick()
            }
        }
    }

    override fun moveActivity() {
        startActivity(Intent(this@MainActivity, MovieSearchActivity::class.java))
    }
}