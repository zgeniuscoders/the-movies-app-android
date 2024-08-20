package cd.zgeniuscoders.themoviesapp.movies.di

import cd.zgeniuscoders.themoviesapp.movies.domain.interactors.CategoryInteractor
import cd.zgeniuscoders.themoviesapp.movies.domain.interactors.MovieInteractor
import cd.zgeniuscoders.themoviesapp.movies.ui.framework.FakeCategoryServiceImpl
import cd.zgeniuscoders.themoviesapp.movies.ui.framework.FakeMovieServiceImpl
import cd.zgeniuscoders.themoviesapp.movies.ui.views.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val moviesModule = module {

    single<CategoryInteractor> {
        val serviceImpl = FakeCategoryServiceImpl()
        CategoryInteractor.build(serviceImpl)
    }

    single<MovieInteractor> {
        val serviceImpl = FakeMovieServiceImpl()
        MovieInteractor.build(serviceImpl)
    }

    viewModel<HomeViewModel> {
        val movieInteractor=get<MovieInteractor>()
        val categoryInteractor=get<CategoryInteractor>()

        HomeViewModel(movieInteractor,categoryInteractor)
    }

}