package com.example.project3

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.project3.ui.theme.Project3Theme
import com.example.project3.view.HomePage
import com.example.project3.view.ImagePage
import com.example.project3.viewmodel.HomeViewModel
import com.example.project3.viewmodel.ImageViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val homeViewModel = ViewModelProvider(this)[HomeViewModel::class]
        val imageViewModel = ViewModelProvider(this)[ImageViewModel::class]


        setContent {
            Project3Theme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Routes.home, builder = {
                    composable(Routes.home){
                        HomePage(Modifier, homeViewModel, navController)
                    }
                    composable(Routes.image){
                        ImagePage(Modifier, imageViewModel, navController)
                    }
                })
            }
        }
    }
}
