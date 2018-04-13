package common.annotation;

   
import java.lang.annotation.ElementType;  
import java.lang.annotation.Retention;  
import java.lang.annotation.RetentionPolicy;  
import java.lang.annotation.Target;  
  
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD,ElementType.PARAMETER,
	ElementType.PACKAGE,ElementType.CONSTRUCTOR,ElementType.LOCAL_VARIABLE})    
@Retention(RetentionPolicy.RUNTIME)    
public @interface Comment {    
    String value() default "";    
}    