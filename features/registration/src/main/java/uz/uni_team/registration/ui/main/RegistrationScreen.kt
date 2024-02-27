package uz.uni_team.registration.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.ramcosta.composedestinations.annotation.Destination
import org.koin.androidx.compose.koinViewModel

@Destination
@Composable
fun RegistrationScreen(navController: NavController) {
    val viewModel: RegistrationViewModel = koinViewModel()
    val uiState: RegistrationViewModel.RegistrationUiState by viewModel.state.collectAsState()
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            Button(onClick = viewModel::incrementCount) {
                Text(text = "Increment +")
            }
            Text(text = "Count:${uiState.count}")
            Button(onClick = viewModel::decrementCount) {
                Text(text = "Decrement -")
            }
        }
    }
}