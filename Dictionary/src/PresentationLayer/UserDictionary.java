package PresentationLayer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BusinessLogicLayer.FacadeBLL;

public class UserDictionary extends JFrame {

	private JPanel contentPane;
	private JTable table;
private String text;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserDictionary frame = new UserDictionary();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public UserDictionary() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ڈکشنری");
		lblNewLabel.setFont(new Font("Urdu Typesetting", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(177, 11, 95, 30);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(36, 63, 365, 163);
		contentPane.add(table);
		CustomDictionary cd=new CustomDictionary();
		text=cd.textArea.getText();
		
		FacadeBLL facade=new FacadeBLL();
DefaultTableModel tableModel=(DefaultTableModel) table.getModel();
		
		
		ArrayList<ArrayList<String>> list=facade.getCustomDic(text);
		
		
		
	}
}
