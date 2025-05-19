package org.chatbot.project.data.api

import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.chatbot.project.data.dto.UserDto

class AuthService(private val apiClient: ApiClient) {
    // Simulated login function (in a real app this would call an actual API)
    suspend fun login(username: String, password: String): UserDto {
        // This is a mock implementation for demo purposes
        // In a real app, you'd make an API call like this:
        /*
        return apiClient.httpClient.post("https://api.example.com/login") {
            contentType(ContentType.Application.Json)
            setBody(LoginRequest(username, password))
        }.body()
        */
        
        // Mock response
        return UserDto(
            id = "user-123",
            username = username,
            email = "$username@example.com",
            fullName = "Demo User"
        )
    }
}

@kotlinx.serialization.Serializable
private data class LoginRequest(val username: String, val password: String)
