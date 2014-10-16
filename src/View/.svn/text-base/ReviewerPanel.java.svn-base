package View;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import Model.Paper;
import Model.PaperSerialization;
import Model.User;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextArea;



public class ReviewerPanel extends JPanel
{
	private int height;
	private int width;
	private User user;
	private JPanel myPanel;
	private JButton reviewButton;
	private JButton summaryButton;
	private String mySummary;
	private int[] reviewNum;
	private String userName;
	private JFileChooser chooser = new JFileChooser();
	private JList paperList;
	DefaultListModel listModel = new DefaultListModel();
	private JTextArea textArea;
	
	public ReviewerPanel(int theWidth, int theHeight, User theUser) 
	{
		height = theHeight;
		width = theWidth;
		user = theUser;
		userName = user.getFirstName() + " " + user.getLastName();
		//Window builder code
		setLayout(null);
		
		JLabel lblName = new JLabel("Name: " + user.getFirstName() + " "+ user.getLastName());
		lblName.setBounds(15, 16, 300, 20);
		add(lblName);
		
		JLabel lblEmail = new JLabel("Email: " + user.getEmail());
		lblEmail.setBounds(15, 52, 174, 20);
		add(lblEmail);
		
		JButton btnSubmitReview = new JButton("Submit Review");
		btnSubmitReview.setBounds(460, 394, 146, 29);
		btnSubmitReview.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int returnVal = chooser.showOpenDialog(ReviewerPanel.this);
		        File file = null;
				if (returnVal == JFileChooser.APPROVE_OPTION) {
		            file = chooser.getSelectedFile();
		        }
				addReview(file);
		}});
		add(btnSubmitReview);
		
		JButton btnGetReview = new JButton("Get Review Form");
		btnGetReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()) {
				    try {
				        File myFile = new File("Conference Review Form.docx");
				        Desktop.getDesktop().open(myFile);
				    } catch (IOException ex) {
				        // no application registered for file
				    }
				}
				
			}
		});
		btnGetReview.setBounds(91, 394, 193, 29);
		add(btnGetReview);
		
		paperList = new JList();
		paperList.setModel(listModel);
		paperList.setLayoutOrientation(JList.VERTICAL);
		paperList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		paperList.setBounds(35, 142, 123, 145);
		paperList.addListSelectionListener(new ListSelectionListener() {
	          private Paper chosen;

			public void valueChanged(ListSelectionEvent e) {
	        	  
//	        	  int i = list.getSelectedIndex();
//	        	  list.setSelectedIndex(i);
//	        	  Paper target = (Paper) list.getModel().getElementAt(i);
	        	 chosen = (Paper) paperList.getSelectedValue();
	        	  
	        	 updateText(chosen);
	            }

			
	          });
		updateList(paperList);
		add(paperList);
		
		JButton btnNewButton = new JButton("Review 1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Desktop.isDesktopSupported()) {
				    try {
				        File myFile = ((Paper)paperList.getSelectedValue()).getReview(0);
				        Desktop.getDesktop().open(myFile);
				    } catch (IOException ex) {
				        // no application registered for file
				    }
				}
			}
		});
		btnNewButton.setBounds(460, 139, 115, 29);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Review 2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Desktop.isDesktopSupported()) {
				    try {
				        File myFile = ((Paper)paperList.getSelectedValue()).getReview(1);
				        Desktop.getDesktop().open(myFile);
				    } catch (IOException ex) {
				        // no application registered for file
				    }
				}
			}
		});
		btnNewButton_1.setBounds(460, 177, 115, 29);
		add(btnNewButton_1);
		
		JButton btnReview = new JButton("Review 3");
		btnReview.setBounds(460, 211, 115, 29);
		btnReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Desktop.isDesktopSupported()) {
				    try {
				        File myFile = ((Paper)paperList.getSelectedValue()).getReview(2);
				        Desktop.getDesktop().open(myFile);
				    } catch (IOException ex) {
				        // no application registered for file
				    }
				}
			}
		});
		add(btnReview);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(211, 143, 151, 145);
		add(textArea);
		
		JButton btnViewPaper = new JButton("View Paper");
		btnViewPaper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()) {
					 try {
					     File myFile = ((Paper)paperList.getSelectedValue()).getFile();
					     Desktop.getDesktop().open(myFile);
					 } catch (IOException ex) {
					        // no application registered for file
					 }
			     }
			}
		});
		btnViewPaper.setBounds(330, 394, 115, 29);
		add(btnViewPaper);

		
		
		
		reviewButton = new JButton("Paper Review");
		reviewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				createReviewPanel(reviewNum);
		}});
		
		setPanel(myPanel);
		
		summaryButton = new JButton("Submit Paper Summary");
		summaryButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				createSummaryPanel(mySummary);
			}
		});
		
		
		
	}
	/**
	 * Adds File to papers reviewarray
	 * 
	 * @param file
	 */
	public void addReview(File file) {
		((Paper) paperList.getSelectedValue()).setReview(file);
		
	}
	public void updateList(JList list)
	{
		System.out.println(userName);
		//listModel.clear();
		for(int i = 0; i < PaperSerialization.papers.size(); i++)
		{
			for(int j = 0; j < 3; j++)
			{
				
				if(userName.equals(PaperSerialization.papers.get(i).getTheReviewer(j)))
				{
					listModel.addElement(PaperSerialization.papers.get(i));
				}
			}
		}
		//listModel.addElement(new Author("melaku", "last", "abc", 1, 4));
		
		this.repaint();
	}
	public void updateText(Paper thePaper) {
		textArea.setText(thePaper.getFullStatus());
		this.repaint();
		
		
	}

	/**
	 * @author Alex Stirngham
	 * @param reviewNum an array of integers received by the radiobutton inputs
	 * @return an int array of review numbers
	 */
	public int[] createReviewPanel(final int[] reviewNum)
	{
		int[] numberReviews;
		

		JPanel reviewPanel;
		reviewPanel = new JPanel();
		reviewPanel.setSize(800, 600);
		
		
		/*
		 * These are int arrays  from 1 to 5. They are set to different
		 * JRadioButtons to indicate different review scores. These 
		 * represent the 9 review questions, 1 overall summary score
		 * and a summary review at the end
		 * 
		 *  **************************NOTE**************************
		 *  I haven't been able to return the values from the radiobuttons
		 *  so that they are available to the paper. That is currently being
		 *  worked on.
		 *  **************************NOTE**************************
		 *  NOTE FROM MATT:
		 *  Uhhhh we set up the review functionality so we don't actually have to
		 *  use this
		 */
		
		//Review question 1
		int[] review1 = {1,2,3,4,5};
		JLabel question1 = new JLabel("Can the content be directly applied by classroom instructors or curriculum designers? ");
		reviewPanel.add(question1);		
		JRadioButton[] q1 = new JRadioButton[review1.length];
		ButtonGroup group1 = new ButtonGroup();
		for(int i = 0; i < review1.length; i++)
		{
			group1.add(q1[i]);
			reviewPanel.add(q1[i]);
		}
		
		ActionListener listner1 = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent action) {
				if(action.getSource() instanceof JRadioButton){
		            JRadioButton radioButton = (JRadioButton) action.getSource();
		            String temp;
		            if(radioButton.isSelected()){
		               temp = radioButton.getText();
		               reviewNum[1] = Integer.parseInt(temp);
		            }
		        }
		    }
			
		};
	
		
		//Review question 2
		int[] review2 = {1,2,3,4,5};
		JLabel question2 = new JLabel("Does the work appeal to a broad readership interested in engineering education or is it narrowly specialized? ");
		reviewPanel.add(question2);		
		JRadioButton[] q2 = new JRadioButton[review2.length];
		ButtonGroup group2 = new ButtonGroup();
		for(int i = 0; i < review2.length; i++)
		{
			group1.add(q2[i]);
			reviewPanel.add(q2[i]);
		}

		//Review question 3
		int[] review3 = {1,2,3,4,5};
		JLabel question3 = new JLabel("Does the work address a significant problem? ");
		reviewPanel.add(question3);		
		JRadioButton[] q3 = new JRadioButton[review3.length];
		ButtonGroup group3 = new ButtonGroup();
		for(int i = 0; i < review3.length; i++)
		{
			group1.add(q3[i]);
			reviewPanel.add(q3[i]);
		}

		//Review question 4
		int[] review4 = {1,2,3,4,5};
		JLabel question4 = new JLabel("Does the author build upon relevant references and bodies of knowledge?");
		reviewPanel.add(question4);		
		JRadioButton[] q4 = new JRadioButton[review4.length];
		ButtonGroup group4 = new ButtonGroup();
		for(int i = 0; i < review4.length; i++)
		{
			group1.add(q4[i]);
			reviewPanel.add(q4[i]);
		}

		//Review question 5
		int[] review5 = {1,2,3,4,5};
		JLabel question5 = new JLabel("If a teaching intervention is reported, is it adequately evaluated in terms of its impact on learning in actual use? ");
		reviewPanel.add(question5);		
		JRadioButton[] q5 = new JRadioButton[review5.length];
		ButtonGroup group5 = new ButtonGroup();
		for(int i = 0; i < review5.length; i++)
		{
			group1.add(q5[i]);
			reviewPanel.add(q5[i]);
		}

		//Review question 6
		int[] review6 = {1,2,3,4,5};
		JLabel question6 = new JLabel("Does the author use methods appropriate to the goals, both for the instructional intervention and the evaluation of impact on learning?");
		reviewPanel.add(question6);		
		JRadioButton[] q6 = new JRadioButton[review6.length];
		ButtonGroup group6 = new ButtonGroup();
		for(int i = 0; i < review6.length; i++)
		{
			group1.add(q6[i]);
			reviewPanel.add(q6[i]);
		}

		//Review question 7
		int[] review7 = {1,2,3,4,5};
		JLabel question7 = new JLabel("Did the author provide sufficient detail to replicate and evaluate?");
		reviewPanel.add(question7);		
		JRadioButton[] q7 = new JRadioButton[review7.length];
		ButtonGroup group7 = new ButtonGroup();
		for(int i = 0; i < review7.length; i++)
		{
			group1.add(q7[i]);
			reviewPanel.add(q7[i]);
		}

		//Review question 8
		int[] review8 = {1,2,3,4,5};
		JLabel question8 = new JLabel("Is the paper clearly and carefully written?");
		reviewPanel.add(question8);		
		JRadioButton[] q8 = new JRadioButton[review8.length];
		ButtonGroup group8 = new ButtonGroup();
		for(int i = 0; i < review8.length; i++)
		{
			group1.add(q8[i]);
			reviewPanel.add(q8[i]);
		}

		//Review question 9
		int[] review9 = {1,2,3,4,5};
		JLabel question9 = new JLabel("Does the paper adhere to accepted standards of style, usage, and composition?");
		reviewPanel.add(question9);		
		JRadioButton[] q9 = new JRadioButton[review9.length];
		ButtonGroup group9 = new ButtonGroup();
		for(int i = 0; i < review9.length; i++)
		{
			group1.add(q9[i]);
			reviewPanel.add(q9[i]);
		}
		
		//Summary review question
		int[] summaryNum = {1,2,3,4,5};
		JLabel summaryQuestion = new JLabel("Summary Review Score");
		reviewPanel.add(summaryQuestion);		
		JRadioButton[] q10 = new JRadioButton[summaryNum.length];
		ButtonGroup group10 = new ButtonGroup();
		for(int i = 0; i < summaryNum.length; i++)
		{
			group1.add(q10[i]);
			reviewPanel.add(q10[i]);
		}
		return summaryNum;
		

		
				
		



	}
	
	/**
	 * @author Alex Stringham
	 * 
	 * @param theSummary summary of the paper given by the reviewer
	 * @return theSummary from the reviewer
	 */
	public String createSummaryPanel(String theSummary)
	{
		//creates a new JPanel
		JPanel summaryPanel;
		summaryPanel = new JPanel();
		summaryPanel.setSize(800, 600);
		
		
			//Gets the text from the reviewers summary
			//and stores it in mySummary
			JLabel summary = new JLabel("Paper Summary:");
			summaryPanel.add(summary);
			JTextField summaryField = new JTextField("Please enter your summary of this paper...");
			summaryField.setEditable(true);
			theSummary = summaryField.getText();
		
		return theSummary;
		
	}
	
	
	
	
	
	public void setPanel(JPanel panel)
	{
		panel = new JPanel();
	}
}
