package com.example.moviecatalogue.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moviecatalogue.model.Movie
import com.example.moviecatalogue.repository.MovieRepository

class MovieViewModel(private val mMovieRepository: MovieRepository) :ViewModel(){
    fun getDataMovie():LiveData<ArrayList<Movie>> = mMovieRepository.getDataMovie()

    fun getDataMovieById(movieId:Int):LiveData<Movie> = mMovieRepository.getDetailMovie(movieId)
}