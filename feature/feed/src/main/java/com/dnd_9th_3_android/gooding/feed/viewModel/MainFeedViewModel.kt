package com.dnd_9th_3_android.gooding.feed.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dnd_9th_3_android.gooding.model.feed.Feed
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainFeedViewModel @Inject constructor(): ViewModel(){
    private var _feedList = MutableLiveData<List<Feed>>()
    val feedList : LiveData<List<Feed>> get() = _feedList


    fun initFeedData(dataSet : List<Feed>){
        _feedList.value = dataSet
    }

}