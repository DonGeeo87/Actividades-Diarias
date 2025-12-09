package dev.dongeeo.actividadesdiarias

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.dongeeo.actividadesdiarias.navigation.AppNavigation
import dev.dongeeo.actividadesdiarias.ui.theme.ActividadesDiariasTheme
import dev.dongeeo.actividadesdiarias.viewmodel.ActivityViewModel
import dev.dongeeo.actividadesdiarias.viewmodel.ViewModelFactory

/**
 * ACTIVIDAD PRINCIPAL DE LA APLICACIÓN
 * 
 * Este es el punto de entrada de la aplicación Android.
 * Se ejecuta cuando el usuario abre la app desde el launcher.
 * 
 * Responsabilidades:
 * - Configurar el tema de la aplicación
 * - Crear el ViewModel con sus dependencias
 * - Inicializar la navegación principal
 * - Habilitar edge-to-edge (contenido hasta los bordes de la pantalla)
 * 
 * Esta clase hereda de ComponentActivity, que es necesaria para usar Jetpack Compose.
 */
class MainActivity : ComponentActivity() {
    /**
     * MÉTODO onCreate
     * 
     * Se ejecuta cuando la actividad se crea por primera vez.
     * Aquí se configura toda la interfaz de usuario usando Compose.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Habilitar edge-to-edge: permite que el contenido llegue hasta los bordes
        // (debajo de la barra de estado y navegación)
        enableEdgeToEdge()
        
        // setContent: Define el contenido de la actividad usando Compose
        setContent {
            // TEMA DE LA APLICACIÓN: Aplica colores, tipografía y estilos
            ActividadesDiariasTheme {
                // Surface: Contenedor principal con el color de fondo del tema
                Surface(
                    modifier = Modifier.fillMaxSize(),  // Ocupar toda la pantalla
                    color = MaterialTheme.colorScheme.background
                ) {
                    // VIEWMODEL: Contiene la lógica y datos de la aplicación
                    // Se crea usando una Factory personalizada para inyectar dependencias
                    val viewModel: ActivityViewModel = viewModel(
                        factory = ViewModelFactory(this@MainActivity)  // Pasar el contexto para DataStore
                    )
                    
                    // NAVEGACIÓN PRINCIPAL: Gestiona el flujo entre pantallas
                    AppNavigation(viewModel = viewModel)
                }
            }
        }
    }
}
