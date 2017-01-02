package dominio;


public class Maquina {

	private int id;

	private int cinCent;

	private int umReal;

	private int doisReal;

	private int cincoReal;

	private int dezReal;
	
	private double dinheiroVendas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public double getDinheiroVendas(){
		return dinheiroVendas;
	}
	
	public void setDinheiroVendas( double dinheiroVendas){
		this.dinheiroVendas = dinheiroVendas;
	}

	public int getCinCent() {
		return cinCent;
	}

	public void setCinCent(int cinCent) {
		this.cinCent = cinCent;
	}

	public int getUmReal() {
		return umReal;
	}

	public void setUmReal(int umReal) {
		this.umReal = umReal;
	}

	public int getDoisReal() {
		return doisReal;
	}

	public void setDoisReal(int doisReal) {
		this.doisReal = doisReal;
	}

	public int getCincoReal() {
		return cincoReal;
	}

	public void setCincoReal(int cincoReal) {
		this.cincoReal = cincoReal;
	}

	public int getDezReal() {
		return dezReal;
	}

	public void setDezReal(int dezReal) {
		this.dezReal = dezReal;
	}
	
	public double calcularValorTotal(){
		double total = 0.5 * cinCent;
		total += umReal;
		total += doisReal * 2;
		total += cincoReal * 5;
		total += dezReal * 10;
		return total;
	}
	
}
