package view.usuario.extended;

import dominio.Alimento;
import javafx.scene.control.Button;

public class ButtonAlimento extends Button{
	private Alimento alimento;
	
	
	public ButtonAlimento( String buttonText ){
		super( buttonText );
	}
	
	public ButtonAlimento(){
		
	}
	
	public Alimento getAlimento(){
		return this.alimento;
	}
	
	public void setAlimento( Alimento alimento ){
		this.alimento = alimento;
	}
}//END class ButtonAlimento


