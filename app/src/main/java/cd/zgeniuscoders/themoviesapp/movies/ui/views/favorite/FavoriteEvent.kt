package cd.zgeniuscoders.themoviesapp.movies.ui.views.favorite

sealed class FavoriteEvent {
    data object OnSearchChanged: FavoriteEvent()
}