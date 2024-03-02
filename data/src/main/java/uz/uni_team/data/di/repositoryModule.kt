package uz.uni_team.data.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import uz.uni_team.data.repository.auth.AuthRepository
import uz.uni_team.data.repository.auth.AuthRepositoryImpl
import uz.uni_team.data.repository.category.CategoryRepository
import uz.uni_team.data.repository.category.CategoryRepositoryImpl
import uz.uni_team.data.repository.product.ProductRepository
import uz.uni_team.data.repository.product.ProductRepositoryImpl

val repositoryModule = module {
    singleOf(::AuthRepositoryImpl) bind AuthRepository::class
    singleOf(::ProductRepositoryImpl) bind ProductRepository::class
    singleOf(::CategoryRepositoryImpl) bind CategoryRepository::class
}