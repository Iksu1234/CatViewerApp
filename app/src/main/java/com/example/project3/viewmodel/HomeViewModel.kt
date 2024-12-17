package com.example.project3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project3.model.ImageData
import com.example.project3.model.ImageRepo
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val imageRepo : ImageRepo = ImageRepo()

    private val _imageData = MutableLiveData<ImageData>()
    val imageData: LiveData<ImageData> = _imageData

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading : LiveData<Boolean> = _isLoading

    fun getImageData() {
        _isLoading.postValue(true)
        viewModelScope.launch {
            val imageResult = imageRepo.fetchImageData()
            _imageData.postValue(imageResult)
            _isLoading.postValue(false)

        }

    }
}