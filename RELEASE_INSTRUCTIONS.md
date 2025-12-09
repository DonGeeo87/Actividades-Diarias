# 📦 Instrucciones para Crear el Release v1.0.0

## Pasos para crear el release en GitHub:

1. **Ve a tu repositorio en GitHub:**
   - https://github.com/DonGeeo87/Actividades-Diarias

2. **Haz clic en "Releases"** (en el menú lateral derecho)

3. **Haz clic en "Draft a new release"**

4. **Selecciona el tag v1.0.0** (debería aparecer en el dropdown)

5. **Título del release:**
   ```
   v1.0.0 - Primera versión de Actividades Diarias
   ```

6. **Descripción del release:**
   ```markdown
   ## 🎉 Primera versión de Actividades Diarias
   
   ### ✨ Características principales:
   - Interfaz moderna con Material Design 3
   - Animaciones fluidas y microinteracciones
   - Personalización con nombre de usuario
   - Registro rápido de actividades
   - Diseño Material You 2025
   
   ### 📱 Instalación:
   1. Descarga el archivo `app-debug.apk`
   2. Habilita "Orígenes desconocidos" en tu dispositivo Android
   3. Instala la APK
   4. ¡Disfruta de la app!
   
   ### 🛠️ Tecnologías:
   - Kotlin 2.0.21
   - Jetpack Compose
   - Material Design 3
   - MVVM Architecture
   - DataStore Preferences
   ```

7. **Arrastra y suelta el archivo APK:**
   - Ubicación: `app/build/outputs/apk/debug/app-debug.apk`
   - Arrástralo a la sección "Attach binaries"

8. **Marca como "Latest release"** (si es la primera versión)

9. **Haz clic en "Publish release"**

## ✅ Después de crear el release:

El link de descarga en el README funcionará automáticamente:
```
https://github.com/DonGeeo87/Actividades-Diarias/releases/download/v1.0.0/app-debug.apk
```

