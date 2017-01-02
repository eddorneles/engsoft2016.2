package view.usuario;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import mbeam.Compra;
import javafx.scene.control.Button;

public class PainelAlimentosControle {
	private Main main;
	@FXML
	private Button btnAdicionarSaldo;
	
	private double saldo;
	
	@FXML
	private Label lblSaldo;
	
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
		main.apresentaPainelAdicionarSaldo();
		if( this.main.getCompra() != null ){
			atualizaLabelSaldo();
		}
	}// END handleBtnAdicionarSaldo
	
	public void setMain( Main main ){
		this.main = main;
	}
	
	private void atualizaLabelSaldo(){
		Compra compra = this.main.getCompra();
		if( compra != null ){
			double saldo = compra.calculaSaldo();
			this.lblSaldo.setText( Double.toString( saldo ) + "0" );
		}else{
			this.lblSaldo.setText( "---" );
		}
	}// END atualizaLabelSaldo
	
	@FXML
	private void handleBtnCancelarCompra(){
		this.main.cancelaCompra();
		this.atualizaLabelSaldo();
	}
}
