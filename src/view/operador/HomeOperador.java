package view.operador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.OperadorDAO;
import dao.OperadorMaquinaDAO;
import dominio.Operador;

import javax.swing.JLabel;
import java.awt.TextField;
import java.awt.TextArea;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeOperador extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeOperador frame = new HomeOperador();
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
	public HomeOperador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Página de login");
		lblNewLabel.setBounds(5, 5, 438, 15);
		contentPane.add(lblNewLabel);
		
		TextField login = new TextField();
		//login.setText("Login");
		login.setBounds(85, 37, 325, 29);
		contentPane.add(login);
		
		TextField senha = new TextField();
		//senha.setText("Senha");
		senha.setBounds(85, 93, 325, 29);
		contentPane.add(senha);
		
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/* instancia operador */
				OperadorDAO operadorDAO = new OperadorDAO();
				OperadorMaquinaDAO opMDAO = new OperadorMaquinaDAO();
				
				/* checa se login e senha são válidos */
				Operador operador = operadorDAO.loginOperador(login.getText(), senha.getText());
				if(operador == null){
					System.out.println("Login ou senha errado");
					
					AcessoNegado dialog = new AcessoNegado();
					//dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				else{
					
					System.out.printf("Logado como operador: %d, Nome: %s\n",
							operador.getId(), operador.getNome());
					/* vai para tela OperadorLogado*/
					//HomeOperador.dispose();
					CloseFrame();
					OperadorLogado frame = new OperadorLogado(operador);
					frame.setVisible(true);
					
				}
			}
		});
		btnEntrar.setBounds(24, 168, 108, 53);
		contentPane.add(btnEntrar);
		
		JLabel lblNewLabel_1 = new JLabel("Login:");
		lblNewLabel_1.setBounds(24, 51, 53, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(24, 103, 53, 15);
		contentPane.add(lblSenha);
		
	}
	public void CloseFrame(){
	    super.dispose();
	}
}

