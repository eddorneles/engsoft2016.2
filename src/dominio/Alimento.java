package dominio;

import java.util.Date;


public class Alimento {

	private TipoAlimento tipoAlimento;
	
	private Maquina maquina;

	private Date dataCadastro;
	
	private Bandeja bandeja;

	private int quantidade;
	
	public int getQuantidade(){
		return quantidade;
	}
	
	public void setQuantidade(int quantidade){
		this.quantidade = quantidade;
	}
	
	

	public TipoAlimento getTipoAlimento() {
		return tipoAlimento;
	}

	public void setTipoAlimento(TipoAlimento tipoAlimento) {
		this.tipoAlimento = tipoAlimento;
	}



	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Bandeja getBandeja() {
		return bandeja;
	}

	public void setBandeja(Bandeja bandeja) {
		this.bandeja = bandeja;
	}
	
	public Maquina getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

}
