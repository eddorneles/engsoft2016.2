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
		
		for(Maquina maquina : maquinas){
			System.out.printf("%s, %d, %d", maquina.getId(), maquina.getCinCent(), maquina.getUmReal());
		}
	}
}
