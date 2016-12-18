package maquina_de_alimentos;

import java.util.List;

import dao.MaquinaDAO;
import dominio.Maquina;

public class TestaMaquina {
public static void main(String[] args){
	
	
	
	MaquinaDAO maquinaDAO = new MaquinaDAO();
	Maquina maquina = maquinaDAO.getMaquina(1);
	if(maquina == null){
		System.out.println("inválido");
	}
	else{
		System.out.println("válido");
		System.out.printf("id: %d \n2 reais: %d", maquina.getId(), maquina.getDoisReal());
	}
}
}
