package com.example.project3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project3.model.ImageData

import kotlinx.coroutines.launch
import com.example.project3.model.RetrofitInstance


class ImageViewModel : ViewModel()  {

    private val _imageData = MutableLiveData<ImageData>()
    private val _imageDatas = MutableLiveData<List<ImageData>>()

    val imageDatas: LiveData<List<ImageData>> = _imageDatas
    val imageData: LiveData<ImageData> = _imageData

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading : LiveData<Boolean> = _isLoading

    private val _singleIsClicked = MutableLiveData<Boolean>(false)
    val singleIsClicked : LiveData<Boolean> = _singleIsClicked

    private val _manyIsClicked = MutableLiveData<Boolean>(false)
    val manyIsClicked : LiveData<Boolean> = _manyIsClicked

    fun getImageData() {
        _isLoading.postValue(true)
        _manyIsClicked.postValue(false)
        _singleIsClicked.postValue(true)
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getImage()
                _imageData.postValue(response[0])
                _isLoading.postValue(false)
            }catch (e: Exception) {
            // Print the exception stack trace if an error occurs during the network call.
            e.printStackTrace()
        }
        }

    }
    fun getManyImageData() {
        _isLoading.postValue(true)
        _singleIsClicked.postValue(false)
        _manyIsClicked.postValue(true)
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getManyImage()
                _imageDatas.postValue(response)
                _isLoading.postValue(false)
            }catch (e: Exception) {
                // Print the exception stack trace if an error occurs during the network call.
                e.printStackTrace()
            }
        }

    }

}