package mbeam;

import dao.AlimentoDAO;
import dao.MaquinaDAO;

import dominio.Alimento;
import dominio.Maquina;

import java.util.HashMap;
import java.util.Map;
import org.joda.time.DateTime;


import def.TipoDinheiro;

public class Compra {
	private int umReal = 0, doisReal = 0, cincoReal = 0, dezReal = 0, cinCent = 0;
	private double saldoInserido;
	
	HashMap<TipoDinheiro, Integer> troco;
	
	public boolean realizaCompra( Maquina maquina , Alimento alimento ,
			HashMap<TipoDinheiro,Integer> mapCedulas ){
		
		double saldo = calculaSaldo( mapCedulas );
		//Se o saldo_inserido for maior ou igual ao preco, então a compra pode ocorrer
		if ( saldo >= alimento.getTipoAlimento().getPreco() ){
			HashMap<TipoDinheiro,Integer> mapTroco = calcularTroco( maquina, alimento , saldo );
			
			if( mapTroco != null ){
				
				AlimentoDAO alimentoDAO = new AlimentoDAO();
				//Se houver algum alimento na bandeja
				if(alimento.getQuantidade() > 0 ){
					alimento.setQuantidade( alimento.getQuantidade() - 1 );
					alimentoDAO.atualizaQuantidade( alimento );
					
				}
				double novoSaldoMaquina = maquina.getDinheiroVendas() + alimento.getTipoAlimento().getPreco();
				maquina.setDinheiroVendas( novoSaldoMaquina );
				MaquinaDAO maquinaDAO = new MaquinaDAO();
				maquinaDAO.updateMaquina(maquina);
				setTroco(mapTroco);
				
				return true;
			}
			
		}//END if valor_dinheiro >= alimento.getTipo ...
		return false;
	}// END realizaCompra
	
	public double calculaSaldo( HashMap<TipoDinheiro , Integer> mapCedulas ){
		double saldo = 0.0;
		
		// Para cada elemento presente em mapCedulas
		for( Map.Entry<TipoDinheiro, Integer> entry : mapCedulas.entrySet() ){
			saldo += (entry.getValue() * entry.getKey().get() );
		}
		return saldo;
	}
	
	public HashMap<TipoDinheiro, Integer> calcularTroco( Maquina maquina, 
			Alimento alimento , double valor_dinheiro ){
		double trocoReceber;
		int trocoParcial;
		int cedulasCincoReal, cedulasDoisReal, moedasUmReal;
		double moedasCinCentavos;
		
		trocoReceber = valor_dinheiro - alimento.getTipoAlimento().getPreco();
		trocoParcial = (int) trocoReceber;
		double somaParcial=0;
		
		//CÁLCULO PARA RECEBER CÉDULAS DE 5 REAIS
		cedulasCincoReal = trocoParcial/5;
		if( maquina.getCincoReal() < cedulasCincoReal ){
			cedulasCincoReal = maquina.getCincoReal();
		}
		trocoParcial = trocoParcial - (cedulasCincoReal * 5);
		somaParcial += (cedulasCincoReal * 5);
		//CÁLCULO PARA RECEBER CÉDULAS DE 2
		cedulasDoisReal = trocoParcial/2;
		if( maquina.getDoisReal() < cedulasDoisReal ){
			cedulasDoisReal = maquina.getDoisReal();
		}
		trocoParcial = trocoParcial - (cedulasDoisReal * 2);
		somaParcial += (cedulasDoisReal * 2);
		//CAĹCULO PARA RECEBER MOEDAS DE 1
		moedasUmReal = trocoParcial/1;
		if( maquina.getUmReal() < moedasUmReal ){
			moedasUmReal = maquina.getUmReal();
		}
		trocoParcial = trocoParcial - (moedasUmReal * 1 );
		somaParcial += (moedasUmReal * 1);
		//CÁLCULO PARA RECEBER MOEDAS DE 0,50
		double trocoRestante = trocoReceber - somaParcial;
		moedasCinCentavos = trocoRestante/0.5;
		
		if( maquina.getCinCent() >= (int) moedasCinCentavos ){
			//A máquina deverá possuir a quantidade correta de cédulas e moedas
			// Necessárias para retornar o troco esperado
			MaquinaDAO maquinaDao = new MaquinaDAO();
			maquina.setCincoReal( maquina.getCincoReal() - cedulasCincoReal );
			maquina.setDoisReal( maquina.getDoisReal() - cedulasDoisReal );
			maquina.setUmReal( maquina.getUmReal() - moedasUmReal );
			maquina.setCinCent( maquina.getCinCent() - (int) moedasCinCentavos);
			
			maquinaDao.updateMaquina( maquina );
			HashMap<TipoDinheiro, Integer> mapTroco = new HashMap<TipoDinheiro, Integer>();
			
			mapTroco.put( TipoDinheiro.CINCO_REAIS, cedulasCincoReal );
			mapTroco.put( TipoDinheiro.DOIS_REAIS, cedulasDoisReal );
			mapTroco.put( TipoDinheiro.UM_REAL, moedasUmReal );
			mapTroco.put( TipoDinheiro.CINQUENTA_CENTAVOS, (int) moedasCinCentavos );
			mapTroco.put( TipoDinheiro.DOIS_REAIS, cedulasDoisReal );
			
			return mapTroco;
		}
		/*Se não houver cedulas ou moedas suficientes para troco, então não é possível gerar troco, 
			portanto, retornar null
		 */
		return null;	
	}
	
	private boolean verificaValidadeAlimento( Alimento alimento , Maquina maquina ){
		
		return false;
	}
	
	public double getSaldoInserido() {
		return saldoInserido;
	}

	public void setSaldoInserido(double saldoInserido) {
		this.saldoInserido = saldoInserido;
	}

	private void setTroco( HashMap<TipoDinheiro, Integer> troco){
		this.troco = troco;
	}
	
	public HashMap<TipoDinheiro, Integer> getTroco(){
		return troco;
	}
}
