package maquiaDeAlimentos;

import java.util.List;

import dominio.Alimento;
import dominio.Maquina;

import mbean.AlimentoMBean;
import mbean.MaquinaMBean;

public class Main {

	public static void main(String[] args){
		
		MaquinaMBean maquinamb = new MaquinaMBean();
		List<Maquina> maquinas = maquinamb.getMaquinasWithProducts();
		
		//AlimentoMBean alimentomb = new AlimentoMBean();
		//List<Alimento> alimentos = alimentomb.findAllAlimentosValidosMaquina(1);
		
		System.out.printf("Id máquina, 50 cent, 1 real, 2 reais, 5 reais, 10 reais\n");
		for(Maquina maquina : maquinas){
			//System.out.printf("id máquina: %s\nMoedas 50 cent.: %d\nMoedas 1 real:  %d\nCédulas 2 reais: %d\n Cédulas 5 reais: %d\nCédulas 10 reais: %d\n\n", maquina.getId(), maquina.getCinCent(), maquina.getUmReal(), maquina.getDoisReal(), maquina.getCincoReal(), maquina.getDezReal());
			System.out.printf("      %s       %d        %d       %d        %d       %d\n", maquina.getId(), maquina.getCinCent(), maquina.getUmReal(), maquina.getDoisReal(), maquina.getCincoReal(), maquina.getDezReal());
		}
	}
}
