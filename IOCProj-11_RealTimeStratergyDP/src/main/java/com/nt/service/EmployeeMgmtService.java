package com.nt.service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAOIMP;
import com.nt.dto.EmployeeDTO;

public class EmployeeMgmtService implements IEmployeeMgmtService {

	private EmployeeDAOIMP dao;
	
	
	public EmployeeMgmtService(EmployeeDAOIMP dao) {	
		System.out.println("EmployeeMgmtService.EmployeeMgmtService()");
		this.dao = dao;
	}


	@Override
	public String registerEmployee(EmployeeDTO dto)throws Exception{
		System.out.println("EmployeeMgmtService.registerEmployee()");
		float grossSalary=dto.getBasicSalary()+dto.getBasicSalary()*0.4f;
		float netSalary=grossSalary-dto.getBasicSalary()*0.2f;
		EmployeeBO bo=new EmployeeBO();
		bo.seteName(dto.geteName());
		bo.setDesg(dto.getDesg());
		bo.setBasicSalary(dto.getBasicSalary());
		bo.setGrossSalary(grossSalary);
		bo.setNetSalary(netSalary);
		int count=dao.insertEmployee(bo);
		return count==1?"Employee register with salary "+netSalary:"Employee not register with netSalary"+netSalary;
	  // return "Hi";
	}
}
