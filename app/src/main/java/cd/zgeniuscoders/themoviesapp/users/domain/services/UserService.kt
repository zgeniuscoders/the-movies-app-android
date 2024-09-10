package cd.zgeniuscoders.themoviesapp.users.domain.services

import cd.zgeniuscoders.themoviesapp.common.UserSettings
import cd.zgeniuscoders.themoviesapp.users.domain.models.Request.ForgotPasswordRequest
import cd.zgeniuscoders.themoviesapp.users.domain.models.Request.LoginRequest
import cd.zgeniuscoders.themoviesapp.users.domain.models.Request.RegisterRequest
import cd.zgeniuscoders.themoviesapp.users.domain.models.Request.ResetPasswordRequest
import cd.zgeniuscoders.themoviesapp.users.domain.models.Response.UserResponse

interface UserService {

    suspend fun login(request: LoginRequest): UserResponse

    suspend fun register(request: RegisterRequest): UserResponse

    suspend fun forgotPassword(request: ForgotPasswordRequest)

    suspend fun resetPassword(request: ResetPasswordRequest)

    suspend fun saveUserInPref(userSettings: UserSettings)
}