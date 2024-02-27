package uz.uni_team.registration.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import uz.uni_team.registration.ui.main.RegistrationViewModel

val registrationModule = module {
    viewModelOf(::RegistrationViewModel)
}
