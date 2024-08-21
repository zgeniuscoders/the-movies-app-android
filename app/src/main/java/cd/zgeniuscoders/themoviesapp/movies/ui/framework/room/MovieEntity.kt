package cd.zgeniuscoders.themoviesapp.movies.ui.framework.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import cd.zgeniuscoders.themoviesapp.movies.domain.models.Movie


@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "synopsis")
    val synopsis: String,
    @ColumnInfo(name = "releaseDate")
    val releaseDate: String,
    @ColumnInfo(name = "posterPath")
    val posterPath: Int,
    @ColumnInfo(name = "overview")
    val overview: String,
    @ColumnInfo(name = "category")
    val category: String,
) {

    companion object {
        fun fromModel(data: Movie): MovieEntity {
            return data.run {
                MovieEntity(id, title, synopsis, releaseDate, posterPath, overview, category)
            }
        }
    }


    fun toModel(): Movie {
        return Movie(id, title, synopsis, releaseDate, posterPath, overview, category)

    }
}