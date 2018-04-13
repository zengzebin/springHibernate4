package common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import common.annotation.SystemControllerLog;
import common.annotation.SystemServiceLog;
import common.json.FastJsonUtils;
import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;
import javassist.NotFoundException;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;
 

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
/**  
 * 切点类  
 * @author tiangai  
 * @since 2014-08-05 Pm 20:35  
 * @version 1.0  
 */

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*首先我们为什么需要做日志管理，在现实的上线中我们经常会遇到系统出现异常或者问题。这个时候就马上打开CRT或者SSH连上服务器拿日子来分析。受网络的各种限制。于是我们就想为什么不能直接在管理后台查看报错的信息呢。于是日志管理就出现了。

其次个人觉得做日志管理最好的是Aop，有的人也喜欢用拦截器。都可以，在此我重点介绍我的实现方式。

Aop有的人说拦截不到Controller。有的人说想拦AnnotationMethodHandlerAdapter截到Controller必须得拦截org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter。

首先Aop可以拦截到Controller的，这个是毋容置疑的其次须拦截AnnotationMethodHandlerAdapter也不是必须的。最起码我没有验证成功过这个。我的spring版本是4.0.3。

Aop之所以有的人说拦截不到Controller是因为Controller被jdk代理了。我们只要把它交给cglib代理就可以了。*/
@Aspect
@Component 
public class SystemLogAspect {
	private static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(SystemLogAspect.class);

	/*
	 * //注入Service用于把日志保存数据库
	 * 
	 * @Resource private LogService logService;
	 */
	
	
	private static String[] types = { "java.lang.Integer", "java.lang.Double", "java.lang.Float", "java.lang.Long",
			"java.lang.Short", "java.lang.Byte", "java.lang.Boolean", "java.lang.Char", "java.lang.String", "int",
			"double", "long", "short", "byte", "boolean", "char", "float" };

	// Controller层切点
	@Pointcut("@annotation(common.annotation.SystemControllerLog)")
	public void controllerAspect() {

	}

	// Service层切点
	@Pointcut("@annotation(common.annotation.SystemServiceLog)")
	public void serviceAspect() {
	}

	/**
	 * 前置通知 用于拦截Controller层记录用户的操作
	 * 
	 * @param joinPoint
	 *            切点
	 */
	@Before("controllerAspect()")
	public void doBefore(JoinPoint joinPoint) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
				// HttpServletRequest request = ((ServletRequestAttributes)
				// RequestContextHolder.getRequestAttributes()).getRequest();

