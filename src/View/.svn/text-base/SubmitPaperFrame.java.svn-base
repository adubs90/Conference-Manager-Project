
/**
 * @author Matt Dufalo
 * This class is a form for submitting papers.
 * 
 */
package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Paper;
import Model.PaperSerialization;
import Model.User;

public class SubmitPaperFrame extends JFrame implements ActionListener {
	private JLabel paperName;
	private JTextField paperNameInput;
	private JLabel authorName;
	private JFileChooser chooser = new JFileChooser();
	private JButton findFileButton;
	private JButton submitPaper;
	private JLabel fileDisplay;
	private JPanel panel;
	private User user;
	private AuthorPanel aPanel;
	private JList list;
	/**
	 * Contructs the frame
	 * @param height height of the frame
	 * @param width  width of the frame
	 * @param user the user using the frame.
	 * @param authorPanel 
	 * @param list 
	 * @param userPanel 
	 */
	public SubmitPaperFrame(int height, int width, User user, AuthorPanel authorPanel, JList theList)
	{	
		this.setSize(406, 264);
		
		panel = new JPanel();
		panel.setSize(400, 400);
		this.user = user;
		aPanel = authorPanel;
		list = theList;
		paperName = new JLabel("Enter name of paper: ");
		paperName.setBounds(15, 9, 156, 20);
		paperNameInput = new JTextField(15);
		paperNameInput.setBounds(166, 6, 216, 26);
		fileDisplay = new JLabel("File: ");
		fileDisplay.setBounds(15, 126, 299, 20);
		
		authorName = new JLabel("Author Name: " + user.getFirstName() + " " + user.getLastName());
		authorName.setBounds(15, 45, 299, 20);
		findFileButton = new JButton("Find File");
		findFileButton.setBounds(15, 81, 91, 29);
		submitPaper = new JButton("Submit Paper");
		submitPaper.setBounds(111, 157, 127, 29);
		submitPaper.addActionListener(this);
		findFileButton.addActionListener(this);
		panel.setLayout(null);
		
		panel.add(paperName);
		panel.add(paperNameInput);
		panel.add(authorName);
		panel.add(fileDisplay);
		panel.add(findFileButton);
		panel.add(submitPaper);
//		
		this.setLocationRelativeTo(null);
		getContentPane().add(panel);
		
		
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == findFileButton)
		{
			submitPaper();
			
		}
		if(event.getSource() == submitPaper)
		{
			aPanel.updateList(list);
			getFile();
		}
	}



	private void submitPaper() {
		String name = paperNameInput.getText();
		int returnVal = chooser.showOpenDialog(SubmitPaperFrame.this);

        File file = null;
		if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
		
        }
		fileDisplay.setText("File: " + file.getName());
		
        Paper addedPaper = new Paper(name, user.getFirstName() + " " + user.getLastName() ,file,1);
        PaperSerialization.papers.add(addedPaper);
        
        panel.repaint();
        
        
		
	}



	private void getFile() {
		// TODO Auto-generated method stub
		this.dispose();
	}

}
