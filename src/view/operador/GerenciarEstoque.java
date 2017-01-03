package view.operador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.AlimentoDAO;
import dao.MaquinaDAO;
import dominio.Alimento;
import dominio.Maquina;
import dominio.OperadorMaquina;
import javax.swing.JTable;
import javax.swing.JList;

public class GerenciarEstoque extends JFrame {

	private JPanel contentPane;
	private OperadorMaquina operadorMaquina;
	private Maquina maquina;
	private JPanel alert;
	private JLabel lblSucesso;
	private JButton btnVoltar;
	private JPanel panel;
	private JButton voltarTelaAnterior;
	private JLabel lblSemProdutosCadastrados;
<<<<<<< HEAD
	private JTextField textField;
=======
	private Alimento alimento;
>>>>>>> develop

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					OperadorCash frame = new OperadorCash();
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
	public GerenciarEstoque(OperadorMaquina opMaq) {
		setLocationByPlatform(true);
		//substituir linha abaixo por 'this.maquina = opMaq.getMaquina()'
		//this.maquina = new Maquina();
		this.maquina = opMaq.getMaquina();
		
		//substituir linha abaixo por 'this.operadorMaquina = opMaq'
		this.operadorMaquina = opMaq;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 432, 253);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		
		JLabel lblAdicionarSaldo = new JLabel("Gerenciar estoque");
		lblAdicionarSaldo.setBounds(145, 12, 149, 15);
		panel.add(lblAdicionarSaldo);
		
<<<<<<< HEAD
		JButton button = new JButton("Reabastecer");
		button.setBounds(75, 216, 137, 25);
		panel.add(button);
=======
		
>>>>>>> develop
		
		
		//MaquinaDAO maquinaDAO = new MaquinaDAO();
		//List<Maquina> maquinas = maquinaDAO.getAllMaquinasWithProducts();
		//Maquina maquina = maquinas.get(0);
		
		AlimentoDAO alimentoDAO = new AlimentoDAO();
		List<Alimento> alimentos = alimentoDAO.getAlimentosValidos(opMaq.getMaquina());
		if(alimentos.isEmpty()){
			System.out.println("Nenhuma alimento na validade na máquina");
<<<<<<< HEAD
			lblSemProdutosCadastrados = new JLabel("Sem produtos cadastrados na máquina");
			lblSemProdutosCadastrados.setBounds(75, 108, 303, 15);
			panel.add(lblSemProdutosCadastrados);
		}
		else{
=======
			lblSemProdutosCadastrados = new JLabel("Nenhuma alimento na validade na máquina");
			lblSemProdutosCadastrados.setBounds(70, 108, 310, 15);
			panel.add(lblSemProdutosCadastrados);
		}
		else{
			JButton button = new JButton("Reabastecer");
			button.setBounds(75, 216, 137, 25);
			panel.add(button);
			
			/* instancia vetor de TextField */
			JTextField[] vetorAlimento;
			vetorAlimento = new JTextField[alimentos.size()];
			
>>>>>>> develop
			for(int i=0; i<alimentos.size(); i++){
				System.out.printf("Produto: %d, NOME: %s, Preço: %.2f\n",
						i, alimentos.get(i).getTipoAlimento().getNome(), alimentos.get(i).getTipoAlimento().getPreco());
				
				JLabel label = new JLabel(alimentos.get(i).getTipoAlimento().getNome());
				label.setBounds(90, 50 + 30*i, 220 +20, 20);
				panel.add(label);
				
<<<<<<< HEAD
				String provisorio;
				provisorio = "alimento" + i;
				
				textField = new JTextField("0");
				textField.setBounds(280, 54 + 30*i, 114, 19);
				
				//textField.setName(provisorio);
				//System.out.println(provisorio);
				panel.add(textField);
				textField.setColumns(10);
				
				if(alimentos.get(i).getQuantidade() == 1){
					textField.setToolTipText(Integer.toString(alimentos.get(i).getQuantidade()) + " alimento");
				}
				else{
					textField.setToolTipText(Integer.toString(alimentos.get(i).getQuantidade()) + " alimentos");
				}	
			}
		}
		
=======
				
				vetorAlimento[i] = new JTextField("0");
				vetorAlimento[i].setBounds(280, 54 + 30*i, 114, 19);
				
				//alimento0.setName(provisorio);
				//System.out.println(provisorio);
				panel.add(vetorAlimento[i]);
				vetorAlimento[i].setColumns(10);
				
