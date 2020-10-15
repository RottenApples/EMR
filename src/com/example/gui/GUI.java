/*
 * @author: Martin Clement
 */
package com.example.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;

import com.example.db.Database;

public class GUI implements ActionListener{
	private Database db;	

	private JFrame frame;
	private JPanel infoPanel, testPanel, historyDisplay, infoDisplay, statusDisplay, staffPanel, prescriptionPanel, listPatientPanel;
	private String searchName;
	private JTextField firstName, lastName, ohip, address, street, city, postal, date, height, weight, prescription, allergy, surgical, obsteric, family, immunization,
	preName, preDosage, physicianFirst, physicianLast, preRefill, preDirect, searchBar;
	private JLabel firstLabel, lastLabel, sexLabel, ohipLabel, addressLabel, streetLabel, cityLabel, postalLabel, dateLabel, heightLabel , weightLabel, 
	adtLabel, unitLabel, infoLabel, statusLabel,
	staffLabel, staffTitle, preNameLabel, preDosageLabel, physicianFirstLabel, physicianLastLabel, preRefillLabel, preDirectLabel;
	private JButton createPatient, createStaff, createPrescription;	
	private JMenuBar menuBar;
	private JMenu menuFile, menuView;
	private JMenuItem menuNewPatient, menuNewPrescription, menuNewTest, menuNewStaff, menuOpen, menuSave, menuExit, menuListPatient,
	menuListStaff, menuListPrescription;
	private JTabbedPane tab; 
	private JComboBox sex, adt, physician, nurse, unit, staff, patient, staffName, bloodType;
	private LineBorder border;
	private	String[] adtList = {"Admit", "Transfer", "Discharge"};
	private	String[] unitList = {"CCU","ER", "ICU", "MICU", "NICU", "Oncology", "Open-Heart Recovery", "OR", "PACU", "Hospice", "PICU", "Pre-Op", "Rehabilitation", "SICU", 
			"Step-Down Unit", "The Floor", "TICU"};
	private String[] staffList = {"Nurse", "Physician"};
	private String[] bloodTypes = {"O+", "O-", "A+", "A-", "B+", "AB+", "AB-"};
	private String[] infoResult, statusResult;
	private JPanel list, listStaffPanel;
	private JTextArea reason;
	private JLabel bloodLabel, reasonLabel, listLabel;
	private JTextField bloodTypeField;
	private JLabel[] listLabels, listStaffLabel, listPrescriptionLabel;
	private JButton[] deletePatient, deleteStaff, deletePrescription, detailPatient, adtPatient;
	private String resultPatient[][] = null; 
	private String resultStaff[][] = null;
	private String resultPrescription[][] = null;
	private int rowPatient = 0;
	private int rowStaff =0;
	private int rowPrescription =0;
	private JPanel detailPanel, detailPanel2, detailPanel3;
	private JTabbedPane detailTab;
	private String[][] ADT;
	private JSeparator split2;
	private JLabel[] detailLabel;
	private JScrollPane scrollPatient, scrollStaff;
	private String[] sexList = {"","Female", "Male"};
	private JLabel physicianNameLabel, patientNameLabel;
	private JComboBox adt2, unit2;
	private JButton change;
	private int patientID;
	private JButton mainNew, mainList, mainListPatient, mainListStaff, mainNewPatient, mainNewPrescription, mainNewTest, mainNewStaff;
	private JButton[] backButton;
	private JPanel mainPanel, mainPanel2, mainPanel3;

