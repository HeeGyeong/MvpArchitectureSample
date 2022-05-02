package com.example.mvparchitecturesample.view.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mvparchitecturesample.R
import com.example.mvparchitecturesample.view.movie.MovieSearchActivity

class MainActivity : AppCompatActivity(), Contract.View {
    private var textView: TextView? = null
    private var progressBar: ProgressBar? = null

    var presenter: Presenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        progressBar = findViewById(R.id.progressBar)

        presenter = Presenter(this, Model())

    }

    fun btnClick(view: View) {
        when (view.id) {
            R.id.button -> {
                presenter!!.onButtonClick()
            }
            R.id.moveBtn -> {
                moveActivity()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter!!.onDestroy()
    }

    override fun showProgress() {
        progressBar!!.visibility = View.VISIBLE
        textView!!.visibility = View.INVISIBLE
    }

    override fun hideProgress() {
        progressBar!!.visibility = View.GONE
        textView!!.visibility = View.VISIBLE
    }

    override fun setString(string: String?) {
        textView!!.text = string
    }

    override fun moveActivity() {
        startActivity(Intent(this@MainActivity, MovieSearchActivity::class.java))
    }
}