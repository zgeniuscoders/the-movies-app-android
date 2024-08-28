package cd.zgeniuscoders.themoviesapp.users.ui.framework

import cd.zgeniuscoders.themoviesapp.users.domain.models.Request.ForgotPasswordRequest
import cd.zgeniuscoders.themoviesapp.users.domain.models.Request.LoginRequest
import cd.zgeniuscoders.themoviesapp.users.domain.models.Request.RegisterRequest
import cd.zgeniuscoders.themoviesapp.users.domain.models.Request.ResetPasswordRequest
import cd.zgeniuscoders.themoviesapp.users.domain.services.UserService

class UserServiceImpl : UserService {
    override suspend fun login(request: LoginRequest) {
        TODO("Not yet implemented")
    }

    override suspend fun register(request: RegisterRequest) {
        TODO("Not yet implemented")
    }

    override suspend fun forgotPassword(request: ForgotPasswordRequest) {
        TODO("Not yet implemented")
    }

    override suspend fun resetPassword(request: ResetPasswordRequest) {
        TODO("Not yet implemented")
    }
}