# User Service — Документація розробки

## 📌 Що реалізовано (станом на 2025-04-10):
1. **Сервіс `UserService`**:
   - Створено `UserEntity` з полями: `id`, `fullName`, `email`, `phone`, `password`, `role`, `active`.
   - Реалізовано `UserRepository` (Spring Data JPA).
   - Налаштовано `UserRequestDto` та `UserResponseDto`.
   - Реалізовано `UserMapper` з використанням MapStruct (`componentModel = "spring"`).
   - Сервіс `UserServiceImpl` з методами:
     - `createUser`
     - `getAllUsers`
     - `getUserById`
     - `deleteUser`
   - Контролер `UserController` з ендпоінтами:
     - `POST /api/users` — створення користувача
     - `GET /api/users` — отримання всіх користувачів
     - `GET /api/users/<built-in function id>` — отримання користувача по ID
     - `DELETE /api/users/<built-in function id>` — видалення користувача по ID

2. **Swagger/OpenAPI**:
   - Додано анотації `@Operation`, `@Tag` до методів контролера.
   - Swagger доступний для перевірки REST API.

3. **База даних**:
   - Використовується PostgreSQL.
   - Таблиця `users` успішно створюється автоматично через Hibernate.
   - Spring JPA конфігуровано для взаємодії з БД.

4. **Інтеграція з безпекою**:
   - Додано базову конфігурацію Spring Security.
   - Працює автентифікація з `inMemoryUserDetailsManager` (тимчасово).

---

## 🔧 Що потрібно зробити далі:

### 1. 🛡 Безпека
- 🔒 Замість `inMemoryUserDetailsManager` реалізувати `CustomUserDetailsService`:
  - Зчитування користувачів із БД
  - Додавання `UserDetails`/`UserPrincipal`
  - Паролі хешувати через BCrypt (`BCryptPasswordEncoder`)
- 🔐 Додати реальну систему авторизації (JWT або session-based)

### 2. 🧪 Валідація та обробка помилок
- Додати глобальний `ExceptionHandler`
- Валідувати поля в DTO (наприклад, email, phone)

### 3. 🧩 Покращення DTO
- Приховати `password` з `UserResponseDto`
- Додати поле `createdAt` / `updatedAt` в `UserEntity` (аудит)

### 4. 📊 Ролі та доступ
- Створити логіку, яка дозволяє тільки адміністраторам видаляти або створювати користувачів

### 5. 🌐 Інтеграція
- Підготувати UserService до інтеграції з іншими мікросервісами (наприклад, через FeignClient або RestTemplate)

### 6. 🧾 Документація
- Додати README до репозиторію
- Додати приклади CURL / Postman для кожного запиту
- Додати специфікацію API (YAML/JSON) для фронтендера

---

## 🧑‍💻 Інше
- Оптимізувати логування
- Додати unit-тести та інтеграційні тести (`@WebMvcTest`, `@DataJpaTest`)

---

> ⚙️ Усі реалізовані частини перевірено через Swagger.