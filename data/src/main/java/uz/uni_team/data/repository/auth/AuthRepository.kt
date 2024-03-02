package uz.uni_team.data.repository.auth

import uz.uni_team.data.model.remote.auth.AuthRequest

interface AuthRepository {
    suspend fun register(authRequest: AuthRequest)
}