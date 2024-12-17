package com.example.project3.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import com.example.project3.viewmodel.HomeViewModel

@Composable
fun HomePage(modifier: Modifier, viewModel: HomeViewModel) {

    val imageData = viewModel.imageData.observeAsState()
    val isLoading = viewModel.isLoading.observeAsState()

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick ={
            viewModel.getImageData()
        } ) {
            Text(text="Get Image Data")
        }
        if (isLoading.value == true) {
            CircularProgressIndicator()
        }else{
        imageData.value?.name?.let {
            Text(text = "Name: $it")
        }
        imageData.value?.description?.let {
            Text(text = "Desc: $it")
        }}
    }
}