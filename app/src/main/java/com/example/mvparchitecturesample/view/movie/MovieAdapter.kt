package com.example.mvparchitecturesample.view.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mvparchitecturesample.R
import com.example.mvparchitecturesample.databinding.ItemMovieBinding
import com.example.mvparchitecturesample.model.MovieEntity

class MovieAdapter(private var presenter: MovieContract.Presenter) :
    ListAdapter<MovieEntity, MovieAdapter.ViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemMovieBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_movie,
            parent,
            false
        )

        return ViewHolder(binding).apply {
            binding.root.setOnClickListener {
                val position = adapterPosition.takeIf { it != RecyclerView.NO_POSITION }
                    ?: return@setOnClickListener
                presenter.itemClick(getItem(position))
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: MovieEntity) {
            binding.movie = movie
            binding.executePendingBindings()
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity) =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity) =
                oldItem.title == newItem.title
        }
    }
}