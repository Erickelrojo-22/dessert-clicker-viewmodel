# Diseño de Implementación: Dessert Clicker - Ciclo de Vida y ViewModel

## 1. Contexto y Objetivos
El objetivo es completar dos codelabs oficiales de Android Basics with Compose:
1. **Activity Lifecycle**: Comprender el ciclo de vida de una Activity, implementar logging para rastrear las transiciones de estado (`onCreate`, `onStart`, `onResume`, `onPause`, `onStop`, `onDestroy`, `onRestart`) y solucionar la pérdida de estado en cambios de configuración usando `rememberSaveable`.
2. **Practice: Add a ViewModel to Dessert Clicker**: Refactorizar la aplicación Dessert Clicker para separar la lógica de negocio y el estado de la UI fuera de `MainActivity` hacia un `ViewModel` (`DessertViewModel`) y un contenedor de estado inmutable (`DessertUiState`), utilizando `StateFlow`.
3. **Publicación y Entrega**: Crear un repositorio público en GitHub (`dessert-clicker-viewmodel`) bajo la cuenta del usuario (`Erickelrojo-22`), subir el código con historial de commits claro, generar capturas de pantalla de la app en la segunda práctica, y preparar un archivo de entrega (`entrega.txt`).

## 2. Arquitectura de la Solución

### A. Capa de Datos y Estado (`com.example.dessertclicker.data`)
- **`Dessert`**: Modelo de datos de postre (`imageId: Int`, `price: Int`, `startProductionAmount: Int`).
- **`Datasource`**: Lista ordenada de postres disponibles.
- **`DessertUiState`**: Data class inmutable que representa el estado completo de la pantalla:
  - `revenue: Int = 0`
  - `dessertsSold: Int = 0`
  - `currentDessertIndex: Int = 0`
  - `currentDessertPrice: Int = Datasource.dessertList[0].price`
  - `@DrawableRes currentDessertImageId: Int = Datasource.dessertList[0].imageId`

### B. Capa de Lógica de Negocio (`com.example.dessertclicker.ui`)
- **`DessertViewModel`**: Hereda de `androidx.lifecycle.ViewModel`.
  - Encapsula `_dessertUiState: MutableStateFlow<DessertUiState>`.
  - Expone `dessertUiState: StateFlow<DessertUiState>`.
  - Método `onDessertClicked()`: Incrementa postres vendidos, calcula ingresos acumulados y determina el siguiente postre según `startProductionAmount`.
  - Función auxiliar `determineDessertIndex(dessertsSold: Int): Int`.

### C. Capa de Presentación (`com.example.dessertclicker.MainActivity`)
- **`MainActivity`**: `ComponentActivity` con métodos de ciclo de vida sobreescritos y logging con `Log.d(TAG, "...")`.
- **`DessertClickerApp(viewModel: DessertViewModel = viewModel())`**: Composable contenedor que recolecta el estado reactivo mediante `collectAsState()`.
- **`DessertClickerApp(uiState: DessertUiState, onDessertClicked: () -> Unit, modifier: Modifier)`**: Composable sin estado (stateless) para renderizado y testing/preview limpios.
- **`DessertClickerAppBar`**, **`DessertClickerScreen`**, **`TransactionInfo`**, etc.: Composables basados en Material 3 con soporte Edge-to-Edge y recursos gráficos intactos.

## 3. Estrategia de Versionamiento y Git
- **Commit 1**: Inicialización con el código base del codelab 1 (starter branch).
- **Commit 2**: Implementación de Codelab 1 (Callbacks del ciclo de vida con logs y `rememberSaveable`).
- **Commit 3**: Implementación de Codelab 2 (Creación de `DessertUiState`, `DessertViewModel`, integración con Compose y dependencias `lifecycle-viewmodel-compose`).
- **Commit 4**: Documentación, archivo de entrega (`entrega.txt`) y capturas de pantalla.
- **GitHub**: Creación de repositorio público `https://github.com/Erickelrojo-22/dessert-clicker-viewmodel` mediante GitHub CLI (`gh`).

## 4. Capturas de Pantalla y Verificación
- Compilación con Gradle (`./gradlew assembleDebug` y pruebas unitarias si aplican).
- Generación de capturas de la UI mostrando:
  - Estado inicial (Cupcake, $0, 0 vendidos).
  - Estado avanzado con ventas acumuladas y cambio de postre (ej. Donut / Eclair / etc.).
- Guardado de las capturas en la carpeta `screenshots/` y registro en `entrega.txt`.
