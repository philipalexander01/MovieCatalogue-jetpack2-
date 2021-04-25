package com.example.moviecatalogue.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moviecatalogue.model.Movie
import com.example.moviecatalogue.repository.MovieRepository

class TvViewModel(private val mMovieRepository: MovieRepository) :ViewModel() {
    fun getDataTv(): LiveData<ArrayList<Movie>> = mMovieRepository.getDataTv()
    fun getDataTvById(tvId:Int):LiveData<Movie> = mMovieRepository.getDetailTv(tvId)
}