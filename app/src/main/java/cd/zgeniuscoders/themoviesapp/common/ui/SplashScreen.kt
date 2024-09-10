package cd.zgeniuscoders.themoviesapp.common.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import cd.zgeniuscoders.themoviesapp.R
import cd.zgeniuscoders.themoviesapp.common.UserSettings
import cd.zgeniuscoders.themoviesapp.common.extension.dataStore
import cd.zgeniuscoders.themoviesapp.common.extension.preferences
import cd.zgeniuscoders.themoviesapp.common.routes.Route
import cd.zgeniuscoders.themoviesapp.common.utility.Constants
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@Composable
fun SplashScreen(navHostController: NavHostController) {

    val context = LocalContext.current

    val IS_LOGGED = booleanPreferencesKey(Constants.IS_LOGGED_KEY)
    val prefs: Flow<Boolean> = context.preferences.data.map { prefs ->
        prefs[IS_LOGGED] ?: false
    }

    val isLogged = prefs.collectAsState(initial = false)

    LaunchedEffect(Unit) {
        delay(2000)
        if(isLogged.value){
            navHostController.navigate(Route.homepage.route)
        }else{
            navHostController.navigate(Route.login.route)
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "anime app logo",
            modifier = Modifier.size(150.dp)
        )
    }

}


@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen(navHostController = rememberNavController())
}