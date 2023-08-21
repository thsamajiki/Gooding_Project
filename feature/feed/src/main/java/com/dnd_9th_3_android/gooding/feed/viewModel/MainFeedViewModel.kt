package com.dnd_9th_3_android.gooding.feed.viewModel

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dnd_9th_3_android.gooding.model.feed.Feed
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainFeedViewModel @Inject constructor(): ViewModel(){
    private var _feedList = MutableLiveData<ArrayList<Feed>>()
    val feedList : LiveData<ArrayList<Feed>> get() = _feedList
    var currentFeed = MutableLiveData<Feed>()

    fun initFeedData(dataSet : ArrayList<Feed>){
        _feedList.value = dataSet
    }

    fun setCurrentFeed(feed : Feed){
        currentFeed.value = feed
    }

    fun setRomantic(per : Int){
        currentFeed.value?.romanticPer = per
    }
}