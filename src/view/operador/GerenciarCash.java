package view.operador;

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
	private MaquinaDAO maquinaDAO;
	private JTextField qtdeCinCent;
	private JTextField qtdeUmReal;
	private JTextField qtdeDoisReal;
	private JTextField qtdeCinReal;
	private JTextField qtdeDezReal;
	private JPanel alert;
	private JLabel lblSucesso;
	private JButton btnVoltar;
	private JPanel panel;

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
		
		panel = new JPanel();
		panel.setBounds(0, 0, 432, 253);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("R$ 0,50");
		label.setBounds(22, 58, 44, 16);
		panel.add(label);
		
		JLabel label_1 = new JLabel("R$ 1,00");
		label_1.setBounds(22, 112, 44, 16);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("R$ 2,00");
		label_2.setBounds(22, 167, 44, 16);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("R$ 5,00");
		label_3.setBounds(207, 83, 44, 16);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("R$ 10,00");
		label_4.setBounds(207, 145, 51, 16);
		panel.add(label_4);
		
		qtdeCinCent = new JTextField();
		qtdeCinCent.setBounds(69, 55, 116, 22);
		panel.add(qtdeCinCent);
		qtdeCinCent.setColumns(10);
		
		qtdeUmReal = new JTextField();
		qtdeUmReal.setBounds(69, 109, 116, 22);
		panel.add(qtdeUmReal);
		qtdeUmReal.setColumns(10);
		
		qtdeDoisReal = new JTextField();
		qtdeDoisReal.setBounds(69, 164, 116, 22);
		panel.add(qtdeDoisReal);
		qtdeDoisReal.setColumns(10);
		
		qtdeCinReal = new JTextField();
		qtdeCinReal.setBounds(260, 80, 116, 22);
		panel.add(qtdeCinReal);
		qtdeCinReal.setColumns(10);
		
		qtdeDezReal = new JTextField();
		qtdeDezReal.setBounds(260, 142, 116, 22);
		panel.add(qtdeDezReal);
		qtdeDezReal.setColumns(10);
		
		JButton button = new JButton("Reabastecer");
		button.setBounds(260, 189, 116, 25);
		panel.add(button);
		
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
				maquina.setCinCent(Integer.valueOf(qtdeCinCent.getText()));
				maquina.setUmReal(Integer.valueOf(qtdeUmReal.getText()));
				maquina.setDoisReal(Integer.valueOf(qtdeDoisReal.getText()));
				maquina.setCincoReal(Integer.valueOf(qtdeCinReal.getText()));
				maquina.setDezReal(Integer.valueOf(qtdeDezReal.getText()));
				System.out.println(""+maquina.getCinCent()+" "+maquina.getUmReal()+" "+maquina.getDoisReal()
				+" "+maquina.getCincoReal()+" "+maquina.getDezReal());
				//atualiza a maquina no objeto OperadorMaquina
				GerenciarCash.this.operadorMaquina.setMaquina(maquina);
				
				//DESCOMENTAR LINHA ABAIXO PARA ATUALIZACAO NO BANCO
				//maquinaDAO.updateMaquina(maquina);
				panel.setVisible(false);
				alert.setVisible(true);
			}
		});
	}

}
