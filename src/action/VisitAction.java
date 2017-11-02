package action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Customer;
import entity.User;
import entity.Visit;
import service.CustomerService;
import service.UserService;
import service.VisitService;

public class VisitAction extends ActionSupport implements ModelDriven<Visit>{

	
	private Visit visit = new Visit();
	@Override
	public Visit getModel() {
		return visit;
	}
	
	private VisitService visitService;
	public void setVisitService(VisitService visitService) {
		this.visitService = visitService;
	}
	
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public String toAddPage(){
		
		List<User> users =userService.list();
		
		List<Customer> customers=customerService.list();
		
		ServletActionContext.getRequest().setAttribute("users", users);
		ServletActionContext.getRequest().setAttribute("customers", customers);
		return "toAddPage";
	}
	
	public String add(){
		
		visitService.add(visit);
		
		return "add";
	}
	
	public String list(){
		
		List<Visit> visits=visitService.list();
		ServletActionContext.getRequest().setAttribute("visits", visits);
		return "list";
	}
	
	public String toUpdatePage(){
		
		List<User> users =userService.list();
		List<Customer> customers=customerService.list();
		int vid=visit.getVid();
		Visit visit=visitService.get(vid);
		ServletActionContext.getRequest().setAttribute("users", users);
		ServletActionContext.getRequest().setAttribute("customers", customers);
		ServletActionContext.getRequest().setAttribute("visit", visit);
		return "toUpdatePage";
	}
	
public String update(){
		
		visitService.update(visit);	
		
		return "update";
	}
	
public String delete(){
	
		int vid=visit.getVid();
		Visit visit=visitService.get(vid);
		visitService.delete(visit);
		return "delete";
	}

	
	
}
