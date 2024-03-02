package uz.uni_team.data.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import uz.uni_team.data.network.service.auth.AuthService
import uz.uni_team.data.network.service.auth.AuthServiceImpl
import uz.uni_team.data.network.service.category.CategoryService
import uz.uni_team.data.network.service.category.CategoryServiceImpl
import uz.uni_team.data.network.service.product.ProductService
import uz.uni_team.data.network.service.product.ProductServiceImpl

val serviceModule = module {
    singleOf(::AuthServiceImpl) bind AuthService::class
    singleOf(::ProductServiceImpl) bind ProductService::class
    singleOf(::CategoryServiceImpl) bind CategoryService::class
}