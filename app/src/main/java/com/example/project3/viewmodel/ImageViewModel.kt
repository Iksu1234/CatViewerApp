package com.example.project3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project3.model.ImageData
import com.example.project3.model.ImageRepo
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import com.example.project3.model.RetrofitInstance


class ImageViewModel : ViewModel()  {

    val imageRepo : ImageRepo = ImageRepo()

    private val _imageData = MutableLiveData<ImageData>()
    val imageData: LiveData<ImageData> = _imageData

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading : LiveData<Boolean> = _isLoading

    fun getImageData() {
        _isLoading.postValue(true)
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

}