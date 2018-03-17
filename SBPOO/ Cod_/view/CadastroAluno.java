package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Aluno;

public class CadastroAluno extends Janela implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar = new JMenuBar();
	private JPanel contentPane;
	private JButton btCadastrar = new JButton("Cadastrar");
	private JButton btLimparDados = new JButton("Limpar dados");
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	public CadastroAluno()  {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setJMenuBar(menuBar);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(50, 47, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMatricula.setBounds(41, 78, 65, 14);
		contentPane.add(lblMatricula);
		
		textField_1 = new JTextField();
		textField_1.setBounds(106, 46, 318, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(106, 77, 318, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCadastroAluno = new JLabel("Cadastro Aluno");
		lblCadastroAluno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCadastroAluno.setBounds(172, 11, 139, 14);
		contentPane.add(lblCadastroAluno);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\PathProjeto\\icone aluno.png"));
		lblNewLabel.setBounds(146, 11, 16, 14);
		contentPane.add(lblNewLabel);
		
		
		btCadastrar.setBounds(73, 185, 120, 23);
		contentPane.add(btCadastrar);
		btCadastrar.addActionListener(this);
		
		
		btLimparDados.setBounds(249, 185, 120, 23);
		contentPane.add(btLimparDados);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf.setBounds(63, 109, 33, 14);
		contentPane.add(lblCpf);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRg.setBounds(246, 109, 23, 14);
		contentPane.add(lblRg);
		
		textField_3 = new JTextField();
		textField_3.setBounds(106, 108, 126, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(280, 108, 144, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCurso.setBounds(50, 143, 46, 14);
		contentPane.add(lblCurso);
		
		textField_5 = new JTextField();
		textField_5.setBounds(106, 142, 318, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		btLimparDados.addActionListener(this);
	}


	public void actionPerformed(ActionEvent e) {
		if (btLimparDados==e.getSource()){
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			JOptionPane.showMessageDialog(null, "Campos de textos limpos!");
		}
		if (btCadastrar==e.getSource()){
			if(textField_3.getText().length() >= 11){
				//parametros(nome = textFiled_1,cpf = textFiled_3,matricula = textFiled_2,rg = textFiled_4)
				Aluno aluno = new Aluno(textField_1.getText(),textField_3.getText(),textField_2.getText(), textField_4.getText(),textField_5.getText());
				datea.AddAluno(aluno);
				JOptionPane.showMessageDialog(null, "Aluno Cadastrado!");
				this.dispose();
			}
			else{
				JOptionPane.showMessageDialog(null, "CAMPO CPF DEVE CONTER 11 DIGITOS");
				textField_3.setText("");
			}
		}
	}
}
