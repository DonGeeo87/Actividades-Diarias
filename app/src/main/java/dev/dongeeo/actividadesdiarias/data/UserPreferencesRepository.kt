package dev.dongeeo.actividadesdiarias.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * EXTENSIÓN DE CONTEXTO: DataStore de Preferencias
 * 
 * Crea una instancia de DataStore para guardar preferencias del usuario.
 * DataStore es la forma moderna y recomendada de guardar datos simples
 * en Android (reemplaza a SharedPreferences).
 * 
 * Se crea una vez y se reutiliza durante toda la vida de la aplicación.
 * Los datos persisten entre sesiones (se mantienen al cerrar y abrir la app).
 */
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_preferences")

/**
 * REPOSITORIO DE PREFERENCIAS DE USUARIO
 * 
 * Encapsula el acceso a las preferencias guardadas del usuario.
 * Proporciona una interfaz simple para leer y escribir el nombre del usuario.
 * 
 * Usa DataStore, que es:
 * - Asíncrono (no bloquea el hilo principal)
 * - Type-safe (seguro de tipos)
 * - Reactivo (emite cambios automáticamente)
 * 
 * @param context: Contexto de Android necesario para acceder al almacenamiento
 */
class UserPreferencesRepository(private val context: Context) {
    /**
     * OBJETO COMPAÑERO: Constantes compartidas
     * 
     * Contiene las claves usadas para guardar/leer valores.
     * Las claves deben ser únicas y consistentes.
     */
    companion object {
        // Clave para guardar/leer el nombre del usuario
        val USER_NAME_KEY = stringPreferencesKey("user_name")
    }

    /**
     * FLUJO DEL NOMBRE DEL USUARIO
     * 
     * Flow es un tipo de datos reactivo que emite valores cuando cambian.
     * Las pantallas pueden "observar" este flujo y actualizarse automáticamente
     * cuando el nombre cambia.
     * 
     * @return Flow que emite el nombre guardado (puede ser null si no hay nombre)
     */
    val userName: Flow<String?> = context.dataStore.data.map { preferences ->
        // Leer el valor guardado con la clave USER_NAME_KEY
        // Si no existe, retorna null
        preferences[USER_NAME_KEY]
    }

    /**
     * GUARDAR NOMBRE DEL USUARIO
     * 
     * Persiste el nombre en el almacenamiento local.
     * Es una función suspendida, lo que significa que debe llamarse
     * desde una corrutina (async/await).
     * 
     * @param name: Nombre del usuario a guardar
     */
    suspend fun saveUserName(name: String) {
        // Editar las preferencias de forma transaccional
        context.dataStore.edit { preferences ->
            // Guardar el nombre con la clave USER_NAME_KEY
            preferences[USER_NAME_KEY] = name
        }
    }
}
