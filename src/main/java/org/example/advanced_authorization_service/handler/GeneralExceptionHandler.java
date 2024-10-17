package org.example.advanced_authorization_service.handler;

import org.example.advanced_authorization_service.exception.InvalidCredentials;
import org.example.advanced_authorization_service.exception.UnauthorizedUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//использование этой аннотации обеспечивает централизованную обработку ошибок контроллера
@ControllerAdvice
public class GeneralExceptionHandler {

    //эта аннотация указывает, что следующий метод будет вызываться, когда возникает исключение
    // типа InvalidCredentials
    @ExceptionHandler(InvalidCredentials.class)
    //метод принимает объект класса InvalidCredentials
    public ResponseEntity<String> handleInvalidCredentials(InvalidCredentials ex) {
        //возвращает объект содержащий HTTP-ответ со статусом 400 и текстом BAD_REQUEST
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }

    //эта аннотация указывает, что следующий метод будет вызываться, когда возникает исключение
    // типа UnauthorizedUser
    @ExceptionHandler(UnauthorizedUser.class)
    //метод принимает объект класса InvalidCredentials
    public ResponseEntity<String> handleUnauthorizedUser(UnauthorizedUser ex) {
        System.out.println(ex.getMessage());  // Логирование сообщения в консоль
        //возвращает объект содержащий HTTP-ответ со статусом 401 и текстом UNAUTHORIZED
        // указывающий на отсутствие прав на выполнение запроса
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(ex.getMessage());
    }
}

