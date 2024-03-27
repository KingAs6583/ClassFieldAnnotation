package com.fluxsparkapp.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MapToClass {
    Class<?> targetClass(); // Class of the target object
}
