package view.customer;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.KeyController;
import controller.UltraVisionManagementSystem;
import model.customer.Customer;
import model.customer.MembershipCard;

public class SearchCustomerScreen implements FocusListener {

	private JFrame searchCustomerScreen = new JFrame();
	KeyController keyListener = new KeyController(searchCustomerScreen);

	private UltraVisionManagementSystem managementSystem;

	private ArrayList<Object> customerInfo;
	private ArrayList<Customer> customerList = new ArrayList<>();
	private ArrayList<MembershipCard> membershipCardList = new ArrayList<>();

	private JTextField searchCustomertf;
	private JButton searchBtn;

	private JTable table;
	private DefaultTableModel model;
	private String[] ColumnNames;
	private JPanel panelToLayTable;

	public SearchCustomerScreen() {
		setAttributes();
		setComponents();
		validation();
	}

	public static void main(String[] args) {
		new SearchCustomerScreen();
	}

	public void setAttributes() {
		searchCustomerScreen.setSize(1000, 650);
		searchCustomerScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		searchCustomerScreen.setVisible(true);
		searchCustomerScreen.setResizable(false);
		searchCustomerScreen.setTitle("Ultra-Vision | Customer Search");
		searchCustomerScreen.setLocationRelativeTo(null);
		searchCustomerScreen.addKeyListener(keyListener);
	}

