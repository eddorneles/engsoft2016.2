package dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="maquina")
public class Maquina {

	@Id
	@Column(name="id_maquina")
	private int id;
	
	@Column(name="cinquenta_centavo")
	private int cinCent;
	
	@Column(name="um_real")
	private int umReal;
	
	@Column(name="dois_real")
	private int doisReal;
	
	@Column(name="cinco_real")
	private int cincoReal;
	
	@Column(name="dez_real")
	private int dezReal;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
}