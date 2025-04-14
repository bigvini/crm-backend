
# 🧩 UserService API

Базовий URL: `http://<HOST>:8081/api/users`

## 🔐 Аутентифікація
Всі запити мають бути з авторизацією. Додайте заголовки:
```
Authorization: Bearer <JWT-TOKEN>
Content-Type: application/json
Accept: application/json
```

---

## 📌 POST /api/users
### ▶️ Створення нового користувача (тільки адмін/власник)
**Тіло запиту:**
```json
{
  "fullName": "Олексій Коваль",
  "email": "oleksiy@example.com",
  "phone": "+380931234567",
  "password": "securePass123",
  "role": "ROLE_ADMIN"
}
```

**Що має зробити фронтенд:**
- Показати форму з обов’язковими полями.
- Зробити валідацію (email, пароль, телефон, role).
- Після успішного створення — повідомлення або редірект.

**Відповідь:**
```json
{
  "id": 1,
  "fullName": "Олексій Коваль",
  "email": "oleksiy@example.com",
  "phone": "+380931234567",
  "role": "ROLE_ADMIN",
  "active": true
}
```

---

## 📌 GET /api/users
### ▶️ Отримати всіх користувачів

**Що має зробити фронтенд:**
- Таблиця зі списком користувачів.
- Фільтрація за роллю, активністю.
- Кнопки редагування, деактивації, видалення.

**Відповідь:**
```json
[
  {
    "id": 1,
    "fullName": "Олексій Коваль",
    "email": "oleksiy@example.com",
    "phone": "+380931234567",
    "role": "ROLE_ADMIN",
    "active": true
  }
]
```

---

## 📌 GET /api/users/{id}
### ▶️ Отримати користувача за ID

**Використання:**
- Детальна інформація в модальному вікні або на окремій сторінці.

**Відповідь:**
```json
{
  "id": 1,
  "fullName": "Олексій Коваль",
  "email": "oleksiy@example.com",
  "phone": "+380931234567",
  "role": "ROLE_ADMIN",
  "active": true
}
```

---

## 📌 DELETE /api/users/{id}
### ▶️ Видалити користувача за ID

**Що має зробити фронтенд:**
- Підтвердження видалення.
- Після — оновити список.

**Відповідь:**
- `204 No Content`

---

## ℹ️ Додатково

- `role` може мати значення:
  - `ROLE_ADMIN`, `ROLE_PARENT`, `ROLE_STUDENT`, `ROLE_TEACHER`
- `active: true/false` — використовується для фільтра.
- Пароль хешується на сервері.

---
