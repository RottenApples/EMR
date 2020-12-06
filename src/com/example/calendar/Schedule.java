package com.example.calendar;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.Border;

import com.example.db.Database;
public class Schedule implements ActionListener {
	private JFrame frame, frame2, frame3;
	private JPanel panel, panel2, panelPop, panelPop2;
	private JButton[] dates;
	private JButton createApp, show;
	private JScrollPane scroll;
	private JLabel startLabel, endLabel;
	private JTextField field;
	private JButton confirm, remove;
	private String[] months = {"January","February","March","April","May",
			"June","July","August","September","October", "November", "December"};
	private JTable table;
	private int start, end;
	private int col, row;
	private JLabel label, nameLabel, startTimeLabel, endTimeLabel, categoryLabel, physicianLabel, physicianLabel2, patientLabel, appointmentLabel;
	private int selDate;
	private String[][] patients, physicians;
	private String[][] appoint;
	private Database database;
	private int id, appID;
	private String time1, time2;
	String[] category = {"Consult", "Hip Replacement", "Blood Test"};
	String[] weekDays = {"Time", ""};
	String[] time = {"8:00","8:30","9:00","9:30","10:00","10:30","11:00","11:30","12:00","12:30","13:00","13:30","14:00","14:30","15:00","15:30","16:00","16:30",
			"17:00","17:30","18:00","18:30","19:00","19:30","20:00","20:30"};
	Object[][] data = {
			{"8:00am",""},
			{"8:30am",""},
			{"9:00am",""},
			{"9:30am",""},
			{"10:00am",""},
			{"10:30am",""},
			{"11:00am",""},
			{"11:30am",""},
			{"12:00pm",""},
			{"12:30pm",""},
			{"1:00pm",""},
			{"1:30pm",""},
			{"2:00pm",""},
			{"2:30pm",""},
			{"3:00pm",""},
			{"3:30pm",""},
			{"4:00pm",""},
			{"4:30pm",""},	
			{"5:00pm",""},
			{"5:30pm",""},
			{"6:00pm",""},
			{"6:30pm",""},
			{"7:00pm",""},
			{"7:30pm",""},
			{"8:00pm",""},
			{"8:30pm",""}};
	
	
	private JComboBox box, startBox,endBox, patientBox, categoryBox, physicianBox, currentBox;
	
