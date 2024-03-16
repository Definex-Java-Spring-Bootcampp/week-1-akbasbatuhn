package com.patika.kredinbizdenservice.factory;

import com.patika.kredinbizdenservice.model.User;

public class UserFactory implements AbstractFactory<User> {
    private static volatile UserFactory instance;

    private UserFactory() {

    }

    public static synchronized UserFactory getInstance() {
        if (instance == null) {
            synchronized (UserFactory.class) {
                if (instance == null) {
                    instance = new UserFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public User create(Object... args) {
        return new User(
                (String) args[0], (String) args[1], (String) args[2],
                (String) args[3], (String) args[4], true);
    }
}
