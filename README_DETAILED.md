# KMP Chat Bot - Kotlin Multiplatform Project

Dự án Chat Bot được xây dựng bằng Kotlin Multiplatform (KMP) theo kiến trúc Clean Architecture + MVVM.

## 🏗️ Kiến trúc

### Clean Architecture + MVVM
Dự án được tổ chức theo 3 layer chính:

#### 📁 Domain Layer (`domain/`)
- **Entities**: `User`, `Result`, `ChatMessage` - Các model chính của ứng dụng
- **Repository Interfaces**: `AuthRepository` - Định nghĩa contract cho data layer
- **Use Cases**: `LoginUseCase`, `CheckLoginStatusUseCase` - Chứa business logic

#### 📁 Data Layer (`data/`)
- **Repository Implementation**: `AuthRepositoryImpl` - Thực hiện repository interfaces
- **API Services**: `ApiClient`, `AuthService` - Xử lý gọi API
- **Cache**: `UserSessionCache` - Quản lý session người dùng
- **DTOs**: `UserDto` - Data Transfer Objects
- **Mappers**: `UserMapper` - Chuyển đổi giữa DTO và Entities

#### 📁 Presentation Layer (`presentation/`)
- **ViewModels**: `SplashViewModel`, `LoginViewModel`, `HomeViewModel` - Quản lý UI state
- **Views**: `SplashScreen`, `LoginScreen`, `HomeScreen` - Các màn hình UI

### 🔧 Các thành phần khác
- **Navigation** (`navigation/`): Quản lý điều hướng giữa các màn hình
- **Dependency Injection** (`di/`): Cấu hình DI với Koin

## 📱 Màn hình

### 1. Splash Screen
- Màn hình khởi động với logo ứng dụng
- Kiểm tra trạng thái đăng nhập
- Tự động chuyển đến Login hoặc Home

### 2. Login Screen  
- Form đăng nhập với username/password
- Validation đầu vào
- Hiển thị loading state và error messages
- Chuyển đến Home khi đăng nhập thành công

### 3. Home Screen
- Giao diện chat với bot
- Hiển thị tin nhắn dạng bubble
- Input field để nhập tin nhắn
- Auto-scroll đến tin nhắn mới nhất

## 🛠️ Công nghệ sử dụng

- **Kotlin Multiplatform**: Framework chính
- **Compose Multiplatform**: UI framework
- **Koin**: Dependency Injection
- **PreCompose**: Navigation cho KMP
- **Kotlinx Coroutines**: Xử lý bất đồng bộ
- **Ktor Client**: HTTP client
- **Kotlinx Serialization**: JSON serialization

## 🚀 Cách chạy dự án

### Prerequisites
- Android Studio hoặc IntelliJ IDEA
- JDK 11 hoặc cao hơn
- Android SDK

### Build và chạy
```bash
# Build dự án
./gradlew build

# Chạy trên Android
./gradlew :composeApp:assembleDebug
./gradlew :composeApp:installDebug

# Chạy trên iOS (cần macOS và Xcode)
./gradlew :composeApp:iosSimulatorArm64Test
```

## 📂 Cấu trúc thư mục

```
composeApp/src/commonMain/kotlin/org/chatbot/project/
├── data/
│   ├── api/           # API services
│   ├── cache/         # Caching layer
│   ├── dto/           # Data Transfer Objects
│   ├── mapper/        # Data mappers
│   └── repository/    # Repository implementations
├── domain/
│   ├── entity/        # Domain entities
│   ├── repository/    # Repository interfaces  
│   └── usecase/       # Business logic use cases
├── presentation/
│   ├── view/          # UI screens
│   │   ├── splash/
│   │   ├── login/
│   │   └── home/
│   └── viewmodel/     # ViewModels
│       ├── splash/
│       ├── login/
│       └── home/
├── di/                # Dependency Injection
└── navigation/        # Navigation setup
```

## 🔄 Flow ứng dụng

1. **Splash Screen**: Kiểm tra trạng thái đăng nhập
2. **Login Screen**: Đăng nhập nếu chưa có session
3. **Home Screen**: Chat với bot

## 🎯 Tính năng hiện tại

- ✅ Splash screen với animation
- ✅ Đăng nhập với validation
- ✅ Session management
- ✅ Chat interface cơ bản
- ✅ Auto bot response (mock)
- ✅ Clean Architecture implementation
- ✅ Dependency Injection với Koin

## 🚧 Tính năng tiếp theo

- [ ] Tích hợp với backend thật
- [ ] Lưu trữ tin nhắn local
- [ ] Push notifications
- [ ] Hỗ trợ đa ngôn ngữ
- [ ] Dark mode
- [ ] File sharing trong chat
- [ ] Voice messages

## 📞 Liên hệ

Dự án được phát triển với mục đích học tập và demo Clean Architecture trong KMP.
