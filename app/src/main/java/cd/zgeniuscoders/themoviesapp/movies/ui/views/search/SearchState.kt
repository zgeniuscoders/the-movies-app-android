package cd.zgeniuscoders.themoviesapp.movies.ui.views.search

import cd.zgeniuscoders.themoviesapp.movies.domain.models.Category
import cd.zgeniuscoders.themoviesapp.movies.domain.models.Movie

data class SearchState(
    val search: String = "",
    val movies: List<Movie> = emptyList(),
    val categories: List<Category> = emptyList(),
    val isLoading: Boolean = true,
    val originMoviesList: List<Movie> = emptyList(),
)
