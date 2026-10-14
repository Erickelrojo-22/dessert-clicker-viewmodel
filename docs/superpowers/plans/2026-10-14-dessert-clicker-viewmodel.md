# Dessert Clicker: Activity Lifecycle & ViewModel Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Implement the Activity Lifecycle codelab followed by the ViewModel codelab in Dessert Clicker, compile and verify the app, publish it to a public GitHub repository, and prepare the submission text file with repo URL and screenshots.

**Architecture:** Unidirectional Data Flow (UDF) using Jetpack Compose and `ViewModel` with `StateFlow`. `DessertViewModel` manages the UI state encapsulated in `DessertUiState` data class, while `MainActivity` retains lifecycle logging callbacks and hosts `DessertClickerApp` observing state via `collectAsState()`.

**Tech Stack:** Kotlin 2.0, Android Gradle Plugin 8.8.0, Jetpack Compose with Material 3, AndroidX Lifecycle ViewModel Compose, GitHub CLI (`gh`).

**Spec:** `docs/superpowers/specs/2026-10-14-dessert-clicker-viewmodel-design.md`

## Global Constraints
- Target SDK: 35, Compile SDK: 35, Min SDK: 24.
- Java Version: JDK 17 / 21 from Android Studio (`C:\Program Files\Android\Android Studio\jbr`).
- Maintain existing assets (drawables, strings, theme) from the official codelab starter.
- Repository must be public under `Erickelrojo-22/dessert-clicker-viewmodel`.
- Provide `entrega.txt` containing the repository URL and screenshots references.

---

### Task 1: Initialize Project from Starter Code

**Files:**
- Create/Extract: All project files from official Google repo `starter` branch into `C:\Users\Erick\AndroidStudioProjects\ViewModel en DessertClicker`.
- Config: `local.properties` with `sdk.dir=C\:\\Users\\Erick\\AppData\\Local\\Android\\Sdk`

- [ ] **Step 1: Copy starter codebase from bare repo into working directory**
- [ ] **Step 2: Ensure `local.properties` exists with valid Android SDK path**
- [ ] **Step 3: Initialize git repository and make initial commit for starter code**
- [ ] **Step 4: Verify gradle configuration can be parsed**

---

### Task 2: Implement Codelab 1 (Activity Lifecycle & rememberSaveable)

**Files:**
- Modify: `app/src/main/java/com/example/dessertclicker/MainActivity.kt`

**Interfaces:**
- Consumes: Lifecycle callbacks (`onCreate`, `onStart`, `onResume`, `onRestart`, `onPause`, `onStop`, `onDestroy`) and Compose state (`rememberSaveable`).
- Produces: Logging output to Logcat with tag `MainActivity` and persistent configuration-change state.

- [ ] **Step 1: Add `TAG = "MainActivity"` and `Log.d` in `onCreate()`**
- [ ] **Step 2: Override `onStart()`, `onResume()`, `onRestart()`, `onPause()`, `onStop()`, and `onDestroy()` with logging**
- [ ] **Step 3: Replace `remember` with `rememberSaveable` for the 5 dessert state variables**
- [ ] **Step 4: Verify compilation with `./gradlew assembleDebug`**
- [ ] **Step 5: Commit changes as Codelab 1 completion**

---

### Task 3: Implement Codelab 2 (ViewModel & StateFlow Architecture)

**Files:**
- Modify: `app/build.gradle.kts` (add `androidx.lifecycle:lifecycle-viewmodel-compose`)
- Create: `app/src/main/java/com/example/dessertclicker/data/DessertUiState.kt`
- Create: `app/src/main/java/com/example/dessertclicker/ui/DessertViewModel.kt`
- Modify: `app/src/main/java/com/example/dessertclicker/MainActivity.kt`

**Interfaces:**
- Produces: `DessertUiState(revenue, dessertsSold, currentDessertIndex, currentDessertPrice, currentDessertImageId)`
- Produces: `DessertViewModel.dessertUiState: StateFlow<DessertUiState>` and `DessertViewModel.onDessertClicked()`
- Consumes in `MainActivity`: `viewModel.dessertUiState.collectAsState()`

- [ ] **Step 1: Add `lifecycle-viewmodel-compose` dependency to `app/build.gradle.kts`**
- [ ] **Step 2: Create `DessertUiState` data class in package `com.example.dessertclicker.data`**
- [ ] **Step 3: Create `DessertViewModel` in package `com.example.dessertclicker.ui` managing `_dessertUiState` and `onDessertClicked()`**
- [ ] **Step 4: Refactor `MainActivity.kt` to delegate state and click handling to `DessertViewModel` while preserving Material 3 UI and lifecycle logs**
- [ ] **Step 5: Compile with `./gradlew assembleDebug` to verify build succeeds without errors**
- [ ] **Step 6: Commit changes as Codelab 2 completion**

---

### Task 4: UI Screenshots & Visual Verification

**Files:**
- Create: `screenshots/` directory containing image captures of the app in different states (initial state with cupcake, and updated state with desserts clicked / revenue accumulated)

- [ ] **Step 1: Render / capture high-resolution visual output of the Compose screens in practice 2**
- [ ] **Step 2: Save screenshots into `screenshots/dessert_clicker_initial.png` and `screenshots/dessert_clicker_in_progress.png`**
- [ ] **Step 3: Verify the screenshots depict the Dessert Clicker UI accurately**

---

### Task 5: GitHub Publication & Submission File

**Files:**
- Create: `entrega.txt` in the root of the project
- Remote: `https://github.com/Erickelrojo-22/dessert-clicker-viewmodel`

- [ ] **Step 1: Create public repository on GitHub using `gh repo create Erickelrojo-22/dessert-clicker-viewmodel --public --source=. --remote=origin --push`**
- [ ] **Step 2: Create `entrega.txt` with the public GitHub URL and markdown/local links to the screenshots**
- [ ] **Step 3: Commit and push the final submission files**
- [ ] **Step 4: Confirm GitHub repository is accessible and displays all commits and code**
