/*
  * @author: Martin Clement
 */
package com.example.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

import com.example.db.Database;

public class GUI implements ActionListener, KeyListener{
private Database db;	
	
private JFrame frame;
private JPanel infoPanel, adtPanel, testPanel, historyDisplay, infoDisplay, statusDisplay, staffPanel, prescriptionPanel, listPanel;
private String searchName;
private JTextField firstName, lastName, ohip, address, street, city, postal, date, height, weight, prescription, allergy, surgical, obsteric, family, immunization,
preName, preDosage, physicianFirst, physicianLast, preRefill, preDirect, searchBar;
private JLabel firstLabel, lastLabel, sexLabel, ohipLabel, addressLabel, streetLabel, cityLabel, postalLabel, dateLabel, heightLabel , weightLabel, 
 adtLabel, unitLabel, infoLabel, statusLabel,
staffLabel, staffTitle, preNameLabel, preDosageLabel, physicianFirstLabel, physicianLastLabel, preRefillLabel, preDirectLabel;
private JButton createPatient, createStaff, createPrescription;	
private JMenuBar menuBar;
private JMenu menuFile, menuEdit;
private JMenuItem menuNewPatient, menuNewPrescription, menuNewTest, menuNewStaff, menuOpen, menuSave, menuExit, menuChange;
private JTabbedPane tab; 
private JComboBox sex, adt, physician, nurse, unit, staff;
private LineBorder border;
private	String[] adtList = {"Admit", "Discharge", "Transfer"};
private	String[] unitList = {"CCU","ER", "ICU", "MICU", "NICU", "Oncology", "Open-Heart Recovery", "OR", "PACU", "Hospice", "PICU", "Pre-Op", "Rehabilitation", "SICU", 
				"Step-Down Unit", "The Floor", "TICU"};
private String[] staffList = {"Nurse", "Physician"};
private String[] infoResult, statusResult;
private JPanel list;
private JTextArea reason;
private JLabel bloodLabel, reasonLabel;
private JTextField bloodType;

private JScrollPane scroll;
private String[] sexList = {"","Female", "Male"};

