package br.com.loja.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.loja.dao.BaseDados;
import br.com.loja.dao.ControllerDaoProduto;
import br.com.loja.model.ProdutoModel;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {

	private BaseDados baseDados;

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtSenha;

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(27, 64, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtSenha = new JTextField();
		txtSenha.setBounds(27, 125, 86, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(142, 67, 46, 14);
		contentPane.add(lblUsuario);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(142, 128, 46, 14);
		contentPane.add(lblSenha);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (baseDados.usuario(txtUsuario, txtSenha)) {

					LojaView lojaView = new LojaView();

					lojaView.setVisible(true);

					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos!!!");
				}

			}
		});
		btnEntrar.setBounds(54, 182, 89, 23);
		contentPane.add(btnEntrar);
	}

}
