package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Professor;

public class EditarProfessor extends Janela implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private String nome_temp;

	public EditarProfessor() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 325);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 35, 463, 121);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(25, 170, 47, 14);

		JLabel lblMatricula = new JLabel("Codigo:");
		lblMatricula.setBounds(15, 204, 57, 14);

		textField = new JTextField();
		textField.setBounds(76, 167, 208, 20);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(77, 201, 207, 20);
		textField_1.setColumns(10);

		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(25, 238, 41, 14);

		textField_2 = new JTextField();
		textField_2.setBounds(76, 235, 208, 20);
		textField_2.setColumns(10);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(311, 170, 34, 14);

		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(311, 204, 34, 14);

		textField_3 = new JTextField();
		textField_3.setBounds(344, 167, 127, 20);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(345, 201, 126, 20);
		textField_4.setColumns(10);

		btConcluirEdicao.setBounds(344, 235, 126, 23);
		btConcluirEdicao.addActionListener(this);
		DefaultTableModel modelo = new DefaultTableModel();
		contentPane.setLayout(null);
		table = new JTable(modelo);
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Matricula", "Curso", "CPF", "RG" }));
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
		contentPane.add(lblCurso);
		contentPane.add(textField_2);
		contentPane.add(lblMatricula);
		contentPane.add(textField_1);
		contentPane.add(lblNome);
		contentPane.add(textField);
		contentPane.add(lblCpf);
		contentPane.add(textField_3);
		contentPane.add(lblRg);
		contentPane.add(btConcluirEdicao);
		contentPane.add(textField_4);

		JLabel lblEditProfessores = new JLabel("Edi\u00E7\u00E3o de Professores");
		lblEditProfessores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEditProfessores.setBounds(176, 10, 140, 14);
		contentPane.add(lblEditProfessores);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Kalber Roberto\\workspace\\test1\\aluno edit.png"));
		label.setBounds(168, 10, 16, 14);
		contentPane.add(label);
		int numCols = table.getModel().getColumnCount();
		for (Professor professor : datep.professores) {
			Object[] fila = new Object[numCols];
			fila[0] = professor.getNome();
			fila[1] = professor.getCodigo();
			fila[2] = professor.getCurso();
			fila[3] = professor.getCpf();
			fila[4] = professor.getRg();
			((DefaultTableModel) table.getModel()).addRow(fila);
		}
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = table.getSelectedRow();
				nome_temp=table.getValueAt(linha, 0).toString();
				textField.setText((String) table.getValueAt(linha, 0).toString());
				textField_1.setText((String) table.getValueAt(linha, 1).toString());
				textField_2.setText((String) table.getValueAt(linha, 2).toString());
				textField_3.setText((String) table.getValueAt(linha, 3).toString());
				textField_4.setText((String) table.getValueAt(linha, 4).toString());
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btConcluirEdicao){
			Professor professor = new Professor(textField.getText(),textField_3.getText(),textField_1.getText(), textField_4.getText(),textField_2.getText());
			datep.alterarProfessor(nome_temp, professor);
			nome_temp="";
			JOptionPane.showMessageDialog(null, "Professor alterado com sucesso.");
			this.dispose();
			janelaEditarProfessor = new EditarProfessor();
			janelaEditarProfessor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			janelaEditarProfessor.setVisible(true);
			janelaEditarProfessor.setLocationRelativeTo(null);
		}
	}

}
