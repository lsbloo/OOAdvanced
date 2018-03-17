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
import model.Livro;
import model.Professor;

public class Buscar extends Janela implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelBuscarAluno = new JPanel();
	private JPanel panelBuscarLivro = new JPanel();
	private JPanel panelBuscarProfessor = new JPanel();
	private final JTextField textField = new JTextField();
	private final JLabel lblNome = new JLabel("Nome:");
	private final JLabel labelNome = new JLabel("");
	private final JLabel labelCPF = new JLabel("");
	private final JLabel labelRG = new JLabel("");
	private final JLabel labelCurso = new JLabel("");
	private final JLabel labelMatricula = new JLabel("");
	private final JButton btBuscarAluno = new JButton("");
	private final JLabel lblBuscarProfessor = new JLabel("Buscar Professor");
	private final JTextField textField_1 = new JTextField();
	private final JLabel label_1 = new JLabel("Nome:");
	private final JLabel labelNomeP = new JLabel("");
	private final JLabel labelCPFp = new JLabel("");
	private final JLabel labelRGp = new JLabel("");
	private final JLabel labelCursoP = new JLabel("");
	private final JLabel labelCodP = new JLabel("");
	private final JButton btBuscarProf = new JButton("");
	private final JPanel panelSelect = new JPanel();
	private final JButton button = new JButton("Aluno");
	private final JButton button_1 = new JButton("Professor");
	private final JButton button_2 = new JButton("Livro");
	private final JLabel label = new JLabel("Selecione o que deseja buscar:");
	private final JButton btInicial_2 = new JButton("");
	private final JButton btInicial = new JButton("");
	private final JLabel lblBuscarLivro = new JLabel("Buscar Livro");
	private final JTextField textField_2 = new JTextField();
	private final JLabel label_3 = new JLabel("Nome:");
	private final JLabel lblNomeLivro = new JLabel("");
	private final JLabel lblQtLivros = new JLabel("");
	private final JLabel lblCodigoLivro = new JLabel("");
	private final JLabel lblAutores = new JLabel("");
	private final JLabel lblDataLanc = new JLabel("");
	private final JButton btBuscarLivro = new JButton("");
	private final JButton btInicial_3 = new JButton("");

	public Buscar() {
		setTitle("SBPOO v3.0 - Busca\t");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panelBuscarLivro.setBounds(0, 0, 414, 217);
		contentPane.add(panelBuscarLivro);
		panelBuscarLivro.setLayout(null);
		lblBuscarLivro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuscarLivro.setBounds(152, 11, 79, 17);

		panelBuscarLivro.add(lblBuscarLivro);
		textField_2.setColumns(10);
		textField_2.setBounds(76, 50, 262, 30);

		panelBuscarLivro.add(textField_2);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(23, 52, 60, 22);

		panelBuscarLivro.add(label_3);
		lblNomeLivro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeLivro.setBounds(23, 101, 318, 30);

		panelBuscarLivro.add(lblNomeLivro);
		lblQtLivros.setBounds(18, 142, 113, 30);

		panelBuscarLivro.add(lblQtLivros);
		lblCodigoLivro.setBounds(149, 142, 113, 30);

		panelBuscarLivro.add(lblCodigoLivro);
		lblAutores.setBounds(18, 177, 243, 30);

		panelBuscarLivro.add(lblAutores);
		lblDataLanc.setBounds(280, 142, 113, 30);

		panelBuscarLivro.add(lblDataLanc);
		btBuscarLivro.addActionListener(this);
		btBuscarLivro.setIcon(new ImageIcon("C:\\PathProjeto\\icone busca.png"));
		btBuscarLivro.setBounds(348, 50, 35, 30);

		panelBuscarLivro.add(btBuscarLivro);
		btInicial_3.setIcon(new ImageIcon("C:\\PathProjeto\\home.png"));
		btInicial_3.setBounds(348, 177, 35, 30);

		panelBuscarLivro.add(btInicial_3);
		panelBuscarLivro.setVisible(false);
		textField.setBounds(76, 50, 262, 30);
		textField.setColumns(10);

		panelBuscarAluno.setBounds(10, 11, 414, 218);
		contentPane.add(panelBuscarAluno);
		panelBuscarAluno.setLayout(null);
		panelBuscarAluno.setVisible(false);

		JLabel lblBuscarAluno = new JLabel("Buscar Aluno");
		lblBuscarAluno.setBounds(152, 11, 79, 17);
		lblBuscarAluno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelBuscarAluno.add(lblBuscarAluno);

		panelBuscarAluno.add(textField);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(23, 52, 60, 22);

		panelBuscarAluno.add(lblNome);
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelNome.setBounds(23, 101, 318, 30);

		panelBuscarAluno.add(labelNome);
		labelCPF.setBounds(18, 142, 113, 30);

		panelBuscarAluno.add(labelCPF);
		labelRG.setBounds(149, 142, 113, 30);

		panelBuscarAluno.add(labelRG);
		labelCurso.setBounds(18, 177, 243, 30);

		panelBuscarAluno.add(labelCurso);
		labelMatricula.setBounds(280, 142, 113, 30);

		panelBuscarAluno.add(labelMatricula);
		btBuscarAluno.setIcon(new ImageIcon("C:\\PathProjeto\\icone busca.png"));
		btBuscarAluno.setBounds(348, 50, 35, 30);
		btBuscarAluno.addActionListener(this);

		panelBuscarAluno.add(btBuscarAluno);
		btInicial_2.setIcon(new ImageIcon("C:\\PathProjeto\\home.png"));
		btInicial_2.setBounds(348, 177, 35, 30);
		btInicial_2.addActionListener(this);

		panelBuscarAluno.add(btInicial_2);

		panelBuscarProfessor.setBounds(10, 11, 414, 218);
		contentPane.add(panelBuscarProfessor);
		panelBuscarProfessor.setLayout(null);
		lblBuscarProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuscarProfessor.setBounds(136, 11, 142, 17);

		panelBuscarProfessor.add(lblBuscarProfessor);
		textField_1.setColumns(10);
		textField_1.setBounds(76, 50, 262, 30);

		panelBuscarProfessor.add(textField_1);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(23, 52, 60, 22);

		panelBuscarProfessor.add(label_1);
		labelNomeP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelNomeP.setBounds(23, 101, 318, 30);

		panelBuscarProfessor.add(labelNomeP);
		labelCPFp.setBounds(18, 142, 113, 30);

		panelBuscarProfessor.add(labelCPFp);
		labelRGp.setBounds(149, 142, 113, 30);

		panelBuscarProfessor.add(labelRGp);
		labelCursoP.setBounds(18, 177, 243, 30);

		panelBuscarProfessor.add(labelCursoP);
		labelCodP.setBounds(280, 142, 113, 30);

		panelBuscarProfessor.add(labelCodP);
		btBuscarProf.setIcon(new ImageIcon("C:\\PathProjeto\\icone busca.png"));
		btBuscarProf.setBounds(348, 50, 35, 30);
		btBuscarProf.addActionListener(this);

		panelBuscarProfessor.add(btBuscarProf);
		btInicial.setIcon(new ImageIcon("C:\\PathProjeto\\home.png"));
		btInicial.setBounds(348, 177, 35, 30);
		btInicial.addActionListener(this);

		panelBuscarProfessor.add(btInicial);
		panelBuscarProfessor.setVisible(false);
		panelSelect.setBounds(0, 0, 434, 239);

		contentPane.add(panelSelect);
		panelSelect.setLayout(null);
		button.setBounds(17, 88, 122, 45);
		panelSelect.add(button);
		button_1.setBounds(156, 87, 122, 45);
		panelSelect.add(button_1);
		button_2.setBounds(295, 88, 122, 45);
		panelSelect.add(button_2);
		label.setBounds(120, 26, 195, 45);
		panelSelect.add(label);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.addActionListener(this);
		button_1.addActionListener(this);
		button_2.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			panelBuscarAluno.setVisible(true);
			panelBuscarProfessor.setVisible(false);
			panelBuscarLivro.setVisible(false);
			panelSelect.setVisible(false);

		}
		if (e.getSource() == button_1) {
			panelBuscarProfessor.setVisible(true);
			panelBuscarLivro.setVisible(false);
			panelBuscarAluno.setVisible(false);
			panelSelect.setVisible(false);

		}
		if (e.getSource() == button_2) {
			panelBuscarLivro.setVisible(true);
			panelBuscarProfessor.setVisible(false);
			panelBuscarAluno.setVisible(false);
			panelSelect.setVisible(false);
		}
		if (e.getSource() == btInicial || e.getSource() == btInicial_2) {
			panelBuscarLivro.setVisible(false);
			panelBuscarProfessor.setVisible(false);
			panelBuscarAluno.setVisible(false);
			panelSelect.setVisible(true);
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
		}
		if (e.getSource() == btBuscarAluno) {
			if (datea.checkAlunoNome(textField.getText())) {
				Aluno temp = datea.buscarObjetoAluno(textField.getText());
				labelNome.setText("Nome: " + temp.getNome());
				labelCPF.setText("CPF: " + temp.getCpf());
				labelRG.setText("RG: " + temp.getRg());
				labelCurso.setText("Curso: " + temp.getCurso());
				labelMatricula.setText("Matricula: " + temp.getMatricula());
			} else {
				JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
			}
		}
		if (e.getSource() == btBuscarProf) {
			if (datep.checkProfessor2(textField_1.getText())) {
				Professor temp1 = datep.buscarObjetoProfessor(textField_1.getText());
				labelNomeP.setText("Nome: " + temp1.getNome());
				labelCPFp.setText("CPF: " + temp1.getCpf());
				labelRGp.setText("RG: " + temp1.getRg());
				labelCursoP.setText("Curso: " + temp1.getCurso());
				labelCodP.setText("Codigo: " + temp1.getCodigo());
			} else {
				JOptionPane.showMessageDialog(null, "Professor não encontrado!");
				}
			}
		if (e.getSource() == btBuscarLivro) {
			if (datel.BuscarLivro(textField_2.getText())) {
				Livro temp2 = datel.buscarObjetoLivro(textField_2.getText());
				lblNomeLivro.setText("Nome: " + temp2.getNome());
				lblQtLivros.setText("Qt. Livros: " + temp2.getQtLivros());
				lblCodigoLivro.setText("Codigo: " + temp2.getCodigo_livro());
				lblAutores.setText("Autores: " + temp2.getAutor());
				lblDataLanc.setText("Data Lanç: " + temp2.getData_lancamento());
			} else {
				JOptionPane.showMessageDialog(null, "Livro não encontrado!");
			}
		}
	}
}
