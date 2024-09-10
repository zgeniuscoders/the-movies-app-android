package cd.zgeniuscoders.themoviesapp.common.routes

import cd.zgeniuscoders.themoviesapp.movies.domain.models.Movie
import kotlinx.serialization.Serializable

@Serializable
sealed class Route(val route: String){

    data object splashscreen : Route("splashscreen")

    @Serializable
    data object homepage: Route("home_page")
    data object settingspage: Route("settings")
    data object profile: Route("profile_page")
    data object search: Route("search_page")
    data object favorite: Route("favorite_page")

    data object login : Route("login")
    data object register : Route("register")
    data object reset_password : Route("reset_password")
    data object forgot_password : Route("forgot_password")

    @Serializable
    data object detail: Route("detail_page")

}

@Serializable
data class DetailRoute(
    val movie: Movie
)

