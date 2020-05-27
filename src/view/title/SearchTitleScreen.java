package view.title;

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
import model.UltraVisionManagementSystem;
import model.enums.Media;
import model.titles.BoxSet;
import model.titles.Movie;
import model.titles.MusicOrLive;

public class SearchTitleScreen implements FocusListener {

	private JFrame searchTitleScreen = new JFrame();
	private KeyController listenerController = new KeyController(searchTitleScreen);

	private UltraVisionManagementSystem managementSystem = new UltraVisionManagementSystem(0);

	private ArrayList<MusicOrLive> musicOrLiveList = new ArrayList<>();
	private ArrayList<Movie> movieList = new ArrayList<>();
	private ArrayList<BoxSet> boxSetList = new ArrayList<>();

	private JTextField searchTitletf;
	private JButton searchBtn;

	private JComboBox<String> filter;

	private String[] ColumnNames;
	private JPanel panelToLayTable;

	private JScrollPane scrollpane;

	public SearchTitleScreen() {
		setAttributes();
		setComponents();
		validation();
	}

	public void setAttributes() {
		searchTitleScreen.setSize(980, 590);
		searchTitleScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		searchTitleScreen.setUndecorated(true);
		searchTitleScreen.setVisible(true);
		searchTitleScreen.setResizable(false);
		searchTitleScreen.setTitle("Ultra-Vision | Title Search");
		searchTitleScreen.setLocationRelativeTo(null);
		searchTitleScreen.setIconImage(new ImageIcon("img\\icons\\ultravisionicon.png").getImage());
		
		searchTitleScreen.addKeyListener(listenerController);
		searchTitleScreen.addWindowListener(listenerController);
		searchTitleScreen.addMouseListener(listenerController);
		searchTitleScreen.addMouseMotionListener(listenerController);
	}

