package com.dnd_9th_3_android.gooding

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dnd_9th_3_android.gooding.databinding.ActivityGalleryBinding

class GalleryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGalleryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGalleryBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
    }

    companion object {
        fun getIntent(context: Context) =
            Intent(context, GalleryActivity::class.java)
    }
}