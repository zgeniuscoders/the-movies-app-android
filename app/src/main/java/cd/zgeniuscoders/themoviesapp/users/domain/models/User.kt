package cd.zgeniuscoders.themoviesapp.users.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: String,
    val name: String,
    val email: String,
    val email_verified_at: String? = null,
    val created_at: String? = null,
    val updated_at: String? = null,
)
