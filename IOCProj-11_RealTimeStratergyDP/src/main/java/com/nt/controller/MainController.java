package com.nt.controller;

import com.nt.dto.EmployeeDTO;
import com.nt.service.IEmployeeMgmtService;
import com.nt.vo.EmployeeVO;

public class MainController {

	//Has-A
	private IEmployeeMgmtService service;

	public MainController(IEmployeeMgmtService service) {
	
		//super();
		this.service = service;
		System.out.println("MainController.MainController()");
	}
	
	public String processEmployee(EmployeeVO vo)throws Exception{
		System.out.println("MainController.processEmployee()");
		EmployeeDTO dto=new EmployeeDTO();
		//dto.setEno(Integer.parseInt(vo.getEno()));
		dto.seteName(vo.getEname());
		dto.setDesg(vo.getDesg());
		dto.setBasicSalary(Float.parseFloat(vo.getBasicSalary()));
	    String result=service.registerEmployee(dto);
		
	    return result; 
		
	}
	
}
