package main;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

import Mate.Mate;
import Player.Player;


public class Test extends JFrame {
	static float i = 0;
	float sum = 0;
	private JPanel contentPane;
	static pbThread pr1;
	static Mate mateIndia;
	static Mate matePeru;
	static Player player;
	static ArrayList<Mate> mate;
	static ArrayList<JLabel> label;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		label = new ArrayList<JLabel>();
		mate = new ArrayList<Mate>();
		mateIndia = new Mate(0.01f, 1, "Mate India");
		matePeru = new Mate(0.05f, 3, "Mate Peru");
		mate.add(mateIndia);
		mate.add(matePeru);
		player = new Player();
		player.setDollar(0);
		player.setMate(mate);
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

		JLabel lblNewLabel_1 = new JLabel("Mate India KG");
		lblNewLabel_1.setBounds(54, 34, 96, 14);
		Home.add(lblNewLabel_1);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(new Color(169, 169, 169));
		progressBar.setToolTipText("");
		progressBar.setBounds(139, 30, 137, 23);
		Home.add(progressBar);


		JPanel Upgrades = new JPanel();
		Upgrades.setBackground(new Color(107, 142, 35));
		layeredPane.add(Upgrades, "name_602210083241700");
		Upgrades.setLayout(null);

		JLabel infoLabel0 = new JLabel("");
		infoLabel0.setBounds(10, 34, 564, 14);
		Upgrades.add(infoLabel0);


		JLabel infoLabel1 = new JLabel("");
		infoLabel1.setBounds(10, 59, 564, 14);
		Upgrades.add(infoLabel1);

		JLabel infoLabel2 = new JLabel("");
		infoLabel2.setBounds(10, 84, 564, 14);
		Upgrades.add(infoLabel2);

		JMenuItem MenuUpgrades = new JMenuItem("Info");
		MenuUpgrades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				label.add(infoLabel0);
				label.add(infoLabel1);
				label.add(infoLabel2);
				layeredPane.removeAll();
				layeredPane.add(Upgrades);
				layeredPane.repaint();
				layeredPane.revalidate();
				for (Mate x : player.getMate()) {
					label.get(i).setText("The " + x.getName() + " production is "//
							+ Float.toString(x.getProduction()) + " KG per click");//
					i++;

				}

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
		JButton btnNewButton = new JButton("Plant & Recolect");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pr1 = new pbThread(progressBar, MateNumber, pr1, btnNewButton, mateIndia);
				pr1.start();
			}
		});
		btnNewButton.setBounds(286, 30, 141, 23);
		Home.add(btnNewButton);

		JButton upgradeButton = new JButton("Upgrade");
		upgradeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Upgrade dialog = new Upgrade();
					dialog.dollar(player.getDollar(), mateIndia, player);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					dialog.setBounds(getBounds());

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		upgradeButton.setBounds(437, 30, 137, 23);
		Home.add(upgradeButton);

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
				player.setDollar(player.getDollar() + sum);
				BigDecimal value = new BigDecimal(player.getDollar());
				value = value.setScale(2, RoundingMode.HALF_DOWN);
				player.setDollar(value.floatValue());
				MoneyNumber.setText(Float.toString(player.getDollar()));
				MateNumber.setText("0.00");
			}
		});


	}
}
