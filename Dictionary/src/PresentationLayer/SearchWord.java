package PresentationLayer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BusinessLogicLayer.FacadeBLL;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class SearchWord extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	 private FacadeBLL facade;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchWord frame = new SearchWord();
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
	public SearchWord() throws SQLException {
		 facade=new FacadeBLL();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 315);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("روٹ"))
				{
					try{
						MashkoolAgainstRoot mar=new MashkoolAgainstRoot();
					mar.show();
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				}
			}
		});
		comboBox.setBackground(new Color(0, 153, 153));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"عربی سے اردو", "اردو سے عربی", "روٹ"}));
		comboBox.setBounds(154, 11, 129, 22);
		contentPane.add(comboBox);
		
		
		JLabel lblNewLabel = new JLabel("لفظ درج کریں");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(new Color(0, 153, 153));
		lblNewLabel.setBounds(325, 62, 75, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(94, 59, 209, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("ٹھیک ہے");
		
		btnNewButton.setBackground(new Color(0, 153, 153));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(160, 90, 89, 23);
		contentPane.add(btnNewButton);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("مشكول:");
		lblNewLabel_1.setForeground(new Color(0, 153, 153));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1.setBounds(396, 131, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("صنف:");
		lblNewLabel_1_1.setForeground(new Color(0, 153, 153));
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(396, 156, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("أصل:");
		lblNewLabel_1_1_1.setForeground(new Color(0, 153, 153));
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(396, 181, 46, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("جنس:");
		lblNewLabel_1_1_1_1.setForeground(new Color(0, 153, 153));
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1_1_1_1.setBounds(396, 206, 46, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("عدد:");
		lblNewLabel_1_1_1_1_1.setForeground(new Color(0, 153, 153));
		lblNewLabel_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1_1_1_1_1.setBounds(396, 231, 46, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("معانی:");
		lblNewLabel_1_1_1_1_1_1.setForeground(new Color(0, 153, 153));
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1_1_1_1_1_1.setBounds(186, 131, 46, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("غیرمشکول:");
		lblNewLabel_1_1_1_1_1_1_1.setForeground(new Color(0, 153, 153));
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(173, 156, 59, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("غیرأصل:");
		lblNewLabel_1_1_1_1_1_1_1_1.setForeground(new Color(0, 153, 153));
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(183, 181, 49, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1 = new JLabel("روٹ:");
		lblNewLabel_1_1_1_1_1_1_1_1_1.setForeground(new Color(0, 153, 153));
		lblNewLabel_1_1_1_1_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1_1_1_1_1_1_1_1_1.setBounds(186, 206, 46, 14);
		contentPane.add(lblNewLabel_1_1_1_1_1_1_1_1_1);
		
		JLabel mashkool = new JLabel("NULL");
		mashkool.setForeground(new Color(0, 153, 153));
		mashkool.setFont(new Font("Times New Roman", Font.BOLD, 13));
		mashkool.setBounds(311, 131, 46, 14);
		contentPane.add(mashkool);
		
		JLabel sinf = new JLabel("NULL");
		sinf.setForeground(new Color(0, 153, 153));
		sinf.setFont(new Font("Times New Roman", Font.BOLD, 13));
		sinf.setBounds(311, 156, 46, 14);
		contentPane.add(sinf);
		
		JLabel asal = new JLabel("NULL");
		asal.setForeground(new Color(0, 153, 153));
		asal.setFont(new Font("Times New Roman", Font.BOLD, 13));
		asal.setBounds(311, 181, 46, 14);
		contentPane.add(asal);
		
		JLabel jins = new JLabel("NULL");
		jins.setForeground(new Color(0, 153, 153));
		jins.setFont(new Font("Times New Roman", Font.BOLD, 13));
		jins.setBounds(311, 206, 46, 14);
		contentPane.add(jins);
		
		JLabel adad = new JLabel("NULL");
		adad.setForeground(new Color(0, 153, 153));
		adad.setFont(new Font("Times New Roman", Font.BOLD, 13));
		adad.setBounds(311, 231, 46, 14);
		contentPane.add(adad);
		
		JLabel mani = new JLabel("NULL");
		mani.setForeground(new Color(0, 153, 153));
		mani.setFont(new Font("Times New Roman", Font.BOLD, 13));
		mani.setBounds(82, 131, 46, 14);
		contentPane.add(mani);
		
		JLabel ghairMashkool = new JLabel("NULL");
		ghairMashkool.setForeground(new Color(0, 153, 153));
		ghairMashkool.setFont(new Font("Times New Roman", Font.BOLD, 13));
		ghairMashkool.setBounds(82, 156, 46, 14);
		contentPane.add(ghairMashkool);
		
		JLabel ghair_asal = new JLabel("NULL");
		ghair_asal.setForeground(new Color(0, 153, 153));
		ghair_asal.setFont(new Font("Times New Roman", Font.BOLD, 13));
		ghair_asal.setBounds(82, 181, 46, 14);
		contentPane.add(ghair_asal);
		
		JLabel root = new JLabel("NULL");
		root.setForeground(new Color(0, 153, 153));
		root.setFont(new Font("Times New Roman", Font.BOLD, 13));
		root.setBounds(82, 206, 46, 14);
		contentPane.add(root);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String word=textField.getText();
				try {
					ArrayList<String> wordData=new ArrayList();
					if(comboBox.getSelectedItem().equals("عربی سے اردو"))
					{
						wordData=facade.getMeaningInUrdu(word);
						if(wordData!=null)
						{
							mashkool.setText(wordData.get(0));
							 sinf.setText(wordData.get(1));
							 asal.setText(wordData.get(2));
							 jins.setText(wordData.get(3));
							 adad.setText(wordData.get(4));
							 mani.setVisible(true);
							 lblNewLabel_1_1_1_1_1_1.setVisible(true);
							 mani.setText(wordData.get(5));
							 ghairMashkool.setText(wordData.get(6));
							 ghair_asal.setText(wordData.get(7));
							 root.setText(wordData.get(8));	
						}
						 
					}
					else if(comboBox.getSelectedItem().equals("اردو سے عربی"))
					{
						wordData=facade.getMeaningInArabic(word);
						if(wordData!=null)
						{
							mashkool.setText(wordData.get(0));
							 sinf.setText(wordData.get(1));
							 asal.setText(wordData.get(2));
							 jins.setText(wordData.get(3));
							 adad.setText(wordData.get(4));
							// mani.setText(wordData.get(5));
							 mani.setVisible(false);
							 lblNewLabel_1_1_1_1_1_1.setVisible(false);
							 ghairMashkool.setText(wordData.get(6));
							 ghair_asal.setText(wordData.get(7));
							 root.setText(wordData.get(8));	
						}
						 
					}
					else if(comboBox.getSelectedItem().equals("روٹ"))
					{
						MashkoolAgainstRoot mar=new MashkoolAgainstRoot();
						mar.show();
						dispose();
					}
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
