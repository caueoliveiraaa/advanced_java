package formulary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class formulary extends JFrame {

	private JPanel contentPane;
	private JTextField textFirstGrade;
	private JLabel lblSecondGrade;
	private JTextField textSecondGrade;
	private JTextField textThirdGrade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formulary frame = new formulary();
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
	public formulary() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstGrade = new JLabel("First grade:");
		lblFirstGrade.setBounds(28, 36, 81, 21);
		contentPane.add(lblFirstGrade);
		
		textFirstGrade = new JTextField();
		textFirstGrade.setBounds(119, 36, 291, 20);
		contentPane.add(textFirstGrade);
		textFirstGrade.setColumns(10);
		
		lblSecondGrade = new JLabel("Second grade:");
		lblSecondGrade.setBounds(28, 94, 121, 21);
		contentPane.add(lblSecondGrade);
		
		textSecondGrade = new JTextField();
		textSecondGrade.setColumns(10);
		textSecondGrade.setBounds(119, 94, 291, 20);
		contentPane.add(textSecondGrade);
		
		JLabel lblThirdGrade = new JLabel("Third grade:");
		lblThirdGrade.setBounds(28, 153, 82, 21);
		contentPane.add(lblThirdGrade);
		
		textThirdGrade = new JTextField();
		textThirdGrade.setColumns(10);
		textThirdGrade.setBounds(119, 153, 291, 20);
		contentPane.add(textThirdGrade);
		
		JLabel lblOutcome = new JLabel("");
		lblOutcome.setBounds(10, 238, 416, 14);
		contentPane.add(lblOutcome);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					// Get grades:
					double grade1 = Double.parseDouble(textFirstGrade.getText());
					double grade2 = Double.parseDouble(textSecondGrade.getText());
					double grade3 = Double.parseDouble(textThirdGrade.getText());
					
					// Calculate average:
					double average = (grade1+grade2+grade3)/3;
					
					// Format the average:
					DecimalFormat df = new DecimalFormat("0.##");
					String avegaredFormatted = df.format(average);
					
					// Ternary operator to check the student's situation:
					String situation = average >= 7 ? "The students has been approved" : "The student has flunked";
					
					// Return the formatted average and the situation of the student:
					lblOutcome.setText(situation + " with the average being "+avegaredFormatted);
					
				} catch(Exception error) {
					lblOutcome.setText("Calculation failed. Try again!");
				}
				
			}
		});
		btnCalculate.setBounds(171, 204, 89, 23);
		contentPane.add(btnCalculate);
		
	}
}
