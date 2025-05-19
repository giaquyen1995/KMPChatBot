package org.chatbot.project.domain.usecase

import org.chatbot.project.domain.repository.AuthRepository

class CheckLoginStatusUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(): Boolean {
        return authRepository.isLoggedIn()
    }
}
