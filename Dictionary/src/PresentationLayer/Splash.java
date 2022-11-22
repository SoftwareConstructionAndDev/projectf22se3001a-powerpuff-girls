package PresentationLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JProgressBar;

public class Splash extends JFrame {
	private JPanel contentPane;
	private JProgressBar progressBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
					Splash frame = new Splash();
					frame.setVisible(true);
					try {
					for(int i=0;i<100;i++)
					{
						Thread.sleep(10);
						frame.progressBar.setValue(i);
					}
					} catch (Exception e) {
						e.printStackTrace();
					}
					UserOptions uo=new UserOptions();
					frame.setVisible(false);
					uo.setVisible(true);
					
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Splash() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(51, 153, 153));
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(51, 153, 153));
		progressBar.setBounds(94, 230, 265, 14);
		contentPane.add(progressBar);
	}
}
