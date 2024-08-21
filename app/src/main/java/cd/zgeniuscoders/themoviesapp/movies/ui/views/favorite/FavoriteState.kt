package cd.zgeniuscoders.themoviesapp.movies.ui.views.favorite

import cd.zgeniuscoders.themoviesapp.movies.domain.models.Movie

data class FavoriteState(
    val isLoading: Boolean = true,
    val movies: List<Movie> = emptyList()
)
