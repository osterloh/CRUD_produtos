package br.com.loja.model;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.loja.dao.ControllerDaoProduto;

public class TableModelProduto extends AbstractTableModel {

	private ControllerDaoProduto ctlDao = new ControllerDaoProduto();
	private List<ProdutoModel> produto;
	private String[] colunas = { "ID", "Produto", "Preco", "Quantidade" };
	private final int col_id = 0;
	private final int col_produto = 1;
	private final int col_preco = 2;
	private final int col_qtd = 3;

	public TableModelProduto(List<ProdutoModel> prod) {
		this.ctlDao.listar(prod);
		this.produto = prod;
	}

	@Override
	public String getColumnName(int indice) {
		// retorna o nome da coluna de acordo com seu indice
		return colunas[indice];
	}

	@Override
	public int getColumnCount() {
		// retorna o total de colunas da tabela
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		// retorna o total de itens(que virarao linhas) da nossa lista
		return produto.size();

	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// preenche cada celula da tabela
		
		//formata os campos da tabela para duas casa decimais e inclui o R$ na frente
		NumberFormat preco = new DecimalFormat("0.00");
		String valor = "R$ " + preco.format(produto.get(rowIndex).getPreco());

		switch (columnIndex) {
		case col_id:
			return produto.get(rowIndex).getIdProduto();

		case col_produto:
			return produto.get(rowIndex).getProduto();

		case col_preco:
			return valor;

		case col_qtd:
			return produto.get(rowIndex).getQtd();
		}

		return null;
	}

}