	public void setComponents() {

		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 120, 170));
		searchCustomerScreen.add(backPanel);

		closeBtn(backPanel);

		JLabel customericon = new JLabel();
		customericon.setIcon(new ImageIcon("img\\icons\\customericonbluebackcircle.png"));
		customericon.setBounds(10, 0, 300, 150);
		backPanel.add(customericon);

		closeBtn(backPanel);

		JPanel backRectangle = new JPanel();
		backRectangle.setLayout(null);
		backRectangle.setBackground(new Color(0, 80, 110));
		backRectangle.setBounds(0, 110, searchCustomerScreen.getWidth(), searchCustomerScreen.getHeight() - 200);
		backPanel.add(backRectangle);

		searchCustomertf = new JTextField();
		searchCustomertf.setText("search customer");
		searchCustomertf.setHorizontalAlignment(JTextField.CENTER);
		searchCustomertf.setForeground(new Color(180, 180, 180));
		searchCustomertf.addFocusListener(this);
		searchCustomertf.setBounds(205, 15, 495, 45);
		searchCustomertf.setBorder(null);
		searchCustomertf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		backRectangle.add(searchCustomertf);

		JPanel searchbarPanel = new JPanel();
		searchbarPanel.setLayout(null);
		searchbarPanel.setBackground(new Color(0, 80, 110));
		searchbarPanel.setBounds(180, 0, 600, 70);
		backRectangle.add(searchbarPanel);

		panelToLayTable = new JPanel();
		panelToLayTable.setLayout(null);
		panelToLayTable.setBackground(Color.WHITE);
		panelToLayTable.setBounds(50, 70, 885, 370);
		backRectangle.add(panelToLayTable);

		JLabel newCustomerLabel = new JLabel("Customer Info");
		newCustomerLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		newCustomerLabel.setBounds(170, 70, 350, 35);
		newCustomerLabel.setForeground(Color.WHITE);
		backPanel.add(newCustomerLabel);

		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon("img\\icons\\logobluecircle.png"));
		logo.setBounds(420, 0, 300, 120);
		backPanel.add(logo);

		buttons(backRectangle, searchbarPanel);

	}

	public void closeBtn(JPanel backPanel) {

		JButton closeBtn = new JButton();
		closeBtn.setIcon(new ImageIcon("img\\btn\\closepagebtn.png"));
		closeBtn.setBounds(780, 20, 222, 65);
		closeBtn.setBorderPainted(false);
		closeBtn.setContentAreaFilled(false);
		closeBtn.setFocusPainted(false);
		backPanel.add(closeBtn);
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchCustomerScreen.dispose();
			}
		});
		closeBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				closeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				closeBtn.setIcon(new ImageIcon("img\\btn\\hover\\closepagebtnhover.png"));
				closeBtn.setBounds(778, 15, 230, 75);
			}

			public void mouseExited(MouseEvent evt) {
				closeBtn.setIcon(new ImageIcon("img\\btn\\closepagebtn.png"));
				closeBtn.setBounds(780, 20, 222, 65);
			}
		});
	}

	public void buttons(JPanel backRectangle, JPanel searchbarPanel) {

// ---------------------------SEARCH BUTTON-------------------------------
		searchBtn = new JButton();
		searchBtn.setIcon(new ImageIcon("img\\btn\\searchbtn.png"));
		searchBtn.setBounds(525, 5, 60, 60);
		searchBtn.setBorderPainted(false);
		searchBtn.setContentAreaFilled(false);
		searchBtn.setFocusPainted(false);
		searchbarPanel.add(searchBtn);
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ImageIcon logoIcon = new ImageIcon("img\\icons\\logopane.png");

				managementSystem = new UltraVisionManagementSystem(0);

				if (searchCustomertf.getText().equals("search customer")) {
					Object[] btns = { "Ok" };
					int i = JOptionPane.showOptionDialog(null,
							"Write something to search. \nTip: if you want to see all let the \nsearch be \" \" (space).",
							"No search given.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns,
							btns[0]);
					return;
				}
				customerInfo = managementSystem.setSearchGetCustomerList(searchCustomertf.getText());

				if (customerInfo.isEmpty()) {
					Object[] btns = { "Ok" };
					int i = JOptionPane.showOptionDialog(null,
							"No results for search: " + searchCustomertf.getText() + ".", "No Results.",
							JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns, btns[0]);
					return;
				} else {
					unwrapTitles(customerInfo);
					populateModel();
					tableInit();
				}
				customerInfo.clear();
				customerList.clear();
				membershipCardList.clear();
			}
		});
		searchBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				searchBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				searchBtn.setIcon(new ImageIcon("img\\btn\\hover\\searchbtnhover.png"));
				searchBtn.setBounds(524, 3, 65, 65);
			}

			public void mouseExited(MouseEvent evt) {
				searchBtn.setIcon(new ImageIcon("img\\btn\\searchbtn.png"));
				searchBtn.setBounds(525, 5, 60, 60);
			}
		});
	}

	public void tableInit() {

		table = new JTable(model);

		table.setRowHeight(30);
		table.setGridColor(new Color(0, 80, 110));
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setEnabled(false);
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setBounds(0, 0, panelToLayTable.getWidth(), panelToLayTable.getHeight());
		scrollpane.getViewport().add(table);
		table.setPreferredScrollableViewportSize(
				new Dimension(panelToLayTable.getWidth(), panelToLayTable.getHeight()));
		table.setFillsViewportHeight(true);

		panelToLayTable.add(scrollpane);

//		table = new JTable(model);
//		table.setRowHeight(30);
//		table.setFont(new Font("Tahoma", Font.BOLD, 12));
//		table.setGridColor(new Color(0, 80, 110));
//
//		JScrollPane scrollpane = new JScrollPane(table);
//		scrollpane.setBounds(0, 0, panelToLayTable.getWidth(), panelToLayTable.getHeight());
//
//		panelToLayTable.add(scrollpane);
	}

	public void unwrapTitles(ArrayList<Object> customerInfo) {

		for (Object obj : customerInfo) {
			switch (obj.getClass().getName()) {// or filter.getName()
			case "model.customer.MembershipCard":
				membershipCardList.add((MembershipCard) obj);
				break;
			case "model.customer.Customer":
				customerList.add((Customer) obj);
				break;
			}
		}
	}

	public void populateModel() {

		model = new DefaultTableModel();

		ColumnNames = new String[] { "ID", "Name", "Phone", "E-mail", "Card ID", "Has Free Rents?",
				"Available Free Rents", "Points", "Subscription" };

		model.setColumnIdentifiers(ColumnNames);
		model.setColumnCount(ColumnNames.length);

		Object[] tablePopulation = new Object[ColumnNames.length];
		for (int i = 0; i < customerList.size(); i++) {
			tablePopulation[0] = customerList.get(i).getCustomer_id();
			tablePopulation[1] = customerList.get(i).getCustomer_name();
			tablePopulation[2] = customerList.get(i).getCustomer_phone();
			tablePopulation[3] = customerList.get(i).getEmail();

			tablePopulation[4] = membershipCardList.get(i).getCardID();
			tablePopulation[5] = membershipCardList.get(i).getHasFreeRent();
			tablePopulation[6] = membershipCardList.get(i).getFreeRents();
			tablePopulation[7] = membershipCardList.get(i).getPoints();
			switch (membershipCardList.get(i).getTitleTypeDB()) {
			case 1:
				tablePopulation[8] = "Music Lover";
				break;
			case 2:
				tablePopulation[8] = "Video Lover";
				break;
			case 3:
				tablePopulation[8] = "TV Lover";
				break;
			case 4:
				tablePopulation[8] = "Premium";
				break;
			}
			model.addRow(tablePopulation);
		}
	}

	public void validation() {
		searchCustomerScreen.repaint();
		searchCustomerScreen.validate();
	}

	/**
	 * @return the searchTitletf
	 */
	public JTextField getSearchCustomertf() {
		return searchCustomertf;
	}

	/**
	 * @param searchCustomertf the searchCustomertf to set
	 */
	public void setSearchTitletf(JTextField searchCustomertf) {
		this.searchCustomertf = searchCustomertf;
	}

	@Override
	public void focusGained(FocusEvent e) {

//------------------movie genre TextField-------------------------
		if (searchCustomertf.getText().matches("search customer")) {
			searchCustomertf.setText("");
			searchCustomertf.setForeground(new Color(0, 80, 110));
		}
		if (!searchCustomertf.hasFocus()) {
			if (searchCustomertf.getText().matches("")) {
				searchCustomertf.setText("search customer");
				searchCustomertf.setForeground(new Color(180, 180, 180));
			}
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}
}
