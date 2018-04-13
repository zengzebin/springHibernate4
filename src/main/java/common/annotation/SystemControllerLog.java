package common.annotation;

import java.lang.annotation.*; 

@Target({ElementType.PARAMETER, ElementType.METHOD})    
@Retention(RetentionPolicy.RUNTIME)    
@Documented    
public @interface SystemControllerLog {

    String description()  default "没有异常";    
	 
 
}
