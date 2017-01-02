package maquina_de_alimentos;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dao.*;
import def.TipoDinheiro;
import dominio.*;
import mbeam.Compra;
import def.TipoDinheiro;

public class MaquinaDeAlimentos {

	public static void main(String[] args){
		
		MaquinaDAO maquinaDAO = new MaquinaDAO();
		
		List<Maquina> maquinas = maquinaDAO.getAllMaquinasWithProducts();
		
		Scanner input = new Scanner(System.in);
		
		if( maquinas.isEmpty() ){
			System.out.println("Não tem máquina com produtos");
		}
		else{
			for(int i=0; i < maquinas.size(); i++){
				System.out.printf("Máquina: %d\n",
						i);
			}
			System.out.println("Selecione uma máquina");
			int maquinaSelecionada = input.nextInt();
			
			AlimentoDAO alimentoDAO = new AlimentoDAO();
			
			Maquina maquina = maquinas.get(maquinaSelecionada);
			
			List<Alimento> alimentos = alimentoDAO.getAlimentosValidos(maquina);
			
		
			if(alimentos.isEmpty()){
				System.out.println("Nenhuma alimento na validade na máquina");
			}
			else{
				for(int i=0; i<alimentos.size(); i++){
					System.out.printf("Produto: %d, NOME: %s, Preço: %.2f\n",
							i, alimentos.get(i).getTipoAlimento().getNome(), alimentos.get(i).getTipoAlimento().getPreco());
				}

				System.out.println("Selecione um alimento");
				int alimentoSelecionado = input.nextInt();
				
				Alimento alimento = alimentos.get(alimentoSelecionado);
				
				HashMap<TipoDinheiro, Integer> mapPagamento = new HashMap<TipoDinheiro, Integer>();
				System.out.println("Informe o pagamento");
				
				System.out.println("Moedas de cinquenta");
				mapPagamento.put( TipoDinheiro.CINQUENTA_CENTAVOS , input.nextInt() );
				
				System.out.println("Moedas de um");
				mapPagamento.put( TipoDinheiro.UM_REAL, input.nextInt());
				
				System.out.println("Cédulas de dois");
				mapPagamento.put( TipoDinheiro.DOIS_REAIS, input.nextInt());
				
				System.out.println("Cédulas de 5");
				mapPagamento.put( TipoDinheiro.CINCO_REAIS, input.nextInt());
				
				System.out.println("Cédulas de 10");
				mapPagamento.put( TipoDinheiro.DEZ_REAIS, input.nextInt());
				
				Compra compra = new Compra();
				
				boolean compraRealizada = compra.realizaCompra(maquina, alimento, mapPagamento);
				
				if( compraRealizada ){
					Map<TipoDinheiro, Integer> troco = compra.getTroco();
					for(Map.Entry<TipoDinheiro, Integer> entry: troco.entrySet() ){
						
						System.out.println(entry.getKey().toString() );
						System.out.println(entry.getValue().toString() );
					}
				}
				else{
					System.out.println("Sua compra não pode ser realizada");
				}//END if
			}
		}
	}
}//END class
