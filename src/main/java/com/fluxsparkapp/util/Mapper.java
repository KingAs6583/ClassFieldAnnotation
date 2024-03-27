package com.fluxsparkapp.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import com.fluxsparkapp.annotation.MapToClass;

public class Mapper {

    public static <T, S> T map(S source) throws IllegalAccessException, InstantiationException,  InvocationTargetException, NoSuchMethodException {
        Class<T> targetClass = (Class<T>) source.getClass().getAnnotation(MapToClass.class).targetClass();
        T targetObject = targetClass.getDeclaredConstructor().newInstance();
        for (Field field : source.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            String targetFieldName = field.getName(); // Use field name for target field
            try {
                Field targetField = targetClass.getDeclaredField(targetFieldName);
                targetField.setAccessible(true);
                if (field.getType().equals(targetField.getType())) { // Check for compatible types
                    targetField.set(targetObject, field.get(source));
                }
            } catch (NoSuchFieldException e) {
            	System.err.println("Inavlid Fields");
            }
        }
        return targetObject;
    }
    
    public static <T> T copy(T source) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Class<T> targetClass = (Class<T>) source.getClass();
        T targetObject = targetClass.getDeclaredConstructor().newInstance();
        for (Field field : source.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            String targetFieldName = field.getName();
            try {
                Field targetField = targetClass.getDeclaredField(targetFieldName);
                targetField.setAccessible(true);
                if (field.getType().equals(targetField.getType())) { // Check for compatible types
                    targetField.set(targetObject, field.get(source));
                }
            } catch (NoSuchFieldException e) {
            	System.err.println("Inavlid Fields");
            }
        }
        return targetObject;
    }
}