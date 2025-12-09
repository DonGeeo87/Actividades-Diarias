package dev.dongeeo.actividadesdiarias.model

/**
 * MODELO DE DATOS: Actividad
 * 
 * Representa una actividad individual registrada por el usuario.
 * Es una "data class", lo que significa que Kotlin genera automáticamente
 * funciones útiles como equals(), hashCode(), toString(), y copy().
 * 
 * Propiedades:
 * - id: Identificador único generado automáticamente (UUID)
 * - title: Título de la actividad (ej: "Ir al gimnasio")
 * - description: Descripción opcional de la actividad
 * - date: Fecha de creación formateada (ej: "15 Dic 2024")
 * - time: Hora de creación formateada (ej: "14:30")
 * 
 * Este modelo es inmutable: una vez creado, no se puede modificar.
 * Para cambiar algo, se crea una nueva instancia.
 */
data class ActivityItem(
    val id: String = java.util.UUID.randomUUID().toString(),  // ID único generado automáticamente
    val title: String,        // Título de la actividad (obligatorio)
    val description: String,  // Descripción opcional
    val date: String,         // Fecha formateada
    val time: String,         // Hora formateada
    val isCompleted: Boolean = false  // Estado de completado de la actividad
)
