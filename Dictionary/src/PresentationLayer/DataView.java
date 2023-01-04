package PresentationLayer;

import java.awt.Color;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import BusinessLogicLayer.DictionaryBLL;
import BusinessLogicLayer.FacadeBLL;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
public class DataView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	 private FacadeBLL facade=new FacadeBLL();
	 private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataView frame = new DataView();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "ایکسیپشن");
					PropertyConfigurator.configure("log4j.properties");
					Logger logger=Logger.getLogger(Login.class);
					logger.info("EXCEPTION");
					logger.warn("EXCEPTION");
					logger.error("EXCEPTION");
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public DataView() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 345);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u0631\u0642\u0645", "\u0645\u0634\u06A9\u0648\u0644", "\u0635\u0646\u0641", "\u0623\u0635\u0644", "\u062C\u0646\u0633", "\u0639\u062F\u062F", "\u0645\u0639\u0627\u0646\u06CC", "\u063A\u06CC\u0631\u0645\u0634\u06A9\u0648\u0644", "\t\u063A\u06CC\u0631\u0623\u0635\u0644"
			}
		));
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		
		DefaultTableModel tableModel=(DefaultTableModel) table.getModel();
		
		btnNewButton_1 = new JButton("واپس جاو");
		btnNewButton_1.setFont(new Font("Urdu Typesetting", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminOptions adminOptions;
				try {
					adminOptions = new AdminOptions();
					dispose();
					adminOptions.show();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
					.addGap(5))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(164)
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
					.addGap(179))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 33, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		//DictionaryBLL dbll=new DictionaryBLL();
		LinkedList<String[]> list=facade.getDataFromDb();
		for(int i=0;i<list.size();i++)
		{
			String[] wordData=list.get(i);
			tableModel.addRow(wordData);
			
		}
		
	}
}
