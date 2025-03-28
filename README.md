# TechAssignment-Aliaksandr_Ushakou

## 📌 Project Overview

This is an Android application developed as a technical assignment.
The project has two screens (Enter amount and Receipt).
The project follows modern Android development best practices,
using **Kotlin**, **MVVM architecture**, **Retrofit**, **Clean Architecture**,
and **Jetpack components** to ensure scalability, maintainability, and efficiency.

## 🔧 Tech Stack & Tools

- **Language:** Kotlin
- **Architecture:** MVVM + Clean Architecture
- **Dependency Injection:** Koin
- **Networking:** Retrofit + OkHttp
- **UI Components:** Jetpack Compose
- **Asynchronous Processing:** Coroutines + Flow
- **Build System:** Gradle (KTS)

## 🚀 Features

- Fetch and display data from a remote API
- Implement dependency injection for better code modularity
- Use best UI/UX practices for a smooth experience
- Follow Clean Architecture principles

## 📂 Project Structure

```

app/
├── di/            # Dependency Injection (Koin modules)
└── Activity/App/  # UI configuration files (Application, Activity)

design-system/
└── components/  # UI components (Keyboard, Loading)

network/
└── di/            # Dependency Injection (REST init Koin modules)

presentation/
├── base/          # Base elements layer
└── extension/     # Base extension layer
└── Constants      # Base constants layer

ui-kit/
├── colors/        # Colors layer
├── dimens/        # Dimensions layer
├── styles/        # Styles layer
├── theme/         # Themes layer
└── typography/    # Typography layer

purchase-api/
└── PurchaseLauncher/  # Purchase-impl module startup file to prevent cyclic dependency

purchase-impl/
├── data/          # Data layer (Repositories, API)
├── di/            # Dependency Injection (Koin modules)
├── domain/        # Business logic layer (Repositories, Models)
├── navigation/    # Navigation configuration (ViewModels, Compose Screens, Navigation Controllers)
└── presentation/  # UI layer (ViewModels, Compose Screens, Intent, State)
```

## 🛠️ Setup & Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/PIXXXA/TechAssignment-Aliaksandr_Ushakou.git
   ```
2. Open the project in **Android Studio** (latest version recommended).
3. Sync Gradle and build the project.
4. Run the app on an emulator or a physical device.

## 🧪 Testing

Run unit tests using:

```sh
./gradlew test
```

Run instrumented tests on a device:

```sh
./gradlew connectedAndroidTest
```

## 📌 Contributing

Contributions are welcome! Feel free to open an issue or submit a pull request.

---
💡 *Happy Reviewing!* 🚀