package frank.java.chapter13.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation 憯唳����
 * 
 * @author <a href="mailto:gzyangfan@gmail.com">Frank</a>
 */
// 憯唳�釣�������
@Retention(RetentionPolicy.RUNTIME)
// 憯唳�釣��������
@Target(
{ ElementType.TYPE, ElementType.METHOD })
public @interface DemoOne
{

}
