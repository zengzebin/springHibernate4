package common.util;

 
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import ssxt.com.zeng.bean.SymUser;

 

public class CtxHelper {
	private static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CtxHelper.class);
	public static final String FILE_SEP=ConstParam.FILE_SEP;
	public static final String Line_SEP=ConstParam.Line_SEP;
	public static final String WEB_LINE_SEP="<br/>";
	public static final String WEB_NEW_LINE="\n";
	public static final String SYS_NEW_LINE=Line_SEP;
	/**
	 * 取消 缓存
	 * @param response
	 */
	public static void setNoCache(HttpServletResponse response){
		response.setDateHeader("expries", -1);
		response.setHeader("pragma", "no-cache"); 
		response.setHeader("cache-control", ""); 
	}
	/**
	 * 
	 * 获取当前用户ID<br/>
	 * 获取不到返回-1
	 * @param request
	 * @return 
	 *long
	 * @exception 
	 * @since  1.0.0
	 */
	public static long getCurUserId(HttpServletRequest request){
		long userId=-1;

		SymUser user=getCurUser(request);
		if(user!=null&&user.getId()!=null){
			userId=user.getId();
		}
		if(userId==-1){
			DataUtil.showMsgException("会话已经失效，请重新登陆!");
		}
				
		return userId;
	}
	/**
	 * 
	 * 获取当前用户Name<br/>
	 * 获取不到返回defaultName
	 * @param request
	 * @param defaultName
	 * @return 
	 *String
	 * @exception 
	 * @since  1.0.0
	 */
	public static String getCurUserName(HttpServletRequest request,String defaultName){
		String userName=defaultName;

		SymUser user=getCurUser(request);
		if(user!=null&&!DataUtil.isNull(user.getName())){
			userName=user.getName();
		}				
		return userName;
	}
	/**
	 * 
	 * 获取当前用户<br/>
	 * @return 
	 *SysUser
	 * @exception 
	 * @since  1.0.0
	 */
	public static SymUser getCurUser(HttpServletRequest request){
		SymUser user=null;
		try{
 			 user=(SymUser)request.getSession().getAttribute(LoginParam.SESSION_USER_NAME);
             if(user!=null){
     			 if(user.getIsCustomer()==null)
    				 user.setIsCustomer(0); 
    		     if(user.getIsMaintenance()==null)
    		    	user.setIsMaintenance(0);
    		     if(user.getIsOwner()==null)
    		    	user.setIsOwner(0);
    		     if(user.getIsManager()==null)
    		    	user.setIsManager(0);
             }
			
			 /*    user=new SymUser();
	 	    user.setId(new Long(17));
		    user.setName("杨护卫"); 
		    user.setIsCustomer(0);
		    user.setIsMaintenance(0);
		    user.setIsManager(0);
		    user.setIsOwner(0); 
		    user.setIsMaintenance(1);*/
		   
		}catch(Throwable t){	
			log.error("获取当前用户出错",t);
		}
		return user;
	}
	
	
	public static SymUser getCurUser2(HttpServletRequest request){
		SymUser user=null;
		try{
			 user=(SymUser)request.getSession().getAttribute(LoginParam.SESSION_USER_NAME);
             if(user.getIsCustomer()==null)
				 user.setIsCustomer(0); 
		     if(user.getIsMaintenance()==null)
		    	user.setIsMaintenance(0);
		     if(user.getIsOwner()==null)
		    	user.setIsOwner(0);
		     if(user.getIsManager()==null)
		    	user.setIsManager(0);
		   
		}catch(Throwable t){	
			log.error("获取当前用户出错",t);
		}
		return user;
	}
	
	
	 
	/**
	 * 
	 * 设置当前用户<br/>
	 * @return 
	 *SysUser
	 * @exception 
	 * @since  1.0.0
	 */
	public static SymUser setCurUser(HttpServletRequest request,SymUser user){
		try{
			request.getSession().setAttribute(LoginParam.SESSION_USER_NAME, user);
		}catch(Throwable t){	
			log.error("保存当前用户出错",t);
		}
		return user;
	}
	

	/**
	 * 获取Spring上下文
	 * @return
	 */
	public static ApplicationContext getApplicationContext() {
		return SpringBeanUtil.getInstance().getApplicationContext();
	}
	/**
	 * 获取某个Spring注入的Bean
	 * @param id
	 * @param clasz
	 * @return
	 */
	public static <T> T getSpringBean(String id, Class<T> clasz) {
		return SpringBeanUtil.getBean(id, clasz);
	}
	/**
	 * 
	 * 设置当前用户所有状态<br/>
	 * @return 
	 *SysUser
	 * @exception 
	 * @since  1.0.0
	 */
	public static SymUser saveUserStatus(SymUser user,HttpServletRequest request,HttpServletResponse response){
		try{
			HttpSession session=request.getSession();
			CtxHelper.setCurUser(request, user);
//			UserService userSerevice=CtxHelper.getSpringBean("userService", UserService.class);
//			DeptService deptService=CtxHelper.getSpringBean("deptService", DeptService.class);
//			session.setAttribute(ConstParam.LoginParam.SESSION_USER_NAME, user);		
//			Dept dept=deptService.getDept(user.getDeptCode());
//			session.setAttribute(LoginParam.SESSION_DEPT, dept);
//			
//		 session.setAttribute(LoginParam.SESSION_USER_MODULE, userSerevice.getUserModule(user));
//		 session.setAttribute(LoginParam.SESSION_ROLE_MODULE, userSerevice.getRoleModule(user.getRoleId()));
//		
//		//	session.setAttribute(LoginParam.SESSION_USER_PERMITSSION, userSerevice.getUserPermission(user));
//	  session.setAttribute(LoginParam.SESSION_ROLE_PERMITSSION, userSerevice.getRolePermission(user.getRoleId())); 
//	  session.setAttribute(LoginParam.SESSION_PERMITSSION, userSerevice.getPermission()); 

 
		}catch(Throwable t){
			throw new RuntimeException("保存用户状态出错",t);
		}
		return user;
	}

	/**
	 * 
	 * 设置当前用户所有状态<br/>
	 * @return 
	 *SysUser
	 * @exception 
	 * @since  1.0.0
	 */
	public static SymUser removeUserStatus(SymUser user, HttpServletRequest request,HttpServletResponse response){
		try{
			HttpSession session=request.getSession();
			CtxHelper.setCurUser(request, null);
			request.getSession().setAttribute(LoginParam.SESSION_USER_MODULE, null);
			request.getSession().setAttribute(LoginParam.SESSION_ROLE_MODULE, null);
			request.getSession().invalidate();
			response.addHeader("pragma", "no-cache");
			response.addHeader("cache-control", "");
			response.setDateHeader("Expires", 0);
 
		}catch(Throwable t){
			throw new RuntimeException("保存用户状态出错",t);
		}
		return user;
	}
	
	public static HashMap getSessionRoleModule(HttpServletRequest request){
		return (HashMap) request.getSession().getAttribute(LoginParam.SESSION_ROLE_MODULE);			
	}

	public static HashMap getSessionUserModule(HttpServletRequest request){
		return (HashMap) request.getSession().getAttribute(LoginParam.SESSION_ROLE_MODULE);			
	}
	 
	public static HashMap getSessionRolePermitssion(HttpServletRequest request){
		return (HashMap) request.getSession().getAttribute(LoginParam.SESSION_ROLE_PERMITSSION);			
	}

