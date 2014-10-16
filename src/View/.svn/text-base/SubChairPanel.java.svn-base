package View;

import Model.DatabaseManager;
import Model.Reviewer;
import Model.SubprogramChair;
import Model.User;

import javax.swing.CellRendererPane;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.ListCellRenderer;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SubChairPanel extends JPanel
{

	private List <Reviewer> reviewers;
	private JList list;

	private DefaultListModel model;
	private Reviewer curReviewer;
	private JTextArea textArea;
	private JButton btnAssignPapers;
	public SubChairPanel(int width, int height, User user, DatabaseManager db)
	{
		setLayout(null);

		JLabel lblName = new JLabel(user.getLastName() + user.getFirstName());
		lblName.setBounds(12, 45, 80, 16);
		add(lblName);
		

		JLabel lblSubprogramChair = new JLabel("Subprogram Chair");
		lblSubprogramChair.setBounds(12, 74, 113, 16);
		add(lblSubprogramChair);

		model = new DefaultListModel();
		initializeReviewers(db);
		list = new JList(model);
		//list.setCellRenderer(new localeRenderer());
		listSelectionListener();
		JScrollPane pane = new JScrollPane(list);
		// add(pane, BorderLayout.NORTH);
		pane.setBounds(12, 153, 226, 251);
		add(pane);
		//curReviewer = reviewers.get(1);
		textArea = new JTextArea();
		//textArea.setText(curReviewer.revInfo());
		
		
		
		JScrollPane textPane = new JScrollPane(textArea);
		textPane.setBounds(310, 151, 290, 253);
		
		add(textPane);

		btnAssignPapers = new JButton("Assign Papers");
		btnAssignPapers.setEnabled(false);
		btnAssignPapers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AssignPapers paperAssign = new AssignPapers(curReviewer);
				paperAssign.pack();
				paperAssign.setVisible(true);
			}
		});
		btnAssignPapers.setBounds(81, 417, 137, 25);
		add(btnAssignPapers);

	}
	/**
	 * Get all reviewers from the database
	 * @param db The database.
	 */
	public void initializeReviewers(DatabaseManager db)
	{
		reviewers = new ArrayList<Reviewer>();
		for(int i = 0; i < db.getUsers().size(); i++)
		{
			//role id = 0 or null--> author, role id= 1 --> PChair
			//role id = 2 --> SubChair
			if(db.getUsers().get(i).getRoleId() == 4)
			{
				reviewers.add((Reviewer) db.getUsers().get(i));
			}
		}
		
		for (int i = 0; i < reviewers.size(); i++)
		{
			model.addElement(reviewers.get(i));
			
		}


	}	
	
	private void listSelectionListener()
	{
		
		list.addListSelectionListener(new ListSelectionListener() {
		      public void valueChanged(ListSelectionEvent evt) {
		        if (evt.getValueIsAdjusting())
		          return;
		       
		        	btnAssignPapers.setEnabled(true);
		        
		        int i = list.getSelectedIndex();
		        curReviewer = (Reviewer) list.getModel().getElementAt(i);
		       
		        textArea.setText(curReviewer.revInfo(curReviewer));
		        //System.out.println("Selected from " + evt.getFirstIndex() + " to " + evt.getLastIndex());
		      }
		    });
	}
		
}
	
