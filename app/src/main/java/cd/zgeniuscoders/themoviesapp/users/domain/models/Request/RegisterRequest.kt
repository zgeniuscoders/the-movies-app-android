package cd.zgeniuscoders.themoviesapp.users.domain.models.Request

import cd.zgeniuscoders.themoviesapp.users.domain.models.User


data class RegisterRequest(
    val username: String,
    val password: String,
    val email: String,
){

    fun toModel(): User {
        return User("0",username,email)
    }

}