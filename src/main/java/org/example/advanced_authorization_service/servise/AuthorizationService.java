package org.example.advanced_authorization_service.servise;

import org.example.advanced_authorization_service.exception.InvalidCredentials;
import org.example.advanced_authorization_service.exception.UnauthorizedUser;
import org.example.advanced_authorization_service.model.Authorities;
import org.example.advanced_authorization_service.model.User;
import org.example.advanced_authorization_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//помечается аннотацией чтобы Spring понимал что это сервисный компонент
@Service
public class AuthorizationService {

    //добавляется аннотация для взаимодействия userRepository
    @Autowired
    private UserRepository userRepository;

    //метод принимает экземпляр класса User и возвращает список допусков, может вызвать исключение
    public List<Authorities> getAuthorities(User user) {
        //получаем имя пользователя из объекта User сохраняем в переменную
        String username = user.getUser();
        //получаем пароль из объекта User сохраняем в переменную
        String password = user.getPassword();

        //если имя пользователя или пароль пустые
        if (isEmpty(username) || isEmpty(password)) {
            //вызывается пользовательское исключение с соответствующим сообщением
            throw new InvalidCredentials("User name or password is empty");
        }

        //если имя и пароль правильные то в список сохраняется имя ,пароль и допуски
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(username, password);
        //проверяется что список не пуст
        if (isEmpty(userAuthorities)) {
            //если условие не выполнено , то пользователь не найден ,
            // вызывается исключение с соответствующим сообщением
            throw new UnauthorizedUser("Unknown user " + username);
        }
        //если проверки успешны возвращается список полномочий пользователя
        return userAuthorities;
    }

    //проверяется валидация входных параметров
    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    //проверяется является ли переданный список пустым или нет
    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
