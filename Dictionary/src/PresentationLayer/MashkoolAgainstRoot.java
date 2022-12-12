package PresentationLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import BusinessLogicLayer.FacadeBLL;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTextPane;

public class MashkoolAgainstRoot extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MashkoolAgainstRoot frame = new MashkoolAgainstRoot();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	 private FacadeBLL facade=new FacadeBLL();
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public MashkoolAgainstRoot() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("عربی سے اردو"))
				{
					SearchWord sw;
					try {
						sw = new SearchWord();
						sw.show();
						dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				else if(comboBox.getSelectedItem().equals("اردو سے عربی"))
				{
					SearchWord sw;
					try {
						sw = new SearchWord();
						sw.show();
						dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"روٹ", "عربی سے اردو", "اردو سے عربی"}));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.setBackground(new Color(0, 153, 153));
		comboBox.setBounds(144, 11, 129, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("لفظ درج کریں");
		lblNewLabel.setForeground(new Color(0, 153, 153));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(319, 61, 75, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(88, 58, 209, 20);
		contentPane.add(textField);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(77, 148, 220, 60);
		contentPane.add(textPane);
		
		JButton btnNewButton = new JButton("ٹھیک ہے");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String word=textField.getText();
				ArrayList<String> wordData=new ArrayList();
				if(comboBox.getSelectedItem().equals("عربی سے اردو"))
				{
					SearchWord sw;
					try {
						sw = new SearchWord();
						sw.show();
						dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				else if(comboBox.getSelectedItem().equals("اردو سے عربی"))
				{
					SearchWord sw;
					try {
						sw = new SearchWord();
						sw.show();
						dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				else if(comboBox.getSelectedItem().equals("روٹ"))
				{
					ArrayList<String []> listOfMashkool=new ArrayList<String[]>();
					try {
						FacadeBLL facade=new FacadeBLL();
						listOfMashkool=facade.returnListOfMashkoolAgainstRoot(word);
						String mashkool="";
						for(int i=0;i<listOfMashkool.size();i++)
						{
							mashkool=mashkool+"\n"+listOfMashkool.get(i)[0];
							
						}
						textPane.setText(mashkool);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(0, 153, 153));
		btnNewButton.setBounds(160, 92, 89, 23);
		contentPane.add(btnNewButton);
		
		
		JLabel lblNewLabel_1 = new JLabel("مشكول");
		lblNewLabel_1.setForeground(new Color(0, 153, 153));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(319, 166, 75, 14);
		contentPane.add(lblNewLabel_1);
		
		
		
		
	}
}