		/*
		 * HttpSession session = request.getSession(); //读取session中的用户 User user
		 * = (User) session.getAttribute(WebConstants.CURRENT_USER);
		 */
		// String ip = request.getRemoteAddr();
		System.out.println("=====前置通知开始=====");
		
		
		System.out.println("请求方法:"
				+ (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
		try {
			String params = "";
			System.out.println("方法描述:" + getControllerMethodDescription(joinPoint));

			Enumeration<String> keys = request.getParameterNames();
			String classType = joinPoint.getTarget().getClass().getName();
			Class<?> clazz = Class.forName(classType);
			String clazzName = clazz.getName();
			String clazzSimpleName = clazz.getSimpleName();
			String methodName = joinPoint.getSignature().getName();
			
			List<String> paramNames = getFieldsName(this.getClass(), clazzName, methodName);
			// String logContent = beanParam(paramNames, joinPoint);
			
			while (keys.hasMoreElements()) {
				String k = keys.nextElement();
				System.out.println("***************name=" + k + " value= " + request.getParameter(k));

			}
			/*for (int i = 0; i < joinPoint.getArgs().length; i++) {
				Object object = joinPoint.getArgs()[i];
				if (object.getClass().equals(HttpServletRequest.class)) {
					System.out.println(object);
				} else if (object.getClass().equals(HttpServletResponse.class)) {
					System.out.println(object);
				} else {
					String json = FastJsonUtils.toJSONString(object);
					System.out.println(json);
				}

			}*/

			System.out.println("=====前置通知结束=====");

			// logService.save(bean)
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 异常通知 用于拦截service层记录异常日志
	 * 
	 * @param joinPoint
	 * @param e
	 */
	@AfterThrowing(pointcut = "serviceAspect()", throwing = "e")
	public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		/*
		 * HttpSession session = request.getSession(); //读取session中的用户 User user
		 * = (User) session.getAttribute(WebConstants.CURRENT_USER);
		 */
		// 获取请求ip
		String ip = request.getRemoteAddr();
		// 获取用户请求方法的参数并序列化为JSON格式字符串
		String params = "";
		if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
			for (int i = 0; i < joinPoint.getArgs().length; i++) {
				params += FastJsonUtils.toJSONString(joinPoint.getArgs()[i]) + ";";
			}
		}
		try {
			/* ========控制台输出========= */
			System.out.println("=====异常通知开始=====");
			System.out.println("异常代码:" + e.getClass().getName());
			System.out.println("异常信息:" + e.getMessage());
			System.out.println("异常方法:"
					+ (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
			System.out.println("方法描述:" + getServiceMthodDescription(joinPoint));

			System.out.println("请求IP:" + ip);
			System.out.println("请求参数:" + params);
			/* ==========数据库日志========= */

			System.out.println("=====异常通知结束=====");
		} catch (Exception ex) {
			// 记录本地异常日志
			log.error("==异常通知异常==");
			log.error("异常信息:{}", ex.getMessage());
		}
		/* ==========记录本地异常日志========== */
		log.error("异常方法:{}异常代码:{}异常信息:{}参数:{}",
				joinPoint.getTarget().getClass().getName() + joinPoint.getSignature().getName(), e.getClass().getName(),
				e.getMessage(), params);

	}

	/**
	 * 获取注解中对方法的描述信息 用于Controller层注解
	 * 
	 * @param joinPoint
	 *            切点
	 * @return 方法描述
	 * @throws Exception
	 */

	public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		String description = "";
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					description = method.getAnnotation(SystemControllerLog.class).description();
					log.info(description);
					break;
				}
			}
		}
		return description;
	}

	/**
	 * 获取注解中对方法的描述信息 用于service层注解
	 * 
	 * @param joinPoint
	 *            切点
	 * @return 方法描述
	 * @throws Exception
	 */
	public static String getServiceMthodDescription(JoinPoint joinPoint) throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		String description = "";
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					description = method.getAnnotation(SystemServiceLog.class).description();
					break;
				}
			}
		}
		return description;
	}
	
	
	
	
	private static List<String>  getFieldsName(Class cls, String clazzName, String methodName) throws NotFoundException {
		ClassPool pool = ClassPool.getDefault();
		// ClassClassPath classPath = new ClassClassPath(this.getClass());
		ClassClassPath classPath = new ClassClassPath(cls);
		pool.insertClassPath(classPath);

		CtClass cc = pool.get(clazzName);
		CtMethod cm = cc.getDeclaredMethod(methodName);
		MethodInfo methodInfo = cm.getMethodInfo();
		CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
		LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
		if (attr == null) {
			// exception
		}
		List <String>  paramNames=new ArrayList<String>();
		
	 
		int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
		for (int i = 0; i <cm.getParameterTypes().length; i++) {
			 paramNames.add(attr.variableName(i + pos)); // paramNames即参数名
		}
		return paramNames;
	}
	
	
	/*
	private static String[] getFieldsName(Class cls, String clazzName, String methodName) throws NotFoundException {
		ClassPool pool = ClassPool.getDefault();
		// ClassClassPath classPath = new ClassClassPath(this.getClass());
		ClassClassPath classPath = new ClassClassPath(cls);
		pool.insertClassPath(classPath);

		CtClass cc = pool.get(clazzName);
		CtMethod cm = cc.getDeclaredMethod(methodName);
		MethodInfo methodInfo = cm.getMethodInfo();
		CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
		LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
		if (attr == null) {
			// exception
		}
		String[] paramNames = new String[cm.getParameterTypes().length];
		
	 
		int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
		for (int i = 0; i < paramNames.length; i++) {
			 paramNames[i] = attr.variableName(i + pos); // paramNames即参数名
		}
		return paramNames;
	}
	
	
	
	  private static String beanParam(String[] paramNames, JoinPoint joinPoint){
		       Object[] args = joinPoint.getArgs();
				StringBuilder sb = new StringBuilder();
				boolean clazzFlag = true;
				for (int k = 0; k < args.length; k++) {
					Object arg = args[k];
					if(arg==null)
						continue;
					 sb.append(getFieldsValue(arg));
				 }
				return sb.toString();
	  }
	
	private static String writeLogInfo(String[] paramNames, JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		StringBuilder sb = new StringBuilder();
		boolean clazzFlag = true;
		for (int k = 0; k < args.length; k++) {
			Object arg = args[k];
			 
			sb.append(paramNames[k] + " ");
			// 获取对象类型
			String typeName = arg.getClass().getName();

			for (String t : types) {
				if (t.equals(typeName)) {
					sb.append("=" + arg + "; ");
				}
			}
			if (clazzFlag) {
				sb.append(getFieldsValue(arg));
			}
		}
		return sb.toString();
	}
	
	
	
	public static String getFieldsValue(Object obj) {
		Field[] fields = obj.getClass().getDeclaredFields();
		String typeName = obj.getClass().getName();
		for (String t : types) {
			if (t.equals(typeName))
				return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("【");
		for (Field f : fields) {
			f.setAccessible(true);
			try {
				for (String str : types) {
					if (f.getType().getName().equals(str)) {
						sb.append(f.getName() + " = " + f.get(obj) + "; ");
					}
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		sb.append("】");
		return sb.toString();
	}*/

}
