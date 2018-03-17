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

import model.Livro;

public class CadastroLivro extends Janela implements ActionListener {
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

	public CadastroLivro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setJMenuBar(menuBar);

		JLabel lblNome = new JLabel("Nome do Livro:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(0, 47, 96, 14);
		contentPane.add(lblNome);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigo.setBounds(41, 78, 65, 19);
		contentPane.add(lblCodigo);

		textField_1 = new JTextField();
		textField_1.setBounds(106, 46, 318, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(106, 77, 318, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblCadastroLivro = new JLabel("Cadastro Livro");
		lblCadastroLivro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCadastroLivro.setBounds(172, 11, 139, 14);
		contentPane.add(lblCadastroLivro);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Kalber Roberto\\workspace\\test1\\icone livro add.png"));
		lblNewLabel.setBounds(146, 11, 16, 14);
		contentPane.add(lblNewLabel);

		btCadastrar.setBounds(73, 185, 120, 23);
		contentPane.add(btCadastrar);
		btCadastrar.addActionListener(this);

		btLimparDados.setBounds(249, 185, 120, 23);
		contentPane.add(btLimparDados);

		JLabel lblQtLivros = new JLabel("Quant. Livros :");
		lblQtLivros.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQtLivros.setBounds(0, 109, 96, 19);
		contentPane.add(lblQtLivros);

		JLabel lblRg = new JLabel("Data Lan\u00E7.:");
		lblRg.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblRg.setBounds(243, 109, 68, 14);
		contentPane.add(lblRg);

		textField_3 = new JTextField();
		textField_3.setBounds(106, 108, 126, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(319, 108, 105, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblAutor = new JLabel("Autor :");
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAutor.setBounds(50, 143, 46, 14);
		contentPane.add(lblAutor);

		textField_5 = new JTextField();
		textField_5.setBounds(106, 142, 318, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		btLimparDados.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (btLimparDados == e.getSource()) {
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			JOptionPane.showMessageDialog(null, "Campos de textos limpos!");
		}
		if (btCadastrar == e.getSource()) {
			Livro livro = new Livro(textField_1.getText(), textField_2.getText(), Integer.parseInt(textField_3.getText()),textField_4.getText(), textField_5.getText());
				datel.addLivro(livro);
				JOptionPane.showMessageDialog(null, "Livro Cadastrado!");
				this.dispose();
			}
		}
	}

