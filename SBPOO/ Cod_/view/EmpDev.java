package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ConcurrentModificationException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Emprestimo;
import model.Livro;
import javax.swing.JMenuBar;

public class EmpDev extends Janela implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblEmprestimosEDevoluo;
	private JButton btnEmprestar;
	private JButton btnDevolver;
	private JTable table;
	private JPanel alunoEmprestimo;
	private JPanel professorEmprestimo;
	private JLabel lblCodigoProf;
	private JTextField textField_2;
	private JButton btnProfessor = new JButton("Professor");
	private JButton btnAluno = new JButton("Aluno");
	private boolean statusEmp;
	private JMenuBar menuBar;
	private int numCols;

	public EmpDev() {
		setTitle("SBPOO v3 - Emprestimo e Devolu\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblEmprestimosEDevoluo = new JLabel("Selecione o tipo:");
		lblEmprestimosEDevoluo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmprestimosEDevoluo.setBounds(116, 8, 123, 25);
		contentPane.add(lblEmprestimosEDevoluo);

		JLabel lblCodigoDoLivro = new JLabel("Codigo do livro:");
		lblCodigoDoLivro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigoDoLivro.setBounds(298, 48, 100, 19);
		contentPane.add(lblCodigoDoLivro);

		textField_1 = new JTextField();
		textField_1.setBounds(408, 47, 129, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		btnEmprestar = new JButton("Emprestar");
		btnEmprestar.setBounds(34, 97, 257, 55);
		contentPane.add(btnEmprestar);
		btnEmprestar.addActionListener(this);

		btnDevolver = new JButton("Devolver");
		btnDevolver.setBounds(298, 97, 257, 55);
		contentPane.add(btnDevolver);
		btnDevolver.addActionListener(this);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 176, 521, 160);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome do livro", "Codigo", "Quantidade" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(300);
		scrollPane.setViewportView(table);

		professorEmprestimo = new JPanel();
		professorEmprestimo.setBounds(23, 44, 272, 31);
		contentPane.add(professorEmprestimo);
		professorEmprestimo.setVisible(false);

		lblCodigoProf = new JLabel("Codigo do professor:");
		professorEmprestimo.add(lblCodigoProf);
		lblCodigoProf.setFont(new Font("Tahoma", Font.PLAIN, 14));

		textField_2 = new JTextField();
		professorEmprestimo.add(textField_2);
		textField_2.setColumns(10);

		alunoEmprestimo = new JPanel();
		alunoEmprestimo.setBounds(23, 44, 272, 31);
		contentPane.add(alunoEmprestimo);
		alunoEmprestimo.setVisible(false);

		JLabel lblMatriculaDoAluno = new JLabel("Matricula do aluno:");
		lblMatriculaDoAluno.setLocation(0, 6);
		alunoEmprestimo.add(lblMatriculaDoAluno);
		lblMatriculaDoAluno.setFont(new Font("Tahoma", Font.PLAIN, 14));

		textField = new JTextField();
		alunoEmprestimo.add(textField);
		textField.setColumns(10);

		btnAluno.setBounds(255, 9, 107, 23);
		contentPane.add(btnAluno);
		btnAluno.addActionListener(this);

		btnProfessor.setBounds(386, 9, 107, 23);
		contentPane.add(btnProfessor);
		btnProfessor.addActionListener(this);

		numCols = table.getModel().getColumnCount();
		for (Livro livro : datel.livros) {
			Object[] fila = new Object[numCols];
			fila[0] = livro.getNome();
			fila[1] = livro.getCodigo_livro();
			fila[2] = livro.getQtLivros();
			((DefaultTableModel) table.getModel()).addRow(fila);
		}
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = table.getSelectedRow();
				textField_1.setText((String) table.getValueAt(linha, 1).toString());

			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAluno) {
			alunoEmprestimo.setVisible(true);
			professorEmprestimo.setVisible(false);
			textField_2.setText("");
			statusEmp = true;

		}
		if (e.getSource() == btnProfessor) {
			alunoEmprestimo.setVisible(false);
			professorEmprestimo.setVisible(true);
			textField.setText("");
			statusEmp = false;
		}
		if (e.getSource() == btnEmprestar) {
			if (statusEmp) {
				int qt = datel.qtLivros(textField_1.getText());
				if (datea.checkAluno(textField.getText())) {
					if (qt > 1) {
						String nome_aluno = datea.retornaNome(textField.getText());
						Emprestimo emprestimo = new Emprestimo(nome_aluno, textField.getText(), textField_1.getText(),
								"Aluno");
						emprestimos.add(emprestimo);
						datea.alterarEmprestimoFalse(textField.getText());
						for (Livro livro : datel.livros) {
							if (textField_1.getText().equals(livro.getCodigo_livro())) {
								livro.setQtLivros(livro.getQtLivros() - 1);
							}
						}
						JOptionPane.showMessageDialog(null, "Emprestimo concluido!");
						this.dispose();
						frameEmprestimo = new EmpDev();
						frameEmprestimo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						frameEmprestimo.setVisible(true);
						frameEmprestimo.setLocationRelativeTo(null);
					} else {
						JOptionPane.showMessageDialog(null, "Livro indisponivel para emprestimo!");
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"O aluno não pode pegar mais um livro emprestado, devolva o outro primeiro!");
				}
			} else {
				int qt = datel.qtLivros(textField_1.getText());
				if (datep.checkProfessor(textField_2.getText())) {
					if (qt > 1) {
						String nome_professor = datep.retornaNome(textField_2.getText());
						Emprestimo emprestimo = new Emprestimo(nome_professor, textField_2.getText(),
								textField_1.getText(), "Professor");
						emprestimos.add(emprestimo);
						datep.adicionarCont(textField_2.getText());
						for (Livro livro : datel.livros) {
							if (textField_1.getText().equals(livro.getCodigo_livro())) {
								livro.setQtLivros(livro.getQtLivros() - 1);
							}
						}
						JOptionPane.showMessageDialog(null, "Emprestimo concluido!");
						this.dispose();
						frameEmprestimo = new EmpDev();
						frameEmprestimo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						frameEmprestimo.setVisible(true);
						frameEmprestimo.setLocationRelativeTo(null);
						
					} else {
						JOptionPane.showMessageDialog(null, "Livro indisponivel para emprestimo!");
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"O professor não pode pegar mais um livro emprestado, devolva o outro primeiro!");
				}
			}
		}

		if (e.getSource() == btnDevolver) {
			if (statusEmp) {
				for (Emprestimo emprestimo : emprestimos) {
					if (emprestimo.getMatricula_aluno().equals(textField.getText())) {
						try {
							emprestimos.remove(emprestimo);
							datea.alterarEmprestimoTrue(textField.getText());
							for (Livro livro : datel.livros) {
								if (textField_1.getText().equals(livro.getCodigo_livro())) {
									livro.setQtLivros(livro.getQtLivros() + 1);
									System.err.println(livro.getQtLivros());
									JOptionPane.showMessageDialog(null, "Livro devolvido, Obrigado!");
									this.dispose();
									frameEmprestimo = new EmpDev();
									frameEmprestimo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
									frameEmprestimo.setVisible(true);
									frameEmprestimo.setLocationRelativeTo(null);
								}
							}
						} catch (ConcurrentModificationException e55) {
							System.out.println("Error linha 217 -- btn Devolver");
						}

					}
				}

			} else {

				try {
					for (Emprestimo emprestimo : emprestimos) {
						if ((emprestimo.getCodigo_livro().equals(textField_1.getText()))
								&& (emprestimo.getMatricula_aluno().equals(textField_2.getText()))) {
							emprestimos.remove(emprestimo);
							datep.removeCont(textField_2.getText());
							for (Livro livro : datel.livros) {
								if (textField_1.getText().equals(livro.getCodigo_livro())) {
									livro.setQtLivros(livro.getQtLivros() + 1);
									JOptionPane.showMessageDialog(null, "Livro devolvido, Obrigado!");
									this.dispose();
									frameEmprestimo = new EmpDev();
									frameEmprestimo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
									frameEmprestimo.setVisible(true);
									frameEmprestimo.setLocationRelativeTo(null);
								}
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"Não foram encontrados emprestimos desse livro nesta matricula!");
						}

					}
				} catch (ConcurrentModificationException e56) {
					System.out.println("Livro devolvido - exception line 240");
				} catch (IndexOutOfBoundsException e61) {
					System.out.println("linha 247 -- btn Devolver ");
				}

			}
		}
	}
}
