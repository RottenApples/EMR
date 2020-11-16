package com.example.calender;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import com.example.db.Database;
public class Calendar  implements ActionListener, MouseListener{
	private JFrame frame, frame2;
	private JPanel panel, panel2, panel3, panelPop;
	private JButton[] dates;
	private JScrollPane scroll;
	private JLabel startLabel, endLabel;
	private JTextField field;
	private JButton confirm;
	private String[] months = {"January","February","March","April","May",
			"June","July","August","September","October", "November", "December"};
	private JTable table;
	private int start, end;
	private int col, row;
	private JLabel label;
	private String[][] patients;
	private Database database;
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
	
	
	private JComboBox box, startBox,endBox, patientBox;
	
	public Calendar(Database db){
		database = db;
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		Border border2 = BorderFactory.createLineBorder(Color.BLACK);

		frame = new JFrame();
		frame.setLayout(null);

		field = new JTextField();
		frame2 = new JFrame();
		frame2.setLayout(null);
		frame2.setVisible(false);
		startLabel=new JLabel("Start Time");
		endLabel=new JLabel("End Time");
		startBox = new JComboBox(time);
		endBox = new JComboBox(time);
		panelPop = new JPanel();
		confirm = new JButton("Confirm");
		

		panelPop.add(startLabel);
		panelPop.add(startBox);
		panelPop.add(endLabel);
		panelPop.add(endBox);
		panelPop.add(confirm);
		panelPop.setBounds(0,0,500,200);
		frame2.add(panelPop);
		
		panel = new JPanel();
		panel2 = new JPanel();
		scroll = new JScrollPane();
		panel.setBorder(border);
		panel.setLayout(null);
		panel.setBounds(30,100,350,150);
		
		
		label = new JLabel();
		label.setBounds(30,300,100,20);
		panel2.add(label);
		
		
		panel2.setBorder(border2);
		panel2.setLayout(null);
		panel2.setBounds(700,50,500,500);

	
		table = new JTable(data, weekDays);
	
		
		scroll = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		table.setFillsViewportHeight(true);
		scroll.setBorder(border2);
		scroll.setBounds(30,50,650,500);
		


		
		dates = new JButton[31];
		box = new JComboBox(months);
		box.setBounds(100,40,160,30);
	
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
		
		box.addActionListener(this);
		table.addMouseListener(this);
		panel2.add(box);
		panel2.add(panel);
		frame.add(panel2);
		frame.add(scroll);
		frame.setVisible(true);
		
		frame.setBounds(0,0,1280,720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		confirm.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0; i<31; i++) {
			if(e.getSource() == dates[i]) {
			
				label.setText(box.getSelectedItem() +" "+ dates[i].getName());
		
				
				
				String date = dates[i].getName();
				String month =  String.valueOf((box.getSelectedIndex()+1));
					
				if(box.getSelectedIndex()+1 < 10) {
					
					month = "0" +month;
				}
				
				String timestamp1 = "2020-"+month+"-"+date+" " + "00:00:00"; 
				String timestamp2 = "2020-"+month+"-"+date+" "+"23:59:59";
				
				  
				
				String[][] appoint =database.getApp(timestamp1, timestamp2);
				
				for(int j =0; j<26; j++) {
					table.setValueAt(" ", j, 1);
				}
				
				for(int j =0; j < appoint.length; j++) {
					
				System.out.println(appoint[j][0]+" "+appoint[j][1]+" "+appoint[j][2]+" "+appoint[j][3]+" "+appoint[j][4]);
					
				String appStart[]=appoint[j][1].split(" ");
				String appEnd[]=appoint[j][2].split(" ");
				
				
				String time1, time2;
				
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
				
					for(int h=0; h< time.length; h++) {
						
						if(time[h].equals(time1)) {
							table.setValueAt(name[0] + " " + name[1], h, 1);
							
						}
					
						if(time[h].equals(time2)) {
							
							table.setValueAt(name[0] + " " + name[1], h, 1);
							
						}
						
						
						
						
					}
				}

			
				
			}
			
			
		}
		
		
		
		if(e.getSource() == confirm) {
			start = startBox.getSelectedIndex();
			end = endBox.getSelectedIndex();
			frame2.setVisible(false);
			
	
			String att[] = new String[4];
			att[0] = startBox.getSelectedItem()+ ":00";
			att[1] = endBox.getSelectedItem()+ ":00";
			
		String temp =	(String)patientBox.getSelectedItem();
		String temp2[] = temp.split(" ");
			att[2] = temp2[0];
			att[3] = "0";

			
		}
		
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
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == table) {
			row = table.rowAtPoint(e.getPoint());

			col = table.columnAtPoint(e.getPoint());



			if(e.getButton() == e.BUTTON3) { 
				
			
				frame2.setVisible(true);
				frame2.setBounds(0,0,500,200);
				frame2.setLocationRelativeTo(null);
				frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void setPatient(String[][] patients) {
		
		this.patients = patients;
		String[] temp = new String[patients.length];
		for(int i =0; i< temp.length; i++) {
			
			temp[i] = patients[i][0] + " " +patients[i][1] + " " + patients[i][2];
		}
		
		patientBox = new JComboBox(temp);
		panelPop.add(patientBox);

	}
	
	/*
	public void getAppointments(){
		String appointments[][] = database.getApp();
		String[] tempStart;
		String[] tempEnd;
		String[] temp1;
		String[] temp2;
		
		
		
		tempStart = appointments[0][1].split(" ");
		tempEnd = appointments[0][2].split(" ");
		
		temp1 = tempStart[0].split("-");
		temp2 = tempEnd[0].split("-");
		
		
	}
	*/
	
}