	public void setComponents() {

		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 140, 190));
		searchTitleScreen.add(backPanel);

		closeBtn(backPanel);

		JLabel customericon = new JLabel();
		customericon.setIcon(new ImageIcon("img\\icons\\titleiconbluebackcircle.png"));
		customericon.setBounds(10, 0, 300, 150);
		backPanel.add(customericon);

		closeBtn(backPanel);

		JPanel backRectangle = new JPanel();
		backRectangle.setLayout(null);
		backRectangle.setBackground(new Color(0, 80, 110));
		backRectangle.setBounds(0, 110, searchTitleScreen.getWidth(), searchTitleScreen.getHeight() - 135);
		backPanel.add(backRectangle);

		searchTitletf = new JTextField();
		searchTitletf.setText("search title");
		searchTitletf.setHorizontalAlignment(JTextField.CENTER);
		searchTitletf.setForeground(new Color(180, 180, 180));
		searchTitletf.addFocusListener(this);
		searchTitletf.setBounds(205, 15, 400, 45);
		searchTitletf.setBorder(null);
		searchTitletf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		backRectangle.add(searchTitletf);

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

		JLabel newCustomerLabel = new JLabel("Title Info");
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
				searchTitleScreen.dispose();
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

				String entityName = "";
				switch (filter.getSelectedItem().toString()) {
				case "Music":
					entityName = "music";
					break;
				case "Live Concert":
					entityName = "live_concert";
					break;
				case "Movie":
					entityName = "movie";
					break;
				case "Box Set":
					entityName = "box_set";
					break;
				}

				if (searchTitletf.getText().equals("search title")) {
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null,
							"Write something to search. \nTip: if you want to see all let the \nsearch be \"\" (blank without space).",
							"No search given.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns,
							btns[0]);
					return;
				}

				ArrayList<Object> titleList = managementSystem.setSearchGetTitleList(searchTitletf.getText(),
						entityName);

				if (titleList.isEmpty()) {
					Object[] btns = { "Ok" };
					JOptionPane.showOptionDialog(null, "No results for search: " + searchTitletf.getText() + ".",
							"No Results.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, logoIcon, btns,
							btns[0]);
					return;

				} else {

					if (!musicOrLiveList.isEmpty() || !movieList.isEmpty() || !boxSetList.isEmpty()) {
						musicOrLiveList.clear();// remove old list to initiate new one
						movieList.clear();
						boxSetList.clear();
						panelToLayTable.remove(scrollpane);
					}

					unwrapTitles(titleList);
					tableInit(titleList);
					titleList.clear();
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

		String[] classifications = { "Music", "Live Concert", "Movie", "Box Set" };

		filter = new JComboBox<String>(classifications);
		filter.setBounds(435, 26, 84, 25);
		filter.setFont(new Font("Tahoma", Font.PLAIN, 10));
		searchbarPanel.add(filter);

	}

	public void tableInit(ArrayList<Object> titleList) {

		DefaultTableModel model = new DefaultTableModel();
		model = populateModel(titleList, model);

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

	public DefaultTableModel setColumnHeaders(DefaultTableModel model) {

		switch (filter.getSelectedItem().toString()) {
		case "Music":
			ColumnNames = new String[] { "Title ID", "Music Name", "Music Singer", "Music Band", "Music Genre",
					"Year of Release", "Disc Type", "Price", "Availability" };
			break;
		case "Live Concert":
			ColumnNames = new String[] { "Title ID", "Concert Name", "Concert Singer", "Concert Band", "Concert Genre",
					"Year of Release", "Disc Type", "Price", "Availability" };
			break;
		case "Movie":
			ColumnNames = new String[] { "Title ID", "Movie Name", "Movie Genre", "Movie Director", "Year of Release",
					"Disc Type", "Price", "Availability" };
			break;
		case "Box Set":
			ColumnNames = new String[] { "Title ID", "Box Set Name", "Box Set Genre", "Number of Films", "Disc Type",
					"Price", "Availability" };
			break;
		}
		model.setColumnIdentifiers(ColumnNames);
		model.setColumnCount(ColumnNames.length);

		return model;
	}

	public DefaultTableModel populateModel(ArrayList<Object> titleList, DefaultTableModel model) {

		model = setColumnHeaders(model);

		Object[] tablePopulation;

		switch (filter.getSelectedItem().toString()) {
		case "Music":
			tablePopulation = new Object[ColumnNames.length];
			for (int i = 0; i < titleList.size(); i++) {
				tablePopulation[0] = musicOrLiveList.get(i).getId();
				tablePopulation[1] = musicOrLiveList.get(i).getName();
				tablePopulation[2] = musicOrLiveList.get(i).getSinger();
				tablePopulation[3] = musicOrLiveList.get(i).getBand();
				tablePopulation[4] = musicOrLiveList.get(i).getGenre();
				tablePopulation[5] = musicOrLiveList.get(i).getYearOfRelease();
				tablePopulation[6] = musicOrLiveList.get(i).getDiscFormatGUI();
				tablePopulation[7] = musicOrLiveList.get(i).getPrice();
				tablePopulation[8] = musicOrLiveList.get(i).getAvailable() == 1 ? "In-Stock" : "Rented";

				model.addRow(tablePopulation);
			}
			break;
		case "Live Concert":
			tablePopulation = new Object[ColumnNames.length];
			for (int i = 0; i < titleList.size(); i++) {
				tablePopulation[0] = musicOrLiveList.get(i).getId();
				tablePopulation[1] = musicOrLiveList.get(i).getName();
				tablePopulation[2] = musicOrLiveList.get(i).getSinger();
				tablePopulation[3] = musicOrLiveList.get(i).getBand();
				tablePopulation[4] = musicOrLiveList.get(i).getGenre();
				tablePopulation[5] = musicOrLiveList.get(i).getYearOfRelease();
				tablePopulation[6] = musicOrLiveList.get(i).getDiscFormatGUI();
				tablePopulation[7] = musicOrLiveList.get(i).getPrice();
				tablePopulation[8] = musicOrLiveList.get(i).getAvailable() == 1 ? "In-Stock" : "Rented";
				model.addRow(tablePopulation);
			}
			break;
		case "Movie":
			tablePopulation = new Object[ColumnNames.length];
			for (int i = 0; i < titleList.size(); i++) {
				tablePopulation[0] = movieList.get(i).getId();
				tablePopulation[1] = movieList.get(i).getName();
				tablePopulation[2] = movieList.get(i).getGenre();
				tablePopulation[3] = movieList.get(i).getDirector();
				tablePopulation[4] = movieList.get(i).getYearOfRelease();
				tablePopulation[5] = movieList.get(i).getDiscFormatGUI();
				tablePopulation[6] = movieList.get(i).getPrice();
				tablePopulation[7] = movieList.get(i).getAvailable() == 1 ? "In-Stock" : "Rented";
				model.addRow(tablePopulation);
			}
			break;
		case "Box Set":
			tablePopulation = new Object[ColumnNames.length];
			for (int i = 0; i < titleList.size(); i++) {
				tablePopulation[0] = boxSetList.get(i).getId();
				tablePopulation[1] = boxSetList.get(i).getName();
				tablePopulation[2] = boxSetList.get(i).getGenre();
				tablePopulation[3] = boxSetList.get(i).getNumOfDiscs();
				tablePopulation[4] = boxSetList.get(i).getDiscFormatGUI();
				tablePopulation[5] = boxSetList.get(i).getPrice();
				tablePopulation[6] = boxSetList.get(i).getAvailable() == 1 ? "In-Stock" : "Rented";
				model.addRow(tablePopulation);
			}
			break;
		}
		return model;
	}

	public void unwrapTitles(ArrayList<Object> titles) {

		for (Object obj : titles) {
			switch (obj.getClass().getName()) {// or filter.getName()
			case "model.titles.MusicOrLive":
				musicOrLiveList.add((MusicOrLive) obj);
				break;
			case "model.titles.Movie":
				movieList.add((Movie) obj);
				break;
			case "model.titles.BoxSet":
				boxSetList.add((BoxSet) obj);
				break;
			}
		}
	}

	/**
	 * @return the searchTitletf
	 */
	public JTextField getSearchTitletf() {
		return searchTitletf;
	}

	/**
	 * @param searchTitletf the searchTitletf to set
	 */
	public void setSearchTitletf(JTextField searchTitletf) {
		this.searchTitletf = searchTitletf;
	}

	public void validation() {
		searchTitleScreen.repaint();
		searchTitleScreen.validate();
	}

	@Override
	public void focusGained(FocusEvent e) {

//------------------movie genre TextField-------------------------
		if (searchTitletf.getText().matches("search title")) {
			searchTitletf.setText("");
			searchTitletf.setForeground(new Color(0, 80, 110));
		}
		if (!searchTitletf.hasFocus()) {
			if (searchTitletf.getText().matches("")) {
				searchTitletf.setText("search title");
				searchTitletf.setForeground(new Color(180, 180, 180));
			}
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}
}
