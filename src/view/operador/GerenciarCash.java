package grafico.operador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.MaquinaDAO;
import dominio.Maquina;
import dominio.OperadorMaquina;

public class GerenciarCash extends JFrame {

	private JPanel contentPane;
	private OperadorMaquina operadorMaquina;
	private Maquina maquina;
	private JTextField qtdeCinCent;
	private JTextField qtdeUmReal;
	private JTextField qtdeDoisReal;
	private JTextField qtdeCinReal;
	private JTextField qtdeDezReal;
	private JPanel alert;
	private JLabel lblSucesso;
	private JButton btnVoltar;
	private JPanel panel;
	private JButton voltarTelaAnterior;

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
	public GerenciarCash(OperadorMaquina opMaq) {
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
		
		JLabel label = new JLabel("R$ 0,50");
		label.setBounds(22, 58, 65, 16);
		panel.add(label);
		
		JLabel label_1 = new JLabel("R$ 1,00");
		label_1.setBounds(22, 112, 65, 16);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("R$ 2,00");
		label_2.setBounds(22, 167, 65, 16);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("R$ 5,00");
		label_3.setBounds(229, 83, 65, 16);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("R$ 10,00");
		label_4.setBounds(229, 145, 65, 16);
		panel.add(label_4);
		
		qtdeCinCent = new JTextField("0");
		
		/* moeda ou moedas */
		if (opMaq.getMaquina().getCinCent() == 0){
			qtdeCinCent.setToolTipText("Vazio");
		}
		else if (opMaq.getMaquina().getCinCent() == 1){
			qtdeCinCent.setToolTipText("Atual: " + Integer.toString(opMaq.getMaquina().getCinCent()) + " moeda");
		}
		else{
			qtdeCinCent.setToolTipText("Atual: " + Integer.toString(opMaq.getMaquina().getCinCent()) + " moedas");
		}
		
		qtdeCinCent.setBounds(96, 56, 116, 22);
		panel.add(qtdeCinCent);
		qtdeCinCent.setColumns(10);
		
		
		qtdeUmReal = new JTextField("0");
		
		/* moeda ou moedas */
		if (opMaq.getMaquina().getUmReal() == 0){
			qtdeUmReal.setToolTipText("Vazio");
		}
		else if(opMaq.getMaquina().getUmReal() == 1){
			qtdeUmReal.setToolTipText("Atual: " + Integer.toString(opMaq.getMaquina().getUmReal()) + " moeda");
		}
		else{
			qtdeUmReal.setToolTipText("Atual: " + Integer.toString(opMaq.getMaquina().getUmReal()) + " moedas");
		}
		
		qtdeUmReal.setBounds(96, 110, 116, 22);
		panel.add(qtdeUmReal);
		qtdeUmReal.setColumns(10);
		
		
		qtdeDoisReal = new JTextField("0");
		
		/* cédula ou cédulas */
		if (opMaq.getMaquina().getDoisReal() == 0){
			qtdeDoisReal.setToolTipText("Vazio");
		}
		else if(opMaq.getMaquina().getDoisReal() == 1){
			qtdeDoisReal.setToolTipText("Atual: " + Integer.toString(opMaq.getMaquina().getDoisReal()) + " cédula");
		}
		else{
			qtdeDoisReal.setToolTipText("Atual: " + Integer.toString(opMaq.getMaquina().getDoisReal()) + " cédulas");
		}
		
		qtdeDoisReal.setBounds(96, 165, 116, 22);
		panel.add(qtdeDoisReal);
		qtdeDoisReal.setColumns(10);
		
		qtdeCinReal = new JTextField("0");
		
		
		/* céedula ou cédulas */
		if (opMaq.getMaquina().getCincoReal() == 0){
			qtdeCinReal.setToolTipText("Vazio");
		}
		else if(opMaq.getMaquina().getCincoReal() == 1){
			qtdeCinReal.setToolTipText("Atual: " + Integer.toString(opMaq.getMaquina().getCincoReal()) + " cédula");
		}
		else{
			qtdeCinReal.setToolTipText("Atual: " + Integer.toString(opMaq.getMaquina().getCincoReal()) + " cédulas");
		}
		
		qtdeCinReal.setBounds(304, 81, 116, 22);
		panel.add(qtdeCinReal);
		qtdeCinReal.setColumns(10);
		
		qtdeDezReal = new JTextField("0");
		
			
		/* cédula ou cédulas */
		if (opMaq.getMaquina().getDezReal() == 0){
			qtdeDezReal.setToolTipText("Vazio");
		}
		else if(opMaq.getMaquina().getDezReal() == 1){
			qtdeDezReal.setToolTipText("Atual: " + Integer.toString(opMaq.getMaquina().getDezReal()) + " cédula");
		}
		else{
			qtdeDezReal.setToolTipText("Atual: " + Integer.toString(opMaq.getMaquina().getDezReal()) + " cédulas");
		}
		
		qtdeDezReal.setBounds(304, 143, 116, 22);
		panel.add(qtdeDezReal);
		qtdeDezReal.setColumns(10);
		
		
		JLabel lblAdicionarSaldo = new JLabel("Adicionar saldo");
		lblAdicionarSaldo.setBounds(166, 12, 116, 15);
		panel.add(lblAdicionarSaldo);
		
		JButton button = new JButton("Reabastecer");
		button.setBounds(75, 216, 137, 25);
		panel.add(button);
		
		voltarTelaAnterior = new JButton("Voltar");
		voltarTelaAnterior.setBounds(241, 216, 137, 25);
		panel.add(voltarTelaAnterior);
		
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
				GerenciarCash.this.setVisible(false);
				OperadorMaquinaMain opMaq = new OperadorMaquinaMain(operadorMaquina);
				opMaq.setVisible(true);
			}
		});
		
		btnVoltar.setBounds(169, 155, 97, 25);
		alert.add(btnVoltar);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaquinaDAO maquinaDAO = new MaquinaDAO();
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
				GerenciarCash.this.operadorMaquina.setMaquina(maquina);
				
				//DESCOMENTAR LINHA ABAIXO PARA ATUALIZACAO NO BANCO
				maquinaDAO.updateMaquina(maquina);
				panel.setVisible(false);
				alert.setVisible(true);
			}
		});
		
		voltarTelaAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.out.println("voltar clicado!");
				GerenciarCash.this.setVisible(false);
				OperadorMaquinaMain opMaq = new OperadorMaquinaMain(operadorMaquina);
				opMaq.setVisible(true);
			}
		});
		
		
	}
}
