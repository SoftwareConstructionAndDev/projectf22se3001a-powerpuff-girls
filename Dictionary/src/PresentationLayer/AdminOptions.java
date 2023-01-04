package PresentationLayer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import BusinessLogicLayer.DictionaryBLL;
import BusinessLogicLayer.FacadeBLL;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AdminOptions extends JFrame {

	private JPanel contentPane;
    private FacadeBLL facade=new FacadeBLL();
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminOptions frame = new AdminOptions();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "ایکسیپشن");
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	
	public AdminOptions() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 438);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("امپورٹ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc=new JFileChooser();
				FileNameExtensionFilter fileFilter=new FileNameExtensionFilter(".csv","csv");
				fc.setFileFilter(fileFilter);
				int fileChosen=fc.showOpenDialog(null);
				if(fileChosen==JFileChooser.APPROVE_OPTION) {
					
					try {
						File file=new File(fc.getSelectedFile().getAbsolutePath());
						//DictionaryBLL dbll=new DictionaryBLL();
						facade.importFiles(file);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "ایکسیپشن IO");
						PropertyConfigurator.configure("log4j.properties");
						Logger logger=Logger.getLogger(Login.class);
						logger.info("IO EXCEPTION");
						logger.warn("IO EXCEPTION");
						logger.error("IO EXCEPTION");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						//JOptionPane.showMessageDialog(null, "ایکسیپشن SQL");
						JOptionPane.showMessageDialog(null, "ایکسیپشن SQL");
						PropertyConfigurator.configure("log4j.properties");
						Logger logger=Logger.getLogger(Login.class);
						logger.info("SQL EXCEPTION");
						logger.warn("SQL EXCEPTION");
						logger.error("SQL EXCEPTION");
					}					
				}
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Urdu Typesetting", Font.BOLD, 18));
		
		JButton btnViewData = new JButton("ویو ڈیٹا");
		btnViewData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataView dv = null;
				try {
					dv = new DataView();
					dv.show();
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "ایکسیپشن");
				}
				
			}
		});
		btnViewData.setFont(new Font("Urdu Typesetting", Font.BOLD, 18));
		btnViewData.setBackground(Color.WHITE);
		
		JButton btnViewData_1 = new JButton("ایڈ ورڈ");
		btnViewData_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddWord uw=new AddWord();
				uw.show();
				dispose();
			}
		});
		btnViewData_1.setFont(new Font("Urdu Typesetting", Font.BOLD, 18));
		btnViewData_1.setBackground(Color.WHITE);
		
		JButton btnViewData_1_1 = new JButton("لاگ آوٹ");
		btnViewData_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserOptions userOptions=new UserOptions();
				dispose();
				userOptions.show();
			}
		});
		btnViewData_1_1.setFont(new Font("Urdu Typesetting", Font.BOLD, 18));
		btnViewData_1_1.setBackground(Color.WHITE);
		
		JButton btnViewData_1_2 = new JButton("اپ ڈیٹ ورڈ");
		btnViewData_1_2.setFont(new Font("Urdu Typesetting", Font.BOLD, 18));
		btnViewData_1_2.setBackground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(143)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnViewData_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnViewData, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
						.addComponent(btnViewData_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnViewData_1_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(17)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnViewData, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnViewData_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
					.addComponent(btnViewData_1_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnViewData_1_1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addGap(19))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	/**
	 * @author Saliha Shahid
	 * @param file
	 * @return
	 */
	public File getFilePath(File file)
	{
		return file;
	}
}
