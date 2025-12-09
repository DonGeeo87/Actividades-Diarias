package dev.dongeeo.actividadesdiarias.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.dongeeo.actividadesdiarias.ui.screens.ActivityListScreen
import dev.dongeeo.actividadesdiarias.ui.screens.RegisterActivityScreen
import dev.dongeeo.actividadesdiarias.ui.screens.WelcomeScreen
import dev.dongeeo.actividadesdiarias.viewmodel.ActivityViewModel
import kotlinx.coroutines.flow.first

/**
 * RUTAS DE NAVEGACIÓN
 * 
 * Define todas las pantallas disponibles en la aplicación.
 * Cada ruta tiene un identificador único (route) que se usa para navegar.
 */
sealed class Routes(val route: String) {
    object Welcome : Routes("welcome")    // Pantalla de bienvenida (primera vez)
    object List : Routes("list")          // Pantalla principal con lista de actividades
    object Register : Routes("register")  // Pantalla para registrar nueva actividad
}

/**
 * NAVEGACIÓN PRINCIPAL DE LA APLICACIÓN
 * 
 * Controla el flujo de navegación entre pantallas:
 * - Si no hay nombre de usuario → muestra WelcomeScreen
 * - Si hay nombre → muestra ActivityListScreen
 * - Permite navegar a RegisterActivityScreen para agregar actividades
 * 
 * La navegación es automática según el estado del usuario.
 * 
 * @param viewModel: Contiene los datos y lógica necesarios para las pantallas
 */
@Composable
fun AppNavigation(viewModel: ActivityViewModel) {
    // Controlador de navegación: gestiona el stack de pantallas
    val navController = rememberNavController()
    
    // Observar el nombre del usuario (se actualiza automáticamente si cambia)
    val userName by viewModel.userName.collectAsState(initial = null)
    
    // EFECTO AUTOMÁTICO: Navega según si hay nombre de usuario o no
    LaunchedEffect(userName) {
        // Si NO hay nombre guardado → ir a pantalla de bienvenida
        if (userName == null) {
            // Solo navegar si no estamos ya en la pantalla de bienvenida
            if (navController.currentDestination?.route != Routes.Welcome.route) {
                navController.navigate(Routes.Welcome.route) {
                    popUpTo(0)  // Limpiar el stack de navegación (no poder volver atrás)
                }
            }
        } else {
            // Si HAY nombre guardado → ir a la lista de actividades
            // Solo navegar si estamos en la pantalla de bienvenida
            if (navController.currentDestination?.route == Routes.Welcome.route) {
                navController.navigate(Routes.List.route) {
                    popUpTo(0)  // Limpiar el stack de navegación
                }
            }
        }
    }

    // NAVHOST: Contenedor que muestra la pantalla actual según la ruta
    NavHost(
        navController = navController,
        // Pantalla inicial: Welcome si no hay nombre, List si ya hay nombre
        startDestination = if (userName == null) Routes.Welcome.route else Routes.List.route
    ) {
        // PANTALLA DE BIENVENIDA
        // Se muestra solo la primera vez que se abre la app
        composable(Routes.Welcome.route) {
            WelcomeScreen(
                viewModel = viewModel,
                // Al completar (guardar nombre), navegar a la lista
                onComplete = { navController.navigate(Routes.List.route) { popUpTo(0) } }
            )
        }
        
        // PANTALLA PRINCIPAL: Lista de actividades
        composable(Routes.List.route) {
            ActivityListScreen(
                viewModel = viewModel,
                // Al presionar el botón de agregar, navegar a la pantalla de registro
                onAddClick = { navController.navigate(Routes.Register.route) }
            )
        }

        // PANTALLA DE REGISTRO: Formulario para agregar nueva actividad
        composable(Routes.Register.route) {
            RegisterActivityScreen(
                viewModel = viewModel,
                // Al guardar la actividad, volver a la lista (popBackStack = volver atrás)
                onSaved = { navController.popBackStack() }
            )
        }
    }
}
