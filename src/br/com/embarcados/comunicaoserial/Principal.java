package br.com.embarcados.comunicaoserial;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class Principal extends javax.swing.JFrame {
	private JButton jButtonLigar;
	private JButton jButtonSair;
	private JButton jButtonDesligar;
	private JTextField jTextFieldMensagem;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Principal inst = new Principal();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Principal() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		ArduinoEnvia arduino = new ArduinoEnvia();
		try {
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			{
				jButtonLigar = new JButton();
				getContentPane().add(jButtonLigar, BorderLayout.CENTER);
				jButtonLigar.setText("Ligar");
				jButtonLigar.setActionCommand("Ligar");
				jButtonLigar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						arduino.comunicacaoArduino(jButtonLigar);
					}
				});;
			}
			{
				jTextFieldMensagem = new JTextField();
				getContentPane().add(jTextFieldMensagem, BorderLayout.NORTH);
			}
			{
				jButtonDesligar = new JButton();
				getContentPane().add(jButtonDesligar, BorderLayout.WEST);
				jButtonDesligar.setText("Desligar");
				jButtonDesligar.setActionCommand("Desligar");
				jButtonDesligar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						arduino.comunicacaoArduino(jButtonDesligar);						
					}
				});;
			}
			{
				jButtonSair = new JButton();
				getContentPane().add(jButtonSair, BorderLayout.EAST);
				jButtonSair.setText("Sair");
				jButtonSair.setActionCommand("Sair");
				jButtonSair.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						arduino.comunicacaoArduino(jButtonSair);						
					}
				});;
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
