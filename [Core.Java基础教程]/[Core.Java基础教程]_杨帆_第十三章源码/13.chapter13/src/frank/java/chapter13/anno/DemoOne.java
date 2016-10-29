package frank.java.chapter13.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation 声明范例
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
// 声明注释的持久性
@Retention(RetentionPolicy.RUNTIME)
// 声明注释的作用目标
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface DemoOne {

}
