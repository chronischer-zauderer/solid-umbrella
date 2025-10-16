package com.example.heltexample.data

import javax.inject.Inject

// Repositorio que depende de UserApi. El constructor tiene @Inject,
// así Hilt puede crearlo si conoce cómo crear UserApi (vía AppModule).
class UserRepository @Inject constructor(
    private val api: UserApi
) {
    // Función pública que usa la dependencia inyectada
    suspend fun fetchUsers(): List<User> = api.getUsers()
}
