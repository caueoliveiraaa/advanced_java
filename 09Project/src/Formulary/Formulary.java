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
	private JTextField txtValueReais;

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
		
		JLabel lblValueReais = new JLabel("Inform the value in Reais:");
		lblValueReais.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblValueReais.setBounds(10, 36, 392, 33);
		contentPane.add(lblValueReais);
		
		txtValueReais = new JTextField();
		txtValueReais.setBounds(10, 86, 200, 38);
		contentPane.add(txtValueReais);
		txtValueReais.setColumns(10);
		
		JButton btnNewButton = new JButton("Return the value in Bitcoin, Litecoin and Ethereum");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					// Get data:
					double valueReais = Double.parseDouble(txtValueReais.getText());
					
					// Display the values converted:
					JOptionPane.showMessageDialog(null, "The values in Reais converted to BItcoins is ("+(0.0000039 * valueReais)+")\nThe values in Reais converted to Litecoin is ("+(valueReais * 0.00094)+")\nThe values in Reais converted to Ethereum is ("+(valueReais * 0.000043)+")\n");

					
				}catch(Exception error) {
					JOptionPane.showMessageDialog(null, "Error: Invalid value. Please try again!");
				}
			}

		});
		btnNewButton.setBounds(10, 152, 378, 53);
		contentPane.add(btnNewButton);
	}

}
