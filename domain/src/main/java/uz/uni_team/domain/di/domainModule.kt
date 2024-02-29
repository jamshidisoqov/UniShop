package uz.uni_team.domain.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import uz.uni_team.domain.auth.AuthUseCase

val domainModule  = module {
    factoryOf(::AuthUseCase)
}