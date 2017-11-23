package grafico;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
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
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.SwingUtilities;
import programacaodinamica.Ligacoes;
import programacaodinamica.ProgDina;
import programacaodinamica.No;
import util.FiltroImagem;
import util.PrevisualizacaoImagem;
import util.VisuaizarImagemArquivo;


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
public class TelaInicial extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JPanel PanelD1;
	private Canvas Display1;
	private JButton abrirMapa;
	private JLabel jLabelPosicao;
	private JButton jButtonAresta;
	private JButton jButtonVertice;
	private JButton jButtonPontoIniFin;
	private JButton	jButtonLimpar;
	private JPanel jPanelText;
	private JPanel PanelControle1;
	private JButton jButtonProcurarCaminho;
	private JTextField jTextField1;
	private BufferedImage imagem;
	private BufferedImage imagemInicial;
	private double escala=3;
	private int modoAtual=0;
	private Double posX;
	private Double posY;
	private Double antigaPosX=0.0;
	private Double antigaPosY=0.0;	
	final JFileChooser abrirArquivo = new JFileChooser();
	private Vertice vertice;
	private Vertices vertices;
	private Aresta aresta;
	private InicioFim inicioFim;
	private int contadorVerticeID=0;
	private int contadorArestaID=0;
	private ProgDina programacaoDinamica = new ProgDina();
	
	
	

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TelaInicial inst = new TelaInicial();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public TelaInicial() {
		super();
		initGUI();
		vertices = new Vertices();
		inicioFim = new InicioFim();
		iniciar();
	}
	
	private void initGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setBackground(new java.awt.Color(206,206,225));
			{
				PanelControle1 = new JPanel();
				AnchorLayout PanelControle1Layout = new AnchorLayout();
				PanelControle1.setLayout(PanelControle1Layout);
				getContentPane().add(PanelControle1, new AnchorConstraint(6, 193, 1000, 3, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				PanelControle1.setPreferredSize(new java.awt.Dimension(149, 559));
				PanelControle1.setBackground(new java.awt.Color(163,167,203));
				PanelControle1.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				{
					jButtonLimpar = new JButton();
					PanelControle1.add(jButtonLimpar, new AnchorConstraint(927, 949, 982, 43, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jButtonLimpar.setText("Limpar");
					jButtonLimpar.setPreferredSize(new java.awt.Dimension(135, 30));
					jButtonLimpar.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							imagemInicial.copyData(imagem.getRaster());
							inicioFim = new InicioFim();
							paintZoom(Display1.getGraphics(),escala);							
						}
					});
				}
				{
					jPanelText = new JPanel();
					PanelControle1.add(jPanelText, new AnchorConstraint(267, 949, 458, 43, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jPanelText.setPreferredSize(new java.awt.Dimension(135, 106));
					jPanelText.setBackground(new java.awt.Color(163,167,203));
					jPanelText.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					{
						jButtonPontoIniFin = new JButton();
						jPanelText.add(jButtonPontoIniFin);
						jButtonPontoIniFin.setText("Início / Fim");
						jButtonPontoIniFin.setPreferredSize(new java.awt.Dimension(123, 28));
						jButtonPontoIniFin.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								jButtonPontoIniFin.setBackground(new Color(255,127,10));
								jButtonVertice.setBackground(new Color(212,208,200));
								jButtonAresta.setBackground(new Color(212,208,200));
								modoAtual = 1;
							}
						});
					}
					{
						jButtonVertice = new JButton();
						jPanelText.add(jButtonVertice);
						jButtonVertice.setText("Vértice");
						jButtonVertice.setPreferredSize(new java.awt.Dimension(123, 28));
						jButtonVertice.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								jButtonVertice.setBackground(new Color(255,127,10));
								jButtonPontoIniFin.setBackground(new Color(212,208,200));
								jButtonAresta.setBackground(new Color(212,208,200));
								modoAtual = 2;
							}
						});
					}
					{
						jButtonAresta = new JButton();
						jPanelText.add(jButtonAresta);
						jButtonAresta.setText("Aresta");
						jButtonAresta.setPreferredSize(new java.awt.Dimension(123, 28));
						jButtonAresta.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								jButtonAresta.setBackground(new Color(255,127,10));		
								jButtonPontoIniFin.setBackground(new Color(212,208,200));
								jButtonVertice.setBackground(new Color(212,208,200));
								modoAtual = 3;
							}
						});
					}
				}				
				{
					abrirMapa = new JButton();
					PanelControle1.add(abrirMapa, new AnchorConstraint(19, 949, 65, 50, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					abrirMapa.setText("Abrir Mapa");
					abrirMapa.setPreferredSize(new java.awt.Dimension(134, 25));
					abrirMapa.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
						painty(Display1.getGraphics());
					
						}
					});
					
				}
				{
					jTextField1 = new JTextField();
					PanelControle1.add(jTextField1, new AnchorConstraint(140, 949, 186, 43, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jTextField1.setPreferredSize(new java.awt.Dimension(135, 25));
				}
				{
					jButtonProcurarCaminho = new JButton();
					PanelControle1.add(jButtonProcurarCaminho, new AnchorConstraint(78, 949, 125, 50, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jButtonProcurarCaminho.setText("Procurar Caminho");
					jButtonProcurarCaminho.setPreferredSize(new java.awt.Dimension(134, 26));
					jButtonProcurarCaminho.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							programacaoDinamica.iniciarCalculos();
							//programacaoDinamica.melhorCaminho("0","2").imprimir();
							paintMostrarMelhor(Display1.getGraphics());
				
						}
					});
				}
				{
					jLabelPosicao = new JLabel();
					PanelControle1.add(jLabelPosicao, new AnchorConstraint(203, 949, 252, 43, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jLabelPosicao.setPreferredSize(new java.awt.Dimension(135, 27));
					jLabelPosicao.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
					jLabelPosicao.setHorizontalTextPosition(SwingConstants.CENTER);
					jLabelPosicao.setHorizontalAlignment(SwingConstants.CENTER);
					jLabelPosicao.setBackground(new java.awt.Color(128,128,128));
				}
			}
			{
				PanelD1 = new JPanel();
				getContentPane().add(PanelD1, new AnchorConstraint(6, 1000, 1000, 199, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				BorderLayout PanelD1Layout = new BorderLayout();
				PanelD1.setLayout(PanelD1Layout);
				PanelD1.setPreferredSize(new java.awt.Dimension(628, 559));
				{
						Display1 = new Canvas();
						PanelD1.add(Display1, BorderLayout.CENTER);
						//jScrollPane1.setViewportView(Display1);
						Display1.setBackground(new java.awt.Color(255,255,255));
						Display1.setSize(630, 551);
						Display1.setPreferredSize(new java.awt.Dimension(630, 551));
						Display1.addMouseWheelListener(new MouseWheelListener() {
							@Override
							public void mouseWheelMoved(MouseWheelEvent arg0) {
								// TODO Auto-generated method stub
								if(arg0.getWheelRotation()==-1){
									paintZoom(Display1.getGraphics(), escala=escala+0.1);
								}else{
									if( escala >= 0){
										Display1.paint(Display1.getGraphics());
										paintZoom(Display1.getGraphics(), escala=escala-0.1);
									}
								}
							}
						});
						Display1.addMouseMotionListener(new MouseMotionListener() {
							
							@Override
							public void mouseMoved(MouseEvent arg0) {
								// TODO Auto-generated method stub
								jLabelPosicao.setText(Double.toString(arg0.getX()/escala)+","+Double.toString(arg0.getY()/escala));
								posX = arg0.getX()/escala;
								posY = arg0.getY()/escala;
								if (modoAtual != 0){
									if (modoAtual == 1 || modoAtual == 2){
										Display1.setCursor(new Cursor(HAND_CURSOR));
									}else{
										Display1.setCursor(new Cursor(CROSSHAIR_CURSOR));
									}
								}else{
									Display1.setCursor(new Cursor(DEFAULT_CURSOR));
								}
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
								jLabelPosicao.setText(Integer.toString(arg0.getX())+","+Integer.toString(arg0.getY()));
								posX = arg0.getX()/escala;;
								posY = arg0.getY()/escala;
								if (modoAtual == 3 ){
									aresta = new Aresta(posX, posY, antigaPosX, antigaPosY, contadorArestaID);
									double[] arestaTemp = vertices.addArestaVertices(aresta);
									if(arestaTemp[2]!=-1 ){
										programacaoDinamica.adicionarLigacao(Integer.toString((int)arestaTemp[0]), Integer.toString((int)arestaTemp[1]), arestaTemp[2]);
										contadorArestaID++;
										paintInserirAresta(Display1.getGraphics());
									}
								}
							}
							
							@Override
							public void mousePressed(MouseEvent arg0) {
								// TODO Auto-generated method stub
								jLabelPosicao.setText(Integer.toString(arg0.getX())+","+Integer.toString(arg0.getY()));
								antigaPosX = arg0.getX()/escala;
								antigaPosY = arg0.getY()/escala;
								if(modoAtual == 1 && inicioFim.getCheio()== false){
									inicioFim.addVertice(posX, posY); 
									if(inicioFim.getCont()<2){
										imagem.copyData(imagemInicial.getRaster());
									}
									paintInserirIniFim(Display1.getGraphics());
								}else if(modoAtual == 2){
									vertice = new Vertice(posX, posY, contadorVerticeID);
									programacaoDinamica.adicionarNo(Integer.toString(contadorVerticeID));
									contadorVerticeID++;
									vertices.addVertices(vertice);
									paintInserirIniFim(Display1.getGraphics());	
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
			}
			pack();
			this.setSize(800, 600);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	public void painty(Graphics g){
		Graphics2D g2d = (Graphics2D) g.create();	
		g2d.scale(escala, escala);
		try {
			abrirArquivo.addChoosableFileFilter(new FiltroImagem());
			abrirArquivo.setAcceptAllFileFilterUsed(false);
			abrirArquivo.setFileView(new VisuaizarImagemArquivo());
			abrirArquivo.setAccessory(new PrevisualizacaoImagem(abrirArquivo));
	        int returnVal = abrirArquivo.showDialog(TelaInicial.this, "Abrir Arquivo");
			imagem = ImageIO.read(abrirArquivo.getSelectedFile());
			imagemInicial = ImageIO.read(abrirArquivo.getSelectedFile());; 
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int w = imagem.getWidth();
		int h = imagem.getHeight();
		int[] pixels = imagem.getRGB(0, 0, w, h, null, 0, w);

		int n=0;
		for (int c = 0; c < w; c++) {
			for (int l = 0; l < h; l++) {
			if (pixels[w * c + l]==-1){
			n++;
			}
			}
		}		    
		jTextField1.setText(Integer.toString(n));
		//		new Color(255,255,255).getRGB();
		imagem.setRGB(0, 0, w, h, pixels, 0, w);
		g2d.drawImage(imagem,0,0,null);
	}
	
	public void paintZoom(Graphics g,double v){
		Graphics2D g2d = (Graphics2D) g.create();	
		g2d.scale(escala, escala);
		g2d.drawImage(imagem,0,0,null);
	}
	public void paintMostrarMelhor(Graphics g){
		Graphics2D g2d = (Graphics2D) g.create();	
		Graphics2D g2dImagem = (Graphics2D) imagem.createGraphics();

		//Azul	
		g2dImagem.setColor(new Color(-12629813));
		g2dImagem.setStroke(new BasicStroke(3)); ;

		Ligacoes ligacoes;
		
		ligacoes = programacaoDinamica.melhorCaminho(Integer.toString(vertices.procuraVertices(inicioFim.getIniX(),inicioFim.getIniY())),Integer.toString(vertices.procuraVertices(inicioFim.getFimX(),inicioFim.getFimY())));
		ArrayList<double[]> coordenadas = new ArrayList<double[]>();
		Iterator<No> interador;
		interador = ligacoes.getLigacao().iterator();
		while(interador.hasNext()) {
			No noTemp = interador.next();
			double pos[] = new double[2];
			pos =  vertices.procuraVertice(Integer.parseInt(noTemp.getNo())).getXY();
			coordenadas.add(pos);
		}
		double tempPos[][] = new double[coordenadas.size()][4];
		for(int i =0;i<coordenadas.size();i++){
			for(int j =0;j<2;j++){
				tempPos[i][j] = coordenadas.get(i)[j];
			}
		}
		for(int i =0;i<coordenadas.size()-1;i++){
			for(int j =0;j<2;j++){
				tempPos[i][j+2] = coordenadas.get(i+1)[j];
			}
		}
		//Azul
		for(int i =0;i<coordenadas.size()-1;i++){
				g2dImagem.drawLine((int)tempPos[i][0], (int)tempPos[i][1], (int)tempPos[i][2], (int)tempPos[i][3]);
		}
		g2d.scale(escala, escala);
		g2d.drawImage(imagem,0,0,null);
	}

	public void paintInserirIniFim(Graphics g){
		int x = posX.intValue();
		int y = posY.intValue();
		Graphics2D g2d = (Graphics2D) g.create();
		Graphics2D g2dImagem = (Graphics2D) imagem.createGraphics();
		int tam = 10;
	if(modoAtual == 1 ){
		//Vermelho
		g2dImagem.setColor(new Color(-1237980));
		g2dImagem.setStroke(new BasicStroke(3)); ;
		g2dImagem.drawOval(x-(tam/2), y-(tam/2), 10, 10);
		imagem.setRGB(x, y, -1237980);
	}else{
		if(modoAtual == 2){
			//Verde
			g2dImagem.setColor(new Color(-14503604));
			g2dImagem.setStroke(new BasicStroke(3)); ;
			g2dImagem.drawOval(x-(tam/2), y-(tam/2), 10, 10);
			imagem.setRGB(x, y, -14503604);
		}
	}
		g2d.scale(escala, escala);
		g2d.drawImage(imagem,0,0,null);
	}
	public void paintInserirAresta(Graphics g){
		Graphics2D g2d = (Graphics2D) g.create();	
		Graphics2D g2dImagem = (Graphics2D) imagem.createGraphics();			
		int x = posX.intValue();
		int y = posY.intValue();
		int antigoX = antigaPosX.intValue();
		int antigoY = antigaPosY.intValue();
		//Laranja
		g2dImagem.setColor(new Color(-14066));
		g2dImagem.setStroke(new BasicStroke(3)); ;
		g2dImagem.drawLine(x, y, antigoX, antigoY);
		g2d.scale(escala, escala);
		g2d.drawImage(imagem,0,0,null);
	}

	private void iniciar(){
		try {
			
			imagem = ImageIO.read(new File("imagem.bmp"));
			imagemInicial = ImageIO.read(new File("imagem.bmp"));
//			imagem = ImageIO.read(new File("src/util/images/imagem.bmp"));
//			imagemInicial = ImageIO.read(new File("src/util/images/imagem.bmp"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}