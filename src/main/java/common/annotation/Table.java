package common.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解 拦截表明
 */

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented

public @interface Table {
	String name() default "";
	String  catalog() default "没"; 
}
