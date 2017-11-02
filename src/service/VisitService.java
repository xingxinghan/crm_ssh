package service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.VisitDao;
import entity.Visit;


@Transactional
public class VisitService {

	private VisitDao visitDao;
	public void setVisitDao(VisitDao visitDao) {
		this.visitDao = visitDao;
	}
	public void add(Visit visit) {
		visitDao.add(visit);
		
	}
	public List<Visit> list() {
		
		return visitDao.list();
		
	}
	public Visit get(int vid) {
		
		return visitDao.find(vid);
	}
	public void update(Visit visit) {
		visitDao.update(visit);
	}
	public void delete(Visit visit) {
		visitDao.delete(visit);
		
	}
	
}
