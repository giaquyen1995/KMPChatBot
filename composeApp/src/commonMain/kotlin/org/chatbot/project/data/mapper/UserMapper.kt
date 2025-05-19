package org.chatbot.project.data.mapper

import org.chatbot.project.data.dto.UserDto
import org.chatbot.project.domain.entity.User

fun UserDto.toUser(): User {
    return User(
        id = id,
        username = username,
        email = email,
        fullName = fullName
    )
}
