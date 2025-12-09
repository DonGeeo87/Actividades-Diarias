# 📱 Actividades Diarias

> Una aplicación Android moderna y elegante para registrar y gestionar tus actividades diarias, construida con Jetpack Compose y Material Design 3.

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-0095D5?style=for-the-badge&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpack-compose&logoColor=white)
![Material Design](https://img.shields.io/badge/Material%20Design-757575?style=for-the-badge&logo=material-design&logoColor=white)

## 📥 Descarga Directa

**¿Quieres probar la app sin compilar?** Descarga la APK directamente:

[⬇️ Descargar APK v1.0.0](https://github.com/DonGeeo87/Actividades-Diarias/releases/download/v1.0.0/app-debug.apk)

> 💡 **Nota**: Esta es una versión debug. Para instalarla en tu dispositivo Android, necesitas habilitar "Orígenes desconocidos" en la configuración de seguridad.

## 📖 Descripción

**Actividades Diarias** es una aplicación móvil desarrollada en Android que te permite registrar, visualizar y gestionar tus actividades del día a día de forma sencilla e intuitiva. 

La app está diseñada con un enfoque en la experiencia del usuario, ofreciendo:
- ✨ Interfaz moderna y atractiva
- 🎨 Animaciones fluidas y microinteracciones
- 👤 Personalización con tu nombre
- 📝 Registro rápido de actividades
- 🎯 Diseño Material You 2025

## 🎯 ¿Para quién es este proyecto?

Este proyecto es ideal para:
- 👨‍💻 **Estudiantes de programación** que quieren aprender Android moderno
- 🎓 **Desarrolladores trainee** que buscan ejemplos de buenas prácticas
- 📚 **Aprendices de Kotlin y Compose** que necesitan un proyecto de referencia
- 🔍 **Cualquier persona** interesada en ver cómo se construye una app Android profesional

## ✨ Características Principales

### 🎨 Interfaz de Usuario
- **Material Design 3**: Diseño siguiendo las últimas guías de Material You
- **Animaciones fluidas**: Transiciones suaves y microinteracciones que mejoran la experiencia
- **Tema personalizado**: Paleta de colores azul y verde menta
- **Modo claro**: Optimizado para una experiencia visual agradable

### 👋 Personalización
- **Pantalla de bienvenida**: La app te saluda y pide tu nombre la primera vez
- **Saludo personalizado**: El nombre se muestra en la pantalla principal
- **Persistencia de datos**: Tu nombre se guarda y se mantiene entre sesiones

### 📝 Gestión de Actividades
- **Registro rápido**: Agrega actividades con título y descripción opcional
- **Vista de lista**: Visualiza todas tus actividades usando RecyclerView con adaptador
- **Marcar como completado**: Marca actividades como hechas para ir despejando la lista
- **Actualización en tiempo real**: La lista se actualiza automáticamente con LiveData
- **Estado vacío**: Mensaje cuando no hay actividades

### 🎭 Animaciones
- **Entrada escalonada**: Las tarjetas aparecen una por una con efecto fade-in
- **Expansión suave**: Las tarjetas se expanden con animación spring
- **Transiciones**: Navegación fluida entre pantallas

## 🛠️ Tecnologías Utilizadas

Este proyecto utiliza las tecnologías más modernas del ecosistema Android:

### Lenguaje y Framework
- **Kotlin 2.0.21**: Lenguaje de programación moderno y seguro
- **Jetpack Compose**: Framework declarativo para construir UIs
- **Material 3**: Sistema de diseño de Google

### Arquitectura
- **MVVM (Model-View-ViewModel)**: Patrón arquitectónico para separar lógica y UI
- **LiveData**: Para manejo reactivo del estado (cumple requisitos del módulo)
- **Fragments**: Implementación con Fragment Factory y Bundles
- **Navigation Component**: Navegación entre Fragments

### Almacenamiento
- **DataStore Preferences**: Almacenamiento moderno y asíncrono para el nombre del usuario
- **LiveData en ViewModel**: Las actividades se gestionan con LiveData para actualización reactiva
- **Estado en memoria**: Las actividades se guardan en el ViewModel durante la sesión

### Componentes Android
- **Fragments**: Implementación con RegisterFragment y ListFragment
- **RecyclerView**: Lista eficiente con ListAdapter y DiffUtil
- **Intents**: Navegación entre Activities con paso de datos mediante Bundles
- **Ciclo de vida**: Manejo correcto de onCreate, onStart, onResume, etc.
- **Permisos**: Gestión de permisos sensibles (notificaciones) con Activity Result API

### Librerías Principales
```gradle
- androidx.compose.bom:2024.12.01
- androidx.navigation:navigation-compose:2.8.4
- androidx.lifecycle:lifecycle-viewmodel-compose:2.8.6
- androidx.datastore:datastore-preferences:1.1.1
```

## 📸 Capturas de Pantalla

> 💡 **Nota para estudiantes**: Las capturas de pantalla muestran cómo se ve la app en un dispositivo real. Si quieres agregar las tuyas, toma screenshots desde Android Studio o un dispositivo físico.

### Pantalla de Bienvenida
La primera vez que abres la app, te pide tu nombre con una animación suave.

### Pantalla Principal
Lista de actividades con saludo personalizado y botón flotante para agregar nuevas.

### Formulario de Registro
Interfaz simple y clara para agregar nuevas actividades.

## 🚀 Instalación y Configuración

### Requisitos Previos

Antes de comenzar, asegúrate de tener instalado:

- **Android Studio** (versión Hedgehog o superior recomendada)
- **JDK 11** o superior
- **Android SDK** con API nivel 24 como mínimo
- **Git** para clonar el repositorio

### Pasos para Instalar

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/DonGeeo87/ActividadesDiarias.git
   cd ActividadesDiarias
   ```

2. **Abrir en Android Studio**
   - Abre Android Studio
   - Selecciona "Open an Existing Project"
   - Navega a la carpeta del proyecto y selecciónala

3. **Sincronizar Gradle**
   - Android Studio detectará automáticamente el proyecto
   - Espera a que Gradle sincronice las dependencias (puede tomar unos minutos la primera vez)

4. **Ejecutar la aplicación**
   - Conecta un dispositivo Android o inicia un emulador
   - Haz clic en el botón "Run" (▶️) o presiona `Shift + F10`
   - La app se instalará y ejecutará automáticamente

### Configuración del Emulador (si no tienes dispositivo físico)

1. En Android Studio, ve a **Tools > Device Manager**
2. Haz clic en **Create Device**
3. Selecciona un dispositivo (recomendado: Pixel 5 o superior)
4. Elige una imagen del sistema (recomendado: API 33 o superior)
5. Completa la configuración y crea el emulador

## 📱 Cómo Usar la Aplicación

### Primera Vez
1. Al abrir la app por primera vez, verás la pantalla de bienvenida
2. Ingresa tu nombre en el campo de texto
3. Presiona "Continuar"
4. ¡Listo! Ya estás en la pantalla principal

### Agregar una Actividad
1. Toca el botón flotante azul con el ícono "+" (esquina inferior derecha)
2. Completa el formulario:
   - **Nombre de actividad**: Campo obligatorio (ej: "Ir al gimnasio")
   - **Descripción**: Campo opcional (ej: "Rutina de piernas")
3. Presiona "Guardar actividad"
4. La actividad aparecerá en tu lista

### Ver Detalles de una Actividad
1. En la lista principal, toca cualquier tarjeta de actividad
2. La tarjeta se expandirá mostrando la descripción completa
3. Toca nuevamente para contraerla

## 📁 Estructura del Proyecto

Para estudiantes: esta estructura sigue las mejores prácticas de Android. Cada carpeta tiene un propósito específico.

```
ActividadesDiarias/
│
├── app/
│   └── src/
│       └── main/
│           ├── java/dev/dongeeo/actividadesdiarias/
│           │   │
│           │   ├── data/                          # Capa de datos
│           │   │   └── UserPreferencesRepository.kt  # Guarda el nombre del usuario
│           │   │
│           │   ├── model/                         # Modelos de datos
│           │   │   └── ActivityItem.kt            # Estructura de una actividad
│           │   │
│           │   ├── navigation/                    # Navegación
│           │   │   └── AppNavigation.kt           # Rutas y navegación entre pantallas
│           │   │
│           │   ├── ui/                            # Interfaz de usuario
│           │   │   ├── screens/                   # Pantallas principales
│           │   │   │   ├── ActivityListScreen.kt   # Pantalla principal (lista)
│           │   │   │   ├── RegisterActivityScreen.kt  # Formulario de registro
│           │   │   │   └── WelcomeScreen.kt       # Pantalla de bienvenida
│           │   │   │
│           │   │   ├── screens/components/        # Componentes reutilizables
│           │   │   │   ├── ActivityCard.kt        # Tarjeta de actividad
│           │   │   │   └── EmptyStateView.kt      # Vista cuando no hay actividades
│           │   │   │
│           │   │   └── theme/                     # Tema y estilos
│           │   │       ├── Color.kt               # Paleta de colores
│           │   │       ├── Theme.kt               # Configuración del tema
│           │   │       └── Type.kt                # Tipografía
│           │   │
│           │   ├── viewmodel/                     # Lógica de negocio
│           │   │   ├── ActivityViewModel.kt      # Maneja actividades y estado
│           │   │   └── ViewModelFactory.kt        # Crea ViewModels con dependencias
│           │   │
│           │   └── MainActivity.kt                # Punto de entrada de la app
│           │
│           └── res/                               # Recursos (imágenes, colores, etc.)
│
└── gradle/                                        # Configuración de Gradle
    └── libs.versions.toml                        # Versiones de dependencias
```

### Explicación de la Estructura (Para Estudiantes)

- **`data/`**: Aquí va todo lo relacionado con almacenamiento (bases de datos, APIs, preferencias)
- **`model/`**: Define las estructuras de datos (como las "clases" que representan objetos)
- **`ui/`**: Todo lo visual (pantallas, componentes, temas)
- **`viewmodel/`**: La "lógica de negocio" - procesa datos y prepara información para la UI
- **`navigation/`**: Controla cómo navegas entre pantallas

> 💡 **Tip para estudiantes**: Esta estructura sigue el patrón **MVVM** (Model-View-ViewModel), que es el estándar en Android moderno.

## 🎓 Conceptos de Programación Aplicados

Este proyecto es excelente para aprender:

### Para Principiantes
- ✅ **Kotlin básico**: Variables, funciones, clases
- ✅ **Compose básico**: @Composable, Column, Row, Text
- ✅ **Estado**: remember, mutableStateOf
- ✅ **Navegación**: Cómo pasar de una pantalla a otra

### Para Intermedios
- ✅ **Arquitectura MVVM**: Separación de responsabilidades
- ✅ **StateFlow**: Programación reactiva
- ✅ **Corrutinas**: Operaciones asíncronas (suspend, launch)
- ✅ **DataStore**: Almacenamiento moderno
- ✅ **Animaciones**: animateFloatAsState, animateContentSize

### Para Avanzados
- ✅ **Inyección de dependencias**: ViewModelFactory
- ✅ **Flows reactivos**: Observar cambios de datos
- ✅ **Material Design 3**: Sistema de diseño completo
- ✅ **Compose avanzado**: Modifiers, Layouts personalizados

## 🔧 Personalización

### Cambiar los Colores

Los colores están definidos en `ui/theme/Color.kt`:

```kotlin
val BluePrimary = Color(0xFF4A90E2)      // Azul principal
val MintSecondary = Color(0xFF50E3C2)    // Verde menta
```

Puedes cambiar estos valores hexadecimales para personalizar la app.

### Agregar Nuevas Funcionalidades

Algunas ideas para extender el proyecto:

- 📅 Agregar fecha de vencimiento a las actividades
- 🏷️ Sistema de categorías o etiquetas
- 🔔 Notificaciones recordatorias
- 📊 Estadísticas (cuántas actividades por día)
- 🗑️ Eliminar actividades (ya está la función, solo falta la UI)
- 💾 Persistencia con Room Database (guardar entre sesiones)

## 🐛 Solución de Problemas Comunes

### "Gradle sync failed"
- Verifica tu conexión a internet
- Asegúrate de tener la última versión de Android Studio
- Intenta: **File > Invalidate Caches / Restart**

### "No se encuentra el dispositivo"
- Verifica que el dispositivo esté conectado: `adb devices`
- Habilita "Depuración USB" en las opciones de desarrollador
- Acepta el diálogo de autorización en el dispositivo

### "La app se cierra al abrirla"
- Revisa Logcat en Android Studio para ver el error
- Verifica que todas las dependencias estén sincronizadas
- Limpia el proyecto: **Build > Clean Project**

## 📚 Recursos de Aprendizaje

Si estás aprendiendo Android, estos recursos te ayudarán:

- [Documentación oficial de Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Codelabs de Android](https://codelabs.developers.google.com/?cat=Android)
- [Kotlin para Android](https://developer.android.com/kotlin)
- [Material Design 3](https://m3.material.io/)

## 🤝 Contribuciones

Este es un proyecto educativo. Si encuentras algún error o tienes sugerencias:

1. Abre un **Issue** describiendo el problema o sugerencia
2. Si quieres contribuir código, crea un **Pull Request**
3. Asegúrate de que tu código esté bien comentado (siguiendo el estilo del proyecto)

## 📄 Licencia

Este proyecto es de código abierto y está disponible para fines educativos.

## 👨‍💻 Autor

**Giorgio Interdonato Palacios**

- GitHub: [@DonGeeo87](https://github.com/DonGeeo87)
- Proyecto desarrollado para: **Bootcamp Desarrollo de Apps en Android**
- Fecha: **9 de Diciembre de 2025**

---

## 🏷️ Tags

`android` `kotlin` `jetpack-compose` `material-design` `mvvm` `android-development` `mobile-app` `compose` `material-you` `android-studio` `kotlin-android` `stateflow` `datastore` `navigation-compose` `android-app` `material-design-3` `android-tutorial` `compose-ui` `android-learning` `bootcamp`

---

<div align="center">

### ⭐ Si este proyecto te ayudó, ¡dale una estrella! ⭐

**Hecho con ❤️ usando Jetpack Compose**

</div>

