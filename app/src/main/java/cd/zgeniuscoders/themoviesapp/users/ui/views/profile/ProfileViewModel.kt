package cd.zgeniuscoders.themoviesapp.users.ui.views.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {

    var state by mutableStateOf(ProfileState())

    fun onTriggerEvent(event: ProfileEvent){

    }



}