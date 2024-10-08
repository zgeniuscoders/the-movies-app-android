package cd.zgeniuscoders.themoviesapp.users.domain.services

import cd.zgeniuscoders.themoviesapp.users.domain.models.Response.UserResponse
import kotlinx.serialization.Serializable
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST


interface UserApi {

    @POST("/api/login/")
    suspend fun login(
        @Header("Content-Type") contentType: String,
        @Body requestBody: RequestBody
    ): UserResponse

    @POST("/api/register/")
    suspend fun register(
        @Header("Content-Type") contentType: String,
        @Body requestBody: RequestBody
    ): UserResponse

}