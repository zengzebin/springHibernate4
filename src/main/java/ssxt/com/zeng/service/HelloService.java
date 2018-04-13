package ssxt.com.zeng.service;
public class HelloService {   
    public String test(){  
        return "hello";  
    }     
    public String test1(String name){          
        if(name==null){  
            name = "nobody";  
        }  
        return "hello,"+name;  
    }  
}  