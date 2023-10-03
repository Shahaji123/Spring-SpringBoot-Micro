package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.nt.bo.EmployeeBO;

public class EmployeeDAOIMP implements EmployeeDAO {
   
	private static final String EMP_INSERT_QUERY="INSERT INTO realtime_springemployee values(SP_ENO_SEQ.NEXTVAL,?,?,?,?,?)";
	PreparedStatement ps=null;
	//Has-A property
	private DataSource ds;
	int result=0;
	
	
	
	public EmployeeDAOIMP( DataSource ds) {		
		this.ds = ds;		
	}



	@Override
	public int insertEmployee(EmployeeBO bo) throws Exception {
		try(Connection con=ds.getConnection();
			PreparedStatement ps=con.prepareStatement(EMP_INSERT_QUERY)	){
		   //  ps.setInt(1, bo.getEno());
		   ps.setString(1,bo.geteName());
			ps.setString(2, bo.getDesg());
			ps.setFloat(3,bo.getBasicSalary());
			ps.setFloat(4, bo.getGrossSalary());
			ps.setFloat(5, bo.getNetSalary());
			 result=ps.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
			System.out.println("EmployeeDAOIMP.insertEmployee()1");
			throw se;
		}catch(Exception e) {
		   System.out.println("EmployeeDAOIMP.insertEmployee()2");
			e.printStackTrace();
			throw e;
		}
		return result;
	}
	
	
	
	
	
	
//	@Override
//	public Integer insertEmployee(EmployeeBO bo) throws Exception {
//	Connection con=null;
//	try {
//		con=ds.getConnection();
//		ps=con.prepareStatement(EMP_INSERT_QUERY);
//		
//		ps.setString(1,bo.geteName());
//		ps.setString(2, bo.getDesg());
//		ps.setFloat(3,bo.getBasicSalary());
//		ps.setFloat(4, bo.getGrossSalary());
//		ps.setFloat(5, bo.getNetSalary());
//		 result=ps.executeUpdate();
//		
//		
//		
//	}catch(SQLException se) {
//		se.printStackTrace();
//		throw se;
//	}catch(Exception e) {
//		e.printStackTrace();
//		throw e;
//	}
//	finally{
//		try {
//		if(ps!=null) {
//			ps.close();
//		}
//		
//	  }catch(SQLException se) {
//		  se.printStackTrace();
//	  }
//		try {
//			if(con!=null) {
//				con.close();
//			} 
//		}catch(SQLException co) {
//			  co.printStackTrace();
//		  }
//	}
//		return null;
//	}

}
