package com.crm.userservice.dto;

import com.crm.userservice.model.Role;
import com.crm.userservice.validation.EmailOrPhoneRequired;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@EmailOrPhoneRequired
public class UserRequestDto {

    @NotBlank(message = "Ім’я не може бути порожнім")
    private String fullName;

    // Або email, або phone має бути заповнений (валідація на рівні контролера або кастомна)
    @Pattern(
            regexp = "^(|[\\w.%+-]+@[\\w.-]+\\.[A-Za-z]{2,6})$",
            message = "Email має бути у правильному форматі або порожній"
    )
    private String email;

    @Pattern(
            regexp = "^(|\\+?\\d{10,15})$",
            message = "Телефон має містити лише цифри, починатись з '+' (опціонально) і бути від 10 до 15 цифр"
    )
    private String phone;

    @NotBlank(message = "Пароль не може бути порожнім")
    @Size(min = 6, message = "Пароль має містити щонайменше 6 символів")
    private String password;

    private Role role;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
