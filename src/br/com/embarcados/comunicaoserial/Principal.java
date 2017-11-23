package br.com.embarcados.comunicaoserial;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.WindowConstants;

import grafico.Aresta;
import grafico.TelaInicial;
import grafico.Vertice;
import util.FiltroImagem;
import util.PrevisualizacaoImagem;
import util.VisuaizarImagemArquivo;

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
	private BufferedImage imagem;
	private BufferedImage imagemInicial;
	private int posX;
	private int posY;
	private int offSetX = 20;
	private int offSetY = 20;
	private int antigaPosX;
	private int antigaPosY;	
	final JFileChooser abrirArquivo = new JFileChooser();

	double[] listDeValores = { 5.1, 5.1, 5.1, 5.1, 5.1, 5.1, 5.09, 5.1, 5.1, 5.1, 5.1, 4.62, 4.62, 4.62, 5.1, 5.1, 5.1,
			5.16, 5.16, 5.32, 5.1, 5.38, 6.03, 6.19, 5.81, 5.81, 5.79, 5.81, 5.79, 5.81, 5.96, 6.24, 6.95, 6.73, 7.42,
			7.28, 7.93, 8.13, 8.29, 8.36, 8.42, 8.45, 8.13, 8.85, 9.12, 9.38, 9.59, 9.81, 9.97, 10.21, 9.92, 10.63,
			10.79, 10.95, 11.24, 11.55, 11.82, 11.71, 11.98, 12.69, 12.92, 13.61, 13.41, 14.1, 14.86, 14.7, 15.02,
			14.84, 14.7, 14.95, 15.22, 15.51, 15.84, 16.63, 17.01, 18.81, 19.68, 19.19, 19.57, 19.89, 20.65, 20.91,
			21.74, 21.63, 21.9, 21.3, 21.63, 21.88, 22.26, 21.74, 22.06, 24.33, 24.35, 24.82, 24.82, 24.83, 26.23, 26.9,
			26.08, 26.17, 23.49, 23.04, 24.38, 29.16, 30.17, 25.05, 28.07, 26.55, 28.4, 27.59, 27.04, 26.99, 27.42,
			27.8, 28.18, 29.05, 29.97, 31.37, 33.18, 37.61, 39.41, 38.45, 57.72, 58.65, 35.01, 34.05, 34.36, 34.64,
			34.84, 37.25, 39.59, 38.77, 39.69, 38.83, 39.31, 39.8, 39.84, 39.8, 39.73};

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.PlasticXPLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7599283594097900415L;
	private JButton jButtonSair;
	private Canvas Display1;

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
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);
			{
				Display1 = new Canvas();
				getContentPane().add(Display1, BorderLayout.CENTER);
				Display1.addMouseMotionListener(new MouseMotionListener() {
					@Override
					public void mouseMoved(MouseEvent arg0) {
						// TODO Auto-generated method stub
						posX = arg0.getX();
						posY = arg0.getY();
						Display1.setCursor(new Cursor(HAND_CURSOR));
					}
					
					@Override
					public void mouseDragged(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				});
				
				Display1.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						posX = arg0.getX();
						posY = arg0.getY();
					}
					
					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						antigaPosX = arg0.getX();
						antigaPosY = arg0.getY();
//						imagem.copyData(imagemInicial.getRaster());
//						paintInserirIniFim(Display1.getGraphics());
						for (int i = 0; i < 10000; i++) {
							
							painty(Display1.getGraphics());
						}
					}
					
					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				});

				
				
			}
			{
				jButtonSair = new JButton();
				getContentPane().add(jButtonSair, BorderLayout.EAST);
				jButtonSair.setText("Sair");
				jButtonSair.setActionCommand("Sair");
				jButtonSair.setBounds(596, 0, 31, 479);
				jButtonSair.setPreferredSize(new java.awt.Dimension(31, 479));
				jButtonSair.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						arduino.close();
					}
				});;
			}
			pack();
			this.setSize(650, 640);
			try {
//				abrirArquivo.addChoosableFileFilter(new FiltroImagem());
//				abrirArquivo.setAcceptAllFileFilterUsed(false);
//				abrirArquivo.setFileView(new VisuaizarImagemArquivo());
//				abrirArquivo.setAccessory(new PrevisualizacaoImagem(abrirArquivo));
//		        int returnVal = abrirArquivo.showDialog(Principal.this, "Abrir Arquivo");
//				imagem = ImageIO.read(abrirArquivo.getSelectedFile());
				imagem = ImageIO.read(new File("C:/Users/Master/Documents/imagem.bmp"));
				imagemInicial = ImageIO.read(new File("C:/Users/Master/Documents/imagem.bmp"));
//				imagem = ImageIO.read(abrirArquivo.getSelectedFile());

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for (int i = 0; i < listDeValores.length; i++) {//Dar um epaçamento
				listDeValores[i]=listDeValores[i]*10;
			}

		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	
	public void painty(Graphics g) {
		int x = posX;
		int y = posY;
		Graphics2D g2d = (Graphics2D) g.create();
		try {
			imagem = ImageIO.read(new File("C:/Users/Master/Documents/imagem.bmp"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Graphics2D g2dImagem = (Graphics2D) imagem.createGraphics(); // Usando para manipular a	imagem para	o redesenho

		int w = imagem.getWidth();
		int h = imagem.getHeight();
		int[] pixels = imagem.getRGB(0, 0, w, h, null, 0, w);
		int n = 0;
		for (int c = 0; c < w; c++) {
			for (int l = 0; l < h; l++) {
				if (pixels[w * c + l] == -1) {
					n++;
				}
			}
		}

		// new Color(255,255,255).getRGB();
		imagem.setRGB(0, 0, w, h, pixels, 0, w);
		imagem.setRGB(x, y, -1237980);
		g2dImagem.setColor(new Color(-1237980));
		g2dImagem.setStroke(new BasicStroke(1));
		
		g2dImagem.drawOval(x, y, 5, 5);
		for (int i = 0; i < listDeValores.length; i++) {
			g2dImagem.drawOval(offSetX+(i*2),600-(int)listDeValores[i]-offSetY, 5, 5);

		}
		for (int i = 1; i < listDeValores.length-1; i++) {//Suaviza
			listDeValores[i]=listDeValores[i]+((listDeValores[i-1]-listDeValores[i+1])/2);
		}

		g2dImagem.drawLine(570, 570, 10, 570);
		g2dImagem.drawLine(20, 20, 20, 580);

		g2d.scale(1, 1);
		g2d.drawImage(imagem, 0, 0, null);
	}


	
	
}
