package cd.zgeniuscoders.themoviesapp.common.ui

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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import cd.zgeniuscoders.themoviesapp.R
import cd.zgeniuscoders.themoviesapp.common.UserSettings
import cd.zgeniuscoders.themoviesapp.common.extension.dataStore
import cd.zgeniuscoders.themoviesapp.common.routes.Route
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navHostController: NavHostController) {

    val context = LocalContext.current
    val userSettings = context.dataStore.data.collectAsState(initial = UserSettings())


    LaunchedEffect(Unit) {
        delay(2000)
        if(userSettings.value.isLogged){
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
            modifier = Modifier.size(180.dp)
        )
    }

}


@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen(navHostController = rememberNavController())
}