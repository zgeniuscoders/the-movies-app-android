package cd.zgeniuscoders.themoviesapp.users.domain.entities

import cd.zgeniuscoders.themoviesapp.users.domain.models.User
import kotlinx.serialization.Serializable

data class UserEntity(
    val message: String,
    val user: User? = null,
    val status: Boolean = false,
    val token: String? = null,
    val errors: List<String>? = null
)