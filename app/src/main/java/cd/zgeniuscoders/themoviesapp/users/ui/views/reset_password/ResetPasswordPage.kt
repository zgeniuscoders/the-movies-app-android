package cd.zgeniuscoders.themoviesapp.users.ui.views.reset_password

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import cd.zgeniuscoders.themoviesapp.common.ui.components.TextFieldComponent
import cd.zgeniuscoders.themoviesapp.common.ui.theme.green
import org.koin.androidx.compose.koinViewModel

@Composable
fun ResetPasswordPage(navHostController: NavHostController) {
    val vm = koinViewModel<ResetPasswordViewModel>()
    val onEvent = vm::onTriggerEvent
    val state = vm.state

    ResetPasswordBody(navHostController, onEvent, state)
}


@Composable
fun ResetPasswordBody(
    navHostController: NavHostController,
    onEvent: (event: ResetPasswordEvent) -> Unit = {},
    state: ResetPasswordState = ResetPasswordState()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
    ) {

        Spacer(modifier = Modifier.height(60.dp))

        Text(
            "Reinitialisation mot de passe",
            style = MaterialTheme.typography.displaySmall,
            color = green
        )

        Spacer(modifier = Modifier.height(20.dp))


        TextFieldComponent(
            textValue = state.password,
            label = "Mot de passe",
            keyboardType = KeyboardType.Password,
            onValueChange = { onEvent(ResetPasswordEvent.OnPasswordChanged(it)) }
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextFieldComponent(
            textValue = state.confirmPassword,
            label = "Confirmer le Mot de passe",
            keyboardType = KeyboardType.Password,
            onValueChange = { onEvent(ResetPasswordEvent.OnConfirmPasswordChanged(it)) }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { onEvent(ResetPasswordEvent.OnFormSubmitted) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = green
            )
        ) {
            Text(
                "Reinitialiser",
                style = MaterialTheme.typography.titleMedium
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    ResetPasswordBody(navHostController = rememberNavController())
}

