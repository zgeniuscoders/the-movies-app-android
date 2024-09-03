package cd.zgeniuscoders.themoviesapp.users.domain.models.Response

import cd.zgeniuscoders.themoviesapp.users.domain.models.User
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val message: String,
    val user: User? = null,
    val status: Boolean = false,
    val token: String? = null,
    val errors: HashMap<String, List<String>>? = null
)