	public GUI(Database db) {
	this.db = db;
		
		 infoResult = new String[8]; 
		 statusResult = new String[4]; 

		
		
		//Initialize GUI
		frame = new JFrame();
		infoPanel = new JPanel();
		infoDisplay = new JPanel();
		adtPanel = new JPanel();
		statusDisplay = new JPanel();
		testPanel = new JPanel();
	    
	    
	    border = new LineBorder(Color.BLACK, 1);
	    
	    
	    
//	    scroll = new JScrollPane(comment, 
//	    		JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    
	    
	    
		
	    menuBar = new JMenuBar();
		menuFile = new JMenu("File");
		menuEdit = new JMenu("Edit");
		menuNewPatient = new JMenuItem("New Patient");
		menuNewStaff = new JMenuItem("New Medical Staff");
		menuNewPrescription = new JMenuItem("New Prescription");
		menuNewTest = new JMenuItem("New Lab Test");
		menuOpen = new JMenuItem("Open");
		menuSave = new JMenuItem("Save");
		menuExit = new JMenuItem("Exit");
		menuChange = new JMenuItem("Edit Patient");


		
		sex = new JComboBox(sexList);
		
		staffPanel = new JPanel();
		staffPanel.setVisible(false);
		staffPanel.setLayout(null);
		testPanel = new JPanel();
		testPanel.setVisible(false);
		testPanel.setLayout(null);
		prescriptionPanel = new JPanel();
		prescriptionPanel.setVisible(false);
		prescriptionPanel.setLayout(null);
		
		tab = new JTabbedPane();
		tab.setVisible(false);
		frame.setLayout(null);

		infoPanel.setLayout(null);
		infoDisplay.setLayout(null);
		adtPanel.setLayout(null);
		statusDisplay.setLayout(null);
		
		
		//Menu
		menuBar.setSize(1280,30);
		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		menuFile.add(menuNewPatient);
		menuFile.add(menuNewStaff);
		menuFile.add(menuNewPrescription);
		menuFile.add(menuNewTest);
		menuFile.add(menuOpen);
		menuFile.add(menuSave);
		menuFile.add(menuExit);
		menuEdit.add(menuChange);
		frame.add(menuBar);
		
		
/*
 *****************************Info Panel*********************************************		
 */
		firstName = new JTextField();
	    lastName = new JTextField();
	    ohip = new JTextField();
	    address = new JTextField();
	    street = new JTextField();
	    city = new JTextField();
	    postal = new JTextField();
	    date = new JTextField();
	    height = new JTextField();
	    weight = new JTextField();
	    createPatient = new JButton("Create Patient");
	    bloodType = new JTextField();
	    bloodLabel = new JLabel("Blood Type");
		

	    firstLabel = new JLabel("First Name");
	    lastLabel = new JLabel("Last Name");
	    sexLabel = new JLabel("Sex");
	    ohipLabel = new JLabel("OHIP No.");
	    addressLabel = new JLabel("Adress No.");
	    streetLabel = new JLabel("Street");
	    cityLabel = new JLabel("City");
	    postalLabel = new JLabel("Postal Code");
	    dateLabel = new JLabel("YYYY-MM-DD");
	    heightLabel = new JLabel("Height (Imperial)");
	    weightLabel = new JLabel("Weight (Imperial, lbs)");
	  
		//Set Bounds
		infoDisplay.setBounds(600, 50,500,500);
		firstLabel.setBounds(30, 50, 70, 20);
		firstName.setBounds(30, 70, 160, 20);
		lastLabel.setBounds(250, 50, 70, 20);
		lastName.setBounds(250, 70, 160, 20);
		sexLabel.setBounds(30, 100, 80, 20);
		sex.setBounds(30, 120, 80, 20);
		ohipLabel.setBounds(250,100, 80, 20);
		ohip.setBounds(250, 120, 160, 20);
		heightLabel.setBounds(430,100, 150, 20);
		height.setBounds(430, 120, 160, 20);
		weightLabel.setBounds(430,200, 150, 20);
		weight.setBounds(430, 220, 160, 20);
		dateLabel.setBounds(430,50, 80, 20);
		date.setBounds(430, 70, 100, 20);
		addressLabel.setBounds(30,200, 80, 20);
		address.setBounds(30, 220, 20, 20);
		streetLabel.setBounds(250,200, 80, 20);
		street.setBounds(250, 220, 160, 20);
		cityLabel.setBounds(30,260, 80, 20);
		city.setBounds(30, 280, 160, 20);
		postalLabel.setBounds(250,260, 80, 20);
		postal.setBounds(250, 280, 160, 20);
		bloodType.setBounds(430,280,160,20);
		bloodLabel.setBounds(430,260,160,20);
		createPatient.setBounds(400,400,200, 30);
		
		
		//Adding components	
		infoDisplay.setBorder(border);
	//	infoPanel.add(infoDisplay);
	
		infoPanel.add(sexLabel);
		infoPanel.add(sex);
		infoPanel.add(ohipLabel);
		infoPanel.add(ohip);
		infoPanel.add(address);
		infoPanel.add(street);
		infoPanel.add(city);
		infoPanel.add(postal);
		infoPanel.add(addressLabel);
		infoPanel.add(streetLabel);
		infoPanel.add(cityLabel);
		infoPanel.add(postalLabel);
		infoPanel.add(dateLabel);
		infoPanel.add(date);
		infoPanel.add(heightLabel);
		infoPanel.add(height);
		infoPanel.add(weightLabel);
		infoPanel.add(weight);
		infoPanel.add(bloodType);
		infoPanel.add(bloodLabel);
		infoPanel.add(createPatient);
//******************************************************************************
		
		
		
		
		
/*
 *************************Status Panel*******************************************		
 */
		
		 statusLabel = new JLabel("<html>ADT: "  + "<br/><br/>" + "Unit: " +"</html>");
		 statusDisplay.setBorder(border);
		 adt = new JComboBox(adtList);
		 unit = new JComboBox(unitList);
		 reason = new JTextArea();
		 reasonLabel = new JLabel("Reason: ");
		 
		 adt.setSelectedIndex(-1);
		 unit.setSelectedIndex(-1);
			 
		 adtLabel = new JLabel("ADT");
		 unitLabel = new JLabel("Unit");
	
	
		adtPanel.add(adtLabel);
		adtPanel.add(unitLabel);
		adtPanel.add(adt);
		adtPanel.add(unit);
		adtPanel.add(reason);
		adtPanel.add(reasonLabel);

	
		
		//Setting Bounds
		statusLabel.setBounds(10,-170,500,500);
		adtLabel.setBounds(30, 50, 70, 20);
		adt.setBounds(30, 70, 160, 20);
		unitLabel.setBounds(250, 50, 70, 20);
		unit.setBounds(250, 70, 160, 20);
		reasonLabel.setBounds(600,80, 50,20);
		reason.setBounds(600,100, 500,500);

//*************************************************************************		
		
		
		
		
		

		
		
		
/*
 **********************Staff Panel********************************
 */
		createStaff = new JButton("Create Staff");
		staffTitle = new JLabel("New Staff Member");
		createStaff.setBounds(30,200,120,30);
		staffTitle.setBounds(30, 20, 150, 20);
		staffPanel.setBounds(0,30,1000,500);
		staffPanel.setBorder(border);
		staff = new JComboBox(staffList);
		staff.setSelectedIndex(-1);
		staffLabel = new JLabel("Staff");
		staffLabel.setBounds(30, 100, 80, 20);
		staff.setBounds(30, 120, 80, 20);
		staffPanel.add(staffTitle);
		staffPanel.add(staffLabel);
		staffPanel.add(staff);
		staffPanel.add(createStaff);
		
		
// ******************************************************************
 
		
		
		
		
/*
 **********************Prescription Panel****************************		
 */
		
		createPrescription = new JButton("Create Prescription");
		preName = new JTextField();
		
		physicianFirst = new JTextField();
		physicianLast = new JTextField();
		preRefill = new JTextField();
		preDirect = new JTextField();
		preDosage = new JTextField();

		
		preNameLabel = new JLabel("Prescription Name");
		preDosageLabel = new JLabel("Dosage: ");
		physicianFirstLabel = new JLabel("First Name");
		physicianLastLabel = new JLabel("Last Name");
		preRefillLabel = new JLabel("Refills: ");
		preDirectLabel = new JLabel("Directions: ");
		
		preNameLabel.setBounds(30, 50, 160, 20);
		preName.setBounds(30, 70, 160, 20);
		preDosageLabel.setBounds(250, 50, 70, 20);
		preDosage.setBounds(250, 70, 160, 20);
		physicianFirstLabel.setBounds(30, 100, 80, 20);
		physicianFirst.setBounds(30, 120, 160, 20);
		physicianLastLabel.setBounds(250,100, 80, 20);
		physicianLast.setBounds(250, 120, 160, 20);
		
		preRefillLabel.setBounds(430,100, 150, 20);
		preRefill.setBounds(430, 120, 160, 20);
		preDirectLabel.setBounds(30,160, 150, 20);
		preDirect.setBounds(30, 180, 160, 20);
		createPrescription.setBounds(30,200,200,30);
		
		prescriptionPanel.add(preName); 
		prescriptionPanel.add(preDosage); 
		prescriptionPanel.add(physicianFirst);
		prescriptionPanel.add(physicianLast);
		prescriptionPanel.add(preRefill);
		prescriptionPanel.add(preDirect);
		
		prescriptionPanel.add(preNameLabel);
		prescriptionPanel.add(preDosageLabel); 
		prescriptionPanel.add(preDosage);
		prescriptionPanel.add(physicianFirstLabel); 
		prescriptionPanel.add(physicianLastLabel); 
		prescriptionPanel.add(preRefillLabel);
		prescriptionPanel.add(preDirectLabel);
		prescriptionPanel.add(createPrescription);

//*************************************************************************
		

		
		
/*
 ****************************List Panel************************************ 		
 */
		
		listPanel = new JPanel();
		listPanel.setVisible(false);
	
		
		
		  
		
//*************************************************************************		
		
		
		
		tab.addTab("Info", infoPanel);
		tab.addTab("ADT", adtPanel);
		tab.setBounds(0,30,1280,690);
		
		prescriptionPanel.setBounds(0,30,1280,690);
		testPanel.setBounds(0,30,1280,690);

		frame.add(staffPanel);
		frame.add(tab);
		frame.add(prescriptionPanel);
		frame.add(testPanel);

		
		//Window Preferences
		frame.setTitle("Electronic Medical Records (EMR)");
		frame.setBounds(0, 0, 1200, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		//ActionListener
		menuNewPatient.addActionListener(this);
		menuNewStaff.addActionListener(this);
		menuNewPrescription.addActionListener(this);
		menuNewTest.addActionListener(this);
		menuOpen.addActionListener(this);
		menuSave.addActionListener(this);
		menuExit.addActionListener(this);
		menuChange.addActionListener(this);
		createPatient.addActionListener(this);
		createStaff.addActionListener(this);
		createPrescription.addActionListener(this);
		
	/*	
		firstName.addKeyListener(this);
		lastName.addKeyListener(this);
		date.addKeyListener(this);
		sex.addKeyListener(this);
		ohip.addKeyListener(this);
		street.addKeyListener(this);
		address.addKeyListener(this);
		city.addKeyListener(this);
		postal.addKeyListener(this);
		prescription.addKeyListener(this);
		family.addKeyListener(this);
		allergy.addKeyListener(this);
		surgical.addKeyListener(this);
		obsteric.addKeyListener(this);
		immunization.addKeyListener(this);
	*/	
		adt.addActionListener(this);
		unit.addActionListener(this);
	
	}

/*
 **************************Action Performed****************************************************
 */
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == createPatient) {
			//height fix
			
			String result[] = new String[13];
			result[1] = firstName.getText();
			result[2] = lastName.getText();
			result[3] = ohip.getText();
			result[4] = date.getText();
			result[5] = sex.getSelectedItem().toString();
			result[6] = height.getText();
			result[7] = weight.getText();
			result[8] = bloodType.getText();
			result[9] = address.getText()+" "+street.getText()+" "+city.getText()+" "+ postal.getText();
			result[10] = adt.getSelectedItem().toString();
			result[11] = unit.getSelectedItem().toString();
			result[12] = reason.getText();
			db.createPatient(result);
		}
		
