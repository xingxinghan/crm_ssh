package entity;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	
	private Integer cid;
	private String custName;
//	private String custLevel;
	private String custSource;
	private String custPhone;
	private String custMobile;
	
	private Dict dict;
	
	public Dict getDict() {
		return dict;
	}
	public void setDict(Dict dict) {
		this.dict = dict;
	}
	private Set<LinkMan> linkMan = new HashSet<LinkMan>();
	private Set<Visit> cusVisits=new HashSet<Visit>();
	
	public Set<Visit> getCusVisits() {
		return cusVisits;
	}
	public void setCusVisits(Set<Visit> cusVisits) {
		this.cusVisits = cusVisits;
	}
	public Set<LinkMan> getLinkMan() {
		return linkMan;
	}
	public void setLinkMan(Set<LinkMan> linkMan) {
		this.linkMan = linkMan;
	}
	
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	public String getCustSource() {
		return custSource;
	}
	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	public String getCustMobile() {
		return custMobile;
	}
	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}

}
