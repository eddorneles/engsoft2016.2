package view.usuario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.util.List;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.AlimentoDAO;
import dao.MaquinaDAO;
import dominio.Alimento;
import dominio.Maquina;

import javax.swing.JTextPane;
import javax.swing.JButton;

public class HomeUsuario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeUsuario frame = new HomeUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomeUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnListaDeOpes = new JTextPane();
		txtpnListaDeOpes.setBounds(5, 5, 438, 21);
		txtpnListaDeOpes.setText("Selecione uma máquina");
		contentPane.add(txtpnListaDeOpes);
		
		MaquinaDAO maquinaDAO = new MaquinaDAO();
		
		List<Maquina> maquinas = new ArrayList<Maquina>();
		maquinas = maquinaDAO.getAllMaquinasWithProducts();
		
		AlimentoDAO alimentoDAO = new AlimentoDAO();
		for(Maquina maquina : maquinas){
			
			List<Alimento> alimentos = alimentoDAO.getAlimentosValidos(maquina);
			
            for(int i = 0; i < alimentos.size(); i++){
            	System.out.println("Produto " + alimentos.get(i).getTipoAlimento().getNome() + " na bandeja " + Integer.toString(alimentos.get(i).getBandeja().getNumero()));
				JButton btnOpao = new JButton("Produto " + alimentos.get(i).getTipoAlimento().getNome() + " na bandeja " + Integer.toString(alimentos.get(i).getBandeja().getNumero()));
				btnOpao.setBounds(90, 80 + 50*i, 300 +20, 25 + 20);
				contentPane.add(btnOpao);
				//contentPane.add(btn1pao);
			}
			
			
			
		}
		
		
	}
}
