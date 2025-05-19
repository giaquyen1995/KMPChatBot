package org.chatbot.project.data.cache

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.chatbot.project.domain.entity.User

/**
 * A simple in-memory cache for the user session
 * In a real app, this would likely use platform-specific secure storage
 */
class UserSessionCache {
    private val mutex = Mutex()
    private var currentUser: User? = null
    
    suspend fun saveUser(user: User) = mutex.withLock {
        currentUser = user
    }
    
    suspend fun getUser(): User? = mutex.withLock {
        return currentUser
    }
    
    suspend fun clearSession() = mutex.withLock {
        currentUser = null
    }
    
    suspend fun isLoggedIn(): Boolean = mutex.withLock {
        return currentUser != null
    }
}
