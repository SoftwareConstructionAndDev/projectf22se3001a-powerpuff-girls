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

public class AdminOptions extends JFrame {

	private JPanel contentPane;
    private FacadeBLL facade=new FacadeBLL();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	
	public AdminOptions() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		btnNewButton.setBackground(new Color(0, 153, 153));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(28, 29, 113, 54);
		contentPane.add(btnNewButton);
		
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
		btnViewData.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnViewData.setBackground(new Color(0, 153, 153));
		btnViewData.setBounds(169, 31, 120, 51);
		contentPane.add(btnViewData);
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
