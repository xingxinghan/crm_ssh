package service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;
import entity.User;

@Transactional
public class UserService {
	
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public User login(User user) {

		return userDao.login(user);
		
	}

	public List<User> list() {
		return userDao.list();
	}

}
