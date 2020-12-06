package com.example.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Database {
	
	private static final String PASSWORD = "xyz555";
	private static final String CONN_STRING = "jdbc:mysql://localhost:3306/test";
	private static final String USERNAME = "martin";
	private String textField;
	private Connection connection;
	
		public Database() {
			
			
		connection = null;

		   try {
		        
		        connection = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
		        System.out.println("Connected");
		        
		      
		        
		    }catch (SQLException e){
		    System.err.println(e);
		    }
		  
		}
		
		/**
		 * Procedure for creating appointments
		 * @param att appointment times, patient name, appointment type and physician name
		 */
		public void App(String att[]) {
			

			  CallableStatement procedure;
			try {
				
 				procedure = connection.prepareCall("{CALL Appointment(?,?,?,?,?)}");
				procedure.setTimestamp(1, java.sql.Timestamp.valueOf(att[0]));
				procedure.setTimestamp(2, java.sql.Timestamp.valueOf(att[1]));
				procedure.setInt(3, Integer.valueOf(att[2]));
				procedure.setString(4, att[3]);
				procedure.setString(5, att[4]);

				ResultSet result = procedure.executeQuery();
		      

		        
		        result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
		}
		
		/**
		 * Procedure for removing scheduled appointments
		 * @param id Patient ID
		 */
		public void removeApp(int id) {
			

			  CallableStatement procedure;
			try {
				
				procedure = connection.prepareCall("{CALL RemoveApp(?)}");
				procedure.setInt(1, id);
				

				ResultSet result = procedure.executeQuery();
		      

		        
		        result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
		}
		
		
		
		/**
		 * Procedure for getting patient demographics
		 * @param id Patient ID
		 * @return Resulting demographics
		 */
		public String[] getPatientDemographic(int id) {
			String[] patient = null; 
			  CallableStatement procedure;
			try {
				
 				procedure = connection.prepareCall("{CALL GetPatientDemographic(?)}");
 				procedure.setInt(1, id);
				
				ResultSet result = procedure.executeQuery();
		      
						
				
				patient = new String[8];
						        if(result.next()) {
		        	patient[0] = result.getString(1);
		        	patient[1] =result.getString(2);
		        	patient[2] =result.getString(3);
		        	patient[3] =result.getString(4);
		        	patient[4] =result.getString(5);
		        	patient[5] =result.getString(6);
		        	patient[6] =result.getString(7);
		        	patient[7] =result.getString(8);
		        	
		        }

			
			

		        
		        result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
		        
			
			
			return patient;
			
		}
		
		
		
		/**
		 * Procedure call for creating patient procedures
		 * @param att Procedure name, Patient name, Physician name 
		 */
		public void createProcedure(String att[]) {
			
			
			CallableStatement procedure;
			try {
			procedure =	connection.prepareCall("{CALL CreateTreatment(?,?,?)}");
			procedure.setString(1, att[0]);
			procedure.setInt(2, Integer.parseInt(att[1]));
			procedure.setInt(3, Integer.parseInt(att[2]));
	
			System.out.println(att[0] + " " + att[1]);
			procedure.execute();	

		

		
		       
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}					
			
		}
		
		
		/**
		 * Procedure for creating blood tests
		 * @param att Blood test details
		 */
		public void createBloodTest(String att[]) {
			
			
			CallableStatement procedure;
			try {
			procedure =	connection.prepareCall("{CALL CreateBloodTest(?,?,?,?,?,?)}");
			procedure.setString(1, att[0]);
			procedure.setString(2, att[1]);
			procedure.setString(3, att[2]);
			procedure.setString(4, att[3]);
			procedure.setString(5, att[4]);
			procedure.setString(6, att[5]);
			
			procedure.execute();	

		

		
		       
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}					
			
		}
		
		
		/**
		 * Procedure for creating urine tests
		 * @param att Urine test details
		 */
		public void createUrineTest(String att[]) {
			
			
			CallableStatement procedure;
			try {
			procedure =	connection.prepareCall("{CALL CreateUrineTest(?,?,?,?,?,?,?,?,?,?,?)}");
			procedure.setString(1, att[0]);
			procedure.setString(2, att[1]);
			procedure.setString(3, att[2]);
			procedure.setString(4, att[3]);
			procedure.setString(5, att[4]);
			procedure.setString(6, att[5]);
			procedure.setString(7, att[6]);
			procedure.setString(8, att[7]);
			procedure.setString(9, att[8]);
			procedure.setString(10, att[9]);
			procedure.setString(11, att[10]);
			procedure.execute();	

		

		
		       
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}					
			
		}
		
		
		/**
		 * Procedure for retrieving blood test results for a given patient
		 * @param id Patient ID
		 * @return Blood Test details
		 */
		public String[][] getBloodTest(int id) {
			int row = getBloodCount(id);
				String[][] test = null; 
			  CallableStatement procedure;
			try {
 				procedure = connection.prepareCall("{CALL GetBloodTest(?)}");
 				procedure.setInt(1, id);
				
				ResultSet result = procedure.executeQuery();
				
				test = new String[row][8];
				
				for(int i =0; i< row; i++) {
				if(result.next()) {
		        	test[i][0] = result.getString(1);
		        	test[i][1] =result.getString(2);
		        	test[i][2] =result.getString(3);
		        	test[i][3] =result.getString(4);
		        	test[i][4] =result.getString(5);
		        	test[i][5] =result.getString(6);
		        	test[i][6] =result.getString(7);
		        	test[i][7] =result.getString(8);

		        }
				}
			    result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
		   
			return test;
			
		}
		
		/**
		 * Procedure for retrieving the number of blood test for a patient
		 * @param id patient id
		 * @return number of blood tests
		 */
		public int getBloodCount(int id) {
			  CallableStatement procedure;
			  String result2 = "";
			try {
				
 				procedure = connection.prepareCall("{CALL GetBloodCount(?)}");
 				procedure.setInt(1, id);
				
				ResultSet result = procedure.executeQuery();
		      
		        if(result.next()) {
		        	result2 = result.getString(1);
		
		        	
		        }

		        result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        if(result2 == "") {result2="0";}
			return Integer.parseInt(result2);
		}
		
		/**
		 * Searches for patients in a given location
		 * @param id Location ID
		 * @return Location ID, patient id, ohip number
		 */
		public String[][] getSearch(int id) {
			int row = getSearchCount(id);
			String[][] patient = null; 
			  CallableStatement procedure;
			try {
				
 				procedure = connection.prepareCall("{CALL GetSearch(?)}");
 				procedure.setInt(1, id);
				
				ResultSet result = procedure.executeQuery();
		      
						
				
				patient = new String[row][3];
				for(int i=0; i < row; i++) {
		        if(result.next()) {
		        	patient[i][0] = result.getString(1);
		        	patient[i][1] =result.getString(2);
		        	patient[i][2] =result.getString(3);
		        

		        }

				}
			

		        
		        result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
		        
			
			
			return patient;
			
		}
		
		/**
		 * Number of search results for a given location
		 * @param id Location ID
		 * @return number of patients
		 */
		public int getSearchCount(int id) {
			  CallableStatement procedure;
			  String result2 = "";
			try {
				
				procedure = connection.prepareCall("{CALL GetSearchCount(?)}");
				procedure.setInt(1, id);
				
				ResultSet result = procedure.executeQuery();
		      
						
				
				
		        if(result.next()) {
		        	result2 = result.getString(1);
		
		        	
		        }

				
			

		        
		        result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
		        
			return Integer.parseInt(result2);
		}
		
		
		/**
		 * Searches for the location of the patient based on the ohip number
		 * @param id Patient Ohip
		 * @return Location ID
		 */
		public int getSearchLocation(String id) {
			  CallableStatement procedure;
			  String result2 = "";
			try {
				
				procedure = connection.prepareCall("{CALL GetSearchLocation(?)}");
				procedure.setString(1, id);
				
				ResultSet result = procedure.executeQuery();
		      
						
				
				
		        if(result.next()) {
		        	result2 = result.getString(1);
		
		        	
		        }

				
			

		        
		        result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
		        
			return Integer.parseInt(result2);
		}
		
		/**
		 * Get all patients in a given location
		 * @param id Location ID
		 * @return list of patients
		 */
		public String[][] getLocationPatient(int id) {
			int row = getLocationPatientCount(id);
			String[][] patient = null; 
			  CallableStatement procedure;
			try {
				
 				procedure = connection.prepareCall("{CALL GetLocationPatient(?)}");
 				procedure.setInt(1, id);
				
				ResultSet result = procedure.executeQuery();
		      
						
				
				patient = new String[row][4];
				for(int i=0; i < row; i++) {
		        if(result.next()) {
		        	patient[i][0] = result.getString(1);
		        	patient[i][1] =result.getString(2);
		        	patient[i][2] =result.getString(3);
		        	patient[i][3] =result.getString(4);

		        }

				}
			

		        
		        result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
		        
			
			
			return patient;
			
		}
		
		
		/**
		 * Number of patients in a given location
		 * @param id Location id
		 * @return number of patients
		 */
		public int getLocationPatientCount(int id) {
			  CallableStatement procedure;
			  String result2 = "";
			try {
				
 				procedure = connection.prepareCall("{CALL GetLocationPatientCount(?)}");
 				procedure.setInt(1, id);
				
				ResultSet result = procedure.executeQuery();
		      
						
				
				
		        if(result.next()) {
		        	result2 = result.getString(1);
		
		        	
		        }

				
			

		        
		        result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
		        
			return Integer.parseInt(result2);
		}
		
		/**
		 * Getting all the appointments scheduled for a given day
		 * @param start Starting timestamp
		 * @param end Ending timestamp
		 * @return Appointments
		 */
		public String[][] getApp(String start, String end) {
			String result2= AppCount(start, end);
			int row = Integer.parseInt(result2);
			String[][] patient = null; 
			  CallableStatement procedure;
			try {
				
 				procedure = connection.prepareCall("{CALL GetApp(?,?)}");
				procedure.setTimestamp(1, java.sql.Timestamp.valueOf(start));
				procedure.setTimestamp(2, java.sql.Timestamp.valueOf(end));
	
				ResultSet result = procedure.executeQuery();
		        
						
				patient = new String[row][6];
				for(int i=0; i < row; i++) {
		        if(result.next()) {
		        	patient[i][0] = result.getString(1);
		        	patient[i][1] =result.getString(2);
		        	patient[i][2] =result.getString(3);
		          	patient[i][3] = result.getString(4);
		        	patient[i][4] =result.getString(5);
		        	patient[i][5] =result.getString(6);
		        	
		        }

				}
			

		        
		        result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return patient;
		}
	
		/**
		 * Getting the number of appointments in a given day
		 * @param start Starting timestamp
		 * @param end Ending timestamp
		 * @return Number of appointments
		 */
		public String AppCount(String start, String end) {
			String count = "";
			  CallableStatement procedure;
			try {
			
				procedure = connection.prepareCall("{CALL AppCount(?,?)}");
				procedure.setTimestamp(1, java.sql.Timestamp.valueOf(start));
				procedure.setTimestamp(2, java.sql.Timestamp.valueOf(end));

				ResultSet result = procedure.executeQuery();
		        
						
				
				for(int i=0; i < 1; i++) {
		        if(result.next()) {
		        	count = result.getString(1);
		 
		        
		        	
		        }

				}

		        
		        result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			return count;
		}
		
		/**
		 * Getting the patient name
		 * @param id Patient ID
		 * @return Patient ID, first name, last name
		 */
		public String[] getName(int id){
			
			String[] patient = new String[2];
			  CallableStatement procedure;
			try {
 				procedure = connection.prepareCall("{CALL GetPatientName(?)}");
				procedure.setInt(1, id);

				ResultSet result = procedure.executeQuery();
		        
						
	
				
		        if(result.next()) {
		        	patient[0] = result.getString(1);
		        	patient[1] =result.getString(2);
		        	
		        }


		        
		        result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
		        
			
			
			return patient;
			
			
		}
		
		
		/**
		 * Getting the name of the physician
		 * @param id physician id
		 * @return Physician ID, First name, last name
		 */
	public String[] getPhysicianName(int id){
			
			String[] physician = new String[2];
			  CallableStatement procedure;
			try {
 				procedure = connection.prepareCall("{CALL GetPhysicianName(?)}");
				procedure.setInt(1, id);

				ResultSet result = procedure.executeQuery();
		        
						
	
				
		        if(result.next()) {
		        	physician[0] = result.getString(1);
		        	physician[1] =result.getString(2);
		        	
		        }


		        
		        result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
		  
			return physician;
			
			
		}
		
		
		/**
		 * Deletes the location entry for a given patient
		 * @param id Patient ID
		 */
		public void deleteLocationPatient(int id) {
			  CallableStatement procedure;
			try {
				
 				procedure = connection.prepareCall("{CALL DeleteLocationPatient(?)}");
 				procedure.setInt(1, id);
				
 				procedure.executeQuery();
        
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
		}
		
		
		/**
		 * Creates a patient
		 * @param att patient demographics
		 */
		public void createPatient(String[] att) {
		
		
			CallableStatement procedure, procedure2;
			String sql;
			try {
			procedure =	connection.prepareCall("CALL CreatePatient(?,?)");
			procedure.setString(1, att[1]);
			procedure.setString(2, att[2]);
			procedure.execute();	

			procedure2 =	connection.prepareCall("{call LastIndex()}");
			
			ResultSet result = procedure2.executeQuery();
			

			while(result.next()) {
				
				att[0] = result.getString(1);
			}
			
			
			
		         createDemographics(att);
		         createADT(att);
		       
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
		}
		
		/**
		 * Creates the demographics entry for a patient
		 * @param att patient demographics
		 */
		public void createDemographics(String att[]) {
			CallableStatement procedure;
			try {
			procedure =	connection.prepareCall("CALL CreateDemographic(?,?,?,?,?,?,?,?)");
			procedure.setString(1, att[0]);
			procedure.setString(2, att[3]);
			procedure.setString(3, att[4]);
			procedure.setString(4, att[5]);
			procedure.setString(5, att[6]);
			procedure.setString(6, att[7]);
			procedure.setString(7, att[8]);
			procedure.setString(8, att[9]);
			procedure.execute();	

		

		
		       
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}						
			
		}
		
		
		/**
		 * Creates the adt entry for a patient
		 * @param att ADT attributes
		 */
		public void createADT(String att[]){
			/*
			 * att[10] - adt 
			 * att[11] -	unit
			 */
		

			

			String result3 = ""; 
			String result4 = "";
			
	
			CallableStatement procedure, procedure2, procedure3;

				try {

				procedure = connection.prepareCall("CALL GetLocationID(?)");
				procedure.setString(1, att[11]);
				
				procedure2 = connection.prepareCall("CALL LastIndex()");
				

				
				 ResultSet result = procedure.executeQuery();
				 ResultSet result2 = procedure2.executeQuery();
				  if(result.next()) {
				        result3=result.getString(1);
				        
				        }
				  if(result2.next()) {
				     result4 = result2.getString(1);
				        }
		     
				if(att[10].equals("Admit")) {
					procedure3 = connection.prepareCall("CALL CreateADT(?,?,?,?)");
					procedure3.setString(1, att[10]);
					procedure3.setString(2,att[12]);
					procedure3.setString(3,result3);
					procedure3.setString(4,result4);
					procedure3.execute();

					createLocationPatient(result4, result3);

			

					}
					if(att[10].equals("Transfer")) {
						procedure3 = connection.prepareCall("CALL CreateADTTransfer(?,?,?,?)");

						procedure3.setString(1, att[10]);
						procedure3.setString(2,att[12]);
						procedure3.setString(3,result3);
						procedure3.setString(4,result4);
						procedure3.execute();

						

					}
					if(att[10].equals("Discharge")) {
						procedure3 = connection.prepareCall("CALL CreateADTDischarge(?,?,?,?)");

						
						procedure3.setString(1, att[10]);
						procedure3.setString(2,att[12]);
						procedure3.setString(3,result3);
						procedure3.setString(4,result4);
						procedure3.execute();


					}
		
					result.close();
			        result2.close();
		     
		       
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}
		
		/**
		 * Creates ADT entry for a given patient
		 * @param PatientID Patient ID
		 * @param adt adt status
		 * @param unit the ward
		 */
		public void createADT(String PatientID, String adt, String unit){
		
			

			String result3 = ""; 
			String result4 = "";
			
	
			CallableStatement procedure, procedure2, procedure3;

				try {

				procedure = connection.prepareCall("CALL GetLocationID(?)");
				procedure.setString(1, unit);
				
				
				 ResultSet result = procedure.executeQuery();
				  if(result.next()) {
				        result3=result.getString(1);
				        
				        }
			
				if(adt == "Admit") {
					procedure3 = connection.prepareCall("CALL CreateADT(?,?,?,?)");
					procedure3.setString(1, adt);
					procedure3.setString(2, null);
					procedure3.setString(3,result3);
					procedure3.setString(4,PatientID);
					procedure3.execute();

			

					}
					if(adt == "Transfer") {

						procedure3 = connection.prepareCall("CALL CreateADTTransfer(?,?,?,?)");

						procedure3.setString(1, adt);
						procedure3.setString(2, null);
						procedure3.setString(3,result3);
						procedure3.setString(4,PatientID);
						procedure3.execute();
						UpdateLocation(PatientID, result3);
						

					}
					if(adt == "Discharge") {
						procedure3 = connection.prepareCall("CALL CreateADTDischarge(?,?,?,?)");

						
						procedure3.setString(1, adt);
						procedure3.setString(2,null);
						procedure3.setString(3,result3);
						procedure3.setString(4, PatientID);
						procedure3.execute();
						deletePatient(Integer.parseInt(PatientID));

					}
		
					result.close();
		     
		       
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}
		
		/**
		 * Creates the location patient entry for a given patient
		 * @param patientID Patient ID
		 * @param locationID Location ID
		 */
		public void createLocationPatient(String patientID, String locationID){
			CallableStatement procedure;

				try {
				procedure = connection.prepareCall("CALL createLocationPatient(?,?)");
				procedure.setInt(1, Integer.parseInt(patientID));
				procedure.setInt(2, Integer.parseInt(locationID));

				
				procedure.executeQuery();
			
				
				procedure.close();
		     
		       
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}
		
		/**
		 * Updates the location of the patient
		 * @param patientID
		 * @param locationID
		 */
		public void UpdateLocation(String patientID, String locationID) {
	
	
			CallableStatement procedure;

				try {
				procedure = connection.prepareCall("CALL UpdateLocation(?,?)");
				procedure.setInt(1, Integer.parseInt(patientID));
				procedure.setInt(2, Integer.parseInt(locationID));

				
				procedure.executeQuery();
			
				
				procedure.close();
		     
		       
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}
			
	
		
		/**
		 * Creates a staff member
		 * @param att First name, last name, staff member type
		 */
		public void createStaff(String[] att) {
	

				try {
				CallableStatement procedure; 
		
				if(att[2].equals("Physician")) {
					procedure = connection.prepareCall("CALL CreatePhysician(?,?)");
					procedure.setString(1, att[0]);
					procedure.setString(2, att[1]);
					procedure.execute();
				}
				else {
					procedure = connection.prepareCall("CALL CreateNurse(?,?)");
					procedure.setString(1, att[0]);
					procedure.setString(2, att[1]);
					procedure.execute();
				}
		     
		       
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
		}
		
		/**
		 * Creates a prescription entry
		 * @param att Prescription name, dosage, number of refills, prescription directions, patient id, physician id
		 */
		public void createPrescription(String[] att) {
			
			CallableStatement procedure;
			try {
				procedure = connection.prepareCall("CALL CreatePrescription(?,?,?,?,?,?)");
				procedure.setString(1, att[0]);
				procedure.setString(2, att[1]);
				procedure.setString(3, att[2]);
				procedure.setString(4, att[3]);
				procedure.setString(5, att[4]);
				procedure.setString(6, att[5]);

				procedure.execute();
		        
		        
		        
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
		
		/**
		 * Deletes a patient
		 * @param id Patient ID
		 */
		public void deletePatient(int id) {
			
			 deleteLocationPatient(id);
			  CallableStatement procedure;
			try {
				
				procedure = connection.prepareCall("CALL DeletePatient(?)");
				procedure.setInt(1, id);
				procedure.execute();

			

		        
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		/**
		 * Gets the location id for a given location
		 * @param name Location Name
		 * @return Location ID
		 */
		public String getLocationID(String name) {
			String location = "";
			  CallableStatement procedure;
			try {
				
				procedure = connection.prepareCall("{CALL GetLocationID(?)}");
				procedure.setString(1, name);
				
				ResultSet result = procedure.executeQuery();
		        
						
				
			
				
		        if(result.next()) {
		        	location = result.getString(1);
		        	
		        }

				
			

		        
		        result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return location;
		}
		
		/**
		 * Gets the location name for a given location
		 * @param id Location ID
		 * @return The name of the location
		 */
		public String getLocationName(int id) {
			
			String name = "";
			String location = "";
			  CallableStatement procedure;
			try {
				
				procedure = connection.prepareCall("{CALL GetLocationName(?,?)}");
				procedure.setInt(1, id);
				procedure.setString(2, name);
				
				ResultSet result = procedure.executeQuery();
		        
						
				
			
				
		        if(result.next()) {
		        	location = result.getString(1);
		        	
		        }

				
			

		        
		        result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return location;
		
		}
		
		/**
		 * Gets the most up to date location of a given patient
		 * @param id Patient ID
		 * @return Location ID
		 */
		public String getLatestLocation(int id) {
			String location = "";
			  CallableStatement procedure;
			try {
				
				procedure = connection.prepareCall("{CALL GetLatestLocation(?)}");
				procedure.setInt(1, id);
				
				ResultSet result = procedure.executeQuery();
		        
		        if(result.next()) {
		        	location = result.getString(1);
		        	
		        }

		  
		        result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return location;
			
			
		}
		
		
		/**
		 * Gets the total dosage of prescriptions administered to a patient
		 * @param id patient id
		 * @return sum of the dosages
		 */
		public String TotalDosage(int id) {
			String sum = "";
			  CallableStatement procedure;
			try {
				
				procedure = connection.prepareCall("{CALL TotalDosage(?)}");
				procedure.setInt(1, id);
				
				ResultSet result = procedure.executeQuery();
		        
		        if(result.next()) {
		        	sum = result.getString(1);
		        	
		        }

		  
		        result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return sum;
			
			
		}
		
		/**
		 * Gets all the active patients in the hospital
		 * @return List of all active patients
		 */
		public String[][] getPatient() {
			int row = getPatientCount();
			String[][] patient = null; 
			  CallableStatement procedure;
			try {
				
 				procedure = connection.prepareCall("{CALL GetPatient()}");

				
				ResultSet result = procedure.executeQuery();
		        
						
				
				patient = new String[row][3];
				for(int i=0; i < row; i++) {
		        if(result.next()) {
		        	patient[i][0] = result.getString(1);
		        	patient[i][1] =result.getString(2);
		        	patient[i][2] =result.getString(3);
		        	
		        }

				}
			

		        
		        result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
		        
			
			
			return patient;
		}

		/**
		 * Gets all the active patients in a given ward
		 * @param Location Location ID
		 * @return List of patients
		 */
		public String[][] getPatient(int Location) {
			int row = getPatientCount();
			String[][] patient = null; 
			  CallableStatement procedure;
			try {
				
 				procedure = connection.prepareCall("{CALL GetPatient()}");
		
				
				ResultSet result = procedure.executeQuery();
		        
						
				
				patient = new String[row][3];
				for(int i=0; i < row; i++) {
		        if(result.next()) {
		        	patient[i][0] = result.getString(1);
		        	patient[i][1] =result.getString(2);
		        	patient[i][2] =result.getString(3);
		        	
		        }

				}
			

		        
		        result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
		        
			
			
			return patient;
		}

		
	
		
		/**
		 * Get all the physicians in the hospital
		 * @return List of all physicians
		 */
		public String[][] getPhysician() {
			int row = getPhysicianCount();
			String[][] staff = null; 
			
			  CallableStatement procedure;
			try {
				
				procedure = connection.prepareCall("{CALL GetPhysician()}");
								
				ResultSet result = procedure.executeQuery();
		        
						
				
				staff = new String[row][3];
				for(int i=0; i < row; i++) {
		        if(result.next()) {
		        	staff[i][0] = result.getString(1);
		        	staff[i][1] =result.getString(2);
		        	staff[i][2] =result.getString(3);
		        	
		        }

				}
			

		        
		        result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
		        
			
			
			return staff;
		}
		
		/**
		 * Get all the nurses in a given hospital
		 * @return List of all the nurses
		 */
		public String[][] getNurse() {
			int row = getNurseCount();
			String[][] staff = null; 
			
			  CallableStatement procedure;
			try {
				
				procedure = connection.prepareCall("{CALL GetNurse()}");
								
				ResultSet result = procedure.executeQuery();
		        
						
				
				staff = new String[row][3];
				for(int i=0; i < row; i++) {
		        if(result.next()) {
		        	staff[i][0] = result.getString(1);
		        	staff[i][1] =result.getString(2);
		        	staff[i][2] =result.getString(3);
		        	
		        }

				}
			

		        
		        result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
		        
			
			
			return staff;
		}
		
		
		/**
		 * Get all the prescriptions for a given patient
		 * @param id Patient ID
		 * @return List of prescriptions
		 */
		public String[][] getPrescription(int id) {
			int row = getPrescriptionCount(id);
			String[][] prescription = null; 
			 CallableStatement procedure;
			try {
				
				procedure = connection.prepareCall("{CALL GetPrescription(?)}");
			
				procedure.setInt(1, id);
				
				ResultSet result = procedure.executeQuery();
		        
						
				
				prescription = new String[row][6];
				for(int i=0; i < row; i++) {
		        if(result.next()) {
		        	prescription[i][0] = result.getString(1);
		        	prescription[i][1] =result.getString(2);
		        	prescription[i][2] =result.getString(3);
		        	prescription[i][3] = result.getString(4);
		        	prescription[i][4] =result.getString(5);
		        	prescription[i][5] =result.getString(6);
		        }

				}
			

		        
		        result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      
			return prescription;
		}
		
		/**
		 * Get all prescriptions given in a hospital
		 * @return List of prescriptions
		 */
		public String[][] getAllPrescriptions() {
			int row = getPrescriptionCount();
			String[][] prescription = null; 
			 CallableStatement procedure;
			try {
				
				procedure = connection.prepareCall("{CALL GetAllPrescriptions()}");
							
				ResultSet result = procedure.executeQuery();					
				
				prescription = new String[row][8];
				for(int i=0; i < row; i++) {
		        if(result.next()) {
		        	prescription[i][0] = result.getString(1);
		        	prescription[i][1] =result.getString(2);
		        	prescription[i][2] =result.getString(3);
		        	prescription[i][3] = result.getString(4);
		        	prescription[i][4] =result.getString(5);
		        	prescription[i][5] =result.getString(6);
		        	prescription[i][6] =result.getString(7);
		        	prescription[i][7] =result.getString(8);

		        }

				}
			

		        
		        result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      
			return prescription;
		}
		
		
		/**
		 * Get the urine tests for a given patient
		 * @param id Patient ID
		 * @return list of urine tests for a patient
		 */
		public String[][] getUrineTest(int id) {
			int row = getUrineCount(id);
				String[][] test = null; 
			  CallableStatement procedure;
			try {
 				procedure = connection.prepareCall("{CALL GetUrineTest(?)}");
 				procedure.setInt(1, id);
				
				ResultSet result = procedure.executeQuery();
				
				test = new String[row][13];
				
				for(int i =0; i< row; i++) {
				if(result.next()) {
		        	test[i][0] = result.getString(1);
		        	test[i][1] =result.getString(2);
		        	test[i][2] =result.getString(3);
		        	test[i][3] =result.getString(4);
		        	test[i][4] =result.getString(5);
		        	test[i][5] =result.getString(6);
		        	test[i][6] =result.getString(7);
		        	test[i][7] =result.getString(8);
		        	test[i][8] =result.getString(9);
		        	test[i][9] =result.getString(10);
		        	test[i][10] =result.getString(11);
		        	test[i][11] =result.getString(12);
		        	test[i][12] =result.getString(13);
		        	

		        }
				}
			    result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
		   
			return test;
			
		}
		
		
		/**
		 * Get the number of urine test for a given patient
		 * @param id patient id
		 * @return the number of tests
		 */
		public int getUrineCount(int id) {
			  CallableStatement procedure;
			  String result2 = "";
			try {
				
 				procedure = connection.prepareCall("{CALL GetUrineCount(?)}");
 				procedure.setInt(1, id);
				
				ResultSet result = procedure.executeQuery();
		      
		        if(result.next()) {
		        	result2 = result.getString(1);
		
		        	
		        }

		        result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        if(result2 == "") {result2="0";}
			return Integer.parseInt(result2);
			
		}
		
		/**
		 * Delete a prescriptions
		 * @param id Prescription ID
		 */
		public void deletePrescription(int id) {
			
			 deleteLocationPatient(id);
			  CallableStatement procedure;
			try {
				
				procedure = connection.prepareCall("CALL DeletePrescription(?)");
				procedure.setInt(1, id);
				procedure.execute();

			

		        
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
		/**
		 * Get all demographics for all patients
		 * @return List of demographics for all patients
		 */
		public String[][] getDemographics() {
			int row = getPatientCount();
			String[][] patient = null; 
			  CallableStatement procedure;
			try {
				procedure = connection.prepareCall("{CALL GetDemographics()}");
				
				
				ResultSet result = procedure.executeQuery();
		     
				
				
				patient = new String[row][7];
				for(int i=0; i < row; i++) {
		        if(result.next()) {
		        	patient[i][0] =result.getString(2);
		        	patient[i][1] =result.getString(3);
		        	patient[i][2] =result.getString(4);
		        	patient[i][3] =result.getString(5);
		        	patient[i][4] =result.getString(6);
		        	patient[i][5] =result.getString(7);
		        	patient[i][6] =result.getString(8);
		        	
		        }

				}
			

		        
		        result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
		        
			
			
			return patient;
		}
		

		
		/**
		 * Get the number of patients in a hospital
		 * @return Number of all patients
		 */
		public int getPatientCount() {
			int row = 0;
			
			
			  CallableStatement procedure;
			try {
				procedure = connection.prepareCall("CALL PatientCount()");
				
				ResultSet result = procedure.executeQuery();
				
				if(result.next()) {
			        row = Integer.parseInt(result.getString(1));
			        }
				
				

		        
		        result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
			return row;
		}
		
		/**
		 * Get the number of physicians in a hospital
		 * @return Number of physicians
		 */
		public int getPhysicianCount() {
			int row = 0;
			
		   CallableStatement procedure;
			try {
				procedure = connection.prepareCall("CALL PhysicianCount()");
			
				
				
				ResultSet result = procedure.executeQuery();
				
				if(result.next()) {
			        row = Integer.parseInt(result.getString(1));
			        }
				
				

		        
		        result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
			return row;
		}
		
		/**
		 * Get the number of nurses in a hospital
		 * @return Number of nurses
		 */
		public int getNurseCount() {
			int row = 0;
			
		   CallableStatement procedure;
			try {
				procedure = connection.prepareCall("CALL NurseCount()");
			
				
				
				ResultSet result = procedure.executeQuery();
				
				if(result.next()) {
			        row = Integer.parseInt(result.getString(1));
			        }
				
				

		        
		        result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
			return row;
		}	
		
		/**
		 * Get the number of prescriptions given in a hospital
		 * @return number of prescriptions
		 */
		public int getPrescriptionCount() {
			int row = 0;
			
			
			  CallableStatement procedure;
			try {
				procedure = connection.prepareCall("CALL GetPrescriptionCount()");

				ResultSet result = procedure.executeQuery();
				
				if(result.next()) {
			        row = Integer.parseInt(result.getString(1));
			        }
				
				

		        
		        result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
			return row;
		}
		
		
		/**
		 * Get the number of prescriptions given to a patient
		 * @param id Patient ID
		 * @return number of prescriptions
		 */
		public int getPrescriptionCount(int id) {
			int row = 0;
			
			
			  CallableStatement procedure;
			try {
				procedure = connection.prepareCall("CALL PrescriptionCount(?)");
				procedure.setInt(1, id);
								
				ResultSet result = procedure.executeQuery();
				
				if(result.next()) {
			        row = Integer.parseInt(result.getString(1));
			        }
				
				

		        
		        result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
			return row;
		}
		
		
		
		/**
		 * Get the adt status list of for a given patient
		 * @param id Patient ID
		 * @return List of adt's
		 */
		public String[][] getADT(int id) {
			
			int row = getADTCount(id);
			String[][] adt = null; 
			  CallableStatement procedure;
			try {
				
				procedure = connection.prepareCall("CALL GetADT(?)");
			

				procedure.setInt(1, id);
			
				procedure.execute();
				
				
				ResultSet result = procedure.executeQuery();
		        
				
				adt = new String[row][7];
				for(int i=0; i < row; i++) {
		        if(result.next()) {
		        	adt[i][0] = result.getString(1);
		        	adt[i][1] =result.getString(2);
		        	adt[i][2] =result.getString(3);
		        	adt[i][3] = result.getString(4);
		        	adt[i][4] =result.getString(5);
		        	adt[i][5] =result.getString(6);
		        	adt[i][6] =result.getString(7);

		        	
		        }

				}
			

		        
		        result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
			return adt;
		}
		
		/**
		 * Get the number of adt's for a given patient
		 * @param id Patient ID
		 * @return number of adt's
		 */
		public int getADTCount(int id) {
			int row = 0;
			
			
			 CallableStatement procedure;
			try {
				procedure = connection.prepareCall("CALL ADTCount(?)");
				procedure.setInt(1, id);

				
				ResultSet result = procedure.executeQuery();
				
				if(result.next()) {
			        row = Integer.parseInt(result.getString(1));
			        }
				
				

		        
		        result.close();
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
			return row;
		}
		
		/**
		 * Delete Physician
		 * @param id Physician ID
		 */
		public void deletePhysician(int id) {
			
			 
		
			  CallableStatement procedure;
			try {
				procedure = connection.prepareCall("CALL DeletePhysician(?)");
				procedure.setInt(1, id);
				procedure.execute();
			

			

		        
		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}
		
		/**
		 * Delete nurse
		 * @param id Nurse id
		 */
		public void deleteNurse(int id) {
			
			 
			
			  CallableStatement procedure;
			try {
				procedure = connection.prepareCall("CALL DeleteNurse(?)");
				procedure.setInt(1, id);
				procedure.execute();
			

			

		        procedure.close();
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
}