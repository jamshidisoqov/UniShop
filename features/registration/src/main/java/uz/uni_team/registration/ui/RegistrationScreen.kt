package uz.uni_team.registration.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun RegistrationScreen(navController: NavController) {
    Text(text = "Register")
}