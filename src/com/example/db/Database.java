package com.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Database {
	
	private static final String PASSWORD = "xyz555";
	private static final String CONN_STRING = "jdbc:mysql://localhost:3306/test";
	private static final String USERNAME = "martin";
	private String textField;
	private Connection conn;
	
		public Database() {
			
			
		conn = null;

		   try {
		        
		        conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
		        System.out.println("Connected");
		        
		      
		        
		    }catch (SQLException e){
		    System.err.println(e);
		    }
		  
		}
		

		
		public void createPatient(String[] att) {
			/*
			 * Test
			 * result[0] - id - obtained from sql
			 * result[1] - first name
			 * result[2] - last name
			 */
			
			String sql = "INSERT INTO Patient (FirstName, LastName) VALUES ("+"'"+att[1]+"', '"+att[2]+"')";
			Statement stmt;
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				sql = "select last_insert_id()";
				 ResultSet rs = stmt.executeQuery(sql);
				  if(rs.next()) {
				        att[0]=rs.getString(1);
				        }
		        rs.close();
		        
		         createDemographics(att);
		         createADT(att);
		       
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
		}
		
		
		public void createDemographics(String att[]) {
		
			String sql = "INSERT INTO Demographics (PatientID, OHIP, DOB, Sex, Height, Weight, BloodType, Contact) VALUES ("+att[0]+", "+att[3]+", '"+ att[4]+ "', '"+ att[5] +"', '"+
																															att[6]+"', "+att[7]+", '"+ att[8] +"', '"+att[9]+"')";
			Statement stmt;
				try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sql);
		
		        
		     
		       
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
		}
		
		
		
		public void createADT(String att[]){
			/*
			 * att[10] - adt 
			 * att[11] -	unit
			 */
			String sql = "";
			String sql2 = "";
			String sql3 = "";

			
			Date date = new Date();
			long time = date.getTime();
			String stamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());		
			sql = "SELECT LocationID FROM Location WHERE LocationName ='"+ att[11] +"'";
			sql2 = "select last_insert_id()";
			String result = ""; 
			String result2 = "";
			
	
			Statement stmt, stmt1, stmt2;

				try {

				stmt = conn.createStatement();
				stmt1 = conn.createStatement();
				stmt2 = conn.createStatement();

				
				 ResultSet rs = stmt.executeQuery(sql);
				 ResultSet rs2 = stmt1.executeQuery(sql2);
				  if(rs.next()) {
				        result=rs.getString(1);
				        
				        }
				  if(rs2.next()) {
				     result2 = rs2.getString(1);
				        }
		     
				if(att[10].equals("Admit")) {
					 sql3 = "INSERT INTO ADT (ADT, AddDateTime, Reason, LocationID, PatientID) VALUES ('"+att[10]+"', '"+stamp+"', '"+ att[12] +"', "+result+ ", "+result2+")";

					}
					if(att[10].equals("Transfer")) {
						sql3 = "INSERT INTO ADT (ADT, TransDateTime, Reason, LocationID, PatientID) VALUES ('"+att[10]+"', '"+stamp+"', '" +att[12] +"', "+result+", "+result2+")";

					}
					if(att[10].equals("Discharge")) {
						sql3 = "INSERT INTO ADT (ADT, DisDateTime, Reason, LocationID, PatientID) VALUES ('"+att[10]+"', '"+stamp+ "', '"+att[12] +"', "+ result+", "+result2+")";

					}
				stmt2.executeUpdate(sql3);
		
				   rs.close();
			        rs2.close();
		     
		       
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}
		
		public void createStaff(String[] att) {
			/*
			 att[0] - Staff First Name
			 att[1] - Staff Last Name 
			 att[2] - Nurse or Physician
			*/
			String sql = "";
			if(att[2].equals("Physician")) {
		    sql = "INSERT INTO Physician (FirstName, LastName) VALUES ('"+att[0]+"', '"+att[1]+"')";
			}
			else {
				sql = "INSERT INTO Nurse (FirstName, LastName) VALUES ('"+att[0]+"', '"+att[1]+"')";
			}
			Statement stmt;

				try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sql);
		
		        
		     
		       
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
		}
		
		public void createPrescription(String[] att) {
			
			
			
			/*
			 Semifinal fields
			 atr[0] - prescription name 
			 atr[1] - dosage
			 atr[2] - physician first name
			 atr[3] - physician last name
			 atr[4] - number of refills
			 atr[5] - prescription direction
			 */
		
	
		    String sql = "INSERT INTO Prescription (PrescriptionName, Dosage, Refill, Description) VALUES ('"+att[0]+"', "+att[1]+", "+att[4]+", '"+att[5] +"')";
			Statement stmt;
			try {
				stmt = conn.createStatement();
		        stmt.executeUpdate(sql);
		        
		        
		        
		        
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
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
		
		public void getStaff() {
			
			
		}
		
		public void getPrescription() {
			
			
		}
		
	
}
