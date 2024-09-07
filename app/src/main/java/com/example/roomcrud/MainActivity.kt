package com.example.roomcrud

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.example.roomcrud.navigation.UserManager
import com.example.roomcrud.room.UserDatabase
import com.example.roomcrud.ui.theme.RoomCRUDTheme
import com.example.roomcrud.viewmodels.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier
                    .fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                val database = Room.databaseBuilder(this,UserDatabase::class.java,"db_user").build()
                val dao = database.UserDao()
                val viewModel = UserViewModel(dao)
                UserManager(viewModel = viewModel)
            }
        }
    }
}

@Preview
@Composable
fun GreetingPreview() {

}