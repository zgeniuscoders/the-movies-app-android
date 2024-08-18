package cd.zgeniuscoders.themoviesapp.common.ui.components

import android.annotation.SuppressLint
import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import cd.zgeniuscoders.themoviesapp.common.ui.theme.secondaryDark

@Composable
fun TextFieldComponent(
    modifier: Modifier = Modifier,
    textValue: String,
    label: String,
    keyboardType: KeyboardType,
    shape: RoundedCornerShape = RoundedCornerShape(5.dp),
    content: @Composable () -> Unit,
    onValueChange: (value: String) -> Unit,
) {
    TextField(
        modifier = modifier.fillMaxWidth(),
        value = textValue,
        onValueChange = { onValueChange(it) },
        leadingIcon = content,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        placeholder = {
            Text(label)
        },
        shape = shape
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