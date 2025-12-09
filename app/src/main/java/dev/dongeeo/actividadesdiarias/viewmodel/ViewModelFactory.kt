package dev.dongeeo.actividadesdiarias.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dev.dongeeo.actividadesdiarias.data.UserPreferencesRepository

/**
 * FACTORY PARA CREAR VIEWMODELS
 * 
 * En Android, los ViewModels no se crean directamente con "new".
 * En su lugar, se usa un Factory que permite inyectar dependencias
 * (como el repositorio) al ViewModel.
 * 
 * Este Factory:
 * - Recibe el Context necesario para crear el UserPreferencesRepository
 * - Crea el repositorio
 * - Crea el ActivityViewModel pasándole el repositorio
 * 
 * Esto permite que el ViewModel tenga acceso a DataStore para guardar
 * el nombre del usuario.
 * 
 * @param context: Contexto de Android necesario para crear el repositorio
 */
class ViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {
    /**
     * CREAR VIEWMODEL
     * 
     * Método requerido por ViewModelProvider.Factory.
     * Se llama automáticamente cuando se necesita crear un ViewModel.
     * 
     * @param modelClass: La clase del ViewModel que se quiere crear
     * @return Instancia del ViewModel con sus dependencias inyectadas
     */
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // Verificar que se está pidiendo crear un ActivityViewModel
        if (modelClass.isAssignableFrom(ActivityViewModel::class.java)) {
            // Crear el repositorio con el contexto
            val repository = UserPreferencesRepository(context)
            
            // Crear el ViewModel pasándole el repositorio
            @Suppress("UNCHECKED_CAST")
            return ActivityViewModel(repository) as T
        }
        // Si se pide un ViewModel desconocido, lanzar error
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
