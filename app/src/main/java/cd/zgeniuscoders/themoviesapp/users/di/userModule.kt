package cd.zgeniuscoders.themoviesapp.users.di

import cd.zgeniuscoders.themoviesapp.users.domain.services.UserApi
import cd.zgeniuscoders.themoviesapp.users.domain.services.UserService
import cd.zgeniuscoders.themoviesapp.users.domain.use_cases.UserInteractor
import cd.zgeniuscoders.themoviesapp.users.ui.framework.UserServiceImpl
import cd.zgeniuscoders.themoviesapp.users.ui.views.forgot_password.ForgotPasswordViewModel
import cd.zgeniuscoders.themoviesapp.users.ui.views.login.LoginViewModel
import cd.zgeniuscoders.themoviesapp.users.ui.views.opt_verification.OptVerificationViewModel
import cd.zgeniuscoders.themoviesapp.users.ui.views.profile.ProfileViewModel
import cd.zgeniuscoders.themoviesapp.users.ui.views.register.RegisterViewModel
import cd.zgeniuscoders.themoviesapp.users.ui.views.reset_password.ResetPasswordViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val userModule = module {

    single<UserApi> {
        Retrofit.Builder()
            .baseUrl("http://192.168.0.101:8000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApi::class.java)
    }

    single<UserService> {
        val api = get<UserApi>()
        UserServiceImpl(api)
    }

    single<UserInteractor> {
        val service = get<UserService>()
        UserInteractor.build(service)
    }

    viewModel<ProfileViewModel> {
        val context = androidContext()
        ProfileViewModel(context)
    }

    viewModel<LoginViewModel> {
        val interactor = get<UserInteractor>()
        LoginViewModel(interactor)
    }

    viewModel<RegisterViewModel> {

        val interactor = get<UserInteractor>()
        val context = androidContext()

        RegisterViewModel(interactor, context)
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