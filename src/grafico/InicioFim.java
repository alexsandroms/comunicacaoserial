package grafico;

import java.util.ArrayList;

public class InicioFim {
	private double IniX;
	private double IniY;
	private double FimX;
	private double FimY;
	private double distancia;
	private int contador = 0;
	private boolean cheio = false;

	
	public double getIniX() {
		return IniX;
	}
	
	public int getCont() {
		return contador;
	}
	public void addVertice(double x,double y) {
		if (contador == 0){
			this.IniX = x;
			this.IniY = y;
			contador++;
		}else{
			if (contador == 1){
				this.FimX = x;
				this.FimY = y;
				contador++;
				this.cheio = true;
			}
		}
	}

	public double getIniY() {
		return IniY;
	}

	public double getFimX() {
		return FimX;
	}

	public double getFimY() {
		return FimY;
	}

	public double getDistancia() {
		return distancia;
	}
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	public boolean getCheio() {
		return cheio;
	}
	

}
