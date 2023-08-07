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

        if (savedInstanceState == null) {
            binding.bottomNavMain.selectedItemId = R.id.menu_feed
        }
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
            R.id.menu_feed -> {
                val feedFragment = supportFragmentManager.fragments.find { it is FeedFragment }
                if (feedFragment != null) {
                    supportFragmentManager.beginTransaction().show(feedFragment).commit()
                } else {
                    supportFragmentManager.beginTransaction()
                        .add(binding.fcvMain.id, FeedFragment.newInstance())
                        .commit()
                }
            }
            R.id.menu_record -> {
                val intent = GalleryActivity.getIntent(this@MainActivity)
                startActivity(intent)
            }
            R.id.menu_my_gooding -> {
                val myGoodingFragment = supportFragmentManager.fragments.find { it is MyGoodingFragment }
                if (myGoodingFragment != null) {
                    supportFragmentManager.beginTransaction().show(myGoodingFragment).commit()
                } else {
                    supportFragmentManager.beginTransaction()
                        .add(binding.fcvMain.id, MyGoodingFragment.newInstance())
                        .commit()
                }
            }
        }

        return true
    }
}