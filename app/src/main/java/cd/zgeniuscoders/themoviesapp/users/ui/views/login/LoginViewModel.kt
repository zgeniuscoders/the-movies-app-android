package cd.zgeniuscoders.themoviesapp.users.ui.views.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import cd.zgeniuscoders.themoviesapp.users.domain.services.UserService

class LoginViewModel(service: UserService) : ViewModel() {

    val state by mutableStateOf(LoginState())

    fun onTriggerEvent(event: LoginEvent){
        when(event){
            is LoginEvent.OnEmailChanged -> TODO()
            LoginEvent.OnFormSubmitted -> TODO()
            is LoginEvent.OnPasswordChanged -> TODO()
            is LoginEvent.OnRememberMeChanged -> TODO()
        }
    }

    fun login(){

    }

}