		if(e.getSource() == createStaff) {
			String result[] = new String[3];
			result[0] = firstName.getText();
			result[1] = lastName.getText();
			result[2] = staff.getSelectedItem().toString();
	
		
			db.createStaff(result);
		}
		
		if(e.getSource() == createPrescription) {
			String result[] =  new String[6];
			result[0] = preName.getText(); 
			result[1] = preDosage.getText(); 
			result[2] = physicianFirst.getText(); 
			result[3] = physicianLast.getText(); 
			result[4] = preRefill.getText(); 
			result[5] = preDirect.getText(); 
			db.createPrescription(result);
			
		}
		
		if(e.getSource() == menuNewPatient) {
			tab.setVisible(true);
			staffPanel.setVisible(false);
			prescriptionPanel.setVisible(false);
			testPanel.setVisible(false);
			
			infoPanel.add(firstLabel);
			infoPanel.add(firstName);
			infoPanel.add(lastLabel);
			infoPanel.add(lastName);

			staffPanel.remove(firstLabel);
			staffPanel.remove(firstName);
			staffPanel.remove(lastLabel);
			staffPanel.remove(lastName);

		}
		
		if(e.getSource() == menuNewStaff) {
			tab.setVisible(false);
			prescriptionPanel.setVisible(false);
			testPanel.setVisible(false);
			staffPanel.setVisible(true);

			infoPanel.remove(firstLabel);
			infoPanel.remove(firstName);
			infoPanel.remove(lastLabel);
			infoPanel.remove(lastName);

			
			staffPanel.add(firstLabel);
			staffPanel.add(firstName);
			staffPanel.add(lastLabel);
			staffPanel.add(lastName);
			
			
		}
		
