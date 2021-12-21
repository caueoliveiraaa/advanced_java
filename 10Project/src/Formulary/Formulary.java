package Formulary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Formulary extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumber;

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
		
		JLabel lblNumber = new JLabel("Informe a number:");
		lblNumber.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNumber.setBounds(10, 11, 315, 62);
		contentPane.add(lblNumber);
		
		txtNumber = new JTextField();
		txtNumber.setBounds(10, 84, 207, 33);
		contentPane.add(txtNumber);
		txtNumber.setColumns(10);
		
		JButton btnTimesTable = new JButton("Return the times table of the number typed");
		btnTimesTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					// Get data:
					int number = Integer.parseInt(txtNumber.getText());
					
					// Structure:
					String structure = "***TIMES TABLE***\n";
					
					// For loop to create the times table:
			        for (int i = 1; i < 11; i++) {
			        	structure += "The number typed times " + i + " will be " + (number * i) + "\n";
			        }
			        
					// Display the times table:
					JOptionPane.showMessageDialog(null, structure);
					
				}catch(Exception error) {
					JOptionPane.showMessageDialog(null, "Error: Invalid value. Please, type in a number!");
				}
				

			}
		});
		btnTimesTable.setBounds(10, 158, 288, 62);
		contentPane.add(btnTimesTable);
	}

}
