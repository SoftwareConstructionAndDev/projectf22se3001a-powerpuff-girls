package ViewLayer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import ControllerAL.Controller;
import java.awt.EventQueue;

public class View extends JFrame {

	private JPanel contentPane;

	Controller controller;
	private JTextField inputTF;
	private JTextField meaningTF;
	
	ArrayList<String> list;
	private JTextField mashkoolTF;
	private JTextField sinfTF;
	private JTextField asalTF;
	private JTextField jinsTF;
	private JTextField adadTF;
	private JTextField newMashkoolTF;
	private JTextField newAsalTF;
	
	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	
	public void setTextFieldData()
	{
		String word = inputTF.getText();
		ArrayList<String> list = controller.returnMeaning(word);
		mashkoolTF.setText(list.get(1));
		sinfTF.setText(list.get(2));
		asalTF.setText(list.get(3));
		jinsTF.setText(list.get(4));
		adadTF.setText(list.get(5));
		newMashkoolTF.setText(list.get(6));
		newAsalTF.setText(list.get(7));
		meaningTF.setText(list.get(8));
	}
	public View() {
		
		list = new ArrayList<>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		inputTF = new JTextField();
		inputTF.setBounds(77, 25, 96, 19);
		contentPane.add(inputTF);
		inputTF.setColumns(10);
		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setTextFieldData();
			}
		});
		searchButton.setBounds(183, 24, 85, 21);
		contentPane.add(searchButton);
		
		JLabel lblNewLabel = new JLabel("Input Word");
		lblNewLabel.setBounds(40, 2, 62, 13);
		contentPane.add(lblNewLabel);
		
		meaningTF = new JTextField();
		meaningTF.setBounds(77, 78, 96, 19);
		contentPane.add(meaningTF);
		meaningTF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Meaning");
		lblNewLabel_1.setBounds(10, 81, 62, 13);
		contentPane.add(lblNewLabel_1);
		
		mashkoolTF = new JTextField();
		mashkoolTF.setColumns(10);
		mashkoolTF.setBounds(77, 125, 96, 19);
		contentPane.add(mashkoolTF);
		
		sinfTF = new JTextField();
		sinfTF.setColumns(10);
		sinfTF.setBounds(77, 182, 96, 19);
		contentPane.add(sinfTF);
		
		asalTF = new JTextField();
		asalTF.setColumns(10);
		asalTF.setBounds(77, 237, 96, 19);
		contentPane.add(asalTF);
		
		jinsTF = new JTextField();
		jinsTF.setColumns(10);
		jinsTF.setBounds(354, 78, 96, 19);
		contentPane.add(jinsTF);
		
		adadTF = new JTextField();
		adadTF.setColumns(10);
		adadTF.setBounds(354, 125, 96, 19);
		contentPane.add(adadTF);
		
		newMashkoolTF = new JTextField();
		newMashkoolTF.setColumns(10);
		newMashkoolTF.setBounds(354, 182, 96, 19);
		contentPane.add(newMashkoolTF);
		
		newAsalTF = new JTextField();
		newAsalTF.setColumns(10);
		newAsalTF.setBounds(354, 237, 96, 19);
		contentPane.add(newAsalTF);
		
		JLabel lbl = new JLabel("Mashkool");
		lbl.setBounds(10, 128, 62, 13);
		contentPane.add(lbl);
		
		JLabel lblNewLabel_1_1 = new JLabel("Sinf:");
		lblNewLabel_1_1.setBounds(10, 185, 62, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Asal:");
		lblNewLabel_1_2.setBounds(10, 240, 62, 13);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Jins:");
		lblNewLabel_1_3.setBounds(268, 81, 62, 13);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Adad:");
		lblNewLabel_1_4.setBounds(268, 128, 62, 13);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("New Mashkool");
		lblNewLabel_1_5.setBounds(268, 185, 87, 13);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("New Adad");
		lblNewLabel_1_6.setBounds(319, 214, 62, 13);
		contentPane.add(lblNewLabel_1_6);
		
		controller = new Controller();
	}
}
