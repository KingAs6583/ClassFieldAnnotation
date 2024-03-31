
package com.fluxsparkapp.annotation;

import java.lang.annotation.*;

/**
 * This is an annotation which copy the field of target class having same fields
 * as class which has this annotation
 * 
 * @Param: targetClass className.class
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MapToClass {
	Class<?> targetClass(); // Class of the target object
}
