package org.chatbot.project.presentation.viewmodel.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {
    
    private val _uiState = MutableStateFlow(HomeUIState())
    val uiState: StateFlow<HomeUIState> = _uiState.asStateFlow()
    
    fun onMessageChange(message: String) {
        _uiState.value = _uiState.value.copy(currentMessage = message)
    }
    
    fun sendMessage() {
        val currentState = _uiState.value
        if (currentState.currentMessage.isNotBlank()) {
            val newMessage = ChatMessage(
                text = currentState.currentMessage,
                isFromUser = true,
                timestamp = System.currentTimeMillis()
            )
            
            val updatedMessages = currentState.messages + newMessage
            _uiState.value = currentState.copy(
                messages = updatedMessages,
                currentMessage = ""
            )
            
            // Simulate bot response
            simulateBotResponse()
        }
    }
    
    private fun simulateBotResponse() {
        val botResponse = ChatMessage(
            text = "Xin chào! Tôi là Chat Bot. Tôi có thể giúp gì cho bạn?",
            isFromUser = false,
            timestamp = System.currentTimeMillis()
        )
        
        val currentState = _uiState.value
        _uiState.value = currentState.copy(
            messages = currentState.messages + botResponse
        )
    }
}

data class HomeUIState(
    val messages: List<ChatMessage> = emptyList(),
    val currentMessage: String = "",
    val isLoading: Boolean = false
)

data class ChatMessage(
    val text: String,
    val isFromUser: Boolean,
    val timestamp: Long
)
