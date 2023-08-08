package com.dnd_9th_3_android.gooding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.dnd_9th_3_android.gooding.data.model.GalleryImageData
import com.dnd_9th_3_android.gooding.data.repository.GalleryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    private val galleryRepository: GalleryRepository
): ViewModel() {

    sealed class UiState {
        object GetGalleryImageListSuccess : UiState()

        object GetGalleryImageListFailed : UiState()

        object Idle : UiState()
    }

    private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val _imageList = MutableLiveData<PagingData<GalleryImageData>>()
    val imageList: LiveData<PagingData<GalleryImageData>> = _imageList

    suspend fun getGalleryImages() {
        viewModelScope.launch {
            kotlin.runCatching {
                galleryRepository.getGalleryPagingList()
                    .cachedIn(viewModelScope)
                    .collect {
                        _imageList.value = it
                    }
            }
        }
    }

    fun addRecipePhotoList(photoPathList: List<String>) {
//        _imageList.value = _imageList.value + photoPathList
    }

    fun deletePhoto(position: Int) {
//        _imageList.value = _imageList.value
//            ?.map {
//                it
//            }
//            .apply {
//                removeAt(position)
//            }
    }

    companion object {
        fun newInstance() = GalleryActivity()
    }
}