	public GUI(Database db) {
		this.db = db;

		infoResult = new String[8]; 
		statusResult = new String[4]; 

		backButton = new JButton[5];


		//Initialize GUI
		frame = new JFrame();
		infoPanel = new JPanel();
		statusDisplay = new JPanel();
		testPanel = new JPanel();


		border = new LineBorder(Color.BLACK, 1);







		menuBar = new JMenuBar();
		menuFile = new JMenu("File");
		menuView = new JMenu("View");
		menuNewPatient = new JMenuItem("New Patient");
		menuNewStaff = new JMenuItem("New Medical Staff");
		menuNewPrescription = new JMenuItem("New Prescription");
		menuNewTest = new JMenuItem("New Lab Test");
		menuOpen = new JMenuItem("Open");
		menuSave = new JMenuItem("Save");
		menuExit = new JMenuItem("Exit");
		menuListPatient = new JMenuItem("List Patients...");
		menuListStaff = new JMenuItem("List Medical Staff...");



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

		frame.setLayout(null);

		infoPanel.setLayout(null);
		statusDisplay.setLayout(null);


		//Menu
		menuBar.setSize(1280,30);
		menuBar.add(menuFile);
		menuBar.add(menuView);
		menuFile.add(menuNewPatient);
		menuFile.add(menuNewStaff);
		menuFile.add(menuNewPrescription);
		menuFile.add(menuNewTest);
		menuFile.add(menuOpen);
		menuFile.add(menuSave);
		menuFile.add(menuExit);
		menuView.add(menuListPatient);
		menuView.add(menuListStaff);

		frame.add(menuBar);

		/*
		 *******************************Main Panel*******************************************
		 */
		mainPanel = new JPanel();
		mainNew =  new JButton("Create New");
		mainList =  new JButton("View List");
		
		mainPanel.setVisible(true);
		mainPanel.setLayout(null);
		
		mainNew.setBounds(380,200,400,40);
		mainList.setBounds(380,300,400,40);
		mainPanel.setBounds(0,30,1280,690);

		mainNew.addActionListener(this);
		mainList.addActionListener(this);
		mainPanel.add(mainNew);
		mainPanel.add(mainList);
		frame.add(mainPanel);
		
		//***********************************************************************************
		
		
		
		/*
		 *******************************Main Panel2*******************************************
		 */
		mainPanel2 = new JPanel();
		mainNewPatient =  new JButton("New Patient");
		mainNewStaff =  new JButton("New Staff");
		mainNewPrescription = new JButton("New Prescription");
		mainNewTest = new JButton("New Test");
		backButton[0] = new JButton("<");
		
		mainPanel2.setVisible(false);
		mainPanel2.setLayout(null);
		
		mainNewPatient.setBounds(380,100,400,40);
		mainNewStaff.setBounds(380,200,400,40);
		mainNewPrescription.setBounds(380,300,400,40);
		mainNewTest.setBounds(380,400,400,40);
		backButton[0].setBounds(10,10,45,30);
		
		mainPanel2.setBounds(0,30,1280,690);

		mainNewPatient.addActionListener(this);
		mainNewStaff.addActionListener(this);
		mainNewPrescription.addActionListener(this);
		mainNewTest.addActionListener(this);
		backButton[0].addActionListener(this);
		
		mainPanel2.add(mainNewPatient);
		mainPanel2.add(mainNewStaff);
		mainPanel2.add(mainNewPrescription);
		mainPanel2.add(mainNewTest);
		mainPanel2.add(backButton[0]);
		frame.add(mainPanel2);
		
		//***********************************************************************************
		
		/*
		 ****************************Main Panel 3*******************************************
		 */
		
		mainPanel3 = new JPanel();
		mainPanel3.setLayout(null);
		mainPanel3.setVisible(false);
		mainPanel3.setBounds(0,30,1280,690);
		mainListPatient = new JButton("List Patients");
		mainListStaff = new JButton("List Staff");
		backButton[1] = new JButton("<");


		backButton[1].setBounds(10,10,45,30);
		mainListPatient.setBounds(380,200,400,40);
		mainListStaff.setBounds(380,300,400,40);
		mainListPatient.addActionListener(this);
		mainListStaff.addActionListener(this);
		backButton[1].addActionListener(this);
		mainPanel3.add(backButton[1]);
		mainPanel3.add(mainListPatient);
		mainPanel3.add(mainListStaff);
		frame.add(mainPanel3);
		
		
		//*********************************************************************************
		
		
		
		
		
		
		
		/*
		 *****************************Info Panel*********************************************		
		 */
		backButton[2] = new JButton("<");
		backButton[2].setBounds(10,10,45,30);
		backButton[2].addActionListener(this);
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
		bloodType = new JComboBox(bloodTypes);
		bloodType.setSelectedIndex(-1);
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

		unit = new JComboBox(unitList);
		unitLabel = new JLabel("Unit");
		reason = new JTextArea();
		reason.setBorder(border);
		reasonLabel = new JLabel("Reason: ");


		//Set Bounds
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
		createPatient.setBounds(30,400,160, 30);
		reasonLabel.setBounds(600,50, 50,20);
		reason.setBounds(600,70,500,500);
		unitLabel.setBounds(30,310, 80, 20);
		unit.setBounds(30, 330, 160, 20);


		//Adding components	
		//	infoPanel.add(infoDisplay);
		infoPanel.add(backButton[2]);
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
		infoPanel.add(reason);
		infoPanel.add(reasonLabel);
		infoPanel.add(unit);
		infoPanel.add(unitLabel);
		
		infoPanel.setVisible(false);


		unit.setSelectedIndex(-1);



		//*************************************************************************		









		/*
		 **********************Staff Panel********************************
		 */
		backButton[3] = new JButton("<");
		backButton[3].setBounds(10,10,45,30);
		backButton[3].addActionListener(this);
		createStaff = new JButton("Create Staff");
		createStaff.setBounds(30,200,120,30);
		staffPanel.setBounds(0,30,1200,650);
		staff = new JComboBox(staffList);
		staff.setSelectedIndex(-1);
		staffLabel = new JLabel("Staff");
		staffLabel.setBounds(30, 120, 80, 20);
		staff.setBounds(30, 140, 80, 20);
		staffPanel.add(staffLabel);
		staffPanel.add(staff);
		staffPanel.add(createStaff);
		staffPanel.add(backButton[3]);

		// ******************************************************************





		/*
		 **********************Prescription Panel****************************		
		 */

		backButton[4] = new JButton("<");
		backButton[4].setBounds(10,10,45,30);
		backButton[4].addActionListener(this);
		createPrescription = new JButton("Create Prescription");
		preName = new JTextField();

		physicianFirst = new JTextField();
		physicianLast = new JTextField();
		preRefill = new JTextField();
		preDirect = new JTextField();
		preDosage = new JTextField();

		String[][] tempPatient;
		tempPatient = db.getPatient();
		String name[] = new String[tempPatient.length];

		for(int i =0; i <tempPatient.length; i++){
			name[i] =tempPatient[i][0]+" "+tempPatient[i][1]+" "+tempPatient[i][2]; ;

		}

		String[][] tempStaff;
		tempStaff = db.getStaff();
		String name2[] = new String[tempStaff.length];

		for(int i =0; i <tempStaff.length; i++){
			name2[i] =tempStaff[i][0]+" "+tempStaff[i][1]+" "+tempStaff[i][2]; ;

		}






		patient = new JComboBox(name);
		staffName = new JComboBox(name2);


		preNameLabel = new JLabel("Prescription Name");
		preDosageLabel = new JLabel("Dosage: ");
		patientNameLabel = new JLabel("Patient Name: ");
		physicianNameLabel = new JLabel("Physician Name: ");
		preRefillLabel = new JLabel("Refills: ");
		preDirectLabel = new JLabel("Directions: ");

		preNameLabel.setBounds(30, 50, 160, 20);
		preName.setBounds(30, 70, 160, 20);
		preDosageLabel.setBounds(250, 50, 70, 20);
		preDosage.setBounds(250, 70, 160, 20);

		preRefillLabel.setBounds(250,100, 150, 20);
		preRefill.setBounds(250, 120, 160, 20);
		preDirectLabel.setBounds(30,100, 150, 20);
		preDirect.setBounds(30, 120, 160, 20);
		patientNameLabel.setBounds(30,160, 150, 20);
		patient.setBounds(30,180,150,20);
		physicianNameLabel.setBounds(250,150,150,30);
		staffName.setBounds(250,180,150,20);

		createPrescription.setBounds(30,220,150,30);

		prescriptionPanel.add(preName); 
		prescriptionPanel.add(preDosage); 
		prescriptionPanel.add(preRefill);
		prescriptionPanel.add(preDirect);

		prescriptionPanel.add(preNameLabel);
		prescriptionPanel.add(preDosageLabel); 
		prescriptionPanel.add(preDosage);
		prescriptionPanel.add(preRefillLabel);
		prescriptionPanel.add(preDirectLabel);
		prescriptionPanel.add(createPrescription);
		prescriptionPanel.add(patientNameLabel);
		prescriptionPanel.add(patient);
		prescriptionPanel.add(physicianNameLabel);
		prescriptionPanel.add(staffName);
		prescriptionPanel.add(backButton[4]);
		//*************************************************************************




		/*
		 ****************************List Patient Panel************************************ 		
		 */

		listPatientPanel = new JPanel();
		listPatientPanel.setLayout(null);
		listPatientPanel.setVisible(true);
		listLabel = new JLabel();
		listPatientPanel.setPreferredSize(new Dimension(1000,1200));
		scrollPatient = new JScrollPane(listPatientPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPatient.setBounds(0,30,1184,655);
		scrollPatient.setVisible(false);

		drawListPatient();

		//*************************************************************************		


		/*
		 ****************************Detail Patient Panel************************************ 		
		 */
		
		detailPanel = new JPanel();
		detailPanel.setLayout(null);
		detailPanel.setVisible(true);
		detailPanel2 = new JPanel();
		detailPanel2.setLayout(null);
		detailPanel2.setVisible(true);
		detailPanel3 = new JPanel();
		detailPanel3.setLayout(null);
		detailPanel3.setVisible(true);

		String resultDem[][] = null;

		resultDem = db.getDemographics();
		detailLabel = new JLabel[rowPatient];
		for(int i =0; i<rowPatient; i++) {
			detailLabel[i] = new JLabel("<html>"+resultPatient[i][1] + " " + resultPatient[i][2] + " <br/>OHIP: " 
					+resultDem[i][0] +" <br/>Date of Birth: "+resultDem[i][1] +" <br/>Sex: "+resultDem[i][2] +" <br/>Height: "+resultDem[i][3] +" <br/>Weight: "+resultDem[i][4] +" <br/>Blood Type: "+resultDem[i][5] 
							+" <br/>Address: " +resultDem[i][6]+"</html>");
			detailLabel[i].setBounds(30,10,1200,150);
		}






		detailTab = new JTabbedPane();	
		detailTab.addTab("Info", detailPanel);
		detailTab.addTab("Prescription History", detailPanel2);
		detailTab.addTab("ADT History", detailPanel3);
		detailTab.setBounds(0,30,1280,690);
		detailTab.setVisible(false);

		//*************************************************************************		


		/*
		 ****************************List Staff Panel************************************ 		
		 */

		listStaffPanel = new JPanel();
		listStaffPanel.setLayout(null);
		listStaffPanel.setVisible(true);
		listLabel = new JLabel();
		listStaffPanel.setPreferredSize(new Dimension(1000,1200));
		scrollStaff = new JScrollPane(listStaffPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollStaff.setBounds(0,30,1184,655);
		scrollStaff.setVisible(false);
		resultStaff = db.getStaff();
		rowStaff = db.getStaffCount();
		listStaffLabel = new JLabel[rowStaff];
		deleteStaff = new JButton[rowStaff];

		JSeparator split3 = new JSeparator();
		split3.setOrientation(SwingConstants.HORIZONTAL); 

		for(int i =0; i<rowStaff; i++) {
			deleteStaff[i] = new JButton("Delete");
			listStaffLabel[i] = new JLabel("<html> Physician: "+resultStaff[i][1] + " " + resultStaff[i][2]+"</html>");
			listStaffLabel[i].setBounds(30,30*(i+1)*2,1200,20);
			deleteStaff[i].setBounds(1000,70*(i+1)*2,80,20);
			deleteStaff[i].addActionListener(this);
			split3.setBounds(0,90*(i+1)*2,1200,10);

			listStaffPanel.add(deleteStaff[i]);
			listStaffPanel.add(listStaffLabel[i]);
			listStaffPanel.add(split3);




		}




		//*************************************************************************		







		infoPanel.setBounds(0,30,1280,690);

		prescriptionPanel.setBounds(0,30,1280,690);
		testPanel.setBounds(0,30,1280,690);

		frame.add(detailTab);
		frame.add(staffPanel);
		frame.add(infoPanel);
		frame.add(prescriptionPanel);
		frame.add(testPanel);
		frame.add(scrollPatient);
		frame.add(scrollStaff);


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
		menuListPatient.addActionListener(this);
		menuListStaff.addActionListener(this);
		createPatient.addActionListener(this);
		createStaff.addActionListener(this);
		createPrescription.addActionListener(this);
		
		
		unit.addActionListener(this);

	}

	/*
	 **************************Action Performed****************************************************
	 */


	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == mainNew) {
			mainPanel.setVisible(false);
			mainPanel2.setVisible(true);
			mainPanel3.setVisible(false);
			infoPanel.setVisible(false);
			staffPanel.setVisible(false);
			prescriptionPanel.setVisible(false);
			testPanel.setVisible(false);
			scrollStaff.setVisible(false);
			scrollPatient.setVisible(false);
			detailTab.setVisible(false);
			
		}
		if(e.getSource() == mainNewPatient) {
			menuNewPatient.doClick();
		}
		if(e.getSource() == mainNewPrescription) {
			menuNewPrescription.doClick();
		}
		if(e.getSource() == mainNewStaff) {
			menuNewStaff.doClick();
		}
		if(e.getSource() == mainNewTest) {
			menuNewTest.doClick();
		}
		if(e.getSource() == mainListPatient) {
			menuListPatient.doClick();
		}
		if(e.getSource() == mainListStaff) {
			menuListStaff.doClick();
		}
		
		
		
		
		for(int i = 0; i< 5; i++) {
		if(e.getSource() == backButton[i]) {
			mainPanel.setVisible(true);
			mainPanel2.setVisible(false);
			mainPanel3.setVisible(false);
			infoPanel.setVisible(false);
			staffPanel.setVisible(false);
			prescriptionPanel.setVisible(false);
			testPanel.setVisible(false);
			scrollStaff.setVisible(false);
			scrollPatient.setVisible(false);
			detailTab.setVisible(false);
			
		}
		}
		if(e.getSource() == mainList) {
			mainPanel.setVisible(false);
			mainPanel2.setVisible(false);
			mainPanel3.setVisible(true);
			infoPanel.setVisible(false);
			staffPanel.setVisible(false);
			prescriptionPanel.setVisible(false);
			testPanel.setVisible(false);
			scrollStaff.setVisible(false);
			scrollPatient.setVisible(false);
			detailTab.setVisible(false);
			
		}
		
		if(e.getSource() == createPatient) {
			//height fix

			try {
			String result[] = new String[13];
			result[1] = firstName.getText();
			result[2] = lastName.getText();
			result[3] = ohip.getText();
			result[4] = date.getText();
			result[5] = sex.getSelectedItem().toString();
			result[6] = height.getText();
			result[7] = weight.getText();
			result[8] = bloodType.getSelectedItem().toString();
			result[9] = address.getText()+" "+street.getText()+" "+city.getText()+" "+ postal.getText();
			result[10] = "Admit";
			result[11] = unit.getSelectedItem().toString();
			result[12] = reason.getText();
			
			if(checkInfo()){
				db.createPatient(result);
			}else {
				JOptionPane.showMessageDialog(null, "Invalid Format.");
			}
			}catch(NullPointerException f) {
				JOptionPane.showMessageDialog(null, "Invalid Format.");
			}
			
		}

		if(e.getSource() == createStaff) {
			String result[] = new String[3];
			result[0] = firstName.getText();
			result[1] = lastName.getText();
			result[2] = staff.getSelectedItem().toString();


			db.createStaff(result);
		}

		if(e.getSource() == createPrescription) {
			String tempPatientName, tempStaffName;
			tempPatientName = patient.getSelectedItem().toString();
			tempStaffName = staffName.getSelectedItem().toString();

			String temp[] = new String[3];
			String temp2[] = new String[3];

			temp =tempPatientName.split(" ");
			temp2=tempStaffName.split(" ");


			String result[] =  new String[6];
			result[0] = preName.getText(); 
			result[1] = preDosage.getText(); 
			result[2] = preRefill.getText(); 
			result[3] = preDirect.getText(); 
			result[4] =	temp[0];
			result[5] =	temp2[0];

			System.out.println(result[0]+" "+result[1]+" "+result[2]+" "+result[3]+" "+result[4]+" "+result[5]);
			db.createPrescription(result);

		}

		if(e.getSource() == menuNewPatient) {
			mainPanel.setVisible(false);
			mainPanel2.setVisible(false);
			mainPanel3.setVisible(false);
			infoPanel.setVisible(true);
			staffPanel.setVisible(false);
			prescriptionPanel.setVisible(false);
			testPanel.setVisible(false);
			scrollStaff.setVisible(false);
			scrollPatient.setVisible(false);
			detailTab.setVisible(false);

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
			mainPanel.setVisible(false);
			mainPanel2.setVisible(false);
			mainPanel3.setVisible(false);
			infoPanel.setVisible(false);
			staffPanel.setVisible(true);
			prescriptionPanel.setVisible(false);
			testPanel.setVisible(false);
			scrollStaff.setVisible(false);
			scrollPatient.setVisible(false);
			detailTab.setVisible(false);

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
			mainPanel.setVisible(false);
			mainPanel2.setVisible(false);
			mainPanel3.setVisible(false);
			infoPanel.setVisible(false);
			staffPanel.setVisible(false);
			prescriptionPanel.setVisible(true);
			testPanel.setVisible(false);
			scrollStaff.setVisible(false);
			scrollPatient.setVisible(false);
			detailTab.setVisible(false);
		}
		if(e.getSource() == menuNewTest) {
			mainPanel.setVisible(false);
			mainPanel2.setVisible(false);
			mainPanel3.setVisible(false);
			infoPanel.setVisible(false);
			staffPanel.setVisible(false);
			prescriptionPanel.setVisible(false);
			testPanel.setVisible(true);
			scrollStaff.setVisible(false);
			scrollPatient.setVisible(false);
			detailTab.setVisible(false);

		}



		if(e.getSource() == menuExit) {
			System.exit(0);
		}


		if(e.getSource() == menuListPatient) {
			mainPanel.setVisible(false);
			mainPanel2.setVisible(false);
			mainPanel3.setVisible(false);
			infoPanel.setVisible(false);
			detailTab.setVisible(false);
			staffPanel.setVisible(false);
			prescriptionPanel.setVisible(false);
			testPanel.setVisible(false);
			scrollStaff.setVisible(false);
			scrollPatient.setVisible(true);

			drawListPatient();
		}


		if(e.getSource() == menuListStaff) {
			mainPanel.setVisible(false);
			mainPanel2.setVisible(false);
			mainPanel3.setVisible(false);
			infoPanel.setVisible(false);
			detailTab.setVisible(false);
			staffPanel.setVisible(false);
			prescriptionPanel.setVisible(false);
			testPanel.setVisible(false);
			scrollPatient.setVisible(false);
			scrollStaff.setVisible(true);







		}



		for(int i =0; i< rowPatient; i++) {
			if(e.getSource() == deletePatient[i]) {

				int id =Integer.parseInt(resultPatient[i][0]);


				db.deletePatient(id);

				drawListPatient();

			}
		}	

		for(int i = 0; i< rowPatient; i++) {
			if(e.getSource() == detailPatient[i]) {

				detailPanel.removeAll();
				prescriptionPanel.removeAll();
				detailPanel3.removeAll();
				mainPanel.setVisible(false);
				mainPanel2.setVisible(false);
				mainPanel3.setVisible(false);
				infoPanel.setVisible(false);
				detailTab.setVisible(true);			
				staffPanel.setVisible(false);
				prescriptionPanel.setVisible(false);
				testPanel.setVisible(false);
				scrollPatient.setVisible(false);
				scrollStaff.setVisible(false);

				int row = db.getADTCount(Integer.parseInt(resultPatient[i][0]));

				ADT = new String[row][6];
				ADT = db.getADT(Integer.parseInt(resultPatient[i][0]));
				JLabel label2[] = new JLabel[row];



				for(int j =0; j < row; j++) {

					if(ADT[j][3] == null && ADT[j][4] == null) {
						label2[j] = new JLabel("<html>"+" ADT: "+ADT[j][1] +" <br/>Admition Date: "+ADT[j][2]+" <br/> Reason: "+ADT[j][5]+ "</html>"); 
					}

					if(ADT[j][2] == null && ADT[j][4] == null) {
						label2[j] = new JLabel("<html>"+"  ADT: "+ADT[j][1] +" <br/>Transfer Date: "+ADT[j][3]+" <br/> Reason: "+ADT[j][5]+ "</html>"); 
					}


					if(ADT[j][2] == null && ADT[j][3] == null) {
						label2[j] = new JLabel("<html>"+"  ADT: "+ADT[j][1] +" <br/>Discharge Date: "+ADT[j][4]+" <br/> Reason: "+ADT[j][5]+ "</html>"); 
					}
					JSeparator split3 = new JSeparator();
					split3.setBounds(0,(140+15*j)*(j+1),1200,20);
					split3.setOrientation(SwingConstants.HORIZONTAL); 
					label2[j].setBounds(30,(140+15*j)*(j+1),300,120);
					detailPanel3.add(label2[j]);
					detailPanel3.add(split3);

				}




				resultPrescription = db.getPrescription(i);
				rowPrescription = db.getPrescriptionCount(i);
				if(rowPrescription != 0) {
					listPrescriptionLabel = new JLabel[rowPrescription];



					listPrescriptionLabel[i] = new JLabel("<html> Prescription Name: "+resultPrescription[i][1] + " <br/> Date: " + resultPrescription[i][2] + " <br/> Dosage: " +resultPrescription[i][3] 
							+ " <br/> Refills: " + resultPrescription[i][4]+ " <br/> Description: "+resultPrescription[i][5]+"</html>");
					listPrescriptionLabel[i].setBounds(30,(140+15*i)*(i+1),300,120);
					detailPanel2.add(listPrescriptionLabel[i]);
					detailPanel2.add(split2);
					split2 = new JSeparator();
					split2.setBounds(0,(140+15*i)*(i+1),1200,20);
					split2.setOrientation(SwingConstants.HORIZONTAL); 


				}



				detailPanel.add(detailLabel[i]);


			}
		}




		for(int i = 0; i< rowPatient; i++) {
			if(e.getSource() == adtPatient[i]) {

				resultPatient = db.getPatient();


				JDialog pane = new JDialog();


				change = new JButton("Update");
				change.addActionListener(this);

				adt2 = new JComboBox(adtList);
				unit2 = new JComboBox(unitList);

				JLabel adtLabel = new JLabel("ADT: ");
				JLabel unitLabel = new JLabel("Unit: ");
				JLabel label = new JLabel("To");
				JLabel name = new JLabel(resultPatient[i][1]+ " " + resultPatient[i][2]);


				pane.add(adt2);
				pane.add(unit2);
				pane.add(adtLabel);
				pane.add(unitLabel);
				pane.add(label);
				pane.add(name);
				pane.add(change);

				pane.setLayout(null);
				pane.setVisible(true);
				pane.setResizable(false);
				pane.setLocationRelativeTo(frame);
				pane.setBounds(600,300,350,200);
				adt2.setBounds(30,80,100,20);
				unit2.setBounds(200,80,100,20);
				name.setBounds(30,0,200,20);
				adtLabel.setBounds(30,60,100,20);
				unitLabel.setBounds(200,60,100,20);
				label.setBounds(150,80,100,20);
				change.setBounds(110,110,100,20);
				pane.setTitle("ADT Status");





			}
			if(e.getSource() == change) {

				db.createADT(resultPatient[i][0].toString(), adt2.getSelectedItem().toString(), unit2.getSelectedItem().toString());

			}
		}




		for(int i =0; i< rowStaff; i++) {
			if(e.getSource() == deleteStaff[i]) {

				int id =Integer.parseInt(resultStaff[i][0]);


				db.deleteStaff(id);
			}
		}




	}



