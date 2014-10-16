package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Paper;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.Conference;
import Model.DatabaseManager;
import Model.PaperSerialization;
import Model.ProgramChair;
import Model.SubprogramChair;
import Model.User;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JRadioButton;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;

import java.awt.Scrollbar;

import javax.swing.JTextArea;

import java.awt.Font;

import javax.swing.JLabel;

import java.awt.SystemColor;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProgramChairPanel extends JPanel
{
	private DefaultListModel paperModel;
	
	private DefaultListModel userModel;
	
	private DefaultListModel SubChairModel;
	
	private DefaultListModel accDecModel;
	
	private ProgramChair myProgramChair;
	
	private SubprogramChair currentSubChair;
	
	private Paper selectedPaper;
	
	private Paper accRejPaper;
	
//	private static ProgramChair chairTest = new ProgramChair("Vladimir", "Gudzyuk", "cooCooCachoo@poop.com",
//			 9 ,666, 1, "HELL", "Hyper Elementary Lessons League");
	
	private DatabaseManager myDm;
	
	private List<SubprogramChair> subChairs;
	
	private List<User> genUser;
	
	private List<Model.Paper> confPapers;
	
	private String conferenceTitle;
	
	private Conference theConf;
	
	public ProgramChairPanel(int width, int height, User theUser, DatabaseManager db)
	{
		
		paperModel = new DefaultListModel();
		
		userModel = new DefaultListModel();
		
		SubChairModel = new DefaultListModel();
		
		accDecModel = new DefaultListModel();
		
		genUser = new ArrayList<User>();
		
		myDm = db;
		
		myProgramChair = (ProgramChair) theUser;
		
		confPapers = new ArrayList<Model.Paper>();
		
		subChairs = new ArrayList<SubprogramChair>();
		
		//sets the conference refrence
		
		for (int i =0; i < db.getConferences().size(); i++)
		{
			if (db.getConferences().get(i).getConfDescription().equals(myProgramChair.getMyConfDescription()))
					{
				
				theConf = db.getConferences().get(i);
				System.out.println("Conference Selected from list");
				break;
					}
		}
		System.out.print(db.toString());
		
		
		addPapersList();
		addSubChairList();
		
		setBackground(SystemColor.menu);
		setForeground(Color.WHITE);
		setLayout(null);
		
		JButton btnNewButtonAssignPaper = new JButton("Assign Papers To...");
		btnNewButtonAssignPaper.setBounds(243, 158, 153, 23);
		add(btnNewButtonAssignPaper);
		
		
		JButton assignSubChairBttn = new JButton("Assign SubProgram Chair");
		assignSubChairBttn.setBounds(44, 416, 189, 23);
		add(assignSubChairBttn);
		
		JList SubChairList = new JList(SubChairModel);
		SubChairList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		SubChairList.setBackground(Color.WHITE);
		//SubChairList.setBounds(414, 54, 192, 138);
		//add(SubChairList);
		JScrollPane subChairPane = new JScrollPane(SubChairList);
		subChairPane.setBounds(414, 54, 192, 138);
		add(subChairPane);
		
		
		
		//////////////////////////////////////////////
		JList papersList = new JList(paperModel);
		papersList.setBorder(null);
		papersList.setBackground(Color.WHITE);
		papersList.setBounds(10, 52, 223, 138);
		add(papersList);
		
		addUserList();
		JList userList = new JList(userModel);
		//add(userList);
		userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		userList.setBackground(Color.WHITE);
		//userList.setBounds(10, 274, 223, 131);
		
		JScrollPane userPane = new JScrollPane(userList);
		userPane.setBounds(10, 274, 223, 131);
		add(userPane);
		/////////////////////////////////////////////////Test Paper
		File file1 = null;
		Model.Paper tester2 = new Model.Paper("We are not alone", "Doopy", file1, 654);
		
		paperModel.addElement(tester2);
		accDecModel.addElement(tester2);
		
		JList acceptDeclineList = new JList(accDecModel);
		acceptDeclineList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		acceptDeclineList.setBackground(Color.WHITE);
		//acceptDeclineList.setBounds(414, 274, 192, 138);
		//add(acceptDeclineList);
		
		JScrollPane addDecPane = new JScrollPane(acceptDeclineList);
		addDecPane.setBounds(414, 274, 192, 138);
		add(addDecPane);
		
		JButton acceptBtn = new JButton("Accept");
		acceptBtn.setBounds(414, 416, 89, 23);
		add(acceptBtn);
		
		JButton rejectBtn = new JButton("Reject");
		rejectBtn.setBounds(517, 416, 89, 23);
		add(rejectBtn);
		
		JTextArea paperAssignments = new JTextArea();
		paperAssignments.setEditable(false);
		paperAssignments.setBackground(Color.WHITE);
		paperAssignments.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		paperAssignments.setBounds(243, 23, 153, 77);
		add(paperAssignments);
		
		JLabel lblPaperAssignments = new JLabel("Paper Assignments:");
		lblPaperAssignments.setBounds(260, 0, 125, 23);
		add(lblPaperAssignments);
		
		JLabel lblSubprogramChairs = new JLabel("Subprogram Chairs:");
		lblSubprogramChairs.setBounds(439, 24, 167, 20);
		add(lblSubprogramChairs);
		
		JLabel lblUserList = new JLabel("User List:");
		lblUserList.setBounds(69, 240, 79, 23);
		add(lblUserList);
		
		JLabel lblPaperList = new JLabel("Paper List");
		lblPaperList.setBounds(10, 27, 115, 20);
		add(lblPaperList);
		assignSubChairBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
	}
	public void addPapersList() 
	{
		for (int i =0; i < theConf.getPapers().size(); i++)
		{
			//confPapers.add(theConf.getPapers().get(i));
			
			confPapers.addAll(theConf.getPapers());
		}
		
//		File file1 = null;
//		Model.Paper tester2 = new Model.Paper("", "", file1, 654);
//		
//		paperModel.addElement(tester2);
//		accDecModel.addElement(tester2);
		for (int i = 0; i < confPapers.size(); i++) 
		{
			paperModel.addElement(confPapers.get(i));
			accDecModel.addElement(confPapers.get(i));
			
		}
		
	}
	
	public void addUserList() 
	{
		if (!(myDm.getUsers()==null)) 
		{
			
		
		for (int i = 0; i < myDm.getUsers().size(); i++) 
		{
			if ((myDm.getUsers().get(i).getRoleId() == 0))
					{
				
				genUser.add(myDm.getUsers().get(i));
					}
		}
		for (int i =0; i < genUser.size(); i++)
		{
			userModel.addElement(genUser.get(i));
			
		}
		}
	}
	
	public void addSubChairList() 
	{
		
		for (int i = 0; i < myDm.getUsers().size(); i ++) {
			int a = myDm.getUsers().get(i).getRoleId();
			
			
			if (a == 2 
					&& ((SubprogramChair)myDm.getUsers().get(i)).getMyConferenceId()==myProgramChair.getConfId()) {
				subChairs.add(((SubprogramChair)myDm.getUsers().get(i)));
				System.out.println("SubChairadded to List");
			}
		}
		
//		for (int i =0; i < theConf.getUsers().size(); i++)
//		{
//			if (!(theConf.getUsers()==null) &&theConf.getUsers().get(i).getRoleId()==2) 
//			{
//				subChairs.add((SubprogramChair) theConf.getUsers().get(i));
//			}
//		}
		
		for (int i =0; i < subChairs.size(); i++) 
		{
			SubChairModel.addElement(subChairs.get(i));
		}
	}
}
