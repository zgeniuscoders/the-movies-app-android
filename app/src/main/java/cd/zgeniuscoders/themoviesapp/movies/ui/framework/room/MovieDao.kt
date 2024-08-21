package cd.zgeniuscoders.themoviesapp.movies.ui.framework.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MovieDao {

    @Insert
    suspend fun add(movie: MovieEntity)

    @Delete
    suspend fun delete(movie: MovieEntity)

    @Query("SELECT * FROM movies")
    fun all(): List<MovieEntity>

    @Query("SELECT * FROM movies WHERE id = :id")
    fun find(id: String): MovieEntity?

}