package com.example.project3.view

import android.media.Image
import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.project3.Routes
import com.example.project3.viewmodel.ImageViewModel

@Composable
fun ImagePage(modifier: Modifier, viewModel: ImageViewModel, navController: NavController) {

    val imageData = viewModel.imageData.observeAsState()
    val isLoading = viewModel.isLoading.observeAsState()

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (isLoading.value == true) {
            CircularProgressIndicator()
        }else{
            imageData.value?.url?.let {
                AsyncImage(
                    model = "$it",
                    contentDescription = "a cat",
                )
            }
        }

        Button(onClick ={
            viewModel.getImageData()
        } ) {
            Text(text="Get Image Data")
        }

        Button(onClick = {
            navController.navigate(Routes.home)
        }
        ) { Text(text="Go to Home Page") }
    }
}