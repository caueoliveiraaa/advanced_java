package Formulary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Formulary extends JFrame {

	private JPanel contentPane;
	private JTextField txtN1;
	private JTextField txtN2;
	private JTextField txtN3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulary frame = new Formulary();
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
	public Formulary() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblN1 = new JLabel("Inform the first number:");
		lblN1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblN1.setBounds(10, 11, 384, 14);
		contentPane.add(lblN1);
		
		JLabel lblN2 = new JLabel("Informe the second number:");
		lblN2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblN2.setBounds(10, 85, 384, 14);
		contentPane.add(lblN2);
		
		JLabel lblN3 = new JLabel("Inform the third number:");
		lblN3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblN3.setBounds(10, 163, 398, 14);
		contentPane.add(lblN3);
		
		txtN1 = new JTextField();
		txtN1.setBounds(10, 36, 96, 20);
		contentPane.add(txtN1);
		txtN1.setColumns(10);
		
		txtN2 = new JTextField();
		txtN2.setBounds(10, 110, 96, 20);
		contentPane.add(txtN2);
		txtN2.setColumns(10);
		
		txtN3 = new JTextField();
		txtN3.setBounds(10, 188, 96, 20);
		contentPane.add(txtN3);
		txtN3.setColumns(10);
		
		JButton btnExecute = new JButton("Execute");
		btnExecute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					// Get numbers:
					int n1 = Integer.parseInt(txtN1.getText());  
					int n2 = Integer.parseInt(txtN2.getText());  
					int n3 = Integer.parseInt(txtN3.getText());  
					
					// Structure:
					String structure = "";
					
					// Conditional to determine the increasing order of the numbers:
					if (n1 < n2 && n1 < n3 && n2 < n3) {
						structure = "The increasing order of the values is "+n1+", "+n2+", and "+n3; 
					} else if (n1 < n2 && n1 < n3 && n3 < n2) {
						structure = "The increasing order of the values is "+n1+", "+n3+", and "+n2; 
					} else if (n2 < n1 && n2 < n3 && n1 < n3) {
						structure = "The increasing order of the values is "+n2+", "+n1+", and "+n3; 
					} else if (n2 < n1 && n2 < n3 && n3 < n1) {
						structure = "The increasing order of the values is "+n2+", "+n3+", and "+n1; 
					} else if (n3 < n2 && n3 < n1 && n1 < n2) {
						structure = "The increasing order of the values is "+n3+", "+n1+", and "+n2; 
					} else if (n3 < n2 && n3 < n1 && n2 < n1) {
						structure = "The increasing order of the values is "+n3+", "+n2+", and "+n1; 
					}
					
					// Display the increasing order of the numbers:
					JOptionPane.showMessageDialog(null, structure);
					
				}catch(Exception error) {
					JOptionPane.showMessageDialog(null, "Error: Invalid value or not all values were typed. Please try again!");
				}
			}
		});
		btnExecute.setBounds(272, 229, 89, 23);
		contentPane.add(btnExecute);
	}

}
