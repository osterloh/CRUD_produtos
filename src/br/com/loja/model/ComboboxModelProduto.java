package br.com.loja.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.text.AbstractDocument.Content;

public class ComboboxModelProduto extends AbstractListModel implements ComboBoxModel{
	
	private List<ProdutoModel> produtos = new ArrayList<ProdutoModel>();
	private ProdutoModel produtoModel;
	
	public ComboboxModelProduto(List<ProdutoModel> produto) {
		this.produtos = produto;
		
	}

	@Override
	public Object getElementAt(int index) {
		// Retorna um pbjeto da lista com forme o index que foi passado
		return this.produtos.get(index);
	}

	@Override
	public int getSize() {
		// Retorna o tamanho da lista
		return produtos.size();
	}

	@Override
	public Object getSelectedItem() {
		// Retorna o item selecionado
		return this.produtoModel;
	}

	@Override
	public void setSelectedItem(Object cbComboBox) {
		if(cbComboBox instanceof ProdutoModel) {
			// Informa o item selecionado
			this.produtoModel = (ProdutoModel) cbComboBox;
			fireContentsChanged(this.produtos, 0, this.produtos.size());
		}
	}
	
}
