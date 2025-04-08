🔧 Структура проєкту:
com.crm.userservice
├── config/         <-- конфігурації (swagger, CORS, bean-и)
├── controller/     <-- REST-контролери
├── dto/            <-- DTO класи: UserRequest, UserResponse
├── entity/         <-- JPA-сутності: UserEntity
├── exception/      <-- обробка винятків: GlobalExceptionHandler
├── mapper/         <-- MapStruct або ручні мапери
├── model/          <-- enum'и: Role, Status
├── repository/     <-- JpaRepository інтерфейси
├── security/       <-- Spring Security конфігурація (на майбутнє)
└── service/        <-- інтерфейси та реалізації UserService
------------------------------------------------------------
