package uz.uni_team.uni_shop.navigation

import com.ramcosta.composedestinations.dynamic.routedIn
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.ramcosta.composedestinations.spec.Route
import uz.uni_team.registration.navigation.registrationNavGraph
import uz.uni_team.uni_shop.ui.destinations.OnboardScreenDestination
import uz.uni_team.uni_shop.ui.destinations.SplashScreenDestination

object RootNavGraph : NavGraphSpec {
    override val destinationsByRoute = emptyMap<String, DestinationSpec<*>>()
    override val route: String = "root"
    override val startRoute: Route = splashGraph
    override val nestedNavGraphs: List<NavGraphSpec> = listOf(
        splashGraph,
        registrationNavGraph
    )
}

val splashGraph = object : NavGraphSpec {
    override val route = "SPLASH_GRAPH"
    override val startRoute = SplashScreenDestination routedIn this
    override val destinationsByRoute = listOf<DestinationSpec<*>>(
        SplashScreenDestination,
        OnboardScreenDestination
    ).routedIn(this).associateBy { it.route }
}
