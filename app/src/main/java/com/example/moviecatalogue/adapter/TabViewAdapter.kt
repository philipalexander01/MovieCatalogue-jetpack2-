package com.example.moviecatalogue.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.moviecatalogue.fragment.MovieFragment

class TabViewAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        return MovieFragment.newInstance(position + 1)
    }


    override fun getItemCount(): Int {
        return 2
    }

}