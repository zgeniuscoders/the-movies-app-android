package cd.zgeniuscoders.themoviesapp.users.ui.views.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PrivacyTip
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import cd.zgeniuscoders.themoviesapp.users.ui.views.profile.components.ProfileHeader
import cd.zgeniuscoders.themoviesapp.users.ui.views.profile.components.SettingItem
import org.koin.androidx.compose.koinViewModel


@Composable
fun ProfilePage(navHostController: NavHostController) {

    val vm = koinViewModel<ProfileViewModel>()

    ProfileBody(state = vm.state)

}

@Composable
fun ProfileBody(state: ProfileState) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        ProfileHeader(modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(10.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            SettingItem("Changer mon nom d'utilisateur", Icons.Filled.Person, {})
            SettingItem("Changer mon mot de passe", Icons.Filled.Lock, {})
        }

        Spacer(modifier = Modifier.height(10.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            SettingItem("A-props de themoviesapp", Icons.Filled.Help, {})
            SettingItem("Condition d'utilisation", Icons.Filled.PrivacyTip, {})
        }

        Spacer(modifier = Modifier.height(10.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            SettingItem("Se deconnecter", Icons.Filled.Logout, {}, showEndIcon = false)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview(modifier: Modifier = Modifier) {
    ProfileBody(ProfileState())
}