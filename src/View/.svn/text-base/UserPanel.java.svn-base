//package View;
//
//import java.awt.Component;
//import java.awt.Dimension;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.Locale;
//
//import javax.swing.DefaultListModel;
//import javax.swing.JButton;
//import javax.swing.JFileChooser;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//import javax.swing.ListCellRenderer;
//
//import Model.Author;
//import Model.Paper;
//import Model.PaperSerialization;
//import Model.User;
//
//import javax.swing.JTable;
//import javax.swing.JList;
//import javax.swing.ListSelectionModel;
//import javax.swing.event.ListSelectionEvent;
//import javax.swing.event.ListSelectionListener;
//import javax.swing.table.DefaultTableCellRenderer;
//import javax.swing.JTextArea;
//import javax.swing.JToolBar;
//import javax.swing.JMenuBar;
//import javax.swing.JMenu;
//import javax.swing.JMenuItem;
//
//public abstract class UserPanel extends JPanel implements ActionListener
//{
//	private JLabel name;
//	private JLabel role;
//	private JLabel email;
//	private JLabel searchPaper;
//	private JLabel submittedPapers;
//	private JLabel conferences;
//	private JTextField search;
//	private JButton submitPaper;
//	private int myWidth, myHeight;
//	private User user;
//	private JList list;
//	JTextArea textArea;
//	JButton DeleteSelectedPaper;
//	DefaultListModel listModel = new DefaultListModel();
//<<<<<<< .mine
//	int j;
//=======
//	private Component chosen;
//>>>>>>> .r93
//	
//	
//	
//	/**
//	 * Create a new General user panel that has all the labels, buttons, and menus.
//	 * @param width Width of the panel.
//	 * @param height Height of the panel.
//	 */
//	public UserPanel(int width, int height, User theUser)
//	{
////		myWidth =  width;
////		myHeight = height;
////		setPreferredSize(new Dimension(width, height));
//		user = theUser;
//		name = new JLabel("Name: " + user.getFirstName() + " " + user.getLastName());
//		name.setBounds(29, 31, 223, 20);
//		email = new JLabel("Email: " + user.getEmail());
//		email.setBounds(29, 64, 223, 20);
//		submitPaper = new JButton("Submit Paper");
//		submitPaper.setBounds(470, 380, 127, 29);
//		submitPaper.addActionListener(this);
//		setLayout(null);
//		
//		this.add(name);
//		this.add(email);
//		this.add(submitPaper);
//		
//		DeleteSelectedPaper = new JButton("Delete Selected Paper");
//		DeleteSelectedPaper.setBounds(257, 380, 198, 29);
//		DeleteSelectedPaper.addActionListener(this);
//		add(DeleteSelectedPaper);
//		
//		
//		list = new JList(listModel);
//		list.setValueIsAdjusting(false);
//		list.setLayoutOrientation(JList.VERTICAL);
//		list.setCellRenderer(new localeRenderer());
//		updateList(list);
//		list.addListSelectionListener(new ListSelectionListener() {
//	          private Paper chosen;
//
//			public void valueChanged(ListSelectionEvent e) {
//	        	  
//<<<<<<< .mine
//	        	  int i = list.getSelectedIndex();
//	        	  j = i;
//	        	  list.setSelectedIndex(i);
//	        	  Paper target = (Paper) list.getModel().getElementAt(i);
//	        	  updateText(target);
//=======
////	        	  int i = list.getSelectedIndex();
////	        	  list.setSelectedIndex(i);
////	        	  Paper target = (Paper) list.getModel().getElementAt(i);
//	        	 chosen = (Paper) list.getSelectedValue();
//	        	  
//	        	  updateText(chosen);
//>>>>>>> .r93
//	            }
//	          });
//			
//		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		list.setBounds(29, 111, 189, 234);
//		
//		
//		add(list);
//		
//		textArea = new JTextArea();
//		textArea.setEditable(false);
//		textArea.setBounds(233, 112, 223, 126);
//		
//		add(textArea);
//		
//		JMenuBar menuBar = new JMenuBar();
//		menuBar.setBounds(0, -8, 119, 26);
//		add(menuBar);
//		
//		JMenu mnFile = new JMenu("File");
//		menuBar.add(mnFile);
//		
//		JMenuItem mntmShowPapers = new JMenuItem("Show Papers..");
//		mnFile.add(mntmShowPapers);
//		
//		
//		
//		JMenuItem mntmShowSubprogramChairs = new JMenuItem("Show Subprogram Chairs");
//		mntmShowSubprogramChairs.setEnabled(false);
//		mnFile.add(mntmShowSubprogramChairs);
//		
//		JMenuItem mntmShowReviewer = new JMenuItem("Show Reviewer");
//		mnFile.add(mntmShowReviewer);
//		
//		JMenu mnEdit = new JMenu("Edit");
//		menuBar.add(mnEdit);
//		
//	}
//	
//	/**
//	 * Create a submit paper button that brings up a file chooser.
//	 * choose a paper from the file chooser and when submit is pressed,
//	 * send the paper to a conference. 
//	 */
//	private void submitPaper()
//	{
//		JFrame submitFrame = new SubmitPaperFrame(400,400,user);
//		submitFrame.setVisible(true);
//	}
//	
//	private void updateConference()
//	{
//		
//	}
//	@Override
//	public void actionPerformed(ActionEvent event)
//	{
//		if(event.getSource() == submitPaper)
//		{
//			submitPaper();
//			updateList(list);
//		}
//		if(event.getSource() == DeleteSelectedPaper)
//		{
//<<<<<<< .mine
//			int i = list.getSelectedIndex();
//			Paper target = (Paper) list.getModel().getElementAt(i);
//			
//			removePaper(target);
//			updateList(list);
//=======
//			//listModel.removeElementAt(list.getSelectedIndex());
//			//System.out.println(listModel);
//			if(listModel != null)
//			{
//				listModel.clear();
//				updateList(list);
//			}
//			
//>>>>>>> .r93
//		}
//	}
//	private void removePaper(Paper toRemove) {
//		for(int i = 0; i < PaperSerialization.papers.size(); i++)
//		{
//			if(toRemove.getTitle() == PaperSerialization.papers.get(i).getTitle());
//			{
//				PaperSerialization.papers.remove(i);
//			}
//		}
//		this.repaint();
//		
//	}
//
//	public void updateText(Paper target) {
//		
//		  textArea.setText(target.toString());
//	      
//	      this.repaint(); 
//	}
//	public void updateList(JList list)
//	{
//		listModel.clear();
//		for(int i = 0; i < PaperSerialization.papers.size(); i++)
//		{
//			listModel.addElement(PaperSerialization.papers.get(i));
//		}
//		//listModel.addElement(new Author("melaku", "last", "abc", 1, 4));
//		
//		this.repaint();
//	}
//	public class localeRenderer extends JLabel implements ListCellRenderer  {
//
//		private static final long serialVersionUID = 1L;
//
//		public Component getListCellRendererComponent(JList list, Object value, int index,
//			      boolean isSelected, boolean cellHasFocus) {
//			    setText(((Paper)list.getModel().getElementAt(index)).getTitle());
//		
//			    return this;
//			  }
//	}
//}
