package cd.zgeniuscoders.themoviesapp.movies.domain.services

import cd.zgeniuscoders.themoviesapp.movies.domain.models.Movie

interface MovieServices {

    suspend fun getMovie(id: String): Movie

    suspend fun getMovies(): List<Movie>

}