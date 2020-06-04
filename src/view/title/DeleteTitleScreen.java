package view.title;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.KeyController;
import model.UltraVisionManagementSystem;
import model.titles.Title;

public class DeleteTitleScreen implements FocusListener {

	private JFrame deleteTitleScreen = new JFrame();
	private KeyController listenerController = new KeyController(deleteTitleScreen);

	private UltraVisionManagementSystem managementSystem = new UltraVisionManagementSystem(0);

	private JTextField titleIDtf;

	private Title title = new Title(0);

	public DeleteTitleScreen() {
		setAttributes();
		setComponents();
		validation();
	}

	public void setAttributes() {
		deleteTitleScreen.setSize(880, 260);
		deleteTitleScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		deleteTitleScreen.setUndecorated(true);
		deleteTitleScreen.setVisible(true);
		deleteTitleScreen.setResizable(false);
		deleteTitleScreen.setTitle("Ultra-Vision | Title Removal");
		deleteTitleScreen.setLocationRelativeTo(null);
		deleteTitleScreen.setIconImage(new ImageIcon("img\\icons\\ultravisionicon.png").getImage());

		deleteTitleScreen.addKeyListener(listenerController);
		deleteTitleScreen.addWindowListener(listenerController);
		deleteTitleScreen.addMouseListener(listenerController);
		deleteTitleScreen.addMouseMotionListener(listenerController);
	}

	public void setComponents() {

		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 140, 190));
		deleteTitleScreen.add(backPanel);

		closeBtn(backPanel);

		JLabel deleteCustomerIcon = new JLabel();
		deleteCustomerIcon.setIcon(new ImageIcon("img\\icons\\deletetitleicon.png"));
		deleteCustomerIcon.setBounds(40, 60, 170, 170);
		backPanel.add(deleteCustomerIcon);

		JLabel newCustomerLabel = new JLabel("Delete Title");
		newCustomerLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		newCustomerLabel.setBounds(40, 10, 300, 35);
		newCustomerLabel.setForeground(Color.WHITE);
		backPanel.add(newCustomerLabel);

		buttons(backPanel);

		JPanel backRectangle = new JPanel();
		backRectangle.setLayout(null);
		backRectangle.setBackground(new Color(0, 80, 110));
		backRectangle.setBounds(0, 50, deleteTitleScreen.getWidth(), deleteTitleScreen.getHeight() - 70);
		backPanel.add(backRectangle);

		JLabel searchIDLabel = new JLabel("Search to get ID");
		searchIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		searchIDLabel.setBounds(320, 10, 350, 35);
		searchIDLabel.setForeground(Color.WHITE);
		backRectangle.add(searchIDLabel);

		titleIDtf = new JTextField();
		titleIDtf.setText("enter title id to delete");
		titleIDtf.setHorizontalAlignment(JTextField.CENTER);
		titleIDtf.setForeground(new Color(180, 180, 180));
		titleIDtf.addFocusListener(this);
		titleIDtf.setBounds(570, 40, 250, 45);
		titleIDtf.setBorder(null);
		titleIDtf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		backRectangle.add(titleIDtf);

	}

	public void closeBtn(JPanel backPanel) {

		JButton closeBtn = new JButton();
		closeBtn.setIcon(new ImageIcon("img\\btn\\closebtnsmall.png"));
		closeBtn.setBounds(840, 10, 30, 30);
		closeBtn.setBorderPainted(false);
		closeBtn.setContentAreaFilled(false);
		closeBtn.setFocusPainted(false);
		backPanel.add(closeBtn);
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteTitleScreen.dispose();
			}
		});
		closeBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				closeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				closeBtn.setIcon(new ImageIcon("img\\btn\\hover\\closebtnsmallhover.png"));
				closeBtn.setBounds(837, 6, 36, 36);
			}

			public void mouseExited(MouseEvent evt) {
				closeBtn.setIcon(new ImageIcon("img\\btn\\closebtnsmall.png"));
				closeBtn.setBounds(840, 10, 30, 30);
			}
		});
	}

	public void buttons(JPanel backRectangle) {

		// ----------------Search Customer
		// Button----------------------------------------------
		JButton searchTitleBtn = new JButton();
		searchTitleBtn.setIcon(new ImageIcon("img\\btn\\searchtitlebtn.png"));
		searchTitleBtn.setBackground(backRectangle.getBackground());
		searchTitleBtn.setBounds(264, 112, 230, 106);
		searchTitleBtn.setBorderPainted(false);
		searchTitleBtn.setContentAreaFilled(false);
		searchTitleBtn.setFocusPainted(false);
		backRectangle.add(searchTitleBtn);
		searchTitleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchTitleScreen();
			}
		});
		searchTitleBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				searchTitleBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				searchTitleBtn.setIcon(new ImageIcon("img\\btn\\hover\\searchtitlebtnhover.png"));
				searchTitleBtn.setBounds(260, 110, 239, 110);
			}

			public void mouseExited(MouseEvent evt) {
				searchTitleBtn.setIcon(new ImageIcon("img\\btn\\searchtitlebtn.png"));
				searchTitleBtn.setBounds(264, 112, 230, 106);
			}
		});
		// ---------------------------DELETE BUTTON-------------------------------
		JButton deleteBtn = new JButton();
		deleteBtn.setIcon(new ImageIcon("img\\btn\\deletebtn.png"));
		deleteBtn.setBackground(backRectangle.getBackground());
		deleteBtn.setBounds(580, 120, 230, 106);
		deleteBtn.setBorderPainted(false);
		deleteBtn.setContentAreaFilled(false);
		deleteBtn.setFocusPainted(false);
		backRectangle.add(deleteBtn);
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//								deleteCustomerScreen.dispose();

				ImageIcon logoIcon = new ImageIcon("img\\icons\\logopane.png");

				if (!titleIDtf.getText().matches("[0-9]{1,3}")) {
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null, "Enter an existing Customer ID please.", "Title ID Error.",
							JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
					return;
				}

				// -----------GET TITLE INFO TO DO VALIDATIONS----------
				ArrayList<Object> UnknownTitleType;
				try {
					UnknownTitleType = managementSystem.getTitleInfoByID(Integer.parseInt(titleIDtf.getText()));

					if (UnknownTitleType.isEmpty()) {
						Object[] btns = { "Ok" };
						JOptionPane.showOptionDialog(null,
								"There's no Title ID " + titleIDtf.getText() + " in the System.", "Non-Existent ID.",
								JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
						return;
					}
				} catch (Exception exc) {
					exc.getMessage();
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null, "There's no Title ID " + titleIDtf.getText() + " in the System.",
							"Non-Existent ID.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns,
							btns[0]);
					return;
				}
