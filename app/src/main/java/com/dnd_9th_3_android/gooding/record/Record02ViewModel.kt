package com.dnd_9th_3_android.gooding.record

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dnd_9th_3_android.gooding.data.model.RequestUploadFeed
import com.dnd_9th_3_android.gooding.data.model.UploadRequest
import com.dnd_9th_3_android.gooding.data.repository.UploadFeedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Record02ViewModel @Inject constructor(
    private val uploadFeedRepository: UploadFeedRepository
): ViewModel() {

    sealed class UiState {
        object UploadFeedFailed : UiState()

        object UploadFeedSuccess: UiState()

        object Idle : UiState()
    }

    private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun uploadFeed() {
        viewModelScope.launch {
            kotlin.runCatching {
                uploadFeedRepository.uploadFeed(RequestUploadFeed(
                    thumbnail = "",
                    thumbnailDirectory = "",
                    images = listOf(),
                    videos = listOf(),
                    oauthId = "",
                    uploadRequest = UploadRequest(
                        title = "",
                        description = "",
                        recordDate = "",
                        placeTitle = "",
                        placeLatitude = 0.0,
                        placeLongitude = 0.0,
                        recordOpen = 1,
                        recordScore = ""
                    )
                ))
            }
                .onSuccess {
                    _uiState.value = UiState.UploadFeedSuccess
                }
                .onFailure {
                    _uiState.value = UiState.UploadFeedFailed
                    it.printStackTrace()
                }
        }
    }
}