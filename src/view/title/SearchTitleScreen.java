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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.KeyController;

public class SearchTitleScreen implements FocusListener {

	private JFrame searchTitleScreen = new JFrame();
	KeyController keyListener = new KeyController(searchTitleScreen);

	private JTextField searchTitletf;
	private JButton searchBtn;

	public SearchTitleScreen() {
		setAttributes();
		setComponents();
		validation();
	}

	public static void main(String[] args) {
		new SearchTitleScreen();
	}

	public void setAttributes() {
		searchTitleScreen.setSize(1000, 650);
		searchTitleScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		searchTitleScreen.setVisible(true);
		searchTitleScreen.setResizable(false);
		searchTitleScreen.setTitle("Ultra-Vision | Title Search");
		searchTitleScreen.setLocationRelativeTo(null);
		searchTitleScreen.addKeyListener(keyListener);
	}

	public void setComponents() {

		JPanel backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBackground(new Color(0, 120, 170));
		searchTitleScreen.add(backPanel);

		mainScreenBtn(backPanel);
		
		JLabel customericon = new JLabel();
		customericon.setIcon(new ImageIcon("img\\icons\\customericonbluebackcircle.png"));
		customericon.setBounds(10, 0, 300, 150);
		backPanel.add(customericon);

		mainScreenBtn(backPanel);

		JPanel backRectangle = new JPanel();
		backRectangle.setLayout(null);
		backRectangle.setBackground(new Color(0, 80, 110));
		backRectangle.setBounds(0, 110, searchTitleScreen.getWidth(), searchTitleScreen.getHeight() - 200);
		backPanel.add(backRectangle);

		searchTitletf = new JTextField();
		searchTitletf.setText("search title");
		searchTitletf.setHorizontalAlignment(JTextField.CENTER);
		searchTitletf.setForeground(new Color(180, 180, 180));
		searchTitletf.addFocusListener(this);
		searchTitletf.setBounds(270, 15, 400, 45);
		searchTitletf.setBorder(null);
		searchTitletf.setFont(new Font("Tahoma", Font.PLAIN, 24));
		backRectangle.add(searchTitletf);

		JPanel whiteRectangle = new JPanel();
		whiteRectangle.setLayout(null);
		whiteRectangle.setBackground(Color.WHITE);
		whiteRectangle.setBounds(142, 70, 700, 370);
		backRectangle.add(whiteRectangle);

		JLabel newCustomerLabel = new JLabel("Customer Info");
		newCustomerLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		newCustomerLabel.setBounds(170, 70, 350, 35);
		newCustomerLabel.setForeground(Color.WHITE);
		backPanel.add(newCustomerLabel);

		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon("img\\icons\\logobluecircle.png"));
		logo.setBounds(420, 0, 300, 120);
		backPanel.add(logo);

		buttons(backRectangle);
	}

	public void mainScreenBtn(JPanel backPanel) {

		JButton mainScreenBtn = new JButton();
		mainScreenBtn.setIcon(new ImageIcon("img\\btn\\mainscreenbtn.png"));
		mainScreenBtn.setBounds(780, 20, 222, 65);
		mainScreenBtn.setBorderPainted(false);
		mainScreenBtn.setContentAreaFilled(false);
		mainScreenBtn.setFocusPainted(false);
		backPanel.add(mainScreenBtn);
		mainScreenBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchTitleScreen.dispose();
			}
		});
		mainScreenBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				mainScreenBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				mainScreenBtn.setIcon(new ImageIcon("img\\btn\\hover\\mainscreenbtnhover.png"));
				mainScreenBtn.setBounds(778, 15, 230, 75);
			}

			public void mouseExited(MouseEvent evt) {
				mainScreenBtn.setIcon(new ImageIcon("img\\btn\\mainscreenbtn.png"));
				mainScreenBtn.setBounds(780, 20, 222, 65);
			}
		});
	}

	public void buttons(JPanel backRectangle) {

		
// ---------------------------SEARCH BUTTON-------------------------------
		searchBtn = new JButton();
		searchBtn.setIcon(new ImageIcon("img\\btn\\searchbtn.png"));
		searchBtn.setBounds(595, 5, 222, 65);
		searchBtn.setBorderPainted(false);
		searchBtn.setContentAreaFilled(false);
		searchBtn.setFocusPainted(false);
		backRectangle.add(searchBtn);
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				searchTitletf.getText();
				
			}
		});
		searchBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				searchBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				searchBtn.setIcon(new ImageIcon("img\\btn\\hover\\searchbtnhover.png"));
				searchBtn.setBounds(593, 2, 228, 70);
			}
			public void mouseExited(MouseEvent evt) {
				searchBtn.setIcon(new ImageIcon("img\\btn\\searchbtn.png"));
				searchBtn.setBounds(595, 5, 222, 65);
			}
		});

	}

	public void validation() {
		searchTitleScreen.repaint();
		searchTitleScreen.validate();
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
