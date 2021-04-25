package com.example.moviecatalogue

import android.content.Intent
import android.net.NetworkCapabilities
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.moviecatalogue.databinding.ActivityDetailBinding
import com.example.moviecatalogue.databinding.NoInternetLayoutBinding
import com.example.moviecatalogue.model.Movie
import com.example.moviecatalogue.utils.Utility
import com.example.moviecatalogue.viewmodel.MovieViewModel
import com.example.moviecatalogue.viewmodel.TvViewModel
import com.example.moviecatalogue.viewmodel.ViewModelFactory

class DetailActivity : AppCompatActivity() {
    private var binding: ActivityDetailBinding? = null
    private var binding1: NoInternetLayoutBinding? = null
    private var actNw: NetworkCapabilities? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val factory = ViewModelFactory.getInstance()

        val id = intent.getIntExtra(this.getString(R.string.id), 0)
        val type = intent.getStringExtra(this.getString(R.string.type))
        binding?.ivBack?.setOnClickListener {
            onBackPressed()
        }

        //check internet connection
        actNw = Utility().checkInternetConnection(this)
        //if there is no an internet connection
        if (actNw == null) {
            binding1 = NoInternetLayoutBinding.inflate(layoutInflater)
            setContentView(binding1?.root)
            binding1?.btnCobaLagi?.setOnClickListener {
                actNw = Utility().checkInternetConnection(this)
                if (actNw != null) {
                    val intent = Intent(this, DetailActivity::class.java)
                    intent.putExtra(getString(R.string.id), id)
                    intent.putExtra(getString(R.string.type), type)
                    startActivity(intent)
                    finish()
                }
            }
        }else{
            binding?.pbLoading?.visibility=View.VISIBLE
            if(id != null){
                when (type) {
                    getString(R.string.movie) -> {
                        val movieViewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

                        movieViewModel.getDataMovieById(id).observe(this, {
                            if (it != null) {
                                setData(it)
                            } else {
                                Toast.makeText(this@DetailActivity, "Data not exist", Toast.LENGTH_SHORT).show()
                            }
                            binding?.pbLoading?.visibility = View.GONE
                        })
                    }
                    getString(R.string.tv) -> {
                        val tvViewModel = ViewModelProvider(this, factory)[TvViewModel::class.java]
                        tvViewModel.getDataTvById(id).observe(this, {
                            if (it != null) {
                                setData(it)
                            }else{
                                Toast.makeText(this@DetailActivity, "Data not exist", Toast.LENGTH_SHORT).show()
                            }
                            binding?.pbLoading?.visibility=View.GONE
                        })
                    }
                }
            }

        }


    }

    private fun setData(data: Movie) {
        binding?.apply {
            Glide.with(this@DetailActivity)
                .load(this@DetailActivity.getString(R.string.url_img) + data.poster_path)
                .placeholder(R.drawable.ic_launcher_background).into(ivAvatar)
            if (data.original_name != null) tvTitle.text = data.original_name
            if (data.original_title != null) tvTitle.text = data.original_title
            if (data.first_air_date != null) tvDate.text = data.first_air_date
            if (data.release_date != null) tvDate.text = data.release_date
            tvOverview.text = data.overview
            setProgressTo(data.vote_average)
        }
    }

    private fun setProgressTo(progress: Double){
        binding?.apply {
            include.progressTv.text = "$progress%"
            include.circularDeterminativePb.progress = (progress*10).toInt()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
        binding1 = null
    }
}