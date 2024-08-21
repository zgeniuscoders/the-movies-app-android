package cd.zgeniuscoders.themoviesapp.movies.ui.framework

import cd.zgeniuscoders.themoviesapp.movies.domain.models.Category

class FakeCategoryDb {

    companion object{
        private val categories = listOf(
            Category(1,"Actions"),
            Category(2,"Dramatics"),
            Category(3,"Horrors"),
            Category(5,"Romantics"),
            Category(6,"Thrillers"),
            Category(7,"War"),
            Category(8,"Westerns"),
            Category(9,"Documentaries"),
            Category(10,"Kids"),
            Category(11,"Adult") ,
            Category(12,"Mysteries"),
            Category(13,"Sci-Fi & Fantasy"),
            Category(14,"Comedies"),
            Category(15,"Crime"),
            Category(16,"Family"),
            Category(17,"Fantasy"),
            Category(18,"Sports"),
            Category(19,"News & Politics"),
            Category(20,"Reality TV")
        )

        fun getCategories(): List<Category>{
            return categories
        }

        fun getCategory(id: Int): Category {
            return categories[id]
        }
    }

}