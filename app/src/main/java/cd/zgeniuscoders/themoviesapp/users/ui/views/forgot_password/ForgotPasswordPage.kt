package cd.zgeniuscoders.themoviesapp.users.ui.views.forgot_password

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
fun ForgotPasswordPage(navHostController: NavHostController) {
    val vm = koinViewModel<ForgotPasswordViewModel>()
    val onEvent = vm::onTriggerEvent
    val state = vm.state

    ForgotPasswordBody(navHostController, onEvent, state)
}


@Composable
fun ForgotPasswordBody(
    navHostController: NavHostController,
    onEvent: (event: ForgotPasswordEvent) -> Unit = {},
    state: ForgotPasswordState = ForgotPasswordState()
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

        Spacer(modifier = Modifier.height(20.dp))


        TextFieldComponent(
            textValue = "",
            label = "Adresse Email",
            keyboardType = KeyboardType.Email,
        ) {

        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = green
            )
        ) {
            Text(
                "Envoyer",
                style = MaterialTheme.typography.titleMedium
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ForgotPasswordPagePreview() {
    ForgotPasswordBody(
        navHostController = rememberNavController()
    )
}

