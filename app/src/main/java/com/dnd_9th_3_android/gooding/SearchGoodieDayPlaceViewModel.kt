package com.dnd_9th_3_android.gooding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dnd_9th_3_android.gooding.data.model.KakaoMapData
import com.dnd_9th_3_android.gooding.data.repository.KakaoMapAddressRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchGoodieDayPlaceViewModel @Inject constructor(
    private val kakaoMapAddressRepository: KakaoMapAddressRepository,
) : ViewModel() {

    sealed class UiState {
        object SearchPlaceFailed : UiState()

        data class SearchPlaceSuccess(
            val mapAddressList: List<KakaoMapData>,
        ) : UiState()

        object Idle : UiState()
    }

    private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    val searchKeyword: MutableLiveData<String> = MutableLiveData()

    private val _emptyStateMessage =
        MutableLiveData("getApplication<Application>().getString(R.string.no_place_found)")
    val emptyStateMessage: LiveData<String>
        get() = _emptyStateMessage

    private val mapAddressList = mutableListOf<KakaoMapData>()

    fun searchPlace(query: String) {
        viewModelScope.launch {
            kotlin.runCatching {
                kakaoMapAddressRepository.getKakaoMapAddress(query)
            }
                .onSuccess {
                    mapAddressList.addAll(mapAddressList)
                }
                .onFailure {
                    it.printStackTrace()
                }
        }
    }
}