package cd.zgeniuscoders.themoviesapp.users.ui.views.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cd.zgeniuscoders.themoviesapp.users.domain.models.Request.LoginRequest
import cd.zgeniuscoders.themoviesapp.users.domain.models.Response.UserResponse
import cd.zgeniuscoders.themoviesapp.users.domain.use_cases.UserInteractor
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import retrofit2.HttpException
import java.net.ConnectException

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
                try {

                    val userEntity = interactor.loginUseCase.run(
                        LoginRequest(
                            state.email,
                            state.password
                        )
                    )


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

//                    state = state.copy(
//                        hasFormError = true,
//                        isFormValidated = false,
//                        error = userResponse.message,
//                    )

                    e.printStackTrace()
                } catch (e: ConnectException) {

                    state = state.copy(
                        hasFormError = true,
                        isFormValidated = false,
                        error = "Connexion failed"
                    )

                    e.printStackTrace()
                }


            }
        }
    }

}