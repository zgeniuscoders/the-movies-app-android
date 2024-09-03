package cd.zgeniuscoders.themoviesapp.users.ui.framework

import cd.zgeniuscoders.themoviesapp.users.domain.models.Request.ForgotPasswordRequest
import cd.zgeniuscoders.themoviesapp.users.domain.models.Request.LoginRequest
import cd.zgeniuscoders.themoviesapp.users.domain.models.Request.RegisterRequest
import cd.zgeniuscoders.themoviesapp.users.domain.models.Request.ResetPasswordRequest
import cd.zgeniuscoders.themoviesapp.users.domain.models.Response.UserResponse
import cd.zgeniuscoders.themoviesapp.users.domain.services.UserApi
import cd.zgeniuscoders.themoviesapp.users.domain.services.UserService
import com.google.gson.Gson
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.HttpException
import java.net.ConnectException

class UserServiceImpl(
    private val service: UserApi
) : UserService {
    override suspend fun login(request: LoginRequest): UserResponse {
        var userResponse = UserResponse()

        val contentType = "application/json"
        val requestBody = RequestBody.create(
            MediaType.parse("application/json"),
            Gson().toJson(
                LoginRequest(request.email, request.password)
            )
        )

        try {
            userResponse = service.login(
                contentType,
                requestBody
            )
        } catch (e: HttpException) {
            val res = e.response()?.errorBody()?.string()
            userResponse = Json.decodeFromString<UserResponse>(res!!)

            e.printStackTrace()
        } catch (e: ConnectException) {
            userResponse = UserResponse(
                message = "Connexion failed"
            )

            e.printStackTrace()
        } catch (e: NullPointerException) {
            userResponse = UserResponse(
                message = "An unexpected error occurred."
            )
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }


        return userResponse

    }

    override suspend fun register(request: RegisterRequest): UserResponse {
        var userResponse = UserResponse()

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

        try {

            userResponse = service.register(
                contentType,
                requestBody
            )
        } catch (e: NullPointerException) {

            userResponse = UserResponse(
                message = "An unexpected error occurred."
            )

            e.printStackTrace()

        } catch (e: HttpException) {

            val res = e.response()?.errorBody()?.string()
            userResponse = Json.decodeFromString<UserResponse>(res!!)

            e.printStackTrace()
        } catch (e: ConnectException) {

            userResponse = UserResponse(
                message = "Connexion failed"
            )

            e.printStackTrace()
        }

        return userResponse

    }

    override suspend fun forgotPassword(request: ForgotPasswordRequest) {
        TODO("Not yet implemented")
    }

    override suspend fun resetPassword(request: ResetPasswordRequest) {
        TODO("Not yet implemented")
    }
}