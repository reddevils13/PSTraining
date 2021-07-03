package com.to;

public class Restaurants {

	private String rid;
	private String rname;
	private String location;
	
	
	public Restaurants(String rid, String rname, String location) {
		super();
		this.rid = rid;
		this.rname = rname;
		this.location = location;
	}
	
	public Restaurants() {
		
		// TODO Auto-generated constructor stub
	}
	
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Restaurants [rid=" + rid + ", rname=" + rname + ", location=" + location + "]";
	}
	
	
	
}
