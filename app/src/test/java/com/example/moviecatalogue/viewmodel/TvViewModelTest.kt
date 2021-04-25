package com.example.moviecatalogue.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

import com.example.moviecatalogue.model.Movie
import com.example.moviecatalogue.repository.MovieRepository
import com.example.moviecatalogue.utils.DataDummy
import junit.framework.Assert.assertEquals
import org.junit.Assert.assertNotNull

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class TvViewModelTest {

    private lateinit var tvViewModel: TvViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<List<Movie>>

    private val tvEntities = DataDummy.getDataTv()[0]

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Before
    fun init() {
        tvViewModel = TvViewModel(movieRepository)
    }


    @Test
    fun testGetDataMovie() {
        val dummyTv = DataDummy.getDataMovie()
        val tv = MutableLiveData<List<Movie>>()
        tv.value = dummyTv

        `when`(movieRepository.getDataTv())
            .thenReturn(tv as LiveData<ArrayList<Movie>>)
        val tvEntities = tvViewModel.getDataTv().value
        verify(movieRepository).getDataTv()
        assertNotNull(tvEntities)
        assertEquals(10, tvEntities?.size)

        tvViewModel.getDataTv().observeForever(observer)
        verify(observer).onChanged(dummyTv)

    }

    @Test
    fun testGetDataMovieById() {
        val tvId = tvEntities.id
        val detailTv = MutableLiveData<Movie>()
        detailTv.value = tvEntities
        `when`(movieRepository.getDetailTv(tvId)).thenReturn(detailTv)

        val detailEntity = tvViewModel.getDataTvById(tvId).value
        verify(movieRepository).getDetailTv(tvId)
        assertNotNull(detailEntity)
        assertEquals(tvEntities.id, detailEntity?.id)
        assertEquals(tvEntities.original_title, detailEntity?.original_title)
        assertEquals(tvEntities.overview, detailEntity?.overview)
        assertEquals(tvEntities.release_date, detailEntity?.release_date)
        assertEquals(tvEntities.poster_path, detailEntity?.poster_path)
        assertEquals(tvEntities.vote_average, detailEntity?.vote_average)
    }
}