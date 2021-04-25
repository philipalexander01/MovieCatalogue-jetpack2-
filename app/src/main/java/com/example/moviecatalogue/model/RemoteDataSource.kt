package com.example.moviecatalogue.model

import android.util.Log
import com.example.moviecatalogue.apiservice.ApiService
import com.example.moviecatalogue.utils.EspressoIdlingResource
import com.example.moviecatalogue.utils.Utility
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {
    private val API_KEY = "2b0b7747bf006bf5325a85fd4e5122e9"

    @Volatile
    private var instance: RemoteDataSource? = null

    fun getInstance(): RemoteDataSource =
        instance ?: synchronized(this) {
            RemoteDataSource().apply { instance = this }
        }

    fun getDataMovie(callback: LoadMovieCallback) {
        EspressoIdlingResource.increment()
        Utility().getRetrofit().create(ApiService::class.java)
            .getMovie("movie", API_KEY)
            .enqueue(object : Callback<Data> {
                override fun onResponse(
                    call: Call<Data>,
                    response: Response<Data>
                ) {
                    if (response.code() == 200) {
                        if (response.body() != null) {
                            callback.onLoadMovie(response.body()?.results as ArrayList<Movie>)
                            EspressoIdlingResource.decrement()

                        }
                    }
                }

                override fun onFailure(call: Call<Data>, t: Throwable) {
                    Log.d("retrofit error", t.message.toString())
                }

            })

    }

    fun getDataTv(callback: LoadTvCallback) {
        EspressoIdlingResource.increment()
        Utility().getRetrofit().create(ApiService::class.java)
            .getMovie("tv", API_KEY)
            .enqueue(object : Callback<Data> {
                override fun onResponse(
                    call: Call<Data>,
                    response: Response<Data>
                ) {
                    if (response.code() == 200) {
                        if (response.body() != null) {
                            callback.onLoadTv(response.body()?.results as ArrayList<Movie>)
                            EspressoIdlingResource.decrement()

                        }
                    }
                }

                override fun onFailure(call: Call<Data>, t: Throwable) {
                    Log.d("retrofit error", t.message.toString())
                }

            })

    }

    fun getDetailMovie(movieId: Int, callback: LoadDetailMovieCallback) {
        EspressoIdlingResource.increment()
        Utility().getRetrofit().create(ApiService::class.java)
            .getMovieById(movieId, API_KEY)
            .enqueue(object : Callback<Movie> {
                override fun onResponse(
                    call: Call<Movie>,
                    response: Response<Movie>
                ) {
                    if (response.code() == 200) {
                        if (response.body() != null) {
                            response.body()?.let { callback.onLoadDetail(it) }
                            EspressoIdlingResource.decrement()

                        }
                    }
                }

                override fun onFailure(call: Call<Movie>, t: Throwable) {
                    Log.d("retrofit error", t.message.toString())
                }


            })

    }


    fun getDetailTv(tvId: Int, callback: LoadDetailTvCallback) {
        EspressoIdlingResource.increment()
        Utility().getRetrofit().create(ApiService::class.java)
            .getTvById(tvId, API_KEY)
            .enqueue(object : Callback<Movie> {
                override fun onResponse(
                    call: Call<Movie>,
                    response: Response<Movie>
                ) {
                    if (response.code() == 200) {
                        if (response.body() != null) {
                            response.body()?.let { callback.onLoadDetail(it) }
                            EspressoIdlingResource.decrement()

                        }
                    }
                }

                override fun onFailure(call: Call<Movie>, t: Throwable) {
                    Log.d("retrofit error", t.message.toString())
                }
            })
    }


    interface LoadMovieCallback {
        fun onLoadMovie(dataMovie: ArrayList<Movie>)
    }

    interface LoadTvCallback {
        fun onLoadTv(dataTv: ArrayList<Movie>)
    }

    interface LoadDetailMovieCallback {
        fun onLoadDetail(dataDetailMovie: Movie)
    }

    interface LoadDetailTvCallback {
        fun onLoadDetail(dataDetailTv: Movie)
    }
}