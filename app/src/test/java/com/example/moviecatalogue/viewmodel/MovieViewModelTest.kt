package com.example.moviecatalogue.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

import com.example.moviecatalogue.model.Movie
import com.example.moviecatalogue.repository.MovieRepository
import com.example.moviecatalogue.utils.DataDummy
import junit.framework.TestCase.assertEquals
import org.junit.Assert

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var movieViewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<List<Movie>>

    private val movieEntities = DataDummy.getDataMovie()[0]

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Before
    fun init() {
        movieViewModel = MovieViewModel(movieRepository)
    }

    @Test
    fun testGetDataMovie() {
        val dummyMovie = DataDummy.getDataMovie()
        val movie = MutableLiveData<List<Movie>>()
        movie.value = dummyMovie

        `when`(movieRepository.getDataMovie()).thenReturn(movie as LiveData<ArrayList<Movie>>)
        val movieEntities = movieViewModel.getDataMovie().value
        verify(movieRepository).getDataMovie()
        Assert.assertNotNull(movieEntities)
        Assert.assertEquals(10, movieEntities?.size)

        movieViewModel.getDataMovie().observeForever(observer)
        verify(observer).onChanged(dummyMovie)

    }

    @Test
    fun testGetDataMovieById() {
        val movieId = movieEntities.id
        val detailMovie = MutableLiveData<Movie>()
        detailMovie.value = movieEntities
        `when`(movieRepository.getDetailMovie(movieId)).thenReturn(detailMovie)

        val detailEntity = movieViewModel.getDataMovieById(movieId).value
        verify(movieRepository).getDetailMovie(movieId)
        Assert.assertNotNull(detailEntity)
        assertEquals(movieEntities.id, detailEntity?.id)
        assertEquals(movieEntities.original_title, detailEntity?.original_title)
        assertEquals(movieEntities.overview, detailEntity?.overview)
        assertEquals(movieEntities.release_date, detailEntity?.release_date)
        assertEquals(movieEntities.poster_path, detailEntity?.poster_path)
        assertEquals(movieEntities.vote_average, detailEntity?.vote_average)
    }
}