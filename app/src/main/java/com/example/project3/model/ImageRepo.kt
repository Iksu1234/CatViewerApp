package com.example.project3.model

import retrofit2.http.GET


class ImageRepo {

    interface ImageApiService {
        @GET("search")
        suspend fun getImage(): List<ImageData>
    }

}