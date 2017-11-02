package service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import dao.DictDao;
import entity.Dict;

@Transactional
public class DictService {
	private DictDao dictDao;

	public void setDictDao(DictDao dictDao) {
		this.dictDao = dictDao;
	}

	public List<Dict> list() {
		// TODO Auto-generated method stub
		return dictDao.list();
	}
	
}
