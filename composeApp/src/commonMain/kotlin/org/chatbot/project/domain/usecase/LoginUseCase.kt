package org.chatbot.project.domain.usecase

import org.chatbot.project.domain.entity.Result
import org.chatbot.project.domain.entity.User
import org.chatbot.project.domain.repository.AuthRepository

class LoginUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(username: String, password: String): Result<User> {
        return authRepository.login(username, password)
    }
}
