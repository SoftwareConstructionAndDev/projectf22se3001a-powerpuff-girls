package PresentationLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import BusinessLogicLayer.FacadeBLL;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class UserOptions extends JFrame {

	private JPanel contentPane;
	 

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserOptions frame = new UserOptions();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "ایکسیپشن");
					
					PropertyConfigurator.configure("log4j.properties");
					Logger logger=Logger.getLogger(Login.class);
					logger.info("EXCEPTION");
					logger.warn("EXCEPTION");
					logger.error("EXCEPTION");
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public UserOptions() {
		setTitle("User Options");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setForeground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("منتظم");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l;
				try {
					l = new Login();
					l.show();
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "ایکسیپشن SQL");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Urdu Typesetting", Font.BOLD, 25));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(Color.WHITE);
		
		JButton btnNewButton_1 = new JButton("صارف");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserFuctionalities uf=new UserFuctionalities();
				uf.show();
				dispose();
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Urdu Typesetting", Font.BOLD, 25));
		btnNewButton_1.setBackground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(107)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
					.addGap(119))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
					.addGap(43)
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
					.addGap(26))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
