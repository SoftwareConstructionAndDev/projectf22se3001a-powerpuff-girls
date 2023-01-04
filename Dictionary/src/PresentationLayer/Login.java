package PresentationLayer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BusinessLogicLayer.DictionaryBLL;
import BusinessLogicLayer.FacadeBLL;
import BusinessLogicLayer.VerifyLogin;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


public class Login extends JFrame {
	 private JTextField textField;
	private JPasswordField passwordField;
	 private FacadeBLL facade=new FacadeBLL();
	 private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "ایکسیپشن");
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Login() throws SQLException {
		
		DictionaryBLL dicbll=new DictionaryBLL();
		dicbll.getConnection();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("لاگ ان");
		lblNewLabel.setFont(new Font("Urdu Typesetting", Font.BOLD, 25));
		lblNewLabel.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_1 = new JLabel("صارف نام");
		lblNewLabel_1.setFont(new Font("Urdu Typesetting", Font.BOLD, 15));
		lblNewLabel_1.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_1_1 = new JLabel("پاس ورڈ");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Urdu Typesetting", Font.BOLD, 15));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		
		JButton btnNewButton = new JButton("لاگ ان");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//lg = new VerifyLogin();
				try {
					if(facade.loginValidity(textField.getText(),passwordField.getText())==true)
					{
						AdminOptions ao=new AdminOptions();
						ao.show();
						dispose();	
					}
					else
					{
						JOptionPane.showMessageDialog(null, "صارف نام یا پاس ورڈ غلط ہے۔");
						PropertyConfigurator.configure("log4j.properties");
						Logger logger=Logger.getLogger(Login.class);
						logger.info("Wrong username or password");
						logger.warn("Wrong username or password");
						logger.error("Wrong username or password");
					}
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "ایکسیپشن SQL");
					PropertyConfigurator.configure("log4j.properties");
					Logger logger=Logger.getLogger(Login.class);
					logger.info("SQL EXCEPTION");
					logger.warn("SQL EXCEPTION");
					logger.error("SQL EXCEPTION");
				}
				
				
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 11));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(167)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
					.addGap(152))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
					.addGap(60))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
					.addGap(60))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(159)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addGap(176))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
					.addGap(15)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
							.addGap(1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)))
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
							.addGap(5)))
					.addGap(34)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
					.addGap(26))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
}
