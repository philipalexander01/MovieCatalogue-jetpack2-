package com.example.moviecatalogue.apiservice

import com.example.moviecatalogue.model.Data
import com.example.moviecatalogue.model.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("{film}/popular")
      fun getMovie(
        @Path("film") film: String,
        @Query("api_key") api_key: String
    ): Call<Data>


    @GET("movie/{external_id}")
      fun getMovieById(
        @Path("external_id") external_id: Int,
        @Query("api_key") api_key: String
    ): Call<Movie>


    @GET("tv/{external_id}")
     fun getTvById(
        @Path("external_id") external_id: Int,
        @Query("api_key") api_key: String
    ): Call<Movie>


}