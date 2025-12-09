package dev.dongeeo.actividadesdiarias.ui.screens.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EditCalendar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import dev.dongeeo.actividadesdiarias.ui.theme.MintSecondary
import dev.dongeeo.actividadesdiarias.ui.theme.TextSecondary
import kotlinx.coroutines.delay

/**
 * VISTA DE ESTADO VACÍO
 * 
 * Se muestra cuando el usuario no tiene actividades registradas.
 * Incluye:
 * - Icono animado con fondo circular
 * - Mensaje motivacional
 * - Botón para agregar la primera actividad
 * 
 * Diseñado para ser atractivo y animado, invitando al usuario a comenzar.
 * 
 * @param onAddClick: Función que se ejecuta al presionar el botón (navega a registro)
 */
@Composable
fun EmptyStateView(
    onAddClick: () -> Unit
) {
    // Estados para animaciones de entrada
    var alpha by remember { mutableStateOf(0f) }        // Opacidad del contenido
    var scale by remember { mutableStateOf(0.8f) }       // Escala del contenido
    var iconScale by remember { mutableStateOf(0f) }    // Escala del icono (animación separada)
    
    // ANIMACIÓN DE OPACIDAD: El contenido aparece gradualmente
    val animatedAlpha by animateFloatAsState(
        targetValue = alpha,
        animationSpec = tween(600),  // Duración: 600ms
        label = "alpha"
    )
    
    // ANIMACIÓN DE ESCALA: El contenido crece desde pequeño
    val animatedScale by animateFloatAsState(
        targetValue = scale,
        animationSpec = tween(500, delayMillis = 100),  // Inicia después de 100ms
        label = "scale"
    )
    
    // ANIMACIÓN DEL ICONO: El icono aparece después con efecto de "pop"
    val animatedIconScale by animateFloatAsState(
        targetValue = iconScale,
        animationSpec = tween(600, delayMillis = 200),  // Inicia después de 200ms
        label = "iconScale"
    )
    
    // EFECTO AL CARGAR: Iniciar las animaciones en secuencia
    LaunchedEffect(Unit) {
        delay(100)  // Pequeña pausa inicial
        alpha = 1f   // Hacer visible el contenido
        scale = 1f   // Tamaño normal del contenido
        delay(200)   // Esperar antes de animar el icono
        iconScale = 1f  // Tamaño normal del icono (efecto de "pop")
    }
    
    // CONTENEDOR PRINCIPAL: Centrado vertical y horizontalmente
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
            .alpha(animatedAlpha)      // Aplicar animación de opacidad
            .scale(animatedScale),     // Aplicar animación de escala
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // CONTENEDOR DEL ICONO: Con fondo circular y gradiente radial
        Box(
            modifier = Modifier
                .size(120.dp)  // Tamaño fijo: 120x120 píxeles
                .scale(animatedIconScale),  // Aplicar animación de escala al icono
            contentAlignment = Alignment.Center
        ) {
            // FONDO CIRCULAR: Gradiente radial (de adentro hacia afuera)
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.radialGradient(
                            colors = listOf(
                                BluePrimary.copy(alpha = 0.2f),   // Azul en el centro
                                MintSecondary.copy(alpha = 0.1f)  // Verde menta en los bordes
                            )
                        ),
                        shape = CircleShape  // Forma circular perfecta
                    ),
                contentAlignment = Alignment.Center
            ) {
                // ICONO DE CALENDARIO: Representa actividades/eventos
                Icon(
                    imageVector = Icons.Default.EditCalendar,
                    contentDescription = null,
                    modifier = Modifier.size(64.dp),  // Tamaño del icono: 64x64
                    tint = BluePrimary
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // TÍTULO PRINCIPAL
        Text(
            text = "No tienes actividades aún",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(8.dp))

        // TEXTO DESCRIPTIVO
        Text(
            text = "Registra tu primera actividad para comenzar",
            color = TextSecondary,
            fontSize = 15.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        // BOTÓN DE ACCIÓN: Invita al usuario a agregar su primera actividad
        Button(
            onClick = onAddClick,  // Navegar a la pantalla de registro
            colors = ButtonDefaults.buttonColors(
                containerColor = BluePrimary
            ),
            shape = RoundedCornerShape(16.dp),  // Bordes redondeados
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(
                "Agregar actividad",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}
