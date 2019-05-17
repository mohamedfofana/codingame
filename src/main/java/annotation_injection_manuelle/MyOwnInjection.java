package main.java.annotation_injection_manuelle;

import java.lang.reflect.Field;

public class MyOwnInjection {
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> clazz = Class.forName("com.annotation.Presenter");
		Object leftSide = clazz.newInstance();
		Field[] fields = clazz.getFields();
		for (Field field : fields) {
			PleaseInject annotation = field.getAnnotation(PleaseInject.class);
			if (annotation != null) {
				Class<?> type = field.getType();
				Object rightSide = type.newInstance();
				field.set(leftSide, rightSide);
			}
		}
		System.out.println(leftSide);
	}
}
