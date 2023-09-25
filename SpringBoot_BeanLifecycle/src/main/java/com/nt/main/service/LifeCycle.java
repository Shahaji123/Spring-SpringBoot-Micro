package com.nt.main.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class LifeCycle implements InitializingBean,DisposableBean{

	public LifeCycle(){
		System.out.println("m1 methdo executed");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("AfterProperties Method Executed");
	}
	@Override
	public void destroy()throws Exception{
		System.out.println("Destroy method executed");
	}
}
