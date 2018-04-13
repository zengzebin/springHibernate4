package ssxt.com.zeng.xml;

import java.util.HashSet;
import java.util.Set;

public class Role implements java.io.Serializable  {
	private Integer roleid;  
    private String rolename;  
    private Integer ordernum;  
    private String description;  
    private Set <User>users = new HashSet<User>(0);  
  
    public Role() {  
        super();  
    }  
  
    public Integer getRoleid() {  
        return roleid;  
    }  
  
    public void setRoleid(Integer roleid) {  
        this.roleid = roleid;  
    }  
  
    public String getRolename() {  
        return rolename;  
    }  
  
    public void setRolename(String rolename) {  
        this.rolename = rolename;  
    }  
  
    public Integer getOrdernum() {  
        return ordernum;  
    }  
  
    public void setOrdernum(Integer ordernum) {  
        this.ordernum = ordernum;  
    }  
  
    public String getDescription() {  
        return description;  
    }  
  
    public void setDescription(String description) {  
        this.description = description;  
    }  
  
    public Set<User> getUsers() {  
        return users;  
    }  
  
    public void setUsers(Set<User> users) {  
        this.users = users;  
    }  
}
