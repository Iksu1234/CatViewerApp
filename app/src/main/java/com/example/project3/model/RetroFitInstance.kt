package com.example.project3.model

// Import the HikingApiService interface to create an instance of it using Retrofit.
import com.example.project3.model.ImageRepo.ImageApiService

// Import Retrofit and GsonConverterFactory.
// Retrofit is a popular HTTP client for making network requests in Android.
// GsonConverterFactory converts JSON responses into Kotlin objects using the Gson library.
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Define the `RetrofitInstance` object as a singleton.
// This ensures only one instance of Retrofit is created and used throughout the app.
object RetrofitInstance {

    // Create a `val` property `api` of type `HikingApiService`.
    // The `by lazy` keyword ensures the instance is created only when first accessed (lazy initialization).
    val api: ImageApiService by lazy {

        // Build a Retrofit instance using the Builder pattern.
        Retrofit.Builder()
            // Set the base URL for the API calls. This is the root URL for Mocky.io endpoints.
            .baseUrl("https://api.thecatapi.com/v1/images/")

            // Add a converter factory to convert JSON responses into Kotlin data classes using Gson.
            .addConverterFactory(GsonConverterFactory.create())

            // Call `build()` to create the Retrofit instance with the specified configuration.
            .build()

            // Create an implementation of the `HikingApiService` interface.
            .create(ImageApiService::class.java)
    }
}