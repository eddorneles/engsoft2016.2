package view.usuario;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;

public class PainelAlimentosControle {
	private Main main;
	@FXML
	private Button btnAdicionarSaldo;
	
	private double saldo;
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	/* 
	 * Método é automaticamente chamado após o arquivo 
	 * fxml ser carregado
	 * */
	@FXML
	private void initialize(){
		
	}
	
	@FXML
	private void handleBtnAdicionarSaldo(){
		main.apresentaPainelAdicionarSaldo( );
	}
	
	public void setMain( Main main ){
		this.main = main;
	}
}
