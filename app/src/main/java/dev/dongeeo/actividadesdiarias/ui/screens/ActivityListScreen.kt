package dev.dongeeo.actividadesdiarias.ui.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.dongeeo.actividadesdiarias.ui.screens.components.ActivityCard
import dev.dongeeo.actividadesdiarias.ui.screens.components.EmptyStateView
import dev.dongeeo.actividadesdiarias.ui.theme.BluePrimary
import dev.dongeeo.actividadesdiarias.viewmodel.ActivityViewModel
import kotlinx.coroutines.delay

/**
 * PANTALLA PRINCIPAL: Lista de Actividades
 * 
 * Esta es la pantalla principal de la aplicación donde se muestran todas las actividades
 * registradas por el usuario. Incluye:
 * - Barra superior con saludo personalizado
 * - Lista de actividades con animaciones
 * - Botón flotante para agregar nuevas actividades
 * - Vista vacía cuando no hay actividades
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActivityListScreen(
    viewModel: ActivityViewModel,  // Contiene la lógica y datos de las actividades
    onAddClick: () -> Unit  // Función que se ejecuta al presionar el botón de agregar
) {
    // Obtener la lista de actividades desde el ViewModel (se actualiza automáticamente)
    val activities by viewModel.activities.collectAsState()
    
    // Obtener el nombre del usuario guardado (puede ser null si no se ha configurado)
    val userName by viewModel.userName.collectAsState(initial = null)
    
    // Estado de la lista para controlar el scroll y animaciones
    val listState = rememberLazyListState()
    
    // Crear el saludo personalizado: si hay nombre, lo incluye; si no, solo dice "Hola"
    val greeting = when {
        !userName.isNullOrBlank() -> "Hola, $userName 👋"
        else -> "Hola 👋"
    }

    // Scaffold es el contenedor principal que organiza: barra superior, contenido y botón flotante
    Scaffold(
        // BARRA SUPERIOR: Muestra el saludo y título
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        // Saludo personalizado con el nombre del usuario
                        Text(
                            text = greeting,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                        // Subtítulo descriptivo
                        Text(
                            text = "Estas son tus actividades",
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.85f)
                        )
                    }
                },
                // Color de fondo de la barra superior (azul primario)
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BluePrimary
                )
            )
        },
        // BOTÓN FLOTANTE: Botón circular en la esquina inferior derecha para agregar actividades
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddClick,  // Al hacer clic, navega a la pantalla de registro
                containerColor = BluePrimary,
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Agregar actividad",
                    tint = androidx.compose.ui.graphics.Color.White
                )
            }
        }
    ) { paddingValues ->
        // CONTENIDO PRINCIPAL: Área donde se muestra la lista o el estado vacío
        Box(
            modifier = Modifier
                .fillMaxSize()
                // Fondo con gradiente sutil (de azul claro a blanco)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            BluePrimary.copy(alpha = 0.03f),
                            MaterialTheme.colorScheme.background
                        )
                    )
                )
                .padding(paddingValues)
        ) {
            // Si no hay actividades, mostrar la vista de estado vacío
            if (activities.isEmpty()) {
                EmptyStateView(onAddClick = onAddClick)
            } else {
                // LISTA DE ACTIVIDADES: Muestra todas las actividades con animaciones
                LazyColumn(
                    state = listState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    contentPadding = PaddingValues(vertical = 8.dp)
                ) {
                    // itemsIndexed permite acceder al índice de cada elemento para animaciones escalonadas
                    itemsIndexed(activities) { index, activity ->
                        // ANIMACIÓN DE ENTRADA: Cada tarjeta aparece gradualmente
                        // Estado inicial: invisible (alpha = 0)
                        var alpha by remember { mutableStateOf(0f) }
                        
                        // Animación que cambia la opacidad de 0 a 1
                        val animatedAlpha by animateFloatAsState(
                            targetValue = alpha,
                            animationSpec = tween(400, delayMillis = index * 50),  // Cada tarjeta aparece 50ms después de la anterior
                            label = "alpha"
                        )
                        
                        // Efecto que se ejecuta cuando la tarjeta aparece en pantalla
                        LaunchedEffect(Unit) {
                            delay(index * 50L)  // Esperar según la posición en la lista
                            alpha = 1f  // Hacer visible la tarjeta
                        }
                        
                        // Mostrar la tarjeta de actividad con la animación aplicada
                        ActivityCard(
                            item = activity,
                            modifier = Modifier.alpha(animatedAlpha)
                        )
                    }
                }
            }
        }
    }
}
