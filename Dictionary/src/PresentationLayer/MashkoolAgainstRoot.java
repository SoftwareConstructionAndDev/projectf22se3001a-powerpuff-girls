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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

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
		comboBox.setFont(new Font("Urdu Typesetting", Font.BOLD, 16));
		comboBox.setBackground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("لفظ درج کریں");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Urdu Typesetting", Font.BOLD, 13));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		
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
		btnNewButton.setFont(new Font("Urdu Typesetting", Font.BOLD, 13));
		btnNewButton.setBackground(Color.WHITE);
		
		
		JLabel lblNewLabel_1 = new JLabel("مشكول");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Urdu Typesetting", Font.BOLD, 13));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(139)
					.addComponent(comboBox, 0, 129, Short.MAX_VALUE)
					.addGap(156))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(83)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
					.addGap(22)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
					.addGap(35))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(155)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addGap(180))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(72)
					.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
					.addGap(22)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
					.addGap(35))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(comboBox, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(3)))
					.addGap(14)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(28)))
					.addGap(48))
		);
		contentPane.setLayout(gl_contentPane);
		
		
		
		
	}
}
