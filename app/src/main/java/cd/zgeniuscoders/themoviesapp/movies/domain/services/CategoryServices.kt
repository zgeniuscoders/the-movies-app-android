package cd.zgeniuscoders.themoviesapp.movies.domain.services

import cd.zgeniuscoders.themoviesapp.movies.domain.models.Category

interface CategoryServices {

    suspend fun getCategory(id: String): Category

    suspend fun getCategories(): List<Category>

}