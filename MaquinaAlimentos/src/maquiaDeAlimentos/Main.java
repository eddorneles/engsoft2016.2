package maquiaDeAlimentos;


import java.util.Collection;

import dominio.Alimento;
import mbean.AlimentoMBean;

public class Main {

	public static void main(String[] args){
		
		AlimentoMBean alimentosBean = new AlimentoMBean();
		
		Collection<Alimento> alimentos = alimentosBean.findAllAlimentosValidosMaquina(1);
		
		for(Alimento alimento : alimentos){
			System.out.println(alimento.getTipoAlimento());
		}
	}
}
