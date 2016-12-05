package mbean;

import java.util.List;

import dominio.Maquina;
import dao.MaquinaDAO;
public class MaquinaMBean {

	
	private List<Maquina> maquinas = null;
	
	public List<Maquina> getMaquinasWithProducts(){
		
		if(maquinas != null){
			return maquinas;
		}
		
		MaquinaDAO dao = new MaquinaDAO();
		maquinas = dao.findAllMaquinasWithProduction();
		
		return maquinas;
	}
}
