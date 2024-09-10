package cd.zgeniuscoders.themoviesapp.users.ui.views.register

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import cd.zgeniuscoders.themoviesapp.common.routes.Route
import cd.zgeniuscoders.themoviesapp.common.ui.components.TextFieldComponent
import cd.zgeniuscoders.themoviesapp.common.ui.theme.green
import org.koin.androidx.compose.koinViewModel

@Composable
fun RegisterPage(navHostController: NavHostController, snackbarHostState: SnackbarHostState) {
    val vm = koinViewModel<RegisterViewModel>()
    val onEvent = vm::onTriggerEvent
    val state = vm.state

    LaunchedEffect(state.error) {
        if (state.error.isNotBlank()) {
            snackbarHostState.showSnackbar(state.error)
        }
    }

    LaunchedEffect(state.isLogged) {

        if(state.isLogged){
            navHostController.navigate(Route.homepage.route)
        }
    }



    RegisterBody(navHostController, onEvent, state)
}

@Composable
fun RegisterBody(
    navHostController: NavHostController,
    onEvent: (event: RegisterEvent) -> Unit = {},
    state: RegisterState = RegisterState()
) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
    ) {

        Spacer(modifier = Modifier.height(60.dp))

        Text(
            "Inscription",
            style = MaterialTheme.typography.displaySmall,
            color = green
        )

        Text("Ne rate plus aucune nouveauté. Crée ton compte gratuit dès maintenant !")

        Spacer(modifier = Modifier.height(20.dp))


        TextFieldComponent(
            textValue = state.username,
            label = "Nom d'utilisateur",
            key = "username",
            errors = state.errors,
            keyboardType = KeyboardType.Text,
            onValueChange = { onEvent(RegisterEvent.OnUsernameChanged(it)) }
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextFieldComponent(
            textValue = state.email,
            label = "Adresse Email",
            keyboardType = KeyboardType.Email,
            key = "email",
            errors = state.errors,
            onValueChange = { onEvent(RegisterEvent.OnEmailChanged(it)) }
        )


        Spacer(modifier = Modifier.height(10.dp))

        TextFieldComponent(
            textValue = state.password,
            label = "Mot de passe",
            isPasswordField = state.showPassword,
            key = "password",
            errors = state.errors,
            keyboardType = KeyboardType.Password,
            trailingIcon = {
                IconButton(onClick = { onEvent(RegisterEvent.OnShowPassword) }) {
                    Icon(imageVector = Icons.Default.RemoveRedEye, contentDescription = null)
                }
            },
            onValueChange = { onEvent(RegisterEvent.OnPasswordChanged(it)) }
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextFieldComponent(
            textValue = state.confirmPassword,
            label = "Confirmer le Mot de passe",
            isPasswordField = state.showConfirmPassword,
            keyboardType = KeyboardType.Password,
            trailingIcon = {
                IconButton(onClick = { onEvent(RegisterEvent.OnShowConfirmPassword) }) {
                    Icon(imageVector =  Icons.Default.RemoveRedEye, contentDescription = null)
                }
            },
            onValueChange = { onEvent(RegisterEvent.OnConfirmPasswordChanged(it)) }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            enabled = !state.isFormValidated,
            onClick = { onEvent(RegisterEvent.OnFormSubmitted) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = green
            )
        ) {
            if (state.isFormValidated) {
                CircularProgressIndicator(modifier = Modifier.size(30.dp))
            } else {
                Text(
                    "S'inscrire",
                    style = MaterialTheme.typography.titleMedium
                )
            }

        }

        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Vous avez déja un compte ? Connectez-vous ")
            Text(
                text = "ici",
                color = green,
                modifier = Modifier.clickable {
                    navHostController.navigate(Route.login.route)
                }
            )
        }


    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPagePreview() {
    RegisterBody(rememberNavController())
}