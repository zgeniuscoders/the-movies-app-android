package cd.zgeniuscoders.themoviesapp.movies.ui.views.details

import cd.zgeniuscoders.themoviesapp.movies.domain.models.Movie

sealed class DetailEvent {
    data object OnFavorited: DetailEvent()
    data class OnMovieAdded(val value: Movie): DetailEvent()
}