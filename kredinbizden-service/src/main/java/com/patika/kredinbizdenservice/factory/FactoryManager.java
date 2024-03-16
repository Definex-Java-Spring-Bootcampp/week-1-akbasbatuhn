package com.patika.kredinbizdenservice.factory;

import java.util.HashMap;
import java.util.Map;

public class FactoryManager {
    private Map<Class<?>, AbstractFactory<?>> factories = new HashMap<>();

    public void registerFactory(Class<?> key, AbstractFactory<?> factory) {
        factories.put(key, factory);
    }

    public Object createObject(Class<?> key, Object... args) {
        AbstractFactory<?> factory = factories.get(key);
        if(factory == null)
            throw new IllegalArgumentException("Factory not found registered for class " + key.getName());

        return factory.create(args);
    }
}
