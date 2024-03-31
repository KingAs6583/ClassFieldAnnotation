package com.fluxsparkapp.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fluxsparkapp.annotation.MapToClass;
import com.fluxsparkapp.annotation.MapToClasses;

/**
 * This the class which has bind to Map Annotations It use class reflection to
 * do it's operation
 */
public final class ClassMapper {

	/**
	 * It use to map or copy the same field of particular class. 
	 * Note: It doesn't Handle the super class fields and different fields from another class
	 * @param <T>
	 * @param <S>
	 * @param source class object
	 * @return The Target class object with copied values <T>
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * 
	 */
	public static <T, S> T mapFrom(S source)
			throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
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
				System.err.println("Invalid Field " + targetFieldName);
			}
		}
		return targetObject;
	}

	/**
	 * It use to copy the fields of same class object to another object
	 * @param <T>
	 * @param source self Object 
	 * @return self copied Object
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public static <T> T copyFrom(T source) throws IllegalAccessException, InstantiationException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
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
				System.err.println("Invalid Field " + targetFieldName);
			}
		}
		return targetObject;
	}

	/**
	 * It is use to copy the same fields of one class to another class
	 * Note: It doesn't Handle the super class fields and different fields from another class
	 * @param <S>
	 * @param <T>
	 * @param source object to copy
	 * @param target return type of className.class
	 * @return To target object
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static <S, T> T copyFields(S source, Class<T> target)
			throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
		Class<S> sourceClass = (Class<S>) source.getClass();
		Class<T> targetClass = target;
		T targetObject = targetClass.getDeclaredConstructor().newInstance();
		for (Field field : sourceClass.getDeclaredFields()) {
			field.setAccessible(true);
			String targetFieldName = field.getName(); // Use field name for target field
			try {
				Field targetField = targetClass.getDeclaredField(targetFieldName);
				targetField.setAccessible(true);
				if (field.getType().equals(targetField.getType())) { // Check for compatible types
					targetField.set(targetObject, field.get(source));
				}
			} catch (NoSuchFieldException e) {
				System.err.println("Invalid Field " + targetFieldName);
			}
		}
		return targetObject;
	}

	/**
	 * It use to map or copy the same field of particular classes from the MapToClasses annotation. 
	 * Note: It doesn't Handle the super class fields and different fields from another class 
	 * @param <T>
	 * @param <S>
	 * @param source class Object
	 * @param target ClassName.class
	 * @return Target class object
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static <T, S> T mapClassesFrom(S source, Class<T> target)
			throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
		Class<T> targetClass[] = (Class<T>[]) source.getClass().getAnnotation(MapToClasses.class).targetClasses();
		T targetObject = null;
		for (Integer i = 0; i < targetClass.length; i++) {
			System.out.println(targetClass[i] + " " + target);
			if (targetClass[i].equals(target)) {
				targetObject = targetClass[i].getDeclaredConstructor().newInstance();
				for (Field field : source.getClass().getDeclaredFields()) {
					field.setAccessible(true);
					String targetFieldName = field.getName(); // Use field name for target field
					try {
						Field targetField = targetClass[i].getDeclaredField(targetFieldName);
						targetField.setAccessible(true);
						if (field.getType().equals(targetField.getType())) { // Check for compatible types
							targetField.set(targetObject, field.get(source));
						}
					} catch (NoSuchFieldException e) {
						System.err.println("Invalid Field " + targetFieldName);
					}
				}
				break;
			}
		}
		if (targetObject == null)
			throw new ClassCastException("Can't cast to " + source.getClass().getName() + " " + target.getName()
					+ " castable are " + Arrays.toString(targetClass));
		return targetObject;
	}

	/**
	 * It is indevelopement phase 
	 * @param <T>
	 * @param <S>
	 * @param source
	 * @return List<T>
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static <T,S> List<T> getListMapFrom(List<S> source) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException{
		List<T> target =  new ArrayList<T>();
		for(int i =0; i < source.size(); i++){
			target.add(ClassMapper.mapFrom(source.get(i)));
		}
		return target;
	}

}