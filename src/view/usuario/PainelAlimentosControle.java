package view.usuario;

import java.util.ArrayList;
import java.util.List;

import dao.AlimentoDAO;
import dao.MaquinaDAO;
import dominio.Alimento;
import dominio.Maquina;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import mbeam.Compra;

public class PainelAlimentosControle {
	/* ATRIBUTOS */
	private Main main;
	private double saldo;
	private Compra compra;
	
	
	private final int MAX_COLUMNS = 2;
	/* ATRIBUTOS FXML */
	@FXML
	private Button btnAdicionarSaldo;
	@FXML
	private Label lblSaldo;
	@FXML
	private GridPane gpnGridAlimentos;
	
	
	/* ********************************************************************************
	 * MÉTODOS LOCAIS */
	

	/* MÉTODOS FXML */
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
			this.compra = this.main.getCompra();
			atualizaLabelSaldo();
		}
	}// END handleBtnAdicionarSaldo
	
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
	
	@FXML
	private void apresentaProdutos(){
		
	}
	//END MÉTODOS FXML
	/* ********************************************************************************/
	// OUTROS MÉTODOS
	public void carregaAlimentosDeMaquina(){
		MaquinaDAO maquinaDAO = new MaquinaDAO();
		List<Maquina> listaMaquinas = maquinaDAO.getAllMaquinasWithProducts();
		if( listaMaquinas.isEmpty() == false ){
			//Possui máquina com alimentos
			Maquina maquina = listaMaquinas.get(0);
			AlimentoDAO alimentoDAO = new AlimentoDAO();
			List<Alimento> listaAlimentos = alimentoDAO.getAlimentosValidos( maquina );
			/*
			Alimento alimento = listaAlimentos.get(0);
			
			VBox vbox = new VBox();
			Button btn = new Button("botão 1");
			GridPane.setRowIndex( vbox , 0 );
			GridPane.setColumnIndex( vbox, 0 );
			this.gpnGridAlimentos.add(vbox, 0, 0);
			//btn.setMargin( new Insets( 0 , 0 , 0 , 0) );
			//vbox.setPadding(new Insets(0,0,0,0) );
			btn.setPrefWidth(230);
			btn.setPrefHeight(90);
			Label lbl = new Label("Preço do produto");
			vbox.setAlignment(Pos.CENTER);
			vbox.getChildren().addAll( btn, lbl );
			vbox = new VBox();
			this.gpnGridAlimentos.add(vbox,1 , 0);
			vbox.getChildren().addAll( new Button("Botão Teste 2") );
			*/
			carregaAlimentosNoGrid( listaAlimentos );
		}//END if( listaMaquinas.isEmpty == false
	}// END carregaAlimentosDeMaquina
	
	private void carregaAlimentosNoGrid( List<Alimento> listaAlimentos ){
		for( int i = 0 ; i < listaAlimentos.size() ; i++ ){
			for( int j = 0 ; j < MAX_COLUMNS ; j++ ){
				Alimento alimento = listaAlimentos.get( i );
				double precoAlimento = alimento.getTipoAlimento().getPreco();
				String nomeAlimento = alimento.getTipoAlimento().getNome();
				VBox vBox = new VBox();
				vBox.setAlignment( Pos.CENTER );
				Button btnAlimento = new Button( listaAlimentos.get(i).getTipoAlimento().getNome() );
				btnAlimento.setPrefWidth(230);
				btnAlimento.setPrefHeight(90);
				Label lblPreco = new Label("Preço: " + (
							listaAlimentos.get( i ).getTipoAlimento().getPreco() ) );
				lblPreco.setPrefWidth( 230 );
				vBox.getChildren().addAll( btnAlimento , lblPreco );
				this.gpnGridAlimentos.add( vBox , j, i );
				
			}// END for( int j = 0 ; j < MAX_COLUMNS ; ...
		}
		
	}
	
	/* ********************************************************************************/
	 // GETs e SETs
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void setMain( Main main ){
		this.main = main;
	}
	
	/* END GETs e SETs */
	/* END MÉTODOS LOCAIS */
}//END class
