package view.usuario;

import javafx.scene.control.TextField;

import java.awt.Button;
import java.util.HashMap;
import java.util.Map;

import def.TipoDinheiro;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class PainelAdicionarSaldoControle {
	private Stage stageAdicionarSaldo;
	
	@FXML
	private TextField txtCinquentaCentavos;
	@FXML
	private Button btnReduzirCinquentaCentavos;
	@FXML
	private Button btnAdicionarCinquentaCentavos;
	@FXML
	private TextField txtUmReal;
	@FXML
	private Button btnReduzirUmReal;
	@FXML
	private Button btnAdicionarUmReal;
	@FXML
	private TextField txtDoisReal;
	@FXML
	private Button btnReduzirDoisReal;
	@FXML
	private Button btnAdicionarDoisReal;
	@FXML
	private TextField txtCincoReal;
	@FXML
	private Button btnReduzirCincoReal;
	@FXML
	private Button btnAdicionarCincoReal;
	@FXML
	private TextField txtDezReal;
	@FXML
	private Button btnReduzirDezReal;
	@FXML
	private Button btnAdicionarDezReal;
	
	private HashMap<TipoDinheiro,Integer> cedulasSaldo;
	
	private boolean btnInserirClicado = false;
	private boolean cancelarClicado = false;
	
	
	public void initialize(){
		txtCinquentaCentavos.setText( "0" );
		txtUmReal.setText( "0" );
		txtDoisReal.setText( "0" );
		txtCincoReal.setText( "0" );
		txtDezReal.setText( "0" );
	}
	
	public void setStageAdicionarSaldo( Stage stage ){
		this.stageAdicionarSaldo = stage;
	}
	
	public HashMap<TipoDinheiro, Integer> getCedulasSaldos(){
		return this.cedulasSaldo;
	}

	
	/* ***********************************************************************
	 * MÉTODOS PARA ADICIONAR OU REDUZIR NÚMERO DE CÉDULAS E MOEDAS 		*/
	public void handleBtnAdicionarCinquentaCentavos(){
		 
		int num = validaValorTextInteiro( txtCinquentaCentavos.getText() );
		num++;
		String novoValor = Integer.toString( num );
		txtCinquentaCentavos.setText( novoValor );
	}
	
	@FXML
	public void handleBtnReduzirCinquentaCentavos(){
		int num = validaValorTextInteiro( txtCinquentaCentavos.getText() );
		num--;
		if( num < 0){
			num = 0;
		}
		String novoValor = Integer.toString( num );
		txtCinquentaCentavos.setText( novoValor );
	}
	
	@FXML
	private void handleBtnAdicionarUmReal(){
		int num = validaValorTextInteiro( txtUmReal.getText() );
		num++;
		String novoValor = Integer.toString( num );
		txtUmReal.setText( novoValor );
	}
	
	@FXML
	public void handleBtnReduzirUmReal(){
		int num = validaValorTextInteiro( txtUmReal.getText() );
		num--;
		if( num < 0){
			num = 0;
		}
		String novoValor = Integer.toString( num );
		txtUmReal.setText( novoValor );
	}
	
	@FXML
	private void handleBtnAdicionarDoisReal(){
		int num = validaValorTextInteiro( txtDoisReal.getText() );
		num++;
		String novoValor = Integer.toString( num );
		txtDoisReal.setText( novoValor );
	}
	
	@FXML
	public void handleBtnReduzirDoisReal(){
		int num = validaValorTextInteiro( txtDoisReal.getText() );
		num--;
		if( num < 0){
			num = 0;
		}
		String novoValor = Integer.toString( num );
		txtDoisReal.setText( novoValor );
	}
	
	@FXML
	public void handleBtnReduzirCincoReal(){
		int num = validaValorTextInteiro( txtCincoReal.getText() );
		num--;
		if( num < 0){
			num = 0;
		}
		String novoValor = Integer.toString( num );
		txtCincoReal.setText( novoValor );
	}
	
	@FXML
	public void handleBtnReduzirDezReal(){
		int num = validaValorTextInteiro( txtDezReal.getText() );
		num--;
		if( num < 0){
			num = 0;
		}
		String novoValor = Integer.toString( num );
		txtDezReal.setText( novoValor );
	}
	
	@FXML
	private void handleBtnAdicionarCincoReal(){
		int num = validaValorTextInteiro( txtCincoReal.getText() );
		num++;
		String novoValor = Integer.toString( num );
		txtCincoReal.setText( novoValor );
	}
	
	@FXML
	private void handleBtnAdicionarDezReal(){
		int num = validaValorTextInteiro( txtDezReal.getText() );
		num++;
		String novoValor = Integer.toString( num );
		txtDezReal.setText( novoValor );
	}
	
	private int validaValorTextInteiro( String valor ){
		int num;
		try{
			num = Integer.parseInt( valor );
			if( num < 0 ){
				num = -1;
			}
		}catch( NumberFormatException e ){
			num = 0;
		}
		return num;
	}
	
	/* ********************************************************************************* */
	
	
	@FXML
	private void handleBtnInserir(){
		HashMap <TipoDinheiro, Integer> cedulasInseridas = new HashMap<TipoDinheiro, Integer>();
		cedulasInseridas.put( TipoDinheiro.CINQUENTA_CENTAVOS, Integer.parseInt( txtCinquentaCentavos.getText() ) );
		cedulasInseridas.put( TipoDinheiro.UM_REAL , Integer.parseInt( txtUmReal.getText() ) );
		cedulasInseridas.put( TipoDinheiro.DOIS_REAIS , Integer.parseInt( txtDoisReal.getText() ) );
		cedulasInseridas.put( TipoDinheiro.CINCO_REAIS, Integer.parseInt( txtCincoReal.getText() ) );
		cedulasInseridas.put( TipoDinheiro.DEZ_REAIS, Integer.parseInt( txtDezReal.getText() ) );
		stageAdicionarSaldo.close();
		this.cedulasSaldo = cedulasInseridas; 
		this.btnInserirClicado = true;
		for(Map.Entry<TipoDinheiro, Integer> entry: cedulasInseridas.entrySet() ){
			System.out.println(entry.getKey().toString());
			System.out.println(entry.getValue().toString());
		} //END for
	}
	
	@FXML
	public void fechar(){
		stageAdicionarSaldo.close();
		this.cancelarClicado = false;
	}
	
	public boolean isCancelarClicado(){
		return this.cancelarClicado;
	}
	
	public boolean isBtnInserirClicado(){
		return this.btnInserirClicado;
	}
	
	
	
}//END class PainelAdicionarSaldoControle
