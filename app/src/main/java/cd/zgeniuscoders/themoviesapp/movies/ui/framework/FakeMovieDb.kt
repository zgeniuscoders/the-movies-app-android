package cd.zgeniuscoders.themoviesapp.movies.ui.framework

import cd.zgeniuscoders.themoviesapp.R
import cd.zgeniuscoders.themoviesapp.movies.domain.models.Movie


class FakeMovieDb{
    companion object{
        private val movies =  listOf(
            Movie(
                1,
                "nightbooks",
                "bla bla bla",
                "December 11 2022",
                R.drawable.nightbooks,
                "",
                ""
            ),
            Movie(
                2,
                "coco",
                "bla bla bla",
                "Jan 11 2024",
                R.drawable.coco,
                "",
                "",
            ),
            Movie(
                3,
                "aladin",
                "bla bla bla",
                "March 11 2023",
                R.drawable.aladin,
                "",
                ""
            ),
            Movie(
                4,
                "matrixt",
                "",
                "May 11 2023",
                R.drawable.matrix,
                "",
                ""
            ),
            Movie(
                5,
                "onward",
                "",
                "May 11 2023",
                R.drawable.onward,
                "",
                ""
            ),
            Movie(
                6,
                "house of horrors",
                "",
                "May 11 2023",
                R.drawable.house_of_horrors,
                "",
                ""
            )
        )
        fun getMovies(): List<Movie> {
            return movies
        }

        fun getMovie(id: Int): Movie {
            return movies[id]
        }
    }
}
