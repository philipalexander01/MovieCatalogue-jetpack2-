package com.example.moviecatalogue.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.moviecatalogue.model.Movie
import com.example.moviecatalogue.model.RemoteDataSource
import com.example.moviecatalogue.utils.DataDummy
import com.example.moviecatalogue.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.*
import junit.framework.TestCase.assertEquals
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito.mock

import org.junit.Rule

class MovieRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val movieRepository = FakeMovieRepository(remote)

    private val movieResponses = DataDummy.getDataMovie()
    private val movieResponse = DataDummy.getDataMovie()[0]
    private val movieId = movieResponses[0].id

    private val tvResponses = DataDummy.getDataTv()
    private val tvResponse = DataDummy.getDataTv()[0]
    private val tvId = tvResponses[0].id

    @Test
    fun getDataMovie() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMovieCallback)
                .onLoadMovie(movieResponses as ArrayList<Movie>)
            null
        }.`when`(remote).getDataMovie(any())
        val movieEntities = LiveDataTestUtil.getValue(movieRepository.getDataMovie())
        verify(remote).getDataMovie(any())
        Assert.assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getDataTv() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvCallback)
                .onLoadTv(tvResponses as ArrayList<Movie>)
            null
        }.`when`(remote).getDataTv(any())
        val tvEntities = LiveDataTestUtil.getValue(movieRepository.getDataTv())
        verify(remote).getDataTv(any())
        Assert.assertNotNull(tvEntities)
        assertEquals(tvResponses.size.toLong(), tvEntities.size.toLong())
    }

    @Test
    fun getDetailMovie() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadDetailMovieCallback)
                .onLoadDetail(movieResponse)
            null
        }.`when`(remote).getDetailMovie(eq(movieId), any())

        val detailMovie = LiveDataTestUtil.getValue(movieRepository.getDetailMovie(movieId))

        verify(remote).getDetailMovie(eq(movieId), any())

        Assert.assertNotNull(detailMovie)
        Assert.assertNotNull(detailMovie.original_title)
        assertEquals(movieResponse.original_title, detailMovie.original_title)
    }

    @Test
    fun getDetailTv() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadDetailTvCallback)
                .onLoadDetail(tvResponse)
            null
        }.`when`(remote).getDetailTv(eq(tvId), any())

        val detailTv = LiveDataTestUtil.getValue(movieRepository.getDetailTv(tvId))

        verify(remote).getDetailTv(eq(tvId), any())

        Assert.assertNotNull(detailTv)
        Assert.assertNotNull(detailTv.original_name)
        assertEquals(tvResponse.original_name, detailTv.original_name)
    }
}