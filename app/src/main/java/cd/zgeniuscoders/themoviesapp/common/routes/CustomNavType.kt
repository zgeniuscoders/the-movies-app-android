package cd.zgeniuscoders.themoviesapp.common.routes

import android.os.Bundle
import androidx.navigation.NavType
import cd.zgeniuscoders.themoviesapp.movies.domain.models.Movie

object CustomNavType {

    val MovieType = object : NavType<Movie>(isNullableAllowed = false) {
        override fun get(bundle: Bundle, key: String): Movie? {
            TODO("Not yet implemented")
        }

        override fun parseValue(value: String): Movie {
            TODO("Not yet implemented")
        }

        override fun put(bundle: Bundle, key: String, value: Movie) {
            TODO("Not yet implemented")
        }

    }

}