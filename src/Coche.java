
public class Coche {
	private String Mat;
	private String NumBast;
	private int Precio;
	private String color;
	private int numAsientos;
	private int numPuertas;
	private int capacidadMaletero;
	private String aniofab;
	private String marca;
	private String Modelo;
	
	public Coche(String mat , String numbast , int precio ,  String color,int asientos , int puertas , int capmal,String aniofab,String marca,String Modelo) {
		this.Mat = mat;
		this.NumBast = numbast;
		this.Precio = precio;

		this.color = color;
		this.numAsientos = asientos;
		this.numPuertas = puertas;
		this.capacidadMaletero = capmal;
		this.marca = marca;
		this.Modelo=Modelo;
		this.aniofab=aniofab;
		
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

	public int getNumPuertas() {
		return numPuertas;
	}

	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}

	public int getCapacidadMaletero() {
		return capacidadMaletero;
	}

	public void setCapacidadMaletero(int capacidadMaletero) {
		this.capacidadMaletero = capacidadMaletero;
	}

	public String getAniofab() {
		return aniofab;
	}

	public void setAniofab(String aniofab) {
		this.aniofab = aniofab;
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

	
	
}
