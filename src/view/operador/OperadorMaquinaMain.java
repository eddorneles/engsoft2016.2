package view.operador;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.OperadorDAO;
import dominio.Maquina;
import dominio.Operador;
import dominio.OperadorMaquina;

public class OperadorMaquinaMain extends JFrame {

	private JPanel contentPane;
	private OperadorMaquina operadorMaquina;
	private Maquina maquina;
	
	//comenta esse metodo main se quiser testar chamar essa classe
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperadorMaquinaMain frame = new OperadorMaquinaMain(new OperadorMaquina());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public OperadorMaquinaMain(OperadorMaquina opMaq) {
		setLocationByPlatform(true);
		//substituir linha abaixo por 'this.maquina = opMaq.getMaquina()'
		this.maquina = opMaq.getMaquina();
		
		//substituir linha abaixo por 'this.operadorMaquina = opMaq'
		this.operadorMaquina = opMaq;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 432, 253);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMaquinaId = new JLabel("Maquina ID:");
		lblMaquinaId.setBounds(47, 32, 100, 16);
		panel.add(lblMaquinaId);
		
		JLabel maquinaIdLbl = new JLabel("");
		maquinaIdLbl.setText(""+maquina.getId());
		maquinaIdLbl.setBounds(137, 26, 20, 28);
		panel.add(maquinaIdLbl);
		
		JButton btnGerenciarCash = new JButton("Gerenciar Cash");
		btnGerenciarCash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Botao cash selecionado!");
				//deixa esta janela invisivel e inicia a janela de Gerenciar Cash
				OperadorMaquinaMain.this.setVisible(false);
				
				//deletar linha abixo quando for iniciar a aplicacao com o banco
				//OperadorMaquinaMain.this.operadorMaquina = new OperadorMaquina();
				operadorMaquina.setMaquina(maquina);
				GerenciarCash gerenciarCash = new GerenciarCash(operadorMaquina);
				gerenciarCash.setVisible(true);
				
			}
		});
		btnGerenciarCash.setBounds(47, 116, 180, 25);
		panel.add(btnGerenciarCash);
		
		JButton btnGerenciarEstoque = new JButton("Gerenciar Estoque");
		btnGerenciarEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Botao estoque selecionado!");
				//deixa esta janela invisivel e inicia a janela de Gerenciar Estoque
				OperadorMaquinaMain.this.setVisible(false);
				
				//deletar linha abixo quando for iniciar a aplicacao com o banco
				//OperadorMaquinaMain.this.operadorMaquina = new OperadorMaquina();
				
				operadorMaquina.setMaquina(maquina);
				GerenciarEstoque gerenciarEstoque = new GerenciarEstoque(operadorMaquina);
				gerenciarEstoque.setVisible(true);
				
			}
		});
		btnGerenciarEstoque.setBounds(211, 116, 180, 25);
		panel.add(btnGerenciarEstoque);
		
		JButton voltarTelaAnterior = new JButton("Voltar");
		voltarTelaAnterior.setBounds(303, 216, 117, 25);
		panel.add(voltarTelaAnterior);
		
		voltarTelaAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.out.println("voltar clicado!");
				OperadorMaquinaMain.this.setVisible(false);
				
				/* Redefine operador */
				//OperadorDAO operadorDAO = new OperadorDAO();
				Operador operador = opMaq.getOperador();
				/*operador.setId(opMaq.getOperador().getId());
				operador.setLogin(opMaq.getOperador().getLogin());
				operador.setNome(opMaq.getOperador().getNome());
				operador.setSenha(opMaq.getOperador().getSenha());*/
				
				//OperadorMaquinaMain opMaq = new OperadorMaquinaMain(operadorMaquina);
				//opMaq.setVisible(true);
				OperadorLogado frame = new OperadorLogado(operador);
				frame.setVisible(true);
			}
		});
		
		
		
		
	}
}