		if(e.getSource() == menuNewPrescription) {
			tab.setVisible(false);
			staffPanel.setVisible(false);
			prescriptionPanel.setVisible(true);
			testPanel.setVisible(false);
			
		}
		if(e.getSource() == menuNewTest) {
			tab.setVisible(false);
			staffPanel.setVisible(false);
			prescriptionPanel.setVisible(false);
			testPanel.setVisible(true);
			
		}
		
		if(e.getSource() == menuOpen) {
			
			
		}
		
		if(e.getSource() == menuSave) {
			
			
			boolean isSaved = save();
			
			if(isSaved) {JOptionPane.showConfirmDialog(null, "Record Saved Sucessful.");}
			else {JOptionPane.showConfirmDialog(null, "Failed Saved.");}
			
		}
		if(e.getSource() == menuExit) {
			System.exit(0);
		}
	
		if(e.getSource() == adt ||e.getSource() == unit ||e.getSource() == physician||e.getSource() == nurse ) {
			if(adt.getSelectedIndex() == -1) {statusResult[0] = "";}else {statusResult[0] = adt.getSelectedItem().toString();}
			if(unit.getSelectedIndex() == -1) {statusResult[1] = "";}else {statusResult[1] = unit.getSelectedItem().toString();}
	
			
			statusLabel.setText("<html>ADT: " +statusResult[0] + "<br/><br/>" + "Unit: "+statusResult[1] 
					 +"</html>");
		}
		
		
		if(e.getSource() == menuChange) {
			tab.setVisible(false);
			staffPanel.setVisible(false);
			prescriptionPanel.setVisible(false);
			testPanel.setVisible(false);
			listPanel.setVisible(true);
		}
		
		
		
	}
	
	

