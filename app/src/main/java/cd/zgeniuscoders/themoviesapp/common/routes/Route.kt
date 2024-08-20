package cd.zgeniuscoders.themoviesapp.common.routes

import cd.zgeniuscoders.themoviesapp.movies.domain.models.Movie
import kotlinx.serialization.Serializable

@Serializable
sealed class Route(val route: String){

    @Serializable
    data object homepage: Route("home_page")
    data object settingspage: Route("settings")
    data object profile: Route("profile")
    data object search: Route("search_page")
    data object favorite: Route("favorite_page")

    @Serializable
    data object detail: Route("detail_page")


}


data class DetailRoute(
    val movie: Movie
)

