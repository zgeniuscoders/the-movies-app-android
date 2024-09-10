package cd.zgeniuscoders.themoviesapp.users.ui.views.profile

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cd.zgeniuscoders.themoviesapp.common.extension.dataStore
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val context: Context
) : ViewModel() {

    var state by mutableStateOf(ProfileState())

    fun onTriggerEvent(event: ProfileEvent){
        when (event){
            ProfileEvent.OnLogout -> logout()
        }
    }


    private fun logout(){
        viewModelScope.launch {
            context.dataStore.updateData {
                it.copy(isLogged = false, token = null)
            }
            state = state.copy(isLogout = true)
        }

    }


}