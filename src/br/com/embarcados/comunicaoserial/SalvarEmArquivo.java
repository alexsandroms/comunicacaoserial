package br.com.embarcados.comunicaoserial;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SalvarEmArquivo {
	BufferedWriter escritor = null;

	public SalvarEmArquivo() throws IOException {
		Path path = Paths.get("dados.csv");
		Charset utf8 = StandardCharsets.UTF_8;
		escritor = Files.newBufferedWriter(path, utf8);
	}

	public void salvar(String msg) throws IOException {
		escritor.write(msg);
		escritor.flush();
	}
}
