package cd.zgeniuscoders.themoviesapp.common.routes

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import cd.zgeniuscoders.themoviesapp.movies.domain.models.Movie
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object CustomNavType {

    val MovieType = object : NavType<Movie>(isNullableAllowed = false) {
        override fun get(bundle: Bundle, key: String): Movie? {
            return Json.decodeFromString(bundle.getString(key) ?: return null)
        }

        override fun serializeAsValue(value: Movie): String {
            return Uri.encode(Json.encodeToString(value))
        }

        override fun parseValue(value: String): Movie {
            return Json.decodeFromString(value)
        }

        override fun put(bundle: Bundle, key: String, value: Movie) {
            bundle.putString(key, Json.encodeToString(value))
        }

    }

}