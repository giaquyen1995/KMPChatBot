package org.chatbot.project.navigation

import androidx.compose.runtime.Composable
import org.chatbot.project.presentation.view.home.HomeScreen
import org.chatbot.project.presentation.view.login.LoginScreen
import org.chatbot.project.presentation.view.splash.SplashScreen
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.rememberNavigator

sealed class Screen(val route: String) {
    data object Splash : Screen("splash")
    data object Login : Screen("login")
    data object Home : Screen("home")
}

@Composable
fun AppNavigation() {
    val navigator = rememberNavigator()
    
    NavHost(
        navigator = navigator,
        initialRoute = Screen.Splash.route
    ) {
        scene(route = Screen.Splash.route) {
            SplashScreen(navigator)
        }
        
        scene(route = Screen.Login.route) {
            LoginScreen(navigator)
        }
        
        scene(route = Screen.Home.route) {
            HomeScreen(navigator)
        }
    }
}
