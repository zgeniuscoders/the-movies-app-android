package cd.zgeniuscoders.themoviesapp.movies.domain.use_cases

import cd.zgeniuscoders.themoviesapp.movies.domain.models.Movie
import cd.zgeniuscoders.themoviesapp.movies.domain.services.MovieServices

class GetMovies(private val service: MovieServices) {
    suspend fun run(): List<Movie> {
        return service.getMovies()
    }
}