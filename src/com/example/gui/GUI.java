/*
 * @author: Martin Clement
 */
package com.example.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.border.TitledBorder;

import com.example.calendar.Schedule;
import com.example.db.Database;

public class GUI implements ActionListener{
	private Database db;	

	private JFrame frame, frame2, frame3, frame4;
	private JPanel infoPanel, testPanel, historyDisplay, infoDisplay, statusDisplay, staffPanel, prescriptionPanel, bloodTestPanel, procedurePanel;
	private JPanel[] listPatientPanel, listStaffPanel; 
	private JPanel listBloodPanel;
	private String searchName;
	private JTextField firstName, lastName, ohip, address, street, city, postal, date, height, weight, prescription, allergy, surgical, obsteric, family, immunization,
	preName, preDosage, physicianFirst, physicianLast, preRefill, preDirect, searchBar;
	private JTextField wbc, rbc, hgb, hct, platelet;
	private JLabel wbcLabel, rbcLabel, hgbLabel, hctLabel, plateletLabel, patientNameLabel2;
	private JButton createBloodTest;
	private JLabel firstLabel, lastLabel, sexLabel, ohipLabel, addressLabel, streetLabel, cityLabel, postalLabel, dateLabel, heightLabel , weightLabel, 
	adtLabel, unitLabel, infoLabel, statusLabel,
	staffLabel, staffTitle, preNameLabel, preDosageLabel, physicianFirstLabel, physicianLastLabel, preRefillLabel, preDirectLabel;

	private JButton createPatient, createStaff, createPrescription, createProcedure; 
	private JButton[][] viewBloodTest;	
	private JMenuBar menuBar;
	private JMenu menuFile, menuView, menuFilter;
	private JMenuItem menuNewPatient, menuNewPrescription, menuBlood, menuUrine,menuNewTest, menuNewStaff, menuOpen, menuSave, menuExit, menuListPatient, menuNewProcedure,
	menuListStaff, menuListPrescription, menuListSchedule;
	private JTabbedPane tab; 
	private JComboBox sex, adt, physician, nurse, unit, staff, patient, staffName, bloodType, patient2,staffName2;
	private LineBorder border;
	private	String[] adtList = {"Transfer", "Discharge"};
	private	String[] unitList = {"CCU","ER", "ICU", "MICU", "NICU", "Oncology", "Open-Heart Recovery", "OR", "PACU", "Hospice", "PICU", "Pre-Op", "Rehabilitation", "SICU", 
			"Step-Down Unit", "The Floor", "TICU"};

	private	String[] proc1 = {"Ablation","Aneurysm Repair", "Angioplasty & Stent Placement", "Aortic Valve Replacements", "Cardiac Catheterization", "Cardioversion",
			"Carotid Surgery", "Heart Bypass Surgery", "Heart Valve Repair", "Left Ventricular Assist Device", "Pacemakers", "Trans-myocardial Revascularization" }; // Cardiac
	private	String[] proc2 = {"Echocardiogram", "EKG/ECG", "Ultrasound", "X-Ray", 
		    "Electroencephalogram (EEG)", "Electromyography (EMG)", "Epilepsy Surgery", "Lumbar Puncture/Spinal Tap"};//NICU
	private	String[] proc3 = {"Barium Enema", "Biopsy", "Bone Marrow Aspiration", "Bone Scan", "Breast MRI", "Carcinoembryonic Antigen Test", "Chemotherapy", "Colonoscopy", "CT Scan",
			"Digital Rectal Exam", "Fecal Occult Blood Tests", "Liver-Spleen Scan", "Lung Biopsy", "Mammography", "MRI", "Pap Test", "PET Scan", "Proctoscopy", "Prostate Biopsy", 
			"Prostatectomy", "Sigmoidoscopy", "Thyroid Biopsy", "Tumor Marker Tests", "Upper Endoscopy","Virtual Colonoscopy/CT Colonography"};

	private	String[] proc4 = {"ACL Reconstruction Surgery", "Ankle Replacement Surgery", "Arthroscopy", "Bone Fracture Repair", "Cervical Disc Surgery", "Herniated Disk Surgery",
			"Hip Replacement Surgery", "Joint Fusion Surgery", "Knee Replacement Surgery", "Laminectomy", "Osteotomy", "Rotator Cuff Surgery", "Shoulder Replacement Surgery",
			"Spinal Fusion", "UCL Reconstruction", "Torn PCL Surgery", "Vertebroplasty/Kyphoplasty"};

	
	private String[] staffList = {"Nurse", "Physician"};
	private String[] bloodTypes = {"O+", "O-", "A+", "A-", "B+", "AB+", "AB-"};
	private String[] infoResult, statusResult;
	private JPanel list;
	private JTextArea reason;
	private JLabel bloodLabel, reasonLabel, listLabel;
	private JTextField bloodTypeField;
	private JLabel[] listLabels, listStaffLabel, listBloodLabel, listPrescriptionLabel;
	private JButton[] deletePrescription;
	private JButton[][] detailPatient, adtPatient, deletePatient, deleteStaff;
	private String resultStaff[][] = null;
	private String resultBlood[][] = null;
	private String resultPrescription[][] = null;
	private int rowPatient = 0;
	private int rowStaff =0;
	private int rowBlood = 0;
	private int rowPrescription =0;
	private JPanel detailPanel, detailPanel2, detailPanel3;
	private String[][] ADT;
	private JSeparator split2;
	private JScrollPane scrollPatient, scrollPatient2, scrollPatient3, scrollPatient4, scrollPatient5, scrollPatient6,  scrollPatient7,  scrollPatient8, scrollPatient9, 
	scrollPatient10,scrollPatient11,scrollPatient12,scrollPatient13,scrollPatient14,scrollPatient15,scrollPatient16,scrollPatient17,scrollADT, scrollPrescription;
	private JScrollPane scrollStaff, scrollStaff2;
	private String[] sexList = {"","Female", "Male"};
	private JLabel physicianNameLabel, patientNameLabel;
	private JComboBox<String> adt2, unit2;
	private JButton[][] change;
	private int patientID;
	private JButton[] backButton;
	private JPanel mainPanel, mainPanel2, mainPanel3;
	private JLabel ADTlabel, Prescriptionlabel;
	private JTabbedPane patientLocation, staffCategory;
	private String[][] Location;
	private String locationPatient[][];
	private String[] patients;
	private String resultDemographics[];
	private JLabel[][] detailLabel;
	private JDialog pane;
	private JPanel schedule;
	private JScrollPane schedule2;
	private int id = 0;
	private JPanel cardiacPanel, nicuPanel, oncologyPanel ,orthopedicPanel, filterPanel,cardiacPanel2, nicuPanel2, oncologyPanel2 ,orthopedicPanel2;
	private JCheckBox[] cardiacBox, nicuBox, oncologyBox ,orthopedicBox, cardiacBox2, nicuBox2, oncologyBox2 ,orthopedicBox2;
	private	JButton filter, filter2, clearFilter;
	private JScrollPane scrollFilter, scrollFilter2, scrollFilter3, scrollFilter4, scrollFilter2_1, scrollFilter2_2, scrollFilter2_3, scrollFilter2_4;
	private String filterValue = ""; 
	private JLabel patientNameLabel3, physicianNameLabel3;
	private JComboBox patient3, physician3,patient4;
	private JPanel listPrescriptionPanel;
	private JScrollPane scrollPrescription2;
	private JLabel[] listPrescriptionLabel2; 
	private int rowPrescription2 = 0;
	private String[][] prescription2;
	private String[] resultDemographics2;
	private String[] patientPrescription;
	private JLabel[] listUrineLabel;
	private JPanel listUrinePanel;
	private String[][] resultAnalysis;
	private int rowAnalysis;
	private JButton[][] viewUrineTest;
	private JTextField pH,specific,protein,bilirubin,urobilinogen,blood,glucose,ketone,nitrite,leukocyte;
	private JLabel pHLabel,specificLabel,proteinLabel,bilirubinLabel,urobilinogenLabel,bloodLabel2,glucoseLabel,ketoneLabel,nitriteLabel,leukocyteLabel;
	private JButton createUrineTest;
	private JPanel urineTestPanel;
	private JButton searchButton;
	
