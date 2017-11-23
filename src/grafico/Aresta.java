package grafico;

public class Aresta {
	private double x1;
	private double y1;
	private double x2;
	private double y2;
	private double tamanho;
	private double ID;
	public double getX1() {
		return x1;
	}
	public double getY1() {
		return y1;
	}
	public double getX2() {
		return x2;
	}
	public double getY2() {
		return y2;
	}
	public double getTamanho() {
		return tamanho;
	}
	public double getID() {
		return ID;
	}
	public Aresta(double x1, double y1, double x2, double y2, double iD) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.tamanho = Math.sqrt(Math.abs(((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1))));
		ID = iD;
	}
}
