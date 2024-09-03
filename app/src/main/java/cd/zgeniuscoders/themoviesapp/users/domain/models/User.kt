package cd.zgeniuscoders.themoviesapp.users.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: String,
    val username: String,
    val email: String
)