	public Schedule(Database db){
		database = db;
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		Border border2 = BorderFactory.createLineBorder(Color.BLACK);

		//Initializing components
		field = new JTextField();
		frame2 = new JFrame();
		frame2.setLayout(null);
		frame2.setVisible(false);
		frame3 = new JFrame();
		frame3.setLayout(null);
		frame3.setVisible(false);
		startLabel=new JLabel("Start Time");
		endLabel=new JLabel("End Time");
		startBox = new JComboBox(time);
		endBox = new JComboBox(time);
		categoryBox = new JComboBox(category);
		currentBox= new JComboBox();
		panelPop = new JPanel();
		confirm = new JButton("Confirm");
		nameLabel = new JLabel();
		startTimeLabel = new JLabel();
		endTimeLabel = new JLabel();
		categoryLabel = new JLabel();
		physicianLabel = new JLabel();
		physicianLabel2 = new JLabel("Physician: ");
		patientLabel = new JLabel("Patient: ");
		appointmentLabel = new JLabel("Type");
		remove = new JButton("Remove");
		show = new JButton("Show");
		createApp = new JButton("Create Appointment");
		
		//Setting bounds
		createApp.setBounds(30, 300, 180, 20);
		currentBox.setBounds(30, 350, 180, 20);
		show.setBounds(220, 350, 80, 20);
		nameLabel.setBounds(200,30,300,20);
		startTimeLabel.setBounds(190,50,100,20);
		endTimeLabel.setBounds(250,50,100,20);
		categoryLabel.setBounds(200,70,100,20);
		physicianLabel.setBounds(200,90,100,20);
		remove.setBounds(350,130,100,20);
		panelPop.setBounds(0,0,500,200);
		startLabel.setBounds(200,10,100,20);
		startBox.setBounds(200,30,100,20);
		endLabel.setBounds(350,10,100,20);
		confirm.setBounds(350,90,100,20);
		endBox.setBounds(350,30,100,20);
		patientLabel.setBounds(30,70,100,20);
		physicianLabel2.setBounds(200,70,100,20);
		appointmentLabel.setBounds(30,10,100,20);
		categoryBox.setBounds(30,30,120,20);
		remove.addActionListener(this);
		show.addActionListener(this);

		
		//Adding components to panels
		panelPop2 = new JPanel();
		panelPop2.add(nameLabel);
		panelPop2.add(startTimeLabel);
		panelPop2.add(endTimeLabel);
		panelPop2.add(categoryLabel);
		panelPop2.add(physicianLabel);
		panelPop2.add(remove);
		panelPop2.setBounds(0,0,500,200);
		panelPop2.setLayout(null);
		frame3.add(panelPop2);
		panelPop.add(patientLabel);
		panelPop.add(appointmentLabel);
		panelPop.add(physicianLabel2);
		panelPop.add(categoryBox);
		panelPop.add(startLabel);
		panelPop.add(startBox);
		panelPop.add(endLabel);
		panelPop.add(endBox);
		panelPop.add(confirm);
		
		

		panelPop.setLayout(null);
		frame2.add(panelPop);
		
		panel = new JPanel();
		panel2 = new JPanel();
		scroll = new JScrollPane();
	
		panel.setLayout(null);
		panel.setBounds(30,100,350,150);
		
		
		label = new JLabel();
		label.setBounds(100,10,160,20);
		panel2.add(label);
		panel2.add(createApp);
		panel2.add(currentBox);
		panel2.add(show);

		
		panel2.setBorder(border2);
		panel2.setLayout(null);
		panel2.setBounds(700,50,450,500);

	
		table = new JTable(data, weekDays);
		table.setEnabled(false);
		
		scroll = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		table.setFillsViewportHeight(true);
		scroll.setBounds(30,50,650,500);
		

		//Initializing the calendar buttons
		dates = new JButton[31];
		box = new JComboBox(months);
		box.setBounds(100,40,160,30);
	
		
		
	    Date date = new Date();  
	    Calendar calendar =  Calendar.getInstance();
	
		box.setSelectedIndex(date.getMonth());
		
		
		
		//Setting the format of the calendar buttons
		int multx = 0;
		int multy = 0;
		for(int i = 0; i< 31; i++ ) {
			String temp = ""+ (i+1); 
			dates[i] = new JButton(temp);
			if(i+1<10) {
			dates[i].setName("0"+temp);
			}else {
				dates[i].setName(temp);	
			}
			dates[i].setBounds(multx,multy,50,30);
			
			
			multx += 50;
			if(i==6 || i == 13 || i == 20 || i == 27) {
				multy += 30;
				multx = 0;
			}
			
			panel.add(dates[i]);
			dates[i].addActionListener(this);
		}
		
		
		//Selecting the current day
		dates[calendar.DAY_OF_MONTH].doClick();
		
		box.addActionListener(this);
		panel2.add(box);
		panel2.add(panel);
	
		
		confirm.addActionListener(this);
		createApp.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0; i<31; i++) {
			
			//Refresh when a new date is selected
			if(e.getSource() == dates[i]) {
			
				

			refresh(i);
				
			}
			
			
		}
		
		
		//Show the details of the appointment
		if(e.getSource() == show) {
		
			nameLabel.setText((String)currentBox.getSelectedItem());
			String[] selection = currentBox.getSelectedItem().toString().split(" ");
			String name = selection[1] + " " + selection[2];
			
			
			id = 0;
			for(int i = 0; i< appoint.length; i++) {
			appID = Integer.parseInt(appoint[i][0]);
			id = Integer.parseInt(appoint[i][3]);
			String nameResult[] = database.getName(id);
			String temp = nameResult[0]+" "+nameResult[1];
			
			if(name.equals(temp)) {
				String appStart[]=appoint[i][1].split(" ");
				String appEnd[]=appoint[i][2].split(" ");
				
				String startTime, endTime;
				
				
				
				//Parsing the timestamps
				if(Integer.parseInt(appStart[1].substring(0, 2)) < 10) {
					
					startTime = appStart[1].substring(1, 5)+"am";	
				}else {
					startTime = appStart[1].substring(0, 5);
					if(Integer.parseInt(startTime.substring(0,2))< 12) {
						startTime = startTime +"am";
					}else {startTime = startTime +"pm";}

				}
					
				
				if(Integer.parseInt(appEnd[1].substring(0, 2)) < 10) {
					
					endTime = appEnd[1].substring(1, 5)+"am";	
				}else {
					endTime = appEnd[1].substring(0, 5);
					if(Integer.parseInt(endTime.substring(0,2))< 12) {
						endTime = endTime +"am";
					}else {endTime = endTime +"pm";}

				}
				
				//Setting the start and end time labels
				startTimeLabel.setText(startTime +" -");
				endTimeLabel.setText(endTime);
				
				categoryLabel.setText(appoint[i][5]);
				
				String nameResult2[] = database.getPhysicianName(Integer.parseInt(appoint[i][4]));
				String temp2 = nameResult2[0]+" "+nameResult2[1];
				physicianLabel.setText(temp2);

				break;
			}
			
			
			
			
			}
			
			
			
			
			if(!name.equals(" ")) {
			frame3.setVisible(true);
			frame3.setBounds(0,0,500,200);
			frame3.setLocationRelativeTo(null);
			frame3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			}
		
		}
		
