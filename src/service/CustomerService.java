package service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import dao.CustomerDao;
import entity.Customer;
import entity.PageBean;

@Transactional
public class CustomerService {
	
	private CustomerDao customerDao;
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	public void add(Customer customer) {
		customerDao.add(customer);
		
	}
	public List<Customer> list() {
		return customerDao.list();
	}
	public Customer find(Integer cid) {
		
		return customerDao.find(cid);
	}
	public void update(Customer customer) {
		customerDao.update(customer);
	}
	public void delete(Customer customer) {
		customerDao.delete(customer);
		
	}
	public PageBean listpage(Integer currentPage) {
		
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(currentPage);
		
		int pageSize=pageBean.getPageSize();
		
		int totalCount = customerDao.findCount();
		
		pageBean.setTotalCount(totalCount);
		pageBean.setTotalPage(pageBean.getTotalPage());
		int begin=pageBean.getBegin();
		pageBean.setBegin(begin);
		
		List<Customer> list=customerDao.findPage(begin,pageSize);
		
		pageBean.setList(list);
		
		return pageBean;
		
	}
	public List<Customer> findcondition(Customer customer) {
		return customerDao.findcondition(customer);
	}
	public List<Customer> select(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.select(customer);
	}
	public List countLevel() {
		
		return customerDao.countLevel();
	}
	public List countSource() {
		// TODO Auto-generated method stub
		return customerDao.countSource();
	}
}
