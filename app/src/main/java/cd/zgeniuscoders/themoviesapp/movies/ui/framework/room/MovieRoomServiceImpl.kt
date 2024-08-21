package cd.zgeniuscoders.themoviesapp.movies.ui.framework.room

import android.util.Log
import cd.zgeniuscoders.themoviesapp.movies.domain.models.Movie
import cd.zgeniuscoders.themoviesapp.movies.domain.services.MovieServices

class MovieRoomServiceImpl(
    private val movieRoom: MovieDao
) : MovieServices {
    override suspend fun getMovie(id: String): Movie? {

        val entity = movieRoom.find(id)

        return entity?.toModel()

    }

    override suspend fun getMovies(): List<Movie> {
        val movies: MutableList<Movie> = mutableListOf()

        val entity = movieRoom.all()
        entity.forEach {
            movies.add(it.toModel())
        }

        return movies
    }

    override suspend fun addMovie(movie: Movie) {
        movieRoom.add(MovieEntity.fromModel(movie))
    }

    override suspend fun deleteMovie(movie: Movie) {
        movieRoom.delete(MovieEntity.fromModel(movie))
    }

}