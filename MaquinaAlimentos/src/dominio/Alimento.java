package dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
@Table(name="alimento")
public class Alimento {

	@Id
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_alimento")
	private TipoAlimento tipoAlimento;
	
	
	@ManyToOne
	@JoinColumn(name="id_maquina")
	private Maquina maquina;
	

	@Column(name="data_cadastro")
	private Date dataCadastro;
	
	private int bandeja;

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



	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public int getBandeja() {
		return bandeja;
	}

	public void setBandeja(int bandeja) {
		this.bandeja = bandeja;
	}
	
	public Maquina getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

}