				if(alimentos.get(i).getQuantidade() == 1){
					vetorAlimento[i].setToolTipText(Integer.toString(alimentos.get(i).getQuantidade()) + " alimento");
				}
				else{
					vetorAlimento[i].setToolTipText(Integer.toString(alimentos.get(i).getQuantidade()) + " alimentos");
				}	
			}
			
			
			/* action listener do botão reabastecer */
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for(int i=0; i<alimentos.size(); i++){
						/* atualiza alimentos na máquina */
						alimentos.get(i).setQuantidade(alimentos.get(i).getQuantidade() + Integer.valueOf(vetorAlimento[i].getText()));
						
						/* atualiza alimentos no banco */
						
						alimento = alimentos.get(i);
						alimentoDAO.atualizaQuantidade(alimento);
						panel.setVisible(false);
						alert.setVisible(true);
					}
					
				}
			});
			
			
		}
		
		alert = new JPanel();
		alert.setBounds(0, 0, 432, 253);
		contentPane.add(alert);
		/*coloca a janela de sucesso invisivel. Essa janela so vai se tornar visivel quando
		'Reabastecer' for clicado*/
		alert.setVisible(false);
		alert.setLayout(null);
		
		lblSucesso = new JLabel("Sucesso!");
		lblSucesso.setHorizontalAlignment(SwingConstants.CENTER);
		lblSucesso.setBounds(101, 61, 226, 99);
		alert.add(lblSucesso);
		
>>>>>>> develop
		
		
		voltarTelaAnterior = new JButton("Voltar");
		voltarTelaAnterior.setBounds(241, 216, 137, 25);
		panel.add(voltarTelaAnterior);
		
		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setBounds(93, 27, 73, 15);
		panel.add(lblProduto);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(291, 27, 91, 15);
		panel.add(lblQuantidade);
		
<<<<<<< HEAD
		
		
		
=======

>>>>>>> develop
		
		alert = new JPanel();
		alert.setBounds(0, 0, 432, 253);
		contentPane.add(alert);
		/*coloca a janela de sucesso invisivel. Essa janela so vai se tornar visivel quando
		'Reabastecer' for clicado*/
		alert.setVisible(false);
		alert.setLayout(null);
		
		lblSucesso = new JLabel("Sucesso!");
		lblSucesso.setHorizontalAlignment(SwingConstants.CENTER);
		lblSucesso.setBounds(101, 61, 226, 99);
		alert.add(lblSucesso);
		
		btnVoltar = new JButton("Voltar");
		
		//volta pro menu inicial da maquina
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerenciarEstoque.this.setVisible(false);
				OperadorMaquinaMain opMaq = new OperadorMaquinaMain(operadorMaquina);
				opMaq.setVisible(true);
			}
		});
		
		btnVoltar.setBounds(169, 155, 97, 25);
		alert.add(btnVoltar);
<<<<<<< HEAD
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String alimento_bd;
				for(int i=0; i<alimentos.size(); i++){
					//alimento_bd = "alimento" + i;
					
					//alimentos.get(i).setQuantidade(Integer.valueOf(alimento1.getText()));
					//maquina.setCinCent(Integer.valueOf(qtdeCinCent.getText()) + opMaq.getMaquina().getCinCent());
				}
				/* substituir por métodos equivalentes para esta classe */
				/*MaquinaDAO maquinaDAO = new MaquinaDAO();
				maquina.setCinCent(Integer.valueOf(qtdeCinCent.getText()) + opMaq.getMaquina().getCinCent());
				maquina.setUmReal(Integer.valueOf(qtdeUmReal.getText()) + opMaq.getMaquina().getUmReal());
				maquina.setDoisReal(Integer.valueOf(qtdeDoisReal.getText()) + opMaq.getMaquina().getDoisReal());
				maquina.setCincoReal(Integer.valueOf(qtdeCinReal.getText()) + opMaq.getMaquina().getCincoReal());
				maquina.setDezReal(Integer.valueOf(qtdeDezReal.getText()) + opMaq.getMaquina().getDezReal());
				maquina.setDinheiroVendas(opMaq.getMaquina().getDinheiroVendas());
				
				
				maquina.setId(opMaq.getMaquina().getId());
				System.out.println("50 cent. "+maquina.getCinCent()+" 1 real "+maquina.getUmReal()+" 2 reais "+maquina.getDoisReal()
				+" 5 reais "+maquina.getCincoReal()+" 10 reais "+maquina.getDezReal() + " id " + opMaq.getMaquina().getId()
				+ " dinheiro vendas " + opMaq.getMaquina().getDinheiroVendas());
				//atualiza a maquina no objeto OperadorMaquina
				GerenciarEstoque.this.operadorMaquina.setMaquina(maquina);
				
				//DESCOMENTAR LINHA ABAIXO PARA ATUALIZACAO NO BANCO
				maquinaDAO.updateMaquina(maquina);
				panel.setVisible(false);
				alert.setVisible(true);*/
			}
		});
=======
		
>>>>>>> develop
		
		voltarTelaAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.out.println("voltar clicado!");
				GerenciarEstoque.this.setVisible(false);
				OperadorMaquinaMain opMaq = new OperadorMaquinaMain(operadorMaquina);
				opMaq.setVisible(true);
			}
		});
		
		
	}
}