	// *********************************************************************************************************************************************'	



	public void drawListPatient() {
		listPatientPanel.removeAll();
		String resultDemographics[][] = null;
		resultPatient = db.getPatient();
		resultDemographics = db.getDemographics();
		rowPatient = db.getPatientCount();
		JSeparator[] split = new JSeparator[rowPatient];

		listLabels = new JLabel[rowPatient];
		deletePatient = new JButton[rowPatient];
		detailPatient = new JButton[rowPatient];
		adtPatient = new JButton[rowPatient];



		for(int i =0; i<rowPatient; i++) {
			split[i] = new JSeparator();

			split[i].setOrientation(SwingConstants.HORIZONTAL); 

			deletePatient[i] = new JButton("Delete");
			detailPatient[i] = new JButton("Details");
			adtPatient[i] = new JButton("ADT");

			listLabels[i] = new JLabel("<html>"+resultPatient[i][1] + " " + resultPatient[i][2] + " <br/>OHIP: " 
					+resultDemographics[i][0] +" <br/>Date of Birth: "+resultDemographics[i][1] +" <br/>Sex: "+resultDemographics[i][2] +" <br/>Height: "+resultDemographics[i][3] +" <br/>Weight: "+resultDemographics[i][4] +" <br/>Blood Type: "+resultDemographics[i][5] 
							+" <br/>Address: " +resultDemographics[i][6]+"</html>");

			if(i>0) {
				listLabels[i].setBounds(30,(90+15*i)*(i+1),1200,150);
				deletePatient[i].setBounds(1000,(140+15*i)*(i+1),80,20);
				detailPatient[i].setBounds(300,(140+15*i)*(i+1),80,20);
				adtPatient[i].setBounds(400,(140+15*i)*(i+1),80,20);

			}else {listLabels[i].setBounds(30,10*(i+1),1200,150);
			deletePatient[i].setBounds(1000,140,80,20);
			detailPatient[i].setBounds(300,140,80,20);
			adtPatient[i].setBounds(400,140,80,20);

			}
			deletePatient[i].addActionListener(this);
			detailPatient[i].addActionListener(this);
			adtPatient[i].addActionListener(this);
			split[i].setBounds(0,90*(i+1)*2,1200,10);

			listPatientPanel.add(listLabels[i]);
			listPatientPanel.add(detailPatient[i]);
			listPatientPanel.add(deletePatient[i]);
			listPatientPanel.add(adtPatient[i]);

			listPatientPanel.add(split[i]);

		}

		listPatientPanel.validate();
		listPatientPanel.repaint();

	}



