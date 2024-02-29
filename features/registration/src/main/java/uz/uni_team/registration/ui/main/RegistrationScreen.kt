package uz.uni_team.registration.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ramcosta.composedestinations.annotation.Destination
import org.koin.androidx.compose.koinViewModel

@Destination
@Composable
fun RegistrationScreen(navController: NavController) {
    val viewModel: RegistrationViewModel = koinViewModel()
    val uiState: RegistrationViewModel.RegistrationUiState by viewModel.state.collectAsState()
    RegistrationContent(
        onRegisterClick = viewModel::onRegisterClick,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RegistrationContent(
    onRegisterClick: (phone: String, password: String) -> Unit
) {
    var phoneTextFieldValue: String by remember { mutableStateOf("") }
    var passwordTextFieldValue: String by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize(), topBar = {
            TopAppBar(
                title = { Text(text = "Register", color = Color.White) },
            )
        }, containerColor = Color.Black
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth(),
                value = phoneTextFieldValue,
                onValueChange = {
                    phoneTextFieldValue = it
                },
            )
            TextField(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth(),
                value = passwordTextFieldValue,
                onValueChange = {
                    passwordTextFieldValue = it
                },
                placeholder = {
                    Text(text = "Password")
                },
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth(),
                onClick = {
                    onRegisterClick.invoke(phoneTextFieldValue, passwordTextFieldValue)
                },
                shape = RoundedCornerShape(8.dp),
            ) {
                Text(text = "Register")
            }
        }
    }
}
