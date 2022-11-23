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
import BusinessLogicLayer.DictionaryBLL;
import javax.swing.JScrollBar;
public class DataView extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataView frame = new DataView();
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
	public DataView() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u0631\u0642\u0645", "\u0645\u0634\u06A9\u0648\u0644", "\u0635\u0646\u0641", "\u0623\u0635\u0644", "\u062C\u0646\u0633", "\u0639\u062F\u062F", "\u0645\u0639\u0627\u0646\u06CC", "\u063A\u06CC\u0631\u0645\u0634\u06A9\u0648\u0644", "\t\u063A\u06CC\u0631\u0623\u0635\u0644"
			}
		));
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBounds(10, 11, 414, 222);
		contentPane.add(table);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(407, 11, 17, 222);
		contentPane.add(scrollBar);
		
		DefaultTableModel tableModel=(DefaultTableModel) table.getModel();
		DictionaryBLL dbll=new DictionaryBLL();
		LinkedList<String[]> list=dbll.getDataFromDb();
		for(int i=0;i<list.size();i++)
		{
			String[] wordData=list.get(i);
			tableModel.addRow(wordData);
			
		}
		
	}
}