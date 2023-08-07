package com.dnd_9th_3_android.gooding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MyGoodingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        return inflater.inflate(R.layout.fragment_my_gooding, container, false)
    }

    companion object {
        fun newInstance() = MyGoodingFragment()
    }
}