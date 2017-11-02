package service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.LinkManDao;
import entity.LinkMan;

@Transactional
public class LinkManService {
	
	private LinkManDao linkManDao;
	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}
	public void add(LinkMan linkMan) {

		linkManDao.add(linkMan);
	}
	public List<LinkMan> list() {
		
		List<LinkMan> list = linkManDao.list();
		return list;
	}
	public LinkMan find(Integer lid) {
		return linkManDao.find(lid);
	}
	public void update(LinkMan linkMan) {
		linkManDao.update(linkMan);
		
	}
	public void delete(LinkMan linkMan) {
		linkManDao.delete(linkMan);
		
	}
	public List<LinkMan> select(LinkMan linkMan) {
		// TODO Auto-generated method stub
		return linkManDao.select(linkMan);
	}
	

}
