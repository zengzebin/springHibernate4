package ssxt.com.zeng.xml;

import java.util.HashSet;
import java.util.Set;

public class User  implements java.io.Serializable {
	 	private Integer userid;  
	    private String username;  
	    private String password;  
	    private Set <Role>roles = new HashSet<Role>(0);  
	  
	    public User() {  
	        super();  
	    }  
	  
	    public Integer getUserid() {  
	        return userid;  
	    }  
	  
	    public void setUserid(Integer userid) {  
	        this.userid = userid;  
	    }  
	  
	    public String getUsername() {  
	        return username;  
	    }  
	  
	    public void setUsername(String username) {  
	        this.username = username;  
	    }  
	  
	    public String getPassword() {  
	        return password;  
	    }  
	  
	    public void setPassword(String password) {  
	        this.password = password;  
	    }  
	  
	    public Set<Role> getRoles() {  
	        return roles;  
	    }  
	  
	    public void setRoles(Set<Role> roles) {  
	        this.roles = roles;  
	    }  
}
