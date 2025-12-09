package dev.dongeeo.actividadesdiarias.ui.screens.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.dongeeo.actividadesdiarias.model.ActivityItem
import dev.dongeeo.actividadesdiarias.ui.theme.BluePrimary
import dev.dongeeo.actividadesdiarias.ui.theme.MintSecondary
import dev.dongeeo.actividadesdiarias.ui.theme.TextSecondary

/**
 * TARJETA DE ACTIVIDAD
 * 
 * Componente reutilizable que muestra una actividad individual en una tarjeta elegante.
 * Características:
 * - Se puede expandir/contraer al hacer clic para ver la descripción
 * - Tiene un avatar circular con la inicial del título
 * - Muestra fecha y hora de creación
 * - Animaciones suaves al expandirse
 * - Diseño moderno con gradientes y sombras
 * 
 * @param item: Los datos de la actividad a mostrar (título, descripción, fecha, hora)
 * @param modifier: Modificadores adicionales para personalizar el diseño
 */
@Composable
fun ActivityCard(
    item: ActivityItem,
    modifier: Modifier = Modifier
) {
    // Estado que controla si la tarjeta está expandida (mostrando descripción) o contraída
    var expanded by remember { mutableStateOf(false) }

    // TARJETA PRINCIPAL: Contenedor con bordes redondeados y sombra
    Card(
        modifier = modifier
            .fillMaxWidth()  // Ocupa todo el ancho disponible
            .padding(horizontal = 16.dp, vertical = 8.dp)  // Espaciado alrededor de la tarjeta
            // Sombra dinámica: más pronunciada cuando está expandida
            .shadow(
                elevation = if (expanded) 12.dp else 6.dp,
                shape = RoundedCornerShape(20.dp),
                spotColor = BluePrimary.copy(alpha = 0.3f)  // Sombra con tinte azul
            )
            // Animación suave al cambiar de tamaño (expandir/contraer)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,  // Efecto de rebote suave
                    stiffness = Spring.StiffnessLow  // Movimiento más lento y natural
                )
            ),
        shape = RoundedCornerShape(20.dp),  // Bordes muy redondeados
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface  // Color de fondo de la tarjeta
        )
    ) {
        // CONTENEDOR INTERNO: Con gradiente de fondo cuando está expandida
        Box(
            modifier = Modifier
                .fillMaxWidth()
                // Gradiente horizontal: solo visible cuando la tarjeta está expandida
                .background(
                    Brush.horizontalGradient(
                        colors = if (expanded) listOf(
                            BluePrimary.copy(alpha = 0.05f),  // Azul muy transparente
                            MintSecondary.copy(alpha = 0.05f)  // Verde menta muy transparente
                        ) else listOf(
                            // Sin gradiente cuando está contraída
                            MaterialTheme.colorScheme.surface,
                            MaterialTheme.colorScheme.surface
                        )
                    )
                )
        ) {
            // CONTENIDO DE LA TARJETA
            Column(
                modifier = Modifier
                    .clickable { expanded = !expanded }  // Al hacer clic, cambia el estado expandido
                    .padding(20.dp)
            ) {
                // FILA PRINCIPAL: Avatar + Título y fecha
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // AVATAR CIRCULAR: Muestra la primera letra del título con gradiente
                    Box(
                        modifier = Modifier
                            .size(48.dp)  // Tamaño fijo: 48x48 píxeles
                            .clip(RoundedCornerShape(12.dp))  // Bordes redondeados
                            // Gradiente lineal de azul a verde menta
                            .background(
                                Brush.linearGradient(
                                    colors = listOf(BluePrimary, MintSecondary)
                                )
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        // Mostrar la primera letra del título en mayúscula
                        Text(
                            text = item.title.take(1).uppercase(),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = androidx.compose.ui.graphics.Color.White
                        )
                    }
                    
                    Spacer(modifier = Modifier.size(16.dp))  // Espacio entre avatar y texto
                    
                    // COLUMNA DE TEXTO: Título y fecha/hora
                    Column(modifier = Modifier.weight(1f)) {
                        // TÍTULO DE LA ACTIVIDAD
                        Text(
                            text = item.title,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        
                        Spacer(modifier = Modifier.height(4.dp))
                        
                        // FILA DE FECHA Y HORA: Con icono de reloj
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            // Icono de reloj pequeño
                            Icon(
                                imageVector = Icons.Default.AccessTime,
                                contentDescription = null,
                                modifier = Modifier.size(14.dp),
                                tint = TextSecondary
                            )
                            Spacer(modifier = Modifier.size(6.dp))
                            // Fecha y hora formateadas (ej: "15 Dic 2024 · 14:30")
                            Text(
                                text = "${item.date} · ${item.time}",
                                color = TextSecondary,
                                fontSize = 13.sp
                            )
                        }
                    }
                }

                // DESCRIPCIÓN: Solo visible cuando la tarjeta está expandida
                if (expanded) {
                    Spacer(modifier = Modifier.height(12.dp))
                    // Contenedor con fondo sutil para la descripción
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                            .padding(12.dp)
                    ) {
                        // Mostrar descripción o mensaje si está vacía
                        Text(
                            text = item.description.ifEmpty { "Sin descripción" },
                            color = TextSecondary,
                            fontSize = 14.sp,
                            lineHeight = 20.sp
                        )
                    }
                }
            }
        }
    }
}
