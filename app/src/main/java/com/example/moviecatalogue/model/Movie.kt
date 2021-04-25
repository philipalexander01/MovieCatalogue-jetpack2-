package com.example.moviecatalogue.model

data class Data(
  val results:List<Movie>
)
data class Movie(
  val id:Int,
  val original_name:String?=null,
  val original_title:String?=null,
  val overview:String,
  val poster_path:String,
  val release_date:String?=null,
  val first_air_date:String?=null,
  val vote_average:Double
)