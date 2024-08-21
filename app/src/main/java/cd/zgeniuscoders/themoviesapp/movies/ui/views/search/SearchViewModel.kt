package cd.zgeniuscoders.themoviesapp.movies.ui.views.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cd.zgeniuscoders.themoviesapp.movies.domain.interactors.CategoryInteractor
import cd.zgeniuscoders.themoviesapp.movies.domain.interactors.MovieInteractor
import kotlinx.coroutines.launch

class SearchViewModel(
    private val movieInteractor: MovieInteractor,
    private val categoryInteractor: CategoryInteractor
) : ViewModel() {

    var state by mutableStateOf(SearchState())

    fun onTriggerEvent(event: SearchEvent) {
        when (event) {
            is SearchEvent.OnSearchChanged -> handlerSearchValueChanged(event.value)
        }
    }

    private fun handlerSearchValueChanged(query: String) {
        state = state.copy(search = query)

        val initialMovies = state.originMoviesList

        val filteredMovies = if (query.isBlank()) {
            initialMovies
        } else {
            initialMovies.filter {
                it.title.startsWith(query, ignoreCase = true) || it.title.contains(
                    query,
                    ignoreCase = true
                )
            }
        }

        state = state.copy(movies = filteredMovies)


    }

    fun getMovies() {
        viewModelScope.launch {
            val movies = movieInteractor.getMovies.run()
            state = state.copy(movies = movies, originMoviesList = movies)
        }
    }

}