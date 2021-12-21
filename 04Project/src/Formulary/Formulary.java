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
import javax.swing.JCheckBox;
import javax.swing.JButton;
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblValue = new JLabel("Inform the purchase value:");
		lblValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValue.setBounds(10, 11, 171, 27);
		contentPane.add(lblValue);
		
		txtValue = new JTextField();
		txtValue.setBounds(186, 16, 152, 20);
		contentPane.add(txtValue);
		txtValue.setColumns(10);
		
		JCheckBox ckbCashDown = new JCheckBox("Cash down");
		ckbCashDown.setBounds(10, 48, 99, 23);
		contentPane.add(ckbCashDown);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					// Get data:
					double value = Double.parseDouble(txtValue.getText());
					boolean cashDown = ckbCashDown.isSelected();
					
					// Conditional to check if there will be a discount of 5%
					if (value >= 100 && cashDown == true) {
						JOptionPane.showMessageDialog(null, "R$ "+value*0.95);
					}else {
						JOptionPane.showMessageDialog(null, "R$ "+value);
					}
					
					
				} catch(Exception error) {
					JOptionPane.showMessageDialog(null, "Inform the purchase value, plase.");
				}
				
			}
		});
		btnSend.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSend.setBounds(158, 93, 89, 23);
		contentPane.add(btnSend);
	}
}
