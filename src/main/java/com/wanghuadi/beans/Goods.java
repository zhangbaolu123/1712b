package com.wanghuadi.beans;

public class Goods {
	
	private Integer gid;
	
	private String ename;
	
	private String cname;
	
	private Integer bid;
	
	private Integer kid;
	
	private String size;
	
	private Double price;
	
	private Integer num;
	
	private String label;
	
	private String priurl;
	
	//临时字段
	private String bname;
	
	private String kname;

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getEname() {
		return ename;
	}
	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public Integer getKid() {
		return kid;
	}

	public void setKid(Integer kid) {
		this.kid = kid;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getPriurl() {
		return priurl;
	}

	public void setPriurl(String priurl) {
		this.priurl = priurl;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getKname() {
		return kname;
	}

	public void setKname(String kname) {
		this.kname = kname;
	}

	@Override
	public String toString() {
		return "Goods [gid=" + gid + ", ename=" + ename + ", bid=" + bid + ", kid=" + kid + ", size=" + size
				+ ", price=" + price + ", num=" + num + ", label=" + label + ", priurl=" + priurl + ", bname=" + bname
				+ ", kname=" + kname + "]";
	}
	
}
