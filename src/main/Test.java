package main;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Test extends JFrame {
	float i = 0;
	float sum = 0;
	float dollar = 0.00f;
	private JPanel contentPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 526);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Selector     ");
		menuBar.add(mnNewMenu);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(85, 107, 47));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 78, 557, 338);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));

		JPanel Home = new JPanel();
		Home.setBackground(new Color(107, 142, 35));
		layeredPane.add(Home, "name_602210067906900");
		Home.setLayout(null);

		JLabel MateNumber = new JLabel("0.00");
		MateNumber.setBounds(80, 53, 77, 14);
		Home.add(MateNumber);

		JLabel MoneyNumber = new JLabel("0.00");
		MoneyNumber.setBounds(80, 74, 53, 14);
		Home.add(MoneyNumber);

		JLabel lblNewLabel = new JLabel("MATE TYCOON");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 11, 263, 56);
		contentPane.add(lblNewLabel);
		JButton btnNewButton = new JButton("Plant & Recolect");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i = (float) (i + 0.01f);
				BigDecimal value = new BigDecimal(i);
				value = value.setScale(2, RoundingMode.HALF_EVEN);
				MateNumber.setText(value + "");
			}
		});
		btnNewButton.setBounds(80, 304, 140, 23);
		Home.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Sell Mate");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i = 0;
				sum = (float) (Float.parseFloat(MateNumber.getText()) * 5);
				dollar = dollar + sum;
				BigDecimal value = new BigDecimal(dollar);
				value = value.setScale(2, RoundingMode.HALF_DOWN);
				dollar = value.floatValue();
				MoneyNumber.setText(Float.toString(dollar));
				MateNumber.setText("0.00");
			}
		});
		btnNewButton_1.setBounds(361, 304, 119, 23);
		Home.add(btnNewButton_1);

		JLabel lblNewLabel_1 = new JLabel("Mate Kilograms");
		lblNewLabel_1.setBounds(124, 53, 96, 14);
		Home.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("$");
		lblNewLabel_2.setBounds(124, 74, 77, 14);
		Home.add(lblNewLabel_2);

		JPanel Upgrades = new JPanel();
		Upgrades.setBackground(new Color(107, 142, 35));
		layeredPane.add(Upgrades, "name_602210083241700");

		JMenuItem MenuUpgrades = new JMenuItem("Upgrades  ");
		MenuUpgrades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Upgrades);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});

		JMenuItem MenuMain = new JMenuItem("Main Menu  ");
		MenuMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Home);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		mnNewMenu.add(MenuMain);
		mnNewMenu.add(MenuUpgrades);

	}
}
