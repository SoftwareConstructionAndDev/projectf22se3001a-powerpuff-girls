package PresentationLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BusinessLogicLayer.FacadeBLL;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UpdateWord extends JFrame {

	private JPanel contentPane;
	private JTextField mashkool;
	private JTextField sinf;
	private JTextField asal;
	private JTextField jins;
	private JTextField adad;
	private JTextField mani;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateWord frame = new UpdateWord();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public UpdateWord() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("مشكول");
		lblNewLabel.setForeground(new Color(0, 153, 153));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBounds(335, 53, 75, 14);
		contentPane.add(lblNewLabel);
		
		mashkool = new JTextField();
		mashkool.setColumns(10);
		mashkool.setBounds(96, 50, 209, 20);
		contentPane.add(mashkool);
		
		JButton btnNewButton = new JButton("ٹھیک ہے");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FacadeBLL facade=new FacadeBLL();
					facade.updateInLughat(mashkool.getText(),sinf.getText(),asal.getText(),jins.getText(),adad.getText(),mani.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(0, 153, 153));
		btnNewButton.setBounds(176, 207, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("صنف");
		lblNewLabel_1.setForeground(new Color(0, 153, 153));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1.setBounds(335, 78, 75, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("أصل");
		lblNewLabel_1_1.setForeground(new Color(0, 153, 153));
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(335, 103, 75, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("جنس");
		lblNewLabel_1_1_1.setForeground(new Color(0, 153, 153));
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(335, 128, 75, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("عدد");
		lblNewLabel_1_1_1_1.setForeground(new Color(0, 153, 153));
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1_1_1_1.setBounds(335, 153, 75, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("معانی");
		lblNewLabel_1_1_1_1_1.setForeground(new Color(0, 153, 153));
		lblNewLabel_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1_1_1_1_1.setBounds(335, 178, 75, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		sinf = new JTextField();
		sinf.setColumns(10);
		sinf.setBounds(96, 75, 209, 20);
		contentPane.add(sinf);
		
		asal = new JTextField();
		asal.setColumns(10);
		asal.setBounds(96, 100, 209, 20);
		contentPane.add(asal);
		
		jins = new JTextField();
		jins.setColumns(10);
		jins.setBounds(96, 125, 209, 20);
		contentPane.add(jins);
		
		adad = new JTextField();
		adad.setColumns(10);
		adad.setBounds(96, 150, 209, 20);
		contentPane.add(adad);
		
		mani = new JTextField();
		mani.setColumns(10);
		mani.setBounds(96, 176, 209, 20);
		contentPane.add(mani);
	}
}
