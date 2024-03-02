package uz.uni_team.uni_shop.navigation.callBuilders

import com.ramcosta.composedestinations.dynamic.within
import com.ramcosta.composedestinations.manualcomposablecalls.ManualComposableCallsBuilder
import com.ramcosta.composedestinations.manualcomposablecalls.composable
import com.ramcosta.composedestinations.navigation.navigate
import uz.uni_team.home.ui.HomeScreen
import uz.uni_team.home.ui.destinations.HomeScreenDestination
import uz.uni_team.warehouse.navigation.warehouseNavGraph
import uz.uni_team.warehouse.ui.destinations.WarehouseScreenDestination

fun ManualComposableCallsBuilder.homeCallBuilders(){
    composable(HomeScreenDestination){
        HomeScreen(
            onClickWareHouse = {
                navController.navigate(WarehouseScreenDestination() within warehouseNavGraph)
            }
        )
    }
}