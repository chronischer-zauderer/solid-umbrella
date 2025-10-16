package com.example.heltexample.data

// Modelo simple para el ejemplo
data class User(val id: Int, val name: String)

// Contrato de la fuente de datos (podría ser Retrofit, Room, etc.)
interface UserApi {
    suspend fun getUsers(): List<User>
}

// Implementación fake para demostrar el flujo sin red/BD real
class FakeUserApi : UserApi {
    override suspend fun getUsers(): List<User> = listOf(
        User(1, "Alice"),
        User(2, "Bob"),
        User(3, "Carol")
    )
}
