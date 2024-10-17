package org.example.advanced_authorization_service.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class User {


    //аннотация @NotEmpty указывает что данный элемент не может быть пустым в случае если пустой
    //отправится сообщение в скобках
    @NotEmpty(message ="Имя пользователя обязательно")
    //аннотация обеспечивает валидацию строки, если строка меньше 3 символов и больше 20 то валидация не пройдет
    @Size(min = 3, max = 20, message = "Имя пользователя должно содержать от 3 до 50 символов")
    private String user;

    //аннотация @NotEmpty указывает что данный элемент не может быть пустым в случае если пустой
    // пользователю сообщение в скобках
    @NotEmpty(message = "Пароль обязателен")
    //аннотация обеспечивает валидацию строки, если строка меньше 6 символов  то валидация не пройдет
    @Size(min = 5, message = "Пароль должен содержать хотя бы 5 символов")
    private String password;

    // геттеры и сеттеры
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
