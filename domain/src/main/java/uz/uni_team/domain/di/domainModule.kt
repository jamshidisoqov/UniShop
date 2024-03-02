package uz.uni_team.domain.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import uz.uni_team.domain.auth.AuthUseCase
import uz.uni_team.domain.category.GetAllCategoriesUseCase
import uz.uni_team.domain.product.GetAllProductsUseCase

val domainModule = module {
    factoryOf(::AuthUseCase)
    factoryOf(::GetAllCategoriesUseCase)
    factoryOf(::GetAllProductsUseCase)
}