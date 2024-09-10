package cd.zgeniuscoders.themoviesapp.users.ui.views.opt_verification

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import cd.zgeniuscoders.themoviesapp.users.domain.services.UserService

class OptVerificationViewModel(
    private val userService: UserService
) : ViewModel() {

    var state by mutableStateOf(OptVerificationState())

    fun onTriggerEvent(event: OptVerificationEvent) {
        when (event) {
            is OptVerificationEvent.OnCodeChanged -> state = state.copy(code = event.value)
            OptVerificationEvent.OnSubmitted -> verify()
        }
    }

    private fun verify() {

    }

}