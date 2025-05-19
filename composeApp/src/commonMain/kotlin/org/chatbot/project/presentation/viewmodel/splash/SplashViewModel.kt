package org.chatbot.project.presentation.viewmodel.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.chatbot.project.domain.usecase.CheckLoginStatusUseCase

class SplashViewModel(
    private val checkLoginStatusUseCase: CheckLoginStatusUseCase
) : ViewModel() {
    
    private val _uiState = MutableStateFlow<SplashUIState>(SplashUIState.Loading)
    val uiState: StateFlow<SplashUIState> = _uiState.asStateFlow()
    
    init {
        viewModelScope.launch {
            // Simulate a delay for splash screen
            delay(2000)
            checkLoginStatus()
        }
    }
    
    private suspend fun checkLoginStatus() {
        val isLoggedIn = checkLoginStatusUseCase()
        _uiState.value = if (isLoggedIn) {
            SplashUIState.NavigateToHome
        } else {
            SplashUIState.NavigateToLogin
        }
    }
}

sealed class SplashUIState {
    object Loading : SplashUIState()
    object NavigateToLogin : SplashUIState()
    object NavigateToHome : SplashUIState()
}
