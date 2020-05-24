package vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import prueba.DragListener;
import util.Utiles;


public class TableroUI extends JPanel {

	// Cada una de las casillas representadas en el tablero
	private JPanel[][] fichas; // usamos una matriz
	private DragListener mouseAdapter;

	DragListener mouseMotion;

	/**
	 * Create the panel.
	 */
	public TableroUI(int ancho, int alto) {
		super();
		
		// this.mouseAdapter = mouseAdapter;
		fichas = new JPanel[ancho][alto];
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new GridLayout(alto, ancho, 0,0));
		 
	//	setOpaque(true);
	//	setVisible(true);
		// actualizarTablero(tableroUIInfo);
	}

	
	
	public void actualizarTablero() { // se le añade el MouseListener y se agrega al PANEL
		removeAll();
		//FichaFactory[][] fichasInfo = tableroUIInfo.getFichasInfo();
		for (int i = 0; i < fichas.length; i++) {
			for (int j = 0; j < fichas[i].length; j++) {				
			fichas[i][j] = getFichaBlanca();
				fichas[i][j].setName(Utiles.nombrar(i, j));
				fichas[i][j].addMouseListener(mouseAdapter);
				fichas[i][j].getInsets();
				fichas[i][j].addMouseMotionListener(mouseMotion);
				add(fichas[i][j]);
			}
		
		}
		revalidate();
	}
	


	
	
	public JPanel getFichaBatallon() {
		return new FichaBatallon("", 1, 2,2,2,2,2,2,false,Color.blue);
	//	return new FichaBatallon(casillaInfo);
	}	
	
	
	public JPanel getFichaBlanca() {
		return new FichaBlanca();
	//	return new FichaBatallon(casillaInfo);
	}	
	
	
	public void setMouseAdapter(DragListener mouseAdapter) {
		this.mouseAdapter = mouseAdapter;
//	actualizarTablero(tableroUIInfo);
	}



	public void setMouseMotion(DragListener mouseMotion) {
		this.mouseMotion=mouseMotion;
		
	}

	
}
