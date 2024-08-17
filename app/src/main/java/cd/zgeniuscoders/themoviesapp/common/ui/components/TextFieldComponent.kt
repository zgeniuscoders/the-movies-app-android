package cd.zgeniuscoders.themoviesapp.common.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TextFieldComponent(
    modifier: Modifier = Modifier,
    textValue: String,
    label: String,
    keyboardType: KeyboardType,
    content: @Composable () -> Unit,
    onValueChange: (value: String) -> Unit,
) {
    TextField(
        modifier = modifier.fillMaxWidth(),
        value = textValue,
        onValueChange = { onValueChange(it) },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White
        ),
        prefix = content,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        placeholder = {
            Text(label)
        }
    )
}

@Preview
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TextFieldComponentPreview(){
    Scaffold {
        TextFieldComponent(
            textValue = "", label = "Email",
            keyboardType = KeyboardType.Email,
            content = {
                Icon(Icons.Filled.Email, contentDescription = null)
            }
        ) {

        }
    }
}