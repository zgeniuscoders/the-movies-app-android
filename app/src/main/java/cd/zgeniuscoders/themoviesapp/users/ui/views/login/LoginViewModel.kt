package cd.zgeniuscoders.themoviesapp.users.ui.views.login

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cd.zgeniuscoders.themoviesapp.users.domain.models.Request.LoginRequest
import cd.zgeniuscoders.themoviesapp.users.domain.services.UserService
import cd.zgeniuscoders.themoviesapp.users.domain.use_cases.UserInteractor
import kotlinx.coroutines.launch

class LoginViewModel(private val interactor: UserInteractor) : ViewModel() {

    var state by mutableStateOf(LoginState())

    fun onTriggerEvent(event: LoginEvent){
        when(event){
            is LoginEvent.OnEmailChanged -> state = state.copy(email = event.value)
            LoginEvent.OnFormSubmitted -> login()
            is LoginEvent.OnPasswordChanged -> state = state.copy(password = event.value)
            is LoginEvent.OnRememberMeChanged -> TODO()
        }
    }

    private fun validated() {
        state = if (state.email.isEmpty() || state.password.isEmpty()) {
            state.copy(hasFormError = true, isFormValidated = false)
        } else {
            state.copy(hasFormError = false, isFormValidated = true)
        }
    }

     fun login() {
        validated()

        if (state.isFormValidated) {
            viewModelScope.launch {
                Log.i("AUTH", "login...")
                interactor.loginUseCase.run(LoginRequest(state.email, state.password))
            }
        }
    }

}