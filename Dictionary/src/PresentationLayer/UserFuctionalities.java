package PresentationLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class UserFuctionalities extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserFuctionalities frame = new UserFuctionalities();
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
	public UserFuctionalities() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 373);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("معنی دیکھیں");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchWord search;
				try {
					search = new SearchWord();
					search.show();
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Urdu Typesetting", Font.BOLD, 18));
		
		JButton btnNewButton_1 = new JButton("اپنی مرضی کے مطابق ڈکشنری بنائیں");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomDictionary cd=new CustomDictionary();
				cd.show();
				dispose();
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Urdu Typesetting", Font.BOLD, 18));
		
		JButton btnNewButton_2 = new JButton("روٹ منتخب کریں");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectRoot sr=new SelectRoot();
				sr.show();
				dispose();
			}
			
		});
		btnNewButton_2.setFont(new Font("Urdu Typesetting", Font.BOLD, 15));
		btnNewButton_2.setBackground(Color.WHITE);
		
		JButton btnNewButton_1_1 = new JButton("واپس جاو");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserOptions userOptions=new UserOptions();
				dispose();
				userOptions.show();
			}
		});
		btnNewButton_1_1.setFont(new Font("Urdu Typesetting", Font.BOLD, 18));
		btnNewButton_1_1.setBackground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(107)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton_1_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
						.addComponent(btnNewButton_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
					.addGap(98))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
					.addGap(15)
					.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
					.addGap(11)
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnNewButton_1_1, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
					.addGap(28))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
