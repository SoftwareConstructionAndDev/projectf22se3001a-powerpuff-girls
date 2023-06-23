package PresentationLayer;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BusinessLogicLayer.FacadeBLL;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class UpdateWord extends JFrame {

	private JPanel contentPane;
	private JTable table;
private String mashkool,sinf,asal,jins,adad,mani,ghairMashkool,ghairAsal,root;
private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateWord frame = new UpdateWord();
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
	public UpdateWord() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 403);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
				mashkool=(String) table.getModel().getValueAt(table.getSelectedRow(), 1);
				 sinf=(String) table.getModel().getValueAt(table.getSelectedRow(), 2);
				System.out.println(sinf);
				 asal=(String) table.getModel().getValueAt(table.getSelectedRow(), 3);
				 jins=(String) table.getModel().getValueAt(table.getSelectedRow(), 4);
				 adad=(String) table.getModel().getValueAt(table.getSelectedRow(), 5);
			 mani=(String) table.getModel().getValueAt(table.getSelectedRow(), 6);
				 ghairMashkool=(String) table.getModel().getValueAt(table.getSelectedRow(), 7);
				 ghairAsal=(String) table.getModel().getValueAt(table.getSelectedRow(), 8);
				 root=(String) table.getModel().getValueAt(table.getSelectedRow(), 9);
			}
			
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 mashkool=(String) table.getModel().getValueAt(table.getSelectedRow(), 1);
				 sinf=(String) table.getModel().getValueAt(table.getSelectedRow(), 2);
				//System.out.println(sinf);
				 asal=(String) table.getModel().getValueAt(table.getSelectedRow(), 3);
				 jins=(String) table.getModel().getValueAt(table.getSelectedRow(), 4);
				 adad=(String) table.getModel().getValueAt(table.getSelectedRow(), 5);
			 mani=(String) table.getModel().getValueAt(table.getSelectedRow(), 6);
				 ghairMashkool=(String) table.getModel().getValueAt(table.getSelectedRow(), 7);
				 ghairAsal=(String) table.getModel().getValueAt(table.getSelectedRow(), 8);
				 root=(String) table.getModel().getValueAt(table.getSelectedRow(), 9);
			}
		});
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Urdu Typesetting", Font.PLAIN, 12));
		table.setCellSelectionEnabled(true);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("واپس جاو");
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
		btnNewButton_1.setFont(new Font("Urdu Typesetting", Font.PLAIN, 16));
		
		FacadeBLL facade=new FacadeBLL();
		
DefaultTableModel tableModel=(DefaultTableModel) table.getModel();
		
		int numberOfColumns=facade.getMetaDataOfDictionaryData().getColumnCount();
		String[] columNames=new String[numberOfColumns];
		for(int i=0;i<numberOfColumns;i++)
		{
			columNames[i]=facade.getMetaDataOfDictionaryData().getColumnName(i+1);
		}
		tableModel.setColumnIdentifiers(columNames);
		LinkedList<String[]> list=facade.getDataFromDb();
		for(int i=0;i<list.size();i++)
		{
			String[] wordData=list.get(i);
			tableModel.addRow(wordData);
			
		}
		
		
		
		JButton btnNewButton_1_1 = new JButton("اپ ڈیٹ");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String word=textField.getText();
					tableModel.setValueAt(word, table.getSelectedRow(), table.getSelectedColumn());
					mashkool=(String) table.getModel().getValueAt(table.getSelectedRow(), 1);
					 sinf=(String) table.getModel().getValueAt(table.getSelectedRow(), 2);
					System.out.println(sinf);
					 asal=(String) table.getModel().getValueAt(table.getSelectedRow(), 3);
					 jins=(String) table.getModel().getValueAt(table.getSelectedRow(), 4);
					 adad=(String) table.getModel().getValueAt(table.getSelectedRow(), 5);
				 mani=(String) table.getModel().getValueAt(table.getSelectedRow(), 6);
					 ghairMashkool=(String) table.getModel().getValueAt(table.getSelectedRow(), 7);
					 ghairAsal=(String) table.getModel().getValueAt(table.getSelectedRow(), 8);
					 root=(String) table.getModel().getValueAt(table.getSelectedRow(), 9);
					 facade.updateInLughat(mashkool,sinf,asal,jins,adad,mani,ghairMashkool,ghairAsal,root);
					
					/*tableModel.setValueAt(mashkool, table.getSelectedRow(), 1);
					tableModel.setValueAt(sinf, table.getSelectedRow(), 2);
					tableModel.setValueAt(asal, table.getSelectedRow(), 3);
					tableModel.setValueAt(jins, table.getSelectedRow(), 4);
					tableModel.setValueAt(adad, table.getSelectedRow(), 5);
					tableModel.setValueAt(mani, table.getSelectedRow(), 6);
					tableModel.setValueAt(ghairMashkool, table.getSelectedRow(), 7);
					tableModel.setValueAt(ghairAsal, table.getSelectedRow(), 8);
					tableModel.setValueAt(root, table.getSelectedRow(), 9);*/
					JOptionPane.showMessageDialog(null, "لفظ کی لغت کو اپ ڈیٹ کر دیا گیا ہے۔");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "ایکسیپشن SQL");
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Urdu Typesetting", Font.PLAIN, 16));
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(44)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
					.addGap(64))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(56)
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
					.addGap(96)
					.addComponent(btnNewButton_1_1, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
					.addGap(48))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
					.addGap(16)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
						.addComponent(btnNewButton_1_1, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
					.addGap(23))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
}
