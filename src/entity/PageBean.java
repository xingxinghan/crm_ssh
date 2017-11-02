package entity;

import java.util.List;

public class PageBean {
	
	private Integer currentPage;   //当前页
	private Integer totalCount;    //总记录数
	private Integer pageSize=2;      //页面显示的记录数
	private Integer totalPage;     //总页数
	private Integer begin;         //开始位置
	private List<Customer> list;   //每页记录的list集合
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		return (this.totalCount+this.pageSize-1)/this.pageSize;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getBegin() {
		return (currentPage-1)*pageSize;
	}
	public void setBegin(Integer begin) {
		this.begin = begin;
	}
	public List<Customer> getList() {
		return list;
	}
	public void setList(List<Customer> list) {
		this.list = list;
	}

}
