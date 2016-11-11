package annotation;

import static java.lang.System.out;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class DebugTool {
    public static void main(String[] args) throws NoSuchMethodException {
        Class<Other> c = Other.class;
        Method method = c.getMethod("doOther");
        if(method.isAnnotationPresent(Debug.class)) {
            out.println("??�脰身摰�? @Debug ??��?��??");
            showDebugAnnotation(method);
        } else {
            out.println("??��?��?��身摰�? @Debug ??��?��??");
        }
        showAllAnnotations(method);
    }

    private static void showDebugAnnotation(Method method) {
        // ����? @Debug ??�虫��
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