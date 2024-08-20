package cd.zgeniuscoders.themoviesapp.movies.ui.framework

import cd.zgeniuscoders.themoviesapp.movies.domain.models.Category
import cd.zgeniuscoders.themoviesapp.movies.domain.services.CategoryServices

class FakeCategoryServiceImpl : CategoryServices {
    override suspend fun getCategory(id: String): Category {
        return FakeCategoryDb.getCategory(id.toInt())
    }

    override suspend fun getCategories(): List<Category> {
        return FakeCategoryDb.getCategories()
    }
}