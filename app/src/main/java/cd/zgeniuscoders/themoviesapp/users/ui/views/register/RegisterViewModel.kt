package cd.zgeniuscoders.themoviesapp.users.ui.views.register

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cd.zgeniuscoders.themoviesapp.common.extension.dataStore
import cd.zgeniuscoders.themoviesapp.users.domain.entities.UserEntity
import cd.zgeniuscoders.themoviesapp.users.domain.models.Request.RegisterRequest
import cd.zgeniuscoders.themoviesapp.users.domain.models.Response.UserResponse
import cd.zgeniuscoders.themoviesapp.users.domain.use_cases.UserInteractor
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import retrofit2.HttpException

class RegisterViewModel(
    private val interactor: UserInteractor,
    private val context: Context
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
    }

    fun register(){
        validate()

        if (state.isFormValidated) {

            viewModelScope.launch {

                try {
                    val userEntity = interactor.registerUseCase.run(
                        RegisterRequest(
                            email = state.email,
                            username = state.username,
                            password = state.password
                        )
                    )

                    state = state.copy(hasFormError = false, isFormValidated = true)

                    context.dataStore.updateData {
                        it.copy(isLogged = true, token = userEntity!!.token)
                    }

                    Log.i("AUTH_REGISTER", userEntity.toString())
                } catch (e: NullPointerException) {

                    state = state.copy(
                        hasFormError = true,
                        isFormValidated = false,
                        error = "An unexpected error occurred."
                    )

                    e.printStackTrace()

                } catch (e: HttpException) {

                    val res = e.response()?.errorBody()?.string()
                    val userResponse = Json.decodeFromString<UserResponse>(res!!)

                    state = state.copy(
                        hasFormError = true,
                        isFormValidated = false,
                        error = userResponse.message,
                        errors = userResponse.errors
                    )

                    Log.e("AUTH_REGISTER_ERROR", userResponse.message)

                    e.printStackTrace()
                }

            }
        }

    }


}