package uz.uni_team.home.navigation

import com.ramcosta.composedestinations.dynamic.routedIn
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.ramcosta.composedestinations.spec.Route
import uz.uni_team.home.ui.destinations.HomeScreenDestination

val homeNavGraph = object : NavGraphSpec {
    override val route: String = "HOME_GRAPH"
    override val startRoute: Route = HomeScreenDestination routedIn this
    override val destinationsByRoute = listOf<DestinationSpec<*>>(
        HomeScreenDestination
    ).routedIn(this).associateBy { it.route }
}