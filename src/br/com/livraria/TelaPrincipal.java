package br.com.livraria;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;


public class TelaPrincipal extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Livro l = new Livro();
	BancoLivraria banco = new BancoLivraria();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {

		ArrayList<Livro> Livros = new ArrayList<>();

		setTitle("Instituto Federal do Rio Grande do Sul - Campus Restinga");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 306);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// -----------------------------------------
		
		ImageIcon imagem = new ImageIcon(getClass().getResource("livro.png"));
		JLabel imagemLivro = new JLabel(imagem);
		imagemLivro.setBounds(254, -19, 180, 301);
		contentPane.add(imagemLivro);

		// -----------------------------------------
		
		JLabel txtOpcao1 = new JLabel("Cadastrar Livro");
		txtOpcao1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		txtOpcao1.setBounds(86, 20, 193, 39);
		contentPane.add(txtOpcao1);

		JLabel txtOpcao2 = new JLabel("Listar Livros");
		txtOpcao2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		txtOpcao2.setBounds(86, 49, 193, 39);
		contentPane.add(txtOpcao2);

		JLabel txtOpcao3 = new JLabel("Pesquisar por Nome");
		txtOpcao3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		txtOpcao3.setBounds(86, 81, 193, 39);
		contentPane.add(txtOpcao3);

		JLabel txtOpcao4 = new JLabel("Pesquisar por Categoria");
		txtOpcao4.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		txtOpcao4.setBounds(86, 110, 193, 45);
		contentPane.add(txtOpcao4);

		JLabel txtOpcao5 = new JLabel("Pesquisar por Preço");
		txtOpcao5.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		txtOpcao5.setBounds(86, 148, 193, 39);
		contentPane.add(txtOpcao5);
		
		JLabel txtOpcao6 = new JLabel("Deletar Livro");
		txtOpcao6.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		txtOpcao6.setBounds(86, 182, 193, 39);
		contentPane.add(txtOpcao6);
		
		JLabel OpcaoSair = new JLabel("Sair");
		OpcaoSair.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		OpcaoSair.setBounds(86, 215, 193, 39);
		contentPane.add(OpcaoSair);
		
		// -----------------------------------------
		
		JButton btOpcao1 = new JButton("1");
		btOpcao1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				banco.addLivro(l);
				banco.addNoBanco(l);
			}

			
		});
		btOpcao1.setBounds(25, 29, 51, 23);
		contentPane.add(btOpcao1);
		
		// -----------------------------------------
		
		JButton btOpcao2 = new JButton("2");
		btOpcao2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				banco.listar(l);
			} 
		});
		btOpcao2.setBounds(25, 58, 51, 23);
		contentPane.add(btOpcao2);
		
		// -----------------------------------------

		JButton btOpcao3 = new JButton("3");
		btOpcao3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String buscaLivro = JOptionPane.showInputDialog("Título do livro:");
				banco.buscarLivro_Nome(l, buscaLivro);	
			}

		});
		btOpcao3.setBounds(25, 90, 51, 23);
		contentPane.add(btOpcao3);
		
		// -----------------------------------------

		JButton btOpcao4 = new JButton("4");
		btOpcao4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String buscaCategoria = JOptionPane.showInputDialog("Nome da categoria:");
					banco.buscarLivro_Categoria(l, buscaCategoria);
			}

		});
		btOpcao4.setBounds(25, 122, 51, 23);
		contentPane.add(btOpcao4);

		// -----------------------------------------
		
		JButton btOpcao5 = new JButton("5");
		btOpcao5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double buscaPreco = Integer.parseInt(JOptionPane
						.showInputDialog("Digite um Valor \n(irá listar livros abaixo do valor digitado)"));
				banco.buscarLivro_Valor(l, buscaPreco);
			}

		});
		btOpcao5.setBounds(25, 157, 51, 23);
		contentPane.add(btOpcao5);
		
		// -----------------------------------------
		
		JButton btOpcao6 = new JButton("6");
		btOpcao6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do Livro que deseja Deletar!"));
				banco.deletar(l, numero);
			}
		});
		btOpcao6.setBounds(25, 191, 51, 23);
		contentPane.add(btOpcao6);
		
		// -----------------------------------------
		
		
		JButton btOpcao6_1 = new JButton("0");
		btOpcao6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Programa Finalizado", "Volte Sempre", JOptionPane.CLOSED_OPTION);
				TelaPrincipal.this.setVisible(false);
				System.exit(0);
			}
		});
		btOpcao6_1.setBounds(25, 225, 51, 23);
		contentPane.add(btOpcao6_1);

	}
}
