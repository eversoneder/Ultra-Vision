package view;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.KeyController;
import model.Rent;
import model.UltraVisionManagementSystem;
import model.customer.Customer;
import model.customer.MembershipCard;
import model.titles.Title;

public class ViewRents implements FocusListener {

	private JFrame viewRentsScreen = new JFrame();
	private KeyController listenerController = new KeyController(viewRentsScreen);

	private ArrayList<Customer> customerList = new ArrayList<>();
	private ArrayList<Rent> rentList = new ArrayList<>();
	private ArrayList<Title> titleList = new ArrayList<>();
	private ArrayList<MembershipCard> cardList = new ArrayList<>();

	private UltraVisionManagementSystem managementSystem = new UltraVisionManagementSystem(0);

	private JTextField searchRentstf;
	private JButton searchBtn;

	private JPanel panelToLayTable;

	private JScrollPane scrollpane;// the scroll pane that has the viewport(table)

	public ViewRents() {
		setAttributes();
		setComponents();
//		searchRentstf.setText("");
//		searchBtn.doClick();
		validation();
	}

	public void setAttributes() {
		viewRentsScreen.setSize(980, 600);
		viewRentsScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		viewRentsScreen.setUndecorated(true);
		viewRentsScreen.setVisible(true);
		viewRentsScreen.setResizable(false);
		viewRentsScreen.setTitle("Ultra-Vision | View Rentals");
		viewRentsScreen.setIconImage(new ImageIcon("img\\icons\\ultravisionicon.png").getImage());
		viewRentsScreen.setLocationRelativeTo(null);

		viewRentsScreen.addKeyListener(listenerController);
		viewRentsScreen.addWindowListener(listenerController);
		viewRentsScreen.addMouseListener(listenerController);
		viewRentsScreen.addMouseMotionListener(listenerController);
	}

