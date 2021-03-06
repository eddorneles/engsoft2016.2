package view.usuario;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.MaquinaDAO;
import def.TipoDinheiro;
import dominio.Maquina;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mbeam.Compra;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private Compra compra;
	//private HashMap<TipoDinheiro, Integer> mapDinheiroSaldo;

        @Override
        public void start( Stage primaryStage ) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle( "Máquina de Alimentos" );

		initRootLayout();
		apresentaProdutos();
	}

	public void initRootLayout(){
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource( "RootLayout.fxml" ));
			rootLayout = (BorderPane) loader.load();
						
			Scene scene = new Scene( rootLayout );
			primaryStage.setScene( scene );
			primaryStage.show();
		}catch( IOException e){
			e.printStackTrace();
		}
	}//END initRootLayout
	
	public void apresentaProdutos(){
	    try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation( Main.class.getResource( "PainelAlimentos.fxml" ) );
            AnchorPane painelAlimentos = (AnchorPane) loader.load();
            rootLayout.setCenter( painelAlimentos );
            
            PainelAlimentosControle ctrlPainelAlimentos = loader.getController();
            ctrlPainelAlimentos.carregaAlimentosDeMaquina();
            ctrlPainelAlimentos.setMain( this );
        }catch( IOException e){
            e.printStackTrace();
		}
	}
	
	public void apresentaPainelAdicionarSaldo(){
		try{
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation( Main.class.getResource( "PainelAdicionarSaldo.fxml" ));
			AnchorPane painelAdicionarSaldo = (AnchorPane) fxmlLoader.load();
			
			//Criação da stage
			Stage dialogStage = new Stage();
	        dialogStage.setTitle("Adicionar Saldo");
	        dialogStage.initModality( Modality.WINDOW_MODAL );
	        dialogStage.initOwner( primaryStage );
	        //Associação da scene ao stage
	        Scene scene = new Scene( painelAdicionarSaldo );
	        dialogStage.setScene( scene );	        
	        PainelAdicionarSaldoControle controle = fxmlLoader.getController();
	        controle.setStageAdicionarSaldo( dialogStage );
	        controle.setCompra( this.compra );
	        controle.initialize(); //O uso desse método é necessário para atualizar a compra do objeto controle
	        dialogStage.showAndWait();
	        
	        if( controle.getCompra() != null ){
	        	this.compra = controle.getCompra();
	        }
	        
		}catch( IOException e ){
			e.printStackTrace();
		}
	}
	
	public Compra getCompra(){
		return this.compra;
	}
	
	public void cancelaCompra(){
		this.compra = null;
	}
	
	public Stage getPrimaryStage(){
		return primaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