//				unwrapTitle(UnknownTitleType);
				title = (Title) UnknownTitleType.get(0);
				Object[] btn = { "Cancel", "Delete" };
				int i = JOptionPane.showOptionDialog(null,
						"Are you sure to delete \nTitle ID: " + title.getId() + "\nTitle Name: " + title.getName()
								+ "?\nThere's no Undo.",
						"Confirmation.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btn,
						btn[0]);
				
				if (i == 1) {

					int a = managementSystem.deleteTitle(title);

					switch (a) {
					case 0:
						Object[] btns = { "Ok" };
						JOptionPane.showOptionDialog(null, "Title of ID " + title.getId() + " doesn't exist.", "Error.",
								JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
						return;
					case 1:
						Object[] btnss = { "Ok" };
						JOptionPane.showOptionDialog(null,
								"Title: " + title.getName() + " ID: " + title.getId()
										+ " was successfully deleted from the system.",
								"Title Removal Done.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon,
								btnss, btnss[0]);
						break;
					}
				} else {
				}
			}
		});
		deleteBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				deleteBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				deleteBtn.setIcon(new ImageIcon("img\\btn\\hover\\deletebtnhover.png"));
				deleteBtn.setBounds(576, 118, 239, 110);
			}

			public void mouseExited(MouseEvent evt) {
				deleteBtn.setIcon(new ImageIcon("img\\btn\\deletebtn.png"));
				deleteBtn.setBounds(580, 120, 230, 106);
			}
		});

	}

//	/**
//	 * @param unknowntitletype the ArrayList of object title types
//	 */
//	public void unwrapTitle(ArrayList<Object> unknowntitletype) {
//
//		for (Object obj : unknowntitletype) {
//			switch (obj.getClass().getName()) {// or filter.getName()
//			case "model.titles.MusicOrLive":
//				title = (Title) obj;
//				break;
//			case "model.titles.Movie":
//				title = (Title) obj;
//				break;
//			case "model.titles.BoxSet":
//				title = (Title) obj;
//				break;
//			}
//		}
//	}

	public void validation() {
		deleteTitleScreen.repaint();
		deleteTitleScreen.validate();
	}

	@Override
	public void focusGained(FocusEvent e) {
// ------------------movie genre TextField-------------------------
		if (titleIDtf.getText().matches("enter title id to delete")) {
			titleIDtf.setText("");
			titleIDtf.setForeground(new Color(0, 80, 110));
		}
		if (!titleIDtf.hasFocus()) {
			if (titleIDtf.getText().matches("")) {
				titleIDtf.setText("enter title id to delete");
				titleIDtf.setForeground(new Color(180, 180, 180));
			}
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}
}
