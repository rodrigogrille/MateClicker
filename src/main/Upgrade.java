package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Mate.Mate;
import Player.Player;

public class Upgrade extends JDialog {
	static JLabel dollarlabel;
	static JLabel upgradeLabel2;
	static Player player;
	float dollar = 0;
	private final JPanel contentPanel = new JPanel();
	Mate mate;

	public void dollar(float dollar, Mate mate, Player player) {
		this.dollar = dollar;
		this.mate = mate;
		this.player = player;
		dollarlabel.setText("You have " + Float.toString(this.dollar) + " $");
	}

	/**
	 * Create the dialog.
	 */
	public Upgrade() {
		setUndecorated(true);
		setResizable(false);
		setBounds(100, 100, 620, 388);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(107, 142, 35));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel upgradeTitleLabel = new JLabel("Mate India");
		upgradeTitleLabel.setForeground(Color.WHITE);
		upgradeTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		upgradeTitleLabel.setBounds(10, 11, 135, 34);
		contentPanel.add(upgradeTitleLabel);
		{
			JLabel upgradeLabel0 = new JLabel("The actual production is  0.1 KG");
			upgradeLabel0.setForeground(Color.WHITE);
			upgradeLabel0.setFont(new Font("Tahoma", Font.BOLD, 13));
			upgradeLabel0.setBounds(21, 94, 327, 22);
			contentPanel.add(upgradeLabel0);
		}
		{
			JLabel upgradeLabel1 = new JLabel("If u upgrade the production will be 0.25");
			upgradeLabel1.setForeground(Color.WHITE);
			upgradeLabel1.setFont(new Font("Tahoma", Font.BOLD, 13));
			upgradeLabel1.setBounds(21, 139, 327, 22);
			contentPanel.add(upgradeLabel1);
		}

		JPanel panel = new JPanel();
		panel.setBackground(new Color(85, 107, 47));
		panel.setBounds(0, 0, 620, 57);
		contentPanel.add(panel);
		{
			upgradeLabel2 = new JLabel("It will cost you 10 $");
			upgradeLabel2.setForeground(Color.WHITE);
			upgradeLabel2.setFont(new Font("Tahoma", Font.BOLD, 13));
			upgradeLabel2.setBounds(21, 186, 327, 22);
			contentPanel.add(upgradeLabel2);
		}
		{
			dollarlabel = new JLabel("");
			dollarlabel.setFont(new Font("Tahoma", Font.BOLD, 13));
			dollarlabel.setForeground(Color.WHITE);
			dollarlabel.setBounds(21, 229, 339, 22);
			contentPanel.add(dollarlabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(85, 107, 47));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Upgrade");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (player.getDollar() >= (mate.getPrice())) {
							player.setDollar(
									(float) (player.getDollar() - (mate.getPrice())));
							mate.setPrice(mate.getPrice() * 2);
							dollarlabel.setText(Float.toString(player.getDollar()));
							mate.setUpgrade(true);
							mate.upgrade(mate, upgradeLabel2);
							mate.setUpgrade(false);
						} else {
							JOptionPane.showMessageDialog(null, "Not enough Plata, you need to get more");
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
