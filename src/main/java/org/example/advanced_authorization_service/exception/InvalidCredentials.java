package org.example.advanced_authorization_service.exception;


//класс является наследником RuntimeException используется
// для того чтобы показать пользователю что имя или пароль
// введены не правильно
public class InvalidCredentials extends RuntimeException {
    public InvalidCredentials(String msg) {
        super(msg);
    }
}
