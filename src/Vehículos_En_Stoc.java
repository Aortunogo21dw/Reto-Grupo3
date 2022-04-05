import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import java.awt.Toolkit;

public class Vehículos_En_Stoc extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vehículos_En_Stoc frame = new Vehículos_En_Stoc();
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
	public Vehículos_En_Stoc() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ik012982i9\\Desktop\\icons8-car-48.png"));
		
		//Crear Conexion
		
		String url = "jdbc:mysql://localhost:3306/java_prueba";
		String userName = "root";
		String password = "root";
		
		
		
		setResizable(false);
		setTitle("Stock de Veh\u00EDculos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//Array para los nombres de las tablas
		String[] columnNames = {"Matricula","NumBastidor","Color","Precio","Serie"};
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 30, 781, 225);
		contentPane.add(scrollPane);
		
		
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(model);
		table.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), null));
		
		
		
		
		JButton btnNewButton_1 = new JButton("Volver al men\u00FA principal");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu_Principal pantalla2 = new Menu_Principal();
				pantalla2.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(23, 358, 181, 23);
		contentPane.add(btnNewButton_1);
		
		
		
		JButton btnNewButton = new JButton("Ver veh\u00EDculos en stock");
		btnNewButton.addActionListener(new ActionListener() {
			int i = 0;
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = DriverManager.getConnection(url,userName,password);
					String sql = "select * from tabla_prueba";
					PreparedStatement ps = conn.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					String Matricula = "";
					String NumBastidor = "";
					String Color = "";
					String Serie = "";
					int Precio = 0;
					
					if(i<1) {
					while(rs.next()) {
						Matricula = rs.getString("Matricula");
						NumBastidor = rs.getString("NumBastidor");
						Color = rs.getString("Color");
						Serie= rs.getString("Serie");
						Precio = rs.getInt("Precio");
						model.addRow(new Object[] {Matricula,NumBastidor,Color,Precio,Serie});
						
					}i++;}
					else {
					JOptionPane.showMessageDialog(null, "No puedes pulsar dos veces","Error",
					JOptionPane.ERROR_MESSAGE);		
					}
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
					JOptionPane.ERROR_MESSAGE);
					}
				
			}
		});
		btnNewButton.setBounds(288, 266, 190, 23);
		contentPane.add(btnNewButton);
	}
}
