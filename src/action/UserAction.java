package action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import entity.User;
import service.UserService;

public class UserAction extends ActionSupport {
	
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
//	属性封装实体类
	private String username;
	private String password;
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

	public String login(){
//		封装到实体类中
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		
		User userExist = userService.login(user);
		
		if(userExist!=null){
			ServletActionContext.getRequest().getSession().setAttribute("user", userExist);;
			return "loginSuccess";
		}else{
			return "login";
		}
	}
}
