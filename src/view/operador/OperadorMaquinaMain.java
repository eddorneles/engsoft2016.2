package view.operador;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dominio.Maquina;
import dominio.OperadorMaquina;

public class OperadorMaquinaMain extends JFrame {

	private JPanel contentPane;
	private OperadorMaquina operadorMaquina;
	private Maquina maquina;
	
	//comenta esse metodo main se quiser testar chamar essa classe
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	/**
	 * Create the frame.
	 */
	public OperadorMaquinaMain(OperadorMaquina opMaq) {
		//substituir linha abaixo por 'this.maquina = opMaq.getMaquina()'
		this.maquina = new Maquina();
		
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
		lblMaquinaId.setBounds(47, 32, 69, 16);
		panel.add(lblMaquinaId);
		
		JLabel maquinaIdLbl = new JLabel("");
		maquinaIdLbl.setBounds(269, 50, -126, -28);
		panel.add(maquinaIdLbl);
		
		JButton btnGerenciarCash = new JButton("Gerenciar Cash");
		btnGerenciarCash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Botao cash selecionado!");
				//deixa esta janela invisivel e inicia a janela de Gerenciar Cash
				OperadorMaquinaMain.this.setVisible(false);
				
				//deletar linha abixo quando for iniciar a aplicacao com o banco
				OperadorMaquinaMain.this.operadorMaquina = new OperadorMaquina();
				operadorMaquina.setMaquina(maquina);
				GerenciarCash gerenciarCash = new GerenciarCash(operadorMaquina);
				gerenciarCash.setVisible(true);
				
			}
		});
		btnGerenciarCash.setBounds(47, 116, 131, 25);
		panel.add(btnGerenciarCash);
		
		JButton btnGerenciarEstoque = new JButton("Gerenciar Estoque");
		btnGerenciarEstoque.setBounds(211, 116, 137, 25);
		panel.add(btnGerenciarEstoque);
		
		
		
		
	}
}
