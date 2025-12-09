# 📱 Actividades Diarias

> Una aplicación Android moderna y elegante para registrar y gestionar tus actividades diarias, construida con Fragments, RecyclerView y Material Design 3.

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-0095D5?style=for-the-badge&logo=kotlin&logoColor=white)
![Material Design](https://img.shields.io/badge/Material%20Design-757575?style=for-the-badge&logo=material-design&logoColor=white)
![MVVM](https://img.shields.io/badge/MVVM-Architecture-FF6B6B?style=for-the-badge)

## 📥 Descarga Directa

**¿Quieres probar la app sin compilar?** Descarga la APK directamente:

[⬇️ Descargar APK v1.1.0](https://github.com/DonGeeo87/Actividades-Diarias/releases/download/v1.1.0/app-debug.apk)

> 💡 **Nota**: Esta es una versión debug. Para instalarla en tu dispositivo Android, necesitas habilitar "Orígenes desconocidos" en la configuración de seguridad.
> 
> 📦 **Versiones anteriores**: [v1.0.0](https://github.com/DonGeeo87/Actividades-Diarias/releases/download/v1.0.0/app-debug.apk)

## 📖 Descripción

**Actividades Diarias** es una aplicación móvil desarrollada en Android que te permite registrar, visualizar y gestionar tus actividades del día a día de forma sencilla e intuitiva. 

La app está diseñada con un enfoque en la experiencia del usuario, ofreciendo:
- ✨ Interfaz moderna y atractiva con Material Components
- 🎨 Diseño limpio siguiendo el sistema 8dp grid
- 👤 Personalización con tu nombre
- 📝 Registro rápido de actividades
- 🎯 Material Design 3 con tema personalizado
- ✅ Marcar actividades como completadas

## 🎯 ¿Para quién es este proyecto?

Este proyecto es ideal para:
- 👨‍💻 **Estudiantes de programación** que quieren aprender Android moderno
- 🎓 **Desarrolladores trainee** que buscan ejemplos de buenas prácticas
- 📚 **Aprendices de Kotlin y Android** que necesitan un proyecto de referencia
- 🔍 **Cualquier persona** interesada en ver cómo se construye una app Android profesional
- 🎓 **Estudiantes de bootcamps** que necesitan cumplir requisitos específicos de arquitectura

## ✨ Características Principales

### 🎨 Interfaz de Usuario
- **Material Design 3**: Diseño siguiendo las últimas guías de Material You
- **Material Components**: Uso de MaterialButton, MaterialToolbar, TextInputLayout
- **Sistema 8dp Grid**: Espaciado consistente y profesional
- **Tema personalizado**: Paleta de colores azul (#4A90E2) y verde menta (#50E3C2)
- **Fondo cálido**: Color #F9FAFB para mejor experiencia visual
- **Tarjetas modernas**: Esquinas redondeadas (16dp) y elevación suave

### 👋 Personalización
- **Pantalla de bienvenida**: La app te saluda y pide tu nombre la primera vez
- **Saludo personalizado**: El nombre se muestra en la pantalla principal (28sp, bold)
- **Persistencia de datos**: Tu nombre se guarda con DataStore y se mantiene entre sesiones

### 📝 Gestión de Actividades
- **Registro rápido**: Agrega actividades con título y descripción opcional
- **Vista de lista**: Visualiza todas tus actividades usando RecyclerView con ListAdapter
- **Marcar como completado**: Marca actividades como hechas con checkbox (texto tachado)
- **Actualización en tiempo real**: La lista se actualiza automáticamente con LiveData
- **Estado vacío mejorado**: Mensaje ilustrado cuando no hay actividades

### 🏗️ Arquitectura
- **Fragments**: ListFragment y RegisterFragment con método factory
- **RecyclerView**: Lista eficiente con ListAdapter y DiffUtil
- **LiveData**: Manejo reactivo del estado (cumple requisitos del módulo)
- **MVVM**: Separación clara de responsabilidades
- **Navigation Component**: Navegación entre Fragments
- **Intents**: Navegación entre Activities con paso de datos mediante Bundles

### 🔐 Permisos y Ciclo de Vida
- **Permisos sensibles**: Gestión de permisos de almacenamiento usando Activity Result API
- **Ciclo de vida**: Manejo correcto de onCreate, onStart, onResume, onDestroyView
- **Lifecycle-aware**: Componentes que respetan el ciclo de vida de Activities y Fragments

## 🛠️ Tecnologías Utilizadas

Este proyecto utiliza las tecnologías más modernas del ecosistema Android:

### Lenguaje y Framework
- **Kotlin 2.0.21**: Lenguaje de programación moderno y seguro
- **Material Components**: Componentes Material Design nativos
- **Material Design 3**: Sistema de diseño de Google

### Arquitectura
- **MVVM (Model-View-ViewModel)**: Patrón arquitectónico para separar lógica y UI
- **LiveData**: Para manejo reactivo del estado (cumple requisitos del módulo)
- **Fragments**: Implementación con Fragment Factory y Bundles
- **Navigation Component**: Navegación entre Fragments
- **ViewModelFactory**: Inyección de dependencias para ViewModels

### Almacenamiento
- **DataStore Preferences**: Almacenamiento moderno y asíncrono para el nombre del usuario
- **LiveData en ViewModel**: Las actividades se gestionan con LiveData para actualización reactiva
- **Estado en memoria**: Las actividades se guardan en el ViewModel durante la sesión

### Componentes Android
- **Fragments**: Implementación con RegisterFragment y ListFragment
- **RecyclerView**: Lista eficiente con ListAdapter y DiffUtil
- **Intents**: Navegación entre Activities con paso de datos mediante Bundles
- **Ciclo de vida**: Manejo correcto de onCreate, onStart, onResume, etc.
- **Permisos**: Gestión de permisos sensibles (almacenamiento) con Activity Result API

### Librerías Principales
```gradle
- androidx.navigation:navigation-fragment:2.8.4
- androidx.lifecycle:lifecycle-viewmodel:2.8.6
- androidx.datastore:datastore-preferences:1.1.1
- com.google.android.material:material:1.12.0
- androidx.recyclerview:recyclerview:1.3.2
```

## 📸 Capturas de Pantalla

> 💡 **Nota para estudiantes**: Las capturas de pantalla muestran cómo se ve la app en un dispositivo real. Si quieres agregar las tuyas, toma screenshots desde Android Studio o un dispositivo físico.

### Pantalla Principal (ListFragment)
Lista de actividades con saludo personalizado, TopBar con botón de información, y FAB para agregar nuevas actividades.

### Formulario de Registro (RegisterFragment)
Interfaz simple y clara con Material Components para agregar nuevas actividades.

### Pantalla Acerca de (AboutActivity)
Demuestra el uso de Intents explícitos y el manejo de permisos sensibles.

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

### Marcar como Completado
1. En la lista principal, marca el checkbox de cualquier actividad
2. El texto se tachará automáticamente
3. La lista se actualiza en tiempo real gracias a LiveData

### Ver Información de la App
1. Toca el icono de información (ℹ️) en el TopBar azul
2. Se abrirá AboutActivity (demuestra uso de Intents)
3. Se solicitará permiso de almacenamiento (demuestra manejo de permisos)

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
│           │   ├── ui/                            # Interfaz de usuario
│           │   │   ├── fragments/                 # Fragments
│           │   │   │   ├── ListFragment.kt        # Fragment de lista de actividades
│           │   │   │   └── RegisterFragment.kt     # Fragment de registro
│           │   │   ├── adapter/                   # Adaptadores
│           │   │   │   └── ActivityAdapter.kt      # Adaptador para RecyclerView
│           │   │   └── AboutActivity.kt           # Activity secundaria (Intents)
│           │   │
│           │   ├── viewmodel/                     # Lógica de negocio
│           │   │   ├── ActivityViewModel.kt      # Maneja actividades y estado
│           │   │   └── ViewModelFactory.kt        # Crea ViewModels con dependencias
│           │   │
│           │   └── MainActivity.kt                # Punto de entrada de la app
│           │
│           └── res/                               # Recursos
│               ├── layout/                        # Layouts XML
│               │   ├── activity_main.xml
│               │   ├── fragment_list.xml
│               │   ├── fragment_register.xml
│               │   ├── item_activity.xml
│               │   └── activity_about.xml
│               ├── navigation/                    # Navigation Graph
│               │   └── nav_graph.xml
│               ├── values/                        # Valores (colores, strings, temas)
│               │   ├── colors.xml
│               │   └── themes.xml
│               └── values-night/                  # Tema oscuro
│                   └── themes.xml
│
└── gradle/                                        # Configuración de Gradle
    └── libs.versions.toml                        # Versiones de dependencias
```

### Explicación de la Estructura (Para Estudiantes)

- **`data/`**: Aquí va todo lo relacionado con almacenamiento (bases de datos, APIs, preferencias)
- **`model/`**: Define las estructuras de datos (como las "clases" que representan objetos)
- **`ui/fragments/`**: Los Fragments que muestran las pantallas principales
- **`ui/adapter/`**: El adaptador que conecta los datos con el RecyclerView
- **`viewmodel/`**: La "lógica de negocio" - procesa datos y prepara información para la UI
- **`res/layout/`**: Los archivos XML que definen cómo se ven las pantallas
- **`res/navigation/`**: Define cómo navegas entre Fragments

> 💡 **Tip para estudiantes**: Esta estructura sigue el patrón **MVVM** (Model-View-ViewModel), que es el estándar en Android moderno. Además, cumple con los requisitos del módulo de arquitectura y ciclo de vida.

## 🎓 Conceptos de Programación Aplicados

Este proyecto es excelente para aprender y cumple con los requisitos del módulo:

### Arquitectura y Componentes Android
- ✅ **Fragments**: Implementación con ListFragment y RegisterFragment
- ✅ **RecyclerView**: Lista eficiente con ListAdapter y DiffUtil
- ✅ **LiveData**: Manejo reactivo del estado (requisito del módulo)
- ✅ **MVVM**: Separación de responsabilidades
- ✅ **ViewModelFactory**: Inyección de dependencias
- ✅ **Ciclo de vida**: Manejo correcto de Activities y Fragments

### Kotlin y Programación
- ✅ **Kotlin básico**: Variables, funciones, clases, data classes
- ✅ **Scope Functions**: apply, let, with, run
- ✅ **Corrutinas**: Operaciones asíncronas (suspend, launch, viewModelScope)
- ✅ **Null Safety**: Manejo seguro de valores nulos

### Android Avanzado
- ✅ **Intents**: Navegación entre Activities con paso de datos
- ✅ **Bundles**: Paso de parámetros entre componentes
- ✅ **Permisos**: Gestión de permisos sensibles con Activity Result API
- ✅ **DataStore**: Almacenamiento moderno y asíncrono
- ✅ **Navigation Component**: Navegación declarativa entre Fragments

### Material Design
- ✅ **Material Components**: MaterialButton, MaterialToolbar, TextInputLayout
- ✅ **Material Design 3**: Sistema de diseño completo
- ✅ **Tema personalizado**: Colores y estilos personalizados
- ✅ **Sistema 8dp Grid**: Espaciado consistente

## 🔧 Personalización

### Cambiar los Colores

Los colores están definidos en `res/values/colors.xml`:

```xml
<color name="blue_primary">#4A90E2</color>      <!-- Azul principal -->
<color name="mint_secondary">#50E3C2</color>    <!-- Verde menta -->
<color name="background_light">#F9FAFB</color>   <!-- Fondo cálido -->
```

Puedes cambiar estos valores hexadecimales para personalizar la app.

### Agregar Nuevas Funcionalidades

Algunas ideas para extender el proyecto:

- 📅 Agregar fecha de vencimiento a las actividades
- 🏷️ Sistema de categorías o etiquetas
- 📊 Estadísticas (cuántas actividades por día)
- 🗑️ Eliminar actividades (swipe to delete)
- 💾 Persistencia con Room Database (guardar entre sesiones)
- 🔍 Búsqueda y filtrado de actividades

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

### "Error con MaterialButton"
- Asegúrate de que el tema sea `Theme.MaterialComponents` en `themes.xml`
- Verifica que la dependencia de Material Components esté incluida

## 📚 Recursos de Aprendizaje

Si estás aprendiendo Android, estos recursos te ayudarán:

- [Documentación oficial de Android](https://developer.android.com/)
- [Codelabs de Android](https://codelabs.developers.google.com/?cat=Android)
- [Kotlin para Android](https://developer.android.com/kotlin)
- [Material Design 3](https://m3.material.io/)
- [Fragments Guide](https://developer.android.com/guide/fragments)
- [RecyclerView Guide](https://developer.android.com/guide/topics/ui/layout/recyclerview)

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

`android` `kotlin` `material-design` `mvvm` `android-development` `mobile-app` `material-components` `android-studio` `kotlin-android` `livedata` `datastore` `navigation-component` `android-app` `material-design-3` `android-tutorial` `android-learning` `bootcamp` `fragments` `recyclerview` `viewmodel` `architecture` `lifecycle`

---

<div align="center">

### ⭐ Si este proyecto te ayudó, ¡dale una estrella! ⭐

**Hecho con ❤️ usando Material Components y MVVM**

</div>
