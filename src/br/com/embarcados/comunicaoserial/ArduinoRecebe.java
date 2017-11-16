package br.com.embarcados.comunicaoserial;

import javax.swing.JButton;

/**
 * @author klauder
 */
public class ArduinoRecebe {
	private ControlePorta arduino;

	/**
	 * Construtor da classe Arduino
	 */
	public ArduinoRecebe() {
		arduino = new ControlePorta("COM9", 9600); // Windows - porta e taxa de transmissão
		// arduino = new ControlePorta("/dev/ttyUSB0",9600);//Linux - porta e taxa de transmissão
	}
}