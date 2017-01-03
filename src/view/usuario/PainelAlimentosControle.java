package view.usuario;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import dao.AlimentoDAO;
import dao.MaquinaDAO;
import def.ResultadoCompra;
import dominio.Alimento;
import dominio.Maquina;
import view.usuario.extended.ButtonAlimento;

public class PainelAlimentosControle {
	/* ATRIBUTOS */
	private Main main;
	
	private double saldo;
	private Compra compra;
	private Maquina maquina;
	
	
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
			this.maquina = listaMaquinas.get(0);
			AlimentoDAO alimentoDAO = new AlimentoDAO();
			List<Alimento> listaAlimentos = alimentoDAO.getAlimentosValidos( maquina );
			carregaAlimentosNoGrid( listaAlimentos );
		}//END if( listaMaquinas.isEmpty == false
	}// END carregaAlimentosDeMaquina
	
	private void carregaAlimentosNoGrid( List<Alimento> listaAlimentos ){
		System.out.println( "Tamanho da lista: " + listaAlimentos.size());
		int i = 0;
		int k = 0;
		//Enquanto não lista todos os alimentos
		while( k < listaAlimentos.size() ){
			//O iterador j 
			for( int j = 0 ; j < MAX_COLUMNS && k < listaAlimentos.size() ; j++ ){
				Alimento alimento = listaAlimentos.get( k );
				double precoAlimento = alimento.getTipoAlimento().getPreco();
				String nomeAlimento = alimento.getTipoAlimento().getNome();
				VBox vBox = new VBox();
				vBox.setAlignment( Pos.CENTER );
				ButtonAlimento btnAlimento = new ButtonAlimento( nomeAlimento );
				btnAlimento.setPrefWidth(230);
				btnAlimento.setPrefHeight(90);
				btnAlimento.setAlimento( alimento );
				adicionarEventHandlerButtonAlimento( btnAlimento );
				Label lblPreco = new Label("Preço: " + precoAlimento );
				lblPreco.setPrefWidth( 230 );
				vBox.getChildren().addAll( btnAlimento , lblPreco );
				this.gpnGridAlimentos.add( vBox , j, i );
				k++;
			}// END for( int j = 0 ; j < MAX_COLUMNS ; ...
			i++;
		}// END while
	}// END carregaAlimentosNoGrid
	
	private void adicionarEventHandlerButtonAlimento( ButtonAlimento btnAlimento ){
		btnAlimento.setOnAction( (event) -> {
			ResultadoCompra resultadoCompra = 
					this.compra.realizaCompra( this.maquina , btnAlimento.getAlimento() );
			//Se o resultado da compra for bem sucedido
			if( resultadoCompra == ResultadoCompra.CONCLUIDA ){
				this.atualizaLabelSaldo();
				System.out.println( "Compra concluída com sucesso!" );
				System.out.println( btnAlimento.getAlimento().getTipoAlimento().getNome() 
						+ " disponíveis: " + btnAlimento.getAlimento().getQuantidade() );
			}else if( resultadoCompra == ResultadoCompra.SALDO_INSUFICIENTE ){
				System.out.println( "Saldo insuficiente." );
			}else if( resultadoCompra == ResultadoCompra.TROCO_INSUFICIENTE ){
				System.out.println( "Troco indisponível." );
			}else{
				
			}
		});//END lambda setOnAction
	}//END adicionarEventHandler
	
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
