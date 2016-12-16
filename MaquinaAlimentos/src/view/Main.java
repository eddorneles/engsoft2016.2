package view;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Main extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	
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
			loader.setLocation( Main.class.getResource( "PainelMaquinaAlimentos.fxml" ) );
			AnchorPane painelMaquinaAlimentos = (AnchorPane) loader.load();
			rootLayout.setCenter( painelMaquinaAlimentos );
		}catch( IOException e){
			e.printStackTrace();
		}
	}
	
	public Stage getPrimaryStage(){
		return primaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
