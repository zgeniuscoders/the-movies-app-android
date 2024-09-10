package cd.zgeniuscoders.themoviesapp.users.ui.views.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import cd.zgeniuscoders.themoviesapp.common.UserSettings
import cd.zgeniuscoders.themoviesapp.common.extension.dataStore
import cd.zgeniuscoders.themoviesapp.common.routes.Route
import cd.zgeniuscoders.themoviesapp.common.ui.components.TextFieldComponent
import cd.zgeniuscoders.themoviesapp.common.ui.theme.green
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginPage(navHostController: NavHostController, snackbarHostState: SnackbarHostState) {
    val vm = koinViewModel<LoginViewModel>()
    val onEvent = vm::onTriggerEvent
    val state = vm.state

    LaunchedEffect(state.error) {
        if (state.error.isNotBlank()) {
            snackbarHostState.showSnackbar(state.error)
        }
    }

    LaunchedEffect(state.isLogged) {
        if (state.isLogged) {
            navHostController.navigate(Route.homepage.route)
        }
    }

    LoginBody(navHostController, onEvent, state)
}


@Composable
fun LoginBody(
    navHostController: NavHostController,
    onEvent: (event: LoginEvent) -> Unit = {},
    state: LoginState = LoginState()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
    ) {

        Spacer(modifier = Modifier.height(60.dp))

        Text(
            "Connexion",
            style = MaterialTheme.typography.displaySmall,
            color = green
        )

        Text("Prêt(e) à découvrir ton prochain coup de cœur ?")

        Spacer(modifier = Modifier.height(20.dp))


        TextFieldComponent(
            textValue = state.email,
            label = "Adresse Email",
            keyboardType = KeyboardType.Email,
            onValueChange = { onEvent(LoginEvent.OnEmailChanged(it)) }
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextFieldComponent(
            textValue = state.password,
            label = "Mot de passe",
            keyboardType = KeyboardType.Password,
            onValueChange = { onEvent(LoginEvent.OnPasswordChanged(it)) },
            trailingIcon = {
                IconButton(onClick = { onEvent(LoginEvent.OnShowPassword) }) {
                    Icon(imageVector = Icons.Default.RemoveRedEye, contentDescription = null)
                }
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                "Mot de passe oubliè ?",
                modifier = Modifier.clickable {
                    navHostController.navigate(Route.forgot_password.route)
                },
                color = green
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { onEvent(LoginEvent.OnFormSubmitted) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = green
            )
        ) {
            Text(
                "Se connecter",
                style = MaterialTheme.typography.titleMedium
            )
        }

        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Vous n’avez pas de compte ? Inscrivez-vous ")
            Text(
                text = "ici",
                color = green,
                modifier = Modifier.clickable {
                    navHostController.navigate(Route.register.route)
                }
            )
        }


    }
}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    LoginBody(navHostController = rememberNavController())
}

