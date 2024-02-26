package uz.uni_team.uni_shop.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.dynamic.within
import com.ramcosta.composedestinations.navigation.navigate
import kotlinx.coroutines.delay
import uz.uni_team.core_ui.theme.UniShopTheme
import uz.uni_team.registration.navigation.registrationNavGraph
import uz.uni_team.registration.ui.destinations.RegistrationScreenDestination
import uz.uni_team.uni_shop.R
import uz.uni_team.uni_shop.navigation.RootNavGraph


@Destination(start = true)
@Composable
fun SplashScreen(navController: NavController) {

    LaunchedEffect(key1 = Unit) {
        delay(3000)
        println("--------Splash end--------")
        navController.navigate(RegistrationScreenDestination() within registrationNavGraph)
    }

    SplashScreenContent()
}

@Composable
fun SplashScreenContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "",
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = stringResource(id = R.string.app_name), color = Color.White, fontSize = 32.sp
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SplashScreenPreview() {
    UniShopTheme(darkTheme = true, dynamicColor = false) {
        SplashScreenContent()
    }
}