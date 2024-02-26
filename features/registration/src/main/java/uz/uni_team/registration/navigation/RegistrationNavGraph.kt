package uz.uni_team.registration.navigation

import com.ramcosta.composedestinations.dynamic.routedIn
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.ramcosta.composedestinations.spec.Route
import uz.uni_team.registration.ui.destinations.ForgotPasswordScreenDestination
import uz.uni_team.registration.ui.destinations.RegistrationScreenDestination

val registrationNavGraph = object : NavGraphSpec {

    override val route: String = "REGISTRATION_GRAPH"

    override val startRoute: Route = RegistrationScreenDestination routedIn this

    override val destinationsByRoute = listOf<DestinationSpec<*>>(
        RegistrationScreenDestination,
        ForgotPasswordScreenDestination
    ).routedIn(this).associateBy { it.route }

}