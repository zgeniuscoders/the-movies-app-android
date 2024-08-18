package cd.zgeniuscoders.themoviesapp.common.routes

sealed class Route(val route: String){
    data object homepage: Route("home_page")
    data object settingspage: Route("settings")
    data object profile: Route("profile")
    data object search: Route("search_page")
}