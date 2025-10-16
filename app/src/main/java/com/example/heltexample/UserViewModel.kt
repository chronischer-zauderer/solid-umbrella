package com.example.heltexample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.heltexample.data.User
import com.example.heltexample.data.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// ViewModel administrado por Hilt. Recibe el repositorio por inyección.
@HiltViewModel
class UserViewModel @Inject constructor(
    private val repo: UserRepository
) : ViewModel() {
    // Estado expuesto a la UI
    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users

    init {
        refresh()
    }

    // Carga de datos (podría manejar errores, loading, etc.)
    fun refresh() {
        viewModelScope.launch {
            _users.value = repo.fetchUsers()
        }
    }
}
