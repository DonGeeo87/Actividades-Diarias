package dev.dongeeo.actividadesdiarias.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.dongeeo.actividadesdiarias.data.UserPreferencesRepository
import dev.dongeeo.actividadesdiarias.model.ActivityItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * VIEWMODEL: Lógica de Negocio y Gestión de Estado
 * 
 * El ViewModel es el "cerebro" de la aplicación. Se encarga de:
 * - Gestionar la lista de actividades
 * - Guardar y recuperar el nombre del usuario
 * - Formatear fechas y horas
 * - Proporcionar datos a las pantallas de forma reactiva
 * 
 * No contiene código de UI (interfaz), solo lógica de negocio.
 * Esto permite que la UI se actualice automáticamente cuando cambian los datos.
 */
class ActivityViewModel(
    private val userPreferencesRepository: UserPreferencesRepository  // Repositorio para guardar datos del usuario
) : ViewModel() {

    // LISTA DE ACTIVIDADES (LiveData para cumplir el requisito)
    private val _activities = MutableLiveData<List<ActivityItem>>(emptyList())
    val activities: LiveData<List<ActivityItem>> = _activities
    
    // NOMBRE DEL USUARIO
    // Flujo que emite el nombre guardado (puede ser null si no se ha configurado)
    val userName = userPreferencesRepository.userName

    /**
     * AGREGAR NUEVA ACTIVIDAD
     * 
     * Crea una nueva actividad con la fecha y hora actuales,
     * y la agrega a la lista.
     * 
     * @param title: Título de la actividad (ej: "Ir al gimnasio")
     * @param description: Descripción opcional de la actividad
     */
    fun addActivity(title: String, description: String) {
        // viewModelScope: Ejecuta la corrutina en el contexto del ViewModel
        // Se cancela automáticamente si el ViewModel se destruye
        viewModelScope.launch {
            delay(500)  // Simula una pequeña carga (500 milisegundos)
            
            // Formatear fecha en español (ej: "15 Dic 2024")
            val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale("es", "ES"))
            // Formatear hora (ej: "14:30")
            val timeFormat = SimpleDateFormat("HH:mm", Locale("es", "ES"))
            val now = Date()  // Fecha y hora actuales
            
            // Crear nueva actividad con los datos proporcionados
            val newItem = ActivityItem(
                title = title,
                description = description,
                date = dateFormat.format(now),  // Fecha formateada
                time = timeFormat.format(now)   // Hora formateada
            )
            
            // Agregar la nueva actividad al final de la lista
            val current = _activities.value.orEmpty()
            _activities.value = current + newItem
        }
    }

    /**
     * ELIMINAR ACTIVIDAD
     * 
     * Remueve una actividad de la lista por su ID único.
     * 
     * @param id: Identificador único de la actividad a eliminar
     */
    fun deleteActivity(id: String) {
        // Filtrar la lista: mantener solo las actividades cuyo ID no coincida
        val current = _activities.value.orEmpty()
        _activities.value = current.filter { it.id != id }
    }
    
    /**
     * MARCAR/DESMARCAR ACTIVIDAD COMO COMPLETADA
     * 
     * Cambia el estado de completado de una actividad.
     * 
     * @param id: Identificador único de la actividad
     */
    fun toggleActivityCompleted(id: String) {
        val current = _activities.value.orEmpty()
        _activities.value = current.map { activity ->
            if (activity.id == id) {
                activity.copy(isCompleted = !activity.isCompleted)
            } else {
                activity
            }
        }
    }
    
    /**
     * GUARDAR NOMBRE DEL USUARIO
     * 
     * Persiste el nombre del usuario en el almacenamiento local
     * para que se mantenga entre sesiones de la app.
     * 
     * @param name: Nombre del usuario a guardar
     */
    suspend fun saveUserName(name: String) {
        userPreferencesRepository.saveUserName(name)
    }
    
    /**
     * VERIFICAR SI HAY NOMBRE GUARDADO
     * 
     * Comprueba si el usuario ya ha configurado su nombre.
     * Útil para decidir si mostrar la pantalla de bienvenida.
     * 
     * @return true si hay un nombre guardado, false si no
     */
    suspend fun hasUserName(): Boolean {
        return userPreferencesRepository.userName.first() != null
    }
}
