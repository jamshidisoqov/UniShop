package uz.uni_team.uni_shop.navigation.callBuilders

import com.ramcosta.composedestinations.dynamic.within
import com.ramcosta.composedestinations.manualcomposablecalls.ManualComposableCallsBuilder
import com.ramcosta.composedestinations.manualcomposablecalls.composable
import com.ramcosta.composedestinations.navigation.navigate
import uz.uni_team.home.navigation.homeNavGraph
import uz.uni_team.home.ui.destinations.HomeScreenDestination
import uz.uni_team.registration.ui.destinations.RegistrationScreenDestination
import uz.uni_team.registration.ui.main.RegistrationScreen

fun ManualComposableCallsBuilder.registrationCallBuilder() {
    composable(RegistrationScreenDestination) {
        RegistrationScreen(
            onNavigateToHome = {
                navController.navigate(HomeScreenDestination() within homeNavGraph)
            },
        )
    }
}