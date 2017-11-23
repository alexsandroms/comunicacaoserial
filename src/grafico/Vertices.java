package grafico;

import java.util.ArrayList;
import java.util.Iterator;

public class Vertices {
	private ArrayList<Vertice> vertices;
	int dist = 5;
	
	public Vertices() {
		super();
		vertices = new ArrayList<Vertice>();
	}

	public ArrayList<Vertice> getVertices() {
		return vertices;
	}
	
	public int procuraVertices(double x1, double y1) {
		int retorno = -1;

		Iterator<Vertice> interador;
		interador = this.vertices.iterator();
			while(interador.hasNext()) {
			    Vertice vertice = interador.next(); 
			    if(Math.sqrt(Math.abs((((vertice.getXY()[0]-x1)*(vertice.getXY()[0]-x1))+((vertice.getXY()[1]-y1)*(vertice.getXY()[1]-y1)))))<dist){
			    	retorno = vertice.getID();
			    }
			}
		return retorno;
	}

	public Vertice procuraVertice(int ID) {
		Vertice retorno = null;
		Iterator<Vertice> interador;
		interador = this.vertices.iterator();
			while(interador.hasNext()) {
			    Vertice vertice = interador.next(); 
			    if(vertice.getID() == ID){
			    	retorno = vertice;
			    }
			}
		return retorno;
	}
	
	public ArrayList<Aresta> procuraVerticesAresta(int ID) {
		ArrayList<Aresta> retorno = null;
		Iterator<Vertice> interador;
		interador = this.vertices.iterator();
			while(interador.hasNext()) {
			    Vertice vertice = interador.next(); 
			    if(vertice.getID() == ID){
			    	retorno = vertice.getArestas();
			    }
			}
		return retorno;
	}
	
	public void addVertices(Vertice vertice) {
		this.vertices.add(vertice);
	}
	
	public double[] addArestaVertices(Aresta aresta) {
		boolean existeX1Y1 = false;
		boolean existeX2Y2 = false;
		double[] retorno = new double[3];
		retorno[0]=-1;
		retorno[1]=-1;
		retorno[2]=-1;
		double x1,y1,x2,y2;
		x1 = aresta.getX1();
		x2 = aresta.getX2();
		y1 = aresta.getY1();
		y2 = aresta.getY2();
		Iterator<Vertice > interador;
		
		interador = this.vertices.iterator();
		while(interador.hasNext()) {
		    Vertice vertice = interador.next(); 
		    if(Math.sqrt(Math.abs((((vertice.getXY()[0]-x1)*(vertice.getXY()[0]-x1))+((vertice.getXY()[1]-y1)*(vertice.getXY()[1]-y1)))))<dist){
		    	System.out.println(Math.sqrt(Math.abs((((vertice.getXY()[0]-x1)*(vertice.getXY()[0]-x1))+((vertice.getXY()[1]-y1)*(vertice.getXY()[1]-y1))))));
		    	existeX1Y1 = true;
		    }
		}

		interador = this.vertices.iterator();
		while(interador.hasNext()) {
		    Vertice vertice = interador.next(); 
		    if(Math.sqrt(Math.abs((((vertice.getXY()[0]-x2)*(vertice.getXY()[0]-x2))+((vertice.getXY()[1]-y2)*(vertice.getXY()[1]-y2)))))<dist){
		    	System.out.println(Math.sqrt(Math.abs((((vertice.getXY()[0]-x2)*(vertice.getXY()[0]-x2))+((vertice.getXY()[1]-y2)*(vertice.getXY()[1]-y2))))));
		    	existeX2Y2 = true;
		    }
		} 
		
		if(existeX1Y1 && existeX2Y2){
			interador = this.vertices.iterator();
			while(interador.hasNext()) {
			    Vertice vertice = interador.next(); 
			    if(Math.sqrt(Math.abs((((vertice.getXY()[0]-x1)*(vertice.getXY()[0]-x1))+((vertice.getXY()[1]-y1)*(vertice.getXY()[1]-y1)))))<dist){
			    	System.out.println(Math.sqrt(Math.abs((((vertice.getXY()[0]-x1)*(vertice.getXY()[0]-x1))+((vertice.getXY()[1]-y1)*(vertice.getXY()[1]-y1))))));
			    	vertice.addAresta(aresta);
			    	retorno[0] = vertice.getID();
			    }
			}
			interador = this.vertices.iterator();
			while(interador.hasNext()) {
			    Vertice vertice = interador.next(); 
			    if(Math.sqrt(Math.abs((((vertice.getXY()[0]-x2)*(vertice.getXY()[0]-x2))+((vertice.getXY()[1]-y2)*(vertice.getXY()[1]-y2)))))<dist){
			    	System.out.println(Math.sqrt(Math.abs((((vertice.getXY()[0]-x2)*(vertice.getXY()[0]-x2))+((vertice.getXY()[1]-y2)*(vertice.getXY()[1]-y2))))));
			    	vertice.addAresta(aresta);
			    	retorno[1] = vertice.getID();
			    }
			}		
			retorno[2] = aresta.getTamanho();
		}
		return retorno;
	}
}
