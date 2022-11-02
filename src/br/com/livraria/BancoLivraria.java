package br.com.livraria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import br.com.livraria.Livro;
import br.com.livraria.ConectaBancoDeDados;

public class BancoLivraria {
	
	Livro l = new Livro();
	
	BancoLivraria () {
	
	}
	
	public void addLivro (Livro l) {
		l.setTitulo(JOptionPane.showInputDialog("Título:"));
		l.setEditora(JOptionPane.showInputDialog("Editora:"));
		l.setArea(JOptionPane.showInputDialog("Categoria:"));
		int ano = Integer.parseInt(JOptionPane.showInputDialog("Ano:"));
		l.setAno(ano);
		double valor = Integer.parseInt(JOptionPane.showInputDialog("Valor:"));
		l.setValor(valor);
		JOptionPane.showMessageDialog(null, "Livro Cadastrado no Banco de Dados com Sucesso!");
	}
	
	public void addNoBanco(Livro livro) {
		String add = "INSERT INTO livro (titulo, editora, categoria, ano, valor) VALUES (?,?,?,?,?)";
		Connection con = null;
		PreparedStatement prepared = null;
		
		try {
			con = ConectaBancoDeDados.conexao();
			prepared = con.prepareStatement(add);
			prepared.setString(1, livro.getTitulo());
			prepared.setString(2, livro.getEditora());
			prepared.setString(3, livro.getArea());
			prepared.setInt(4, livro.getAno());
			prepared.setDouble(5, livro.getValor());
			prepared.execute();
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	public void deletar(Livro livro, int delete) {
		String deletar = "DELETE FROM livro WHERE livro.id = ?";
		Connection con = null;
		PreparedStatement prepared = null;
		
		try {
			con = ConectaBancoDeDados.conexao();
			prepared = con.prepareStatement(deletar);
			prepared.setInt(1, delete);
			prepared.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void buscarLivro_Nome (Livro livro, String nomeLivro) {

		String buscar = "SELECT titulo FROM livro WHERE titulo = ?";
		Connection con = null;
		PreparedStatement prepared = null;
		
		try {
			con = ConectaBancoDeDados.conexao();
			prepared = con.prepareStatement(buscar);
			prepared.setString(1, nomeLivro);
			prepared.execute();
			ResultSet resultado = prepared.executeQuery();
			
			StringBuffer nameLivro = new StringBuffer();
			
			while (resultado.next()) {
				String titulo = resultado.getString("titulo");
				nameLivro.append("Livro Encontrado \n"+titulo);
			}
			
			if (nameLivro.length() == 0) {
				JOptionPane.showMessageDialog(null, "Título não encontrado!", "Tente Novamente", JOptionPane.PLAIN_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, nameLivro, "Buscar Livro por Nome", JOptionPane.PLAIN_MESSAGE);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public void buscarLivro_Categoria (Livro livro, String categoria) {
		String buscar = "SELECT id, titulo, categoria FROM livro WHERE categoria = ?";
		Connection con = null;
		PreparedStatement prepared = null;
		
		try {
			con = ConectaBancoDeDados.conexao();
			prepared = con.prepareStatement(buscar);
			prepared.setString(1, categoria);
			prepared.execute();
			ResultSet resultado = prepared.executeQuery();
			
			StringBuffer categoria1 = new StringBuffer();
			
			while (resultado.next()) {
				int id = resultado.getInt("id");
				String titulo = resultado.getString("titulo");
				categoria1.append("\n--- Livro ID ["+id+"] ---");
				categoria1.append("\nTítulo: "+titulo);
			}
			
			if (categoria1.length() == 0) {
				JOptionPane.showMessageDialog(null, "Categoria não encontrada!", "Tente Novamente", JOptionPane.PLAIN_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, categoria1, "Livros da Categoria: "+categoria, JOptionPane.PLAIN_MESSAGE);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void buscarLivro_Valor (Livro livro, double valor) {
		String buscarValor = "SELECT id, titulo, valor FROM livro WHERE valor < ?";
		Connection con = null;
		PreparedStatement prepared = null;
		
		try {
			con = ConectaBancoDeDados.conexao();
			prepared = con.prepareStatement(buscarValor);
			prepared.setDouble(1, valor);
			prepared.execute();
			ResultSet resultado = prepared.executeQuery();
			
			StringBuffer val = new StringBuffer();
			
			while (resultado.next()) {
				int id = resultado.getInt("id");
				String titulo = resultado.getString("titulo");
				double valor1 = resultado.getDouble("valor");
				val.append("\n--- Livro ID ["+id+"] ---");
				val.append("\nTítulo: "+titulo);
				val.append("\nValor: "+valor1);
			}
			
			if (val.length() == 0) {
				JOptionPane.showMessageDialog(null, "não foi encontrado nenhum livro abaixo do valor desejado!", "Tente Novamente", JOptionPane.PLAIN_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, val, "Livros abaixo de: "+valor+" R$", JOptionPane.PLAIN_MESSAGE);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void listar(Livro livro) {
		String listar = "SELECT * FROM livro";
		Connection con = null;
		PreparedStatement prepared = null;
		
		try {
			con = ConectaBancoDeDados.conexao();
			prepared = con.prepareStatement(listar);
			ResultSet resultado = prepared.executeQuery();
			StringBuffer livros = new StringBuffer();
			
			while (resultado.next()) {
				String id = resultado.getString("id");
				String titulo = resultado.getString("titulo");
				String editora = resultado.getString("editora");
				String categoria = resultado.getString("categoria");
				String ano = resultado.getString("ano");
				String valor = resultado.getString("valor");
				
				livros.append("\n");
				livros.append("   ---   Livro ID ["+id+"]   ---   ");
				livros.append("\nTítulo: "+titulo);
				livros.append("\nEditora: "+editora);
				livros.append("\nCategoria: "+categoria);
				livros.append("\nAno: "+ano);
				livros.append("\nValor: "+valor+" R$\n");
			}
			JOptionPane.showMessageDialog(null, livros, "Livros Cadastrados", JOptionPane.PLAIN_MESSAGE);
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
