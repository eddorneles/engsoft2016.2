package dominio;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="operador_maquina")
public class OperadorMaquina {

	@OneToOne
	@JoinColumn(name="id_operador")
	private Operador operador;
	
	@OneToOne
	@JoinColumn(name="id_maquina")
	private Maquina maquina;

	public Operador getOperador() {
		return operador;
	}

	public void setOperador(Operador operador) {
		this.operador = operador;
	}

	public Maquina getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}
}
