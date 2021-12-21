package Formulary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class Formulary extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtHeight;
	private JTextField txtWeight;

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
		
		JLabel lblName = new JLabel("Type in the name of the person:");
		lblName.setBounds(10, 11, 197, 14);
		contentPane.add(lblName);
		
		JLabel lblHeight = new JLabel("Type in the height of the person:");
		lblHeight.setBounds(10, 92, 170, 14);
		contentPane.add(lblHeight);
		
		JLabel lblWeight = new JLabel("Type in the weight of the person:");
		lblWeight.setBounds(10, 175, 170, 14);
		contentPane.add(lblWeight);
		
		txtName = new JTextField();
		txtName.setBounds(10, 36, 82, 14);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtHeight = new JTextField();
		txtHeight.setBounds(10, 117, 88, 14);
		contentPane.add(txtHeight);
		txtHeight.setColumns(10);
		
		txtWeight = new JTextField();
		txtWeight.setBounds(10, 200, 88, 14);
		contentPane.add(txtWeight);
		txtWeight.setColumns(10);
		
		JButton btnCalculate = new JButton("Calculate BMI");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String name = txtName.getText();
					String text = "";
					double height = Double.parseDouble(txtHeight.getText());
					double weight = Double.parseDouble(txtWeight.getText());
					double outcome = weight/(height*height);
					DecimalFormat df = new DecimalFormat("0.##");
					String formattedOutcome = df.format(outcome);
					
			        if (outcome < 18.5){
			            text = "underweight!";
			        }else if (outcome >= 18.5 && outcome < 25){
			            text = "normal!";
			        }else if (outcome >= 25 && outcome < 30){
			            text = "overweight!";
			        }else if (outcome >= 30 && outcome < 35){
			            text = "obesity 1!";
			        }else if (outcome >= 35 && outcome < 40){
			            text = "obesity 2!";
			        }else{
			            text = "obesity 3!";
			        }
						
			        JOptionPane.showMessageDialog(null, "The BMI of "+name+" is "+formattedOutcome+" and this person's situation is "+text);
					
					
					
					
				}catch(Exception error) {
					JOptionPane.showMessageDialog(null, "Invalid value. Plese, try again!");
				}

			}
		});
		btnCalculate.setBounds(267, 229, 159, 23);
		contentPane.add(btnCalculate);
	}

}
