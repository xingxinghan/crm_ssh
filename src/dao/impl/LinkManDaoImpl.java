package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import dao.LinkManDao;
import entity.LinkMan;

public class LinkManDaoImpl extends BaseDaoImpl<LinkMan> implements LinkManDao {

	@Override
	public List<LinkMan> select(LinkMan linkMan) {
		String hql="from LinkMan l where 1=1";
		List<String> list=new ArrayList<String>();
		if(linkMan.getLkmName()!=null && !linkMan.getLkmName().trim().equals("")){
			hql=hql+" and l.lkmName=?";
		}
		if(linkMan.getCustomer().getCid()>0){
			hql=hql+" and l.customer.cid="+linkMan.getCustomer().getCid();
		}
		return (List<LinkMan>) this.getHibernateTemplate().find(hql, list.toArray());
	}

//	@Override
//	public void add(LinkMan linkMan) {
//		this.getHibernateTemplate().save(linkMan);
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<LinkMan> list() {
//		List<LinkMan>list= (List<LinkMan>) this.getHibernateTemplate().find("from LinkMan");
//		return list;
//	}
//
//	@Override
//	public LinkMan find(Integer lid) {
//		return this.getHibernateTemplate().get(LinkMan.class, lid);
//	}
//
//	@Override
//	public void update(LinkMan linkMan) {
//		this.getHibernateTemplate().update(linkMan);
//	
//	}
//
//	@Override
//	public void delete(LinkMan linkMan) {
//		this.getHibernateTemplate().delete(linkMan);
//		
//	}
	
	
}
