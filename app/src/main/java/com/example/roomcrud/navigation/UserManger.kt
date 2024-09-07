package com.example.roomcrud.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.roomcrud.viewmodels.UserViewModel
import com.example.roomcrud.views.AddView
import com.example.roomcrud.views.HomeView
import com.example.roomcrud.views.UpdateView

@Composable
fun UserManager(viewModel: UserViewModel){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home"){
            HomeView(navController, viewModel)
        }
        composable("add"){
            AddView(navController, viewModel)
        }
        composable("update/{id}/{firstName}/{lastName}", arguments = listOf(
            navArgument("id"){type = NavType.IntType},
            navArgument("firstName"){type = NavType.StringType},
            navArgument("lastName"){type = NavType.StringType}
        )){
            UpdateView(
                navController,
                viewModel,
                it.arguments!!.getInt("id"),
                it.arguments!!.getString("firstName"),
                it.arguments!!.getString("lastName")
            )
        }
    }
}