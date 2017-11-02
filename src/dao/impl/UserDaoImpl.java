package dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import dao.UserDao;
import entity.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@SuppressWarnings("unchecked")
	@Override
	public User login(User user) {

		HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
		List<User> list = (List<User>) hibernateTemplate.find("from User where username=? and password=?",
				user.getUsername(), user.getPassword());
		if(list==null || list.isEmpty()){
			return null;
		}
		return list.get(0);
	}

//	@Override
//	public List<User> list() {
//		return (List<User>) this.getHibernateTemplate().find("from User");
//	}

}
