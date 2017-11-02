package dao;

import java.util.List;

import entity.LinkMan;

public interface LinkManDao extends BaseDao<LinkMan>{

	void add(LinkMan linkMan);

	List<LinkMan> list();

	LinkMan find(Integer lid);

	void update(LinkMan linkMan);

	void delete(LinkMan linkMan);

	List<LinkMan> select(LinkMan linkMan);

}
