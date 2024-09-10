package cd.zgeniuscoders.themoviesapp.users.ui.views.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cd.zgeniuscoders.themoviesapp.common.UserSettings
import cd.zgeniuscoders.themoviesapp.users.domain.use_cases.UserInteractor
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val userInteractor: UserInteractor
) : ViewModel() {

    var state by mutableStateOf(ProfileState())

    fun onTriggerEvent(event: ProfileEvent){
        when (event){
            ProfileEvent.OnLogout -> logout()
        }
    }


    private fun logout(){
        viewModelScope.launch {
            userInteractor.saveUserPref.run(UserSettings(false, ""))
            state = state.copy(isLogout = true)
        }

    }


}