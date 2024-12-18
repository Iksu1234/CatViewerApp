package com.example.project3.view

import android.media.Image
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.project3.Routes
import com.example.project3.viewmodel.ImageViewModel

@Composable
fun ImagePage(modifier: Modifier, viewModel: ImageViewModel, navController: NavController) {

    val imageData = viewModel.imageData.observeAsState()
    val imageDatas = viewModel.imageDatas.observeAsState()
    val isLoading = viewModel.isLoading.observeAsState()
    val singleIsClicked = viewModel.singleIsClicked.observeAsState()
    val manyIsClicked = viewModel.manyIsClicked.observeAsState()


    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isLoading.value == true) {
            CircularProgressIndicator()
        } else if (isLoading.value == false && manyIsClicked.value == true) {
            LazyVerticalGrid(modifier = Modifier.requiredSize(width = 400.dp, height = 400.dp), contentPadding = PaddingValues(5.dp), columns = GridCells.Fixed(2)) {
                items(imageDatas.value?.size ?: 0) {
                    AsyncImage(
                        contentScale = ContentScale.Crop,
                        modifier =
                        Modifier.fillMaxSize()
                        .border(BorderStroke(1.dp, androidx.compose.ui.graphics.Color.LightGray)),
                        model = "${imageDatas.value?.get(it)?.url}",
                        contentDescription = "a cat",
                    )
                }
            }
        }
        else if (isLoading.value == false && singleIsClicked.value == true) {
            AsyncImage(
                model = "${imageData.value?.url}",
                contentDescription = "a cat",
            )}
        Row {
            Button(onClick = {
                viewModel.getImageData()
            }, Modifier.padding(10.dp)) {
                Text(text = "Get a cat image")
            }
            Button(onClick = {
                viewModel.getManyImageData()
            }, Modifier.padding(10.dp)) {
                Text(text = "Get many cat images")
            }
        }
        Button(onClick = {
            navController.navigate(Routes.home)
        }
        ) { Text(text = "Go to Home Page") }
    }

}
