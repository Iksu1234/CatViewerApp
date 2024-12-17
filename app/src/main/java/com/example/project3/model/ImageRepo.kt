package com.example.project3.model

import kotlinx.coroutines.delay

class ImageRepo {
    suspend fun fetchImageData() : ImageData{
        // mock api
        delay(2000)
        return ImageData("John","Doe")
    }
}