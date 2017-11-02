package dao;

import java.util.List;
import java.util.Map;

import entity.Customer;
import entity.PageBean;

public interface CustomerDao extends BaseDao<Customer>{

//	void add(Customer customer);

//	List<Customer> list();

//	Customer find(Integer cid);

//	void update(Customer customer);

//	void delete(Customer customer);

	int findCount();

	List<Customer> findPage(int begin, int pageSize);

	List<Customer> findcondition(Customer customer);

	List<Customer> select(Customer customer);

	List countLevel();

	List countSource();


}
