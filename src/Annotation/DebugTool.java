package annotation;

import static java.lang.System.out;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class DebugTool {
    public static void main(String[] args) throws NoSuchMethodException {
        Class<Other> c = Other.class;
        Method method = c.getMethod("doOther");
        if(method.isAnnotationPresent(Debug.class)) {
            out.println("??Œè„°èº«æ‘°ï¿? @Debug ??…î?–é??");
            showDebugAnnotation(method);
        } else {
            out.println("??î?‰ï¿½?¦èº«æ‘°ï¿? @Debug ??…î?–é??");
        }
        showAllAnnotations(method);
    }

    private static void showDebugAnnotation(Method method) {
        // ï¿½ï¿½î¡¼ï¿½ï¿? @Debug ??–è™«ï¿½ï¿½
        Debug debug = method.getAnnotation(Debug.class);
        out.printf("value: %s%n", debug.value());
        out.printf("name : %s%n", debug.name());
    }
    
    private static void showAllAnnotations(Method method) {
        Annotation[] annotations = method.getAnnotations();
        for(Annotation annotation : annotations) {
            out.println(annotation.annotationType().getName());
        }
    }
} 