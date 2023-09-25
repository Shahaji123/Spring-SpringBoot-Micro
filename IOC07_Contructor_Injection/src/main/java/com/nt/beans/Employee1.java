package com.nt.beans;

public class Employee1 {
	private int eno;
	private String ename;
	private String eaddress;
	
	public Employee1(int eno, String ename, String eaddress) {
		this.eno = eno;
		this.ename = ename;
		this.eaddress = eaddress;
	}

	@Override
	public String toString() {
		return "Employee1 [eno=" + eno + ", ename=" + ename + ", eaddress=" + eaddress + "]";
	}
	
}
