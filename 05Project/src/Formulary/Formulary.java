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
import java.text.DecimalFormat;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Formulary extends JFrame {

	private JPanel contentPane;
	private JTextField lblMonth_1;
	private JTextField lblValue_1;

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
		
		JLabel lblMonth = new JLabel("Type in the amount of months: ");
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMonth.setBounds(10, 11, 283, 34);
		contentPane.add(lblMonth);
		
		JLabel lblValue = new JLabel("Type in the value of the investment:");
		lblValue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblValue.setBounds(10, 86, 299, 42);
		contentPane.add(lblValue);
		
		lblMonth_1 = new JTextField();
		lblMonth_1.setBounds(10, 55, 192, 20);
		contentPane.add(lblMonth_1);
		lblMonth_1.setColumns(10);
		
		lblValue_1 = new JTextField();
		lblValue_1.setBounds(10, 128, 192, 20);
		contentPane.add(lblValue_1);
		lblValue_1.setColumns(10);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				try {
					
					// Get data:
					double value = Double.parseDouble(lblValue_1.getText());
					int months = Integer.parseInt(lblMonth_1.getText());
					
					// Structure:
					String structure = "Investiment: \n";
					
					// Calculate the investment: 
					for (int i = 0; i < months; i++) {
						value += value * 0.0036; 
						
						DecimalFormat df = new DecimalFormat("0.##");
						String formattedValue = df.format(value);
						
						structure += "The value invested after "+months+" months is "+formattedValue+"\n";
							
					}
					
					JOptionPane.showMessageDialog(null, structure);
					
				
				}catch(Exception error) {
					JOptionPane.showMessageDialog(null, "The value typed is inlavid! Please try again.");
				}
			}		
		});	
		btnCalculate.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnCalculate.setBounds(149, 197, 130, 42);
		contentPane.add(btnCalculate);
		

	}
}
