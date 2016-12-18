package grafico.operador;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import dao.AlimentoDAO;
import dao.MaquinaDAO;
import dao.OperadorDAO;
import dao.OperadorMaquinaDAO;
import dominio.Alimento;
import dominio.Maquina;
import dominio.Operador;
import dominio.OperadorMaquina;

public class OperadorLogado extends JFrame {

	private JPanel contentPane;
	private Operador operador;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperadorLogado frame = new OperadorLogado();
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
	public OperadorLogado(Operador operador) {
		this.operador = operador;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnListaDeOpes = new JTextPane();
		txtpnListaDeOpes.setBounds(5, 5, 438, 21);
		txtpnListaDeOpes.setText("Selecione uma máquina");
		contentPane.add(txtpnListaDeOpes);
		
		JButton voltarTelaAnterior = new JButton("Sair");
		voltarTelaAnterior.setBounds(330, 220, 85, 30);
		contentPane.add(voltarTelaAnterior, BorderLayout.NORTH);
		
		OperadorMaquinaDAO opMDAO = new OperadorMaquinaDAO();
		List <Maquina> maquinasOperador = opMDAO.getAllMaquinaOperador(operador);
		if(!maquinasOperador.isEmpty()){
			for(int i=0; i<maquinasOperador.size(); i++){
				System.out.printf("Máquina: %d\n",
						maquinasOperador.get(i).getId());
				
				/* cria máquinas na tela */
				JButton btnOpao = new JButton("Máquina " + maquinasOperador.get(i).getId());
				btnOpao.setName(String.valueOf(maquinasOperador.get(i).getId()));
				btnOpao.setBounds(90, 80 + 50*i, 220 +20, 25 + 20);
				contentPane.add(btnOpao);
				btnOpao.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//btnOpao.getName(); - nome do botão
						//CloseFrame();
						System.out.printf("Selecionado máquina %s\n", btnOpao.getName());
						
						/* pega objeto máquina para enviar à prox. classe */
						for(int i=0; i<maquinasOperador.size(); i++){
							if(Integer.parseInt(btnOpao.getName()) == maquinasOperador.get(i).getId()){
								System.out.print("It's a match!");
								OperadorMaquina opMaq = new OperadorMaquina();
								opMaq.setMaquina(maquinasOperador.get(i));
								opMaq.setOperador(OperadorLogado.this.operador);
								
								OperadorMaquinaMain main = new OperadorMaquinaMain(opMaq);
								main.setVisible(true);
								CloseFrame();
							}
							Maquina maquinaProx = maquinasOperador.get(i);
							//chama próx função
							//CloseFrame();//fecha frame atual
							//abre frame da máquina
							
							/* teste */
							//System.out.printf("%d", maquinaProx.getDezReal());
						}
					}
				});
			}
			voltarTelaAnterior.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					System.out.println("voltar clicado!");
					OperadorLogado.this.setVisible(false);
					HomeOperador frame = new HomeOperador();
					frame.setVisible(true);
					
				}
			});
		}
		else{
			System.out.println("Operador não tem acesso a alguma máquina");
		}
			
           
			
			
			
	}
	public void CloseFrame(){
	    super.dispose();
	}
}
