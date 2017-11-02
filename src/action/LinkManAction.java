package action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Customer;
import entity.LinkMan;
import service.CustomerService;
import service.LinkManService;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {

	private LinkManService linkManService;

	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}

	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public void setLinkMan(LinkMan linkMan) {
		this.linkMan = linkMan;
	}

	private LinkMan linkMan = new LinkMan();

	@Override
	public LinkMan getModel() {
		return linkMan;
	}

	public String toAddPage() {

		List<Customer> customers = customerService.list();
		ServletActionContext.getRequest().setAttribute("customers", customers);
		return "toAddPage";
	}

	public String add() {

		linkManService.add(linkMan);
		return "add";
	}
	
	public String list(){
		
		List<LinkMan> linkMans=linkManService.list();
		ServletActionContext.getRequest().setAttribute("linkMans", linkMans);
		return "list";
	}
	
	public String toUpdatePage(){
		Integer lid=linkMan.getLid();
		LinkMan linkMan = linkManService.find(lid);
		System.out.println(linkMan);
		System.out.println(linkMan.getLkmName());
		List<Customer> customers=customerService.list();
		ServletActionContext.getRequest().setAttribute("linkMan", linkMan);
		ServletActionContext.getRequest().setAttribute("customers", customers);
		
		return "toUpdatePage";
	}
	
	public String update(){
		linkManService.update(linkMan);
		return "update";
	}
	
	public String delete(){
		Integer lid=linkMan.getLid();
		LinkMan linkMan = linkManService.find(lid);
		linkManService.delete(linkMan);
		return "update";
	}
	
	public String toSelectPage(){
		List<Customer> customers=customerService.list();
		ServletActionContext.getRequest().setAttribute("customers", customers);
		return "toSelectPage";
	}
public String select(){
		List<LinkMan> linkMans =linkManService.select(linkMan);
		ServletActionContext.getRequest().setAttribute("linkMans", linkMans);
		return "select";
	}

}
