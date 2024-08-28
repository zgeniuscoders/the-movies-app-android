package cd.zgeniuscoders.themoviesapp.users.ui.views.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import cd.zgeniuscoders.themoviesapp.users.domain.services.UserService

class RegisterViewModel(service: UserService) : ViewModel() {

    val state by mutableStateOf(RegisterState())

    fun onTriggerEvent(event: RegisterEvent){
        when(event){
            is RegisterEvent.OnConfirmPasswordChanged -> TODO()
            is RegisterEvent.OnEmailChanged -> TODO()
            RegisterEvent.OnFormSubmitted -> TODO()
            is RegisterEvent.OnPasswordChanged -> TODO()
            is RegisterEvent.OnUsernameChanged -> TODO()
        }
    }

    fun validate(){

    }

    fun register(){

    }


}