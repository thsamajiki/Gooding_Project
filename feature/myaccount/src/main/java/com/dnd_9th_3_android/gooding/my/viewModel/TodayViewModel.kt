package com.dnd_9th_3_android.gooding.my.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.*
import javax.inject.Inject

@HiltViewModel
class TodayViewModel @Inject constructor(): ViewModel() {
    var _todayCalendar = MutableLiveData<Calendar>() //오늘 데이터
    val todayCalendar : LiveData<Calendar> get() = _todayCalendar
    var currentYear  = 0
    var currentMonth  = 0
    init {
        _todayCalendar.value = Calendar.getInstance()
        currentYear = todayCalendar.value!!.get(Calendar.YEAR)
        currentMonth = todayCalendar.value!!.get(Calendar.MONTH)+1
    }
}