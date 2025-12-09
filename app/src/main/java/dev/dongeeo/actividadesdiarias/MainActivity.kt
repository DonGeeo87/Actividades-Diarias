package dev.dongeeo.actividadesdiarias

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * ACTIVIDAD PRINCIPAL DE LA APLICACIÓN
 *
 * Ahora usa Fragments + Navigation Component para cumplir los requisitos.
 * Carga un layout con un NavHostFragment definido en activity_main.xml.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
