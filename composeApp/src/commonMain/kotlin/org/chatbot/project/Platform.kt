package org.chatbot.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform