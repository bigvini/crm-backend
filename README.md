# Crm Backend
crm-backend/
├── user-service/              # Сервіс авторизації і користувачів
├── student-service/           # Сервіс учнів
├── teacher-service/           # Сервіс викладачів
├── lesson-service/            # Сервіс занять
├── payment-service/           # Сервіс оплат
├── gateway-service/           # API Gateway (Spring Cloud Gateway)
├── discovery-service/         # Eureka Server (для сервіс-реєстрації)
├── notification-service/      # Сервіс повідомлень
├── docker/                    # docker-compose.yaml, конфіги БД
├── docs/                      # Технічна документація
└── README.md                  # Загальний опис проєкту

# 📚 CRM для онлайн-школи — Документація

## 🔧 Проєкт: CRM-система для онлайн-школи англійської мови

### 🎯 Мета
Автоматизація управління учнями, вчителями, уроками, оплатами, балансом занять, сповіщеннями та статистикою успішності в форматі мікросервісної архітектури.

---

## 📦 Сервіси

### 1. **User Service**
- 🔹 Відповідає за управління системними користувачами:
  - адміністратори
  - батьки
  - учні
  - вчителі
- 🔹 Поточний стан: **проєкт створено, реалізація ще не почалась**
- 🔹 У планах:
  - Створення Entity `UserEntity` з полями: `id`, `fullName`, `email`, `role`, `password`, `isActive`
  - Реєстрація/логін користувачів
  - Валідація та DTO
  - Swagger документація
  - Інтеграція з NotificationService (email підтвердження)
  - Підтримка ролей (ROLE_ADMIN, ROLE_PARENT, ROLE_TEACHER, ROLE_STUDENT)

### 2. **Student Service**
- 🔹 Відповідає за студентів, їхній баланс, історію цін
- 🔹 Реалізовано:
  - `StudentEntity`, `StudentPricingEntity`, `BalanceEntity`
  - Стартове API для створення студента
- 🔹 У планах:
  - Перегляд балансу
  - Історія змін ціни
  - Зв'язок з PaymentService і LessonService

### 3. **Teacher Service**
- 🔹 Відповідає за вчителів
- 🔹 У розробці:
  - Створено `TeacherController`, DTO, мапінг, Swagger
  - Планується інтеграція з LessonService

### 4. **Lesson Service**
- 🔹 Відповідає за розклад уроків, списання балансу
- 🔹 У планах:
  - Entity `LessonEntity`, контролер, сервіс, DTO
  - Фільтрація по учню/вчителю/даті
  - Списання одного заняття з балансу
  - Інтеграція з StudentService та TeacherService

### 5. **Payment Service**
- 🔹 Відповідає за оплату уроків і поповнення балансу
- 🔹 У планах:
  - Додавання платежу
  - Автоматичне оновлення балансу через FeignClient до StudentService

### 6. **Notification Service**
- 🔹 Email/SMS-сповіщення про:
  - Уроки
  - Баланс
  - Пробні заняття
- 🔹 У планах:
  - Реалізація email через SendGrid
  - SMS через Twilio
  - Виклик з інших сервісів через FeignClient

### 7. **Teacher Payout Service**
- 🔹 Розрахунок зарплати вчителям на основі проведених уроків
- 🔹 У розробці:
  - Планується зв'язок з LessonService
  - Обрахунок суми за кожного викладача

---

## 🗃️ Бази даних (ER-діаграми)

🟦 _будуть додані схеми для:_
- user-service: UserEntity (з ролями)
- student-service: Student, Pricing, Balance
- teacher-service: TeacherEntity
- lesson-service: LessonEntity

---

## 🔄 Інтеграції
- FeignClient (LessonService → TeacherService)
- FeignClient (LessonService → StudentService для списання балансу)
- FeignClient (PaymentService → StudentService для оновлення балансу)
- FeignClient (UserService → NotificationService для підтвердження email)

---

## 📅 Що зроблено / Що далі

### ✅ Зроблено:
- [x] Створено базовий проєкт UserService
- [x] Створено StudentService: сутності + DTO
- [x] TeacherService: структура, DTO, Swagger

### 🛠️ В процесі:
- [ ] TeacherService: API, інтеграція з уроками
- [ ] LessonService: створення уроку, логіка списання

### 📌 Наступні кроки:
- [ ] Завершити TeacherService
- [ ] Реалізувати LessonService з інтеграціями
- [ ] Реалізувати NotificationService через email (SendGrid)
- [ ] Реалізувати PaymentService (оплати + баланс)
- [ ] Додати ER-діаграми (draw.io або dbdiagram.io)

---

## 🧭 Автор
Костянтин — власник школи Time English, архітектор CRM-проєкту

---

> 🔄 Документ оновлюється у процесі розробки


