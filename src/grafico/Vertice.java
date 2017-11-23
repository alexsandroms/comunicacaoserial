package grafico;


import java.util.ArrayList;

public class Vertice {
	private double x1;
	private double y1;
	private int ID;
	private ArrayList<Aresta> arestas;

	public Vertice(double x1, double y1, int ID) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.ID = ID;
		arestas = new ArrayList<Aresta>();
	}

	public ArrayList<Aresta> getArestas() {
		return arestas;
	}

	public void addAresta(Aresta aresta) {
		this.arestas.add(aresta);
	}
	
	public void apagarAresta(int indice) {
		this.arestas.remove(indice);
	}

	public double[] getXY() {
		double retorno[] = new double[2];
		retorno[0]= x1;
		retorno[1]= y1;
		return retorno;
	}
	
	public double getX1() {
		return x1;
	}

	public double getY1() {
		return y1;
	}

	public int getID() {
		return ID;
	}

}
