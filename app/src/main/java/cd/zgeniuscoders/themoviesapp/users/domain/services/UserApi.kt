package cd.zgeniuscoders.themoviesapp.users.domain.services

import cd.zgeniuscoders.themoviesapp.users.domain.entities.UserEntity
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface UserApi {

    @POST("/api/login/")
    suspend fun login(
        @Header("Content-Type") contentType: String,
        @Body requestBody: RequestBody
    ): UserEntity

    @POST("/api/register/")
    suspend fun register(
        @Header("Content-Type") contentType: String,
        @Body requestBody: RequestBody
    ): UserEntity

}