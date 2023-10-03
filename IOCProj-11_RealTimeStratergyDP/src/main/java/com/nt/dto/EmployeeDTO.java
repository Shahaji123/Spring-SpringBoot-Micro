package com.nt.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable{
	
	private Integer eno;
	private String ename;
	private Float basicSalary;
	private String desg;
	
	public Integer getEno() {
		return eno;
	}
	public void setEno(Integer eno) {
		this.eno = eno;
	}
	public String geteName() {
		return ename;
	}
	public void seteName(String eName) {
		this.ename = eName;
	}
	public Float getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(Float basicSalary) {
		this.basicSalary = basicSalary;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	

}