	public void setComponents() {

		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 140, 190));
		viewRentsScreen.add(backPanel);

		closeBtn(backPanel);

		JLabel customericon = new JLabel();
		customericon.setIcon(new ImageIcon("img\\icons\\titleiconbluebackcircle.png"));
		customericon.setBounds(10, 0, 300, 150);
		backPanel.add(customericon);

		closeBtn(backPanel);

		JPanel backRectangle = new JPanel();
		backRectangle.setLayout(null);
		backRectangle.setBackground(new Color(0, 80, 110));
		backRectangle.setBounds(0, 110, viewRentsScreen.getWidth(), viewRentsScreen.getHeight() - 150);
		backPanel.add(backRectangle);

		searchRentstf = new JTextField();
		searchRentstf.setText("search rentals");
		searchRentstf.setHorizontalAlignment(JTextField.CENTER);
		searchRentstf.setForeground(new Color(180, 180, 180));
		searchRentstf.addFocusListener(this);
		searchRentstf.setBounds(205, 15, 495, 45);
		searchRentstf.setBorder(null);
		searchRentstf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		backRectangle.add(searchRentstf);

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

		JLabel newCustomerLabel = new JLabel("View Rentals");
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
		closeBtn.setBounds(770, 20, 222, 65);
		closeBtn.setBorderPainted(false);
		closeBtn.setContentAreaFilled(false);
		closeBtn.setFocusPainted(false);
		backPanel.add(closeBtn);
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewRentsScreen.dispose();
			}
		});
		closeBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				closeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				closeBtn.setIcon(new ImageIcon("img\\btn\\hover\\closepagebtnhover.png"));
				closeBtn.setBounds(768, 15, 230, 75);
			}

			public void mouseExited(MouseEvent evt) {
				closeBtn.setIcon(new ImageIcon("img\\btn\\closepagebtn.png"));
				closeBtn.setBounds(770, 20, 222, 65);
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

				if (searchRentstf.getText().equals("search rentals")) {
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null,
							"Write something to search. \nTip: if you want to see all rents let the \nsearch be \"\" (blank without space).",
							"No search given.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns,
							btns[0]);
					return;

				} else {

					ArrayList<Object> rentAndCustAndTitle = managementSystem
							.setSearchGetRentList(searchRentstf.getText());

					if (rentAndCustAndTitle.isEmpty()) {
						Object[] btns = { "Ok" };
						JOptionPane.showOptionDialog(null, "No results for search: " + searchRentstf.getText() + ".",
								"No Results.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns,
								btns[0]);
						return;
					} else {

						if (!customerList.isEmpty()) {// remove old list to initiate new one
							customerList.clear();
							titleList.clear();
							rentList.clear();
							panelToLayTable.remove(scrollpane);
						}

						unwrapTitles(rentAndCustAndTitle);
						tableInit();
						rentAndCustAndTitle.clear();
					}
				}
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

	public DefaultTableModel populateModel(DefaultTableModel model) {

		String[] ColumnNames = new String[] { "Start Date", "Return Date", "Cust. ID", "Cust. Name", "Cust. Email",
				"Title ID", "Title Name", "Title Type", "Price" };

		model.setColumnIdentifiers(ColumnNames);
		model.setColumnCount(ColumnNames.length);

		Object[] tablePopulation = new Object[ColumnNames.length];
		for (int i = 0; i < customerList.size(); i++) {
			tablePopulation[0] = rentList.get(i).getStartDateString();
			tablePopulation[1] = rentList.get(i).getReturnDateString();
			tablePopulation[2] = customerList.get(i).getCustomerID();
			tablePopulation[3] = customerList.get(i).getCustomer_name();
			tablePopulation[4] = customerList.get(i).getEmail();

			tablePopulation[5] = titleList.get(i).getId();
			tablePopulation[6] = titleList.get(i).getName();
			tablePopulation[7] = titleList.get(i).getTitleTypeGUI();
			tablePopulation[8] = titleList.get(i).getPrice();
			model.addRow(tablePopulation);
		}
		return model;
	}

	public void tableInit() {

		DefaultTableModel model = new DefaultTableModel();
		model = populateModel(model);

		JTable table = new JTable(model);

		table.setRowHeight(30);
		table.setGridColor(new Color(0, 80, 110));
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setEnabled(false);

		scrollpane = new JScrollPane(table);
		scrollpane.setBounds(0, 0, panelToLayTable.getWidth(), panelToLayTable.getHeight());
		table.setPreferredScrollableViewportSize(
				new Dimension(panelToLayTable.getWidth(), panelToLayTable.getHeight()));
		table.setFillsViewportHeight(true);

		panelToLayTable.add(scrollpane);
	}

	/**
	 * @param custAndTitleAndRent to be unwrapped
	 */
	public void unwrapTitles(ArrayList<Object> custAndTitleAndRent) {

		for (Object obj : custAndTitleAndRent) {
			switch (obj.getClass().getName()) {
			case "model.Rent":
				rentList.add((Rent) obj);
				break;
			case "model.customer.Customer":
				customerList.add((Customer) obj);
				break;
			case "model.customer.Title":
				titleList.add((Title) obj);
				break;
			case "model.customer.MembershipCard":
				cardList.add((MembershipCard) obj);
				break;
			case "model.titles.MusicOrLive":
				titleList.add((Title) obj);
				break;
			case "model.titles.Movie":
				titleList.add((Title) obj);
				break;
			case "model.titles.BoxSet":
				titleList.add((Title) obj);
				break;
			}
		}
	}

	/**
	 * @return the searchTitletf
	 */
	public JTextField getSearchCustomertf() {
		return searchRentstf;
	}

	/**
	 * @param searchCustomertf the searchCustomertf to set
	 */
	public void setSearchTitletf(JTextField searchCustomertf) {
		this.searchRentstf = searchCustomertf;
	}

	public void validation() {
		viewRentsScreen.repaint();
		viewRentsScreen.validate();
	}

	@Override
	public void focusGained(FocusEvent e) {

//------------------movie genre TextField-------------------------
		if (searchRentstf.getText().matches("search rentals")) {
			searchRentstf.setText("");
			searchRentstf.setForeground(new Color(0, 80, 110));
		}
		if (!searchRentstf.hasFocus()) {
			if (searchRentstf.getText().matches("")) {
				searchRentstf.setText("search rentals");
				searchRentstf.setForeground(new Color(180, 180, 180));
			}
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}
}
