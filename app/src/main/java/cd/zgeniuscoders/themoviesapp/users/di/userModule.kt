package cd.zgeniuscoders.themoviesapp.users.di

import cd.zgeniuscoders.themoviesapp.users.ui.views.profile.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val userModule = module {


    viewModel<ProfileViewModel> {
        ProfileViewModel()
    }


}