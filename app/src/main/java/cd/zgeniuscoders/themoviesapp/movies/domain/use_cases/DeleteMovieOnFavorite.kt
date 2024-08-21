package cd.zgeniuscoders.themoviesapp.movies.domain.use_cases

import cd.zgeniuscoders.themoviesapp.movies.domain.models.Movie
import cd.zgeniuscoders.themoviesapp.movies.domain.services.MovieServices

class DeleteMovieOnFavorite(val services: MovieServices)  {
    suspend fun run(movie: Movie) {
        services.deleteMovie(movie)
    }
}