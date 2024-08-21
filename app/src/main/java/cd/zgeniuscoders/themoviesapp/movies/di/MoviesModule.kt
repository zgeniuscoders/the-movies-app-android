package cd.zgeniuscoders.themoviesapp.movies.di

import androidx.room.Room
import cd.zgeniuscoders.themoviesapp.movies.domain.interactors.CategoryInteractor
import cd.zgeniuscoders.themoviesapp.movies.domain.interactors.MovieDaoInteractor
import cd.zgeniuscoders.themoviesapp.movies.domain.interactors.MovieInteractor
import cd.zgeniuscoders.themoviesapp.movies.ui.framework.FakeCategoryServiceImpl
import cd.zgeniuscoders.themoviesapp.movies.ui.framework.FakeMovieServiceImpl
import cd.zgeniuscoders.themoviesapp.movies.ui.framework.room.MovieDao
import cd.zgeniuscoders.themoviesapp.movies.ui.framework.room.MovieDatabase
import cd.zgeniuscoders.themoviesapp.movies.ui.framework.room.MovieRoomServiceImpl
import cd.zgeniuscoders.themoviesapp.movies.ui.views.details.DetailViewModel
import cd.zgeniuscoders.themoviesapp.movies.ui.views.favorite.FavoriteViewModel
import cd.zgeniuscoders.themoviesapp.movies.ui.views.home.HomeViewModel
import cd.zgeniuscoders.themoviesapp.movies.ui.views.search.SearchViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val moviesModule = module {

    single<MovieDao> {

        val appContext = androidContext()
        Room.databaseBuilder(
            appContext,
            MovieDatabase::class.java,
            "themoviesapp"
        ).allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
            .MovieDao()

    }

    single<CategoryInteractor> {
        val serviceImpl = FakeCategoryServiceImpl()
        CategoryInteractor.build(serviceImpl)
    }

    single<MovieInteractor> {
        val serviceImpl = FakeMovieServiceImpl()
        MovieInteractor.build(serviceImpl)
    }

    single<MovieDaoInteractor> {
        val movieDao = get<MovieDao>()

        val serviceImpl = MovieRoomServiceImpl(movieDao)
        MovieDaoInteractor.build(serviceImpl)
    }

    viewModel<HomeViewModel> {
        val movieInteractor=get<MovieInteractor>()
        val categoryInteractor=get<CategoryInteractor>()

        HomeViewModel(movieInteractor,categoryInteractor)
    }

    viewModel<DetailViewModel> {
        val movieDaoInteractor = get<MovieDaoInteractor>()
        DetailViewModel(movieDaoInteractor)
    }

    viewModel<SearchViewModel> {
        val movieInteractor=get<MovieInteractor>()
        val categoryInteractor=get<CategoryInteractor>()

        SearchViewModel(movieInteractor,categoryInteractor)
    }

    viewModel<FavoriteViewModel> {
        val movieInteractor = get<MovieDaoInteractor>()
        FavoriteViewModel(movieInteractor)
    }

}