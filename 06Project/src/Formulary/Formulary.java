package Formulary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Formulary extends JFrame {

	private JPanel contentPane;
	private JTextField txtValuePerHour;
	private JTextField txtEarnedMonth;
	private JTextField txt50extra;
	private JTextField txt100extra;

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
		
		JLabel lblValuePerHour = new JLabel("Inform how much is earned per hour:");
		lblValuePerHour.setBounds(10, 11, 267, 14);
		contentPane.add(lblValuePerHour);
		
		JLabel lblValueEarnedMonth = new JLabel("Inform the value earned in a month:");
		lblValueEarnedMonth.setBounds(10, 61, 267, 14);
		contentPane.add(lblValueEarnedMonth);
		
		JLabel lblOverTime50 = new JLabel("Informe the hours worked overtime plus 50% extra:");
		lblOverTime50.setBounds(10, 108, 344, 14);
		contentPane.add(lblOverTime50);
		
		JLabel lblOverTime100 = new JLabel("Informe the hours worked overtime plus 100% extra:");
		lblOverTime100.setBounds(10, 158, 355, 14);
		contentPane.add(lblOverTime100);
		
		txtValuePerHour = new JTextField();
		txtValuePerHour.setBounds(10, 36, 184, 14);
		contentPane.add(txtValuePerHour);
		txtValuePerHour.setColumns(10);
		
		txtEarnedMonth = new JTextField();
		txtEarnedMonth.setBounds(10, 83, 184, 14);
		contentPane.add(txtEarnedMonth);
		txtEarnedMonth.setColumns(10);
		
		txt50extra = new JTextField();
		txt50extra.setBounds(10, 133, 184, 14);
		contentPane.add(txt50extra);
		txt50extra.setColumns(10);
		
		txt100extra = new JTextField();
		txt100extra.setBounds(10, 183, 184, 14);
		contentPane.add(txt100extra);
		txt100extra.setColumns(10);
		
		JButton btnNewButton = new JButton("Calculate the gross salary");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					double valueHour = Double.parseDouble(txtValuePerHour.getText());
					double earnedMonth = Double.parseDouble(txtEarnedMonth.getText());
					double extra50 = Double.parseDouble(txt50extra.getText()) * 1.5;
					double extra100 = Double.parseDouble(txt100extra.getText()) * 2;
					
					double finalValue = (valueHour * earnedMonth) + (valueHour * extra50) + (valueHour * extra100);
					
					JOptionPane.showMessageDialog(null, "The gross salary is "+finalValue);
									
				}catch(Exception error) {
					JOptionPane.showMessageDialog(null, "Invalid value. PLease try again!");
				}
			}
		});
		btnNewButton.setBounds(10, 229, 239, 23);
		contentPane.add(btnNewButton);
	}

}
