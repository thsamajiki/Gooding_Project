package com.dnd_9th_3_android.gooding.my.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class TodayViewModel @Inject constructor(): ViewModel() {
    var _todayCalendar = MutableLiveData<Calendar>() //오늘 데이터
    val todayCalendar : LiveData<Calendar> get() = _todayCalendar
    var todayYear  = 0
    var todayMonth  = 0
    var currentYear = 0
    var currentMonth = 0
    init {
        _todayCalendar.value = Calendar.getInstance()
        todayYear = todayCalendar.value!!.get(Calendar.YEAR)
        todayMonth = todayCalendar.value!!.get(Calendar.MONTH)+1
        currentYear = todayYear
        currentMonth = todayMonth
    }
}