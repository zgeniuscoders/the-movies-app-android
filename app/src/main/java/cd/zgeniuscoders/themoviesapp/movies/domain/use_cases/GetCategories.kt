package cd.zgeniuscoders.themoviesapp.movies.domain.use_cases

import cd.zgeniuscoders.themoviesapp.movies.domain.models.Category
import cd.zgeniuscoders.themoviesapp.movies.domain.services.CategoryServices

class GetCategories(private val services: CategoryServices) {

    suspend fun run(): List<Category> {
        return services.getCategories()
    }

}