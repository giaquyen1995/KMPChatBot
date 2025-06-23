package org.chatbot.project.di

import org.chatbot.project.data.api.ApiClient
import org.chatbot.project.data.api.AuthService
import org.chatbot.project.data.cache.UserSessionCache
import org.chatbot.project.data.repository.AuthRepositoryImpl
import org.chatbot.project.domain.repository.AuthRepository
import org.chatbot.project.domain.usecase.CheckLoginStatusUseCase
import org.chatbot.project.domain.usecase.LoginUseCase
import org.chatbot.project.presentation.viewmodel.login.LoginViewModel
import org.chatbot.project.presentation.viewmodel.splash.SplashViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

fun appModule(): Module = module {
    // API
    single { ApiClient() }
    single { AuthService(get()) }
    
    // Cache
    single { UserSessionCache() }
    
    // Repositories
    single<AuthRepository> { AuthRepositoryImpl(get(), get()) }
    
    // Use Cases
    factory { LoginUseCase(get()) }
    factory { CheckLoginStatusUseCase(get()) }
    
    // ViewModels
    factory { SplashViewModel(get()) }
    factory { LoginViewModel(get()) }
    factory { org.chatbot.project.presentation.viewmodel.home.HomeViewModel() }
}
