package dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import dao.VisitDao;
import entity.Visit;

public class VisitDaoImpl extends BaseDaoImpl<Visit> implements VisitDao {

	
//	@Override
//	public void add(Visit visit) {
//		this.getHibernateTemplate().save(visit);
//		
//	}
//
//	@Override
//	public List<Visit> list() {
//		return (List<Visit>) this.getHibernateTemplate().find("from Visit");
//	}
//
//	@Override
//	public Visit find(int vid) {
//		return this.getHibernateTemplate().get(Visit.class, vid);
//	}
//
//	@Override
//	public void update(Visit visit) {
//		this.getHibernateTemplate().update(visit);
//		
//	}
//
//	@Override
//	public void delete(Visit visit) {
//		this.getHibernateTemplate().delete(visit);
//		
//	}

}
