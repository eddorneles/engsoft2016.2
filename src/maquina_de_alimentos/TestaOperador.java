package maquina_de_alimentos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dao.OperadorDAO;
import dao.OperadorMaquinaDAO;
import dominio.Maquina;
//import dao.MaquinaDAO;
import dominio.Operador;
//import dominio.Maquina;
//import mbeam.Compra;
import dominio.OperadorMaquina;

public class TestaOperador {
public static void main(String[] args){
		
		OperadorDAO operadorDAO = new OperadorDAO();
		
		OperadorMaquinaDAO opMDAO = new OperadorMaquinaDAO();
		
		
		Scanner input = new Scanner(System.in);
		/*for(int i=0; i<opM.size(); i++){
			System.out.printf("Máquina: %d\n",
					i);
		}*/
		//System.out.printf(opM.get(0).get
		
		
		System.out.println("Logando operador");
		System.out.println("informe login:");
		String login = input.nextLine();
		System.out.println("informe senha:");
		String senha = input.nextLine();
		
		
		Operador operador = operadorDAO.loginOperador(login, senha);
		if(operador == null){
			System.out.println("Login ou senha errado");
		}
		else{
			
			System.out.printf("Logado como operador: %d, Nome: %s\n",
					operador.getId(), operador.getNome());
		

			System.out.println("Selecione uma máquina:");
			
			List <Maquina> maquinasOperador = opMDAO.getAllMaquinaOperador(operador);
			if(!maquinasOperador.isEmpty()){
				for(int i=0; i<maquinasOperador.size(); i++){
					System.out.printf("Máquina: %d\n",
							maquinasOperador.get(i).getId());
				}
			}
			else{
				System.out.println("Operador não tem acesso a alguma máquina");
			}
			
		}
		
	}
}
