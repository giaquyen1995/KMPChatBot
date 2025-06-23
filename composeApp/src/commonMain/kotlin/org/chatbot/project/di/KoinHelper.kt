package org.chatbot.project.di

import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.mp.KoinPlatform

object KoinHelper {
    inline fun <reified T> get(): T {
        return KoinPlatform.getKoin().get()
    }
}
