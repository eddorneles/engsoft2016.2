package dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="tipo_alimento")
public class TipoAlimento {

	@Id
	private int id;
	
	private String nome;
	
	@Column(name = "validade_dia")
	private int validadeDias;
	
	private double preco;

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getValidadeDias() {
		return validadeDias;
	}

	public void setValidadeDias(int validadeDias) {
		this.validadeDias = validadeDias;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}
