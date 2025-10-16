package com.example.heltexample.di

import com.example.heltexample.data.UserApi
import com.example.heltexample.data.FakeUserApi
import com.example.heltexample.data.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// Módulo de Hilt donde definimos cómo construir dependencias.
// InstallIn(SingletonComponent) => las instancias viven toda la vida de la app.
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    // Provee una implementación de UserApi.
    // @Singleton: una única instancia compartida (patrón singleton controlado por Hilt).
    @Provides
    @Singleton
    fun provideUserApi(): UserApi = FakeUserApi()

    // Provee el repositorio. Hilt resuelve su dependencia (UserApi) automáticamente.
    @Provides
    @Singleton
    fun provideUserRepository(api: UserApi): UserRepository = UserRepository(api)
}
