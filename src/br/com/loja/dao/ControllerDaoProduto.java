package br.com.loja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.loja.controller.ProdutoController;
import br.com.loja.model.ProdutoModel;


public class ControllerDaoProduto {

	private ProdutoModel produto;
	private BaseDados baseDados = new BaseDados();
	private Connection con;
	
	public ControllerDaoProduto() {
		con = baseDados.getConnection();

	}
	
	public void incluir(ProdutoModel prod) {
		
		try {
			//Grava registro
			String sql = "INSERT INTO produto (produto, preco, qtd) VALUES ( ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, prod.getProduto());
			ps.setDouble(2, prod.getPreco());
			ps.setInt(3, prod.getQtd());
			
			ps.execute();
			
		} catch (SQLException e) {
			System.out.println("Error ao cadastrar itens!!!");
			e.printStackTrace();
		}
	}
	
	public void listar(List<ProdutoModel> produtoModel) {
		produtoModel.clear();
		
		try {
			String sql = "SELECT * FROM produto";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				produto = new ProdutoModel();
				
				produto.setIdProduto(rs.getInt("idProduto"));
				produto.setProduto(rs.getString("produto"));
				produto.setQtd(rs.getInt("qtd"));
				produto.setPreco(rs.getDouble("preco"));
				
				produtoModel.add(produto);
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao listar os dados cadastrados na BD!!!\n");
			e.printStackTrace();
		}
		
	}
	
	public void remover(int codigo) {
		try {
			String sql = "DELETE FROM produto WHERE idProduto = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, codigo);
			ps.execute();
			
		} catch (SQLException e) {
			System.out.println("Erro ao excluir dados da BD!!!\n");
			e.printStackTrace();	
		}
	}
	
}
