package br.com.embarcados.comunicaoserial;
import javax.comm.*;
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NoSuchPortException, Exception  {
		// TODO Auto-generated method stub
		int timeout = 1000; // Tempo de espera.
		String tipoPorta = "COM1"; 
		CommPortIdentifier cp = CommPortIdentifier.getPortIdentifier(tipoPorta);
		SerialPort porta = (SerialPort)cp.open("titulo", timeout);
		// Captura a lista de portas disponíveis,
		// Pelo método estético em CommPortIdentifier.
		Enumeration pList = CommPortIdentifier.getPortIdentifiers();
		// Um mapping de nomes para CommPortIdentifiers.
		HashMap map = new HashMap();
		// Procura pela porta desejada
		while (pList.hasMoreElements()) {
			CommPortIdentifier cpi = (CommPortIdentifier) pList.nextElement();
			map.put(cpi.getName(), cpi);
			if (cpi.getPortType() == CommPortIdentifier.PORT_SERIAL) {
				// fazer alguma tarefa
			}
		}
	}

}
