package org.example.advanced_authorization_service.repository;


import org.springframework.stereotype.Repository;
import org.example.advanced_authorization_service.model.Authorities;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    public List<Authorities> getUserAuthorities(String user, String password) {
        //проверка на админа
        if ("admin".equals(user) && "admin".equals(password)) {
            //создается список допусков для админа
            List<Authorities> authorities = new ArrayList<>();//создается пустой список
            authorities.add(Authorities.READ);//добавление в список
            authorities.add(Authorities.WRITE);//добавление в список
            authorities.add(Authorities.DELETE);//добавление в список
            //если условие выполнено возвращается список полномочий для этого пользователя
            return authorities;
        }
        //проверка пользователя
        if ("Smith".equals(user) && "Smith".equals(password)) {
            //создается список допусков для пользователя
            List<Authorities> authorities = new ArrayList<>();//создается пустой список
            authorities.add(Authorities.READ);//добавление в список
            authorities.add(Authorities.WRITE);//добавление в список
            //если условие выполнено возвращается список полномочий для этого пользователя
            return authorities;
        }
        // Возвращение пустого списка, если пользователь не найден или данные неверные
        return new ArrayList<>();
    }
}
