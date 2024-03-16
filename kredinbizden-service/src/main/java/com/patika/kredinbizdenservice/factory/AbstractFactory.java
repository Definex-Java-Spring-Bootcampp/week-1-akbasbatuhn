package com.patika.kredinbizdenservice.factory;

public interface AbstractFactory<T> {
    T create(Object... args);
}
