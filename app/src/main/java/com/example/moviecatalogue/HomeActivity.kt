package com.example.moviecatalogue

import android.content.Intent
import android.net.NetworkCapabilities
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.example.moviecatalogue.adapter.TabViewAdapter
import com.example.moviecatalogue.databinding.ActivityHomeBinding
import com.example.moviecatalogue.databinding.NoInternetLayoutBinding
import com.example.moviecatalogue.utils.Utility
import com.google.android.material.tabs.TabLayoutMediator

class HomeActivity : AppCompatActivity() {
    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_movie,
            R.string.tab_tv
        )
    }
    private var actNw: NetworkCapabilities? = null
    private var binding:ActivityHomeBinding? = null
    private var binding1: NoInternetLayoutBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        //check internet connection
        actNw = Utility().checkInternetConnection(this)
        //if there is no an internet connection
        if (actNw == null) {
            binding1 = NoInternetLayoutBinding.inflate(layoutInflater)
            setContentView(binding1?.root)
            binding1?.btnCobaLagi?.setOnClickListener {
                actNw = Utility().checkInternetConnection(this)
                if (actNw != null) {
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }else{
            val tabViewAdapter = TabViewAdapter(this)
            binding?.apply {
                viewPager.adapter = tabViewAdapter
                TabLayoutMediator(tabs, viewPager) { tab, position ->
                    tab.text = resources.getString(TAB_TITLES[position])
                }.attach()
                supportActionBar?.elevation = 0f
            }
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
        binding1 = null
    }
}