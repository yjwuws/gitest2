package com.emp.model;

public class EmployeeVO {
	private static final long serialVersionUID = 1L;
	private String emp_no;
	private String emp_acc;
	public String getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}
	public String getEmp_acc() {
		return emp_acc;
	}
	public void setEmp_acc(String emp_acc) {
		this.emp_acc = emp_acc;
	}
	public String getEmp_pwd() {
		return emp_pwd;
	}
	public void setEmp_pwd(String emp_pwd) {
		this.emp_pwd = emp_pwd;
	}
	public Integer getEmp_title() {
		return emp_title;
	}
	public void setEmp_title(Integer emp_title) {
		this.emp_title = emp_title;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public Integer getEmp_is_delete() {
		return emp_is_delete;
	}
	public void setEmp_is_delete(Integer emp_is_delete) {
		this.emp_is_delete = emp_is_delete;
	}
	public Byte[] getEmp_pic() {
		return emp_pic;
	}
	public void setEmp_pic(Byte[] emp_pic) {
		this.emp_pic = emp_pic;
	}
	private String emp_pwd;
	private Integer emp_title; 
	private String emp_name;
	private Integer emp_is_delete;
	private Byte[] emp_pic;
}
