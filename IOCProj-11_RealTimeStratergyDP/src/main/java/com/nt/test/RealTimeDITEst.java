package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.controller.MainController;
import com.nt.vo.EmployeeVO;

public class RealTimeDITEst {
public static void main(String[] args) {
	 DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
	 XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
	
	reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
	System.out.println(factory);
	MainController controller=factory.getBean("controller",MainController.class);
	 System.out.println(controller);
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter name");
	String name=sc.nextLine();
	System.out.println("Employee Desig");
	String desig=sc.nextLine();
	System.out.println("Employee BasicSalary");
	String basicSalary=sc.next();
	
	EmployeeVO vo=new EmployeeVO();
	vo.setEname(name);
	vo.setDesg(desig);
	vo.setBasicSalary(basicSalary);
//	vo.setEno("12");
	try {
		String  result=controller.processEmployee(vo);
		System.out.println(result);
	 }catch(Exception e) {
		 
		System.out.println("RealTimeDITEst.main() Error");
		e.printStackTrace();
		
	}
 }
}
