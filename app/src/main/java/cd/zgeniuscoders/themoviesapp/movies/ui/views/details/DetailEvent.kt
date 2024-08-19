package cd.zgeniuscoders.themoviesapp.movies.ui.views.details

sealed class DetailEvent {
    data object OnSearchChanged: DetailEvent()
}