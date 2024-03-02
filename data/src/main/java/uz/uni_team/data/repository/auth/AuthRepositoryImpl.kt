package uz.uni_team.data.repository.auth

import uz.uni_team.data.model.remote.auth.AuthRequest
import uz.uni_team.data.network.service.auth.AuthService

internal class AuthRepositoryImpl(private val service: AuthService) : AuthRepository {
    override suspend fun register(authRequest: AuthRequest) {
        return service.registerUser(authRequest)
    }
}