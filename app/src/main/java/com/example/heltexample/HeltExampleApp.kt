package com.example.heltexample

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// Punto de entrada de Hilt a nivel de aplicación.
// Esta anotación genera e inicializa los componentes de Hilt.
@HiltAndroidApp
class HeltExampleApp : Application()
