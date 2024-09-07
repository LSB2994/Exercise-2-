package com.example.roomcrud.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.roomcrud.models.User
import com.example.roomcrud.viewmodels.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateView(navController: NavController, viewModel: UserViewModel, id:Int, firstName:String?, lastName:String?) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "add view",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "add",
                            tint = Color.White
                        )
                    }
                }
            )
        }
    ) {
        ContentUpdateView(it, navController , viewModel,id,firstName,lastName )
    }
}
@Composable
fun ContentUpdateView(it: PaddingValues, navController: NavController, viewModel: UserViewModel,id: Int,firstName: String?,lastName: String?){
    var firstName by remember { mutableStateOf(firstName) }
    var lastName by remember { mutableStateOf(lastName) }

    Column(
        modifier = Modifier
            .padding(it)
            .padding(top = 30.dp)
            .fillMaxSize()
    ) {
        OutlinedTextField(
            value = firstName?: "",
            onValueChange = {firstName = it},
            label = { Text(text = "first name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
                .padding(bottom = 15.dp)
        )
        OutlinedTextField(
            value = lastName?: "",
            onValueChange = {lastName = it},
            label = { Text(text = "last name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
                .padding(bottom = 15.dp)
        )
        Button(
            onClick = {
                val user = User(id = id, firstName = firstName!!, lastName = lastName!!)
                viewModel.updateUser(user)
                navController.popBackStack()
            }) {
            Text(text = "Update")
        }
    }
}