// *********************************************************************************************************************************************'	
 
	
	
	
	
/*
 * ***************************************************************Key Pressed********************************************************************	
 */
	
	
	public void keyTyped(KeyEvent f) {}
	public void keyReleased(KeyEvent f) {

	}
	public void keyPressed(KeyEvent f) {
	     int key = f.getKeyCode();
	     
	     if (key == KeyEvent.VK_ENTER && (f.getSource() == firstName||f.getSource() == lastName || f.getSource() == sex || f.getSource() == date || f.getSource() == ohip
	    		 ||f.getSource() == address || f.getSource() == street || f.getSource() == city || f.getSource() == postal )) { 


	    	 if(!(firstName.getText().equals(""))) {infoResult[0] = firstName.getText();}
	    	 if(!(lastName.getText().equals(""))) {infoResult[1] = lastName.getText();}
	    	 if(!(date.getText().equals(""))) {infoResult[2] = date.getText();}
	    	 if(!(ohip.getText().equals(""))) {infoResult[3] = ohip.getText();}
	    	 if(!(address.getText().equals(""))) {infoResult[4] = address.getText();}
	    	 if(!(street.getText().equals(""))) {infoResult[5] = street.getText();}
	    	 if(!(city.getText().equals(""))) {infoResult[6] = city.getText();}
	    	 if(!(postal.getText().equals(""))) {infoResult[7] = postal.getText();}
	     
	        
	     if(infoResult[0] == null) {infoResult[0] = "";}
	     if(infoResult[1] == null) {infoResult[1] = "";}
	     if(infoResult[2] == null) {infoResult[2] = "";}
	     if(infoResult[3] == null) {infoResult[3] = "";}
	     if(infoResult[4] == null) {infoResult[4] = "";}
	     if(infoResult[5] == null) {infoResult[5] = "";}
	     if(infoResult[6] == null) {infoResult[6] = "";}
	     if(infoResult[7] == null) {infoResult[7] = "";}

	     
	     	infoLabel.setText("<html>First Name: "  + infoResult[0]+ "<br/><br/>" + "Last Name: " +infoResult[1] + "<br/><br/>"  + "Date of Birth: "  +infoResult[2] +
	     			"<br/><br/>" + "Sex: " +sex.getSelectedItem() + "<br/><br/>"+ "Ohip Number: " +infoResult[3] + "<br/><br/>"+ "Address : "  + infoResult[4] +" "
	     					+ infoResult[5] +", " +infoResult[6]+", " +infoResult[7] + "</html>");


	     	firstName.setText("");
	     	lastName.setText("");
	     	date.setText("");
	     	ohip.setText("");
	     	address.setText("");
	     	street.setText("");
	     	city.setText("");
	     	postal.setText("");
	     }
	     
	     
	        
	     

	    
	  
	    
	     
	     
	     
	     
	     }



	
	

	
	public void toDisplay(String name) {
		String[] attributes = db.getPatient(name);
	}
	
	public boolean save() {
		
		if(isComplete()) {
		String[] result = new String[18];
		
		//0-7 infoPanel
		result[0] = firstName.getText();
		result[1] = lastName.getText();
		result[2] = date.getText();
		result[3] = ohip.getText();
		result[4] = address.getText();
		result[5] = street.getText();
		result[6] = city.getText();
		result[7] = postal.getText();
		
		//8-11 statusPanel
		result[8] = adt.getSelectedItem().toString();
		result[9] = unit.getSelectedItem().toString();
	
		
		//12-17 historyPanel
		result[12] = prescription.getText();
		result[13] = family.getText();
		result[14] = allergy.getText();
		result[15] = surgical.getText();
		result[16] = obsteric.getText();
		result[17] = immunization.getText();
		
		
		
		return true;
		}
			
		return false;
		
	}
	

	/*
	 * checkInfo - Verifies that the contents in the info Panel follow the proper structure
	 * @return boolean - Variable to output result
	 */
	public boolean checkInfo() {
		String[] result = new String[8];
		JTextField parameter[] = new JTextField[4];
		parameter[0] = firstName;
		parameter[1] = lastName;
		parameter[2] = street;
		parameter[3] = city;
		boolean number = false;
		
		//Length of date
		String ohipString = ohip.getText();
		int ohipNumber = 0;
		
		try {
		 ohipNumber =  (int)Integer.parseInt(ohipString);
		}catch(NumberFormatException f) {
		
		}
		if(ohipNumber == 0) {number = true;}
		
		//System.out.println(dateValue);
		//Error checking strings
		if(!number) {
		for(int i =0; i< 4; i++) {
			String input = parameter[i].getText();
			for(int j =0; j< input.length(); j++) {
				
				if(!(input.charAt(j) > 64 && input.charAt(j) < 91 || input.charAt(j) > 96 && input.charAt(j) < 123)) {
					number = true;
					break;
					
				}
			}
			
			
			if(number) {break;}
			
		}
		}
		
		
		
		
		if(!number) {	
		result[0] = firstName.getText();
		result[1] = lastName.getText();
		result[2] = sex.getSelectedItem().toString();
		result[3] = ohip.getText();
		result[4] = address.getText();
		result[5] = street.getText();
		result[6] = city.getText();
		result[7] = postal.getText();
		
		
		
		
		
		}
		else {
			JOptionPane.showMessageDialog(null, "Invalid Information");
			return false;
		}
	return true;	
	}

	/*
	 * isComplete - Verifies that all text fields are completed before creating a new record
	 * @return boolean - Returns the result
	 */
	public boolean isComplete() {
		boolean info = false;
		boolean status = false;
		boolean isComplete = false;		
		info = checkInfo();
		
		if(adt.getSelectedIndex() > -1 && unit.getSelectedIndex() > -1 && physician.getSelectedIndex() > -1 && nurse.getSelectedIndex() > -1) {
			status = true;
		}
		
	
		if(info && status) {
			isComplete = true;
		}
		
		return isComplete;
	}


	

}
