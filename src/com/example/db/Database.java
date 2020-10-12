package com.example.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
			 * flag - 0 or 1
			 */
		
			CallableStatement stmt, stmt2;
			String sql;
			try {
			stmt =	conn.prepareCall("CALL CreatePatient(?,?)");
			stmt.setString(1, att[1]);
			stmt.setString(2, att[2]);
			stmt.execute();	

			stmt2 =	conn.prepareCall("{call LastIndex(?)}");
			stmt2.registerOutParameter(1, java.sql.Types.INTEGER);
			stmt.setString(1, "@id");
			ResultSet rs = stmt2.executeQuery();
			

			while(rs.next()) {
				
				att[0] = rs.getString(1);
			}
			
			
			
		   //      createDemographics(att);
		     //    createADT(att);
		       
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
		}
		public void createDemographics(String att[]) {
			CallableStatement stmt;
			try {
			stmt =	conn.prepareCall("CALL CreateDemographic(?,?,?,?,?,?,?,?)");
			stmt.setString(1, att[0]);
			stmt.setString(2, att[3]);
			stmt.setString(3, att[4]);
			stmt.setString(4, att[5]);
			stmt.setString(5, att[6]);
			stmt.setString(6, att[7]);
			stmt.setString(7, att[8]);
			stmt.setString(8, att[9]);
			stmt.execute();	

		

		
		       
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
		

			
			Date date = new Date();
			long time = date.getTime();
			String stamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());		
			
			String result = ""; 
			String result2 = "";
			
	
			CallableStatement stmt, stmt1, stmt2;

				try {

				stmt = conn.prepareCall("CALL GetLocationID(?)");
				stmt.setString(1, att[11]);
				stmt.registerOutParameter(1, java.sql.Types.INTEGER);
				stmt.setString(1, "@id");
				
				stmt1 = conn.prepareCall("CALL LastIndex(?)");
				stmt1.registerOutParameter(1, java.sql.Types.INTEGER);
				stmt1.setString(1, "@id");
				

				
				 ResultSet rs = stmt.executeQuery();
				 ResultSet rs2 = stmt1.executeQuery();
				  if(rs.next()) {
				        result=rs.getString(1);
				        
				        }
				  if(rs2.next()) {
				     result2 = rs2.getString(1);
				        }
		     
				if(att[10].equals("Admit")) {
					stmt2 = conn.prepareCall("CALL CreateADT(?,?,?,?,?,?,?)");
					stmt2.setString(1, att[10]);
					stmt2.setString(2, stamp);
					stmt2.setString(3, null);
					stmt2.setString(4, null);
					stmt2.setString(5,att[12]);
					stmt2.setString(6,result);
					stmt2.setString(7,result2);
					stmt2.execute();


			

					}
					if(att[10].equals("Transfer")) {
						stmt2 = conn.prepareCall("CALL CreateADT(?,?,?,?,?,?,?)");

						stmt2.setString(1, att[10]);
						stmt2.setString(2, null);
						stmt2.setString(3, stamp);
						stmt2.setString(4, null);
						stmt2.setString(5,att[12]);
						stmt2.setString(6,result);
						stmt2.setString(7,result2);
						stmt2.execute();

						

					}
					if(att[10].equals("Discharge")) {
						stmt2 = conn.prepareCall("CALL CreateADT(?,?,?,?,?,?,?)");

						
						stmt2.setString(1, att[10]);
						stmt2.setString(2, null);
						stmt2.setString(3, null);
						stmt2.setString(4, stamp);
						stmt2.setString(5,att[12]);
						stmt2.setString(6,result);
						stmt2.setString(7,result2);
						stmt2.execute();


					}
		
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
	

				try {
				CallableStatement stmt; 
		
				if(att[2].equals("Physician")) {
					stmt = conn.prepareCall("CALL CreatePhysician(?,?)");
					stmt.setString(1, att[0]);
					stmt.setString(2, att[1]);
					stmt.execute();
				}
				else {
					stmt = conn.prepareCall("CALL CreateNurse(?,?)");
					stmt.setString(1, att[0]);
					stmt.setString(2, att[1]);
					stmt.execute();
				}
		     
		       
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
		}
		
		public void createPrescription(String[] att) {
			
			
			
			/*
			 Semifinal fields
			 att[0] - prescription name 
			 att[1] - dosage
			 att[2] - number of refills
			 att[3] - prescription direction
			 att[4] - patient id
			 att[5] - patient id
			 */
			
			
			Date date = new Date();
			long time = date.getTime();
			String stamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());	
		
	
		  
			CallableStatement stmt;
			try {
				stmt = conn.prepareCall("CALL CreatePrescription(?,?,?,?,?,?,?)");
				stmt.setString(1, att[0]);
				stmt.setString(2, stamp);
				stmt.setString(3, att[1]);
				stmt.setString(4, att[2]);
				stmt.setString(5, att[3]);
				stmt.setString(6, att[4]);
				stmt.setString(7, att[5]);

				stmt.execute();
		        
		        
		        
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
		public void deletePatient(int id) {
			
			 
			  CallableStatement stmt;
			try {
				
				stmt = conn.prepareCall("CALL DeletePatient(?)");
				stmt.setInt(1, id);
				stmt.execute();

			

		        
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		       
			
			
		}
		


		
		public String[][] getPatient() {
			int row = getPatientCount();
			String[][] patient = null; 
			  CallableStatement stmt;
			try {
				
 				stmt = conn.prepareCall("{CALL GetStaff(?,?,?)}");
				stmt.registerOutParameter(1, java.sql.Types.INTEGER);
				stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
				stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
				stmt.setString(1, "@PatientID");
				stmt.setString(2, "@FirstName");
				stmt.setString(3, "@LastName");
				
				ResultSet rs = stmt.executeQuery();
		        
						
				
				patient = new String[row][3];
				for(int i=0; i < row; i++) {
		        if(rs.next()) {
		        	patient[i][0] = rs.getString(1);
		        	patient[i][1] =rs.getString(2);
		        	patient[i][2] =rs.getString(3);
		        	
		        }

				}
			

		        
		        rs.close();
		        stmt.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
		        
			
			
			return patient;
		}

		
		
	
		
		
		public String[][] getStaff() {
			int row = getPatientCount();
			String[][] staff = null; 
			
			  CallableStatement stmt;
			try {
				
				stmt = conn.prepareCall("{CALL GetStaff(?,?,?)}");
				stmt.registerOutParameter(1, java.sql.Types.INTEGER);
				stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
				stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
				stmt.setString(1, "@StaffID");
				stmt.setString(2, "@FirstName");
				stmt.setString(3, "@LastName");
				
				
				ResultSet rs = stmt.executeQuery();
		        
						
				
				staff = new String[row][3];
				for(int i=0; i < row; i++) {
		        if(rs.next()) {
		        	staff[i][0] = rs.getString(1);
		        	staff[i][1] =rs.getString(2);
		        	staff[i][2] =rs.getString(3);
		        	
		        }

				}
			

		        
		        rs.close();
		        stmt.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
		        
			
			
			return staff;
		}
		
		
		public String[][] getPrescription(int id) {
			int row = getPrescriptionCount(id);
			String[][] prescription = null; 
			 CallableStatement stmt;
			try {
				
				stmt = conn.prepareCall("{CALL GetPrescription(?,?,?,?,?,?,?)}");
				stmt.registerOutParameter(2, java.sql.Types.INTEGER);
				stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
				stmt.registerOutParameter(4, java.sql.Types.DATE);
				stmt.registerOutParameter(5, java.sql.Types.INTEGER);
				stmt.registerOutParameter(6, java.sql.Types.INTEGER);
			
				
				stmt.setInt(1, id);
				stmt.setString(2, "@IDOut");
				stmt.setString(3, "@PrescriptionName");
				stmt.setString(4, "@PrescriptionDate");
				stmt.setString(5, "@Dosage");
				stmt.setString(6, "@Refill");
				stmt.setString(7, "@Direction");
				
				ResultSet rs = stmt.executeQuery();
		        
						
				
				prescription = new String[row][6];
				for(int i=0; i < row; i++) {
		        if(rs.next()) {
		        	prescription[i][0] = rs.getString(1);
		        	prescription[i][1] =rs.getString(2);
		        	prescription[i][2] =rs.getString(3);
		        	prescription[i][3] = rs.getString(4);
		        	prescription[i][4] =rs.getString(5);
		        	prescription[i][5] =rs.getString(6);
		        }

				}
			

		        
		        rs.close();
		        stmt.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
		        
			
			
			return prescription;
		}
		
		
		
		public String[][] getDemographics() {
			int row = getPatientCount();
			String[][] patient = null; 
			  CallableStatement stmt;
			try {
				stmt = conn.prepareCall("{CALL GetDemographics(?,?,?,?,?,?,?,?)}");
				stmt.registerOutParameter(1, java.sql.Types.INTEGER);
				stmt.registerOutParameter(2, java.sql.Types.INTEGER);
				stmt.registerOutParameter(3, java.sql.Types.DATE);
				stmt.registerOutParameter(4, java.sql.Types.VARCHAR);
				stmt.registerOutParameter(5, java.sql.Types.VARCHAR);
				stmt.registerOutParameter(6, java.sql.Types.INTEGER);
				stmt.registerOutParameter(7, java.sql.Types.CHAR);
				
				stmt.setString(1, "@id");
				stmt.setString(2, "@ohip");
				stmt.setString(3, "@DOB");
				stmt.setString(4, "@sex");
				stmt.setString(5, "@height");
				stmt.setString(6, "@weight");
				stmt.setString(7, "@bloodtype");
				stmt.setString(8, "@contact");
				
				
				ResultSet rs = stmt.executeQuery();
		     
				
				
				patient = new String[row][7];
				for(int i=0; i < row; i++) {
		        if(rs.next()) {
		        	patient[i][0] =rs.getString(2);
		        	patient[i][1] =rs.getString(3);
		        	patient[i][2] =rs.getString(4);
		        	patient[i][3] =rs.getString(5);
		        	patient[i][4] =rs.getString(6);
		        	patient[i][5] =rs.getString(7);
		        	patient[i][6] =rs.getString(8);
		        	
		        }

				}
			

		        
		        rs.close();
		        stmt.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
		        
			
			
			return patient;
		}
		

		
		
		public int getPatientCount() {
			int row = 0;
			
			
			  CallableStatement stmt;
			try {
				stmt = conn.prepareCall("CALL PatientCount(?)");
				stmt.registerOutParameter(1, java.sql.Types.INTEGER);
				stmt.setString(1, "@count");
				
				
				ResultSet rs = stmt.executeQuery();
				
				if(rs.next()) {
			        row = Integer.parseInt(rs.getString(1));
			        }
				
				

		        
		        rs.close();
		        stmt.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
			return row;
		}
		
		public int getStaffCount() {
			int row = 0;
			
		   CallableStatement stmt;
			try {
				stmt = conn.prepareCall("CALL StaffCount(?)");
				stmt.registerOutParameter(1, java.sql.Types.INTEGER);
				stmt.setString(1, "@count");
				
				
				ResultSet rs = stmt.executeQuery();
				
				if(rs.next()) {
			        row = Integer.parseInt(rs.getString(1));
			        }
				
				

		        
		        rs.close();
		        stmt.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
			return row;
		}
		
		public int getPrescriptionCount(int id) {
			int row = 0;
			
			
			  CallableStatement stmt;
			try {
				stmt = conn.prepareCall("CALL PrescriptionCount(?,?)");
				stmt.setInt(1, id);
				stmt.registerOutParameter(2, java.sql.Types.INTEGER);
				stmt.setString(2, "@count");
								
				ResultSet rs = stmt.executeQuery();
				
				if(rs.next()) {
			        row = Integer.parseInt(rs.getString(1));
			        }
				
				

		        
		        rs.close();
		        stmt.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
			return row;
		}
		
		public String[][] getADT(int id) {
			
			int row = getADTCount(id);
			String[][] adt = null; 
			  CallableStatement stmt;
			try {
				
				stmt = conn.prepareCall("CALL GetADT(?,?,?,?,?,?,?)");
				stmt.registerOutParameter(2, java.sql.Types.INTEGER);
				stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
				stmt.registerOutParameter(4, java.sql.Types.TIMESTAMP);
				stmt.registerOutParameter(5, java.sql.Types.TIMESTAMP);
				stmt.registerOutParameter(6, java.sql.Types.TIMESTAMP);

				stmt.setInt(1, id);
				stmt.setString(2, "@IDOut");
				stmt.setString(3, "@adt");
				stmt.setString(4, "@add");
				stmt.setString(5, "@trans");
				stmt.setString(6, "@dis");
				stmt.setString(7, "@reason");
				
				stmt.execute();
				
				
				ResultSet rs = stmt.executeQuery();
		        
				
				adt = new String[row][6];
				for(int i=0; i < row; i++) {
		        if(rs.next()) {
		        	adt[i][0] = rs.getString(1);
		        	adt[i][1] =rs.getString(2);
		        	adt[i][2] =rs.getString(3);
		        	adt[i][3] = rs.getString(4);
		        	adt[i][4] =rs.getString(5);
		        	adt[i][5] =rs.getString(6);
		        	
		        }

				}
			

		        
		        rs.close();
		        stmt.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
			return adt;
		}
		
		public int getADTCount(int id) {
			int row = 0;
			
			
			 CallableStatement stmt;
			try {
				stmt = conn.prepareCall("CALL ADTCount(?,?)");
				stmt.setInt(1, id);
				stmt.registerOutParameter(2, java.sql.Types.INTEGER);
				stmt.setString(2, "@count");
				
				ResultSet rs = stmt.executeQuery();
				
				if(rs.next()) {
			        row = Integer.parseInt(rs.getString(1));
			        }
				
				

		        
		        rs.close();
		        stmt.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
			return row;
		}
		
		public void deleteStaff(int id) {
			
			 
		
			  CallableStatement stmt;
			try {
				stmt = conn.prepareCall("CALL DeleteStaff(?)");
				stmt.setInt(1, id);
				stmt.execute();
			

			

		        
		        stmt.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
	
}
	
}