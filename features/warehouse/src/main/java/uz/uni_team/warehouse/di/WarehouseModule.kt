package uz.uni_team.warehouse.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import uz.uni_team.warehouse.ui.WarehouseViewModel

val wareHouseModule = module {
    viewModelOf(::WarehouseViewModel)
}