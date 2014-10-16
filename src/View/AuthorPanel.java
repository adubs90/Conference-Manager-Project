package View;

import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Paper;
import Model.PaperSerialization;
import Model.User;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextArea;

public class AuthorPanel extends JPanel implements ActionListener {
	private JLabel name;
	private JLabel role;

	private JLabel searchPaper;
	private JLabel submittedPapers;
	private JLabel conferences;
	private JTextField search;
	private JButton submitPaper;
	private int myWidth, myHeight;
	private User user;
	@SuppressWarnings("rawtypes")
	private JList list;
	JTextArea textArea;
	JButton DeleteSelectedPaper;
	DefaultListModel listModel = new DefaultListModel();
	private JLabel lblChooseConference;
	private JButton btnViewPaper;
	private String userName;

	/**
	 * @author Matt Dufalo
	 * 
	 *         Create a new Author panel that has all the labels, buttons, and
	 *         menus.
	 * @param width
	 *            Width of the panel.
	 * @param height
	 *            Height of the panel.
	 */
	public AuthorPanel(int width, int height, User theUser) {
		myWidth = width;
		myHeight = height;
		setPreferredSize(new Dimension(width, height));
		user = theUser;
		userName = user.getFirstName() + " " + user.getLastName();
		name = new JLabel("Name: " + user.getFirstName() + " "
				+ user.getLastName());
		name.setBounds(29, 31, 223, 20);
		role = new JLabel("Author");
		role.setBounds(29, 64, 223, 20);
		submitPaper = new JButton("Submit Paper");
		submitPaper.setBounds(470, 380, 127, 29);
		submitPaper.addActionListener(this);
		setLayout(null);

		this.add(name);
		this.add(role);
		this.add(submitPaper);

		DeleteSelectedPaper = new JButton("Delete Selected Paper");
		DeleteSelectedPaper.setBounds(257, 380, 198, 29);
		DeleteSelectedPaper.addActionListener(this);
		add(DeleteSelectedPaper);

		// This part intializes list then adds to panel
		list = new JList(listModel);
		list.setLayoutOrientation(JList.VERTICAL);
		updateList(list);
		list.addListSelectionListener(new ListSelectionListener() {
			private Paper chosen;

			public void valueChanged(ListSelectionEvent e) {
				int i = list.getSelectedIndex();
		        chosen = (Paper) list.getModel().getElementAt(i);
		       
		        textArea.setText(chosen.getFullStatus());
			}
		});
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(29, 111, 189, 234);
		add(list);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(374, 216, 223, 126);

		add(textArea);

		lblChooseConference = new JLabel("Choose Conference");
		lblChooseConference.setBounds(416, 95, 142, 16);
		add(lblChooseConference);

		btnViewPaper = new JButton("View Paper");
		btnViewPaper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()) {
					try {
						File myFile = ((Paper) list.getSelectedValue())
								.getFile();
						Desktop.getDesktop().open(myFile);
					} catch (IOException ex) {
						// no application registered for file
					}
				}
			}
		});
		btnViewPaper.setBounds(127, 380, 115, 29);
		add(btnViewPaper);

	}

	/**
	 * @author Matt Dufalo
	 * 
	 *         Create a submit paper button that brings up a file chooser.
	 *         choose a paper from the file chooser and when submit is pressed,
	 *         send the paper to a conference.
	 */
	private void submitPaper() {
		JFrame submitFrame = new SubmitPaperFrame(400, 400, user, this, list);
		submitFrame.setVisible(true);
	}

	/**
	 * @author Matt Dufalo
	 * 
	 *         action listeners for buttons on this panel
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == submitPaper) {
			submitPaper();
			updateList(list);
		}
		if (event.getSource() == DeleteSelectedPaper) {
			// listModel.removeElementAt(list.getSelectedIndex());
			// System.out.println(listModel);
			if (listModel != null) {
				listModel.clear();
				updateList(list);
			}

		}
	}

	/**
	 * @author Matt Dufalo
	 * 
	 *         Update status field when a paper is selected.
	 * @param target
	 *            the paper to to get status from
	 */
	public void updateText(Paper target) {

		textArea.setText(target.getFullStatus());

		this.repaint();
	}

	/**
	 * @author Matt Dufalo
	 * 
	 *         Updates Jlist that holds selectable papers.
	 * @param list
	 */
	public void updateList(JList list) {
		listModel.clear();
		for (int i = 0; i < PaperSerialization.papers.size(); i++) {
			if (userName.equals(PaperSerialization.papers.get(i).getAuthor())) {
				listModel.addElement(PaperSerialization.papers.get(i));
			}
		}

		this.repaint();
	}

}
