package cd.zgeniuscoders.themoviesapp.users.ui.views.reset_password

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import cd.zgeniuscoders.themoviesapp.users.domain.services.UserService

class ResetPasswordViewModel(service: UserService) : ViewModel() {

    val state by mutableStateOf(ResetPasswordState())

    fun onTriggerEvent(event: ResetPasswordEvent){
        when(event){
            is ResetPasswordEvent.OnConfirmPasswordChanged -> TODO()
            ResetPasswordEvent.OnFormSubmitted -> reset()
            is ResetPasswordEvent.OnPasswordChanged -> TODO()
        }
    }

    private fun validate(){

    }

    private fun reset(){
        validate()
    }

}