package common.annotation;

import java.util.HashMap;
import java.util.Map;

 

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;;

@TestA // 使用了类注解
(gid = UserAnnotation.class, name = "使用了类注解")
public class UserAnnotation {
	@TestA // 使用了类成员注解
	(gid = UserAnnotation.class, name = "使用了类成员注解age属性")
	private Integer age;

	private Integer sex;
	 
	@TestA // 使用了构造方法注解
	(gid = UserAnnotation.class, name = "使用了构造方法注解")
	public UserAnnotation() {

	}

	@TestA // 使用了类方法注解
	(gid = UserAnnotation.class, name = "使用了类方法注解testMethods")
	public void testMethods() {
		@TestA // 使用了局部变量注解
		(gid = Map.class, name = "使用了局部变量注解")
		Map m = new HashMap(0);
	}

	public void b(@TestA(gid = UserAnnotation.class, name = "方法参数注解") Integer a) {
		// 使用了方法参数注解
	}

	public static void parseTypeAnnotation()   {
		Class clazz=null;
		try {
			clazz = Class.forName("myframe.UserAnnotation");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Annotation[] annotations = clazz.getAnnotations();
		for (Annotation annotation : annotations) {
			TestA testA = (TestA) annotation;
			System.out.println("id= " + testA.id() + "; name= " + testA.name() + "; gid = " + testA.gid());
		}
	}

	public static void parseMethodAnnotation() {
		Method[] methods = UserAnnotation.class.getDeclaredMethods();
		for (Method method : methods) {

			boolean hasAnnotation = method.isAnnotationPresent(TestA.class);
			if (hasAnnotation) {

				TestA annotation = method.getAnnotation(TestA.class);
				System.out.println("method = " + method.getName() + " ; id = " + annotation.id() + " ; description = "
						+ annotation.name() + "; gid= " + annotation.gid());
			}
		}
	}
	
	public static void parseConstructAnnotation(){
		Constructor[] constructors = UserAnnotation.class.getConstructors();  
		        for (Constructor constructor : constructors) { 
		         
		            boolean hasAnnotation = constructor.isAnnotationPresent(TestA.class);  
		            if (hasAnnotation) {  
		                 
		            TestA annotation =(TestA) constructor.getAnnotation(TestA.class);  
		                System.out.println("constructor = " + constructor.getName()  
		                        + " ; id = " + annotation.id() + " ; description = "  
		                        + annotation.name() + "; gid= "+annotation.gid());  
		            }  
		        }  
		}


	public static void main(String[] args) {
		/*Field[] fields = UserAnnotation.class.getDeclaredFields();

		for (Field f : fields) {
			// 判断f是否注解
			if (f.isAnnotationPresent(TestA.class)) {

				// 解析f注解
				TestA inject = f.getAnnotation(TestA.class);
				// 获取注解f属性
				String paramenterValue = StringUtils.trim(inject.name());
				System.out.println(paramenterValue);
			}

		}
		Method[] methods = UserAnnotation.class.getMethods();

		for (Method m : methods) {
			// 判断f是否注解
			if (m.isAnnotationPresent(TestA.class)) {
				// 解析f注解
				TestA inject = m.getAnnotation(TestA.class);
				// 获取注解f属性
				String paramenterValue = StringUtils.trim(inject.name());
				System.out.println(paramenterValue);
			}

		}*/
		parseTypeAnnotation();
		parseMethodAnnotation();
		parseConstructAnnotation();

	}
}