	public GUI(Database db) {
		this.db = db;

		infoResult = new String[8]; 
		statusResult = new String[4]; 

		backButton = new JButton[8];


		//Initialize GUI
		frame = new JFrame();
		frame2 = new JFrame();
		frame4 = new JFrame();
		infoPanel = new JPanel();
		statusDisplay = new JPanel();
		testPanel = new JPanel();


		border = new LineBorder(Color.BLACK, 1);






		menuBar = new JMenuBar();
		menuFile = new JMenu("File");
		menuView = new JMenu("View");
		menuFilter = new JMenu("Filter");
		menuNewPatient = new JMenuItem("New Patient");
		menuNewStaff = new JMenuItem("New Medical Staff");
		menuNewPrescription = new JMenuItem("New Prescription");
		menuBlood = new JMenuItem("New Blood Test");
		menuUrine = new JMenuItem("New Urinalysis");
		menuExit = new JMenuItem("Exit");
		menuListPatient = new JMenuItem("List Patients");
		menuNewProcedure = new JMenuItem("New Procedure");
		menuListStaff = new JMenuItem("List Medical Staff");
		menuListSchedule = new JMenuItem("List Schedule");
		menuListPrescription = new JMenuItem("List Prescription");



		
		



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
		menuFile.add(menuNewProcedure);
		menuFile.add(menuNewPrescription);
		menuFile.add(menuBlood);
		menuFile.add(menuUrine);
		menuFile.add(menuExit);
		menuView.add(menuListPatient);
		menuView.add(menuListStaff);
		menuView.add(menuListSchedule);
		menuView.add(menuListPrescription);


		
		frame.add(menuBar);



		/*
		 * ****************************************Calendar***************************************
		 */
		Schedule calendar = new Schedule(db);
		calendar.setPatient(db.getPatient());
		calendar.setPhysician(db.getPhysician());

		Object[] panels = calendar.getPanels();
		schedule = (JPanel) panels[0];
		schedule2 = (JScrollPane) panels[1];

		frame.add(schedule);
		frame.add(schedule2);


		//*******************************************************************************************




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
		tempStaff = db.getPhysician();
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
		 **********************Procedure Panel****************************		
		 */
		backButton[6] = new JButton("<");
		backButton[6].setBounds(10,10,45,30);
		backButton[6].addActionListener(this);

		
		procedurePanel = new JPanel();
		procedurePanel.setLayout(null);
		createProcedure = new JButton("Create");
		
		patient3 = new JComboBox(name);
		physician3 = new JComboBox(name2);


		
		
		
		
		cardiacPanel2 = new JPanel();
		nicuPanel2 = new JPanel();
		oncologyPanel2 = new JPanel();
		orthopedicPanel2 = new JPanel();
		
		int length2_1 =  proc1.length;
		int length2_2 = proc2.length;
		int length2_3 = proc3.length;
		int length2_4 = proc4.length;
		cardiacBox2 = new JCheckBox[length2_1];
		nicuBox2 = new JCheckBox[length2_2];
		oncologyBox2 = new JCheckBox[length2_3];
		orthopedicBox2 = new JCheckBox[length2_4];



		for(int i =0; i<4; i++) {
			if(i == 0) {
				
				
				for(int j =0; j<length2_1; j++) {
					cardiacBox2[j] = new JCheckBox(proc1[j]);
					cardiacPanel2.add(cardiacBox2[j]);
					cardiacBox2[j].addActionListener(this);
				}
			}
		
			if(i == 1) {
			
				for(int j =0; j<length2_2; j++) {
					
					
					nicuBox2[j] = new JCheckBox(proc2[j]);
					nicuPanel2.add(nicuBox2[j]);
					nicuBox2[j].addActionListener(this);
				}
			}
			if(i == 2) {
			
				for(int j =0; j<length2_3; j++) {
					oncologyBox2[j] = new JCheckBox(proc3[j]);
					oncologyPanel2.add(oncologyBox2[j]);
					oncologyBox2[j].addActionListener(this);
				}
			}
			if(i == 3) {
			
				for(int j =0; j<length2_4; j++) {
									
					orthopedicBox2[j] = new JCheckBox(proc4[j]);
					orthopedicPanel2.add(orthopedicBox2[j]);
					orthopedicBox2[j].addActionListener(this);
				}
			}
		}
	
		TitledBorder border6 = new TitledBorder("Cardiac");
		TitledBorder border7 = new TitledBorder("NICU");
		TitledBorder border8 = new TitledBorder("Oncology");
		TitledBorder border9 = new TitledBorder("Orthopedic");

		scrollFilter2_1 = new JScrollPane(cardiacPanel2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollFilter2_1.setBounds(70,0,300,300);
		cardiacPanel2.setPreferredSize(new Dimension(50,400));
		scrollFilter2_1.setBorder(border6);
		
		scrollFilter2_2 = new JScrollPane(nicuPanel2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollFilter2_2.setBounds(390,0,300,300);
		nicuPanel2.setPreferredSize(new Dimension(50,400));
		scrollFilter2_2.setBorder(border7);
		
		scrollFilter2_3 = new JScrollPane(oncologyPanel2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollFilter2_3.setBounds(70,300,300,300);
		oncologyPanel2.setPreferredSize(new Dimension(50,500));
		scrollFilter2_3.setBorder(border8);
		
		scrollFilter2_4 = new JScrollPane(orthopedicPanel2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollFilter2_4.setBounds(390,300,300,300);
		orthopedicPanel2.setPreferredSize(new Dimension(50,500));
		scrollFilter2_4.setBorder(border9);
		
		
		
		procedurePanel.add(scrollFilter2_1);
		procedurePanel.add(scrollFilter2_2);
		procedurePanel.add(scrollFilter2_3);
		procedurePanel.add(scrollFilter2_4);
		
		
		
		patientNameLabel3 = new JLabel("Patient Name: ");
		physicianNameLabel3 = new JLabel("Physician Name: ");


	
		patientNameLabel3.setBounds(700,160, 150, 20);
		patient3.setBounds(700,180,150,20);

		physicianNameLabel3.setBounds(900,160,150,20);
		physician3.setBounds(900,180,150,20);

		createProcedure.setBounds(750,220,150,30);

		
		
		procedurePanel.add(patient3);
		procedurePanel.add(physician3);
		procedurePanel.add(patientNameLabel3);
		procedurePanel.add(physicianNameLabel3);
		procedurePanel.add(createProcedure);
		procedurePanel.add(backButton[6]);
		procedurePanel.setVisible(false);
		//****************************************************************
		



		/*
		 **********************Blood Test Panel****************************		
		 */
		backButton[5] = new JButton("<");
		backButton[5].setBounds(10,10,45,30);
		backButton[5].addActionListener(this);
		createBloodTest = new JButton("Create Blood Test");
		createBloodTest.addActionListener(this);
		wbc = new JTextField();
		rbc = new JTextField();
		hgb = new JTextField();
		hct = new JTextField();
		platelet = new JTextField();



		patient2 = new JComboBox(name);


		wbcLabel = new JLabel("WBC (cu.mm): ");
		rbcLabel = new JLabel("RBC (cu.mm): ");
		hgbLabel = new JLabel("HGB (g): ");
		hctLabel = new JLabel("HCT (%): ");
		plateletLabel = new JLabel("Platelets (cu.mm): ");
		patientNameLabel2 = new JLabel("Patient: ");


		createBloodTest.setBounds(30,220,150,30);


		wbcLabel.setBounds(30, 50, 160, 20);
		wbc.setBounds(30, 70, 160, 20);
		rbcLabel.setBounds(30,100, 150, 20);
		rbc.setBounds(30, 120, 160, 20);
		hgbLabel.setBounds(250, 50, 70, 20);
		hgb.setBounds(250, 70, 160, 20);

		hctLabel.setBounds(250,100, 150, 20);
		hct.setBounds(250, 120, 160, 20);
		plateletLabel.setBounds(450,100, 150, 20);
		platelet.setBounds(450, 120, 160, 20);
		patientNameLabel2.setBounds(30,160, 150, 20);
		patient2.setBounds(30,180,150,20);


		bloodTestPanel = new JPanel();
		bloodTestPanel.setLayout(null);
		bloodTestPanel.setVisible(false);
		bloodTestPanel.add(wbc); 
		bloodTestPanel.add(rbc); 
		bloodTestPanel.add(hgb);
		bloodTestPanel.add(hct);

		bloodTestPanel.add(wbcLabel);
		bloodTestPanel.add(rbcLabel); 
		bloodTestPanel.add(hgbLabel);
		bloodTestPanel.add(hctLabel);
		bloodTestPanel.add(patientNameLabel2);
		bloodTestPanel.add(patient2);
		bloodTestPanel.add(createBloodTest);
		bloodTestPanel.add(plateletLabel);
		bloodTestPanel.add(platelet);
		bloodTestPanel.add(backButton[5]);

		//*************************************************************************

		
		
		
		/*
		 **********************Urine Test Panel****************************		
		 */
		
		createUrineTest = new JButton("Create Urine Test");
		pH = new JTextField();
		specific = new JTextField();
		protein = new JTextField();
		bilirubin = new JTextField();
		urobilinogen = new JTextField();
		blood = new JTextField();
		glucose = new JTextField();
		ketone = new JTextField();
		nitrite = new JTextField();
		leukocyte = new JTextField();



		patient4 = new JComboBox(name);


		pHLabel = new JLabel("pH: ");
		specificLabel = new JLabel("Specific Gravity: ");
		proteinLabel = new JLabel("Protein (mg): ");
		bilirubinLabel = new JLabel("Bilirubin (mg): ");
		urobilinogenLabel = new JLabel("Urobilinogen (mg): ");
		bloodLabel2 = new JLabel("Blood (RBC): ");
		glucoseLabel = new JLabel("Glucose (mg): ");
		ketoneLabel = new JLabel("Ketone (mg): ");
		nitriteLabel = new JLabel("Nitrite (mg): ");
		leukocyteLabel = new JLabel("Leukocyte (WBC): ");
	
		patientNameLabel3 = new JLabel("Patient: ");

		
		

		createUrineTest.setBounds(30,220,150,30);


		pHLabel.setBounds(30, 50, 160, 20);
		pH.setBounds(30, 70, 160, 20);
		specificLabel.setBounds(30,100, 150, 20);
		specific.setBounds(30, 120, 160, 20);
		proteinLabel.setBounds(250, 50, 100, 20);
		protein.setBounds(250, 70, 160, 20);
		bilirubinLabel.setBounds(250,100, 150, 20);
		bilirubin.setBounds(250, 120, 160, 20);
		urobilinogenLabel.setBounds(450,100, 150, 20);
		urobilinogen.setBounds(450, 120, 160, 20);
		bloodLabel2.setBounds(450, 50, 160, 20);
		blood.setBounds(450, 70, 160, 20);
		glucoseLabel.setBounds(630,100, 150, 20);
		glucose.setBounds(630, 120, 160, 20);
		ketoneLabel.setBounds(630, 50, 100, 20);
		ketone.setBounds(630, 70, 160, 20);
		nitriteLabel.setBounds(810,50, 150, 20);
		nitrite.setBounds(810, 70, 160, 20);
		leukocyteLabel.setBounds(810,100, 150, 20);
		leukocyte.setBounds(810, 120, 160, 20);
		
		patientNameLabel3.setBounds(30,160, 150, 20);
		patient4.setBounds(30,180,150,20);


		urineTestPanel = new JPanel();
		urineTestPanel.setLayout(null);
		urineTestPanel.setVisible(false);
		urineTestPanel.add(pH); 
		urineTestPanel.add(specific); 
		urineTestPanel.add(protein);
		urineTestPanel.add(bilirubin);
		urineTestPanel.add(urobilinogen);
		urineTestPanel.add(blood);
		urineTestPanel.add(glucose);
		urineTestPanel.add(ketone);
		urineTestPanel.add(nitrite);
		urineTestPanel.add(leukocyte);

		
		urineTestPanel.add(pHLabel); 
		urineTestPanel.add(specificLabel); 
		urineTestPanel.add(proteinLabel);
		urineTestPanel.add(bilirubinLabel);
		urineTestPanel.add(urobilinogenLabel);
		urineTestPanel.add(bloodLabel2);
		urineTestPanel.add(glucoseLabel);
		urineTestPanel.add(ketoneLabel);
		urineTestPanel.add(nitriteLabel);
		urineTestPanel.add(leukocyteLabel);

	
		urineTestPanel.add(patientNameLabel3);
		urineTestPanel.add(patient4);
		urineTestPanel.add(createUrineTest);
		createUrineTest.addActionListener(this);

		//*************************************************************************




		/*
		 ****************************List Patient Panel************************************ 		
		 */

		searchBar = new JTextField();
		searchButton = new JButton("Search");
		
		searchBar.setVisible(false);
		searchBar.setBounds(10,50,1000,20);
		searchButton.setBounds(1050,50,100,20);
		searchButton.addActionListener(this);
		searchButton.setVisible(false);
		frame.add(searchButton);
		frame.add(searchBar);
		patientLocation = new JTabbedPane();
		listPatientPanel = new JPanel[17];
		listLabel = new JLabel();
		for(int i =0; i< 17; i++) {
			listPatientPanel[i] = new JPanel();
			listPatientPanel[i].setLayout(null);
			listPatientPanel[i].setPreferredSize(new Dimension(1000,18000));
		}

		scrollPatient = new JScrollPane(listPatientPanel[0],JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPatient.setBounds(0,30,1184,655);		
		scrollPatient2 = new JScrollPane(listPatientPanel[1],JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPatient2.setBounds(0,30,1184,655);
		scrollPatient3 = new JScrollPane(listPatientPanel[2],JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPatient3.setBounds(0,30,1184,655);
		scrollPatient4 = new JScrollPane(listPatientPanel[3],JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPatient4.setBounds(0,30,1184,655);
		scrollPatient5 = new JScrollPane(listPatientPanel[4],JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPatient5.setBounds(0,30,1184,655);
		scrollPatient6 = new JScrollPane(listPatientPanel[5],JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPatient6.setBounds(0,30,1184,655);
		scrollPatient7 = new JScrollPane(listPatientPanel[6],JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPatient7.setBounds(0,30,1184,655);
		scrollPatient8 = new JScrollPane(listPatientPanel[7],JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPatient8.setBounds(0,30,1184,655);
		scrollPatient9 = new JScrollPane(listPatientPanel[8],JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPatient9.setBounds(0,30,1184,655);
		scrollPatient10 = new JScrollPane(listPatientPanel[9],JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPatient10.setBounds(0,30,1184,655);
		scrollPatient11 = new JScrollPane(listPatientPanel[10],JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPatient11.setBounds(0,30,1184,655);
		scrollPatient12 = new JScrollPane(listPatientPanel[11],JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPatient12.setBounds(0,30,1184,655);
		scrollPatient13 = new JScrollPane(listPatientPanel[12],JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPatient13.setBounds(0,30,1184,655);
		scrollPatient14 = new JScrollPane(listPatientPanel[13],JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPatient14.setBounds(0,30,1184,655);
		scrollPatient15 = new JScrollPane(listPatientPanel[14],JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPatient15.setBounds(0,30,1184,655);
		scrollPatient16 = new JScrollPane(listPatientPanel[15],JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPatient16.setBounds(0,30,1184,655);
		scrollPatient17 = new JScrollPane(listPatientPanel[16],JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPatient17.setBounds(0,30,1184,655);






		patientLocation.add(scrollPatient, "CCU");
		patientLocation.add(scrollPatient2, "ER");
		patientLocation.add(scrollPatient3, "ICU");
		patientLocation.add(scrollPatient4, "MICU");
		patientLocation.add(scrollPatient5, "NICU");
		patientLocation.add(scrollPatient6, "Oncology");
		patientLocation.add(scrollPatient7, "Open-Heart Surgery");
		patientLocation.add(scrollPatient8, "OR");
		patientLocation.add(scrollPatient9, "PACU");
		patientLocation.add(scrollPatient10, "Hospice");
		patientLocation.add(scrollPatient11, "PICU");
		patientLocation.add(scrollPatient12, "Pre-OP");
		patientLocation.add(scrollPatient13, "Rehabilition");
		patientLocation.add(scrollPatient14, "SICU");
		patientLocation.add(scrollPatient15, "Step-Down Unit");
		patientLocation.add(scrollPatient16, "The Floor");
		patientLocation.add(scrollPatient17, "TICU");





		patientLocation.setBounds(0,100,1184,655);
		patientLocation.setVisible(false);
		detailPatient = new JButton[17][100];
		adtPatient = new JButton[17][100];
		change = new JButton[17][100];
		deletePatient = new JButton[17][100];


		detailLabel = new JLabel[17][100];

		drawListPatient();

		//*************************************************************************		



		/*
		 ****************************List Staff Panel************************************ 		
		 */


		staffCategory = new JTabbedPane();
		listStaffPanel = new JPanel[2];



		for(int i =0; i<2; i++) {
			listStaffPanel[i] = new JPanel();
			listStaffPanel[i].setLayout(null);
			listStaffPanel[i].setPreferredSize(new Dimension(1000,18000));
		}




		scrollStaff = new JScrollPane(listStaffPanel[0],JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollStaff.setBounds(0,30,1184,655);

		scrollStaff2 = new JScrollPane(listStaffPanel[1],JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollStaff2.setBounds(0,30,1184,655);


		staffCategory.add(scrollStaff, "Nurse");
		staffCategory.add(scrollStaff2, "Physician");


		staffCategory.setBounds(0,30,1184,655);
		staffCategory.setVisible(false);
	
	
		deleteStaff = new JButton[2][100];




		//*************************************************************************		


		/*
		 ****************************List Prescription Panel************************************ 		
		 */
		
	
		
		
		
		listPrescriptionPanel = new JPanel();	
		listPrescriptionPanel.setLayout(null);
		listPrescriptionPanel.setPreferredSize(new Dimension(1000,18000));
		

		scrollPrescription2 = new JScrollPane(listPrescriptionPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPrescription2.setBounds(0,30,1184,655);		

		deletePrescription = new JButton[100];
		
		scrollPrescription2.setVisible(false);

		drawListPrescription();

		/*
		 ****************************Detail Patient Panel************************************ 		
		 */

		backButton[7] = new JButton("<");
		backButton[7].setBounds(10,10,45,30);
		backButton[7].addActionListener(this);
		detailPanel = new JPanel();
		detailPanel.setLayout(null);
		detailPanel.setVisible(false);
		detailPanel.setBounds(0,30,1280,690);
		detailPanel2 = new JPanel();
		detailPanel2.setLayout(null);
		detailPanel2.setVisible(true);
		detailPanel2.setPreferredSize(new Dimension(650,1200));
		detailPanel3 = new JPanel();
		detailPanel3.setLayout(null);
		detailPanel3.setVisible(true);
		detailPanel3.setPreferredSize(new Dimension(650,1200));
		ADTlabel = new JLabel("ADT History");
		ADTlabel.setBounds(500,0,160,30);
		Prescriptionlabel = new JLabel("Prescription History");
		Prescriptionlabel.setBounds(500,300,160,30);



		scrollADT = new JScrollPane(detailPanel3,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollADT.setBounds(500,30,650,250);
		scrollADT.setVisible(true);

		scrollPrescription = new JScrollPane(detailPanel2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPrescription.setBounds(500,340,650,250);
		scrollPrescription.setVisible(true);


		//*************************************************************************		



		/*
		 ****************************Blood List Panel************************************ 		
		 */


		listBloodPanel = new JPanel();
		listBloodPanel.setLayout(null);
		listBloodPanel.setBounds(0,30,1280,690);
		viewBloodTest = new JButton[17][100];


		//*************************************************************************		



		/*
		 ****************************Urine List Panel************************************ 		
		 */


		listUrinePanel = new JPanel();
		listUrinePanel.setLayout(null);
		listUrinePanel.setBounds(0,30,1280,690);
		viewUrineTest = new JButton[17][100];


		//*************************************************************************		


		/*
		 ****************************Filter Panels************************************ 		
		 */
	
		frame3 = new JFrame();
		cardiacPanel = new JPanel();
		nicuPanel = new JPanel();
		oncologyPanel = new JPanel();
		orthopedicPanel = new JPanel();
		filterPanel = new JPanel();
		clearFilter = new JButton("Clear");
		
		int length =  proc1.length;
		int length2 = proc2.length;
		int length3 = proc3.length;
		int length4 = proc4.length;
		cardiacBox = new JCheckBox[length];
		nicuBox = new JCheckBox[length2];
		oncologyBox = new JCheckBox[length3];
		orthopedicBox = new JCheckBox[length4];

		filter2 = new JButton("Filter");

		filter2.setBounds(700,600,70,20);
		filter2.addActionListener(this);
		clearFilter.setBounds(600,600,80,20);
		clearFilter.addActionListener(this);

		for(int i =0; i<4; i++) {
			if(i == 0) {
				
				
				for(int j =0; j<length; j++) {
					cardiacBox[j] = new JCheckBox(proc1[j]);
					cardiacPanel.add(cardiacBox[j]);
					cardiacBox[j].addActionListener(this);
				}
			}
		
			if(i == 1) {
			
				for(int j =0; j<length2; j++) {
					
					
					nicuBox[j] = new JCheckBox(proc2[j]);
					nicuPanel.add(nicuBox[j]);
					nicuBox[j].addActionListener(this);
				}
			}
			if(i == 2) {
			
				for(int j =0; j<length3; j++) {
					oncologyBox[j] = new JCheckBox(proc3[j]);
					oncologyPanel.add(oncologyBox[j]);
					oncologyBox[j].addActionListener(this);
				}
			}
			if(i == 3) {
			
				for(int j =0; j<length4; j++) {
									
					orthopedicBox[j] = new JCheckBox(proc4[j]);
					orthopedicPanel.add(orthopedicBox[j]);
					orthopedicBox[j].addActionListener(this);
				}
			}
		}
	
		TitledBorder border2 = new TitledBorder("Cardiac");
		TitledBorder border3 = new TitledBorder("NICU");
		TitledBorder border4 = new TitledBorder("Oncology");
		TitledBorder border5 = new TitledBorder("Orthopedic");

		scrollFilter = new JScrollPane(cardiacPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollFilter.setBounds(30,0,300,300);
		cardiacPanel.setPreferredSize(new Dimension(50,400));
		scrollFilter.setBorder(border2);
		filterPanel.add(scrollFilter);
		
		scrollFilter2 = new JScrollPane(nicuPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollFilter2.setBounds(350,0,300,300);
		nicuPanel.setPreferredSize(new Dimension(50,400));
		scrollFilter2.setBorder(border3);
		filterPanel.add(scrollFilter2);
		
		scrollFilter3 = new JScrollPane(oncologyPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollFilter3.setBounds(30,300,300,300);
		oncologyPanel.setPreferredSize(new Dimension(50,500));
		scrollFilter3.setBorder(border4);
		filterPanel.add(scrollFilter3);
		
		scrollFilter4 = new JScrollPane(orthopedicPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollFilter4.setBounds(350,300,300,300);
		orthopedicPanel.setPreferredSize(new Dimension(50,500));
		scrollFilter4.setBorder(border5);
		filterPanel.add(scrollFilter4);
		
		frame3.add(filterPanel);
		
		filter = new JButton("Filter");
		filter.setVisible(false);
		filter.setBounds(1090,100,70,20);
		filter.addActionListener(this);
	
		filterPanel.setLayout(null);
		filterPanel.add(filter2);
		filterPanel.add(clearFilter);
		frame.add(filter);
		
		
		
	

		//*************************************************************************		




		infoPanel.setBounds(0,30,1280,690);

		prescriptionPanel.setBounds(0,30,1280,690);
		procedurePanel.setBounds(0,30,1280,690);

		bloodTestPanel.setBounds(0,30,1280,690);
		urineTestPanel.setBounds(0,30,1280,690);

		testPanel.setBounds(0,30,1280,690);

		
		frame.add(detailPanel);
		frame.add(staffPanel);
		frame.add(infoPanel);
		frame.add(prescriptionPanel);
		frame.add(patientLocation);
		frame.add(scrollPrescription2);
		frame.add(staffCategory);		
		frame2.add(listBloodPanel);
		frame.add(bloodTestPanel);
		frame.add(urineTestPanel);
		frame.add(procedurePanel);
		frame4.add(listUrinePanel);

		//Window Preferences
		frame.setTitle("Electronic Medical Records (EMR)");
		frame.setBounds(0, 0, 1200, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);




		//Window Preferences
		frame2.setTitle("Blood Test");
		frame2.setBounds(0, 0, 800, 400);
		frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame2.setResizable(false);
		frame2.setVisible(false);
		frame2.setLocationRelativeTo(null);
		
		//Window Preferences
		frame3.setTitle("Filter");
		frame3.setBounds(0, 0, 800, 720);
		frame3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame3.setResizable(false);
		frame3.setVisible(false);
		frame3.setLocationRelativeTo(null);

		
		
		frame4.setTitle("Urine Test");
		frame4.setBounds(0, 0, 800, 400);
		frame4.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame4.setResizable(false);
		frame4.setVisible(false);
		frame4.setLocationRelativeTo(null);
		
		
		
		
		
		
		//ActionListener
		menuNewPatient.addActionListener(this);
		menuNewStaff.addActionListener(this);
		menuNewPrescription.addActionListener(this);
		menuNewProcedure.addActionListener(this);
		menuBlood.addActionListener(this);
		menuUrine.addActionListener(this);
		menuExit.addActionListener(this);
		menuListPatient.addActionListener(this);
		menuListStaff.addActionListener(this);
		menuListSchedule.addActionListener(this);		
		menuListPrescription.addActionListener(this);
		createPatient.addActionListener(this);
		createStaff.addActionListener(this);
		createPrescription.addActionListener(this);
		createProcedure.addActionListener(this);

		filter.addActionListener(this);
	

		unit.addActionListener(this);

	}

	/*
	 **************************Action Performed****************************************************
	 */


	public void actionPerformed(ActionEvent e) {

		
		
		
		if(e.getSource() == filter) {
			frame3.setVisible(true);
		}
		
		
		if(e.getSource() == clearFilter) {
			
			filterValue = "";
			drawListPatient();
		}
		
		
		
		for(int i =0; i<cardiacBox.length; i++) {
		if(e.getSource() == cardiacBox[i]) {
			if(cardiacBox[i].isSelected() == true) {
				for(int j = 0; j<cardiacBox.length; j++) {
					if(j!=i) {
					cardiacBox[j].setSelected(false);
					}
				}
			}
		}	
	}
		
		
		for(int i =0; i<nicuBox.length; i++) {
			if(e.getSource() == nicuBox[i]) {
				if(nicuBox[i].isSelected() == true) {
					for(int j = 0; j<nicuBox.length; j++) {
						if(j!=i) {
						nicuBox[j].setSelected(false);
						}
					}
				}
			}	
		}
		
		
		for(int i =0; i<oncologyBox.length; i++) {
			if(e.getSource() == oncologyBox[i]) {
				if(oncologyBox[i].isSelected() == true) {
					for(int j = 0; j<oncologyBox.length; j++) {
						if(j!=i) {
						oncologyBox[j].setSelected(false);
						}
					}
				}
			}	
		}
		
		
		for(int i =0; i<orthopedicBox.length; i++) {
			if(e.getSource() == orthopedicBox[i]) {
				if(orthopedicBox[i].isSelected() == true) {
					for(int j = 0; j<orthopedicBox.length; j++) {
						if(j!=i) {
						orthopedicBox[j].setSelected(false);
						}
					}
				}
			}	
		}
		
		
		

		for(int i =0; i<cardiacBox2.length; i++) {
		if(e.getSource() == cardiacBox2[i]) {
			if(cardiacBox2[i].isSelected() == true) {
				for(int j = 0; j<cardiacBox2.length; j++) {
					if(j!=i) {
					cardiacBox2[j].setSelected(false);
					}
				}
			}
		}	
	}
		
		
		for(int i =0; i<nicuBox2.length; i++) {
			if(e.getSource() == nicuBox2[i]) {
				if(nicuBox2[i].isSelected() == true) {
					for(int j = 0; j<nicuBox2.length; j++) {
						if(j!=i) {
						nicuBox2[j].setSelected(false);
						}
					}
				}
			}	
		}
		
		
		for(int i =0; i<oncologyBox2.length; i++) {
			if(e.getSource() == oncologyBox2[i]) {
				if(oncologyBox2[i].isSelected() == true) {
					for(int j = 0; j<oncologyBox2.length; j++) {
						if(j!=i) {
						oncologyBox2[j].setSelected(false);
						}
					}
				}
			}	
		}
		
		
		for(int i =0; i<orthopedicBox2.length; i++) {
			if(e.getSource() == orthopedicBox2[i]) {
				if(orthopedicBox2[i].isSelected() == true) {
					for(int j = 0; j<orthopedicBox2.length; j++) {
						if(j!=i) {
						orthopedicBox2[j].setSelected(false);
						}
					}
				}
			}	
		}
		
		
		
		
		
		if(e.getSource() == filter2) {
		
			for(int i =0; i< cardiacBox.length; i++) {
				if(cardiacBox[i].isSelected() == true) {
					filterValue =cardiacBox[i].getText();
				
				}	
			}
			
			for(int i =0; i< nicuBox.length; i++) {
				if(nicuBox[i].isSelected() == true) {
					filterValue =nicuBox[i].getText();
				}	
				
			}
			
			for(int i =0; i< oncologyBox.length; i++) {
				if(oncologyBox[i].isSelected() == true) {
					filterValue = oncologyBox[i].getText();
				}	
			}
			
			for(int i =0; i< orthopedicBox.length; i++) {
				if(orthopedicBox[i].isSelected() == true) {
					filterValue = orthopedicBox[i].getText();
				}
			}
			
	
			frame3.setVisible(false);
			drawListPatient();
	
		}
		
		
		for(int i =0; i< 7; i++ ) {
			if(e.getSource() == backButton[i]) {
				schedule.setVisible(true);
				schedule2.setVisible(true);
				infoPanel.setVisible(false);
				staffPanel.setVisible(false);
				prescriptionPanel.setVisible(false);
				testPanel.setVisible(false);
				patientLocation.setVisible(false);
				staffCategory.setVisible(false);
				detailPanel.setVisible(false);
				bloodTestPanel.setVisible(false);
				filter.setVisible(false);
				procedurePanel.setVisible(false);
				scrollPrescription2.setVisible(false);
				frame4.setVisible(false);
				searchButton.setVisible(false);
				searchBar.setVisible(false);

			}
		}




		if(e.getSource() == menuBlood) {
			schedule.setVisible(false);
			schedule2.setVisible(false);
			infoPanel.setVisible(false);
			staffPanel.setVisible(false);
			prescriptionPanel.setVisible(false);
			testPanel.setVisible(false);
			patientLocation.setVisible(false);
			staffCategory.setVisible(false);
			detailPanel.setVisible(false);
			bloodTestPanel.setVisible(true);
			filter.setVisible(false);
			procedurePanel.setVisible(false);
			scrollPrescription2.setVisible(false);
			frame4.setVisible(false);
			urineTestPanel.setVisible(false);
			searchButton.setVisible(false);
			searchBar.setVisible(false);
			
			String[][] tempPatient;
			tempPatient = db.getPatient();
			String name[] = new String[tempPatient.length];

			patient2.removeAllItems();
			for(int i =0; i <tempPatient.length; i++){
				name[i] =tempPatient[i][0]+" "+tempPatient[i][1]+" "+tempPatient[i][2]; ;
				patient2.addItem(name[i]);

			}


			
		

		}
		
		if(e.getSource() == menuUrine) {
			schedule.setVisible(false);
			schedule2.setVisible(false);
			infoPanel.setVisible(false);
			staffPanel.setVisible(false);
			prescriptionPanel.setVisible(false);
			testPanel.setVisible(false);
			patientLocation.setVisible(false);
			staffCategory.setVisible(false);
			detailPanel.setVisible(false);
			bloodTestPanel.setVisible(false);
			filter.setVisible(false);
			procedurePanel.setVisible(false);
			scrollPrescription2.setVisible(false);
			frame4.setVisible(false);
			urineTestPanel.setVisible(true);
			searchButton.setVisible(false);
			searchBar.setVisible(false);
			
			
			String[][] tempPatient;
			tempPatient = db.getPatient();
			String name[] = new String[tempPatient.length];
			
			patient4.removeAllItems();


			for(int i =0; i <tempPatient.length; i++){
				name[i] =tempPatient[i][0]+" "+tempPatient[i][1]+" "+tempPatient[i][2]; 
				patient4.addItem(name[i]);


			}


			

		}
		
		if(e.getSource() == menuListPrescription) {
			schedule.setVisible(false);
			schedule2.setVisible(false);
			infoPanel.setVisible(false);
			staffPanel.setVisible(false);
			prescriptionPanel.setVisible(false);
			testPanel.setVisible(false);
			patientLocation.setVisible(false);
			staffCategory.setVisible(false);
			detailPanel.setVisible(false);
			bloodTestPanel.setVisible(false);
			filter.setVisible(false);
			procedurePanel.setVisible(false);
			scrollPrescription2.setVisible(true);
			frame4.setVisible(false);
			searchButton.setVisible(false);
			searchBar.setVisible(false);

		}



		if(e.getSource() == backButton[7]) {
			schedule.setVisible(false);
			schedule2.setVisible(false);
			staffCategory.setVisible(false);
			infoPanel.setVisible(false);
			staffPanel.setVisible(false);
			prescriptionPanel.setVisible(false);
			testPanel.setVisible(false);
			patientLocation.setVisible(true);
			detailPanel.setVisible(false);
			bloodTestPanel.setVisible(false);
			filter.setVisible(true);
			procedurePanel.setVisible(false);
			scrollPrescription2.setVisible(false);
			frame4.setVisible(false);
			searchButton.setVisible(true);
			searchBar.setVisible(true);

		}

		if(e.getSource() == createBloodTest) {

			try {
				String result[] = new String[7];
				String value = (String) patient2.getSelectedItem();
				String[] temp = value.split(" ");
				result[0] = temp[0];
				result[1] = wbc.getText();
				result[2] = rbc.getText();
				result[3] = hgb.getText();
				result[4] = hct.getText();
				result[5] = platelet.getText();




		
					System.out.println("Im here");
					db.createBloodTest(result);	
			
			}catch(NullPointerException f) {
				JOptionPane.showMessageDialog(null, "Invalid Format.");
			}
		}


		if(e.getSource() == createUrineTest) {

			try {
				String result[] = new String[11];
				String value = (String) patient4.getSelectedItem();
				String[] temp = value.split(" ");
				
				result[0] =pH.getText();
				result[1] =specific.getText();
				result[2] =protein.getText();
				result[3] =bilirubin.getText();
				result[4] =urobilinogen.getText();
				result[5] =blood.getText();
				result[6] =glucose.getText();
				result[7] =ketone.getText();
				result[8] =nitrite.getText();
				result[9] =leukocyte.getText();
				result[10] = temp[0];


				if(checkUrineInfo()){
					db.createUrineTest(result);	
				}else {
					JOptionPane.showMessageDialog(null, "Invalid Format.");
				}
			}catch(NullPointerException f) {
				JOptionPane.showMessageDialog(null, "Invalid Format.");
			}
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

				if(checkPatientInfo()){
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
			try {
				result[0] = firstName.getText();
				result[1] = lastName.getText();

				result[2] = staff.getSelectedItem().toString();

				if(checkStaffInfo()) {
					db.createStaff(result);
				}else {
					JOptionPane.showMessageDialog(null, "Invalid Format.");

				}
			}catch(NullPointerException f){
				JOptionPane.showMessageDialog(null, "Invalid Format.");


			}

		}

		if(e.getSource() == createPrescription) {
			String tempPatientName, tempStaffName;
			try {
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

				if(checkPrescriptionInfo()) {

					db.createPrescription(result);
					JOptionPane.showMessageDialog(null, "Prescription created.");

				}else {

					JOptionPane.showMessageDialog(null, "Invalid Format.");

				}
			}catch(NullPointerException f){
				JOptionPane.showMessageDialog(null, "Invalid Format.");

			}

		}

		if(e.getSource() == menuNewPatient) {
			schedule.setVisible(false);
			schedule2.setVisible(false);
			staffCategory.setVisible(false);
			infoPanel.setVisible(true);
			staffPanel.setVisible(false);
			prescriptionPanel.setVisible(false);
			testPanel.setVisible(false);
			patientLocation.setVisible(false);
			detailPanel.setVisible(false);
			bloodTestPanel.setVisible(false);
			filter.setVisible(false);
			procedurePanel.setVisible(false);
			scrollPrescription2.setVisible(false);
			frame4.setVisible(false);
			urineTestPanel.setVisible(false);
			searchButton.setVisible(false);
			searchBar.setVisible(false);

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
			schedule.setVisible(false);
			schedule2.setVisible(false);
			staffCategory.setVisible(false);
			infoPanel.setVisible(false);
			staffPanel.setVisible(true);
			prescriptionPanel.setVisible(false);
			testPanel.setVisible(false);
			patientLocation.setVisible(false);
			detailPanel.setVisible(false);
			bloodTestPanel.setVisible(false);
			filter.setVisible(false);
			procedurePanel.setVisible(false);
			scrollPrescription2.setVisible(false);
			frame4.setVisible(false);
			urineTestPanel.setVisible(false);
			searchButton.setVisible(false);
			searchBar.setVisible(false);

			
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
			schedule.setVisible(false);
			schedule2.setVisible(false);
			staffCategory.setVisible(false);
			infoPanel.setVisible(false);
			staffPanel.setVisible(false);
			prescriptionPanel.setVisible(true);
			testPanel.setVisible(false);
			patientLocation.setVisible(false);
			detailPanel.setVisible(false);
			bloodTestPanel.setVisible(false);
			filter.setVisible(false);
			procedurePanel.setVisible(false);
			scrollPrescription2.setVisible(false);
			frame4.setVisible(false);
			urineTestPanel.setVisible(false);
			searchButton.setVisible(false);
			searchBar.setVisible(false);
			
			
			String[][] tempPatient;
			tempPatient = db.getPatient();
			String name[] = new String[tempPatient.length];


			patient.removeAllItems();
			staffName.removeAllItems();
			for(int i =0; i <tempPatient.length; i++){
				name[i] =tempPatient[i][0]+" "+tempPatient[i][1]+" "+tempPatient[i][2]; ;
				patient.addItem(name[i]);

			}

			String[][] tempStaff;
			tempStaff = db.getPhysician();
			String name2[] = new String[tempStaff.length];

			for(int i =0; i <tempStaff.length; i++){
				name2[i] =tempStaff[i][0]+" "+tempStaff[i][1]+" "+tempStaff[i][2]; ;
				staffName.addItem(name2[i]);

			}



		}


		if(e.getSource() == menuNewProcedure) {
			schedule.setVisible(false);
			schedule2.setVisible(false);
			staffCategory.setVisible(false);
			infoPanel.setVisible(false);
			staffPanel.setVisible(false);
			prescriptionPanel.setVisible(false);
			testPanel.setVisible(false);
			patientLocation.setVisible(false);
			detailPanel.setVisible(false);
			bloodTestPanel.setVisible(false);
			filter.setVisible(false);
			procedurePanel.setVisible(true);
			scrollPrescription2.setVisible(false);
			frame4.setVisible(false);
			urineTestPanel.setVisible(false);
			searchButton.setVisible(false);
			searchBar.setVisible(false);

			
			
			
			
			String[][] tempPatient;
			tempPatient = db.getPatient();
			String name[] = new String[tempPatient.length];


			patient3.removeAllItems();
			physician3.removeAllItems();
			for(int i =0; i <tempPatient.length; i++){
				name[i] =tempPatient[i][0]+" "+tempPatient[i][1]+" "+tempPatient[i][2]; ;
				patient3.addItem(name[i]);

			}

			String[][] tempStaff;
			tempStaff = db.getPhysician();
			String name2[] = new String[tempStaff.length];

			for(int i =0; i <tempStaff.length; i++){
				name2[i] =tempStaff[i][0]+" "+tempStaff[i][1]+" "+tempStaff[i][2]; ;
				physician3.addItem(name2[i]);

			}
		}


		if(e.getSource() == menuExit) {
			System.exit(0);
		}


		if(e.getSource() == menuListPatient) {
			schedule.setVisible(false);
			schedule2.setVisible(false);
			staffCategory.setVisible(false);
			infoPanel.setVisible(false);
			detailPanel.setVisible(false);
			staffPanel.setVisible(false);
			prescriptionPanel.setVisible(false);
			testPanel.setVisible(false);
			bloodTestPanel.setVisible(false);
			filter.setVisible(true);
			searchButton.setVisible(true);
			searchBar.setVisible(true);
			procedurePanel.setVisible(false);
			patientLocation.setVisible(true);
			scrollPrescription2.setVisible(false);
			frame4.setVisible(false);
			urineTestPanel.setVisible(false);

			

			drawListPatient();
		}


		if(e.getSource() == menuListStaff) {
			schedule.setVisible(false);
			schedule2.setVisible(false);
			infoPanel.setVisible(false);
			detailPanel.setVisible(false);
			staffPanel.setVisible(false);
			prescriptionPanel.setVisible(false);
			testPanel.setVisible(false);
			patientLocation.setVisible(false);
			staffCategory.setVisible(true);
			bloodTestPanel.setVisible(false);
			filter.setVisible(false);
			procedurePanel.setVisible(false);
			scrollPrescription2.setVisible(false);
			frame4.setVisible(false);
			urineTestPanel.setVisible(false);
			searchButton.setVisible(false);
			searchBar.setVisible(false);

			drawListStaff();
		}

		
		
		
		if(e.getSource() == menuListSchedule) {
			schedule.setVisible(true);
			schedule2.setVisible(true);
			infoPanel.setVisible(false);
			detailPanel.setVisible(false);
			staffPanel.setVisible(false);
			prescriptionPanel.setVisible(false);
			testPanel.setVisible(false);
			patientLocation.setVisible(false);
			staffCategory.setVisible(false);
			bloodTestPanel.setVisible(false);
			filter.setVisible(false);
			procedurePanel.setVisible(false);
			scrollPrescription2.setVisible(false);
			frame4.setVisible(false);
			urineTestPanel.setVisible(false);
			searchButton.setVisible(false);
			searchBar.setVisible(false);


		}
		
		
		if(e.getSource() == searchButton) {
			
			search();
		}
		
		
		
		
		
		if(e.getSource() == createProcedure) {
			String att[] = new String[3];
			for(int i =0; i< cardiacBox2.length; i++) {
				if(cardiacBox2[i].isSelected() == true) {
					att[0] =cardiacBox2[i].getText();
				
				}	
			}
			
			for(int i =0; i< nicuBox2.length; i++) {
				if(nicuBox2[i].isSelected() == true) {
					System.out.println("Im here");
					att[0] =nicuBox2[i].getText();
				}	
				
			}
			
			for(int i =0; i< oncologyBox2.length; i++) {
				if(oncologyBox2[i].isSelected() == true) {
					att[0] = oncologyBox2[i].getText();
				}	
			}
			
			for(int i =0; i< orthopedicBox2.length; i++) {
				if(orthopedicBox2[i].isSelected() == true) {
					
					att[0] = orthopedicBox2[i].getText();
				}
			}
			
			
			String[] temp = patient3.getSelectedItem().toString().split(" ");
			String[] temp2 = physician3.getSelectedItem().toString().split(" ");
			att[1] = temp[0];
			att[2] = temp2[0];
			

			
					db.createProcedure(att);

			JOptionPane.showMessageDialog(null, "Procedure Created.");		
			
		}


		for(int h = 0; h< 17; h++) {
			for(int i =0; i< rowPatient; i++) {
				if(e.getSource() == deletePatient[h][i]) {


					locationPatient= db.getLocationPatient(h+1);


					db.deletePatient(Integer.parseInt(locationPatient[i][0]));

					drawListPatient();

				}
			}
		}

		for(int h =0; h< 17; h++) {
			for(int i = 0; i< rowPatient; i++) {
				if(e.getSource() == detailPatient[h][i]) {
					detailPanel.removeAll();
					detailPanel3.removeAll();
					detailPanel2.removeAll();

					schedule.setVisible(false);
					schedule2.setVisible(false);
					staffCategory.setVisible(false);
					infoPanel.setVisible(false);
					detailPanel.setVisible(true);			
					staffPanel.setVisible(false);
					prescriptionPanel.setVisible(false);
					testPanel.setVisible(false);
					patientLocation.setVisible(false);
					bloodTestPanel.setVisible(false);
					filter.setVisible(false);
					procedurePanel.setVisible(false);
					scrollPrescription2.setVisible(false);
					frame4.setVisible(false);
					urineTestPanel.setVisible(false);
					searchButton.setVisible(false);
					searchBar.setVisible(false);


					viewBloodTest[h][i] = new JButton("View Blood Test");
					viewBloodTest[h][i].setBounds(30,500,200,20);
					viewBloodTest[h][i].addActionListener(this);
					
					
					viewUrineTest[h][i] = new JButton("View Urine Test");
					viewUrineTest[h][i].setBounds(30,450,200,20);
					viewUrineTest[h][i].addActionListener(this);

					locationPatient= db.getLocationPatient(h+1);
					id = Integer.parseInt(locationPatient[i][0]);
					int row = db.getADTCount(Integer.parseInt(locationPatient[i][0]));

					ADT = new String[row][7];


					ADT = db.getADT(Integer.parseInt(locationPatient[i][0]));

					String Location;

					Location = db.getLocationName(Integer.parseInt(ADT[0][6]));




					JLabel label2[] = new JLabel[row];

					resultDemographics = db.getPatientDemographic(Integer.parseInt(locationPatient[i][0]));
					patients = db.getName(Integer.parseInt(locationPatient[i][0]));




					detailLabel[h][i] =  new JLabel("<html>"+patients[0] + " " + patients[1] + " <br/>OHIP: " 
							+resultDemographics[1] +" <br/>Date of Birth: "+resultDemographics[2] +" <br/>Sex: "+resultDemographics[3] +" <br/>Height: "+resultDemographics[4] +" <br/>Weight: "+resultDemographics[5] +" <br/>Blood Type: "+resultDemographics[6] 
									+" <br/>Address: " +resultDemographics[7]+"</html>");



					detailLabel[h][i].setBounds(30,40, 500, 200);
					for(int j =0; j < row; j++) {

						if(ADT[j][3] == null && ADT[j][4] == null) {
							label2[j] = new JLabel("<html>"+" ADT: "+ADT[j][1] +" <br/>Admition Date: "+ADT[j][2]+" <br/> Reason: "+ADT[j][5]+ " <br/> Location: "+Location+"</html>"); 
						}

						if(ADT[j][2] == null && ADT[j][4] == null) {
							label2[j] = new JLabel("<html>"+"  ADT: "+ADT[j][1] +" <br/>Transfer Date: "+ADT[j][3]+" <br/> Reason: "+ADT[j][5]+ "</html>"); 
						}


						if(ADT[j][2] == null && ADT[j][3] == null) {
							label2[j] = new JLabel("<html>"+"  ADT: "+ADT[j][1] +" <br/>Discharge Date: "+ADT[j][4]+" <br/> Reason: "+ADT[j][5]+ "</html>"); 
						}
						JSeparator split3 = new JSeparator();
						if(j==0) {


							label2[j].setBounds(30,0,300,120);

						}else {

							split3.setBounds(0,(70+15*j)*(j+1),1200,20);
							split3.setOrientation(SwingConstants.HORIZONTAL); 
							label2[j].setBounds(30,(70+15*j)*(j+1),300,120);
						}
						detailPanel3.add(label2[j]);
						detailPanel3.add(split3);

					}

					
					
					

					resultPrescription = db.getPrescription(id);
					rowPrescription = db.getPrescriptionCount(id);
					listPrescriptionLabel = new JLabel[rowPrescription+1];

					for(int j =0; j < rowPrescription; j++) {
				
							listPrescriptionLabel[j] = new JLabel("<html> Prescription Name: "+resultPrescription[j][1] + " <br/> Date: " + resultPrescription[j][2] + " <br/> Dosage: " +resultPrescription[j][3] 
									+ " <br/> Refills: " + resultPrescription[j][4]+ " <br/> Description: "+resultPrescription[j][5]+"</html>");
							
							split2 = new JSeparator();

							if(j==0) {
								listPrescriptionLabel[j].setBounds(30,0,300,120);

							}else {
							listPrescriptionLabel[j].setBounds(30,(70+15*j)*(j+1),300,120);
							split2.setBounds(0,(70+15*j)*(j+1),1200,20);
							split2.setOrientation(SwingConstants.HORIZONTAL);
							}
							
							detailPanel2.add(listPrescriptionLabel[j]);
							detailPanel2.add(split2);

					}

					String sumPrescription = db.TotalDosage(id);

					if(sumPrescription == null) {sumPrescription = "0";}
					
					
					listPrescriptionLabel[rowPrescription] = new JLabel("<html> Total Dosage: "+sumPrescription+" ml</html>");
					listPrescriptionLabel[rowPrescription].setBounds(30,(70+15*rowPrescription)*(rowPrescription+1),300,120);

					detailPanel2.add(listPrescriptionLabel[rowPrescription]);
				
					detailPanel.add(ADTlabel);
					detailPanel.add(scrollADT);
					detailPanel.add(Prescriptionlabel);
					detailPanel.add(scrollPrescription);
					detailPanel.add(backButton[7]);
					detailPanel.add(detailLabel[h][i]);
					detailPanel.add(viewBloodTest[h][i]);
					detailPanel.add(viewUrineTest[h][i]);


				}
			}



			for(int i =0; i < 100; i++) {
				if(e.getSource() == viewBloodTest[h][i]) {
					schedule.setVisible(false);
					schedule2.setVisible(false);
					staffCategory.setVisible(false);
					infoPanel.setVisible(false);
					detailPanel.setVisible(true);			
					staffPanel.setVisible(false);
					prescriptionPanel.setVisible(false);
					testPanel.setVisible(false);
					patientLocation.setVisible(false);
					bloodTestPanel.setVisible(false);
					frame2.setVisible(true);
					filter.setVisible(false);
					procedurePanel.setVisible(false);
					scrollPrescription2.setVisible(false);
					frame4.setVisible(false);
					urineTestPanel.setVisible(false);
					searchButton.setVisible(false);
					searchBar.setVisible(false);

					drawBloodTest(id);
				}
			}

			
			
			
			for(int i =0; i < 100; i++) {
				if(e.getSource() == viewUrineTest[h][i]) {
					schedule.setVisible(false);
					schedule2.setVisible(false);
					staffCategory.setVisible(false);
					infoPanel.setVisible(false);
					detailPanel.setVisible(true);			
					staffPanel.setVisible(false);
					prescriptionPanel.setVisible(false);
					testPanel.setVisible(false);
					patientLocation.setVisible(false);
					bloodTestPanel.setVisible(false);
					frame2.setVisible(false);
					frame4.setVisible(true);
					filter.setVisible(false);
					procedurePanel.setVisible(false);
					scrollPrescription2.setVisible(false);
					urineTestPanel.setVisible(false);
					searchButton.setVisible(false);
					searchBar.setVisible(false);


					drawUrineTest(id);
				}
			}

		}

		for(int h = 0; h< 17; h++) {
			for(int i = 0; i< rowPatient; i++) {
				if(e.getSource() == adtPatient[h][i]) {


					locationPatient= db.getLocationPatient(h+1);
					patients = db.getName(Integer.parseInt(locationPatient[i][0]));

					pane = new JDialog();


					change[h][i] = new JButton("Update");
					change[h][i].addActionListener(this);

					adt2 = new JComboBox<String>(adtList);
					unit2 = new JComboBox<String>(unitList);

					JLabel adtLabel = new JLabel("ADT: ");
					JLabel unitLabel = new JLabel("Unit: ");
					JLabel label = new JLabel("To");
					JLabel name = new JLabel(patients[0]+ " " + patients[1]);


					pane.add(adt2);
					pane.add(unit2);
					pane.add(adtLabel);
					pane.add(unitLabel);
					pane.add(label);
					pane.add(name);
					pane.add(change[h][i]);

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
					change[h][i].setBounds(110,110,100,20);
					pane.setTitle("ADT Status");





				}
				if(e.getSource() == change[h][i]) {
					db.createADT(locationPatient[i][0].toString(), adt2.getSelectedItem().toString(), unit2.getSelectedItem().toString());
					drawListPatient();
					pane.setVisible(false);

				}
			}


		}




		for(int h = 0; h< 2; h++) {
			for(int i =0; i< rowStaff; i++) {
				if(e.getSource() == deleteStaff[h][i]) {


					if(h==0) {
						resultStaff = db.getNurse();
						int id =Integer.parseInt(resultStaff[i][0]);
						db.deleteNurse(id);
						drawListStaff();

					}
					if(h==1) {
						resultStaff = db.getPhysician();
						int id =Integer.parseInt(resultStaff[i][0]);
					
						db.deletePhysician(id);
						drawListStaff();

					}

				}
			}
		}
		
		
		
		
		for(int i = 0; i< rowPrescription2; i++) {
			if(e.getSource() == deletePrescription[i]) {



				db.deletePrescription(Integer.parseInt(prescription2[i][0]));

				drawListPrescription();

			}
			}


	}


	// *********************************************************************************************************************************************'	



	public void drawListPatient() {
		for(int j =0; j < 17; j++) {
			listPatientPanel[j].removeAll();



			rowPatient = db.getLocationPatientCount(j+1);

			locationPatient= db.getLocationPatient(j+1);
	
			JSeparator[] split = new JSeparator[rowPatient];

			listLabels = new JLabel[rowPatient];


			for(int i =0; i<rowPatient; i++) {
				if(filterValue == "") {
				
				split[i] = new JSeparator();

				split[i].setOrientation(SwingConstants.HORIZONTAL); 
				resultDemographics = db.getPatientDemographic(Integer.parseInt(locationPatient[i][0]));
				patients = db.getName(Integer.parseInt(locationPatient[i][0]));


				deletePatient[j][i] = new JButton("Delete");
				detailPatient[j][i] = new JButton("Details");
				adtPatient[j][i] = new JButton("ADT");

				listLabels[i] = new JLabel("<html>"+patients[0] + " " + patients[1] + " <br/>OHIP: " 
						+resultDemographics[1] +" <br/>Date of Birth: "+resultDemographics[2] +" <br/>Sex: "+resultDemographics[3] +" <br/>Height: "+resultDemographics[4] +" <br/>Weight: "+resultDemographics[5] +" <br/>Blood Type: "+resultDemographics[6] 
								+" <br/>Address: " +resultDemographics[7]+"</html>");

				if(i == 1) {
					listLabels[i].setBounds(30,180,1200,150);
					deletePatient[j][i].setBounds(1000,320,80,20);
					detailPatient[j][i].setBounds(400,320,80,20);
					adtPatient[j][i].setBounds(500,320,80,20);


				}else if(i > 0){

					listLabels[i].setBounds(30,180*i,380,150);
					deletePatient[j][i].setBounds(1000,(180*i)+140,80,20);
					detailPatient[j][i].setBounds(400,(180*i)+140,80,20);
					adtPatient[j][i].setBounds(500,(180*i)+140,80,20);

				}else {listLabels[i].setBounds(30,10,1200,150);
				deletePatient[j][i].setBounds(1000,140,80,20);
				detailPatient[j][i].setBounds(400,140,80,20);
				adtPatient[j][i].setBounds(500,140,80,20);

				}
				deletePatient[j][i].addActionListener(this);
				detailPatient[j][i].addActionListener(this);
				adtPatient[j][i].addActionListener(this);
				split[i].setBounds(0,90*(i+1)*2,1200,10);

				listPatientPanel[j].add(listLabels[i]);
				listPatientPanel[j].add(detailPatient[j][i]);
				listPatientPanel[j].add(deletePatient[j][i]);
				listPatientPanel[j].add(adtPatient[j][i]);

				listPatientPanel[j].add(split[i]);
				}else {
					if(locationPatient[i][3] == null) {locationPatient[i][3] = "";}
					if(locationPatient[i][3].equals(filterValue)){
					
					split[i] = new JSeparator();

					split[i].setOrientation(SwingConstants.HORIZONTAL); 
					resultDemographics = db.getPatientDemographic(Integer.parseInt(locationPatient[i][0]));
					patients = db.getName(Integer.parseInt(locationPatient[i][0]));


					deletePatient[j][i] = new JButton("Delete");
					detailPatient[j][i] = new JButton("Details");
					adtPatient[j][i] = new JButton("ADT");

					listLabels[i] = new JLabel("<html>"+patients[0] + " " + patients[1] + " <br/>OHIP: " 
							+resultDemographics[1] +" <br/>Date of Birth: "+resultDemographics[2] +" <br/>Sex: "+resultDemographics[3] +" <br/>Height: "+resultDemographics[4] +" <br/>Weight: "+resultDemographics[5] +" <br/>Blood Type: "+resultDemographics[6] 
									+" <br/>Address: " +resultDemographics[7]+"</html>");

					if(i == 1) {
						listLabels[i].setBounds(30,180,1200,150);
						deletePatient[j][i].setBounds(1000,320,80,20);
						detailPatient[j][i].setBounds(400,320,80,20);
						adtPatient[j][i].setBounds(500,320,80,20);


					}else if(i > 0){

						listLabels[i].setBounds(30,180*i,380,150);
						deletePatient[j][i].setBounds(1000,(180*i)+140,80,20);
						detailPatient[j][i].setBounds(400,(180*i)+140,80,20);
						adtPatient[j][i].setBounds(500,(180*i)+140,80,20);

					}else {listLabels[i].setBounds(30,10,1200,150);
					deletePatient[j][i].setBounds(1000,140,80,20);
					detailPatient[j][i].setBounds(400,140,80,20);
					adtPatient[j][i].setBounds(500,140,80,20);

					}
					deletePatient[j][i].addActionListener(this);
					detailPatient[j][i].addActionListener(this);
					adtPatient[j][i].addActionListener(this);
					split[i].setBounds(0,90*(i+1)*2,1200,10);

					listPatientPanel[j].add(listLabels[i]);
					listPatientPanel[j].add(detailPatient[j][i]);
					listPatientPanel[j].add(deletePatient[j][i]);
					listPatientPanel[j].add(adtPatient[j][i]);

					listPatientPanel[j].add(split[i]);
					
					}
					
				}
			}

			listPatientPanel[j].validate();
			listPatientPanel[j].repaint();
		}
	}



	public void drawListStaff() {

		for(int j =0; j < 2; j++) {
			listStaffPanel[j].removeAll();


			if(j==0) {
				rowStaff = db.getNurseCount();

				resultStaff= db.getNurse();	

			}

			if(j==1) {

				rowStaff = db.getPhysicianCount();

				resultStaff= db.getPhysician();
			}


			JSeparator[] split = new JSeparator[rowStaff];

			listStaffLabel = new JLabel[rowStaff];


			for(int i =0; i<rowStaff; i++) {
				split[i] = new JSeparator();

				split[i].setOrientation(SwingConstants.HORIZONTAL); 


				deleteStaff[j][i] = new JButton("Delete");

				listStaffLabel[i] = new JLabel(resultStaff[i][1] + " " + resultStaff[i][2]);

				if(i == 1) {
					listStaffLabel[i].setBounds(30,180,1200,150);
					deleteStaff[j][i].setBounds(1000,320,80,20);


				}else if(i > 0){

					listStaffLabel[i].setBounds(30,180*i,380,150);
					deleteStaff[j][i].setBounds(1000,(180*i)+140,80,20);

				}else {
					listStaffLabel[i].setBounds(30,10,1200,150);
					deleteStaff[j][i].setBounds(1000,140,80,20);

				}
				deleteStaff[j][i].addActionListener(this);
				split[i].setBounds(0,90*(i+1)*2,1200,10);

				listStaffPanel[j].add(listStaffLabel[i]);
				listStaffPanel[j].add(deleteStaff[j][i]);

				listStaffPanel[j].add(split[i]);

			}

			listStaffPanel[j].validate();
			listStaffPanel[j].repaint();
		}
	}
	
	public void drawListPrescription() {

			listPrescriptionPanel.removeAll();



			rowPrescription2 = db.getPrescriptionCount();

			prescription2= db.getAllPrescriptions();
	
			JSeparator[] split = new JSeparator[rowPrescription2];

			listPrescriptionLabel2 = new JLabel[rowPrescription2];


			for(int i =0; i<rowPrescription2; i++) {
				
				
				split[i] = new JSeparator();

				split[i].setOrientation(SwingConstants.HORIZONTAL); 
				resultDemographics2 = db.getPatientDemographic(Integer.parseInt(prescription2[i][6]));
				patientPrescription = db.getName(Integer.parseInt(prescription2[i][6]));


				deletePrescription[i] = new JButton("Delete");

				listPrescriptionLabel2[i] = new JLabel("<html>"+patientPrescription[0] + " " + patientPrescription[1] + " <br/>OHIP: " 
						+resultDemographics2[1] +"<br/>Prescription Name: "+ prescription2[i][1] +" <br/>Date: "+prescription2[i][2]+ 
						"<br/>Dosage: "+ prescription2[i][3]+ "<br/>Refill: "+ prescription2[i][4] + "<br/>Description: "+ prescription2[i][5] + "</html>");

				if(i == 1) {
					listPrescriptionLabel2[i].setBounds(30,180,1200,150);
					deletePrescription[i].setBounds(1000,320,80,20);

				}else if(i > 0){

					listPrescriptionLabel2[i].setBounds(30,180*i,380,150);
					deletePrescription[i].setBounds(1000,(180*i)+140,80,20);

				}else {
				listPrescriptionLabel2[i].setBounds(30,10,1200,150);
				deletePrescription[i].setBounds(1000,140,80,20);

				}
				deletePrescription[i].addActionListener(this);
				split[i].setBounds(0,90*(i+1)*2,1200,10);

				listPrescriptionPanel.add(listPrescriptionLabel2[i]);
				listPrescriptionPanel.add(deletePrescription[i]);
		
				listPrescriptionPanel.add(split[i]);
				
			}

			listPrescriptionPanel.validate();
			listPrescriptionPanel.repaint();
		
	}
	
	
	
	
	


	public void drawBloodTest(int id) {

		rowBlood = db.getBloodCount(id);

		listBloodPanel.removeAll();
		resultBlood= db.getBloodTest(id);


		listBloodLabel = new JLabel[14];


		if(resultBlood.length != 0) {
			listBloodLabel[0] = new JLabel("WBC");
			listBloodLabel[1] = new JLabel("RBC");
			listBloodLabel[2] = new JLabel("HGB");
			listBloodLabel[3] = new JLabel("HCT");
			listBloodLabel[4] = new JLabel("PLATELET");

			listBloodLabel[5] = new JLabel(resultBlood[0][1]);
			listBloodLabel[6] = new JLabel(resultBlood[0][2]);
			listBloodLabel[7] = new JLabel(resultBlood[0][3]);
			listBloodLabel[8] = new JLabel(resultBlood[0][4]);
			listBloodLabel[9] = new JLabel(resultBlood[0][5]);

			listBloodLabel[10] = new JLabel(resultBlood[0][6]);
			listBloodLabel[11] = new JLabel("Date: ");




			listBloodLabel[0].setBounds(30,80,1200,150);
			listBloodLabel[1].setBounds(30,100,1200,150);
			listBloodLabel[2].setBounds(30,120,380,150);
			listBloodLabel[3].setBounds(30,140,380,150);
			listBloodLabel[4].setBounds(30,160,380,150);


			listBloodLabel[5].setBounds(400,80,1200,150);
			listBloodLabel[6].setBounds(400,100,1200,150);
			listBloodLabel[7].setBounds(400,120,380,150);
			listBloodLabel[8].setBounds(400,140,380,150);
			listBloodLabel[9].setBounds(400,160,380,150);

			listBloodLabel[10].setBounds(30,30,380,150);
			listBloodLabel[11].setBounds(30,10,380,150);


			listBloodLabel[12] = new JLabel("Result");
			listBloodLabel[13] = new JLabel("Test");



			listBloodLabel[12].setBounds(400,120,1200,30);
			listBloodLabel[13].setBounds(30,120,1200,30);

			
			for(int i =0; i<14; i++) {

				listBloodPanel.add(listBloodLabel[i]);


			}
		}
		listBloodPanel.validate();
		listBloodPanel.repaint();

	}

	
	
	
	
	
	
	public void drawUrineTest(int id) {
		listUrinePanel.removeAll();

		rowAnalysis = db.getUrineCount(id);

		resultAnalysis= db.getUrineTest(id);


		listUrineLabel = new JLabel[24];


		if(resultAnalysis.length != 0) {
			listUrineLabel[0] = new JLabel("pH");
			listUrineLabel[1] = new JLabel("Specific Gravity");
			listUrineLabel[2] = new JLabel("Protein");
			listUrineLabel[3] = new JLabel("Bilirubin");
			listUrineLabel[4] = new JLabel("Urobilinogen");
			listUrineLabel[5] = new JLabel("Blood");
			listUrineLabel[6] = new JLabel("Glucose");
			listUrineLabel[7] = new JLabel("Ketone");
			listUrineLabel[8] = new JLabel("Nitrite");
			listUrineLabel[9] = new JLabel("Leukocyte");

			listUrineLabel[10] = new JLabel(resultAnalysis[0][1]);
			listUrineLabel[11] = new JLabel(resultAnalysis[0][2]);
			listUrineLabel[12] = new JLabel(resultAnalysis[0][3]);
			listUrineLabel[13] = new JLabel(resultAnalysis[0][4]);
			listUrineLabel[14] = new JLabel(resultAnalysis[0][5]);
			listUrineLabel[15] = new JLabel(resultAnalysis[0][6]);
			listUrineLabel[16] = new JLabel(resultAnalysis[0][7]);
			listUrineLabel[17] = new JLabel(resultAnalysis[0][8]);
			listUrineLabel[18] = new JLabel(resultAnalysis[0][9]);
			listUrineLabel[19] = new JLabel(resultAnalysis[0][10]);

			
			
			
			
			listUrineLabel[20] = new JLabel(resultAnalysis[0][11]);
			listUrineLabel[21] = new JLabel("Date: ");


		


			listUrineLabel[0].setBounds(30,80,1200,150);
			listUrineLabel[1].setBounds(30,100,1200,150);
			listUrineLabel[2].setBounds(30,120,380,150);
			listUrineLabel[3].setBounds(30,140,380,150);
			listUrineLabel[4].setBounds(30,160,380,150);
			listUrineLabel[5].setBounds(30,180,380,150);
			listUrineLabel[6].setBounds(30,200,380,150);
			listUrineLabel[7].setBounds(30,220,380,150);
			listUrineLabel[8].setBounds(30,240,380,150);
			listUrineLabel[9].setBounds(30,260,380,150);


			listUrineLabel[10].setBounds(400,80,1200,150);
			listUrineLabel[11].setBounds(400,100,1200,150);
			listUrineLabel[12].setBounds(400,120,380,150);
			listUrineLabel[13].setBounds(400,140,380,150);
			listUrineLabel[14].setBounds(400,160,380,150);
			listUrineLabel[15].setBounds(400,180,380,150);
			listUrineLabel[16].setBounds(400,200,380,150);
			listUrineLabel[17].setBounds(400,220,380,150);
			listUrineLabel[18].setBounds(400,240,380,150);
			listUrineLabel[19].setBounds(400,260,380,150);



			listUrineLabel[20].setBounds(30,30,380,150);
			listUrineLabel[21].setBounds(30,10,380,150);
		
			
	
			listUrineLabel[22] = new JLabel("Result");
			listUrineLabel[23] = new JLabel("Test");


			listUrineLabel[22].setBounds(400,120,1200,30);
			listUrineLabel[23].setBounds(30,120,1200,30);

			
			
			
			
			for(int i =0; i<24; i++) {

				listUrinePanel.add(listUrineLabel[i]);


			}
		}
		listUrinePanel.validate();
		listUrinePanel.repaint();

	}
	
	
	
	

	/*
	 * checkInfo - Verifies that the contents in the info Panel follow the proper structure
	 * @return boolean - Variable to output result
	 */
	public boolean checkPatientInfo() {
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


	public boolean checkStaffInfo() {
		String param[] = new String[2];

		param[0] = firstName.getText();
		param[1] = lastName.getText();
		//Checking characters from [0] to [2]
		for(int i =0; i< 2; i++) {
			String input = param[i];
			for(int j =0; j< input.length(); j++) {
				if(!(input.charAt(j) > 64 && input.charAt(j) < 91 || input.charAt(j) > 96 && input.charAt(j) < 123)) {
					return false;
				}
			}
		}

		if(staff.getSelectedIndex() == -1) {return false;}
		return true;	
	}


	public boolean checkPrescriptionInfo() {

		if(patient.getSelectedIndex() == -1 || staffName.getSelectedIndex() == -1) {
			return false;
		}





		String result[] =  new String[4];
		result[0] = preName.getText(); 
		result[1] = preDosage.getText(); 
		result[2] = preRefill.getText(); 
		result[3] = preDirect.getText();

		if(result[0].isEmpty() || result[1].isEmpty() || result[2].isEmpty() || result[3].isEmpty()) {

			return false;
		}

		String input = result[0];
		for(int j =0; j< input.length(); j++) {
			if(!(input.charAt(j) > 64 && input.charAt(j) < 91 || input.charAt(j) > 96 && input.charAt(j) < 123)) {
				return false;
			}

		}
		for(int i = 1; i< 3; i++) {
			input = result[i];
			for(int j =0; j< input.length(); j++) {
				if(!(input.charAt(j) > 47 && input.charAt(j) < 58)) {
					return false;
				}
			}
		}


		return true;
	}

	public boolean checkBloodInfo() {
		String result[] = new String[5];

		result[0] = wbc.getText();
		result[1] = rbc.getText();
		result[2] = hgb.getText();
		result[3] = hct.getText();
		result[4] = platelet.getText();


		for(int i =0; i<5; i++) {
			if(result[i].length()>3) {
				return false;
			}
		}

		return true;
	}


	public boolean checkUrineInfo() {
		String result[] = new String[10];

		result[0] =pH.getText();
		result[1] =specific.getText();
		result[2] =protein.getText();
		result[3] =bilirubin.getText();
		result[4] =urobilinogen.getText();
		result[5] =blood.getText();
		result[6] =glucose.getText();
		result[7] =ketone.getText();
		result[8] =nitrite.getText();
		result[9] =leukocyte.getText();


		for(int i =0; i<10; i++) {
			if(result[i].length()>6) {
				return false;
			}
		}

		return true;
	}
	
	
	public void search() {
		
		String ohip = searchBar.getText();
		System.out.println(ohip);
		
		
		if(ohip.length() != 10) {

			return;
		}

		int num = db.getSearchLocation(ohip);
		
		String[][] searchResult = db.getSearch(num);
		int searchCount = db.getSearchCount(num);

		
		for(int i = 0; i< searchCount; i++) {
			if(ohip.equals(searchResult[i][2])) {
				int location = Integer.parseInt(searchResult[i][1]);
				detailPatient[location-1][i].doClick();
				break;
			}
		}
		
		
		
	}
	

}
