package control;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;

import prueba.ComponentMover;
import prueba.DragListener;
import util.Utiles;
import vista.FichaBlanca;
import vista.VentanaPrincipal;

public class ParaUI extends VentanaPrincipal {

	DragListener drag;
	
	public ParaUI() {
		drag = new DragListener(		getTableroUI());
		getTableroUI().setMouseAdapter(drag);
		getTableroUI().setMouseMotion(drag);
		getTableroUI().actualizarTablero();
	}
	
	MouseAdapter mouseAdapter = new MouseAdapter() {
		
		//Coordenada coordenadaDestino;	
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			JPanel panel = (JPanel) e.getSource();
			panel.setBackground(Color.YELLOW);
		System.out.println("ddd");
			
			//getTableroUI().actualizarTablero();
			
		}
	};
	
	MouseMotionAdapter mouseMotion = new MouseMotionAdapter() {
	       private  int X, Y;
	 
			public void mousePressed(MouseEvent e){
				if(e!=null) {
				JPanel panel = (JPanel) e.getSource();
				//Coordenada	coordenadaOrigen = Utiles.getCoordenada(panel.getName());
				  Component c =  panel.findComponentAt(e.getX(), e.getY());
		        Point parentLocation = c.getParent().getLocation();
		        X= parentLocation.x - e.getX();
		        Y = parentLocation.y - e.getY();
		        panel = (JPanel)c;
		        panel.setLocation(e.getX() + X, e.getY() + Y);

	getTableroUI().add(panel);
	getTableroUI().setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
				}
				
				//controller.getJuego().setCasillaMarcada(coordenadaOrigen);
			}
		@Override
		public void mouseDragged(MouseEvent e) {	
	
			JPanel panel = (JPanel) e.getSource();
		//	Coordenada	coordenadaDestino = Utiles.getCoordenada(panel.getName());
			panel.setVisible(true);
	        int x = e.getX() + X;
	        int xMax = getTableroUI().getWidth() - panel.getWidth();
	        x = Math.min(x, xMax);
	        x = Math.max(x, 0);

	        int y = e.getY() + Y;
	        int yMax = getTableroUI().getHeight() - panel.getHeight();
	        y = Math.min(y, yMax);
	        y = Math.max(y, 0);

	        panel.setLocation(x, y);
	    	getTableroUI().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}	


		public void mouseReleased(MouseEvent e) {
			JPanel panel = (JPanel) e.getSource();
			getTableroUI().setCursor(null);

		        if (panel == null) return;

		     //   panel.setVisible(false);
		        getTableroUI().remove(panel);
		        panel.setVisible(true);
		        int xMax = getTableroUI().getWidth() - panel.getWidth();
		        int x = Math.min(e.getX(), xMax);
		        x = Math.max(x, 0);
		        int yMax =getTableroUI().getHeight() - panel.getHeight();
		        int y = Math.min(e.getY(), yMax);
		        y = Math.max(y, 0);

		        Component c =  panel.findComponentAt(x, y);

		        if (c instanceof JPanel)
		        {
		            Container parent = c.getParent();
		            parent.remove(0);
		            parent.add( panel );
		            parent.validate();
		        }
		        else
		        {
		            Container parent = (Container)c;
		            parent.add( panel );
		            parent.validate();
		        }
		     
		    }
	};
	
}
