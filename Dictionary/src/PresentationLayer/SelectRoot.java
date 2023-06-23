package PresentationLayer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BusinessLogicLayer.FacadeBLL;
import BusinessLogicLayer.IFacadeBLL;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SelectRoot extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private ButtonGroup btngrp=new ButtonGroup();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectRoot frame = new SelectRoot();
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
	public SelectRoot() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 349);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("لفظ درج کریں");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Urdu Typesetting", Font.BOLD, 14));
		
		textField = new JTextField();
		textField.setColumns(10);
		JRadioButton rdbtnNewRadioButton = new JRadioButton("NULL");
		rdbtnNewRadioButton.setBackground(new Color(0, 0, 0));
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.BOLD, 11));
		rdbtnNewRadioButton.setForeground(Color.WHITE);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("NULL");
		rdbtnNewRadioButton_1.setBackground(new Color(0, 0, 0));
		rdbtnNewRadioButton_1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		rdbtnNewRadioButton_1.setForeground(Color.WHITE);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("NULL");
		rdbtnNewRadioButton_2.setBackground(new Color(0, 0, 0));
		rdbtnNewRadioButton_2.setFont(new Font("Times New Roman", Font.BOLD, 11));
		rdbtnNewRadioButton_2.setForeground(Color.WHITE);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("NULL");
		rdbtnNewRadioButton_3.setBackground(new Color(0, 0, 0));
		rdbtnNewRadioButton_3.setFont(new Font("Times New Roman", Font.BOLD, 11));
		rdbtnNewRadioButton_3.setForeground(Color.WHITE);
		JButton btnNewButton_1 = new JButton("ٹھیک ہے");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					IFacadeBLL facade=new FacadeBLL();
					if(rdbtnNewRadioButton.isSelected())
					{
					facade.setRootInLughat(textField.getText(),rdbtnNewRadioButton.getText() );	
					}
					else if(rdbtnNewRadioButton_1.isSelected())
					{
					facade.setRootInLughat(textField.getText(),rdbtnNewRadioButton_1.getText() );	
					}
					else if(rdbtnNewRadioButton_2.isSelected())
					{
					facade.setRootInLughat(textField.getText(),rdbtnNewRadioButton_2.getText() );	
					}
					if(rdbtnNewRadioButton_3.isSelected())
					{
					facade.setRootInLughat(textField.getText(),rdbtnNewRadioButton_3.getText() );	
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Urdu Typesetting", Font.BOLD, 14));
		btnNewButton_1.setBackground(Color.WHITE);
		
		JButton btnNewButton = new JButton("ٹھیک ہے");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					IFacadeBLL facade=new FacadeBLL();
					ArrayList<String> roots=new ArrayList();
					int a=107;
					roots=facade.getRootsuggestions(textField.getText());
					if(roots.size()==0)
					{
						rdbtnNewRadioButton.setVisible(false);
						rdbtnNewRadioButton_1.setVisible(false);
						rdbtnNewRadioButton_2.setVisible(false);
						rdbtnNewRadioButton_3.setVisible(false);
						btnNewButton_1.setVisible(false);
						JOptionPane.showMessageDialog(null, " null = روٹ");
					}
					if(roots!=null)
					{
						rdbtnNewRadioButton.setText(roots.get(0));
						if(roots.size()>=2)
						{
							rdbtnNewRadioButton_1.setText(roots.get(1));	
						}
						else
						{
							rdbtnNewRadioButton_1.setVisible(false);
							rdbtnNewRadioButton_2.setVisible(false);
							rdbtnNewRadioButton_3.setVisible(false);
						}
						if(roots.size()>=3)
						{
						rdbtnNewRadioButton_2.setText(roots.get(2));
						}
						{
							rdbtnNewRadioButton_2.setVisible(false);
							rdbtnNewRadioButton_3.setVisible(false);
						}
						if(roots.size()>=4)
						{
						rdbtnNewRadioButton_3.setText(roots.get(3));
						}
						else
						{
							
							rdbtnNewRadioButton_3.setVisible(false);
						}
						
					}
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Urdu Typesetting", Font.BOLD, 14));
		btnNewButton.setBackground(Color.WHITE);
		
		JButton btnNewButton_1_1 = new JButton("واپس جاو");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserFuctionalities userFunctionalities=new UserFuctionalities();
				dispose();
				userFunctionalities.show();
			}
		});
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setFont(new Font("Urdu Typesetting", Font.BOLD, 14));
		btnNewButton_1_1.setBackground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(70)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
					.addGap(36)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
					.addGap(34))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(145)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addGap(190))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(55)
					.addComponent(rdbtnNewRadioButton, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(89)
					.addComponent(rdbtnNewRadioButton_1, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(62))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(55)
							.addComponent(rdbtnNewRadioButton_2, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(38)
							.addComponent(btnNewButton_1_1, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(89)
							.addComponent(rdbtnNewRadioButton_3, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)))
					.addGap(62))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(3)))
					.addGap(16)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 9, Short.MAX_VALUE)
					.addGap(46)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnNewRadioButton, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
						.addComponent(rdbtnNewRadioButton_1, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnNewRadioButton_2, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
						.addComponent(rdbtnNewRadioButton_3, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1_1, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		
		
		
		
		
		
		
		
		
	}
}
