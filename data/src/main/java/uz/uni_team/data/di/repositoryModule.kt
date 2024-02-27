package uz.uni_team.data.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import uz.uni_team.data.repository.AuthRepository
import uz.uni_team.data.repository.AuthRepositoryImpl

val repositoryModule = module {
    singleOf(::AuthRepositoryImpl) bind AuthRepository::class
}