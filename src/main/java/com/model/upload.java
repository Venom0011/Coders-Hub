package com.model;

public class upload {
	
	private int pid;
	private String fname;
	private String email;
	private String mobno;
	private String projectname;
	private String desc;
	private String pic;
	public upload(String fname, String email, String mobno, String projectname, String desc, String pic) {
		super();
		this.fname = fname;
		this.email = email;
		this.mobno = mobno;
		this.projectname = projectname;
		this.desc = desc;
		this.pic = pic;
	
	}
	public upload(int pid, String fname, String email, String mobno, String projectname, String desc,
			String pic) {
		super();
		this.pid = pid;
		this.fname = fname;
		this.email = email;
		this.mobno = mobno;
		this.projectname = projectname;
		this.desc = desc;
		this.pic = pic;
	}
	public upload() {
		super();
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	
	
	
	
}
