package br.com.loja.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.loja.controller.ProdutoController;
import br.com.loja.dao.ControllerDaoProduto;
import br.com.loja.model.ProdutoModel;
import br.com.loja.model.TableModelProduto;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class CadProdView extends JDialog {
	
	private List<ProdutoModel> produtoModel = new ArrayList<>();
	private ProdutoController produtoController;
	private ControllerDaoProduto ctlDao = new ControllerDaoProduto();
	
	private JFrame lojaView;

	private final JPanel contentPanel = new JPanel();
	

	/**
	 * Create the dialog.
	 */
	public CadProdView(JFrame lojaView) {
		
		this.lojaView = lojaView;
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lojaView.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(159, 99, 114, 25);
		contentPanel.add(btnVoltar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ctlDao.listar(produtoModel);
				produtoController.listar(produtoModel);
			}
		});
		btnListar.setBounds(169, 136, 114, 25);
		contentPanel.add(btnListar);
	}
}
