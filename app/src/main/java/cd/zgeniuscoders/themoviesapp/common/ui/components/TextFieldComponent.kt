package cd.zgeniuscoders.themoviesapp.common.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldComponent(
    modifier: Modifier = Modifier,
    textValue: String,
    label: String,
    key: String? = null,
    keyboardType: KeyboardType,
    shape: RoundedCornerShape = RoundedCornerShape(5.dp),
    colors: TextFieldColors = TextFieldDefaults.colors(
        focusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent
    ),
    isPasswordField: Boolean = false,
    errors: HashMap<String, List<String>>? = null,
    content: @Composable (() -> Unit?)? = null,
    onValueChange: (value: String) -> Unit,
) {
    Column {
        TextField(
            modifier = modifier.fillMaxWidth(),
            value = textValue,
            onValueChange = { onValueChange(it) },
            leadingIcon = null,
            visualTransformation = if (isPasswordField) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            colors = colors,
            placeholder = {
                Text(label)
            },
            shape = shape,
            isError = errors?.containsKey(key) == true
        )
        if (errors?.containsKey(key) == true) {
            Spacer(modifier = Modifier.height(5.dp))
            errors[key]?.firstOrNull()?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.Red
                )
            }
        }
    }
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