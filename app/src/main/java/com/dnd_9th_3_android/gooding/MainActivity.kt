package com.dnd_9th_3_android.gooding

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import com.dnd_9th_3_android.gooding.databinding.ActivityMainBinding
import com.dnd_9th_3_android.gooding.viewModel.MainFeedViewModel
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
                    val transaction = supportFragmentManager.beginTransaction()
                        .add(binding.fcvMain.id, FeedFragment.newInstance())

                    transaction.addToBackStack(null)
                    transaction.commit()
                }
            }
            R.id.menu_record -> {
//                val intent = GalleryActivity.getIntent(this@MainActivity)
//                startActivity(intent)
                if (checkStoragePermission()) {
                    val intent = GalleryActivity.getIntent(this@MainActivity)
                    startActivity(intent)
                }
            }
            R.id.menu_my_gooding -> {
                val myGoodingFragment = supportFragmentManager.fragments.find { it is MyGoodingFragment }
                if (myGoodingFragment != null) {
                    supportFragmentManager.beginTransaction().show(myGoodingFragment).commit()
                } else {
                    val transaction = supportFragmentManager.beginTransaction()
                        .add(binding.fcvMain.id, MyGoodingFragment.newInstance())

                    transaction.addToBackStack(null )
                    transaction.commit()
                }
            }
        }

        return true
    }

    private fun checkStoragePermission(): Boolean {
        val readPermission = Manifest.permission.READ_EXTERNAL_STORAGE
        val writePermission = Manifest.permission.WRITE_EXTERNAL_STORAGE

        return if (ActivityCompat.checkSelfPermission(
                this,
                readPermission
            ) == PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(
                this,
                writePermission
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            true
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(readPermission, writePermission),
                PERMISSION_REQ_CODE
            )
            false
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray,
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            val intent = GalleryActivity.getIntent(this@MainActivity)
            startActivity(intent)
        }
    }

    companion object {
        const val PERMISSION_REQ_CODE = 1010
    }
}