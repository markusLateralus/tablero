package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
private TableroUI tableroUI;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		//setPreferredSize(getSize());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	    tableroUI=new TableroUI(12,6);
	 //  setGlassPane(tableroUI);
				contentPane.add(tableroUI, BorderLayout.CENTER);
				setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		tableroUI.setVisible(true);
			        setVisible(true);

	}


	public TableroUI getTableroUI() {
		return tableroUI;
	}
	

}
