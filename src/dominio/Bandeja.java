package dominio;


public class Bandeja {

	private int id;
	
	private TipoAlimento tipoAlimento;
	
	private Maquina maquina;
	
	private int numero;
	
	private Bandeja bandeja;
	
	public Bandeja getBandeja(){
		return bandeja;
	}
	
	public void setBandeja(Bandeja bandeja){
		this.bandeja = bandeja;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TipoAlimento getTipoAlimento() {
		return tipoAlimento;
	}
	public void setTipoAlimento(TipoAlimento tipoAlimento) {
		this.tipoAlimento = tipoAlimento;
	}
	public Maquina getMaquina() {
		return maquina;
	}
	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	
	
}
