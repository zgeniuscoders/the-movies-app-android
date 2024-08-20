package cd.zgeniuscoders.themoviesapp.movies.domain.use_cases

import cd.zgeniuscoders.themoviesapp.movies.domain.models.Movie
import cd.zgeniuscoders.themoviesapp.movies.domain.services.MovieServices

class GetMovie(private val service: MovieServices) {

    suspend fun run(id: String): Movie {
        return service.getMovie(id)
    }

}