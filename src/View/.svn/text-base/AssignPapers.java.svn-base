package View;

import java.awt.Dimension;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Model.Paper;
import Model.PaperSerialization;
import Model.Reviewer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AssignPapers extends JFrame
{
	private List<Paper> papers;
	private Paper curPaper;
	private DefaultListModel model;
	private JList list;
	private JTextArea textArea;
	public AssignPapers(final Reviewer reviewer) {
		
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(450, 280));
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 432, 255);
		
		panel.setLayout(null);
		
		JLabel lblPapers = new JLabel("Papers");
		lblPapers.setBounds(12, 41, 56, 16);
		panel.add(lblPapers);
		
		model = new DefaultListModel();
		//list.setCellRenderer(new localeRenderer());
		
		
		JButton btnAssign = new JButton("Assign");
		btnAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				assignPaper(curPaper, reviewer);
			}
		});
		btnAssign.setBounds(323, 37, 97, 25);
		panel.add(btnAssign);
		panel.setPreferredSize(new Dimension(432, 255));
		getContentPane().add(panel);
		
		list = new JList(model);
		initializePapers();
		listSelectionListener();
		list.setBounds(12, 80, 144, 162);
		panel.add(list);
		JScrollPane pane = new JScrollPane();
		pane.setBounds(12, 80, 144, 162);
		panel.add(pane);
		//textArea.setText(curReviewer.revInfo());
		
		
		textArea = new JTextArea();
		JScrollPane textPane = new JScrollPane(textArea);		
		
		
		textPane.setBounds(268, 80, 152, 141);
		panel.add(textPane);
		//curReviewer = reviewers.get(1);
		
		
		
		
	}
	
	private void initializePapers() 
	{
		for(int i = 0; i < PaperSerialization.papers.size(); i++)
		{
			model.addElement(PaperSerialization.papers.get(i));
		}
			
		
	}

	private void listSelectionListener() 
	{
		list.addListSelectionListener(new ListSelectionListener() {
		      public void valueChanged(ListSelectionEvent evt) {
		        if (evt.getValueIsAdjusting())
		          return;
		       
		        	//btnAssignPapers.setEnabled(true);
		        
		        int i = list.getSelectedIndex();
		        curPaper = (Paper) list.getModel().getElementAt(i);
		        textArea.setText(curPaper.getFullStatus());
		        //System.out.println("Selected from " + evt.getFirstIndex() + " to " + evt.getLastIndex());
		      }
		    });
		
	}

	private void assignPaper(Paper paper, Reviewer rev)
	{
		paper.setReviewer(rev);
		
		this.dispose();
	}
}
