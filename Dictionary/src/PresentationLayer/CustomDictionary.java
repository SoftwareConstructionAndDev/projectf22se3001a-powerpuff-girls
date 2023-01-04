package PresentationLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class CustomDictionary extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomDictionary frame = new CustomDictionary();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CustomDictionary() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("متن درج کریں");
		lblNewLabel.setForeground(new Color(0, 153, 153));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JTextArea textArea = new JTextArea();
		
		JButton btnNewButton = new JButton("ٹھیک ہے");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDictionary ud;
				try {
					ud = new UserDictionary(textArea.getText());
					ud.show();
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(0, 153, 153));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(80)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
					.addGap(5))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(156)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addGap(179))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
							.addGap(56)))
					.addGap(33)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(45))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
