## 🔧 Структура проєкту

com.crm.userservice
├── config/         # ⚙️ Конфігурації (Swagger, CORS, Beans)
├── controller/     # 🎯 REST-контролери
├── dto/            # ✉️ DTO класи: UserRequest, UserResponse
├── entity/         # 🧱 JPA-сутності: UserEntity
├── exception/      # 🚨 Обробка винятків: GlobalExceptionHandler
├── mapper/         # 🔄 MapStruct або ручні мапери
├── model/          # 🧩 Enum'и: Role, Status
├── repository/     # 💾 JpaRepository інтерфейси
├── security/       # 🔐 Spring Security конфігурація (на майбутнє)
└── service/        # 🛠️ Інтерфейси та реалізації UserService


### 🗂 Опис основних пакетів:

- **`config/`** – містить конфігураційні класи, такі як:
  - Swagger-документація
  - Налаштування CORS
  - Bean-конфігурації, які використовуються у всьому застосунку

- **`controller/`** – REST-контролери, які відповідають за обробку HTTP-запитів, взаємодію з сервісами та повернення відповідей клієнту.

- **`dto/`** – Data Transfer Object'и:
  - `UserRequest` – структура вхідних даних від клієнта
  - `UserResponse` – структура відповіді, яку повертає сервер

- **`entity/`** – JPA-сутності, які відповідають таблицям у базі даних. Наприклад:
  - `UserEntity` – сутність користувача

- **`exception/`** – централізована обробка винятків:
  - `GlobalExceptionHandler` – обробляє помилки з усього застосунку через `@ControllerAdvice`

- **`mapper/`** – мапери, які перетворюють Entity ↔ DTO:
  - Може використовуватись MapStruct або ручна реалізація мапінгу

- **`model/`** – enum'и, які описують сталі значення, наприклад:
  - `Role` – ролі користувача (USER, ADMIN тощо)
  - `Status` – статус облікового запису

- **`repository/`** – інтерфейси, що наслідують `JpaRepository` для взаємодії з БД.

- **`security/`** – (опціональний модуль, який можна реалізувати пізніше) містить конфігурацію Spring Security:
  - Аутентифікація та авторизація
  - JWT-фільтри, якщо потрібно

- **`service/`** – бізнес-логіка застосунку:
  - Інтерфейси (`UserService`)
  - Їх реалізації (`UserServiceImpl`)

