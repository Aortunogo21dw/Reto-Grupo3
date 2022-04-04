import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;



public class Modificar_Datos extends JFrame {

	private JPanel contentPane;
	private JTextField matricula;
	private JTextField bastidor;
	private JTextField precio;
	private JTextField serie;
	private String url = "jdbc:mysql://localhost:3306/concesionario2";
	private String userName = "root";
	private String password = "root";
	private JTextField ColorText;
	private JTable table;
	private int z = 0;
	private Coche coche;
	private Camion camion;
	private JTextField Asientos;
	private JTextField CapacidadCarga;
	private JTextField Mercancia;
	private JTextField CapacidadMaletero;
	private JTextField Marca;
	private JTextField Modelo;
	private JTextField AnioFab;
	private JTextField NumPuertasT;
	private JTextField Fecha1;
	private JTextField Fecha2;
	private static String FILENAME = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modificar_Datos frame = new Modificar_Datos();
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
	public Modificar_Datos() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ik012982i9\\Desktop\\icons8-car-48.png"));
		setTitle("Gesti\u00F3n Compra-Venta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1410, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVolverMenu = new JButton("Volver al Men\u00FA Principal");
		btnVolverMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu_Principal pantalla1 = new Menu_Principal();
				pantalla1.setVisible(true);
				setVisible(false);
			}
		});
		btnVolverMenu.setBounds(604, 458, 218, 23);
		contentPane.add(btnVolverMenu);
		
		JLabel lblNewLabel_1_3 = new JLabel("Serie :");
		lblNewLabel_1_3.setBounds(54, 126, 150, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("Precio :");
		lblNewLabel_1_2.setBounds(54, 101, 150, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("N\u00FAmero de Bastidor :");
		lblNewLabel_1_1.setBounds(54, 76, 150, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Matr\u00EDcula veh\u00EDculo :");
		lblNewLabel_1.setBounds(54, 51, 150, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Aplicaci\u00F3n para gesti\u00F3n de veh\u00EDculos");
		lblNewLabel.setBounds(54, 7, 257, 23);
		contentPane.add(lblNewLabel);
		
		matricula = new JTextField();
		matricula.setEnabled(false);
		matricula.setColumns(10);
		matricula.setBounds(212, 48, 86, 20);
		contentPane.add(matricula);
		
		
		bastidor = new JTextField();
		bastidor.setEnabled(false);
		bastidor.setColumns(10);
		bastidor.setBounds(212, 73, 86, 20);
		contentPane.add(bastidor);
		
		precio = new JTextField();
		precio.setEnabled(false);
		precio.setColumns(10);
		precio.setBounds(212, 98, 86, 20);
		contentPane.add(precio);
		
		serie = new JTextField();
		serie.setEnabled(false);
		serie.setColumns(10);
		serie.setBounds(212, 123, 86, 20);
		contentPane.add(serie);
		
		
		
		JTextArea textArea = new JTextArea();
		textArea.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textArea.setEditable(false);
		textArea.setBounds(350, 32, 285, 266);
		contentPane.add(textArea);
		

		Asientos = new JTextField();
		Asientos.setEnabled(false);
		Asientos.setBounds(212, 173, 86, 20);
		contentPane.add(Asientos);
		Asientos.setColumns(10);
		
		CapacidadCarga = new JTextField();
		CapacidadCarga.setEnabled(false);
		CapacidadCarga.setBounds(212, 198, 86, 20);
		contentPane.add(CapacidadCarga);
		CapacidadCarga.setColumns(10);
		
		Mercancia = new JTextField();
		Mercancia.setEnabled(false);
		Mercancia.setBounds(212, 223, 86, 20);
		contentPane.add(Mercancia);
		Mercancia.setColumns(10);
		
		CapacidadMaletero = new JTextField();
		CapacidadMaletero.setEnabled(false);
		CapacidadMaletero.setBounds(212, 248, 86, 20);
		contentPane.add(CapacidadMaletero);
		CapacidadMaletero.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Marca :");
		lblNewLabel_8.setBounds(54, 276, 108, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_8_1 = new JLabel("Modelo :");
		lblNewLabel_8_1.setBounds(54, 302, 108, 14);
		contentPane.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_9 = new JLabel("A\u00F1o Fabricaci\u00F3n :");
		lblNewLabel_9.setBounds(54, 327, 150, 14);
		contentPane.add(lblNewLabel_9);
		
		Marca = new JTextField();
		Marca.setEnabled(false);
		Marca.setBounds(212, 273, 86, 20);
		contentPane.add(Marca);
		Marca.setColumns(10);
		
		Modelo = new JTextField();
		Modelo.setEnabled(false);
		Modelo.setBounds(212, 299, 86, 20);
		contentPane.add(Modelo);
		Modelo.setColumns(10);
		
		AnioFab = new JTextField();
		AnioFab.setEnabled(false);
		AnioFab.setBounds(212, 324, 86, 20);
		contentPane.add(AnioFab);
		AnioFab.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("NumPuertas :");
		lblNewLabel_3.setBounds(54, 352, 108, 14);
		contentPane.add(lblNewLabel_3);
		
		NumPuertasT = new JTextField();
		NumPuertasT.setEnabled(false);
		NumPuertasT.setBounds(212, 349, 86, 20);
		contentPane.add(NumPuertasT);
		NumPuertasT.setColumns(10);
		
		ColorText = new JTextField();
		ColorText.setEnabled(false);
		ColorText.setBounds(212, 148, 86, 20);
		contentPane.add(ColorText);
		ColorText.setColumns(10);
		
		JButton BotComprar = new JButton("Comprar"); 
		JCheckBox SelectCamion = new JCheckBox("Seleccionar Cami\u00F3n");
		JCheckBox SelecCoche = new JCheckBox("Seleccionar Coche");
		
		
		/**
		 * Guarda la selección introducida en los campos de datos en variables , para después utilizarlas en otras operaciones
		 * tiene un par de excepciones para por si acaso están los campos vacíos.
		 */
		
		
		JButton BotGuardar = new JButton("Guardar Selecci\u00F3n");
		BotGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (SelecCoche.isEnabled() == true) {
					coche =	new Coche(matricula.getText(),bastidor.getText(),Integer.parseInt(precio.getText()),serie.getText(),ColorText.getText(),Integer.parseInt(Asientos.getText()),Integer.parseInt(NumPuertasT.getText()),Integer.parseInt(CapacidadMaletero.getText()),AnioFab.getText(),Marca.getText(),Modelo.getText());
					textArea.setText("");
					textArea.append("Numero Matrícula : "+coche.getMat()+"\n"+"Numero Bastidor : "+coche.getNumBast()+"\n"+"Precio : "+coche.getPrecio()+ "\n" + "Serie : "+coche.getSerie()+ "\n"+"Color : "+coche.getColor()+"\n"+"Número Asientos : "+coche.getNumAsientos()+"\n"+"Número de Puertas : "+coche.getNumPuertas()+"\n"+"Capacidad maletero : "+coche.getCapacidadMaletero()+"\n"+"Año Fabricación : "+coche.getAniofab()+"\n"+"Marca : "+coche.getMarca()+"\n"+"Modelo : "+coche.getModelo());
					}else if(SelectCamion.isEnabled() == true) {
					camion = new Camion(matricula.getText(),bastidor.getText(),Integer.parseInt(precio.getText()),Integer.parseInt(serie.getText()),ColorText.getText(),Integer.parseInt(Asientos.getText()),Integer.parseInt(CapacidadCarga.getText()),Mercancia.getText(),AnioFab.getText(),Marca.getText(),Modelo.getText());	
					textArea.setText("");
					textArea.append("Numero Matrícula : "+camion.getMat()+"\n"+"Numero Bastidor : "+camion.getNumBast()+"\n"+"Precio : "+camion.getPrecio()+ "\n" + "Serie : "+camion.getSerie()+ "\n"+"Color : "+camion.getColor()+"\n"+"Número Asientos : "+camion.getNumAsientos()+"\n"+"Capacidad de carga : "+camion.getCapacidadCarga()+"\n"+"Tipo de carga : "+camion.getTipoCarga()+"\n"+"Año Fabricación : "+camion.getAnio_fab()+"\n"+"Marca : "+camion.getMarca()+"\n"+"Modelo : "+camion.getMarca());
					}
					
					 if(bastidor.getText().equals("") && serie.getText().equals("") && matricula.getText().equals("") && precio.getText().equals("")) {
							throw new Exception ("Error , no puedes dejar los campos vacíos");
						}
					
					
								
				if(precio.getText().equals("") == false) {
					
					
				}
				
				
				
				
				}
				
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),"Error",
							JOptionPane.ERROR_MESSAGE);		
							
				}
					
			}
		});
		
		
		
		
		BotGuardar.setBounds(361, 458, 218, 23);
		contentPane.add(BotGuardar);
		
		
		
		/**
		 * Borra un dato de la tabla de mysql , establece la conexion y después envía y ejecuta el comando
		 */
		
		
		
		JButton BotVender = new JButton("Vender");
		BotVender.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection conn = DriverManager.getConnection(url,userName,password);
					if(SelectCamion.isSelected() == true) {
					String sql = "delete from camion where Matricula = '"+camion.getMat()+"'" ; //Ejecuta comando en mysql
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.execute(sql);
					String sql2 = "delete from serie where numSerie = '"+camion.getSerie()+"'" ; //Ejecuta comando en mysql
					PreparedStatement ps2 = conn.prepareStatement(sql2);
					ps2.execute(sql2);
					conn.close();
					}else if(SelecCoche.isSelected() == true) {
					String sql = "delete from coche where Matricula = '"+coche.getMat()+"'" ; //Ejecuta comando en mysql
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.execute(sql);
					String sql2 = "delete from serie where numSerie = '"+coche.getSerie()+"'" ; //Ejecuta comando en mysql
					PreparedStatement ps2 = conn.prepareStatement(sql2);
					ps2.execute(sql2);
					conn.close();
					}
					
				
				
				} catch (SQLException e1) {
					// TODO Bloque catch generado automáticamente
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		
		
		
		
		BotVender.setBounds(350, 309, 89, 23);
		contentPane.add(BotVender);
		
		
		//Botón para modificar datos en mysql.
		
		JButton BotModificar = new JButton("Modificar");
		BotModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection conn = DriverManager.getConnection(url,userName,password);
					
					if(SelectCamion.isSelected() == true) {
						String sql = "update camion set matricula ='"+camion.getMat()+"' ,"+"numBastidor = '"+camion.getNumBast()+"' ,"+"precio = '"+camion.getPrecio()+"' ,"+"color ='"+camion.getColor()+"' ,"+"numAsientos = '"+camion.getNumAsientos()+"' ,"+"carga = '"+camion.getCapacidadCarga()+"',"+"tipoMercancia = '"+camion.getTipoCarga()+"'"+"where matricula ='"+camion.getMat()+"'"+";";
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.execute(sql);
						conn.close();
						
						
					}else if(SelecCoche.isSelected() == true) {
						String sql = "update coche set matricula ='"+coche.getMat()+"' ,"+"numBastidor = '"+coche.getNumBast()+"' ,"+"precio = '"+coche.getPrecio()+"' ,"+"color ='"+coche.getColor()+"' ,"+"numAsientos = '"+coche.getNumAsientos()+"' ,"+"numPuertas = '"+coche.getNumPuertas()+"',"+"capacidadMaletero = '"+coche.getCapacidadMaletero()+"'"+"where matricula ='"+coche.getMat()+"'"+";";
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.execute(sql);
						conn.close();
						
					}
					
					
					
					
				
				} catch (SQLException e1) {
					// TODO Bloque catch generado automáticamente
					e1.printStackTrace();
				}
				
				
				
				
				
			}
		});
		
		
		
		
		
		BotModificar.setBounds(449, 309, 89, 23);
		contentPane.add(BotModificar);
		
		JLabel lblNewLabel_2 = new JLabel("Opciones Seleccionadas");
		lblNewLabel_2.setBounds(429, 7, 150, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Color :");
		lblNewLabel_1_3_1.setBounds(54, 151, 156, 14);
		contentPane.add(lblNewLabel_1_3_1);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(680, 32, 704, 266);
		contentPane.add(scrollPane);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Se crea modelo para la tabla nueva.	
		DefaultTableModel model = new DefaultTableModel();
		
		
		
		
		//Se crea tabla nueva.
		table = new JTable();
		scrollPane.setViewportView(table);
		
		//Se establece modelo para la tabla.
		table.setModel(model);
		table.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), null));
		
		
		
		
		
		
		
		
		
		
		JButton BotActualizar = new JButton("Actualizar");
		BotActualizar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = DriverManager.getConnection(url,userName,password);
					z=0;
					if(SelecCoche.isEnabled() == true) {
					
					String sql = "select * from coche";
					String sql2 = "select * from serie";
					PreparedStatement ps = conn.prepareStatement(sql);
					PreparedStatement ps2 = conn.prepareStatement(sql2);
					ResultSet rs2 = ps2.executeQuery();
					ResultSet rs = ps.executeQuery();
					String Matricula = "";
					String NumBastidor = "";
					String Color = "";
					int Serie1 = 0;
					int numAsientos = 0;
					int numPuertas = 0;
					int capacidadMaletero = 0;
					int Precio1 = 0;
					String modelo = "";
					String marca = "";
					int anio_fab = 0;
					
					
					model.setRowCount(0);
					while(rs.next() && rs2.next()) {
						Matricula = rs.getString("matricula");
						NumBastidor = rs.getString("numBastidor");
						Color = rs.getString("Color");
						Serie1 = rs.getInt("numserie");
						Precio1 = rs.getInt("precio");
						numAsientos =rs.getInt("numAsientos");
						numPuertas =rs.getInt("numPuertas");
						capacidadMaletero =rs.getInt("capacidadMaletero");
						modelo = rs2.getString("modelo");
						marca = rs2.getString("marca");
						anio_fab = rs2.getInt("añoFabricacion");
						model.addRow(new Object[] {Matricula,NumBastidor,Color,Precio1,Serie1,numAsientos,numPuertas,capacidadMaletero,modelo,marca,anio_fab});
						
						
					
					}conn.close();
					
					}else if(SelectCamion.isEnabled() == true) {
						
						String sql2 = "select * from serie";
						String sql = "select * from camion";
						PreparedStatement ps = conn.prepareStatement(sql);
						PreparedStatement ps2 = conn.prepareStatement(sql2);
						ResultSet rs = ps.executeQuery();
						ResultSet rs2 = ps2.executeQuery();
						String Matricula = "";
						String NumBastidor = "";
						String Color = "";
						int Serie = 0;
						int Precio = 0;
						int numAsientos = 0;
						String TipoMercancia = "";
						int capacidadCarga = 0;
						String modelo = "";
						String marca = "";
						int anio_fab = 0;
						
						
						model.setRowCount(0);
						while(rs.next() && rs2.next()) {
							Matricula = rs.getString("Matricula");
							NumBastidor = rs.getString("NumBastidor");
							Color = rs.getString("Color");
							Serie= rs.getInt("numSerie");
							Precio = rs.getInt("Precio");
							numAsientos = rs.getInt("numAsientos");
							TipoMercancia = rs.getString("tipoMercancia");
							capacidadCarga = rs.getInt("carga");
							modelo = rs2.getString("modelo");
							marca = rs2.getString("marca");
							anio_fab = rs2.getInt("añoFabricacion");
							model.addRow(new Object[] {Matricula,NumBastidor,Color,Precio,Serie,numAsientos,capacidadCarga,TipoMercancia,modelo,marca,anio_fab});
							
						
						}conn.close();
						
						
					
					}
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
					JOptionPane.ERROR_MESSAGE);
					}
			}		
		});
		BotActualizar.setBounds(758, 309, 100, 23);
		contentPane.add(BotActualizar);
		
		
		
		
		
		
		
		JButton BotStock = new JButton("Mostrar veh\u00EDculos en stock");
		if(SelecCoche.isSelected() == false && SelectCamion.isSelected() == false ) {
			BotStock.setEnabled(false);
			BotGuardar.setEnabled(false);
			BotModificar.setEnabled(false);
			BotVender.setEnabled(false);
			BotComprar.setEnabled(false);
			
		}
		
		BotStock.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = DriverManager.getConnection(url,userName,password);
					
					if(SelecCoche.isEnabled() == true) {
					String sql = "select * from coche";
					String sql2 = "select * from serie";
					PreparedStatement ps = conn.prepareStatement(sql);
					PreparedStatement ps2 = conn.prepareStatement(sql2);
					ResultSet rs = ps.executeQuery();
					ResultSet rs2 = ps2.executeQuery();
					String Matricula = "";
					String NumBastidor = "";
					String Color = "";
					int Serie1 = 0;
					int numAsientos = 0;
					int numPuertas = 0;
					int capacidadMaletero = 0;
					int Precio1 = 0;
					String modelo = "";
					String marca = "";
					int anio_fab = 0;
					
					
					if(z<1) {
					model.setRowCount(0);
					while(rs.next() && rs2.next()) {
						Matricula = rs.getString("matricula");
						NumBastidor = rs.getString("numBastidor");
						Color = rs.getString("Color");
						Serie1 = rs.getInt("numserie");
						Precio1 = rs.getInt("precio");
						numAsientos =rs.getInt("numAsientos");
						numPuertas =rs.getInt("numPuertas");
						capacidadMaletero =rs.getInt("capacidadMaletero");
						modelo = rs2.getString("modelo");
						marca = rs2.getString("marca");
						anio_fab = rs2.getInt("añoFabricacion");
						model.addRow(new Object[] {Matricula,NumBastidor,Color,Precio1,Serie1,numAsientos,numPuertas,capacidadMaletero,modelo,marca,anio_fab});
						
					}z++;
					conn.close();}
					else {
						JOptionPane.showMessageDialog(null, "Ya se esán mostrando los vehículos en stock","Error",
						JOptionPane.ERROR_MESSAGE);	
					}}else if(SelectCamion.isEnabled() == true) {
						String sql = "select * from camion";
						String sql2 = "select * from serie";
						PreparedStatement ps = conn.prepareStatement(sql);
						PreparedStatement ps2 = conn.prepareStatement(sql2);
						ResultSet rs = ps.executeQuery();
						ResultSet rs2 = ps2.executeQuery();
						String Matricula = "";
						String NumBastidor = "";
						String Color = "";
						int Serie = 0;
						int Precio = 0;
						int numAsientos = 0;
						String TipoMercancia = "";
						int capacidadCarga = 0;
						String modelo = "";
						String marca = "";
						int anio_fab = 0;
						
						
						if(z<1) {
						model.setRowCount(0);
						while(rs.next() && rs2.next()) {
							Matricula = rs.getString("Matricula");
							NumBastidor = rs.getString("NumBastidor");
							Color = rs.getString("Color");
							Serie= rs.getInt("numSerie");
							Precio = rs.getInt("Precio");
							numAsientos = rs.getInt("numAsientos");
							TipoMercancia = rs.getString("tipoMercancia");
							capacidadCarga = rs.getInt("carga");
							modelo = rs2.getString("modelo");
							marca = rs2.getString("marca");
							anio_fab = rs2.getInt("añoFabricacion");
							model.addRow(new Object[] {Matricula,NumBastidor,Color,Precio,Serie,numAsientos,capacidadCarga,TipoMercancia,modelo,marca,anio_fab});
							
						}z++;
						conn.close();}
						else {
							JOptionPane.showMessageDialog(null, "Ya se esán mostrando los vehículos en stock","Error",
							JOptionPane.ERROR_MESSAGE);	
						}
						
						
						
						
					}
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
					JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		BotStock.setBounds(939, 309, 191, 23);
		contentPane.add(BotStock);
		
		JLabel lblNewLabel_2_1 = new JLabel("Veh\u00EDculos");
		lblNewLabel_2_1.setBounds(980, 11, 150, 14);
		contentPane.add(lblNewLabel_2_1);
		
		
		
		BotComprar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = DriverManager.getConnection(url,userName,password);
					
					if(SelectCamion.isSelected() == true) {
					String sql = "insert into camion values('"+camion.getNumBast()+"',"+"'"+camion.getCapacidadCarga()+"',"+"'"+camion.getTipoCarga()+"',"+"'"+camion.getMat()+"',"+"'"+camion.getColor()+"' ,"+"'"+camion.getNumAsientos()+"' ,"+"'"+camion.getPrecio()+"' ,"+"'"+camion.getSerie()+"');";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.execute(sql);
					sql ="insert into serie values("+camion.getSerie()+",'"+camion.getModelo()+"','"+camion.getMarca()+"',"+camion.getAnio_fab()+")";
					ps.execute(sql);
					
					conn.close();
					}else if(SelecCoche.isSelected() == true) {
					String sql = "insert into coche values('"+coche.getNumBast()+"',"+"'"+coche.getNumPuertas()+"',"+"'"+coche.getCapacidadMaletero()+"',"+"'"+coche.getMat()+"',"+"'"+coche.getColor()+"' ,"+"'"+coche.getNumAsientos()+"' ,"+"'"+coche.getPrecio()+"' ,"+"'"+coche.getSerie()+"')";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.execute(sql);
					sql ="insert into serie values("+coche.getSerie()+",'"+coche.getModelo()+"','"+coche.getMarca()+"',"+coche.getAniofab()+")";
					ps.execute(sql);
					conn.close();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		
		
		
		
		
		BotComprar.setBounds(546, 309, 89, 23);
		contentPane.add(BotComprar);
		
		JButton btnNewButton_7 = new JButton("Limpiar");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
			
		});
		btnNewButton_7.setBounds(449, 343, 89, 23);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Limpiar");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				z = 0;
			}
		});
		btnNewButton_8.setBounds(1212, 309, 89, 23);
		contentPane.add(btnNewButton_8);
		
		
		SelectCamion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (SelectCamion.isSelected() == true) {
					SelecCoche.setEnabled(false);
					NumPuertasT.setEnabled(false);
					CapacidadMaletero.setEnabled(false);
					matricula.setEnabled(true);
					bastidor.setEnabled(true);
					precio.setEnabled(true);
					serie.setEnabled(true);
					Asientos.setEnabled(true);
					CapacidadCarga.setEnabled(true);
					Mercancia.setEnabled(true);
					Marca.setEnabled(true);
					Modelo.setEnabled(true);
					AnioFab.setEnabled(true);
					ColorText.setEnabled(true);
					String[] columnNames = {"Matricula","Bastidor","Color","Precio","Serie","Asientos","Cap.Carga","Ti.Carga","Marca","Modelo","Año"};
					model.setColumnIdentifiers(columnNames);
					z=0;
					model.setRowCount(0);
					BotStock.setEnabled(true);
					BotGuardar.setEnabled(true);
					BotModificar.setEnabled(true);
					BotVender.setEnabled(true);
					BotComprar.setEnabled(true);
					NumPuertasT.setText("");
					CapacidadMaletero.setText("");
					matricula.setText("");
					bastidor.setText("");
					precio.setText("");
					serie.setText("");
					Asientos.setText("");
					CapacidadCarga.setText("");
					Mercancia.setText("");
					Marca.setText("");
					Modelo.setText("");
					AnioFab.setText("");
					ColorText.setText("");
					
					
					
					
				}else {
					SelecCoche.setEnabled(true);
					NumPuertasT.setEnabled(false);
					CapacidadMaletero.setEnabled(false);
					matricula.setEnabled(false);
					bastidor.setEnabled(false);
					precio.setEnabled(false);
					serie.setEnabled(false);
					Asientos.setEnabled(false);
					CapacidadCarga.setEnabled(false);
					Mercancia.setEnabled(false);
					Marca.setEnabled(false);
					Modelo.setEnabled(false);
					AnioFab.setEnabled(false);
					ColorText.setEnabled(false);
					BotStock.setEnabled(false);
					BotGuardar.setEnabled(false);
					BotModificar.setEnabled(false);
					BotVender.setEnabled(false);
					BotComprar.setEnabled(false);
				}
				
			}
		});
		
	
		SelecCoche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (SelecCoche.isSelected() == true) {
					SelectCamion.setEnabled(false);
					NumPuertasT.setEnabled(true);
					CapacidadMaletero.setEnabled(true);
					matricula.setEnabled(true);
					bastidor.setEnabled(true);
					precio.setEnabled(true);
					serie.setEnabled(true);
					Asientos.setEnabled(true);
					CapacidadCarga.setEnabled(false);
					Mercancia.setEnabled(false);
					Marca.setEnabled(true);
					Modelo.setEnabled(true);
					AnioFab.setEnabled(true);
					ColorText.setEnabled(true);
					z=0;
					String[] columnNames = {"Matricula","Bastidor","Color","Precio","Serie","Asientos","Puertas","Maletero","Marca","Modelo","Año"};
					model.setColumnIdentifiers(columnNames);
					model.setRowCount(0);
					BotStock.setEnabled(true);
					BotGuardar.setEnabled(true);
					BotModificar.setEnabled(true);
					BotVender.setEnabled(true);
					BotComprar.setEnabled(true);
					NumPuertasT.setText("");
					CapacidadMaletero.setText("");
					matricula.setText("");
					bastidor.setText("");
					precio.setText("");
					serie.setText("");
					Asientos.setText("");
					CapacidadCarga.setText("");
					Mercancia.setText("");
					Marca.setText("");
					Modelo.setText("");
					AnioFab.setText("");
					ColorText.setText("");
					
					
					
				}else {
					SelectCamion.setEnabled(true);
					NumPuertasT.setEnabled(false);
					CapacidadMaletero.setEnabled(false);
					matricula.setEnabled(false);
					bastidor.setEnabled(false);
					precio.setEnabled(false);
					serie.setEnabled(false);
					Asientos.setEnabled(false);
					CapacidadCarga.setEnabled(false);
					Mercancia.setEnabled(false);
					Marca.setEnabled(false);
					Modelo.setEnabled(false);
					AnioFab.setEnabled(false);
					ColorText.setEnabled(false);
					BotStock.setEnabled(false);
					BotGuardar.setEnabled(false);
					BotModificar.setEnabled(false);
					BotVender.setEnabled(false);
					BotComprar.setEnabled(false);
				}
			}
		});
		
		
		SelecCoche.setBounds(205, 458, 150, 23);
		contentPane.add(SelecCoche);
		
		
		SelectCamion.setBounds(54, 458, 149, 23);
		contentPane.add(SelectCamion);
		
		JLabel lblNewLabel_4 = new JLabel("N\u00FAmero Asientos :");
		lblNewLabel_4.setBounds(54, 176, 142, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Capacidad Carga :");
		lblNewLabel_5.setBounds(54, 201, 127, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Tipo Mercanc\u00EDa :");
		lblNewLabel_6.setBounds(54, 226, 142, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Capacidad Maletero :");
		lblNewLabel_7.setBounds(54, 251, 127, 14);
		contentPane.add(lblNewLabel_7);
		
		JButton BuscarVentas = new JButton("Buscar ventas");
		BuscarVentas.setEnabled(false);
		
		JCheckBox VentasFecha = new JCheckBox("Buscar ventas por fecha");
		
		
		
		
		VentasFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (VentasFecha.isSelected() == false) {
					BuscarVentas.setEnabled(false);
					Fecha1.setEnabled(false);
					Fecha2.setEnabled(false);
				}else if(VentasFecha.isSelected() == true) {
					String[] columnNames = {"id","Bastidor","matricula","color","Asientos","Serie","precio","fecha","tipocambio","tipovehículo"};
					model.setColumnIdentifiers(columnNames);
					BuscarVentas.setEnabled(true);
					Fecha1.setEnabled(true);
					Fecha2.setEnabled(true);
				}
			}
			
		});
		
		
		
		
		
		
		
		
		
		BuscarVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = DriverManager.getConnection(url,userName,password);
					String Fecha_1 = Fecha1.getText();
					String Fecha_2 = Fecha2.getText();
					
					String sql = "select * from historial where (fecha BETWEEN '"+Fecha_1+"' AND '"+Fecha_2+"') AND tipocambio = 'Vender'";
					
					PreparedStatement ps = conn.prepareStatement(sql);
					
					ResultSet rs = ps.executeQuery();
					int id = 0;
					String numBastidor = "";
					String matricula = "";
					String color = "";
					int numAsientos = 0;
					int numSerie = 0;
					double precio = 0;
					String fecha = "";
					String tipocambio = "";
					String tipovehículo = "";
					
					if(z<1) {
					model.setRowCount(0);
					while(rs.next()) {
						id = rs.getInt("id");
						numBastidor = rs.getString("numBastidor");
						matricula = rs.getString("matricula");
						color = rs.getString("color");
						numAsientos = rs.getInt("numAsientos");
						numSerie = rs.getInt("numSerie");
						precio = rs.getDouble("precio");
						fecha = rs.getString("fecha");
						tipocambio = rs.getString("tipocambio");
						tipovehículo = rs.getString("tipovehículo");
						model.addRow(new Object[] {id,numBastidor,matricula,color,numAsientos,numSerie,precio,fecha,tipocambio,tipovehículo});
						
					}z++;
					conn.close();}
					else {
						JOptionPane.showMessageDialog(null, "Ya se esán mostrando los vehículos en stock","Error",
						JOptionPane.ERROR_MESSAGE);	
					}
						
					
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
					JOptionPane.ERROR_MESSAGE);
					}
				
					
			}
		});
		
		
		
		
		BuscarVentas.setBounds(939, 348, 191, 23);
		contentPane.add(BuscarVentas);
		
		
		VentasFecha.setBounds(758, 348, 175, 23);
		contentPane.add(VentasFecha);
		
		Fecha1 = new JTextField();
		Fecha1.setBounds(1168, 349, 86, 20);
		contentPane.add(Fecha1);
		Fecha1.setColumns(10);
		
		Fecha2 = new JTextField();
		Fecha2.setColumns(10);
		Fecha2.setBounds(1298, 349, 86, 20);
		contentPane.add(Fecha2);
		
		JLabel lblNewLabel_10 = new JLabel("F2");
		lblNewLabel_10.setBounds(1264, 352, 24, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_10_1 = new JLabel("F1");
		lblNewLabel_10_1.setBounds(1140, 352, 18, 14);
		contentPane.add(lblNewLabel_10_1);
		
		Fecha1.setEnabled(false);
		Fecha2.setEnabled(false);
		
		JCheckBox Leercoch = new JCheckBox("Leer coche desde xml");
		JCheckBox Leercam = new JCheckBox("Leer camion desde xml");
		JButton BotLeerXML = new JButton("Leer");
		Leercoch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Leercoch.isSelected() == true) {
					Leercam.setEnabled(false);
					
				}else {
					Leercam.setEnabled(true);
				}
			}
		});
		Leercoch.setBounds(761, 394, 156, 23);
		contentPane.add(Leercoch);
		
		
		Leercam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Leercam.isSelected() == true) {
					Leercoch.setEnabled(false);
				}else {
					Leercoch.setEnabled(true);
				}
				
			}
		});
		Leercam.setBounds(939, 394, 142, 23);
		contentPane.add(Leercam);
		
	}
}
