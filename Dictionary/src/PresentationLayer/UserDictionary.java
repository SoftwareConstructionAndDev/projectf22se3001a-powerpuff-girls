package PresentationLayer;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BusinessLogicLayer.FacadeBLL;

public class UserDictionary extends JFrame {

	private JPanel contentPane;
	 private FacadeBLL facade;
	 private JTable table;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserDictionary frame = new UserDictionary();
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
	public UserDictionary(String text) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u0645\u0634\u0643\u0648\u0644", "\u0635\u0646\u0641", "\u0623\u0635\u0644 ", "\u062C\u0646\u0633", "\u0639\u062F\u062F", "\u0645\u0639\u0627\u0646\u06CC", "\u063A\u06CC\u0631\u0645\u0634\u06A9\u0648\u0644", "\u063A\u06CC\u0631\u0623\u0635\u0644", "\u0631\u0648\u0679"
			}
		));
		table.setBounds(48, 95, 251, -48);
		contentPane.add(table);
		  facade=new FacadeBLL();
		ArrayList<ArrayList<String>> dicData=new ArrayList<ArrayList<String>>();
		
		
		for(int i=0;i<dicData.size();i++)
		{
			//String[] wordData=dicData.get(i);
			ArrayList<String> wordData=new ArrayList<String>();
			String[] words= {"","","","","","","","",""};
			for(int j=0;j<wordData.size();j++)
			{
				words[j]=wordData.get(j);
			}
			
			tableModel.addRow(words);
			
		}
	}
}
