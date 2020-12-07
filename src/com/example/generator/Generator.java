package com.example.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import com.example.db.Database;

public class Generator {
	private String[] bloodTypes = {"O+", "O-", "A+", "A-", "B+", "AB+", "AB-"};
	private String[] sexList = {"Female", "Male"};
	private	String[] unitList = {"CCU","ER", "ICU", "MICU", "NICU", "Oncology", "Open-Heart Recovery", "OR", "PACU", "Hospice", "PICU", "Pre-Op", "Rehabilitation", "SICU", 
			"Step-Down Unit", "The Floor", "TICU"};
	private int height;
	private int weight;
	private String sex;
	private String result;
	private  String result2;
	private Random rand;
	private Scanner input;
	private Scanner input2;

	String[] names;
	public Generator() {
		names = new String[2];
		
		//Name files
		File file = new File("File");
		File file2 = new File("File2");
		File file3 = new File("File3");
		File file4 = new File("File4");
	
	
		Database db = new Database();
	
		
		try {
			 input = new Scanner(file);
			 input2 = new Scanner(file2);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int gender= 0;
		 rand = new Random();
		
		for(int i = 0; i< 100; i++) {
			String ohip = "";
			
			//Creating the ohip number
			for(int j=0; j<10; j++) {
			ohip = ohip+rand.nextInt(10);	
			}
			
		//Generate demographics
		if(gender == 0) {
			String name = input.nextLine();
			names =name.split(" ");
			int blood = rand.nextInt(7);
			 height = rand.nextInt(3)+5;
			 weight = rand.nextInt(200)+90;
			int resultUnit = rand.nextInt(17);
		 sex =	sexList[0];
		 result = bloodTypes[blood];
		 result2 = unitList[resultUnit];
		}else {
			String name = input2.nextLine();
			names =name.split(" ");
		int blood = rand.nextInt(7);
		 height = rand.nextInt(3)+5;
		 weight = rand.nextInt(200)+90;
		 sex =	sexList[1];
		 result = bloodTypes[blood];	
		int resultUnit = rand.nextInt(17);
		 result2 = unitList[resultUnit];
		}
		
		if(gender == 0) {
			gender =1;
			}else {
			gender=0;
			}
	
		//Creating address
		String address = cities() + " "+ postal();
	
		String[] send  = new String[13];
		
		//Setting attributes
		send[1] = names[0];
		send[2] = names[1];
		send[3] = ohip;
		send[4] = DOB();
		send[5] = sex;
		send[6] = String.valueOf(height);
		send[7] = String.valueOf(weight);
		send[8] = result;
		send[9] = address;
		send[10] = "Admit";
		send[11] = result2;
		send[12] = "";
		db.createPatient(send);
		}
	
		try {
		 input = new Scanner(file3);
		 input2 = new Scanner(file4);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
		//Creating staff members
		for(int i = 0; i < 50; i++) {
		String name = input.nextLine();
		String[]names =name.split(" ");
		String send[] = new String[3];
		send[0] = names[0];
		send[1] = names[1];
		send[2] = "Nurse";
		
		String name2 = input2.nextLine();
		String []names2 =name2.split(" ");
		String send2[] = new String[3];
		send2[0] = names2[0];
		send2[1] = names2[1];
		send2[2] = "Physician";
		
		
		db.createStaff(send2);
		}
		input.close();
		input2.close();
	}
	
	
	/**
	 * Creating postal codes
	 * @return postal code
	 */
	public String postal() {
		int temp = 0;
		Random rand = new Random();
		String[] number = new String[3];
		char[] letter = new char[3];	
		
		number[0] =  String.valueOf(rand.nextInt(9));
		number[1] =  String.valueOf(rand.nextInt(9));
		number[2] =  String.valueOf(rand.nextInt(9));
	
		 letter[0] = (char) (rand.nextInt(26)+65);
		 letter[1] = (char) (rand.nextInt(26)+65);
		 letter[2] = (char) (rand.nextInt(26)+65);
	
		 String result = letter[0]+number[0]+letter[1]+number[1]+letter[2]+number[2];
		 
		 return result;
	}
	
	/**
	 * Choosing a city from the file
	 * @return City
	 */
	public String cities() {
		File file = new File("Cities");
		try {
			Scanner scan = new Scanner(file);
			String[] cities = new String[53];
			
			for(int i = 0; i < 53; i++) {
				
				String temp = scan.nextLine();
				cities[i] = temp;
			}
			
			Random rand = new Random();
			
			int random = rand.nextInt(53);
			
			int number = rand.nextInt(9)+1;
			
			String result = cities[random];
			
			return number + " " + result;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
	
	/**
	 * Creating date of birth
	 * @return Date of Birth
	 */
	public String DOB() {
		
		Random rand = new Random();
		String num[] = new String[10];
		
		 num[0] = String.valueOf(1);
		 num[1] = String.valueOf(9);
		 num[2] = String.valueOf(rand.nextInt(45)+50);
		 num[3] = String.valueOf(rand.nextInt(12)+1);
		 num[4] = String.valueOf(rand.nextInt(30)+1);

		 if(Integer.parseInt(num[3]) < 10) {
			 num[3] = "0"+num[3];
		 }
		
		 if(Integer.parseInt(num[4]) < 10) {
			 num[4] = "0"+num[4];
		 }
		 
		 String result = num[0]+num[1]+num[2] + "-" + num[3] + "-"+num[4];
		 
		 
		return result;
		
	}
	
	
}
