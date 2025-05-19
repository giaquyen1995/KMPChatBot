package org.chatbot.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import org.chatbot.project.di.initKoin
import org.chatbot.project.navigation.AppNavigation
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    // Initialize Koin for Dependency Injection
    initKoin()

    MaterialTheme {
        AppNavigation()
    }
}