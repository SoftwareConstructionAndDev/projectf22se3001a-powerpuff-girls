package ViewLayer;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ControllerAL.Controller;
import DataBaseLayer.DB;

public class View extends JFrame {

	private JPanel contentPane;

	Controller controller;
	private JTextField inputword;
	
	ArrayList<String> list;
	private JTextField adadbefore;
	private JTextField sinfbefore;
	private JTextField jinsbefore;
	private JTextField mashkoolbefore;
	private JTextField asalbefore;
	private JTextField mashkoolafter;
	private JTextField adadafter;
	private JTextField sinfafter;
	private JTextField jinsafter;
	private JTextField asalafter;
	private JTextField meaningbefore;
	private JTextField meaningafter;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void setTextFieldData()
	{
		String word = inputword.getText();
		ArrayList<String> list = controller.returnMeaning(word);
		adadbefore.setText(list.get(1));
		sinfbefore.setText(list.get(2));
		jinsbefore.setText(list.get(3));
		mashkoolbefore.setText(list.get(4));
		asalbefore.setText(list.get(5));
		meaningbefore.setText(list.get(6));
	}
	public View() {
		
		list = new ArrayList<>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 369);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		inputword = new JTextField();
		inputword.setBounds(129, 25, 96, 19);
		contentPane.add(inputword);
		inputword.setColumns(10);
		
		JButton searchButton = new JButton("Search");
		searchButton.setBackground(new Color(0, 153, 153));
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setTextFieldData();
			}
		});
		searchButton.setBounds(235, 25, 85, 21);
		contentPane.add(searchButton);
		
		JLabel lblNewLabel = new JLabel("Enter Word to Update");
		lblNewLabel.setForeground(new Color(0, 153, 153));
		lblNewLabel.setBounds(10, 29, 118, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Meaning:");
		lblNewLabel_1.setForeground(new Color(0, 153, 153));
		lblNewLabel_1.setBounds(10, 81, 62, 13);
		contentPane.add(lblNewLabel_1);
		
		adadbefore = new JTextField();
		adadbefore.setColumns(10);
		adadbefore.setBounds(77, 196, 96, 19);
		contentPane.add(adadbefore);
		
		sinfbefore = new JTextField();
		sinfbefore.setColumns(10);
		sinfbefore.setBounds(77, 110, 96, 19);
		contentPane.add(sinfbefore);
		
		jinsbefore = new JTextField();
		jinsbefore.setColumns(10);
		jinsbefore.setBounds(77, 140, 96, 19);
		contentPane.add(jinsbefore);
		
		mashkoolbefore = new JTextField();
		mashkoolbefore.setColumns(10);
		mashkoolbefore.setBounds(77, 166, 96, 19);
		contentPane.add(mashkoolbefore);
		
		asalbefore = new JTextField();
		asalbefore.setColumns(10);
		asalbefore.setBounds(77, 226, 96, 19);
		contentPane.add(asalbefore);
		
		mashkoolafter = new JTextField();
		mashkoolafter.setColumns(10);
		mashkoolafter.setBounds(383, 166, 96, 19);
		contentPane.add(mashkoolafter);
		
		adadafter = new JTextField();
		adadafter.setColumns(10);
		adadafter.setBounds(383, 196, 96, 19);
		contentPane.add(adadafter);
		
		JLabel lbl = new JLabel("Mashkool:");
		lbl.setForeground(new Color(0, 153, 153));
		lbl.setBounds(10, 170, 62, 13);
		contentPane.add(lbl);
		
		JLabel lblNewLabel_1_1 = new JLabel("Sinf:");
		lblNewLabel_1_1.setForeground(new Color(0, 153, 153));
		lblNewLabel_1_1.setBounds(10, 114, 62, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Asal:");
		lblNewLabel_1_2.setForeground(new Color(0, 153, 153));
		lblNewLabel_1_2.setBounds(10, 230, 62, 13);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Jins:");
		lblNewLabel_1_3.setForeground(new Color(0, 153, 153));
		lblNewLabel_1_3.setBounds(10, 144, 62, 13);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Adad:");
		lblNewLabel_1_4.setForeground(new Color(0, 153, 153));
		lblNewLabel_1_4.setBounds(10, 200, 62, 13);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Enter New Mashkool:");
		lblNewLabel_1_5.setForeground(new Color(0, 153, 153));
		lblNewLabel_1_5.setBounds(257, 170, 116, 13);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Enter New Adad:");
		lblNewLabel_1_6.setForeground(new Color(0, 153, 153));
		lblNewLabel_1_6.setBounds(257, 200, 116, 13);
		contentPane.add(lblNewLabel_1_6);
		
		sinfafter = new JTextField();
		sinfafter.setColumns(10);
		sinfafter.setBounds(383, 110, 96, 19);
		contentPane.add(sinfafter);
		
		jinsafter = new JTextField();
		jinsafter.setColumns(10);
		jinsafter.setBounds(383, 140, 96, 19);
		contentPane.add(jinsafter);
		
		asalafter = new JTextField();
		asalafter.setColumns(10);
		asalafter.setBounds(383, 226, 96, 19);
		contentPane.add(asalafter);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Enter New Jins:");
		lblNewLabel_1_5_1.setForeground(new Color(0, 153, 153));
		lblNewLabel_1_5_1.setBounds(257, 144, 87, 13);
		contentPane.add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_1_5_2 = new JLabel("Enter New Sinf:");
		lblNewLabel_1_5_2.setForeground(new Color(0, 153, 153));
		lblNewLabel_1_5_2.setBounds(257, 114, 87, 13);
		contentPane.add(lblNewLabel_1_5_2);
		
		JLabel lblNewLabel_1_5_3 = new JLabel("Enter New Asal:");
		lblNewLabel_1_5_3.setForeground(new Color(0, 153, 153));
		lblNewLabel_1_5_3.setBounds(257, 229, 87, 13);
		contentPane.add(lblNewLabel_1_5_3);
		
		JLabel lblNewLabel_1_5_4 = new JLabel("Enter New Meaning:");
		lblNewLabel_1_5_4.setForeground(new Color(0, 153, 153));
		lblNewLabel_1_5_4.setBounds(257, 80, 116, 13);
		contentPane.add(lblNewLabel_1_5_4);
		
		meaningbefore = new JTextField();
		meaningbefore.setColumns(10);
		meaningbefore.setBounds(77, 77, 96, 19);
		contentPane.add(meaningbefore);
		
		meaningafter = new JTextField();
		meaningafter.setColumns(10);
		meaningafter.setBounds(383, 77, 96, 19);
		contentPane.add(meaningafter);
		
		JButton update = new JButton("Update");
		update.setBackground(new Color(0, 153, 153));
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String me= meaningafter.getText();
				String si= sinfafter.getText();
				String ji= jinsafter.getText();
				String mas= mashkoolafter.getText();
				String ada= adadafter.getText();
				String asl= asalafter.getText();
				DB d=new DB();
				
				String updatquery= "update dictionary set meaning = '"+me+"', sinf= '"+si+"',jins= '"+ji+
						"',mashkool= '"+mas+"',adal= '"+ada+"',asal= '"+asl+"WHERE word ="+ inputword.getText()+";";
				
				
				Statement st;
				try {
					st = d.connection.createStatement();
					st.executeUpdate(updatquery);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		update.setBounds(383, 24, 85, 21);
		contentPane.add(update);
		
		controller = new Controller();
	}
}





