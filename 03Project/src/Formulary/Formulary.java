package Formulary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Formulary extends JFrame {

	private JPanel contentPane;
	private JTextField txtValue;

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
		setBounds(100, 100, 667, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblValue = new JLabel("Inform the value which will be converted:");
		lblValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValue.setBounds(40, 57, 329, 28);
		contentPane.add(lblValue);
		
		txtValue = new JTextField();
		txtValue.setBounds(379, 58, 264, 31);
		contentPane.add(txtValue);
		txtValue.setColumns(10);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					// Get data:
					double value = Double.parseDouble(txtValue.getText());
					int option = comboBox.getSelectedIndex();
					
					// Switch to select the option:
					switch(option) {
						case 1:
							JOptionPane.showMessageDialog(null, value * 5.5);
						break;	
						
						case 2:
							JOptionPane.showMessageDialog(null, value / 5.5);
						break;	
						
						case 3:
							JOptionPane.showMessageDialog(null, value * 6.5);
						break;
						
						case 4:
							JOptionPane.showMessageDialog(null, value / 6.5);
						break;
					}	
					
				}catch(Exception error) {}
			}
		});

		comboBox.addItem("Choose the type of conversion: ");
		comboBox.addItem("From Reais to Dollars");
		comboBox.addItem("From Dollars to Reais");
		comboBox.addItem("From Reais to Pounds");
		comboBox.addItem("From Pounds to Reais");
		comboBox.setBounds(379, 100, 264, 32);
		contentPane.add(comboBox);
	}
}
