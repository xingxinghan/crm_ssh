package dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import dao.CustomerDao;
import entity.Customer;
import entity.PageBean;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

//	hibernateTemplate不能作为属性，因为它是通过this对象得到，此时还没有对象，所有得到的hibernateTemplate都为null
//	private HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
	
	
//	@Override
//	public void add(Customer customer) {
//		getHibernateTemplate().save(customer);
//		
//	}
//
//	@Override
//	public List<Customer> list() {
//		List<Customer> list = (List<Customer>) getHibernateTemplate().find("from Customer");
//		
//		return list;
//	}
//
//	@Override
//	public Customer find(Integer cid) {
//		return this.getHibernateTemplate().get(Customer.class,cid);
//	}
//
//	@Override
//	public void update(Customer customer) {
//
//		this.getHibernateTemplate().update(customer);
//	}
//
//	@Override
//	public void delete(Customer customer) {
//		this.getHibernateTemplate().delete(customer);
//		
//	}

	@Override
	public int findCount() {
		List<Object> list =(List<Object>) this.getHibernateTemplate().find("select count(*) from Customer");
		if(list!=null && !list.isEmpty()){
			Long val=(Long) list.get(0);
			return val.intValue();
		}
		return 0;
	}

	@Override
	public List<Customer> findPage(int begin, int pageSize) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Customer.class);
		return (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findcondition(Customer customer) {
		
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().find("from Customer where custName like ?", "%"+customer.getCustName()+"%");
		return list;
	}

	@Override
	public List<Customer> select(Customer customer) {
		List<String> list=new ArrayList<String> ();
		String hql="from Customer c where 1=1";
		System.out.println(customer.getCustName());
		System.out.println(customer.getCustName().trim());
		if(customer.getCustName()!=null && !customer.getCustName().trim().equals("")){
			hql=hql+" and c.custName=?";
			list.add(customer.getCustName());
		}
		if(customer.getCustSource()!=null && !customer.getCustSource().trim().equals("")){
			hql=hql+" and c.custSource=?";
			list.add(customer.getCustSource());
		}
		if(customer.getDict().getDid()>0){
			hql=hql+" and c.dict.did="+customer.getDict().getDid();
			
		}
		return (List<Customer>) this.getHibernateTemplate().find(hql,list.toArray());
	}

	@Override
	public List countLevel() {
		
//		String hql="select d.dname,count(*) num from Customer c,Dict d where c.customer.levelid=d.did group by c.levelid";
		
		
		String sql="select d.dname,count(*) num from t_customer c,t_dict d where c.levelid=d.did group by c.levelid";
		Session session=this.getSessionFactory().getCurrentSession();
		SQLQuery query=session.createSQLQuery(sql);
		query.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		return query.list();
	}

	@Override
	public List countSource() {
		Session session=this.getSessionFactory().getCurrentSession();
		
		String hql="select count(*),custSource from Customer group by custSource";
		Query query=session.createQuery(hql);
		
//		String sql="select custSource,count(*) num from t_customer group by custSource";
//		SQLQuery query=session.createSQLQuery(sql);
		//得到的是list集合，集合中装的对象数组，［［2，报纸］，［1，网络］］
		List list=query.list();
		return list;
	}

	

}
