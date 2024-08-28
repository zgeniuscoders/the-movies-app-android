package cd.zgeniuscoders.themoviesapp.users.ui.views.forgot_password

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import cd.zgeniuscoders.themoviesapp.users.domain.services.UserService

class ForgotPasswordViewModel(service: UserService) : ViewModel() {

    val state by mutableStateOf(ForgotPasswordState())

    fun onTriggerEvent(event: ForgotPasswordEvent){
        when(event){
            is ForgotPasswordEvent.OnEmailChanged -> TODO()
            ForgotPasswordEvent.OnFormSubmitted -> TODO()
        }
    }

    fun login(){

    }

}