package dao;

import java.util.List;

import entity.User;

public interface UserDao {

	User login(User user);

	List<User> list();

}
