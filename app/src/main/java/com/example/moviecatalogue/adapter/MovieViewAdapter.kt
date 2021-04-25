package com.example.moviecatalogue.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviecatalogue.R
import com.example.moviecatalogue.databinding.ItemListBinding
import com.example.moviecatalogue.model.Movie

class MovieViewAdapter : RecyclerView.Adapter<MovieViewAdapter.ViewHolder>() {
    private val data = ArrayList<Movie>()

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataMovie = data[position]
        holder.binding.apply {
            ivPoster.loadImage(dataMovie.poster_path)
            if (dataMovie.original_name != null) tvTitle.text = dataMovie.original_name
            if (dataMovie.original_title != null) tvTitle.text = dataMovie.original_title
            tvOverview.text = dataMovie.overview
            materialCardView.setOnClickListener {
                onItemClickCallback.onItemClick(dataMovie)
            }
        }
    }

    override fun getItemCount(): Int = data.size
    fun setData(data: ArrayList<Movie>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    private fun ImageView.loadImage(url: String) {
        Glide.with(this.context).load(context.getString(R.string.url_img) + url)
            .placeholder(R.drawable.ic_launcher_background).into(this)
    }

    interface OnItemClickCallback {
        fun onItemClick(data: Movie)
    }
}