		//Create an appointment
		if(e.getSource() == confirm) {
			start = startBox.getSelectedIndex();
			end = endBox.getSelectedIndex();
			frame2.setVisible(false);
			
	
			String att[] = new String[5];
			
			
		
			String month =  String.valueOf((box.getSelectedIndex()+1));
				
			if(box.getSelectedIndex()+1 < 10) {
				
				month = "0" +month;
			}
			
			//Creating the starting and ending timestamps
			String timestamp1 = "2020-"+month+"-"+(selDate)+" "; 
			String timestamp2 = "2020-"+month+"-"+(selDate)+" ";
			
		
			String a = (String) startBox.getSelectedItem();
			String b = (String) endBox.getSelectedItem();
					
			
			
			if(a.charAt(1) == ':') {
				a = "0"+a;

			}

			if(a.charAt(1) == ':') {
				b = "0"+b;

			}
		
			att[0] = timestamp1 + a+ ":00";
			att[1] = timestamp2 + b+ ":00";
		
			
		//Getting the selected patient	
		String temp =	(String)patientBox.getSelectedItem();
		String temp2[] = temp.split(" ");
			att[2] = temp2[0];
			
			
			//Getting the selected physican
			 	temp =	(String)physicianBox.getSelectedItem();
			 	temp2 = temp.split(" ");
				att[3] = temp2[0];
			
			att[4] = (String)categoryBox.getSelectedItem();

			
			if(startBox.getSelectedIndex() >=endBox.getSelectedIndex()) {
				JOptionPane.showMessageDialog(null, "Invalid Format.");
			}else {

			//Creating a new appointment	
			database.App(att);
			refresh(selDate-1);
			}
			}
		
		
		//Format the dates buttons according to the selected month 
		if(e.getSource() == box) {
			
			int max = 31;
			int multx = 0;
			int multy = 0;
			if(box.getSelectedIndex() == 3 || box.getSelectedIndex() == 5 || box.getSelectedIndex() == 8 || box.getSelectedIndex() == 10) {
			max = 30;	
			}
			if(box.getSelectedIndex() == 1) {max =28;}
			
			panel.removeAll();
			
			for(int i = 0; i< max; i++ ) {
				String temp = ""+ (i+1); 
				dates[i] = new JButton(temp);
				if(i+1<10) {
					dates[i].setName("0"+temp);
					}else {
						dates[i].setName(temp);	
					}
				dates[i].setBounds(multx,multy,50,30);
				
				
				multx += 50;
				if(i==6 || i == 13 || i == 20 || i == 27) {
					multy += 30;
					multx = 0;
				}
				panel.validate();
				panel.repaint();
				panel.add(dates[i]);

				dates[i].addActionListener(this);
			}
		}
		
		
		
