package cd.zgeniuscoders.themoviesapp.users.ui.framework

import cd.zgeniuscoders.themoviesapp.users.domain.entities.UserEntity
import cd.zgeniuscoders.themoviesapp.users.domain.models.Request.ForgotPasswordRequest
import cd.zgeniuscoders.themoviesapp.users.domain.models.Request.LoginRequest
import cd.zgeniuscoders.themoviesapp.users.domain.models.Request.RegisterRequest
import cd.zgeniuscoders.themoviesapp.users.domain.models.Request.ResetPasswordRequest
import cd.zgeniuscoders.themoviesapp.users.domain.services.UserApi
import cd.zgeniuscoders.themoviesapp.users.domain.services.UserService
import com.google.gson.Gson
import okhttp3.MediaType
import okhttp3.RequestBody

class UserServiceImpl(
    private val service: UserApi
) : UserService {
    override suspend fun login(request: LoginRequest): UserEntity {

        val contentType = "application/json"
        val requestBody = RequestBody.create(
            MediaType.parse("application/json"),
            Gson().toJson(
                LoginRequest(request.email, request.password)
            )
        )

        val body = service.login(
            contentType,
            requestBody
        )

        return body

    }

    override suspend fun register(request: RegisterRequest): UserEntity {

        val contentType = "application/json"
        val requestBody = RequestBody.create(
            MediaType.parse("application/json"),
            Gson().toJson(
                RegisterRequest(
                    email = request.email,
                    password = request.password,
                    username = request.username
                )
            )
        )

        val body = service.register(
            contentType,
            requestBody
        )

        return body

    }

    override suspend fun forgotPassword(request: ForgotPasswordRequest) {
        TODO("Not yet implemented")
    }

    override suspend fun resetPassword(request: ResetPasswordRequest) {
        TODO("Not yet implemented")
    }
}