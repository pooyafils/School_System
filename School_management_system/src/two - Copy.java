import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class two extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					
					two frame = new two();
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
	
	

	public two() {
		String pooya;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel one = new JLabel("Sign up");
		one.setFont(new Font("Traditional Arabic", Font.PLAIN, 24));
		one.setForeground(Color.WHITE);
		one.setBounds(45, 77, 74, 23);
		contentPane.add(one);
		
		JButton btnNewButton = new JButton("registration");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new three().setVisible(true);
			dispose();
			
			}
		});
		btnNewButton.setBounds(45, 219, 102, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("login");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.print(textField_1.getText());
				System.out.print(textField_2.getText());
				
				if(textField_1.getText().equals("a") && textField_2.getText().equals("a")) {
					
					JOptionPane.showMessageDialog(null,"welcome");
						new dashboard().setVisible(true);
						dispose();
				}
				else {
					JOptionPane.showMessageDialog(null,"try again"+"!");
				}
				
				
					
			}
			
		});
		
		btnNewButton_1.setBounds(417, 219, 89, 23);
		contentPane.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(417, 114, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(417, 164, 89, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblLogIn = new JLabel("Log in");
		lblLogIn.setForeground(Color.WHITE);
		lblLogIn.setFont(new Font("Traditional Arabic", Font.PLAIN, 24));
		lblLogIn.setBounds(417, 83, 74, 23);
		contentPane.add(lblLogIn);
		
		JLabel lblV = new JLabel("v 1.0");
		lblV.setForeground(Color.WHITE);
		lblV.setBounds(10, 336, 46, 14);
		contentPane.add(lblV);
		
		textField = new JTextField();
		textField.setBounds(417, 125, 86, 20);
		
		textField.setColumns(10);
		 pooya= textField_1.getText();
				
	}
}
