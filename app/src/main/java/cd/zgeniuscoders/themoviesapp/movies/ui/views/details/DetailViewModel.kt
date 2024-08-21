package cd.zgeniuscoders.themoviesapp.movies.ui.views.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import cd.zgeniuscoders.themoviesapp.movies.domain.interactors.MovieDaoInteractor

class DetailViewModel(private val movieDaoInteractor: MovieDaoInteractor) : ViewModel() {

    var state by mutableStateOf(DetailState())

    suspend fun onTriggerEvent(event: DetailEvent) {
        when (event) {
            is DetailEvent.OnFavorited -> handlerFavoriteState()
            is DetailEvent.OnMovieAdded -> state = state.copy(movie = event.value)
        }
    }

    private suspend fun handlerFavoriteState() {
        state = state.copy(isFavorite = !state.isFavorite)
        if (state.isFavorite) {
            movieDaoInteractor.addMovie.run(state.movie!!)
        } else {
            movieDaoInteractor.deleteMovie.run(state.movie!!)
        }
    }

    suspend fun isOnFavorite() {
        val movie = movieDaoInteractor.getMovie.run(state.movie!!.id.toString())
        state = if(movie != null){
            state.copy(isFavorite = true)
        }else{
            state.copy(isFavorite = false)
        }
    }

}