		//Remove a scheduled appointment
		if(e.getSource() == remove) {
			
			database.removeApp(appID);
			frame3.setVisible(false);
			refresh(selDate-1);

		}
		
		
		
		
	
	
		if(e.getSource() == createApp) {
			
			frame2.setVisible(true);
			frame2.setBounds(0,0,500,200);
			frame2.setLocationRelativeTo(null);
			frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		}
		
		
		
		
		
	}


	
	/**
	 * Set the patient selection box with all available patients
	 * @param patients List of patients
	 */
	public void setPatient(String[][] patients) {
		
		this.patients = patients;
		String[] temp = new String[patients.length];
		for(int i =0; i< temp.length; i++) {
			
			temp[i] = patients[i][0] + " " +patients[i][1] + " " + patients[i][2];
		}
		
		patientBox = new JComboBox(temp);
		patientBox.setBounds(30,90,140,20);

		panelPop.add(patientBox);

	}
	
	
	/**
	 * Set the patient selection box with all available physicians
	 * @param patients List physicians
	 */
	public void setPhysician(String[][] physicians) {
		
		this.physicians = physicians;
		String[] temp = new String[physicians.length];
		for(int i =0; i< temp.length; i++) {
			
			temp[i] = physicians[i][0] + " " +physicians[i][1] + " " + physicians[i][2];
		}
		
		physicianBox = new JComboBox(temp);
		physicianBox.setBounds(200,90,140,20);

		panelPop.add(physicianBox);

	}
	
	
	/**
	 * Setting the appointments on the table according to a specific date
	 * @param i The index of the selected date 
	 */
	public void refresh(int i) {
		currentBox.removeAllItems();
		label.setText(box.getSelectedItem() +" "+ dates[i].getName()+", 2020");
		
		selDate = Integer.parseInt(dates[i].getName());
		String date = dates[i].getName();
		String month =  String.valueOf((box.getSelectedIndex()+1));
		if(box.getSelectedIndex()+1 < 10) {
			
			month = "0" +month;
		}
		
		String timestamp1 = "2020-"+month+"-"+date+" " + "00:00:00"; 
		String timestamp2 = "2020-"+month+"-"+date+" "+"23:59:59";
		
		  
		//Get the appointments for a given date
		appoint =database.getApp(timestamp1, timestamp2);
		
		//Clearing the table
		for(int j =0; j<26; j++) {
			table.setValueAt(" ", j, 1);
		}
		
		
		
		//Setting the appointments to the table
		for(int j =0; j < appoint.length; j++) {	
			
		String appStart[]=appoint[j][1].split(" ");
		String appEnd[]=appoint[j][2].split(" ");
		
		
	
		//Parsing the timestamps
		if(Integer.parseInt(appStart[1].substring(0, 2)) < 10) {
			
			time1 = appStart[1].substring(1, 5);	
		}else {
			time1 = appStart[1].substring(0, 5);
		}
		
		
		
		if(Integer.parseInt(appEnd[1].substring(0, 2)) < 10) {
			
			time2 = appEnd[1].substring(1, 5);	
		}else {
			time2 = appEnd[1].substring(0, 5);
		}
		
		
		int id = Integer.parseInt(appoint[j][3]);
	
		String name[] = database.getName(id);
		currentBox.addItem(id + " "+name[0]+" "+name[1]);
			for(int h=0; h< time.length; h++) {
				
				if(time[h].equals(time1)) {
					table.setValueAt(name[0] + " " + name[1], h, 1);
					
				}
					
			}
		}
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Getting the table and calendar panel
	 * @return Table and calendar panel
	 */
	public Object[] getPanels() {
		Object[] temp = new Object[2];
		
		temp[0] = panel2;
		temp[1] = scroll;
		
		return temp;
		
	}
	


}