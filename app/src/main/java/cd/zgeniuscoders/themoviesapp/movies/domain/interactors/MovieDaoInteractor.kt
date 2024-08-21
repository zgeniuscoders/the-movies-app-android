package cd.zgeniuscoders.themoviesapp.movies.domain.interactors

import cd.zgeniuscoders.themoviesapp.movies.domain.services.MovieServices
import cd.zgeniuscoders.themoviesapp.movies.domain.use_cases.AddMovieOnFavorite
import cd.zgeniuscoders.themoviesapp.movies.domain.use_cases.DeleteMovieOnFavorite
import cd.zgeniuscoders.themoviesapp.movies.domain.use_cases.GetMovie
import cd.zgeniuscoders.themoviesapp.movies.domain.use_cases.GetMovies

class MovieDaoInteractor private constructor(
    val getMovies: GetMovies,
    val getMovie: GetMovie,
    val addMovie: AddMovieOnFavorite,
    val deleteMovie: DeleteMovieOnFavorite,
){
    companion object {
        fun build(service: MovieServices): MovieDaoInteractor {
            return MovieDaoInteractor(
                GetMovies(service),
                GetMovie(service),
                AddMovieOnFavorite(service),
                DeleteMovieOnFavorite(service)
            )
        }
    }
}