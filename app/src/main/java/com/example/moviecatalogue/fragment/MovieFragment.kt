package com.example.moviecatalogue.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviecatalogue.DetailActivity
import com.example.moviecatalogue.R
import com.example.moviecatalogue.adapter.MovieViewAdapter
import com.example.moviecatalogue.databinding.FragmentMovieBinding
import com.example.moviecatalogue.model.Movie
import com.example.moviecatalogue.viewmodel.MovieViewModel
import com.example.moviecatalogue.viewmodel.TvViewModel
import com.example.moviecatalogue.viewmodel.ViewModelFactory

class MovieFragment : Fragment() {
    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(index: Int) =
            MovieFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, index)
                }
            }
    }

    private var binding: FragmentMovieBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory = ViewModelFactory.getInstance()
        val index = arguments?.getInt(ARG_SECTION_NUMBER, 0)
        val movieViewAdapter = MovieViewAdapter()
        binding?.apply {
            pbLoading.visibility = View.VISIBLE
            rvMovie.layoutManager = LinearLayoutManager(requireActivity())
            rvMovie.adapter = movieViewAdapter
        }
        var type = ""
        if (index == 1) {
            val movieViewModel =
                ViewModelProvider(requireActivity(), factory)[MovieViewModel::class.java]
            movieViewModel.getDataMovie().observe(requireActivity(), {
                if (it.isNotEmpty()) {
                    movieViewAdapter.setData(it)
                    type = getString(R.string.movie)
                } else {
                    Toast.makeText(
                        requireActivity(),
                        getString(R.string.data_not_exist),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                binding?.pbLoading?.visibility = View.GONE
            })
        } else if (index == 2) {
            val tvViewModel = ViewModelProvider(requireActivity(), factory)[TvViewModel::class.java]
            tvViewModel.getDataTv().observe(requireActivity(), {
                if (it.isNotEmpty()) {
                    movieViewAdapter.setData(it)
                    type = getString(R.string.tv)
                } else {
                    Toast.makeText(
                        requireActivity(),
                        getString(R.string.data_not_exist),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                binding?.pbLoading?.visibility = View.GONE
            })
        }


        movieViewAdapter.setOnItemClickCallback(object : MovieViewAdapter.OnItemClickCallback {
            override fun onItemClick(data: Movie) {
                val intent = Intent(requireActivity(), DetailActivity::class.java).apply {
                    putExtra(getString(R.string.id), data.id)
                    putExtra(getString(R.string.type), type)
                }
                startActivity(intent)
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}