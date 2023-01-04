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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

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
		setBounds(100, 100, 457, 332);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
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
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Urdu Typesetting", Font.BOLD, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"عربی سے اردو", "اردو سے عربی", "روٹ"}));
		
		
		JLabel lblNewLabel = new JLabel("لفظ درج کریں");
		lblNewLabel.setFont(new Font("Urdu Typesetting", Font.BOLD, 13));
		lblNewLabel.setForeground(Color.WHITE);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("ٹھیک ہے");
		
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Urdu Typesetting", Font.BOLD, 13));
		
		
		
		JLabel lblNewLabel_1 = new JLabel("مشكول:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Urdu Typesetting", Font.BOLD, 13));
		
		JLabel lblNewLabel_1_1 = new JLabel("صنف:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Urdu Typesetting", Font.BOLD, 13));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("أصل:");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Urdu Typesetting", Font.BOLD, 13));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("جنس:");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Urdu Typesetting", Font.BOLD, 13));
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("عدد:");
		lblNewLabel_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Urdu Typesetting", Font.BOLD, 13));
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("معانی:");
		lblNewLabel_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Urdu Typesetting", Font.BOLD, 13));
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("غیرمشکول:");
		lblNewLabel_1_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Urdu Typesetting", Font.BOLD, 13));
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("غیرأصل:");
		lblNewLabel_1_1_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("Urdu Typesetting", Font.BOLD, 13));
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1 = new JLabel("روٹ:");
		lblNewLabel_1_1_1_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_1_1_1_1.setFont(new Font("Urdu Typesetting", Font.BOLD, 13));
		
		JLabel mashkool = new JLabel("NULL");
		mashkool.setForeground(Color.WHITE);
		mashkool.setFont(new Font("Times New Roman", Font.BOLD, 13));
		
		JLabel sinf = new JLabel("NULL");
		sinf.setForeground(Color.WHITE);
		sinf.setFont(new Font("Times New Roman", Font.BOLD, 13));
		
		JLabel asal = new JLabel("NULL");
		asal.setForeground(Color.WHITE);
		asal.setFont(new Font("Times New Roman", Font.BOLD, 13));
		
		JLabel jins = new JLabel("NULL");
		jins.setForeground(Color.WHITE);
		jins.setFont(new Font("Times New Roman", Font.BOLD, 13));
		
		JLabel adad = new JLabel("NULL");
		adad.setForeground(Color.WHITE);
		adad.setFont(new Font("Times New Roman", Font.BOLD, 13));
		
		JLabel mani = new JLabel("NULL");
		mani.setForeground(Color.WHITE);
		mani.setFont(new Font("Times New Roman", Font.BOLD, 13));
		
		JLabel ghairMashkool = new JLabel("NULL");
		ghairMashkool.setForeground(Color.WHITE);
		ghairMashkool.setFont(new Font("Times New Roman", Font.BOLD, 13));
		
		JLabel ghair_asal = new JLabel("NULL");
		ghair_asal.setForeground(Color.WHITE);
		ghair_asal.setFont(new Font("Times New Roman", Font.BOLD, 13));
		
		JLabel root = new JLabel("NULL");
		root.setForeground(Color.WHITE);
		root.setFont(new Font("Times New Roman", Font.BOLD, 13));
		
		JButton btnNewButton_1_1 = new JButton("واپس جاو");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserFuctionalities userFunctionalities=new UserFuctionalities();
				dispose();
				userFunctionalities.show();
			}
		});
		btnNewButton_1_1.setFont(new Font("Urdu Typesetting", Font.BOLD, 18));
		btnNewButton_1_1.setBackground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(89)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
					.addGap(22)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
					.addGap(42))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(77)
					.addComponent(mani, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
					.addGap(58)
					.addComponent(lblNewLabel_1_1_1_1_1_1, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
					.addGap(79)
					.addComponent(mashkool, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
					.addGap(39)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(77)
					.addComponent(ghairMashkool, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
					.addGap(45)
					.addComponent(lblNewLabel_1_1_1_1_1_1_1, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
					.addGap(79)
					.addComponent(sinf, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
					.addGap(39)
					.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(77)
					.addComponent(ghair_asal, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
					.addGap(55)
					.addComponent(lblNewLabel_1_1_1_1_1_1_1_1, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
					.addGap(79)
					.addComponent(asal, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
					.addGap(39)
					.addComponent(lblNewLabel_1_1_1, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(164)
					.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(171))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(155)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
					.addGap(193))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(77)
							.addComponent(root, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
							.addGap(58)
							.addComponent(lblNewLabel_1_1_1_1_1_1_1_1_1, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
							.addGap(79))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(42)
							.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 4, Short.MAX_VALUE)
							.addGap(132)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(adad, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
							.addGap(45)
							.addComponent(lblNewLabel_1_1_1_1_1, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(jins, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
							.addGap(39)
							.addComponent(lblNewLabel_1_1_1_1, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(3)))
					.addGap(11)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(mani, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(mashkool, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(ghairMashkool, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(sinf, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1_1_1_1_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(ghair_asal, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(asal, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 19, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1_1_1_1_1_1_1_1, 0, 0, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(jins, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1_1_1_1_1_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(root, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(adad, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 34, Short.MAX_VALUE)))
		);
		contentPane.setLayout(gl_contentPane);
		
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
