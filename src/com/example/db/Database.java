package com.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
	private static final String PASSWORD = "xyz553";
	private static final String CONN_STRING = "jdbc:mysql://localhost:3306/test";
	private String textField;
	private Connection conn;
	
		public Database() {
			textField = new String();
			
			
			
			
			
			
			
	       

		    conn = null;
/*
		   try {
		        
		      //  conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
		       // System.out.println("Connected");
		        
		      
		        
		    }catch (SQLException e){
		    System.err.println(e);
		    }
		    */
		}
		
		public void create(String[] attributes) {
			//Info query
			
			//Status query
			
			//
			
		}
		
		
		public String[] getPatient(String name) {
			
			//fix this
			String sql = "SELECT * FROM PATIENT WHERE NAME=" + name;
			  Statement stmt;
			try {
				stmt = conn.createStatement();
		        ResultSet rs = stmt.executeQuery(sql);
		        
		        if(rs.next()) {
		        System.out.println(rs.getString(3));
		        }
		        rs.close();
		        stmt.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
		        
			
			
			return null;
		}
		
		
		
	
}
