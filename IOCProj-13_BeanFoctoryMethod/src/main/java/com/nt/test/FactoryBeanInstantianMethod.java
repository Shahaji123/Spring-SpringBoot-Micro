package com.nt.test;

import java.util.Calendar;
import java.util.Properties;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class FactoryBeanInstantianMethod {
public static void main(String[] args) {

	DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
	XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
	reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
	//getSpring Bean Class Object
	Class clazz=factory.getBean("c1",Class.class);
	System.out.println("Clazz Name Class Object "+clazz.getClass()+"     \nclazz OBject "+clazz.toString());
	System.out.println("===================================================");
	
	 Calendar cal=factory.getBean("cal",Calendar.class);
	 System.out.println(cal.getClass()+" "+cal.toString());
	System.out.println("=================================================");
	Properties props=factory.getBean("props",Properties.class);
	 System.out.println(props.getClass()+" "+props.toString());
  }

}
