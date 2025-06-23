package org.chatbot.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import moe.tlaster.precompose.PreComposeApp
import org.chatbot.project.di.appModule
import org.chatbot.project.navigation.AppNavigation
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
@Preview
fun App() {
    KoinApplication(application = {
        modules(appModule())
    }) {
        MaterialTheme {
            PreComposeApp {
                AppNavigation()
            }
        }
    }
}