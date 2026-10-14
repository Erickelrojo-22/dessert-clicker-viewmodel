# Dessert Clicker: Activity Lifecycle & ViewModel

Proyecto desarrollado para el curso **Android Basics with Compose**, completando los codelabs oficiales de:
1. [Stages of the Activity Lifecycle](https://developer.android.com/codelabs/basic-android-kotlin-compose-activity-lifecycle)
2. [Practice: Add a ViewModel to Dessert Clicker](https://developer.android.com/codelabs/basic-android-kotlin-compose-practice-viewmodel)

---

## 🛠️ Tecnologías y Arquitectura
- **Lenguaje**: Kotlin 2.2 / JDK 25 & 11
- **UI Toolkit**: Jetpack Compose con Material 3 y soporte Edge-to-Edge
- **Gestión de Estado**: Android Jetpack `ViewModel` + Kotlin `StateFlow` / `MutableStateFlow` (Flujo de Datos Unidireccional - UDF)
- **Persistencia en Ciclo de Vida**: Manejo de cambios de configuración y callbacks de ciclo de vida con logging (`Log.d`).
- **Pruebas Unitarias**: JUnit 4 (`DessertViewModelTest`) para verificar el estado inicial y la transición de postres según ingresos/ventas.

---

## 📁 Estructura del Proyecto

```
app/src/
├── main/java/com/example/dessertclicker/
│   ├── MainActivity.kt          # Activity principal, callbacks de ciclo de vida y composables UI
│   ├── data/
│   │   ├── Datasource.kt        # Lista de postres y sus precios/umbrales de producción
│   │   └── DessertUiState.kt    # Data class que encapsula el estado de la UI
│   ├── model/
│   │   └── Dessert.kt           # Modelo de datos de un postre
│   └── ui/
│       ├── DessertViewModel.kt  # ViewModel que maneja la lógica de negocio y StateFlow
│       └── theme/               # Tema Material 3, colores y tipografía
└── test/java/com/example/dessertclicker/ui/
    └── DessertViewModelTest.kt  # Pruebas unitarias de la lógica del ViewModel
```

---

## 🧪 Pruebas Unitarias

Para ejecutar las pruebas unitarias:
```bash
./gradlew testDebugUnitTest
```

---

## 🚀 Cómo Ejecutar el Proyecto
1. Abrir la carpeta del proyecto en **Android Studio**.
2. Sincronizar los archivos de Gradle.
3. Seleccionar un emulador o dispositivo físico con Android 7.0+ (API 24 o superior).
4. Presionar **Run 'app'** (`Shift + F10`).
