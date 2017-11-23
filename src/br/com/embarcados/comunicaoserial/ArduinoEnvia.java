package br.com.embarcados.comunicaoserial;

import javax.swing.JButton;

/**
 * @author klauder
 */
public class ArduinoEnvia {
	private ControlePorta controlePorta;

	/**
	 * Construtor da classe Arduino
	 */
	public ArduinoEnvia() {
		controlePorta = new ControlePorta("COM9", 9600);// Windows - porta e taxa de transmissão
		// arduino = new ControlePorta("/dev/ttyUSB0",9600);//Linux - porta e taxa de transmissão
	}

	public void comunicacaoArduino(JButton button) {
		if ("Ligar".equals(button.getActionCommand())) {
			controlePorta.enviaDados("RDD\n");
			System.out.println(button.getText());// Imprime o nome do botão pressionado
		} 
		else {
			controlePorta.close();
			System.out.println(button.getText());// Imprime o nome do botão pressionado
		}
	}
	
	public void close() {
		controlePorta.close();
		System.exit(0);
	}

}