import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import java.awt.Toolkit;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Canvas;
import java.awt.ScrollPane;
import javax.swing.JTree;
import javax.swing.JPasswordField;

public class Menu_Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_Principal frame = new Menu_Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	/**
	 * Create the frame.
	 */
	
	public Menu_Principal() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ik012982i9\\Desktop\\icons8-car-48.png"));
		setTitle("Men\u00FA Principal");
		setBounds(100, 100, 817, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Aplicaci\u00F3n de gesti\u00F3n de veh\u00EDculos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(142, 11, 543, 83);
		contentPane.add(lblNewLabel);
		
		JButton btnGestionarCompraventa = new JButton("Iniciar");
		btnGestionarCompraventa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modificar_Datos pantalla1 = new Modificar_Datos();
				pantalla1.setVisible(true);
				setVisible(false);
			}
		});
		btnGestionarCompraventa.setBounds(296, 105, 192, 23);
		contentPane.add(btnGestionarCompraventa);
		
		JLabel lblNewLabel_2 = new JLabel("\u00A9 Grupo 3 (Dani , Sergio , Asier)");
		lblNewLabel_2.setBounds(10, 221, 186, 14);
		contentPane.add(lblNewLabel_2);
	}
}
