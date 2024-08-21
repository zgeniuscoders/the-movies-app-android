package cd.zgeniuscoders.themoviesapp.movies.ui.views.details

import cd.zgeniuscoders.themoviesapp.movies.domain.models.Movie

data class DetailState(
    val search: String = "",
    val isFavorite: Boolean = false,
    val isLoading: Boolean = true,
    val movie: Movie? = null,
)
