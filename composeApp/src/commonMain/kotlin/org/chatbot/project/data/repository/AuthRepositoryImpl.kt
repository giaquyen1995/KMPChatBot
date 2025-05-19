package org.chatbot.project.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import org.chatbot.project.data.api.AuthService
import org.chatbot.project.data.cache.UserSessionCache
import org.chatbot.project.data.mapper.toUser
import org.chatbot.project.domain.entity.Result
import org.chatbot.project.domain.entity.User
import org.chatbot.project.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val authService: AuthService,
    private val userSessionCache: UserSessionCache
) : AuthRepository {
    
    override suspend fun login(username: String, password: String): Result<User> = withContext(Dispatchers.IO) {
        return@withContext try {
            val userDto = authService.login(username, password)
            val user = userDto.toUser()
            userSessionCache.saveUser(user)
            Result.Success(user)
        } catch (e: Exception) {
            Result.Error("Login failed: ${e.message}", e)
        }
    }
    
    override suspend fun isLoggedIn(): Boolean = withContext(Dispatchers.IO) {
        return@withContext userSessionCache.isLoggedIn()
    }
    
    override suspend fun logout() = withContext(Dispatchers.IO) {
        userSessionCache.clearSession()
    }
}
