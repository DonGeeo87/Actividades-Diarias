package dev.dongeeo.actividadesdiarias.ui.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.dongeeo.actividadesdiarias.ui.theme.BluePrimary
import dev.dongeeo.actividadesdiarias.viewmodel.ActivityViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.compose.runtime.rememberCoroutineScope

/**
 * PANTALLA DE BIENVENIDA
 * 
 * Esta pantalla se muestra solo la primera vez que el usuario abre la aplicación.
 * Su propósito es:
 * - Dar la bienvenida al usuario
 * - Solicitar y guardar el nombre del usuario
 * - Personalizar la experiencia con el nombre guardado
 * 
 * Incluye animaciones suaves de entrada para una experiencia agradable.
 * 
 * @param viewModel: Contiene la lógica para guardar el nombre del usuario
 * @param onComplete: Función que se ejecuta cuando el usuario guarda su nombre
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(
    viewModel: ActivityViewModel,
    onComplete: () -> Unit
) {
    // Estado del campo de texto: almacena lo que el usuario escribe
    var name by remember { mutableStateOf("") }
    
    // Estados para animaciones de entrada
    var alpha by remember { mutableStateOf(0f) }      // Opacidad (0 = invisible, 1 = visible)
    var scale by remember { mutableStateOf(0.8f) }    // Escala (0.8 = 80% del tamaño, 1 = tamaño normal)
    
    // Scope para ejecutar operaciones asíncronas (guardar nombre)
    val scope = rememberCoroutineScope()
    
    // ANIMACIÓN DE OPACIDAD: La tarjeta aparece gradualmente
    val animatedAlpha by animateFloatAsState(
        targetValue = alpha,
        animationSpec = tween(800),  // Duración: 800 milisegundos
        label = "alpha"
    )
    
    // ANIMACIÓN DE ESCALA: La tarjeta crece desde pequeño a tamaño normal
    val animatedScale by animateFloatAsState(
        targetValue = scale,
        animationSpec = tween(600, delayMillis = 200),  // Duración: 600ms, inicio después de 200ms
        label = "scale"
    )
    
    // EFECTO AL CARGAR: Iniciar las animaciones cuando la pantalla aparece
    LaunchedEffect(Unit) {
        delay(100)  // Pequeña pausa para suavizar la entrada
        alpha = 1f   // Hacer visible
        scale = 1f   // Tamaño normal
    }
    
    // CONTENEDOR PRINCIPAL: Fondo con gradiente sutil
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        BluePrimary.copy(alpha = 0.1f),  // Azul claro en la parte superior
                        MaterialTheme.colorScheme.background  // Color de fondo normal abajo
                    )
                )
            )
    ) {
        // TARJETA CENTRAL: Contiene el formulario de bienvenida
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)  // Espaciado desde los bordes
                .align(Alignment.Center)  // Centrar en la pantalla
                .alpha(animatedAlpha)      // Aplicar animación de opacidad
                .scale(animatedScale),    // Aplicar animación de escala
            shape = RoundedCornerShape(24.dp),  // Bordes muy redondeados
            elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),  // Sombra pronunciada
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface  // Color de fondo blanco
            )
        ) {
            // CONTENIDO DE LA TARJETA
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),  // Espaciado interno
                horizontalAlignment = Alignment.CenterHorizontally,  // Centrar elementos horizontalmente
                verticalArrangement = Arrangement.spacedBy(20.dp)  // Espacio entre elementos
            ) {
                // ICONO DE PERSONA: Representa al usuario
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    modifier = Modifier
                        .scale(1.5f)  // 50% más grande
                        .padding(bottom = 8.dp),
                    tint = BluePrimary  // Color azul primario
                )
                
                // TÍTULO DE BIENVENIDA
                Text(
                    text = "¡Bienvenido! 👋",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                
                // TEXTO DESCRIPTIVO
                Text(
                    text = "Para comenzar, cuéntanos tu nombre",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)  // Texto más suave
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // CAMPO DE TEXTO: Donde el usuario escribe su nombre
                OutlinedTextField(
                    value = name,  // Valor actual del campo
                    onValueChange = { name = it },  // Actualizar cuando el usuario escribe
                    label = { Text("Tu nombre") },  // Etiqueta flotante
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,  // Solo una línea de texto
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = BluePrimary,  // Borde azul cuando está enfocado
                        focusedLabelColor = BluePrimary    // Etiqueta azul cuando está enfocado
                    ),
                    shape = RoundedCornerShape(12.dp)  // Bordes redondeados
                )
                
                // BOTÓN DE CONTINUAR
                Button(
                    onClick = {
                        // Solo guardar si el nombre no está vacío
                        if (name.isNotBlank()) {
                            scope.launch {
                                // Guardar el nombre (sin espacios al inicio/final)
                                viewModel.saveUserName(name.trim())
                                // Ejecutar callback para navegar a la siguiente pantalla
                                onComplete()
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = name.isNotBlank(),  // Solo habilitado si hay texto
                    colors = ButtonDefaults.buttonColors(
                        containerColor = BluePrimary
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        "Continuar",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = androidx.compose.ui.graphics.Color.White
                    )
                }
            }
        }
    }
}
