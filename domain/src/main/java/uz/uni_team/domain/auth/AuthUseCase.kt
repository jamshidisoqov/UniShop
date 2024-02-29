package uz.uni_team.domain.auth

import uz.uni_team.data.model.remote.auth.AuthRequest
import uz.uni_team.data.repository.AuthRepository

class AuthUseCase(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(
        phone: String, password: String
    ) {
        return repository.register(AuthRequest(phone = phone, password = password))
    }

}