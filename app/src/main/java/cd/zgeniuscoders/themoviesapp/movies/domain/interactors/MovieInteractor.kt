package cd.zgeniuscoders.themoviesapp.movies.domain.interactors

import cd.zgeniuscoders.themoviesapp.movies.domain.services.MovieServices
import cd.zgeniuscoders.themoviesapp.movies.domain.use_cases.GetMovie
import cd.zgeniuscoders.themoviesapp.movies.domain.use_cases.GetMovies

class MovieInteractor private constructor(
    val getMovies: GetMovies,
    val getMovie: GetMovie
) {
    companion object {
        fun build(service: MovieServices): MovieInteractor {
            return MovieInteractor(
                GetMovies(service),
                GetMovie(service)
            )
        }
    }
}