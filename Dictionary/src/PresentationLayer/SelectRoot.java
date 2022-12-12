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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("لفظ درج کریں");
		lblNewLabel.setForeground(new Color(0, 153, 153));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(320, 29, 75, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(75, 26, 209, 20);
		contentPane.add(textField);
		JRadioButton rdbtnNewRadioButton = new JRadioButton("NULL");
		rdbtnNewRadioButton.setBackground(new Color(0, 0, 0));
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.BOLD, 11));
		rdbtnNewRadioButton.setForeground(new Color(0, 153, 153));
		rdbtnNewRadioButton.setBounds(60, 131, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("NULL");
		rdbtnNewRadioButton_1.setBackground(new Color(0, 0, 0));
		rdbtnNewRadioButton_1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		rdbtnNewRadioButton_1.setForeground(new Color(0, 153, 153));
		rdbtnNewRadioButton_1.setBounds(258, 131, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("NULL");
		rdbtnNewRadioButton_2.setBackground(new Color(0, 0, 0));
		rdbtnNewRadioButton_2.setFont(new Font("Times New Roman", Font.BOLD, 11));
		rdbtnNewRadioButton_2.setForeground(new Color(0, 153, 153));
		rdbtnNewRadioButton_2.setBounds(60, 179, 109, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("NULL");
		rdbtnNewRadioButton_3.setBackground(new Color(0, 0, 0));
		rdbtnNewRadioButton_3.setFont(new Font("Times New Roman", Font.BOLD, 11));
		rdbtnNewRadioButton_3.setForeground(new Color(0, 153, 153));
		rdbtnNewRadioButton_3.setBounds(258, 179, 109, 23);
		contentPane.add(rdbtnNewRadioButton_3);
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
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBackground(new Color(0, 153, 153));
		btnNewButton_1.setBounds(150, 227, 89, 23);
		contentPane.add(btnNewButton_1);
		
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
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(0, 153, 153));
		btnNewButton.setBounds(150, 62, 89, 23);
		contentPane.add(btnNewButton);
		
		
		
		
		
		
		
		
		
		
	}
}
