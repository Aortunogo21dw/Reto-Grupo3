
public class Camion {

	private String Mat;
	private String NumBast;
	private int Precio;
	private int Serie;
	private String color;
	private int numAsientos;
	private int capacidadCarga ;
	private String tipoCarga;
	private String anio_fab;
	private String marca;
	private String Modelo;
	
	public Camion(String mat , String numbast , int precio , int serie , String color , int numasientos , int capacidad , String tipocarga , String aniofab , String marca , String modelo) {
		this.Mat = mat;
		this.NumBast = numbast;
		this.Precio = precio;
		this.Serie = serie;
		this.color = color;
		this.numAsientos = numasientos;
		this.capacidadCarga = capacidad;
		this.tipoCarga=tipocarga;
		this.anio_fab=aniofab;
		this.marca=marca;
		this.Modelo=modelo;
		
	}

	public String getAnio_fab() {
		return anio_fab;
	}

	public void setAnio_fab(String anio_fab) {
		this.anio_fab = anio_fab;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		Modelo = modelo;
	}

	public String getMat() {
		return Mat;
	}

	public void setMat(String mat) {
		Mat = mat;
	}

	public String getNumBast() {
		return NumBast;
	}

	public void setNumBast(String numBast) {
		NumBast = numBast;
	}

	public int getPrecio() {
		return Precio;
	}

	public void setPrecio(int precio) {
		Precio = precio;
	}

	public int getSerie() {
		return Serie;
	}

	public void setSerie(int serie) {
		Serie = serie;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getNumAsientos() {
		return numAsientos;
	}

	public void setNumAsientos(int numAsientos) {
		this.numAsientos = numAsientos;
	}

	public int getCapacidadCarga() {
		return capacidadCarga;
	}

	public void setCapacidadCarga(int capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}

	public String getTipoCarga() {
		return tipoCarga;
	}

	public void setTipoCarga(String tipoCarga) {
		this.tipoCarga = tipoCarga;
	}
	
	
	
}
