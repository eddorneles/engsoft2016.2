package def;

public enum TipoDinheiro {
	CINQUENTA_CENTAVOS(0.5),
	UM_REAL(1),
	DOIS_REAIS(2),
	CINCO_REAIS(5),
	DEZ_REAIS(10);
	
	private final double value;
	
	public double get(){
		return value;
	}
	
	TipoDinheiro( double v ){
		this.value = v;
	}
}//END enum TipoDinheiro