	/*
	 * checkInfo - Verifies that the contents in the info Panel follow the proper structure
	 * @return boolean - Variable to output result
	 */
	public boolean checkInfo() {
		String[] result = new String[8];
		String param[] = new String[13];
		param[0] = firstName.getText();
		param[1] = lastName.getText();
		param[2] = city.getText();
		param[3] = street.getText();
		param[4] = ohip.getText();
		param[5] = height.getText();
		param[6] = weight.getText();
		param[7] = address.getText();
		param[8] = postal.getText();
		param[9] = date.getText();
		param[10] = sex.getSelectedItem().toString();
		param[11] = bloodType.getSelectedItem().toString();
		param[12] = unit.getSelectedItem().toString();




		//Check if fields are empty
		for(int i= 0; i < 10; i++) {
			if(param[i].isEmpty()) { return false;}
		}




		//Checking characters from [0] to [2]
		for(int i =0; i< 3; i++) {
			String input = param[i];
			for(int j =0; j< input.length(); j++) {
				if(!(input.charAt(j) > 64 && input.charAt(j) < 91 || input.charAt(j) > 96 && input.charAt(j) < 123)) {
					return false;
				}
			}
		}


		//Checking characters in street
		String input = param[3];
		for(int i =0; i< input.length(); i++) {
			if(!(input.charAt(i) > 64 && input.charAt(i) < 91 || input.charAt(i) > 96 && input.charAt(i) < 123 ||input.charAt(i) == 46 || input.charAt(i) == 32)) {
				return false;
			}
		}

		//Checking ohip length
		if(param[4].length() != 10 ) {return false;}
		
		
		//Checking for digits 
		for(int i = 4; i< 8; i++) {
		input = param[i];
		for(int j =0; j< input.length(); j++) {
			if(!(input.charAt(j) > 47 && input.charAt(j) < 58)) {
				return false;
			}
		}
		}
		
		
		//Checking for postal code
		input = param[8];
		if(input.length() != 6) {return false;}
		
		for(int i =0; i< input.length(); i++) {
			
			if(i == 0 || i==2||i==4) {
				if(!(input.charAt(i) > 64 && input.charAt(i) < 91 || input.charAt(i) > 96 && input.charAt(i) < 123)) {
					return false;
				}
			}
		
			if(i == 1 || i==3||i==5) {
			if(!(input.charAt(i) > 47 && input.charAt(i) < 58)) {
				return false;
			}
			}	
		}
		
		
		input = param[9];
		if(input.length() != 10) {return false;}
		
		for(int i =0; i< input.length(); i++) {
			
			if(i == 4 || i==7) {
				if(input.charAt(i) != 45) {
					return false;
				}
			}else {
			if(!(input.charAt(i) > 47 && input.charAt(i) < 58)) {
				return false;
			}
			}	
		}
		
		
		
		//Check if check boxes are selected;
		if(sex.getSelectedIndex() == -1 || unit.getSelectedIndex() == -1 || bloodType.getSelectedIndex() == -1) {
			return false;
		}


		return true;	
	}





}
