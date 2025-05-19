package org.chatbot.project.domain.repository

import org.chatbot.project.domain.entity.Result
import org.chatbot.project.domain.entity.User

interface AuthRepository {
    suspend fun login(username: String, password: String): Result<User>
    suspend fun isLoggedIn(): Boolean
    suspend fun logout()
}
