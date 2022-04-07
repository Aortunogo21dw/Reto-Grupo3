import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Instrucciones extends JFrame {
	ImageIcon icono = new ImageIcon("C:\\Users\\ik012982i9\\Desktop\\icons8-car-48.ico");
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Instrucciones frame = new Instrucciones();
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
	public Instrucciones() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ik012982i9\\Desktop\\icons8-car-48.png"));
		
		setBounds(100, 100, 519, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, -1, 503, 261);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		textArea.setText("Instrucciones para la utilización de la aplicación"+"\n"+"\n"+"Para introducir vehículos , el primer paso es seleccionar ya sea coche o camión"+"\n"+"Después hay que rellenar los campos correspondientes"+"\n"+"A continuación seleccionar la operación deseada"+"\n"+"Disclaimer : No dejar en blanco(Matricula , Numero de bastidor)"+"\n"+"No introducir misma matricula ni numero de bastidor si ya existe"+"\n"+"Si quieres ver el stock , tras seleccionar el tipo de vehículo haz click en el botón correspondiente"+"\n"+"Puedes filtrar tu búsqueda en color seleleccionando el tipo de vehículo e introduciendo el color"+"\n"+"Puedes filtrar tu búsqueda para sacar las ventas introduciendo dos fechas"+"\n"+"Para importar o exportar tus archivos XML antes debes de cambiar la ruta para que el programa lea donde tengas guardado el archivo");
		
		
		
	}
}
