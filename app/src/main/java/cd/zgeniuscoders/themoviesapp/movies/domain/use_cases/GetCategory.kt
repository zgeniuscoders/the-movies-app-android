package cd.zgeniuscoders.themoviesapp.movies.domain.use_cases

import cd.zgeniuscoders.themoviesapp.movies.domain.models.Category
import cd.zgeniuscoders.themoviesapp.movies.domain.services.CategoryServices

class GetCategory(private val services: CategoryServices) {

    suspend fun run(id: String): Category {
         return services.getCategory(id)
    }

}