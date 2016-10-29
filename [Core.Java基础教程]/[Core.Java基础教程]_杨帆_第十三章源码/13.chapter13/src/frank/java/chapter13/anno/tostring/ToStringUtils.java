package frank.java.chapter13.anno.tostring;

import java.lang.reflect.Field;

public abstract class ToStringUtils {

	public static String AnnotationToString(Object obj) throws IllegalArgumentException, IllegalAccessException {
		Class<?> clz = obj.getClass();
		ClassName clzName = clz.getAnnotation(ClassName.class);
		if (clzName == null)
			return clz.getName() + "@" + obj.hashCode();
		
		StringBuilder builder = new StringBuilder();
		builder.append(clzName.value());
		builder.append("[");
		for (Field f : clz.getDeclaredFields()) {
			FieldName anno = f.getAnnotation(FieldName.class);
			if (anno != null) {
				builder.append(anno.value());
				builder.append(":");
				builder.append(f.get(obj));
				builder.append(" ");
			}
		}
		builder.append("]");
		return builder.toString();
	}

}
