package cd.zgeniuscoders.themoviesapp.common

import kotlinx.serialization.Serializable


@Serializable
data class UserSettings(
    val isLogged: Boolean = false,
    val token: String? = null
)