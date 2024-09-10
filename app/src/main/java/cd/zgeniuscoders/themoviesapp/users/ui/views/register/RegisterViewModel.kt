package cd.zgeniuscoders.themoviesapp.users.ui.views.register

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cd.zgeniuscoders.themoviesapp.common.UserSettings
import cd.zgeniuscoders.themoviesapp.users.domain.models.Request.RegisterRequest
import cd.zgeniuscoders.themoviesapp.users.domain.use_cases.UserInteractor
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val interactor: UserInteractor
) : ViewModel() {

    var state by mutableStateOf(RegisterState())

    fun onTriggerEvent(event: RegisterEvent){
        when(event){
            is RegisterEvent.OnConfirmPasswordChanged -> state =
                state.copy(confirmPassword = event.value)

            is RegisterEvent.OnEmailChanged -> state = state.copy(email = event.value)
            RegisterEvent.OnFormSubmitted -> register()
            is RegisterEvent.OnPasswordChanged -> state = state.copy(password = event.value)
            is RegisterEvent.OnUsernameChanged -> state = state.copy(username = event.value)
            RegisterEvent.OnShowConfirmPassword -> state =
                state.copy(showConfirmPassword = !state.showConfirmPassword)

            RegisterEvent.OnShowPassword -> state = state.copy(showPassword = !state.showPassword)
        }
    }

    private fun validate() {
        state = state.copy(isFormValidated = true)
        state =
            if (state.email.isEmpty() || state.username.isEmpty() || state.password.isEmpty() || state.confirmPassword.isEmpty()) {
                state.copy(
                    hasFormError = true,
                    isFormValidated = false,
                    error = "please fill all fields"
                )
            } else {
                if (state.password.length < 6) {
                    state.copy(
                        hasFormError = true,
                        isFormValidated = false,
                        error = "password must have more than 6 characters"
                    )
                } else {
                    if (state.password != state.confirmPassword) {
                        state.copy(
                            hasFormError = true,
                            isFormValidated = false,
                            error = "confirm password does not match"
                        )
                    } else {
                        state.copy(hasFormError = false, isFormValidated = true)
                    }
                }
            }

        Log.i("REGISTER", state.error)
    }

    fun register(){
        validate()

        if (state.isFormValidated) {

            viewModelScope.launch {
                val userResponse = interactor.registerUseCase.run(
                        RegisterRequest(
                            email = state.email,
                            username = state.username,
                            password = state.password
                        )
                    )

                if (userResponse.status) {
                    state =
                        state.copy(hasFormError = false, isFormValidated = true, isLogged = true)

                    interactor.saveUserPref.run(UserSettings(true, userResponse.token))

                } else {
                    state = state.copy(
                        hasFormError = true,
                        isFormValidated = false,
                        error = userResponse.message,
                        errors = userResponse.errors
                    )
                }


            }
        }

    }


}