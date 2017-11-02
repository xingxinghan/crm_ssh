package dao;
import java.util.List;

public interface BaseDao<T> {
//	增
	void add(T t);
//	删
	void delete(T t);
//	改
	void update(T t);
//	查所有
	List<T> list();
//	通过id查
	T find(Integer id);
	
}
