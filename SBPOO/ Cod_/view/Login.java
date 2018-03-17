package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.Data_ADM;
import model.Administrador;

public class Login extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnEntrar = new JButton("Entrar ");
	public Data_ADM date = new Data_ADM();
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JButton btnCadastrar = new JButton("Cadastrar");
	private JMenuItem mntmCadastrarAdm = new JMenuItem("Cadastrar ADM");;
	private JPanel panel = new JPanel();
	private JMenuItem mntmLogin = new JMenuItem("Login");
	private JPanel panelLogin = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setResizable(false);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("SBPOO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 248);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		
		mnCadastro.add(mntmCadastrarAdm);
		mntmCadastrarAdm.addActionListener(this);
		
		
		mnCadastro.add(mntmLogin);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		mntmLogin.addActionListener(this);		
		
		contentPane.setLayout(null);
		
		
		panelLogin.setBounds(0, 0, 402, 191);
		contentPane.add(panelLogin);
		panelLogin.setLayout(null);
		
				JLabel lblNome = new JLabel("Nome:");
				lblNome.setBounds(27, 53, 53, 14);
				panelLogin.add(lblNome);
				
						textField = new JTextField();
						textField.setBounds(74, 50, 301, 20);
						panelLogin.add(textField);
						textField.setColumns(10);
						
								JLabel lblSenha = new JLabel("Senha:");
								lblSenha.setBounds(27, 100, 51, 14);
								panelLogin.add(lblSenha);
								
										passwordField = new JPasswordField();
										passwordField.setBounds(74, 96, 301, 23);
										panelLogin.add(passwordField);
										
												JLabel lblLogin = new JLabel("Login");
												lblLogin.setBounds(182, 24, 46, 26);
												panelLogin.add(lblLogin);
												lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
												btnEntrar.setBounds(148, 131, 107, 37);
												panelLogin.add(btnEntrar);
												btnEntrar.addActionListener(this);
		
		
		panel.setBounds(0, 0, 402, 191);
		contentPane.add(panel);
		panel.setVisible(false);
		panel.setLayout(null);
		
				textField_1 = new JTextField();
				textField_1.setBounds(99, 40, 303, 20);
				panel.add(textField_1);
				textField_1.setColumns(10);
				
						textField_2 = new JTextField();
						textField_2.setBounds(99, 71, 303, 20);
						panel.add(textField_2);
						textField_2.setColumns(10);
						
								passwordField_1 = new JPasswordField();
								passwordField_1.setBounds(99, 102, 303, 20);
								panel.add(passwordField_1);
								
										JLabel lblSenhaPadro = new JLabel("Senha padr\u00E3o:");
										lblSenhaPadro.setBounds(0, 133, 91, 14);
										panel.add(lblSenhaPadro);
										
												passwordField_2 = new JPasswordField();
												passwordField_2.setBounds(99, 133, 303, 20);
												panel.add(passwordField_2);
												
														JLabel lblSenha_1 = new JLabel("Senha:");
														lblSenha_1.setBounds(47, 105, 47, 14);
														panel.add(lblSenha_1);
														
																JLabel lblLogin_1 = new JLabel("Login:");
																lblLogin_1.setBounds(47, 71, 42, 14);
																panel.add(lblLogin_1);
																
																		JLabel lblNome_1 = new JLabel("Nome:");
																		lblNome_1.setBounds(47, 40, 42, 14);
																		panel.add(lblNome_1);
																		btnCadastrar.setBounds(160, 157, 114, 23);
																		panel.add(btnCadastrar);
																		
																		JLabel lblCadastroDeUsuario = new JLabel("Cadastro de Usuario");
																		lblCadastroDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
																		lblCadastroDeUsuario.setBounds(143, 0, 149, 32);
																		panel.add(lblCadastroDeUsuario);
																		btnCadastrar.addActionListener(this);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmCadastrarAdm){
			panel.setVisible(true);
			panelLogin.setVisible(false);
		}
		if (e.getSource() == mntmLogin){
			panel.setVisible(false);
			panelLogin.setVisible(true);
		}
		if (e.getSource() == btnEntrar) {
			try {
				date.realizarAcesso(textField.getText(), passwordField.getText());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			System.out.println(date.Acesso());
			if (date.Acesso()) {
				Janela janela = new Janela();
				janela.setVisible(true);
				janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				janela.setLocationRelativeTo(null);
				janela.setResizable(false);
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Senha incorreta, tente novamente!");
				passwordField.setText("");
			}
		}
		if (e.getSource() == btnCadastrar) {
			if (passwordField_2.getText().equals("49946325")) {
				Administrador adm = new Administrador(textField_2.getText(), passwordField_1.getText(),
						textField_1.getText());
				date.addAdm(adm);
				JOptionPane.showMessageDialog(null, "Administrador cadastrado com sucesso!");
				panel.setVisible(false);
				panelLogin.setVisible(true);
				textField_1.setText("");
				textField_2.setText("");
				passwordField_1.setText("");
				passwordField_2.setText("");
				
			} else {
				JOptionPane.showMessageDialog(null, "Senha do sistema incorreta! \n Usuario não cadastrado.");
			}
		}

	}
}
