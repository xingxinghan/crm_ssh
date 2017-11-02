package action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Customer;
import entity.Dict;
import entity.PageBean;
import service.CustomerService;
import service.DictService;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	
	private CustomerService customerService;
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	private DictService dictService;
	public void setDictService(DictService dictService) {
		this.dictService = dictService;
	}
	//模型驱动注入实体类
	private Customer customer=new Customer();
	@Override
	public Customer getModel() {
		return customer;
	}
	
//	到添加页面
	public String toAddPage(){
		List<Dict> dicts = dictService.list();
		ServletActionContext.getRequest().setAttribute("dicts", dicts);
		return "toAddPage";
	}
//	添加方法
	public String add(){
		customerService.add(customer);
		return "add";
	}
	
	
//	private List<Customer> list;
//	public List<Customer> getList() {
//		return list;
//	}

	//	客户列表方法
	public String list(){
//		在jsp页面中通过el表达式得到
		List<Customer> list = customerService.list();
		ServletActionContext.getRequest().setAttribute("list", list);
		
//		list = customerService.list();
		return "list";
	}
	
	
	public String toUpdate(){
		int cid=customer.getCid();
		System.out.println(cid);
		customer = customerService.find(cid);
		List<Dict> dicts = dictService.list();
		ServletActionContext.getRequest().setAttribute("dicts", dicts);
		ServletActionContext.getRequest().setAttribute("customer", customer);
		return "toUpdate";
	}
	
	
	public String update(){
		customerService.update(customer);
		return "update";
	}
	
	public String delete(){
		customer = customerService.find(customer.getCid());
		if(customer!=null){
			customerService.delete(customer);
		}
		return "delete";
	}
	
	
//	属性封装 得到currentPage
	Integer currentPage;
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public String listpage(){
		
		PageBean pageBean = customerService.listpage(currentPage);
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		
		return "listpage";
	}
	
	public String listcondition(){
		
		if(customer.getCustName()!=null && !customer.getCustName().equals("")){
			List<Customer> list =customerService.findcondition(customer);
			ServletActionContext.getRequest().setAttribute("list", list);
		}else{
			List<Customer> list = customerService.list();
			ServletActionContext.getRequest().setAttribute("list", list);
		}
		
		return "listcondition";
	}
	
	public String toSelectPage(){
		List<Dict> dicts = dictService.list();
		ServletActionContext.getRequest().setAttribute("dicts", dicts);
		return "toSelectPage";
	}
	
	public String select(){
		
		List<Customer> list = customerService.select(customer);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "select";
	}
	
	public String countLevel(){
		List levelResults = customerService.countLevel();
		ServletActionContext.getRequest().setAttribute("levelResults", levelResults);
		return "countLevel";
	}
	
	public String countSource(){
		List sourceResults = customerService.countSource();
		ServletActionContext.getRequest().setAttribute("sourceResults", sourceResults);
		return "countSource";
	}

}
