package cd.zgeniuscoders.themoviesapp.users.di

import cd.zgeniuscoders.themoviesapp.users.domain.services.UserService
import cd.zgeniuscoders.themoviesapp.users.ui.framework.UserServiceImpl
import cd.zgeniuscoders.themoviesapp.users.ui.views.forgot_password.ForgotPasswordViewModel
import cd.zgeniuscoders.themoviesapp.users.ui.views.login.LoginViewModel
import cd.zgeniuscoders.themoviesapp.users.ui.views.opt_verification.OptVerificationViewModel
import cd.zgeniuscoders.themoviesapp.users.ui.views.profile.ProfileViewModel
import cd.zgeniuscoders.themoviesapp.users.ui.views.register.RegisterViewModel
import cd.zgeniuscoders.themoviesapp.users.ui.views.reset_password.ResetPasswordViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val userModule = module {

    single<UserService> {
        UserServiceImpl()
    }

    viewModel<ProfileViewModel> {
        ProfileViewModel()
    }

    viewModel<LoginViewModel> {
        val service = get<UserService>()
        LoginViewModel(service)
    }

    viewModel<RegisterViewModel> {
        val service = get<UserService>()
        RegisterViewModel(service)
    }

    viewModel<ResetPasswordViewModel> {
        val service = get<UserService>()
        ResetPasswordViewModel(service)
    }

    viewModel<ForgotPasswordViewModel> {
        val service = get<UserService>()
        ForgotPasswordViewModel(service)
    }

    viewModel<OptVerificationViewModel> {
        val service = get<UserService>()
        OptVerificationViewModel(service)
    }

}