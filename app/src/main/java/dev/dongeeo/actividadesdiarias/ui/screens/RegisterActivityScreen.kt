package dev.dongeeo.actividadesdiarias.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.dongeeo.actividadesdiarias.ui.theme.BluePrimary
import dev.dongeeo.actividadesdiarias.viewmodel.ActivityViewModel

/**
 * PANTALLA DE REGISTRO DE ACTIVIDAD
 * 
 * Formulario simple para crear una nueva actividad.
 * Permite al usuario ingresar:
 * - Título de la actividad (obligatorio)
 * - Descripción opcional
 * 
 * Al guardar, la actividad se agrega a la lista y se regresa a la pantalla principal.
 * 
 * @param viewModel: Contiene la función para agregar actividades
 * @param onSaved: Función que se ejecuta después de guardar (normalmente navega atrás)
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterActivityScreen(
    viewModel: ActivityViewModel,
    onSaved: () -> Unit
) {
    // Estados de los campos de texto
    var title by remember { mutableStateOf("") }           // Título de la actividad
    var description by remember { mutableStateOf("") }    // Descripción opcional

    // Scaffold: Estructura básica con barra superior y contenido
    Scaffold(
        // BARRA SUPERIOR: Muestra el título de la pantalla
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Registrar actividad",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { paddingValues ->
        // CONTENIDO DEL FORMULARIO
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)  // Respetar el espacio de la barra superior
                .padding(20.dp)  // Espaciado adicional
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            // CAMPO DE TÍTULO: Obligatorio para crear la actividad
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },  // Actualizar cuando el usuario escribe
                label = { Text("Nombre de actividad") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true  // Solo una línea
            )

            Spacer(modifier = Modifier.height(12.dp))

            // CAMPO DE DESCRIPCIÓN: Opcional, permite múltiples líneas
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Descripción") },
                modifier = Modifier.fillMaxWidth(),
                maxLines = 4,   // Máximo 4 líneas visibles
                minLines = 3    // Mínimo 3 líneas (altura inicial)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // BOTÓN DE GUARDAR
            Button(
                onClick = {
                    // Solo guardar si el título no está vacío
                    if (title.isNotBlank()) {
                        // Agregar la actividad al ViewModel
                        viewModel.addActivity(title, description)
                        // Ejecutar callback (normalmente navega atrás)
                        onSaved()
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = title.isNotBlank(),  // Solo habilitado si hay título
                colors = ButtonDefaults.buttonColors(
                    containerColor = BluePrimary
                )
            ) {
                Text("Guardar actividad", color = androidx.compose.ui.graphics.Color.White)
            }
        }
    }
}
