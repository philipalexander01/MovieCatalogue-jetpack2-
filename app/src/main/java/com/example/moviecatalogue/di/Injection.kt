package com.example.moviecatalogue.di

import com.example.moviecatalogue.model.RemoteDataSource
import com.example.moviecatalogue.repository.MovieRepository

object Injection {
    fun provideRepository(): MovieRepository {
        val remoteRepository = RemoteDataSource().getInstance()
        return MovieRepository.getInstance(remoteRepository)
    }
}