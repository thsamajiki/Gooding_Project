package com.dnd_9th_3_android.gooding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.dnd_9th_3_android.gooding.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        setupBottomNavigationView()
    }

    private fun setupBottomNavigationView() {
        binding.bottomNavMain.setOnItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        val prevFragment = supportFragmentManager.fragments.find {
            it.isVisible
        }

        if (prevFragment != null) {
            supportFragmentManager.beginTransaction().hide(prevFragment).commitNow()
        }

        when (item.itemId) {
            R.id.menu_day_feed -> {
                val dayFeedFragment = supportFragmentManager.fragments.find { it is DayFeedFragment }
                if (dayFeedFragment != null) {
                    supportFragmentManager.beginTransaction().show(dayFeedFragment).commit()
                } else {
                    supportFragmentManager.beginTransaction()
                        .add(binding.fcvMain.id, DayFeedFragment.newInstance())
                        .commit()
                }
            }
            R.id.menu_record -> {
                val recordFragment = supportFragmentManager.fragments.find { it is RecordFragment }
                if (recordFragment != null) {
                    supportFragmentManager.beginTransaction().show(recordFragment).commit()
                } else {
                    supportFragmentManager.beginTransaction()
                        .add(binding.fcvMain.id, RecordFragment.newInstance()
                    ).commit()
                }
            }
            R.id.menu_my_page -> {
                val myPageFragment = supportFragmentManager.fragments.find { it is MyPageFragment }
                if (myPageFragment != null) {
                    supportFragmentManager.beginTransaction().show(myPageFragment).commit()
                } else {
                supportFragmentManager.beginTransaction()
                    .add(binding.fcvMain.id, MyPageFragment.newInstance()
                    ).commit()
                }
            }
        }

        return true
    }
}