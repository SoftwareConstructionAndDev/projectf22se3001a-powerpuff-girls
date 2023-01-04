package PresentationLayer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BusinessLogicLayer.FacadeBLL;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AddWord extends JFrame {

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
	public AddWord() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 485);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("مشكول");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Urdu Typesetting", Font.BOLD, 13));
		
		JButton btnNewButton = new JButton("ٹھیک ہے");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FacadeBLL facade=new FacadeBLL();
					//facade.updateInLughat(mashkool.getText(),sinf.getText(),asal.getText(),jins.getText(),adad.getText(),mani.getText());
					
					facade.insertInLughatTable(mashkool.getText(),mashkool.getText(),asal.getText(),jins.getText(),adad.getText(),mani.getText(),facade.generateUnVocalizedForm(mashkool.getText()),facade.generateUnVocalizedForm(asal.getText()));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Urdu Typesetting", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_1 = new JLabel("صنف");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Urdu Typesetting", Font.BOLD, 13));
		
		JLabel lblNewLabel_1_1 = new JLabel("أصل");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Urdu Typesetting", Font.BOLD, 13));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("جنس");
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("Urdu Typesetting", Font.BOLD, 13));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("عدد");
		lblNewLabel_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1.setFont(new Font("Urdu Typesetting", Font.BOLD, 13));
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("معانی");
		lblNewLabel_1_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1_1.setFont(new Font("Urdu Typesetting", Font.BOLD, 13));
		
		mashkool = new JTextField();
		mashkool.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("واپس جاو");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminOptions adminOptions;
				try {
					adminOptions = new AdminOptions();
					dispose();
					adminOptions.show();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Urdu Typesetting", Font.BOLD, 14));
		
		JLabel lblNewLabel_2 = new JLabel("ایڈ ورڈ");
		lblNewLabel_2.setFont(new Font("Urdu Typesetting", Font.BOLD, 18));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		
		sinf = new JTextField();
		sinf.setColumns(10);
		
		asal = new JTextField();
		asal.setColumns(10);
		
		jins = new JTextField();
		jins.setColumns(10);
		
		adad = new JTextField();
		adad.setColumns(10);
		
		mani = new JTextField();
		mani.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(198)
					.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
					.addGap(159))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(59)
					.addComponent(mashkool, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
					.addGap(30)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
					.addGap(19))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(59)
					.addComponent(sinf, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
					.addGap(30)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(59)
					.addComponent(asal, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
					.addGap(30)
					.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(59)
					.addComponent(jins, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
					.addGap(30)
					.addComponent(lblNewLabel_1_1_1, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(59)
					.addComponent(adad, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
					.addGap(30)
					.addComponent(lblNewLabel_1_1_1_1, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
					.addGap(19))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(59)
					.addComponent(mani, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
					.addGap(30)
					.addComponent(lblNewLabel_1_1_1_1_1, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(78)
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addGap(88)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
					.addGap(121))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
					.addGap(13)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(mashkool, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(7)))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(sinf, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(7)))
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(7)
							.addComponent(asal, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
							.addGap(1)))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(jins, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(lblNewLabel_1_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(7)))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(adad, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(lblNewLabel_1_1_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(4)))
					.addGap(7)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(mani, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
							.addGap(2))
						.addComponent(lblNewLabel_1_1_1_1_1, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 28, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
							.addGap(1)))
					.addGap(33))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
