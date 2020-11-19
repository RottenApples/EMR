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
		public void App(String att[]) {
			

			  CallableStatement stmt;
			try {
				
 				stmt = conn.prepareCall("{CALL Appointment(?,?,?,?)}");
				stmt.setTimestamp(1, java.sql.Timestamp.valueOf(att[0]));
				stmt.setTimestamp(2, java.sql.Timestamp.valueOf(att[1]));
				stmt.setInt(3, Integer.valueOf(att[2]));
				stmt.setInt(4, Integer.valueOf(att[3]));

				ResultSet rs = stmt.executeQuery();
		      

		        
		        rs.close();
		        stmt.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
		}
		
		public String[] getPatientDemographic(int id) {
			String[] patient = null; 
			  CallableStatement stmt;
			try {
				
 				stmt = conn.prepareCall("{CALL GetPatientDemographic(?)}");
 				stmt.setInt(1, id);
				
				ResultSet rs = stmt.executeQuery();
		      
						
				
				patient = new String[8];
						        if(rs.next()) {
		        	patient[0] = rs.getString(1);
		        	patient[1] =rs.getString(2);
		        	patient[2] =rs.getString(3);
		        	patient[3] =rs.getString(4);
		        	patient[4] =rs.getString(5);
		        	patient[5] =rs.getString(6);
		        	patient[6] =rs.getString(7);
		        	patient[7] =rs.getString(8);
		        	
		        }

			
			

		        
		        rs.close();
		        stmt.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
		        
			
			
			return patient;
			
		}
		
		
		
		
		public String[] getBloodTest(int id) {
			String[] test = null; 
			  CallableStatement stmt;
			try {
				
 				stmt = conn.prepareCall("{CALL GetBloodTest(?)}");
 				stmt.setInt(1, id);
				
				ResultSet rs = stmt.executeQuery();
				
				test = new String[7];
						        if(rs.next()) {
		        	test[0] = rs.getString(1);
		        	test[1] =rs.getString(2);
		        	test[2] =rs.getString(3);
		        	test[3] =rs.getString(4);
		        	test[4] =rs.getString(5);
		        	test[5] =rs.getString(6);
		        	test[6] =rs.getString(7);
		        	
		        }

     rs.close();
		        stmt.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
		   
			return test;
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		public String[][] getLocationPatient(int id) {
			int row = getLocationPatientCount(id);
			String[][] patient = null; 
			  CallableStatement stmt;
			try {
				
 				stmt = conn.prepareCall("{CALL GetLocationPatient(?)}");
 				stmt.setInt(1, id);
				
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
		
		public int getLocationPatientCount(int id) {
			  CallableStatement stmt;
			  String result = "";
			try {
				
 				stmt = conn.prepareCall("{CALL GetLocationPatientCount(?)}");
 				stmt.setInt(1, id);
				
				ResultSet rs = stmt.executeQuery();
		      
						
				
				
		        if(rs.next()) {
		        	result = rs.getString(1);
		
		        	
		        }

				
			

		        
		        rs.close();
		        stmt.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
		        
			return Integer.parseInt(result);
		}
		
		public String[][] getApp(String start, String end) {
			String result = AppCount(start, end);
			int row = Integer.parseInt(result);
			String[][] patient = null; 
			  CallableStatement stmt;
			try {
				
 				stmt = conn.prepareCall("{CALL GetApp(?,?)}");
				stmt.setTimestamp(1, java.sql.Timestamp.valueOf(start));
				stmt.setTimestamp(2, java.sql.Timestamp.valueOf(end));
	
				ResultSet rs = stmt.executeQuery();
		        
						
				patient = new String[row][5];
				for(int i=0; i < row; i++) {
		        if(rs.next()) {
		        	patient[i][0] = rs.getString(1);
		        	patient[i][1] =rs.getString(2);
		        	patient[i][2] =rs.getString(3);
		          	patient[i][3] = rs.getString(4);
		        	patient[i][4] =rs.getString(5);
		        
		        	
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
	
		
		public String AppCount(String start, String end) {
			String count = "";
			  CallableStatement stmt;
			try {
			
				stmt = conn.prepareCall("{CALL AppCount(?,?)}");
				stmt.setTimestamp(1, java.sql.Timestamp.valueOf(start));
				stmt.setTimestamp(2, java.sql.Timestamp.valueOf(end));

				ResultSet rs = stmt.executeQuery();
		        
						
				
				for(int i=0; i < 1; i++) {
		        if(rs.next()) {
		        	count = rs.getString(1);
		 
		        
		        	
		        }

				}

		        
		        rs.close();
		        stmt.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			return count;
		}
		
		public String[] getName(int id){
			
			String[][] patient = new String[1][2];
			  CallableStatement stmt;
			try {
 				stmt = conn.prepareCall("{CALL GetPatientName(?)}");
				stmt.setInt(1, id);

				ResultSet rs = stmt.executeQuery();
		        
						
	
				
		        if(rs.next()) {
		        	patient[0][0] = rs.getString(1);
		        	patient[0][1] =rs.getString(2);
		        	
		        }


		        
		        rs.close();
		        stmt.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
		        
			
			String[] patient2 = new String[2];
			patient2[0]= patient[0][0];
			patient2[1]= patient[0][1];
			return patient2;
			
			
		}
		
		
		public void deleteLocationPatient(int id) {
			  CallableStatement stmt;
			try {
				
 				stmt = conn.prepareCall("{CALL DeleteLocationPatient(?)}");
 				stmt.setInt(1, id);
				
 				stmt.executeQuery();
        
		        stmt.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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

			stmt2 =	conn.prepareCall("{call LastIndex()}");
			
			ResultSet rs = stmt2.executeQuery();
			

			while(rs.next()) {
				
				att[0] = rs.getString(1);
			}
			
			
			
		         createDemographics(att);
		         createADT(att);
		       
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
				
				stmt1 = conn.prepareCall("CALL LastIndex()");
				

				
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
					stmt2.setTimestamp(2, java.sql.Timestamp.valueOf(stamp));
					stmt2.setNull(3, java.sql.Types.TIMESTAMP);
					stmt2.setNull(4, java.sql.Types.TIMESTAMP);
					stmt2.setString(5,att[12]);
					stmt2.setString(6,result);
					stmt2.setString(7,result2);
					stmt2.execute();


			

					}
					if(att[10].equals("Transfer")) {
						stmt2 = conn.prepareCall("CALL CreateADT(?,?,?,?,?,?,?)");

						stmt2.setString(1, att[10]);
						stmt2.setNull(2, java.sql.Types.TIMESTAMP);
						stmt2.setTimestamp(3, java.sql.Timestamp.valueOf(stamp));
						stmt2.setNull(4, java.sql.Types.TIMESTAMP);
						stmt2.setString(5,att[12]);
						stmt2.setString(6,result);
						stmt2.setString(7,result2);
						stmt2.execute();

						

					}
					if(att[10].equals("Discharge")) {
						stmt2 = conn.prepareCall("CALL CreateADT(?,?,?,?,?,?,?)");

						
						stmt2.setString(1, att[10]);
						stmt2.setNull(2, java.sql.Types.TIMESTAMP);
						stmt2.setNull(3, java.sql.Types.TIMESTAMP);
						stmt2.setTimestamp(4, java.sql.Timestamp.valueOf(stamp));
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
		public void createADT(String PatientID, String adt, String unit){
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
				stmt.setString(1, unit);
				
				
				 ResultSet rs = stmt.executeQuery();
				  if(rs.next()) {
				        result=rs.getString(1);
				        
				        }
			
				if(adt == "Admit") {
					stmt2 = conn.prepareCall("CALL CreateADT(?,?,?,?,?,?,?)");
					stmt2.setString(1, adt);
					stmt2.setTimestamp(2, java.sql.Timestamp.valueOf(stamp));
					stmt2.setNull(3, java.sql.Types.TIMESTAMP);
					stmt2.setNull(4, java.sql.Types.TIMESTAMP);
					stmt2.setString(5, null);
					stmt2.setString(6,result);
					stmt2.setString(7,PatientID);
					stmt2.execute();


			

					}
					if(adt == "Transfer") {

						stmt2 = conn.prepareCall("CALL CreateADT(?,?,?,?,?,?,?)");

						stmt2.setString(1, adt);
						stmt2.setNull(2, java.sql.Types.TIMESTAMP);
						stmt2.setTimestamp(3, java.sql.Timestamp.valueOf(stamp));
						stmt2.setNull(4, java.sql.Types.TIMESTAMP);
						stmt2.setString(5, null);
						stmt2.setString(6,result);
						stmt2.setString(7,PatientID);
						stmt2.execute();
						UpdateLocation(PatientID, result);
						

					}
					if(adt == "Discharge") {
						stmt2 = conn.prepareCall("CALL CreateADT(?,?,?,?,?,?,?)");

						
						stmt2.setString(1, adt);
						stmt2.setNull(2, java.sql.Types.TIMESTAMP);
						stmt2.setNull(3, java.sql.Types.TIMESTAMP);
						stmt2.setTimestamp(4, java.sql.Timestamp.valueOf(stamp));
						stmt2.setString(5,null);
						stmt2.setString(6,result);
						stmt2.setString(7, PatientID);
						stmt2.execute();


					}
		
					rs.close();
		     
		       
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}
		
		public void UpdateLocation(String patientID, String locationID) {
	
	
			CallableStatement stmt;

				try {
				stmt = conn.prepareCall("CALL UpdateLocation(?,?)");
				stmt.setInt(1, Integer.parseInt(patientID));
				stmt.setInt(2, Integer.parseInt(locationID));

				
				stmt.executeQuery();
			
				
				stmt.close();
		     
		       
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
			
			 deleteLocationPatient(id);
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
		
		public String getLocationID(String name) {
			String location = "";
			  CallableStatement stmt;
			try {
				
				stmt = conn.prepareCall("{CALL GetLocationID(?)}");
				stmt.setString(1, name);
				
				ResultSet rs = stmt.executeQuery();
		        
						
				
			
				
		        if(rs.next()) {
		        	location = rs.getString(1);
		        	
		        }

				
			

		        
		        rs.close();
		        stmt.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return location;
		}
		
		public String getLocationName(int id) {
			
			String name = "";
			String location = "";
			  CallableStatement stmt;
			try {
				
				stmt = conn.prepareCall("{CALL GetLocationName(?,?)}");
				stmt.setInt(1, id);
				stmt.setString(2, name);
				
				ResultSet rs = stmt.executeQuery();
		        
						
				
			
				
		        if(rs.next()) {
		        	location = rs.getString(1);
		        	
		        }

				
			

		        
		        rs.close();
		        stmt.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return location;
		
		}
		
		public String getLatestLocation(int id) {
			String location = "";
			  CallableStatement stmt;
			try {
				
				stmt = conn.prepareCall("{CALL GetLatestLocation(?)}");
				stmt.setInt(1, id);
				
				ResultSet rs = stmt.executeQuery();
		        
		        if(rs.next()) {
		        	location = rs.getString(1);
		        	
		        }

		  
		        rs.close();
		        stmt.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return location;
			
			
		}
		
		
		

		
		public String[][] getPatient() {
			int row = getPatientCount();
			String[][] patient = null; 
			  CallableStatement stmt;
			try {
				
 				stmt = conn.prepareCall("{CALL GetPatient()}");

				
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

		
		public String[][] getPatient(int Location) {
			int row = getPatientCount();
			String[][] patient = null; 
			  CallableStatement stmt;
			try {
				
 				stmt = conn.prepareCall("{CALL GetPatient()}");
		
				
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

		
	
		
		
		public String[][] getPhysician() {
			int row = getPhysicianCount();
			String[][] staff = null; 
			
			  CallableStatement stmt;
			try {
				
				stmt = conn.prepareCall("{CALL GetPhysician()}");
								
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
		
		public String[][] getNurse() {
			int row = getNurseCount();
			String[][] staff = null; 
			
			  CallableStatement stmt;
			try {
				
				stmt = conn.prepareCall("{CALL GetNurse()}");
								
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
				
				stmt = conn.prepareCall("{CALL GetPrescription(?)}");
			
				stmt.setInt(1, id);
				
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
				stmt = conn.prepareCall("{CALL GetDemographics()}");
				
				
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
				stmt = conn.prepareCall("CALL PatientCount()");
				
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
		
		public int getPhysicianCount() {
			int row = 0;
			
		   CallableStatement stmt;
			try {
				stmt = conn.prepareCall("CALL PhysicianCount()");
			
				
				
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
		
		public int getNurseCount() {
			int row = 0;
			
		   CallableStatement stmt;
			try {
				stmt = conn.prepareCall("CALL NurseCount()");
			
				
				
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
				stmt = conn.prepareCall("CALL PrescriptionCount(?)");
				stmt.setInt(1, id);
								
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
				
				stmt = conn.prepareCall("CALL GetADT(?)");
			

				stmt.setInt(1, id);
			
				stmt.execute();
				
				
				ResultSet rs = stmt.executeQuery();
		        
				
				adt = new String[row][7];
				for(int i=0; i < row; i++) {
		        if(rs.next()) {
		        	adt[i][0] = rs.getString(1);
		        	adt[i][1] =rs.getString(2);
		        	adt[i][2] =rs.getString(3);
		        	adt[i][3] = rs.getString(4);
		        	adt[i][4] =rs.getString(5);
		        	adt[i][5] =rs.getString(6);
		        	adt[i][6] =rs.getString(7);

		        	
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
				stmt = conn.prepareCall("CALL ADTCount(?)");
				stmt.setInt(1, id);

				
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
		
		public void deletePhysician(int id) {
			
			 
		
			  CallableStatement stmt;
			try {
				stmt = conn.prepareCall("CALL DeletePhysician(?)");
				stmt.setInt(1, id);
				stmt.execute();
			

			

		        
		        stmt.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}
		
		
		public void deleteNurse(int id) {
			
			 
			
			  CallableStatement stmt;
			try {
				stmt = conn.prepareCall("CALL DeleteNurse(?)");
				stmt.setInt(1, id);
				stmt.execute();
			

			

		        
		        stmt.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
}