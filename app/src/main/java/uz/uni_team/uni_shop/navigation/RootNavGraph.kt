package uz.uni_team.uni_shop.navigation

import com.ramcosta.composedestinations.dynamic.routedIn
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.ramcosta.composedestinations.spec.Route
import uz.uni_team.home.navigation.homeNavGraph
import uz.uni_team.registration.navigation.registrationNavGraph
import uz.uni_team.uni_shop.ui.destinations.OnboardScreenDestination
import uz.uni_team.uni_shop.ui.destinations.SplashScreenDestination
import uz.uni_team.warehouse.navigation.warehouseNavGraph

object RootNavGraph {

    val root = object : NavGraphSpec {
        override val route: String = "root"
        override val startRoute: Route = splashGraph
        override val destinationsByRoute = emptyMap<String, DestinationSpec<*>>()
        override val nestedNavGraphs: List<NavGraphSpec> = listOf(
            splashGraph,
            registrationNavGraph,
            homeNavGraph,
            warehouseNavGraph
        )
    }
}

val splashGraph = object : NavGraphSpec {
    override val route = "SPLASH_GRAPH"
    override val startRoute = SplashScreenDestination routedIn this
    override val destinationsByRoute = listOf<DestinationSpec<*>>(
        SplashScreenDestination,
        OnboardScreenDestination
    ).routedIn(this).associateBy { it.route }
}
