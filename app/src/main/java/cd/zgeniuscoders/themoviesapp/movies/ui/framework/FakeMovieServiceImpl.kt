package cd.zgeniuscoders.themoviesapp.movies.ui.framework

import cd.zgeniuscoders.themoviesapp.R
import cd.zgeniuscoders.themoviesapp.movies.domain.models.Movie
import cd.zgeniuscoders.themoviesapp.movies.domain.services.MovieServices

class FakeMovieServiceImpl : MovieServices {
    override suspend fun getMovie(id: String): Movie {
        return FakeMovieDb.getMovie(id.toInt())
    }

    override suspend fun getMovies(): List<Movie> {
        return FakeMovieDb.getMovies()
    }
}