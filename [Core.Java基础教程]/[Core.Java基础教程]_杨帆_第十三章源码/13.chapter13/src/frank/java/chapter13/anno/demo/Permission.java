package frank.java.chapter13.anno.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Permission
{

	// 0000
	// 0001 : Read
	// 0010 : Create
	// 0100 : Update
	// 1000 : Deltete
	int value();

}
