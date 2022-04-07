import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
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
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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
	private JTextField colorField;

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
		btnVolverMenu.setBounds(361, 424, 218, 23);
		contentPane.add(btnVolverMenu);
		
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
		
		
		
		JTextArea textArea = new JTextArea();
		textArea.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textArea.setEditable(false);
		textArea.setBounds(350, 32, 285, 266);
		contentPane.add(textArea);
		

		Asientos = new JTextField();
		Asientos.setEnabled(false);
		Asientos.setBounds(212, 147, 86, 20);
		contentPane.add(Asientos);
		Asientos.setColumns(10);
		
		CapacidadCarga = new JTextField();
		CapacidadCarga.setEnabled(false);
		CapacidadCarga.setBounds(212, 172, 86, 20);
		contentPane.add(CapacidadCarga);
		CapacidadCarga.setColumns(10);
		
		Mercancia = new JTextField();
		Mercancia.setEnabled(false);
		Mercancia.setBounds(212, 196, 86, 20);
		contentPane.add(Mercancia);
		Mercancia.setColumns(10);
		
		CapacidadMaletero = new JTextField();
		CapacidadMaletero.setEnabled(false);
		CapacidadMaletero.setBounds(212, 221, 86, 20);
		contentPane.add(CapacidadMaletero);
		CapacidadMaletero.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Marca :");
		lblNewLabel_8.setBounds(54, 249, 108, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_8_1 = new JLabel("Modelo :");
		lblNewLabel_8_1.setBounds(54, 273, 108, 14);
		contentPane.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_9 = new JLabel("A\u00F1o Fabricaci\u00F3n :");
		lblNewLabel_9.setBounds(54, 298, 150, 14);
		contentPane.add(lblNewLabel_9);
		
		Marca = new JTextField();
		Marca.setEnabled(false);
		Marca.setBounds(212, 246, 86, 20);
		contentPane.add(Marca);
		Marca.setColumns(10);
		
		Modelo = new JTextField();
		Modelo.setEnabled(false);
		Modelo.setBounds(212, 270, 86, 20);
		contentPane.add(Modelo);
		Modelo.setColumns(10);
		
		AnioFab = new JTextField();
		AnioFab.setEnabled(false);
		AnioFab.setBounds(212, 295, 86, 20);
		contentPane.add(AnioFab);
		AnioFab.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("NumPuertas :");
		lblNewLabel_3.setBounds(54, 325, 108, 14);
		contentPane.add(lblNewLabel_3);
		
		NumPuertasT = new JTextField();
		NumPuertasT.setEnabled(false);
		NumPuertasT.setBounds(212, 322, 86, 20);
		contentPane.add(NumPuertasT);
		NumPuertasT.setColumns(10);
		
		ColorText = new JTextField();
		ColorText.setEnabled(false);
		ColorText.setBounds(212, 123, 86, 20);
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
					
					if(precio.getText().equals("") | matricula.getText().equals("") | bastidor.getText().equals("") | Asientos.getText().equals("") | NumPuertasT.getText().equals("") | CapacidadMaletero.getText().equals("") | ColorText.getText().equals("") | AnioFab.getText().equals("") | Marca.getText().equals("") | Modelo.getText().equals("")) {
						throw new Exception("No se pueden dejar campos vacíos");
					}
					
					
					
					
					
					
					if (SelecCoche.isEnabled() == true) {
					coche =	new Coche(matricula.getText(),bastidor.getText(),Integer.parseInt(precio.getText()),ColorText.getText(),Integer.parseInt(Asientos.getText()),Integer.parseInt(NumPuertasT.getText()),Integer.parseInt(CapacidadMaletero.getText()),AnioFab.getText(),Marca.getText(),Modelo.getText());
					textArea.setText("");
					textArea.append("Numero Matrícula : "+coche.getMat()+"\n"+"Numero Bastidor : "+coche.getNumBast()+"\n"+"Precio : "+coche.getPrecio()+  "\n"+"Color : "+coche.getColor()+"\n"+"Número Asientos : "+coche.getNumAsientos()+"\n"+"Número de Puertas : "+coche.getNumPuertas()+"\n"+"Capacidad maletero : "+coche.getCapacidadMaletero()+"\n"+"Año Fabricación : "+coche.getAniofab()+"\n"+"Marca : "+coche.getMarca()+"\n"+"Modelo : "+coche.getModelo());
					}else if(SelectCamion.isEnabled() == true) {
					camion = new Camion(matricula.getText(),bastidor.getText(),Integer.parseInt(precio.getText()),ColorText.getText(),Integer.parseInt(Asientos.getText()),Integer.parseInt(CapacidadCarga.getText()),Mercancia.getText(),AnioFab.getText(),Marca.getText(),Modelo.getText());	
					textArea.setText("");
					textArea.append("Numero Matrícula : "+camion.getMat()+"\n"+"Numero Bastidor : "+camion.getNumBast()+"\n"+"Precio : "+camion.getPrecio()+ "\n" +"Color : "+camion.getColor()+"\n"+"Número Asientos : "+camion.getNumAsientos()+"\n"+"Capacidad de carga : "+camion.getCapacidadCarga()+"\n"+"Tipo de carga : "+camion.getTipoCarga()+"\n"+"Año Fabricación : "+camion.getAnio_fab()+"\n"+"Marca : "+camion.getMarca()+"\n"+"Modelo : "+camion.getMarca());
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
		 * Botón para vender coches , símplemente borra entradas de la base de datos , borra únicamente entrada de la tabla del vehículo correspondiente
		 * no borra entradas en serie por si acaso hay algún otro vehículo que la comparta;
		 */
	
		
		
		JButton BotVender = new JButton("Vender");
		BotVender.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection conn = DriverManager.getConnection(url,userName,password);
					if(SelectCamion.isSelected() == true) {
					String sql = "delete from camion where Matricula = '"+camion.getMat()+"'" ; 
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.execute(sql);
					
					conn.close();
					}else if(SelecCoche.isSelected() == true) {
					String sql = "delete from coche where Matricula = '"+coche.getMat()+"'" ; 
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
		
		
		
		
		BotVender.setBounds(350, 309, 89, 23);
		contentPane.add(BotVender);
		
		
		/**
		 * Modifica datos en la base de datos , puede cambiar cualquier dato excepto los de la tabla de serie.
		 */
		
		JButton BotModificar = new JButton("Modificar");
		BotModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection conn = DriverManager.getConnection(url,userName,password);
					
					if(SelectCamion.isSelected() == true) {
						String sql = "update camion set "+"precio = '"+camion.getPrecio()+"' ,"+"color ='"+camion.getColor()+"' ,"+"numAsientos = '"+camion.getNumAsientos()+"' ,"+"carga = '"+camion.getCapacidadCarga()+"',"+"tipoMercancia = '"+camion.getTipoCarga()+"'"+"where matricula ='"+camion.getMat()+"'"+";";
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.execute(sql);
						conn.close();
						
						
					}else if(SelecCoche.isSelected() == true) {
						String sql = "update coche set "+"precio = '"+coche.getPrecio()+"' ,"+"color ='"+coche.getColor()+"' ,"+"numAsientos = '"+coche.getNumAsientos()+"' ,"+"numPuertas = '"+coche.getNumPuertas()+"',"+"capacidadMaletero = '"+coche.getCapacidadMaletero()+"'"+"where matricula ='"+coche.getMat()+"'"+";";
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
		lblNewLabel_1_3_1.setBounds(54, 126, 156, 14);
		contentPane.add(lblNewLabel_1_3_1);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(680, 32, 704, 266);
		contentPane.add(scrollPane);
		
		
		

		
		DefaultTableModel model = new DefaultTableModel();
		
		
		
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		table.setModel(model);
		table.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), null));
		
		
		
		
		
		
		/**
		 * Botón para actualizar , cada vez que lo pulsas te saca si hay algún cambio en la tabla.
		 */
		
		
		
		JButton BotActualizar = new JButton("Actualizar");
		BotActualizar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = DriverManager.getConnection(url,userName,password);
					z=0;
					if(SelecCoche.isSelected() == true) {
					String sql = "select coche.*,serie.modelo,serie.marca,serie.añoFabricacion from coche inner join serie where coche.numSerie = serie.numSerie;";
					PreparedStatement ps = conn.prepareStatement(sql);
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
					while(rs.next()) {
						Matricula = rs.getString("matricula");
						NumBastidor = rs.getString("numBastidor");
						Color = rs.getString("Color");
						Serie1 = rs.getInt("numSerie");
						Precio1 = rs.getInt("precio");
						numAsientos =rs.getInt("numAsientos");
						numPuertas =rs.getInt("numPuertas");
						capacidadMaletero =rs.getInt("capacidadMaletero");
						modelo = rs.getString("modelo");
						marca = rs.getString("marca");
						anio_fab = rs.getInt("añoFabricacion");
						model.addRow(new Object[] {Matricula,NumBastidor,Color,Precio1,Serie1,numAsientos,numPuertas,capacidadMaletero,modelo,marca,anio_fab});
						
						
					
					}conn.close();
					
					}else if(SelectCamion.isSelected() == true) {
						
						String sql = "select camion.*,serie.modelo,serie.marca,serie.añoFabricacion from camion  inner join serie where camion.numSerie = serie.numSerie;";
						PreparedStatement ps = conn.prepareStatement(sql);
						ResultSet rs = ps.executeQuery();
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
						while(rs.next()) {
							Matricula = rs.getString("Matricula");
							NumBastidor = rs.getString("NumBastidor");
							Color = rs.getString("Color");
							Serie= rs.getInt("numSerie");
							Precio = rs.getInt("Precio");
							numAsientos = rs.getInt("numAsientos");
							TipoMercancia = rs.getString("tipoMercancia");
							capacidadCarga = rs.getInt("carga");
							modelo = rs.getString("modelo");
							marca = rs.getString("marca");
							anio_fab = rs.getInt("añoFabricacion");
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
		
		
		
		/**
		 * Muestra vehículos en stock , está activado solo cuando se selecciona una de las dos opciones , camion o coche. Muestra los vehículos en Stock , se reinicia con el botón limpiar;
		 */
	
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
					
					if(SelecCoche.isSelected() == true) {
					String sql = "select coche.*,serie.modelo,serie.marca,serie.añoFabricacion from coche inner join serie where coche.numSerie = serie.numSerie;";
					PreparedStatement ps = conn.prepareStatement(sql);
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
					
					
					if(z<1) {
					model.setRowCount(0);
					while(rs.next()) {
						Matricula = rs.getString("matricula");
						NumBastidor = rs.getString("numBastidor");
						Color = rs.getString("Color");
						Serie1 = rs.getInt("numSerie");
						Precio1 = rs.getInt("precio");
						numAsientos =rs.getInt("numAsientos");
						numPuertas =rs.getInt("numPuertas");
						capacidadMaletero =rs.getInt("capacidadMaletero");
						modelo = rs.getString("modelo");
						marca = rs.getString("marca");
						anio_fab = rs.getInt("añoFabricacion");
						model.addRow(new Object[] {Matricula,NumBastidor,Color,Precio1,Serie1,numAsientos,numPuertas,capacidadMaletero,modelo,marca,anio_fab});
						
					}z++;
					conn.close();}
					else {
						JOptionPane.showMessageDialog(null, "Ya se esán mostrando los vehículos en stock","Error",
						JOptionPane.ERROR_MESSAGE);	
						
					}}else if(SelectCamion.isSelected() == true) {
						String sql = "select camion.*,serie.modelo,serie.marca,serie.añoFabricacion from camion  inner join serie where camion.numSerie = serie.numSerie;";
						PreparedStatement ps = conn.prepareStatement(sql);
						ResultSet rs = ps.executeQuery();
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
						while(rs.next()) {
							Matricula = rs.getString("Matricula");
							NumBastidor = rs.getString("NumBastidor");
							Color = rs.getString("Color");
							Serie= rs.getInt("numSerie");
							Precio = rs.getInt("Precio");
							numAsientos = rs.getInt("numAsientos");
							TipoMercancia = rs.getString("tipoMercancia");
							capacidadCarga = rs.getInt("carga");
							modelo = rs.getString("modelo");
							marca = rs.getString("marca");
							anio_fab = rs.getInt("añoFabricacion");
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
		
		
		
		/**
		 * Botón para comprar , comprueba si existe la serie y si no asigna una nueva.
		 */
		
		BotComprar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				boolean existe = false;
				try {
					Connection conn = DriverManager.getConnection(url,userName,password);
					
					if(SelectCamion.isSelected() == true) {
					String sq2l = "SET FOREIGN_KEY_CHECKS=0";
					PreparedStatement ps2 = conn.prepareStatement(sq2l);
					ps2.execute(sq2l);
					
					String sql3 = "select * from serie";
					PreparedStatement ps3 = conn.prepareStatement(sql3);
					ResultSet rs = ps3.executeQuery();
					String modelotemp = "";
					String marcatemp = "";
					String aniotemp = "";
					int numSerieTemp = 0;
					
					while(rs.next()) {
						modelotemp = rs.getString("modelo");
						marcatemp = rs.getString("marca");
						aniotemp = rs.getString("añoFabricacion");
						if (camion.getModelo().equalsIgnoreCase(modelotemp) && camion.getMarca().equalsIgnoreCase(marcatemp) && camion.getAnio_fab().equalsIgnoreCase(aniotemp)) {
							existe = true;
							numSerieTemp = rs.getInt("numSerie");
							break;
						}else {
							existe = false;
						}
						
					}
					
					
					if(existe == false) {
						
					String sql ="insert into serie values(null,'"+camion.getModelo()+"','"+camion.getMarca()+"',"+camion.getAnio_fab()+")";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.execute(sql);
					sql3 = "select * from serie";
					ps3 = conn.prepareStatement(sql3);
					rs = ps3.executeQuery();
	
					while(rs.next()) {
						modelotemp = rs.getString("modelo");
						marcatemp = rs.getString("marca");
						aniotemp = rs.getString("añoFabricacion");
						if (camion.getModelo().equalsIgnoreCase(modelotemp) && camion.getMarca().equalsIgnoreCase(marcatemp) && camion.getAnio_fab().equalsIgnoreCase(aniotemp)) {

							numSerieTemp = rs.getInt("numSerie");
							break;
						}}
					
					sql = "insert into camion values('"+camion.getNumBast()+"',"+"'"+camion.getCapacidadCarga()+"',"+"'"+camion.getTipoCarga()+"',"+"'"+camion.getMat()+"',"+"'"+camion.getColor()+"' ,"+"'"+camion.getNumAsientos()+"' ,"+"'"+camion.getPrecio()+"','"+numSerieTemp+"');";
					ps.execute(sql);
					
					}else {
						
					String sql = "insert into camion values('"+camion.getNumBast()+"',"+"'"+camion.getCapacidadCarga()+"',"+"'"+camion.getTipoCarga()+"',"+"'"+camion.getMat()+"',"+"'"+camion.getColor()+"' ,"+"'"+camion.getNumAsientos()+"' ,"+"'"+camion.getPrecio()+"','"+numSerieTemp+"');";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.execute(sql);
						
						
					}
					
					
					conn.close();
					}
					
					
					
					else if(SelecCoche.isSelected() == true) {
						String sq2l = "SET FOREIGN_KEY_CHECKS=0";
						PreparedStatement ps2 = conn.prepareStatement(sq2l);
						ps2.execute(sq2l);
						
						String sql3 = "select * from serie";
						PreparedStatement ps3 = conn.prepareStatement(sql3);
						ResultSet rs = ps3.executeQuery();
						String modelotemp = "";
						String marcatemp = "";
						String aniotemp = "";
						int numSerieTemp = 0;
						
						while(rs.next()) {
							modelotemp = rs.getString("modelo");
							marcatemp = rs.getString("marca");
							aniotemp = rs.getString("añoFabricacion");
							if (coche.getModelo().equalsIgnoreCase(modelotemp) && coche.getMarca().equalsIgnoreCase(marcatemp) && coche.getAniofab().equalsIgnoreCase(aniotemp)) {
								existe = true;
								numSerieTemp = rs.getInt("numSerie");
								break;
							}else {
								existe = false;
							}
							
						}
						
						
							
						if(existe == false) {
							String sql ="insert into serie values(null,'"+coche.getModelo()+"','"+coche.getMarca()+"',"+coche.getAniofab()+")";
							PreparedStatement ps = conn.prepareStatement(sql);
							ps.execute(sql);
							sql3 = "select * from serie";
							ps3 = conn.prepareStatement(sql3);
							rs = ps3.executeQuery();
			
							while(rs.next()) {
								modelotemp = rs.getString("modelo");
								marcatemp = rs.getString("marca");
								aniotemp = rs.getString("añoFabricacion");
								if (coche.getModelo().equalsIgnoreCase(modelotemp) && coche.getMarca().equalsIgnoreCase(marcatemp) && coche.getAniofab().equalsIgnoreCase(aniotemp)) {

									numSerieTemp = rs.getInt("numSerie");
									break;
								}}
							
							sql = "insert into coche values('"+coche.getNumBast()+"',"+"'"+coche.getNumPuertas()+"',"+"'"+coche.getCapacidadMaletero()+"',"+"'"+coche.getMat()+"',"+"'"+coche.getColor()+"' ,"+"'"+coche.getNumAsientos()+"' ,"+"'"+coche.getPrecio()+"','"+numSerieTemp+"');";
							ps.execute(sql);
						
						}else {
							
						String sql = "insert into coche values('"+coche.getNumBast()+"',"+"'"+coche.getNumPuertas()+"',"+"'"+coche.getCapacidadMaletero()+"',"+"'"+coche.getMat()+"',"+"'"+coche.getColor()+"' ,"+"'"+coche.getNumAsientos()+"' ,"+"'"+coche.getPrecio()+"','"+numSerieTemp+"');";
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.execute(sql);
							
							
						}
						
						
						conn.close();
						}
						
						
						
						
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		
	
		
		
		BotComprar.setBounds(546, 309, 89, 23);
		contentPane.add(BotComprar);
		
		
		
		/**
		 * Uno de los múltiples botones para limpiar pantalla.
		 */
		
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
		
		
		SelecCoche.setBounds(193, 424, 150, 23);
		contentPane.add(SelecCoche);
		
		
		SelectCamion.setBounds(42, 424, 149, 23);
		contentPane.add(SelectCamion);
		
		JLabel lblNewLabel_4 = new JLabel("N\u00FAmero Asientos :");
		lblNewLabel_4.setBounds(54, 150, 142, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Capacidad Carga :");
		lblNewLabel_5.setBounds(54, 175, 127, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Tipo Mercanc\u00EDa :");
		lblNewLabel_6.setBounds(54, 199, 142, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Capacidad Maletero :");
		lblNewLabel_7.setBounds(54, 224, 127, 14);
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
					Fecha1.setText("");
					Fecha2.setText("");
				}else if(VentasFecha.isSelected() == true) {
					String[] columnNames = {"id","Bastidor","matricula","color","Asientos","Serie","precio","fecha","tipocambio","tipovehículo"};
					model.setColumnIdentifiers(columnNames);
					BuscarVentas.setEnabled(true);
					Fecha1.setEnabled(true);
					Fecha2.setEnabled(true);
				}
			}
			
		});
		
		
		
		
		
		
		
		/**
		 * Devuelve las ventas comprendidas entre dos fechas.
		 */
		
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
		
		
		
		
		BuscarVentas.setBounds(939, 394, 191, 23);
		contentPane.add(BuscarVentas);
		
		
		VentasFecha.setBounds(758, 394, 175, 23);
		contentPane.add(VentasFecha);
		
		Fecha1 = new JTextField();
		Fecha1.setBounds(1168, 395, 86, 20);
		contentPane.add(Fecha1);
		Fecha1.setColumns(10);
		
		Fecha2 = new JTextField();
		Fecha2.setColumns(10);
		Fecha2.setBounds(1298, 395, 86, 20);
		contentPane.add(Fecha2);
		
		JLabel lblNewLabel_10 = new JLabel("F2");
		lblNewLabel_10.setBounds(1264, 398, 24, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_10_1 = new JLabel("F1");
		lblNewLabel_10_1.setBounds(1140, 398, 18, 14);
		contentPane.add(lblNewLabel_10_1);
		
		Fecha1.setEnabled(false);
		Fecha2.setEnabled(false);
		JButton BotLeerXML = new JButton("Importar XML");
		
		
		
		
		
		
		
		BotLeerXML.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean existe = false;
				
			      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			    
			      try {
			    	  Connection conn = DriverManager.getConnection(url,userName,password);
			         
			          dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

			          
			          DocumentBuilder db = dbf.newDocumentBuilder();

			          Document doc = db.parse(new File("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/filevehiculos.xml"));

			      
			          doc.getDocumentElement().normalize();

			     
			          
			          NodeList list = doc.getElementsByTagName("coche");

			          for (int temp = 0; temp < list.getLength(); temp++) {

			              Node node = list.item(temp);

			              if (node.getNodeType() == Node.ELEMENT_NODE) {

			                  Element element = (Element) node;

			                 
			                  
			                  String NumBastidor = element.getElementsByTagName("numBastidor").item(0).getTextContent();
			                  String capacidadMaletero = element.getElementsByTagName("capacidadMaletero").item(0).getTextContent();
			                  String numPuertas = element.getElementsByTagName("numPuertas").item(0).getTextContent();
			                  String matricula = element.getElementsByTagName("matricula").item(0).getTextContent();
			                  String color = element.getElementsByTagName("color").item(0).getTextContent();
			                  String numAsientos = element.getElementsByTagName("numAsientos").item(0).getTextContent();
			                  String precio = element.getElementsByTagName("precio").item(0).getTextContent();
			                  String modelo = element.getElementsByTagName("modelo").item(0).getTextContent();
			                  String marca = element.getElementsByTagName("marca").item(0).getTextContent();
			                  String aniofab = element.getElementsByTagName("añoFabricacion").item(0).getTextContent();
			                  
			                  
			                  
			                  coche = new Coche(matricula,NumBastidor,Integer.parseInt(precio),color,Integer.parseInt(numAsientos),Integer.parseInt(numPuertas),Integer.parseInt(capacidadMaletero),aniofab,marca,modelo);
			                  String sq2l = "SET FOREIGN_KEY_CHECKS=0";
								PreparedStatement ps2 = conn.prepareStatement(sq2l);
								ps2.execute(sq2l);
								
								String sql3 = "select * from serie";
								PreparedStatement ps3 = conn.prepareStatement(sql3);
								ResultSet rs = ps3.executeQuery();
								String modelotemp = "";
								String marcatemp = "";
								String aniotemp = "";
								int numSerieTemp = 0;
								
								while(rs.next()) {
									modelotemp = rs.getString("modelo");
									marcatemp = rs.getString("marca");
									aniotemp = rs.getString("añoFabricacion");
									if (coche.getModelo().equalsIgnoreCase(modelotemp) && coche.getMarca().equalsIgnoreCase(marcatemp) && coche.getAniofab().equalsIgnoreCase(aniotemp)) {
										existe = true;
										numSerieTemp = rs.getInt("numSerie");
										break;
									}else {
										existe = false;
									}
									
								}
									
								if(existe == false) {
									String sql ="insert into serie values(null,'"+coche.getModelo()+"','"+coche.getMarca()+"',"+coche.getAniofab()+")";
									PreparedStatement ps = conn.prepareStatement(sql);
									ps.execute(sql);
									sql3 = "select * from serie";
									ps3 = conn.prepareStatement(sql3);
									rs = ps3.executeQuery();
					
									while(rs.next()) {
										modelotemp = rs.getString("modelo");
										marcatemp = rs.getString("marca");
										aniotemp = rs.getString("añoFabricacion");
										if (coche.getModelo().equalsIgnoreCase(modelotemp) && coche.getMarca().equalsIgnoreCase(marcatemp) && coche.getAniofab().equalsIgnoreCase(aniotemp)) {

											numSerieTemp = rs.getInt("numSerie");
											break;
										}}
									
									sql = "insert into coche values('"+coche.getNumBast()+"',"+"'"+coche.getNumPuertas()+"',"+"'"+coche.getCapacidadMaletero()+"',"+"'"+coche.getMat()+"',"+"'"+coche.getColor()+"' ,"+"'"+coche.getNumAsientos()+"' ,"+"'"+coche.getPrecio()+"','"+numSerieTemp+"');";
									ps.execute(sql);
								
								}else {
									
								String sql = "insert into coche values('"+coche.getNumBast()+"',"+"'"+coche.getNumPuertas()+"',"+"'"+coche.getCapacidadMaletero()+"',"+"'"+coche.getMat()+"',"+"'"+coche.getColor()+"' ,"+"'"+coche.getNumAsientos()+"' ,"+"'"+coche.getPrecio()+"','"+numSerieTemp+"');";
								PreparedStatement ps = conn.prepareStatement(sql);
								ps.execute(sql);
									
									
								}
  
			                  
			              }
			              
		 
			              
			          }
			          
			          
			          
			          
			          list = doc.getElementsByTagName("camion");

			          for (int temp = 0; temp < list.getLength(); temp++) {

			              Node node = list.item(temp);

			              if (node.getNodeType() == Node.ELEMENT_NODE) {

			                  Element element = (Element) node;

			                 
			                 
			                  String NumBastidor = element.getElementsByTagName("numBastidor").item(0).getTextContent();
			                  String carga = element.getElementsByTagName("carga").item(0).getTextContent();
			                  String TipoMercancia = element.getElementsByTagName("tipoMercancia").item(0).getTextContent();
			                  String matricula = element.getElementsByTagName("matricula").item(0).getTextContent();
			                  String color = element.getElementsByTagName("color").item(0).getTextContent();
			                  String numAsientos = element.getElementsByTagName("numAsientos").item(0).getTextContent();
			                  String precio = element.getElementsByTagName("precio").item(0).getTextContent();
			                  String modelo = element.getElementsByTagName("modelo").item(0).getTextContent();
			                  String marca = element.getElementsByTagName("marca").item(0).getTextContent();
			                  String aniofab = element.getElementsByTagName("añoFabricacion").item(0).getTextContent();
			                  
			                  
			                  camion = new Camion(matricula,NumBastidor,Integer.parseInt(precio),color,Integer.parseInt(numAsientos),Integer.parseInt(carga),TipoMercancia,aniofab,marca,modelo);
			                 
			                  
			                  String sq2l = "SET FOREIGN_KEY_CHECKS=0";
								PreparedStatement ps2 = conn.prepareStatement(sq2l);
								ps2.execute(sq2l);
								
								String sql3 = "select * from serie";
								PreparedStatement ps3 = conn.prepareStatement(sql3);
								ResultSet rs = ps3.executeQuery();
								String modelotemp = "";
								String marcatemp = "";
								String aniotemp = "";
								int numSerieTemp = 0;
								
								while(rs.next()) {
									modelotemp = rs.getString("modelo");
									marcatemp = rs.getString("marca");
									aniotemp = rs.getString("añoFabricacion");
									if (camion.getModelo().equalsIgnoreCase(modelotemp) && camion.getMarca().equalsIgnoreCase(marcatemp) && camion.getAnio_fab().equalsIgnoreCase(aniotemp)) {
										existe = true;
										numSerieTemp = rs.getInt("numSerie");
										break;
									}else {
										existe = false;
									}
									
								}
								
								
								if(existe == false) {
									
								String sql ="insert into serie values(null,'"+camion.getModelo()+"','"+camion.getMarca()+"',"+camion.getAnio_fab()+")";
								PreparedStatement ps = conn.prepareStatement(sql);
								ps.execute(sql);
								sql3 = "select * from serie";
								ps3 = conn.prepareStatement(sql3);
								rs = ps3.executeQuery();
				
								while(rs.next()) {
									modelotemp = rs.getString("modelo");
									marcatemp = rs.getString("marca");
									aniotemp = rs.getString("añoFabricacion");
									if (camion.getModelo().equalsIgnoreCase(modelotemp) && camion.getMarca().equalsIgnoreCase(marcatemp) && camion.getAnio_fab().equalsIgnoreCase(aniotemp)) {

										numSerieTemp = rs.getInt("numSerie");
										break;
									}}
								
								sql = "insert into camion values('"+camion.getNumBast()+"',"+"'"+camion.getCapacidadCarga()+"',"+"'"+camion.getTipoCarga()+"',"+"'"+camion.getMat()+"',"+"'"+camion.getColor()+"' ,"+"'"+camion.getNumAsientos()+"' ,"+"'"+camion.getPrecio()+"','"+numSerieTemp+"');";
								ps.execute(sql);
								
								}else {
									
								String sql = "insert into camion values('"+camion.getNumBast()+"',"+"'"+camion.getCapacidadCarga()+"',"+"'"+camion.getTipoCarga()+"',"+"'"+camion.getMat()+"',"+"'"+camion.getColor()+"' ,"+"'"+camion.getNumAsientos()+"' ,"+"'"+camion.getPrecio()+"','"+numSerieTemp+"');";
								PreparedStatement ps = conn.prepareStatement(sql);
								ps.execute(sql);
									
									
								}
			                 
			              }
			              
		  
			          }

			          conn.close();
			          
			          
			          

			      } catch (ParserConfigurationException | SAXException | IOException  | SQLException e1) {
			         e1.printStackTrace();
			      }
				

			}
		});
		
		
		
		
		BotLeerXML.setBounds(758, 458, 119, 23);
		contentPane.add(BotLeerXML);
		
		JButton btnNewButton = new JButton("Exportar XML Tabla");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Document doc = null;
				
				try {
					Connection conn = DriverManager.getConnection(url,userName,password);
					DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			      	String sql = "select coche.*,serie.modelo,serie.marca,serie.añoFabricacion from coche inner join serie where coche.numSerie = serie.numSerie;";
					PreparedStatement ps = conn.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					String Matricula = "";
					String NumBastidor = "";
					String Color = "";
					int numAsientos = 0;
					int numPuertas = 0;
					int capacidadMaletero = 0;
					int Precio1 = 0;
					String modelo = "";
					String marca = "";
					int anio_fab = 0;
					
					 doc = docBuilder.newDocument();
				      Element rootElement = doc.createElement("Vehiculos");
				      doc.appendChild(rootElement);
				
				  
					
					while(rs.next()) {
						Matricula = rs.getString("matricula");
						NumBastidor = rs.getString("numBastidor");
						Color = rs.getString("Color");
						Precio1 = rs.getInt("precio");
						numAsientos =rs.getInt("numAsientos");
						numPuertas =rs.getInt("numPuertas");
						capacidadMaletero =rs.getInt("capacidadMaletero");
						modelo = rs.getString("modelo");
						marca = rs.getString("marca");
						anio_fab = rs.getInt("añoFabricacion");
						
						  Element coche = doc.createElement("coche");
					      rootElement.appendChild(coche);
						

					      Element numBastidor1= doc.createElement("numBastidor");
					      numBastidor1.setTextContent(NumBastidor);
					      coche.appendChild(numBastidor1);
				
					      Element Matricula1 = doc.createElement("matricula");
					      Matricula1.setTextContent(Matricula);
					      coche.appendChild(Matricula1);
					      
					      Element Color1 = doc.createElement("color");
					      Color1.setTextContent(Color);
					      coche.appendChild(Color1);
					     
					      
					      Element numAsientos1 = doc.createElement("numAsientos");
					      numAsientos1.setTextContent(Integer.toString(numAsientos));
					      coche.appendChild(numAsientos1);
					      
					      Element numPuertas1 = doc.createElement("numPuertas");
					      numPuertas1.setTextContent(Integer.toString(numPuertas));
					      coche.appendChild(numPuertas1);
					      
					      
					      Element precio1 = doc.createElement("precio");
					      precio1.setTextContent(Integer.toString(Precio1));
					      coche.appendChild(precio1);
					      
					      
					      Element capacidadMaletero1 = doc.createElement("capacidadMaletero");
					      numPuertas1.setTextContent(Integer.toString(capacidadMaletero));
					      coche.appendChild(capacidadMaletero1);
				
					      Element tablaserie = doc.createElement("tablaserie");
					      coche.appendChild(tablaserie);
					      
					      Element modelo1 = doc.createElement("modelo");
					      modelo1.setTextContent(modelo);
					      tablaserie.appendChild(modelo1);
					      
					      Element marca1 = doc.createElement("marca");
					      marca1.setTextContent(marca);
					      tablaserie.appendChild(marca1);
					      
					      
					      Element aniofab = doc.createElement("anioFabricacion");
					      aniofab.setTextContent(Integer.toString(anio_fab));
					      tablaserie.appendChild(aniofab);
					      
					    	      
					      
					}
					
				
					conn = DriverManager.getConnection(url,userName,password);
					String sql2 = "select camion.*,serie.modelo,serie.marca,serie.añoFabricacion from camion  inner join serie where camion.numSerie = serie.numSerie;";
					PreparedStatement ps2 = conn.prepareStatement(sql2);
					ResultSet rs3 = ps2.executeQuery();
					String Matricula2 = "";
					String NumBastidor2 = "";
					String Color2 = "";
					int Precio2 = 0;
					int numAsientos2 = 0;
					String TipoMercancia2 = "";
					int capacidadCarga2 = 0;
					String modelo2 = "";
					String marca2 = "";
					int anio_fab2 = 0;
					
					
					while(rs3.next()) {
						Matricula2 = rs3.getString("Matricula");
						NumBastidor2= rs3.getString("NumBastidor");
						Color2 = rs3.getString("Color");
						Precio2 = rs3.getInt("Precio");
						numAsientos2 = rs3.getInt("numAsientos");
						TipoMercancia2 = rs3.getString("tipoMercancia");
						capacidadCarga2 = rs3.getInt("carga");
						modelo2 = rs3.getString("modelo");
						marca2 = rs3.getString("marca");
						anio_fab2 = rs3.getInt("añoFabricacion");
						
						
						
						 Element camion = doc.createElement("camion");
					      rootElement.appendChild(camion);
						

					      Element numBastidor1= doc.createElement("numBastidor");
					      numBastidor1.setTextContent(NumBastidor2);
					      camion.appendChild(numBastidor1);
				
					      Element Matricula1 = doc.createElement("matricula");
					      Matricula1.setTextContent(Matricula2);
					      camion.appendChild(Matricula1);
					      
					      Element Color1 = doc.createElement("color");
					      Color1.setTextContent(Color2);
					      camion.appendChild(Color1);
					      
					      Element numAsientos1 = doc.createElement("numAsientos");
					      numAsientos1.setTextContent(Integer.toString(numAsientos2));
					      camion.appendChild(numAsientos1);
					      
					      Element tipoMercancia = doc.createElement("tipoMercancia");
					      tipoMercancia.setTextContent(TipoMercancia2);
					      camion.appendChild(tipoMercancia);
					      
					      Element capacidadCarga = doc.createElement("capacidadCarga");
					      capacidadCarga.setTextContent(Integer.toString(capacidadCarga2));
					      camion.appendChild(capacidadCarga);
					      
					      
					      Element precio1 = doc.createElement("precio");
					      precio1.setTextContent(Integer.toString(Precio2));
					      camion.appendChild(precio1);
					      
				
					      Element tablaserie = doc.createElement("tablaserie");
					      camion.appendChild(tablaserie);
					      
					      Element modelo1 = doc.createElement("modelo");
					      modelo1.setTextContent(modelo2);
					      tablaserie.appendChild(modelo1);
					      
					      Element marca1 = doc.createElement("marca");
					      marca1.setTextContent(marca2);
					      tablaserie.appendChild(marca1);
					      
					      
					      Element aniofab = doc.createElement("anioFabricacion");
					      aniofab.setTextContent(Integer.toString(anio_fab2));
					      tablaserie.appendChild(aniofab);
					      
							
			
				}
					 
					  
					
					  

				
				}catch(ParserConfigurationException  | SQLException e4 ) {
						e4.printStackTrace();
					}
				
				
				
				 try (FileOutputStream output =
		                  new FileOutputStream("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\Prueba.xml")) { //C:\\Users\\ik012982i9\\Desktop\\Carpeta\\Reto-Grupo3\\prueba.xml <----- Ejemplo
					// escribirXML(doc,output); <------- Para que salga
					 escribirXML(doc, output);
		     } catch (IOException e8) {
		        e8.printStackTrace();
		     } catch (TransformerException e1) {
				// TODO Bloque catch generado automáticamente
				e1.printStackTrace();
			}
		
			}
		});
		
		
		
		
		
		btnNewButton.setBounds(1212, 458, 172, 23);
		contentPane.add(btnNewButton);
		
		
		
		
		/**
		 * Devuelven características de los vehículos dependiendo del color
		 */
		
		
		
		
		
		JCheckBox camionesColor = new JCheckBox("Mostrar Camiones por color");
		JCheckBox cochesColor = new JCheckBox("Mostrar coches por color");
		camionesColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(camionesColor.isSelected() == true) {
					cochesColor.setEnabled(false);
				}else {
					cochesColor.setEnabled(true);
				}
			}
		});
	
		cochesColor.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(cochesColor.isSelected() == true) {
					camionesColor.setEnabled(false);
				}else {
					camionesColor.setEnabled(true);
				}
			}
		});
		
		
		
		cochesColor.setBounds(758, 424, 175, 23);
		contentPane.add(cochesColor);
		
		
		
		camionesColor.setBounds(939, 424, 172, 23);
		contentPane.add(camionesColor);
		
		JButton mostrar = new JButton("Mostrar");
		mostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = DriverManager.getConnection(url,userName,password);
					
					if(cochesColor.isSelected() == true) {
			
					String sql = "call colorCoche('"+colorField.getText()+"')";
					
					PreparedStatement ps = conn.prepareStatement(sql);
					
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
					
					
					if(z<1) {
					model.setRowCount(0);
					while(rs.next() ) {
						Matricula = rs.getString("matricula");
						NumBastidor = rs.getString("numBastidor");
						Color = rs.getString("Color");
						Serie1 = rs.getInt("numSerie");
						Precio1 = rs.getInt("precio");
						numAsientos =rs.getInt("numAsientos");
						numPuertas =rs.getInt("numPuertas");
						capacidadMaletero =rs.getInt("capacidadMaletero");
						modelo = rs.getString("modelo");
						marca = rs.getString("marca");
						anio_fab = rs.getInt("añoFabricacion");
						model.addRow(new Object[] {Matricula,NumBastidor,Color,Precio1,Serie1,numAsientos,numPuertas,capacidadMaletero,modelo,marca,anio_fab});
						
					}z++;
					conn.close();}
					else {
						JOptionPane.showMessageDialog(null, "Ya se esán mostrando los vehículos en stock","Error",
						JOptionPane.ERROR_MESSAGE);	
					}}else if(camionesColor.isSelected() == true) {
						
						String sql ="call colorCamion('"+colorField.getText()+"')";
						
						PreparedStatement ps = conn.prepareStatement(sql);
						
						ResultSet rs = ps.executeQuery();
						
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
						while(rs.next() ) {
							Matricula = rs.getString("Matricula");
							NumBastidor = rs.getString("NumBastidor");
							Color = rs.getString("Color");
							Serie= rs.getInt("numSerie");
							Precio = rs.getInt("Precio");
							numAsientos = rs.getInt("numAsientos");
							TipoMercancia = rs.getString("tipoMercancia");
							capacidadCarga = rs.getInt("carga");
							modelo = rs.getString("modelo");
							marca = rs.getString("marca");
							anio_fab = rs.getInt("añoFabricacion");
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
		mostrar.setBounds(1222, 424, 89, 23);
		contentPane.add(mostrar);
		
		colorField = new JTextField();
		colorField.setBounds(1123, 425, 86, 20);
		contentPane.add(colorField);
		colorField.setColumns(10);
		
		JButton BotonInstrucciones = new JButton("Ver instrucciones");
		BotonInstrucciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Instrucciones pantalla1 = new Instrucciones();
				
				pantalla1.setVisible(true);
				
				
				
				
			}
		});
		BotonInstrucciones.setBounds(42, 458, 149, 23);
		contentPane.add(BotonInstrucciones);
		
		
		
	}
	

	  private static void escribirXML(Document doc,
	                               OutputStream output)
	          throws TransformerException {

	      TransformerFactory transformerFactory = TransformerFactory.newInstance();
	      Transformer transformer = transformerFactory.newTransformer();

	    
	      transformer.setOutputProperty(OutputKeys.INDENT, "yes");

	      DOMSource source = new DOMSource(doc);
	      StreamResult result = new StreamResult(output);

	      transformer.transform(source, result);

	  }
	
	
}

