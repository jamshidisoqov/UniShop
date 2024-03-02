package uz.uni_team.warehouse.navigation

import com.ramcosta.composedestinations.dynamic.routedIn
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.ramcosta.composedestinations.spec.Route
import uz.uni_team.warehouse.ui.destinations.WarehouseScreenDestination

val warehouseNavGraph = object : NavGraphSpec {
    override val route: String = "WAREHOUSE_GRAPH"
    override val startRoute: Route = WarehouseScreenDestination routedIn this
    override val destinationsByRoute = listOf<DestinationSpec<*>>(
        WarehouseScreenDestination
    ).routedIn(this).associateBy { it.route }

}