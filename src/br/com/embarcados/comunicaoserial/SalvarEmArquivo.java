package br.com.embarcados.comunicaoserial;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SalvarEmArquivo {
	static FileWriter arq = null;
	public static PrintWriter gravarArq = null;

	public SalvarEmArquivo()  {
		try {
			arq = new FileWriter("dados.csv");
			gravarArq = new PrintWriter(arq);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close()  {
		try {
			arq.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
