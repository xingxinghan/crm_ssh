package dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import dao.BaseDao;
import entity.Customer;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	private Class aclass;
	
	public BaseDaoImpl(){
		Class clazz=this.getClass();
		//获得运行类的父类的参数化类型BaseDaoImpl<Customer>
		ParameterizedType ptype=(ParameterizedType) clazz.getGenericSuperclass();
		//获得参数化类型中的实际类型参数<Customer>
		Type types[] = ptype.getActualTypeArguments();
		
		this.aclass=(Class) types[0];
	}
	
	
	@Override
	public void add(T t) {
		this.getHibernateTemplate().save(t);
		
	}

	@Override
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
		
	}

	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
		
	}
//	不能直接写成this.getHibernateTemplate().find("from T")
	@Override
	public List<T> list() {
		// TODO Auto-generated method stub
		return (List<T>) this.getHibernateTemplate().find("from "+aclass.getSimpleName());
	}

	@Override
	public T find(Integer id) {
		// TODO Auto-generated method stub
		return (T) this.getHibernateTemplate().get(aclass, id);
	}

}
