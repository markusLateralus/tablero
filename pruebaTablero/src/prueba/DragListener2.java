package prueba;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import vista.TableroUI;

public class DragListener2 extends MouseInputAdapter
{
    Point location;
    MouseEvent pressed;
    TableroUI tableroUI;
    public DragListener2(TableroUI tableroUI) {
		// TODO Auto-generated constructor stub
    	this.tableroUI=tableroUI;
	}
 
    public void mousePressed(MouseEvent me)
    {
    	  pressed = me;
    		JPanel panel = (JPanel) me.getSource();
			panel.setBackground(Color.YELLOW);
    }
 
    public void mouseDragged(MouseEvent me)
    {
        Component component = me.getComponent();
    //    component.setVisible(true);
        location = component.getLocation(location);
        int x = location.x - pressed.getX() + me.getX();
        int y = location.y - pressed.getY() + me.getY();
        component.setLocation(x, y);
     //   tableroUI.remove(component);
        pressed = me;
     
     
     }
    public void mouseReleased(MouseEvent e) {
		JPanel panel = (JPanel) e.getSource();
		
		int    x = location.x - pressed.getX();
		int   y = location.y - pressed.getY() ;
        panel.setLocation(x, y);


	     
	    }
}
