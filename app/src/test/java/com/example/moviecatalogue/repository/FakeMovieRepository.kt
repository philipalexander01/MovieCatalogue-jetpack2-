package com.example.moviecatalogue.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviecatalogue.model.Movie
import com.example.moviecatalogue.model.RemoteDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FakeMovieRepository(private val remoteDataSource: RemoteDataSource) :
    MovieDataSource {

    override fun getDataMovie(): LiveData<ArrayList<Movie>> {
        val dataMovie1 = MutableLiveData<ArrayList<Movie>>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getDataMovie(object : RemoteDataSource.LoadMovieCallback {
                override fun onLoadMovie(dataMovie: ArrayList<Movie>) {
                    val dataMov = ArrayList<Movie>()
                    for (i in 0 until 10) {
                        dataMov.add(dataMovie[i])
                    }
                    dataMovie1.postValue(dataMov)
                }

            })

        }
        return dataMovie1

    }

    override fun getDataTv(): LiveData<ArrayList<Movie>> {
        val dataTv1 = MutableLiveData<ArrayList<Movie>>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getDataTv(object : RemoteDataSource.LoadTvCallback {
                override fun onLoadTv(dataTv: ArrayList<Movie>) {
                    val tvData = ArrayList<Movie>()
                    for (i in 0 until 10) {
                        tvData.add(dataTv[i])
                    }
                    dataTv1.postValue(tvData)
                }
            })

        }
        return dataTv1
    }


    override fun getDetailMovie(movieId: Int): LiveData<Movie> {
        val dataMovieById = MutableLiveData<Movie>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getDetailMovie(movieId,
                object : RemoteDataSource.LoadDetailMovieCallback {
                    override fun onLoadDetail(dataDetailMovie: Movie) {
                        dataMovieById.postValue(dataDetailMovie)
                    }

                })
        }
        return dataMovieById
    }


    override fun getDetailTv(tvId: Int): LiveData<Movie> {
        val dataTvById = MutableLiveData<Movie>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getDetailTv(tvId, object : RemoteDataSource.LoadDetailTvCallback {
                override fun onLoadDetail(dataDetailTv: Movie) {
                    dataTvById.postValue(dataDetailTv)
                }
            })
        }
        return dataTvById
    }
}