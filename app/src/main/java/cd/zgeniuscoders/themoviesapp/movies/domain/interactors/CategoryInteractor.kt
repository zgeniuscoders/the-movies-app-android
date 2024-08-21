package cd.zgeniuscoders.themoviesapp.movies.domain.interactors

import cd.zgeniuscoders.themoviesapp.movies.domain.services.CategoryServices
import cd.zgeniuscoders.themoviesapp.movies.domain.use_cases.GetCategories
import cd.zgeniuscoders.themoviesapp.movies.domain.use_cases.GetCategory

class CategoryInteractor private constructor(
    val getCategories: GetCategories,
    val getCategory: GetCategory
) {

    companion object {
        fun build(services: CategoryServices): CategoryInteractor {
            return CategoryInteractor(
                GetCategories(services),
                GetCategory(services)
            )
        }
    }


}