//	public static Dept getSessionDept(HttpServletRequest request){
//		return (Dept) request.getSession().getAttribute(ConstParam.LoginParam.SESSION_DEPT);			
//	}
	/**
	 * 校验token
	 * @param reset
	 * @return
	 */
	public static boolean validateToken(boolean reset){
		HttpServletRequest request=getRequest();
		return TokenProcessor.getInstance().isTokenValid(request, reset);
	}
	/**
	 * 
	 * @return
	 */
	public static AccData createFailAccData() {
		return new AccData(false,"no","");		
	}
	/**
	 * 
	 * @return
	 */
	public static AccData createSuccAccData() {
		return new AccData(true,"ok","");		
	}
	/**
	 * 
	 * @return
	 */
	public static AccData toSuccAccData(AccData ad) {
		ad.setMsg("操作成功");
		ad.setSuccess(true);
		return ad;		
	}
	/**
	 * 
	 * 把AccData打印到JSON(使用toJson)
	 * @param ad
	 * @return 
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 * @exception 
	 * @since  1.0.0
	 */
	public static void writeToJson(HttpServletResponse response,AccData ad) {
		//responseResult(response,ad.toJson(), "UTF-8");
	}

	/**
	 * 
	 * 把AccData打印到JSON(使用toJson)
	 * @param ad
	 * @return 
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 * @exception 
	 * @since  1.0.0
	 */
	public static void writeToJson(HttpServletResponse response,AccData ad,String callback) {

		//CtxHelper.responseResult(response,DataUtil.addCallback(ad.toJson(), callback));
		
	}
	
	/**
	 * 
	 * 把ad打印到JSON
	 * @param ad
	 * @return 
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 * @exception 
	 * @since  1.0.0
	 */
	public static void writeToJsonWithToString(HttpServletResponse response,AccData ad) {
		responseResult(response,ad.toString(), "UTF-8");
	}
	

	/**
	 * 判断菜单有无url权限
	 * checkUrlRight(作用)<br/>
	 * (适用条件):<br/>
	 * (执行流程):<br/>
	 * (使用方法):<br/>
	 * (注意事项):<br/>
	 * @param urlRightMap
	 * @param url
	 * @return 
	 *boolean
	 * @exception 
	 * @since  1.0.0
	 */
	public static  boolean checkUrlRight(Map<String,Object> urlRightMap,String url){
		boolean flag=false;
		if(!ConstParam.URL_CHECK_ENABLE){
			flag=true;
		}else{
			flag=urlRightMap!=null&&urlRightMap.containsKey(url);
		}
		return flag;
			
	}

	/**
	 * 响应 ajax提交的请求，返回字符串
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 */
	public static void responseResult(HttpServletResponse response,String result)  {
		 responseResult(response,result, "UTF-8");
	}
	/**
	 * 响应 ajax提交的请求，返回字符串
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 */
	public static void responseResult(HttpServletResponse response,String result,String charset) {
		
		//1.设定返回类型
//		response.setContentType("text/html;charset="+charset);
		response.setContentType("application/json");
		
		//2.取参数
		response.setCharacterEncoding(charset);

		//3.返回页面
		try {
			response.getOutputStream().write(result.getBytes(charset));
			response.getOutputStream().flush();
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("不支持的编码!",e);
		} catch (IOException e) {
			throw new RuntimeException("IO异常!",e);
		}
	}
	



	/**
	 * 获取当前的request
	 * 该方法可能会有问题，不过一般没问题
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		 return getRequestAttributes().getRequest();
	}
//	public static HttpServletResponse getResponse() {
//		 return ((ServletRequestAttributes)getRequestAttributes()).getRequest()
//	}
//	public static ServletRequestAttributes getServletRequestAttributes(){
//		return  (ServletRequestAttributes) 
//                RequestContextHolder.currentRequestAttributes(); 
//	}
	public static ServletRequestAttributes  getRequestAttributes(){
		return  (ServletRequestAttributes) RequestContextHolder.getRequestAttributes(); 
	}
	/**
	 *从小到大排序请求参数
	 * @author 杨培新
	 * @return String
	 * @param params
	 * @param hreq
	 * @return
	 */
    @SuppressWarnings("unchecked")
	public static String accessRequestParaStr(Enumeration params,HttpServletRequest hreq){
    	 StringBuffer sb = new StringBuffer();
    	 ArrayList aList =Collections.list(params);
    	 Collections.sort(aList,acc);   //Comparator用来实现排序规则
    	 String value = "";String param="";
    	 String prefix="";
    	 for(int i=0;i<aList.size();i++){
    		 param = aList.get(i).toString();
    		 if("randnum".equals(param))continue;
    		 value = hreq.getParameter(param);
    		 sb.append(prefix+param+"="+value);
    		 prefix="&";
    	 }
    	return sb.toString();
    }
	 /**
     * 组装web信息参数
     * @param request
     * @return 
     *String
     * @exception 
     * @since  1.0.0
     */
	public static String accessWebPara(HttpServletRequest request){
		StringBuffer sb=new StringBuffer();		
		String urlExt = CtxHelper.accessRequestParaStr(request.getParameterNames(),request);		
		sb.append("IP:"+getIpAddr(request));		
		sb.append("\tURL:"+request.getServletPath());
		sb.append("  Param:"+urlExt);
		sb.append(CtxHelper.Line_SEP);
		return sb.toString();
	}
	/**
	 * 通过reuqest参数获取地址
	 * @param request
	 * @return 
	 *String
	 * @exception 
	 * @since  1.0.0
	 */
    public static String getIpAddr(HttpServletRequest request) {
	    String ip = request.getHeader("x-forwarded-for");
		if (DataUtil.isNull(ip)|| "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (DataUtil.isNull(ip)|| "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (DataUtil.isNull(ip)|| "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if(!DataUtil.isNull(ip)&&ip.length()>=20&&ip.contains(","))
			return ip.split(",")[0];
		return ip;
	}
	public static String markIpStr(HttpServletRequest request,String str){
		return "IP:"+ getIpAddr(request)+" -- "+str;
	}
	

	private static final  AsciiComparator acc = new AsciiComparator();
}
