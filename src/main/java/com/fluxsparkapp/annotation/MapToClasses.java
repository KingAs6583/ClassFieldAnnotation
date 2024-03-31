package com.fluxsparkapp.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * It is an annotation which use to map multiple 
 * class having same fields with different class name
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MapToClasses {
	Class<?>[] targetClasses();
}