package com.example.moviecatalogue.repository

import androidx.lifecycle.LiveData
import com.example.moviecatalogue.model.Movie

interface MovieDataSource {
    fun getDataMovie(): LiveData<ArrayList<Movie>>
    fun getDataTv(): LiveData<ArrayList<Movie>>
    fun getDetailMovie(movieId: Int): LiveData<Movie>
    fun getDetailTv(tvId: Int): LiveData<Movie>
}