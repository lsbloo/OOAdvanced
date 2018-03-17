package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Data_Aluno;
import control.Data_Livro;
import control.Data_Professor;
import model.Emprestimo;
import model.Enum_IO;
import model.Strategy;

public class Janela extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuCadastro = new JMenu("Cadastrar");
	private JMenuItem btAluno = new JMenuItem("Aluno");
	private JMenuItem btLivro = new JMenuItem("Livro");
	private JMenuItem btProfessor = new JMenuItem("Professor");
	private JMenu menuEmprestimo = new JMenu("Emprestimo");
	private JMenuItem btEmprestarLivro = new JMenuItem("Emprestar/Devolver");
	private JMenu menuBuscar = new JMenu("Buscar");
	private JMenuItem btBuscar = new JMenuItem("Buscar");
	private JMenuItem btEditarAluno = new JMenuItem("Aluno");
	private JMenu menuEditar = new JMenu("Editar");
	private JMenuItem btEditarProfessor = new JMenuItem("Professor");
	private JMenuItem mntmtxt = new JMenuItem(".txt");
	protected JButton btConcluirEdicao = new JButton("Concluir Edi\u00E7\u00E3o\t");
	protected EmpDev frameEmprestimo;
	protected EditarAluno janelaEditarAluno;
	protected EditarProfessor janelaEditarProfessor;

	/*
	 * 
	 */
	static Data_Aluno datea = new Data_Aluno();
	static Data_Professor datep = new Data_Professor();
	static Data_Livro datel = new Data_Livro();
	static LinkedList<Emprestimo> emprestimos = new LinkedList<Emprestimo>();

	public Janela() {
		setTitle("Biblioteca Universit\u00E1ria v3.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		this.setJMenuBar(menuBar);

		menuBar.add(menuCadastro);

		btAluno.setIcon(new ImageIcon("C:\\PathProjeto\\icone aluno.png"));
		menuCadastro.add(btAluno);
		btAluno.addActionListener(this);

		btLivro.setIcon(new ImageIcon("C:\\PathProjeto\\icone livro add.png"));
		menuCadastro.add(btLivro);
		btLivro.addActionListener(this);

		btProfessor.setIcon(new ImageIcon("C:\\PathProjeto\\icone professores.png"));
		menuCadastro.add(btProfessor);
		btProfessor.addActionListener(this);

		menuBar.add(menuEditar);

		btEditarAluno.setIcon(new ImageIcon("C:\\PathProjeto\\aluno edit.png"));
		menuEditar.add(btEditarAluno);
		btEditarAluno.addActionListener(this);

		btEditarProfessor.setIcon(new ImageIcon("C:\\PathProjeto\\professores edit.png"));
		menuEditar.add(btEditarProfessor);
		btEditarProfessor.addActionListener(this);

		menuBar.add(menuEmprestimo);

		btEmprestarLivro.setIcon(new ImageIcon("C:\\PathProjeto\\novo emprestimo.png"));
		menuEmprestimo.add(btEmprestarLivro);
		btEmprestarLivro.addActionListener(this);

		menuBar.add(menuBuscar);

		btBuscar.setIcon(new ImageIcon("C:\\PathProjeto\\icone busca.png"));
		menuBuscar.add(btBuscar);
		btBuscar.addActionListener(this);

		JMenu mnSalvar = new JMenu("Salvar");
		menuBar.add(mnSalvar);

		mntmtxt.setIcon(new ImageIcon("C:\\PathProjeto\\icone salvar txt.png"));
		mnSalvar.add(mntmtxt);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		mntmtxt.addActionListener(this);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\PathProjeto\\BV.jpg"));
		label.setBounds(20, 11, 564, 326);
		contentPane.add(label);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btAluno) {
			CadastroAluno janelaAluno = new CadastroAluno();
			janelaAluno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			janelaAluno.setVisible(true);
			janelaAluno.setLocationRelativeTo(null);
			janelaAluno.setResizable(false);
			datea.ListarAlunos();
		}
		if (e.getSource() == btProfessor) {
			CadastroProfessor janelaProfessor = new CadastroProfessor();
			janelaProfessor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			janelaProfessor.setVisible(true);
			janelaProfessor.setLocationRelativeTo(null);
			janelaProfessor.setResizable(false);
			datep.ListarProfessor();
		}
		if (e.getSource() == btLivro) {
			CadastroLivro janelaLivro = new CadastroLivro();
			janelaLivro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			janelaLivro.setVisible(true);
			janelaLivro.setLocationRelativeTo(null);
			janelaLivro.setResizable(false);
			datel.ListarLivro();
		}
		if (e.getSource() == btEditarAluno) {
			janelaEditarAluno = new EditarAluno();
			janelaEditarAluno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			janelaEditarAluno.setVisible(true);
			janelaEditarAluno.setLocationRelativeTo(null);
			janelaEditarAluno.setResizable(false);
		}
		if (e.getSource() == btEditarProfessor) {

			janelaEditarProfessor = new EditarProfessor();
			janelaEditarProfessor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			janelaEditarProfessor.setVisible(true);
			janelaEditarProfessor.setResizable(false);
			janelaEditarProfessor.setLocationRelativeTo(null);
		}
		if (e.getSource() == mntmtxt) {
			JOptionPane.showMessageDialog(null, "Dados Salvos!");

			Enum_IO tipo2 = Enum_IO.values()[1];
			Strategy saida2 = tipo2.obterIO();
			saida2.armazenarIO();
			datel.armazenarIO();

			datep.armazenarIO();
			datea.armazenarIO();
			System.out.println(Enum_IO.values()[0]);

		}
		if (e.getSource() == btEmprestarLivro) {
			frameEmprestimo = new EmpDev();
			frameEmprestimo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frameEmprestimo.setVisible(true);
			frameEmprestimo.setResizable(false);
			frameEmprestimo.setLocationRelativeTo(null);
		}

		if (e.getSource() == btBuscar) {

			Buscar janelaBuscar = new Buscar();
			janelaBuscar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			janelaBuscar.setVisible(true);
			janelaBuscar.setResizable(false);
			janelaBuscar.setLocationRelativeTo(null);
		}
	}
}
