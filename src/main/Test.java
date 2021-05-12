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
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Mate.Mate;


public class Test extends JFrame {
	static float i = 0;
	float sum = 0;
	float dollar = 0.00f;
	private JPanel contentPane;
	static pbThread pr1;
	static Mate mateIndia;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		mateIndia = new Mate(0.01f, 3);
		pr1 = new pbThread();
		pr1.setI(i);
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
		setBounds(100, 100, 620, 526);

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
		layeredPane.setBounds(10, 78, 584, 338);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));

		JPanel Home = new JPanel();
		Home.setBackground(new Color(107, 142, 35));
		layeredPane.add(Home, "name_602210067906900");
		Home.setLayout(null);

		JLabel MateNumber = new JLabel("0.00");
		MateNumber.setBounds(10, 34, 77, 14);
		Home.add(MateNumber);

		JLabel lblNewLabel_1 = new JLabel("Mate Kilograms");
		lblNewLabel_1.setBounds(54, 34, 96, 14);
		Home.add(lblNewLabel_1);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(160, 34, 116, 14);
		Home.add(progressBar);


		JPanel Upgrades = new JPanel();
		Upgrades.setBackground(new Color(107, 142, 35));
		layeredPane.add(Upgrades, "name_602210083241700");
		Upgrades.setLayout(null);

		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mateIndia.upgrade(mateIndia.getProduction());
			}
		});
		btnNewButton_2.setBounds(182, 182, 89, 23);
		Upgrades.add(btnNewButton_2);

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
		JLabel lblNewLabel = new JLabel("MATE TYCOON");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 11, 263, 56);
		contentPane.add(lblNewLabel);
		JButton btnNewButton = new JButton("Plant & \nRecolect");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pr1 = new pbThread(progressBar, MateNumber, pr1, btnNewButton, mateIndia);
				pr1.start();
			}
		});
		btnNewButton.setBounds(286, 30, 141, 23);
		Home.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Sell Mate");
		btnNewButton_1.setBounds(218, 431, 119, 23);
		contentPane.add(btnNewButton_1);

		JLabel MoneyNumber = new JLabel("0.00");
		MoneyNumber.setBounds(10, 440, 53, 14);
		contentPane.add(MoneyNumber);

		JLabel lblNewLabel_2 = new JLabel("$");
		lblNewLabel_2.setBounds(54, 440, 77, 14);
		contentPane.add(lblNewLabel_2);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pr1.setI(0);
				sum = (float) (Float.parseFloat(MateNumber.getText()) * 1);
				dollar = dollar + sum;
				BigDecimal value = new BigDecimal(dollar);
				value = value.setScale(2, RoundingMode.HALF_DOWN);
				dollar = value.floatValue();
				MoneyNumber.setText(Float.toString(dollar));
				MateNumber.setText("0.00");
			}
		});

	}
}
