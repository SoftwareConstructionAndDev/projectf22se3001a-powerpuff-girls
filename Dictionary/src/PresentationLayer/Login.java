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


public class Login extends JFrame {

	private JPanel contentPane;
	 private JTextField textField;
	private JPasswordField passwordField;
	 private FacadeBLL facade=new FacadeBLL();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

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
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("لاگ ان");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(0, 153, 153));
		lblNewLabel.setBounds(172, 11, 105, 56);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("صارف نام");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(0, 153, 153));
		lblNewLabel_1.setBounds(10, 82, 76, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("پاس ورڈ");
		lblNewLabel_1_1.setForeground(new Color(0, 153, 153));
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(10, 141, 76, 32);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(96, 78, 273, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(96, 136, 273, 32);
		contentPane.add(passwordField);
		
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
		btnNewButton.setBackground(new Color(0, 153, 153));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton.setBounds(164, 207, 89, 23);
		contentPane.add(btnNewButton);
	}
	
}
