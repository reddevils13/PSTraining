package com.to;

public class Tables {

	private String tid;
	private String rid;
	private String status;
	
	
	public Tables() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tables(String tid, String rid, String status) {
		super();
		this.tid = tid;
		this.rid = rid;
		this.status = status;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Tables [tid=" + tid + ", rid=" + rid + ", status=" + status + "]";
	}
	
	
	
}
