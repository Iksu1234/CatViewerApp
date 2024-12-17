package com.example.project3.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.project3.Routes
import com.example.project3.viewmodel.HomeViewModel


@Composable
fun HomePage(modifier: Modifier, viewModel: HomeViewModel, navController: NavController) {
    val imageModifier = Modifier
        .size(200.dp)
        .border(
            BorderStroke(width = 5.dp, color = androidx.compose.ui.graphics.Color.LightGray),
            RoundedCornerShape(16.dp)
        )
        .clip(RoundedCornerShape(16.dp))
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = com.example.project3.R.drawable.nyytt),
            contentDescription = "kissa",
            contentScale = ContentScale.Crop,
            modifier = imageModifier
        )
        Text(text="Cat viewer app", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Button(onClick = {
            navController.navigate(Routes.image)
        }
        ) { Text(text="Go to Image Page") }
    }

}




