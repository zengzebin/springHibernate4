package common.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解 拦截表明
 */

@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented

public @interface Id {
	 
}
